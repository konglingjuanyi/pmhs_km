						{
							text : '7、分娩记录打印',
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
										//查询
										var printpanel = Ext.extend(Ext.Panel, {
											closable : true,
											currentNode : null, // 当前选择的树节点
											layout : 'fit',
											border: false,
											//title: '第2至5次产前随访记录打印',
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											panelId : 'print_visitBeforeBornPanel',
											// height:700,
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findBirthChildRecords,

											// 设置查询用的类别，比如档案，高血压等。。
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
															{ "header" : "执行机构", "dataIndex" : "execOrgName"}, 
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 }, 
															 { "header" : "姓名", "dataIndex" : "name" }, 
															 { "header" : "性别", "dataIndex" : "sex" }, 
															 { "header" : "出生日期", "dataIndex" : "birthday", 
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') }, 
															 { "header" : "高危", "dataIndex" : "highRisk" }, 
															 { "header" : "分娩日期", "dataIndex" : "birthRecordDate" }, 
															 { "header" : "录入人", "dataIndex" : "username" }
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
											 * 查询数据, 如果树没有选择了节点，不执行
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
													emptyMsg : "没有记录"
												});
												var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
												this.gridCmConfig.unshift(sm);
												this.grid = new Ext.grid.GridPanel({
													//title : '请选择一个行政区划',
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
													// 缺省选择grid的第一条记录
													var model = this.grid.getSelectionModel();
													if (model.getCount() == 0) {
														model.selectFirstRow();
													}
												}.createDelegate(this));
												/*页选择*/
												var pagedata = [ 
													[1,"第一页"], 
													[2,"第二页"]
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
														{header:"页数",dataIndex:"name"}, 
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
														title : '第一步：选择要打印的记录',
														region : 'east',
														width : 640,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},{
														region : 'center',
														frame : false,
														title : '第二步：<br>选择页数',
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
															text:"打印",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择要打印的记录!');
																	return;
																}
																if(!this.pagegrid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择页数!');
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
															text:"退出",
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
											{width:720,height:500,title:"6、打印产前检查记录",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						}