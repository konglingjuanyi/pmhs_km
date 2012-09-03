						{
							text : '7�������¼��ӡ',
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
										//��ѯ
										var printpanel = Ext.extend(Ext.Panel, {
											closable : true,
											currentNode : null, // ��ǰѡ������ڵ�
											layout : 'fit',
											border: false,
											//title: '��2��5�β�ǰ��ü�¼��ӡ',
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											panelId : 'print_visitBeforeBornPanel',
											// height:700,
											// �Ƿ���Ҫ����ĩ���������ӣ�
											checkLastLevel : true,

											// ���ò�ѯurl
											queryUrl : UserMenuTreeService.findBirthChildRecords,

											// ���ò�ѯ�õ���𣬱��絵������Ѫѹ�ȡ���
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'birthRecord.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'sex', mapping: 'person.sex'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'birthRecord.criticalWoman'},
															{name:'birthRecordDate', mapping: 'birthRecord.birthRecordDate'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															{ "header" : "ִ�л���", "dataIndex" : "execOrgName"}, 
															 { "header" : "���", "dataIndex" : "fileNo", "width":130 }, 
															 { "header" : "����", "dataIndex" : "name" }, 
															 { "header" : "�Ա�", "dataIndex" : "sex" }, 
															 { "header" : "��������", "dataIndex" : "birthday", 
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') }, 
															 { "header" : "��Σ", "dataIndex" : "highRisk" }, 
															 { "header" : "��������", "dataIndex" : "birthRecordDate" }, 
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
													autoLoad: true,
													proxy : new Ext.ux.data.DWRProxy({
														dwrFunction : this.queryUrl,
														listeners : {
															'beforeload' : function(dataProxy, params) {
																params[dataProxy.loadArgsKey] = [ cond, params ];
															}
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
												var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
												this.gridCmConfig.unshift(sm);
												this.grid = new Ext.grid.GridPanel({
													//title : '��ѡ��һ����������',
													bbar : this.pagingBar,
													layout : 'fit',
													border : false,
													height:403,
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
												/*ҳѡ��*/
												var pagedata = [ 
													[1,"��һҳ"], 
													[2,"�ڶ�ҳ"]
													];
												var pagestore = new Ext.data.SimpleStore({ 
													fields:[ 
													{name:"id"}, 
													{name:"name"}
													] 
												}); 
												var pagesm = new Ext.grid.CheckboxSelectionModel({
														singleSelect:true});
												var pagecm = new Ext.grid.ColumnModel([ 
														pagesm, 
														{header:"ҳ��",dataIndex:"name"}, 
														]); 
												pagestore.loadData(pagedata);
												this.pagegrid = new Ext.grid.GridPanel({ 
													cm:pagecm, 
													height:430,
													width:80,
													sm:pagesm, 
													store:pagestore, 
													loadMask:true
													});
												var panel = new Ext.Panel({
													layout : 'table',
													autoScroll : false,
													layoutConfig: {
														columns: 3
													},
													
													border:false,
													items : [  {
														title : '��һ����ѡ��Ҫ��ӡ�ļ�¼',
														region : 'east',
														width : 640,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},{
														region : 'center',
														frame : false,
														title : '�ڶ�����<br>ѡ��ҳ��',
														split : false,
														collapsible : false,
													   
														width : 80,
														height:430,
														border : true,
														items : [ this.pagegrid ]
													},{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														layoutConfig: {
															columns: 3
														},
														height:8,
														border : false
													},{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														layoutConfig: {
															columns: 4
														},
														height:32,
														baseCls:"margin-top:10px",
														border : false,
														buttonAlign : "center", 
														items : [ 
														{
															border:false,
															width:300
														},{xtype:'button',
															iconCls: 'c_print',
															text:"��ӡ",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('��ʾ', '��ѡ��Ҫ��ӡ�ļ�¼!');
																	return;
																}
																if(!this.pagegrid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('��ʾ', '��ѡ��ҳ��!');
																	return;
																}
																var pagenum = this.pagegrid.getSelectionModel().getSelected().json[0];
																if(pagenum ==="1"){
																	printObj.printPreview(getPrintCfg08(this.grid.getSelectionModel().getSelected().json),-1);
																}else{
																	printObj.printPreview(getPrintCfg09(this.grid.getSelectionModel().getSelected().json),-1);
																}
															}.createDelegate(this)
														},
														{	border:false,width:20},
														{	xtype:'button',
															cls:"x-btn-text-icon",
															icon:"/resources/images/black/qtip/close.gif",
															text:"�˳�",
															scope :win,
															handler : function (){
																	win.close();
																}
														}
														//{border:false} 
														]
													} ]
												});
												
												return panel;
											}
										});
										var ppanel = new printpanel();
										var win = new Ext.Window(
											{width:720,height:500,title:"6����ӡ��ǰ����¼",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						}