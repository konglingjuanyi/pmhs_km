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


function setVisibleDetail(gridName,colsVisibleTrue,colsVisibleFalse){
	for(var i = 0;i< colsVisibleTrue.length;i++){
		Ext.getCmp(gridName).getColumnModel().setHidden(colsVisibleTrue[i], true);
	}
	for(var i = 0;i< colsVisibleFalse.length;i++){
		Ext.getCmp(gridName).getColumnModel().setHidden(colsVisibleFalse[i], false);
	}
}

function getColumnsIndexDetail(gridName,colName){
	return Ext.getCmp(gridName).getColumnModel().getIndexById(colName)
}


function getFlag(item,namearray,flag,count,grid1,record,cm,rowIndex){
	if (item.innerHTML.indexOf("plus1.gif")>0 && flag){
		var space = "";
		for(var i =0 ; i <count ;i++){
			space +="&nbsp;";
		}
		item.innerHTML = item.innerHTML.replace("plus1.gif","minus1.gif");
		var msg = "";
		for (var i =0 ; i <namearray.length;i++){
			var record1 = record.copy();
			record1.set(cm.getDataIndex(0),space+namearray[i]);
			//alert(i+" "+record.get(cm.getDataIndex(i)));
			for(var j = 2 ; j <cm.getColumnCount();j++){
				name = cm.getDataIndex(j);
				var endindex = i +1;
				var count = i +1;
				var start = 1;
				var content = parseInt(""+record.get(name));
				if(content > ((endindex+start) * count) /2 ){
					record1.set(name,endindex);
				}else{
					if(content > ((endindex-1+start) * (count-1)) /2 ){
						record1.set(name,content - ((endindex-1+start) * (count-1)) /2);
					}else{
						record1.set(name,0);
					}
				}
			}
			grid1.getStore().insert(rowIndex+1+i,record1);
		}
		//Ext.Msg.show({title:'提示',"msg":msg});
		
		//grid1.getStore().reload();
	}else{
		for (var i =0 ; i <namearray.length;i++){
			var record1 = grid1.getStore().getAt(rowIndex+1);
			grid1.getStore().remove(record1);
		}
		item.innerHTML = item.innerHTML.replace("minus1.gif","plus1.gif");
	}
}

Ext.tf.SummaryStatisticDetailPanel = Ext.extend(Ext.Panel,{
	closable : true,
	pageSize : 10,
	layout : 'fit',
	recordId : 'id',
	statisticType : null,
	idsArray : {},
	readerConfig : [ {
		name : 'orgName'
	}, {
		name : 'userName'
	}, {
		name : 'groupDate'
	}, {
		name : 'vhealthCount'
	}, {
		name : 'chealthCount'
	}, {
		name : 'babyHealthCount'
	}, {
		name : 'babyVisitCount'
	}, {
		name : 'children01count'
	}, {
		name : 'children02count'
	}, {
		name : 'children36count'
	}, {
		name : 'babyAllVisitCount'
	}, {
		name : 'maternalCount'
	}, {
		name : 'firstVistBeforeBornCount'
	}, {
		name : 'visitBeforeBornCount'
	}, {
		name : 'prenatalVisitCount'
	}, {
		name : 'visitAfterBornCount'
	}, {
		name : 'visitAfterBorn42count'
	}, {
		name : 'hypertensionHealthCount'
	}, {
		name : 'hypertensionVisitCount'
	}, {
		name : 'diabetesHealthCount'
	}, {
		name : 'diabetesVisitCount'
	}, {
		name : 'furiousHealthCount'
	}, {
		name : 'furiousVisitCount'
	}],
	gridCmConfig : [ {
		"header" : "组织机构",
		"dataIndex" : "orgName",
		"id" : "orgName",
		"renderer": function (value, metadata ,record,rowIndex ,colIndex ,store  ){
			//metadata.css ="";
			//metadata.attr='style="color:red;"';
			//if("总计" !== value && "&" !== value.substr(0,1))
			var a1  = "&nbsp;&nbsp;";
			var a2 = "&nbsp;&nbsp;&nbsp;&nbsp;";
			var a3 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			//alert("value=="+value)
			if("总计" !== value){
				if(a3 == value.substr(0,a3.length)){
					return a3+"&nbsp;&nbsp;&nbsp;&nbsp;"+value.substr(a3.length);
				}else if(a2 == value.substr(0,a2.length)){
					return a2+"<img src='/image/plus1.gif'>&nbsp;"+value.substr(a2.length);
				}else if(a1 == value.substr(0,a1.length)){
					return a1+"<img src='/image/plus1.gif'>&nbsp;"+value.substr(a1.length);
				}else if("&" !== value.substr(0,1)){
					return "<img src='/image/plus1.gif'>&nbsp;"+value;
				}
			}else{
				return value;
			}
		},
	}, {
		"header" : "操作员",
		"dataIndex" : "userName",
		"id" : "userName"
	}, {
		"header" : "日期",
		"dataIndex" : "groupDate",
		"id" : "groupDate"
	}, {
		"header" : "农业人口档案数",
		"dataIndex" : "vhealthCount",
		"id" : "vhealthCount"
	}, {
		"header" : "城镇人口档案数",
		"dataIndex" : "chealthCount",
		"id" : "chealthCount"
	}, {
		"header" : "儿童档案数",
		"dataIndex" : "babyHealthCount",
		"id" : "babyHealthCount",
		"hidden" : true
	}, {
		"header" : "新生儿家庭访视",
		"dataIndex" : "babyVisitCount",
		"id" : "babyVisitCount"
	}, {
		"header" : "1岁以内儿童体检",
		"dataIndex" : "children01count",
		"id" : "children01count"
	}, {
		"header" : "1~2岁儿童体检",
		"dataIndex" : "children02count",
		"id" : "children02count"
	}, {
		"header" : "3~6岁儿童体检",
		"dataIndex" : "children36count",
		"id" : "children36count"
	}, {
		"header" : "儿童体检总和",
		"dataIndex" : "babyAllVisitCount",
		"id" : "babyAllVisitCount"
	}, {
		"header" : "孕产妇档案数",
		"dataIndex" : "maternalCount",
		"id" : "maternalCount",
		"hidden" : true
	}, {
		"header" : "第1次产前随访",
		"dataIndex" : "firstVistBeforeBornCount",
		"id" : "firstVistBeforeBornCount"
	}, {
		"header" : "第2~5次产前随访",
		"dataIndex" : "visitBeforeBornCount",
		"id" : "visitBeforeBornCount"
	}, {
		"header" : "产前随访总和",
		"dataIndex" : "prenatalVisitCount",
		"id" : "prenatalVisitCount"
	}, {
		"header" : "产后访视",
		"dataIndex" : "visitAfterBornCount",
		"id" : "visitAfterBornCount"
	}, {
		"header" : "产后42天体检",
		"dataIndex" : "visitAfterBorn42count",
		"id" : "visitAfterBorn42count"
	}, {
		"header" : "高血压档案数",
		"dataIndex" : "hypertensionHealthCount",
		"id" : "hypertensionHealthCount",
		"hidden" : true
	}, {
		"header" : "高血压随访",
		"dataIndex" : "hypertensionVisitCount",
		"id" : "hypertensionVisitCount"
	}, {
		"header" : "糖尿病档案数",
		"dataIndex" : "diabetesHealthCount",
		"id" : "diabetesHealthCount",
		"hidden" : true
	}, {
		"header" : "糖尿病随访",
		"dataIndex" : "diabetesVisitCount",
		"id" : "diabetesVisitCount"
	}, {
		"header" : "重性精神病档案数",
		"dataIndex" : "furiousHealthCount",
		"id" : "furiousHealthCount",
		"hidden" : true
	}, {
		"header" : "重性精神病随访",
		"dataIndex" : "furiousVisitCount",
		"id" : "furiousVisitCount"
	}],
	queryUrl : Ext.emptyFn,
	
	initComponent: function(){
		this.build();
		Ext.tf.SummaryStatisticDetailPanel.superclass.initComponent.call(this);
	},
	
	build : function(){
		this.items = [ this.createPanel() ];
	},
	
	getParams : function(){
		var startDate = Ext.getCmp(this.idsArray.startDate).getValue();
		var endDate = Ext.getCmp(this.idsArray.endDate).getValue();		
		var healthfile = Ext.getCmp(this.idsArray.healthfile).getValue();
		var children = Ext.getCmp(this.idsArray.children).getValue();
		var maternal = Ext.getCmp(this.idsArray.maternal).getValue();
		var chronicDisease = Ext.getCmp(this.idsArray.chronicDisease).getValue();
		var statisticResult = (healthfile ? '1' : '0') + (children ? '1' : '0') +
			(maternal ? '1' : '0') + (chronicDisease ? '1' : '0') + '00';
		var isQryWipeOut = Ext.getCmp(this.idsArray.isQryWipeOut).getValue();
		isQryWipeOut = isQryWipeOut ? '1' : '0';
		var condition = {
			startDate : startDate,
			endDate : endDate,
			statisticType : this.statisticType,
			statisticResult : statisticResult,
			isQryWipeOut : isQryWipeOut
		};
		return condition;
	},
	
	load : function(isReset){		
		var healthfile = Ext.getCmp(this.idsArray.healthfile).getValue();
		var children = Ext.getCmp(this.idsArray.children).getValue();
		var maternal = Ext.getCmp(this.idsArray.maternal).getValue();
		var chronicDisease = Ext.getCmp(this.idsArray.chronicDisease).getValue();
		
		if(healthfile || children || maternal || chronicDisease){
			Ext.getCmp(this.idsArray.grid).getStore().reload();
			
			var colsVisibleFalse = [];
			var colsVisibleTrue = [];
			var tmpStatisticType = this.statisticType + '';
//			console.log(tmpStatisticType);
			var org = tmpStatisticType.substring(0,1);
			var inputPerson = this.statisticType.substring(1,2);
			var date = this.statisticType.substring(2,3);
//			console.log(org + '-' + inputPerson + '-' + date);
			if(org == '1' || inputPerson == '1')
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'orgName'));
			else
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'orgName'));
			
			if(inputPerson == '1')
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'userName'));
			else
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'userName'));
			
			
			if(date == '1' || date == '2' || date == '3')
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'groupDate'));
			else
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'groupDate'));
			
			if(healthfile){
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'vhealthCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'chealthCount'));
//				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'babyHealthCount'));
//				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'maternalCount'));
//				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionHealthCount'));
//				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesHealthCount'));
//				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'furiousHealthCount'));
			}else{
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'vhealthCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'chealthCount'));
//				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'babyHealthCount'));
//				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'maternalCount'));
//				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionHealthCount'));
//				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesHealthCount'));
//				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'furiousHealthCount'));
			}
			
			if(children){
//				if(!healthfile)
//					colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'babyHealthCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'babyVisitCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'children01count'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'children02count'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'children36count'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'babyAllVisitCount'));
			}else{
//				if(!healthfile)
//					colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'babyHealthCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'babyVisitCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'children01count'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'children02count'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'children36count'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'babyAllVisitCount'));
			}
			
			if(maternal){
//				if(!healthfile)
//					colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'maternalCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'firstVistBeforeBornCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'visitBeforeBornCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'prenatalVisitCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'visitAfterBornCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'visitAfterBorn42count'));
			}else{
//				if(!healthfile)
//					colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'maternalCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'firstVistBeforeBornCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'visitBeforeBornCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'prenatalVisitCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'visitAfterBornCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'visitAfterBorn42count'));
			}
			
			if(chronicDisease){
//				if(!healthfile){
//					colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionHealthCount'));
//					colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesHealthCount'));
//					colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'furiousHealthCount'));
//				}
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionVisitCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesVisitCount'));
				colsVisibleFalse.push(getColumnsIndexDetail(this.idsArray.grid,'furiousVisitCount'));
			}else{
//				if(!healthfile){
//					colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionHealthCount'));
//					colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesHealthCount'));
//					colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'furiousHealthCount'));
//				}
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'hypertensionVisitCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'diabetesVisitCount'));
				colsVisibleTrue.push(getColumnsIndexDetail(this.idsArray.grid,'furiousVisitCount'));
			}
			
			setVisibleDetail(this.idsArray.grid,colsVisibleTrue,colsVisibleFalse);
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
						params[dataProxy.loadArgsKey] = [o,params];
					}.createDelegate(this)
				}
			}),
			reader : reader
		});
		
		var grid = new Ext.grid.GridPanel({
			id : this.idsArray.grid,
			layout : 'fit',
			region : 'center',
			autoScroll : true,
			store: store,
			cm : new Ext.grid.ColumnModel(this.gridCmConfig),
			loadMask : true
		});
		grid.on("cellclick",function(grid1, rowIndex, columnIndex, e) {
				var record = grid1.getStore().getAt(rowIndex);  // Get the Record
				var cm =grid1.getColumnModel();
				var fieldName = cm.getDataIndex(columnIndex); // Get field name
				var data = record.get(fieldName);
				var item = grid1.getView().getCell(rowIndex,columnIndex);
				var names=new Array("盘龙区","五华区","官渡区","西山区","经开区");
				var name1 = new Array("华山街道办事处","护国街道办事处","大观街道办事处","龙翔街道办事处");
				var name2 = new Array("洪化桥社区居委会","水晶宫社区居委会","华山西路社区居委会","翠湖南路社区居委会","文林社区居委会");
//				alert("aaaaaaaaaaaa")
				var mm = String.fromCharCode(160);
//				alert("mm=="+mm)
				var a1 = mm;
				var a2 = mm+mm+mm;
				var a3 = mm+mm+mm+mm+mm;
				var value = item.textContent;
				if (a3 === value.substr(0,a3.length)){
					getFlag(item,name2,true,6,grid1,record,cm,rowIndex);
				}else if (a2 === value.substr(0,a2.length)){
					getFlag(item,name1,true,4,grid1,record,cm,rowIndex);
				}else if(a1 == value.substr(0,a1.length)){
					getFlag(item,names,true,2,grid1,record,cm,rowIndex);
				}
				
			}
			//Ext.Msg.show({			title:'提示',
			//	msg: grid1.getView()+" "+rowIndex+" "+columnIndex});
			//grid1.getGridEl().getCell(rowIndex,columnIndex);	
			//Ext.Msg.show({			title:'提示1',
			//	msg: grid1.getView().getCell(rowIndex,columnIndex).innerHTML});
			//grid1.getGridEl().getCell(rowIndex,columnIndex);	
			//}
		);
		
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
				id : this.idsArray.isQryWipeOut,
				name : this.idsArray.isQryWipeOut
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
					printDataExportObj.printGrid(grid,printDataExportObj.initDateRange(this.idsArray.startDate,this.idsArray.endDate));
				}.createDelegate(this)				
			},exportButton],
			items : [{
				xtype : 'panel',
				layout : 'absolute',
				frame : true,
				items : [createFieldset('dateRange','dateRange',5,0,'统计查询日期范围',
						 [createLabel('dateText','dateText',0,3,'起:'),
						  createDatefield(this.idsArray.startDate,this.idsArray.startDate,20,0,'Y-m-d',120,new Date()),
						  createLabel('dateTextSeparator','dateTextSeparator',0,43,'止:'),
						  createDatefield(this.idsArray.endDate,this.idsArray.endDate,20,40,'Y-m-d',120,new Date())],140),
				 createFieldset('statisticResult','statisticResult',180,0,'统计数据显示',
						 [createCheckBox('居民健康档案',true,this.idsArray.healthfile,this.idsArray.healthfile,0,0,1,null),
						  createCheckBox('儿童业务数据',false,this.idsArray.children,this.idsArray.children,100,0,2,null),
						  createCheckBox('孕产妇业务数据',false,this.idsArray.maternal,this.idsArray.maternal,0,25,3,null),
						  createCheckBox('慢性病业务数据',false,this.idsArray.chronicDisease,this.idsArray.chronicDisease,0,50,4,null)],200)]
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
