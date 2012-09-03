// /////////////
// ��������ģ��
// /////////////


var printpanel = Ext.extend(Ext.Panel, {
	closable : true,
	currentNode : null, // ��ǰѡ������ڵ�
	layout : 'fit',
	title: '��2��5�β�ǰ��ü�¼',
	pageSize : 20,
	recordId : 'visit.id',
	recordPk : 'id',
	panelId : 'print_visitBeforeBornPanel',
	// height:700,
	// �Ƿ���Ҫ����ĩ���������ӣ�
	checkLastLevel : true,

	// ���ò�ѯurl
	queryUrl : UserMenuTreeService.findVisitBeforeBornRecords,

	// ���ò�ѯ�õ���𣬱��絵������Ѫѹ�ȡ���
	queryType : 'demo',
	readerConfig : [
                    {name:'execOrgName', mapping: 'org.name'},
                    {name:'id', mapping: 'visit.id'},
                    {name:'fileNo', mapping: 'file.fileNo'},
                    {name:'name', mapping: 'file.name'},
                    {name:'birthday', mapping: 'person.birthday'},
                    {name:'highRisk', mapping: 'visit.highRisk'},
                    {name:'weeks', mapping: 'visit.weeks'},
                    {name:'item', mapping: 'visit.item'},
                    {name:'visitDate', mapping: 'visit.visitDate'},
                    {name:'nextVisitDate', mapping: 'visit.nextVisitDate'},
                    {name:'visitDoctor', mapping: 'visit.visitDoctor'},
                    {name:'username', mapping: 'samTaxempcode.username'}
                   ],
	gridCmConfig :
                   [
                    { "header" : "ִ�л���", "dataIndex" : "execOrgName"}, 
                     { "header" : "���", "dataIndex" : "fileNo", "width":130 },
                     { "header" : "����", "dataIndex" : "name" },
                     { "header" : "��Ŀ", "dataIndex" : "item","renderer" : function(val){
                    	 return "��" + val + "��";
                     }},
                     { "header" : "��������", "dataIndex" : "birthday",
                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                                         { "header" : "��Σ", "dataIndex" : "highRisk" },   
                     { "header" : "����", "dataIndex" : "weeks" },
                     { "header" : "�������", "dataIndex" : "visitDate",
                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                     { "header" : "�´��������", "dataIndex" : "nextVisitDate",
                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                     { "header" : "���ҽ��", "dataIndex" : "visitDoctor" },
                     { "header" : "¼����", "dataIndex" : "username" }
                   ],
	gridViewConfig : {},
	initComponent : function() {
		this.build();
		Ext.tf.HealthPanel.superclass.initComponent.call(this);
	},

	build : function() {
//		this.tbar = this.createActions();
		this.items = [ this.createPanel() ];
	},
	/*
	 * ��ѯ����, �����û��ѡ���˽ڵ㣬��ִ��
	 */
	load : function(isReset) {
		this.grid.getStore().reload();
		this.doLayout(true);
	},

	createPanel : function() {
		var reader = new Ext.data.JsonReader({
			totalProperty : "totalSize",
			root : "data",
			id : this.recordId
		}, Ext.data.Record.create(this.readerConfig));

		var store = new Ext.data.Store({
			proxy : new Ext.ux.data.DWRProxy({
				dwrFunction : this.queryUrl,
				listeners : {
					'beforeload' : function(dataProxy, params) {
						var o = this.getParams();
						console.log("getParams: ")
						console.log(o);
						if (!params.limit)
							params.limit = this.pageSize;
						params[dataProxy.loadArgsKey] = [ o, params ];
					}.createDelegate(this)
				}
			}),
			reader : reader
		});

		this.pagingBar = new App.PagingToolbar({
			pageSize : this.pageSize,
			store : store,
			displayInfo : true,
			displayMsg : '{0} - {1} of {2}',
			emptyMsg : "û�м�¼"
		});
		var sm = new Ext.grid.CheckboxSelectionModel();
		this.gridCmConfig.unshift(sm);
		this.grid = new Ext.grid.GridPanel({
			title : '��ѡ��һ����������',
			bbar : this.pagingBar,
			layout : 'fit',
			store : store,
			cm : new Ext.grid.ColumnModel(this.gridCmConfig),
			viewConfig : this.gridViewConfig,
			sm : sm
		});
		this.grid.getView().on('refresh', function() {
			// ȱʡѡ��grid�ĵ�һ����¼
			var model = this.grid.getSelectionModel();
			if (model.getCount() == 0) {
				model.selectFirstRow();
			}
		}.createDelegate(this));

		var panel = new Ext.Panel({
			layout : 'border',
			autoScroll : true,
			id : this.panelId,
			bbar: {[
				new Ext.Button({
					text: '��ӡ',
					iconCls: 'c_print',
					menu: new Ext.menu.Menu({
						items: [{
							text : '��ӡ',
							iconCls: 'c_print',
							handler : function(){
								var selections = this.grid.getSelections();
								if(selections.length > 0){
									var records = selections[0];
									var fileNo = records.get(this.recordPk);
									var param = '?' + this.recordPk + '=' + fileNo;
									var filterKey = "a."+this.recordPk;
									var filterValue = fileNo;
									var selNode = this.getTreeSelNode();
									if (selNode) {
										var cond = {
											district : selNode.id,
											filterKey : filterKey,
											filterValue : filterValue,
											isFirst : 1
										};
										console.log(cond);
										UserMenuTreeService.findFirstVisitRecords(cond,function(data){
											if(data){
												printObj.printPreview(getPrintCfg01(data.data[0],this.menu),-1);
											}else{
												showError('�û�û�е�һ�β�ǰ�����¼,�޷���ӡ��');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},
                        {
							text : '�˳�',
							iconCls: 'c_print',
							handler : function(){
								var selections = this.grid.getSelections();
								if(selections.length > 0){
									var records = selections[0];
									var fileNo = records.get(this.recordPk);
									var param = '?' + this.recordPk + '=' + fileNo;
									var filterKey = "a."+this.recordPk;
									var filterValue = fileNo;
									var selNode = this.getTreeSelNode();
									if (selNode) {
										var cond = {
											district : selNode.id,
											filterKey : filterKey,
											filterValue : filterValue,
											isFirst : 1
										};
										console.log(cond);
										UserMenuTreeService.findFirstVisitRecords(cond,function(data){
											if(data){
												printObj.printPreview(getPrintCfg01(data.data[0],this.menu),-1);
											}else{
												showError('�û�û�е�һ�β�ǰ�����¼,�޷���ӡ��');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						}]
                        })
                      })
                    ]
                },
			items : [  {
                title : '��һ����ѡ���¼',
				region : 'east',
				layout : 'fit',
				frame : false,
				border : false,
				items : [ this.grid ]
			},{
				region : 'center',
				layout : 'fit',
				frame : false,
				title : '�ڶ�����ѡ��ҳ��',
				split : false,
				collapsible : true,
				layoutConfig : {
					animate : true
				},
				width : 200,
				minSize : 100,
				maxSize : 400,
				border : false,
				items : [  ]
			},{
				region : 'west',
				layout : 'fit',
				frame : false,
				title : '��������ѡ������',
				split : false,
				collapsible : true,
				layoutConfig : {
					animate : true
				},
				width : 200,
				minSize : 100,
				maxSize : 400,
				border : false,
				items : [  ]
			} ]
		});
		return panel;
	}
});

var win = Ext.Window({width:500,height:400,title:"6����ӡ��ǰ����¼",items[printpanel]});
win.show();

