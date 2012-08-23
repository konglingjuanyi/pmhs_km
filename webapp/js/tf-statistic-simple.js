Ext.ns('Ext.tf')

function createCheckBox(boxLabel,checked,id,name,x,y,val,clicks){
	return new Ext.form.Checkbox({
		boxLabel : boxLabel,
		checked : checked,
		id : id,
		name : name,
		x : x,
		y : y,
		value : val,
		listeners : {
			'check' : {
				fn : clicks
			}
		} 
	});
}

function createLabel(id,name,x,y,text){
	return new Ext.form.Label({
		id : id,
		name : name,
		x : x,
		y : y,
		text : text
	});
}

function createDatefield(id,name,x,y,format,width,val){
	return new Ext.form.DateField({
		id : id,
		name : name,
		x : x,
		y : y,
		format : format,
		width : width,
		value : val
	});
}

function createFieldset(id,name,x,y,title,items,width){
	var panel = new Ext.Panel({
		layout : 'absolute',
		items : items,
		height : 70
	});
	return new Ext.form.FieldSet({
		autoHeight:true,
		defaults: {width: width},
		id : id,
		name : name,
		x : x,
		y : y,
		title : title,
		items : panel
	});
}   


function setVisible(colsVisibleTrue,colsVisibleFalse){
	for(var i = 0;i< colsVisibleTrue.length;i++){
		Ext.getCmp("mygrid").getColumnModel().setHidden(colsVisibleTrue[i], true);
	}
	for(var i = 0;i< colsVisibleFalse.length;i++){
		Ext.getCmp("mygrid").getColumnModel().setHidden(colsVisibleFalse[i], false);
	}
}

function getColumnsIndex(colName){
	return Ext.getCmp("mygrid").getColumnModel().getIndexById(colName)
}

Ext.tf.SummaryStatisticPanel = Ext.extend(Ext.Panel,{
	closable : true,
	pageSize : 10,
	layout : 'fit',
	recordId : 'id',
	
	readerConfig : [],
	gridCmConfig : [],
	queryUrl : Ext.emptyFn,
	
	initComponent: function(){
		this.build();
		Ext.tf.SummaryStatisticPanel.superclass.initComponent.call(this);
	},
	
	build : function(){
		this.items = [ this.createPanel() ];
	},
	
	getParams : function(){
		var startDate = Ext.getCmp('startDate').getValue();
		var endDate = Ext.getCmp('endDate').getValue();
		var org = Ext.getCmp('statisticByOrg').getValue();
		var inputPerson =  Ext.getCmp('statisticByInputPerson').getValue();
		var year = Ext.getCmp('statisticByYear').getValue();
		var month = Ext.getCmp('statisticByMonth').getValue();
		var day = Ext.getCmp('statisticByDay').getValue();
		
		var statisticType = (org ? '1' : '0') + (inputPerson ? '1' : '0') + 
			(year ? '1' : (month ? '2' : (day ? '3' : '0')));
		
		var healthfile = Ext.getCmp('healthfile').getValue();
		var children = Ext.getCmp('children').getValue();
		var maternal = Ext.getCmp('maternal').getValue();
		var chronicDisease = Ext.getCmp('chronicDisease').getValue();
		
		var statisticResult = (healthfile ? '1' : '0') + (children ? '1' : '0') +
			(maternal ? '1' : '0') + (chronicDisease ? '1' : '0') + '00';
		
		var isQryWipeOut = Ext.getCmp('isQryWipeOut').getValue();
		isQryWipeOut = isQryWipeOut ? '1' : '0';
		var condition = {
			startDate : startDate,
			endDate : endDate,
			statisticType : statisticType,
			statisticResult : statisticResult,
			isQryWipeOut : isQryWipeOut
		};
		return condition;
	},
	
	dataExport : function(){
		if (Ext.getCmp("mygrid").getStore().getCount() == 0) {
            alert("目前没有数据!");
            return;
        }
        var vExportContent = Ext.getCmp("mygrid").getExcelXml();
        if (Ext.isIE6 || Ext.isIE7 || Ext.isIE8 || Ext.isSafari || Ext.isSafari2 || Ext.isSafari3) {
            var fd = Ext.get('frmDummy');
            if (!fd) {
                fd = Ext.DomHelper.append(Ext.getBody(), { tag: 'form', method: 'post', id: 'frmDummy', action: 'exportexcel.jsp', target: '_blank', name: 'frmDummy', cls: 'x-hidden', cn: [
                    { tag: 'input', name: 'exportContent', id: 'exportContent', type: 'hidden' },
                    { tag: 'input', name: 'fileName', id: 'fileName', type: 'hidden' },
                ]
                }, true);
            }
            fd.child('#exportContent').set({ value: vExportContent });
            fd.child('#fileName').set({ value: new Date().format("YmdHms") });
            fd.dom.submit();
        } else {
            window.location.href = 'data:application/vnd.ms-excel;base64,' + Base64.encode(vExportContent);
        }
	},
	
	load : function(isReset){
		var org = Ext.getCmp('statisticByOrg').getValue();
		var inputPerson =  Ext.getCmp('statisticByInputPerson').getValue();
		var year = Ext.getCmp('statisticByYear').getValue();
		var month = Ext.getCmp('statisticByMonth').getValue();
		var day = Ext.getCmp('statisticByDay').getValue();
		
		var healthfile = Ext.getCmp('healthfile').getValue();
		var children = Ext.getCmp('children').getValue();
		var maternal = Ext.getCmp('maternal').getValue();
		var chronicDisease = Ext.getCmp('chronicDisease').getValue();
		
		if((org || inputPerson || year || month || day) && (healthfile || children || maternal || chronicDisease)){
			if (isReset) {
				this.pagingBar.changePage(1);
			}
			var colsVisibleFalse = [];
			var colsVisibleTrue = [];
			
			if(org || inputPerson )
				colsVisibleFalse.push(getColumnsIndex('orgName'));
			else
				colsVisibleTrue.push(getColumnsIndex('orgName'));
			
			if(inputPerson)
				colsVisibleFalse.push(getColumnsIndex('userName'));
			else
				colsVisibleTrue.push(getColumnsIndex('userName'));
			
			
			if(year || month || day)
				colsVisibleFalse.push(getColumnsIndex('groupDate'));
			else
				colsVisibleTrue.push(getColumnsIndex('groupDate'));
			
			if(healthfile){
				colsVisibleFalse.push(getColumnsIndex('vhealthCount'));
				colsVisibleFalse.push(getColumnsIndex('chealthCount'));
//				colsVisibleFalse.push(getColumnsIndex('babyHealthCount'));
//				colsVisibleFalse.push(getColumnsIndex('maternalCount'));
//				colsVisibleFalse.push(getColumnsIndex('hypertensionHealthCount'));
//				colsVisibleFalse.push(getColumnsIndex('diabetesHealthCount'));
//				colsVisibleFalse.push(getColumnsIndex('furiousHealthCount'));
			}else{
				colsVisibleTrue.push(getColumnsIndex('vhealthCount'));
				colsVisibleTrue.push(getColumnsIndex('chealthCount'));
//				colsVisibleTrue.push(getColumnsIndex('babyHealthCount'));
//				colsVisibleTrue.push(getColumnsIndex('maternalCount'));
//				colsVisibleTrue.push(getColumnsIndex('hypertensionHealthCount'));
//				colsVisibleTrue.push(getColumnsIndex('diabetesHealthCount'));
//				colsVisibleTrue.push(getColumnsIndex('furiousHealthCount'));
			}
			
			if(children){
//				if(!healthfile)
//					colsVisibleFalse.push(getColumnsIndex('babyHealthCount'));
				colsVisibleFalse.push(getColumnsIndex('babyVisitCount'));
				colsVisibleFalse.push(getColumnsIndex('children01count'));
				colsVisibleFalse.push(getColumnsIndex('children02count'));
				colsVisibleFalse.push(getColumnsIndex('children36count'));
				colsVisibleFalse.push(getColumnsIndex('babyAllVisitCount'));
			}else{
//				if(!healthfile)
//					colsVisibleTrue.push(getColumnsIndex('babyHealthCount'));
				colsVisibleTrue.push(getColumnsIndex('babyVisitCount'));
				colsVisibleTrue.push(getColumnsIndex('children01count'));
				colsVisibleTrue.push(getColumnsIndex('children02count'));
				colsVisibleTrue.push(getColumnsIndex('children36count'));
				colsVisibleTrue.push(getColumnsIndex('babyAllVisitCount'));
			}
			
			if(maternal){
//				if(!healthfile)
//					colsVisibleFalse.push(getColumnsIndex('maternalCount'));
				colsVisibleFalse.push(getColumnsIndex('firstVistBeforeBornCount'));
				colsVisibleFalse.push(getColumnsIndex('visitBeforeBornCount'));
				colsVisibleFalse.push(getColumnsIndex('prenatalVisitCount'));
				colsVisibleFalse.push(getColumnsIndex('visitAfterBornCount'));
				colsVisibleFalse.push(getColumnsIndex('visitAfterBorn42count'));
			}else{
//				if(!healthfile)
//					colsVisibleTrue.push(getColumnsIndex('maternalCount'));
				colsVisibleTrue.push(getColumnsIndex('firstVistBeforeBornCount'));
				colsVisibleTrue.push(getColumnsIndex('visitBeforeBornCount'));
				colsVisibleTrue.push(getColumnsIndex('prenatalVisitCount'));
				colsVisibleTrue.push(getColumnsIndex('visitAfterBornCount'));
				colsVisibleTrue.push(getColumnsIndex('visitAfterBorn42count'));
			}
			
			if(chronicDisease){
//				if(!healthfile){
//					colsVisibleFalse.push(getColumnsIndex('hypertensionHealthCount'));
//					colsVisibleFalse.push(getColumnsIndex('diabetesHealthCount'));
//					colsVisibleFalse.push(getColumnsIndex('furiousHealthCount'));
//				}
				colsVisibleFalse.push(getColumnsIndex('hypertensionVisitCount'));
				colsVisibleFalse.push(getColumnsIndex('diabetesVisitCount'));
				colsVisibleFalse.push(getColumnsIndex('furiousVisitCount'));
			}else{
//				if(!healthfile){
//					colsVisibleTrue.push(getColumnsIndex('hypertensionHealthCount'));
//					colsVisibleTrue.push(getColumnsIndex('diabetesHealthCount'));
//					colsVisibleTrue.push(getColumnsIndex('furiousHealthCount'));
//				}
				colsVisibleTrue.push(getColumnsIndex('hypertensionVisitCount'));
				colsVisibleTrue.push(getColumnsIndex('diabetesVisitCount'));
				colsVisibleTrue.push(getColumnsIndex('furiousVisitCount'));
			}
			
			setVisible(colsVisibleTrue,colsVisibleFalse);
		}else{
			showInfoObj.Error('请选择条件!');
		}
	},
	
	createPanel : function(){
		var reader = new Ext.data.JsonReader({
			totalProperty : 'totalSize',
			root : 'data',
			id : this.recordId
		},Ext.data.Record.create(this.readerConfig));
		
		var store = new Ext.data.Store({
			proxy : new Ext.ux.data.DWRProxy({
				dwrFunction : this.queryUrl,
				listeners : {
					'beforeload' : function(dataProxy, params){
						var o = this.getParams();
//						if(!params.limit)
//							params.limit = this.pageSize;
						params[dataProxy.loadArgsKey] = [o,params];
					}.createDelegate(this)
				}
			}),
			reader : reader
		});
		
		this.pagingBar = new Ext.PagingToolbar({
			pageSize : this.pageSize,
			displayMsg : '{0}-{1} of {2}',
			displayInfo : true,
			emptyMsg : '没有记录',
			store : store
		});
		
		var grid = new Ext.grid.GridPanel({
			id : 'mygrid',
			layout : 'fit',
			region : 'center',
//			bbar : this.pagingBar,
			autoScroll : true,
			store: store,
			cm : new Ext.grid.ColumnModel(this.gridCmConfig),
			loadMask : true
		});
		

		
		var exportButton = new Ext.ux.Exporter.Button({
			component : grid,
			text : "数据导出",
			iconCls : 'dataExportbg'
		});
		var topPanel = new Ext.Panel({
			layout : 'fit',
			region : 'north',
			height : 150,
			tbar : [{
				xtype : 'checkbox',
				boxLabel : '报销统计数据',
				id : 'isQryWipeOut',
				name : 'isQryWipeOut'
			},{
				text : '查询',
				iconCls : 'searchbg',
				handler : function(){
					this.load(true);
				}.createDelegate(this)
			},{
				text : '打印',
				iconCls : 'printbg',
				handler : function(){
					printDataExportObj.printGrid(grid,printDataExportObj.initDateRange('startDate','endDate'));
				}.createDelegate(this)				
			},exportButton],
			items : [{
				xtype : 'panel',
				layout : 'absolute',
				frame : true,
				items : [createFieldset('dateRange','dateRange',5,0,'统计查询日期范围',
						 [createLabel('dateText','dateText',0,3,'起:'),
						  createDatefield('startDate','startDate',20,0,'Y-m-d',120,new Date()),
						  createLabel('dateTextSeparator','dateTextSeparator',0,43,'止:'),
						  createDatefield('endDate','endDate',20,40,'Y-m-d',120,new Date())],140),
			     createFieldset('statisticType','statisticType',175,0,'统计分类',
						 [createCheckBox('组织机构',true,'statisticByOrg','statisticByOrg',0,0,1,null),
						  createCheckBox('操作员',false,'statisticByInputPerson','statisticByInputPerson',0,25,2,null),
						  createCheckBox('年',false,'statisticByYear','statisticByYear',0,50,3,function(obj,ischecked){
							  if(ischecked){
								  Ext.getCmp('statisticByMonth').setValue(false);
								  Ext.getCmp('statisticByDay').setValue(false);
							  }
						  }),
						  createCheckBox('月',false,'statisticByMonth','statisticByMonth',40,50,4,function(obj,ischecked){
							  if(ischecked){
								  Ext.getCmp('statisticByYear').setValue(false);
								  Ext.getCmp('statisticByDay').setValue(false);
							  }
						  }),
						  createCheckBox('日',false,'statisticByDay','statisticByDay',80,50,5,function(obj,ischecked){
							  if(ischecked){
								  Ext.getCmp('statisticByMonth').setValue(false);
								  Ext.getCmp('statisticByYear').setValue(false);
							  }
						  })],120),
				 createFieldset('statisticResult','statisticResult',325,0,'统计数据显示',
						 [createCheckBox('居民健康档案',true,'healthfile','healthfile',0,0,1,null),
						  createCheckBox('儿童业务数据',false,'children','children',100,0,2,null),
						  createCheckBox('孕产妇业务数据',false,'maternal','maternal',0,25,3,null),
						  createCheckBox('慢性病业务数据',false,'chronicDisease','chronicDisease',0,50,4,null)],200)]
			}]
		});
		
		var panel = new Ext.Panel({
			autoScroll : true,
			layout : 'border',
			items : [topPanel,grid]
		});

		return panel;
	}
});