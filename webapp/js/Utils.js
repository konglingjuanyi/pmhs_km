Utils = function() {
	// URL解析
};
Utils.prototype.openwindow = function(targetUrl,param,gridId,titles) {
	var win = new Ext.Window({
		modal : true,
		title : titles,
		border : false
	});
	if (param != null) {
		window.other_init_param = param;
	}
	win.show();
	win.maximize();

	win.add({
		xtype : 'iframepanel',
		defaultSrc : targetUrl,
		title : '',
		loadMask : true,
		autoScroll : false,
		listeners : {
			message : function(f, data) {
				if (data.data == 'quit') {
					win.close();
				} else if (data.data == 'saved') {
					//...
				}
				Ext.getCmp(gridId).getStore().reload();
			}.createDelegate(this)
		}
	});
	win.doLayout(true);
}

var Utils = new Utils();