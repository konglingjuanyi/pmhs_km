Ext.ns("app");

app.modMgrPanel = new Ext.tf.SimplePanel({
	title : '模块目录管理',
	pageSize : 10,
	queryUrl : ModuleService.findModuleCategory.createDelegate(this),
	editUrl : ModuleService.editModuleCategory.createDelegate(this),
	deleteUrl : ModuleService.removeModuleCategory.createDelegate(this),

	queryConfig : [ {
		fieldLabel : '名称',
		name : 'name',
		allowBlank : true
	} ],

	editConfig : [ {
		fieldLabel : 'ID',
		name : 'id',
		xtype : 'hidden'
	}, {
		fieldLabel : '模块目录名称',
		name : 'name'
	}, {
		fieldLabel : '排列顺序',
		name : 'displayOrder',
		xtype : 'numberfield'
	}, {
		fieldLabel : 'clsSetting',
		name : 'cls',
		xtype : 'hidden'
	} ],

	readerConfig : [ {
		name : 'id',
		mapping : 'id'
	}, {
		name : 'name',
		mapping : 'name'
	}, {
		name : 'displayOrder',
		mapping : 'displayOrder'
	} ],

	gridCm : [ {
		"hidden" : true,
		"header" : "ID",
		"sortable" : true,
		"dataIndex" : "id"
	}, {
		"header" : "模块目录名称",
		"sortable" : true,
		"dataIndex" : "name"
	}, {
		"header" : "排列顺序",
		"sortable" : true,
		"dataIndex" : "displayOrder"
	} ]
});
ModuleMgr.register(app.modMgrPanel);
//_tab = ModuleMgr.register(app.modMgrPanel);
//app.modMgrPanel.load();
