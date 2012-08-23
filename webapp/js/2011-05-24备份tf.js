tfMoney = function(v, sign) {
	if (!sign)
		sign = '';
	v = (Math.round((v - 0) * 100)) / 100;
	v = (v == Math.floor(v)) ? v + ".00" : ((v * 10 == Math.floor(v * 10)) ? v
			+ "0" : v);
	v = String(v);
	var ps = v.split('.');
	var whole = ps[0];
	var sub = ps[1] ? '.' + ps[1] : '.00';
	var r = /(\d+)(\d{3})/;
	while (r.test(whole)) {
		whole = whole.replace(r, '$1' + ',' + '$2');
	}
	v = whole + sub;
	if (v.charAt(0) == '-') {
		return '-' + sign + v.substr(1);
	}
	return sign + v;
}
//保存数据
function savedate(ref,index ,selected_data,name){
	ref.getComponent(0).getComponent(index)
							.getComponent(0).setValue(selected_data[0].data[name]);
}
//选中combox的第一个值
function selectComBoFirst(combo){
	combo.on("render", function (thiscombo){
		var firstValue  = thiscombo.store.getRange()[0].data.id;
		thiscombo.setValue(firstValue);
	})
}

Ext.apply(Ext.form.VTypes, {
			daterange : function(val, field) {
				var date = field.parseDate(val);

				if (!date) {
					return;
				}
				if (field.startDateField
						&& (!this.dateRangeMax || (date.getTime() != this.dateRangeMax
								.getTime()))) {
					var start = Ext.getCmp(field.startDateField);
					start.setMaxValue(date);
					start.validate();
					this.dateRangeMax = date;
				} else if (field.endDateField
						&& (!this.dateRangeMin || (date.getTime() != this.dateRangeMin
								.getTime()))) {
					var end = Ext.getCmp(field.endDateField);
					end.setMinValue(date);
					end.validate();
					this.dateRangeMin = date;
				}
				/*
				 * Always return true since we're only using this vtype to set
				 * the min/max allowed values (these are tested for after the
				 * vtype test)
				 */
				return true;
			},

			password : function(val, field) {
				if (field.initialPassField) {
					var pwd = Ext.getCmp(field.initialPassField);
					return (val == pwd.getValue());
				}
				return true;
			},

			passwordText : 'Passwords do not match'
		});

Ext.grid.CheckColumn = function(config) {
	Ext.apply(this, config);
	if (!this.id) {
		this.id = Ext.id();
	}
	this.renderer = this.renderer.createDelegate(this);
};

Ext.grid.CheckColumn.prototype = {
	init : function(grid) {
		this.grid = grid;
		this.grid.on('render', function() {
					var view = this.grid.getView();
					view.mainBody.on('mousedown', this.onMouseDown, this);
				}, this);
	},

	onMouseDown : function(e, t) {
		if (t.className && t.className.indexOf('x-grid3-cc-' + this.id) != -1) {
			e.stopEvent();
			var index = this.grid.getView().findRowIndex(t);
			var record = this.grid.store.getAt(index);
			record.set(this.dataIndex, !record.data[this.dataIndex]);
		}
	},

	renderer : function(v, p, record) {
		p.css += ' x-grid3-check-col-td';
		return '<div class="x-grid3-check-col' + (v ? '-on' : '')
				+ ' x-grid3-cc-' + this.id + '">&#160;</div>';
	}
};

Ext.namespace('Ext.tf.util');

/**
 * Compiles a selector/xpath query into a reusable function. The returned
 * function takes one parameter "root" (optional), which is the context node
 * from where the query should start.
 * 
 * @param {Ext.form.FormPanel}
 *            formPanel 包含主数据的FormPanel
 * @param {Ext.grid.GridPanel/Ext.grid.EditorGridPanel}
 *            gridPanel 包含细节数据的GridPanel
 * @param {Array}
 *            excludes gridPanel中不需要获取的列, 数组中加入需要摈弃的grid.store.fields中
 * @param {Array}
 *            resultPropNames (可选) 定义返回的json对象的属性名，缺省为["formData", "gridData"]
 * @return {Object} 缺省为{formData:masterData, gridData:detailData}
 *         masterData为json对象, detailData为[json对象],
 *         detailData数组中的json对象的属性名与grid.store的fields定义相同
 */
Ext.tf.util.gatherData = function(formPanel, gridPanel, excludes,
		resultPropNames) {
	var store = gridPanel.store;
	var gridDataList = [];
	var formData = formPanel.getForm().getValues(false);

	store.each(function(rec) {
				for (var i = excludes.length - 1; i >= 0; --i) {
					delete rec.data[excludes[i]];
				};
				gridDataList.push(rec.data)
			});
	if (resultPropNames) {
		var result = {};
		result[resultPropNames[0]] = formData;
		result[resultPropNames[1]] = gridDataList;
		return result;
	} else
		return {
			formData : formData,
			gridData : gridDataList
		};
}

Ext.tf.util.debug = function(msg) {
	if (typeof(console) != "undefined") {
		console.debug(msg);
	}
}

/*
 * Usage : var lable = Ext.tf.util.OptCache.getLabel("Nationality", "1");
 * 
 */

Ext.tf.util.OptCache = {};
Ext.tf.util.OptCache.data = {};
Ext.tf.util.OptCache.getOptions = function(optName) {
	var util = Ext.tf.util;
	if (!util.OptCache.data[optName]) {
		OptionProvider.getOptions(optName, {
					async : false,
					callback : function(list) {
						var opt = {};
						for (var i = list.length - 1; i >= 0; --i) {
							opt[list[i].id] = list[i].name;
						};
						util.OptCache.data[optName] = opt;
					}
				});
	} else {
		util.debug("util.OptCache.getOptions: using cache");
	}
	return util.OptCache.data[optName];
};

Ext.tf.util.OptCache.getLabel = function(optName, key) {
	var util = Ext.tf.util;
	var options = util.OptCache.getOptions(optName);
	if (options) {
		return options[key];
	} else {
		return '';
	}
};

/**
 * 回车对应函数 handler
 */
Ext.tf.util.enterKey = function(handler) {
	return {
		key : [10, 13],
		fn : handler
	}
};

// //////////////////////
Ext.ns("Ext.tf");
Ext.tf.currentUser = null;

Ext.tf.SimpleFormPanel = Ext.extend(Ext.FormPanel, {
			autoHeight : true,
			frame : true,
			defaultType : 'textfield',
			inputCard : null,
			initComponent : function() {
				Ext.applyIf(this, {
						// saveFn : function() {}
						});
				this.build();
				Ext.tf.SimpleFormPanel.superclass.initComponent.call(this);
			},

			build : function() {
				this.buttons = [{
							text : '确认',
							handler : this.saveFn,
							formBind : true
						}, {
							text : '取消',
							handler : this.close
						}]
				// this.keys = [ Ext.tf.util.enterKey(this.saveFn) ];
			}

		})

Ext.tf.SimpleQueryFormPanel = Ext.extend(Ext.FormPanel, {
			collapsible : true,
			title : '查询',
			labelWidth : 75,
			frame : true,
			bodyStyle : 'padding:5px 5px 0',
			width : 500,
			defaults : {
				width : 230
			},
			defaultType : 'textfield',

			initComponent : function() {
				Ext.apply(this, this.queryConfigEx);
				Ext.tf.SimpleQueryFormPanel.superclass.initComponent.call(this);
			}

		});

Ext.tf.SimpleGridPanel = Ext.extend(Ext.grid.GridPanel, {

			loadMask : {
				msg : '正在加载数据...'
			},
			viewConfig : {
				forceFit : true
			},
			width : 500,
			height : 300,
			frame : true,

			// toggle: in grid, whether double click fire edit
			dblclickToggle : true,

			// toggle: in grid, whether right mouse click fire context menu
			contextmenuToggle : true,

			initComponent : function() {
				Ext.apply(this, this.gridConfigEx);
				Ext.tf.SimpleGridPanel.superclass.initComponent.call(this);

				this.dblclickToggle && this.on('rowdblclick', this.edit, this);

				// 右键菜单
				this.contextmenuToggle
						&& this.on('rowcontextmenu', this.contextmenu, this);
			},

			contextmenu : function(grid, rowIndex, e) {

				e.preventDefault();
				e.stopEvent();

				var updateMenu = new Ext.menu.Item({
							iconCls : 'edit',
							id : 'updateMenu',
							text : '修改',
							handler : this.edit.createDelegate(this)
						});

				var deleteMenu = new Ext.menu.Item({
							iconCls : 'delete',
							id : 'deleteMenu',
							text : '删除',
							handler : this.del.createDelegate(this)
						});

				var selections = this.getSelections();

				if (selections.length > 1) {
					updateMenu.disable();
				}

				var menuList = [updateMenu, deleteMenu];

				this.grid_menu = new Ext.menu.Menu({
							id : 'mainMenu',
							items : menuList
						});

				var coords = e.getXY();
				grid.getSelectionModel().selectRow(rowIndex);
				this.grid_menu.showAt([coords[0], coords[1]]);

			}

		});

/**
 * 功能页面的panel类 Config 说明: title : '模块目录管理', pageSize : 10, queryUrl :
 * ModuleService.findModuleCategory.createDelegate(this), editUrl :
 * ModuleService.editModuleCategory.createDelegate(this), deleteUrl : xxx, //
 * Grid 需要的配置信息, 会覆盖掉缺省的 gridConfigEx : {}; // query panel 需要的配置信息, 会覆盖掉缺省的
 * queryConfigEx : {};
 * 
 * //查询用到的form配置 queryConfig : [ { fieldLabel : '名称', name : 'name', allowBlank :
 * true } ], //编辑用到的form配置 editConfig : [ { fieldLabel : '模块目录名称', name : 'name' }, {
 * fieldLabel : '排列顺序', name : 'ordinal' } ], //reader的配置 readerConfig : [ {
 * name : 'id', mapping : 'id' }, { name : 'name', mapping : 'name' }, { name :
 * 'ordinal', mapping : 'ordinal' } ], //网格记录显示的配置 gridCm : [ { "hidden" : true,
 * "header" : "ID", "sortable" : true, "dataIndex" : "id" }, { "header" :
 * "模块目录名称", "sortable" : true, "dataIndex" : "name" }, { "header" : "排列顺序",
 * "sortable" : true, "dataIndex" : "ordinal" } ]
 */
Ext.tf.SimplePanel = Ext.extend(Ext.Panel, {
	closable : true,
	hasAdd : true,
	queryUrl : Ext.emptyFn,
	editUrl : Ext.emptyFn,
	deleteUrl : Ext.emptyFn,

	// toggle: in grid, whether double click fire edit
	dblclickToggle : true,

	// toggle: in grid, whether right mouse click fire context menu
	contextmenuToggle : true,

	initComponent : function() {
		try {
			Ext.applyIf(this, {
						pageSize : 10
					});

			this.reader = new Ext.data.JsonReader({
						totalProperty : "totalSize", // 总记录数
						root : "data", // 分页对象中的数据集
						id : "id" //
					}, Ext.data.Record.create(this.readerConfig));

			this.store = new Ext.data.Store({
				proxy : new Ext.ux.data.DWRProxy({
							dwrFunction : this.queryUrl,
							listeners : {
								'beforeload' : function(dataProxy, params) {
									// alert(dwr.util.toDescriptiveString(params,
									// 2));
									var o = this.queryForm.getForm()
											.getValues(false);
									if (!params.limit)
										params.limit = this.pageSize;
									params[dataProxy.loadArgsKey] = [o, params];
								}.createDelegate(this)
							}
						}),
				reader : this.reader
			});

			this.pagingBar = new App.PagingToolbar({
						pageSize : this.pageSize,
						store : this.store,
						displayInfo : true,
						displayMsg : '{0} - {1} of {2}',
						emptyMsg : "没有记录"
					});

			this.grid = new Ext.tf.SimpleGridPanel({
						gridConfigEx : this.gridConfigEx,
						edit : this.edit.createDelegate(this),
						del : this.del.createDelegate(this),
						store : this.store,
						cm : new Ext.grid.ColumnModel(this.gridCm),
						dblclickToggle : this.dblclickToggle,
						contextmenuToggle : this.contextmenuToggle,
						bbar : this.pagingBar
					});
			this.editForm = new Ext.tf.SimpleFormPanel({
						items : this.editConfig,

						close : function() {
							this.editWin.hide();
						}.createDelegate(this),

						saveFn : function() {
							var formBean = this.editForm.getForm()
									.getValues(false);
							this.editUrl(formBean, function() {
										Ext.MessageBox.alert("提示", "保存成功！");
										this.editWin.hide();
										this.store.reload();
									}.createDelegate(this));
						}.createDelegate(this)
					});
			this.editWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 300,
						items : [this.editForm]
					});
			this.addRecord = function() {
				this.editForm.getForm().reset();
				this.editWin.show();
			};
			this.query = function() {
				this.grid.selModel.clearSelections();
				this.store.reload();
			};
			this.queryForm = new Ext.tf.SimpleQueryFormPanel({
						queryConfigEx : this.queryConfigEx,
						items : this.queryConfig,
						buttons : [{
									text : '查询',
									formBind : true,
									scope : this,
									handler : this.query.createDelegate(this)
								}],
						keys : [Ext.tf.util.enterKey(this.query
								.createDelegate(this))]
					});

			if (this.hasAdd) {
				this.queryForm.addButton('新增', this.addRecord, this);
			}

			this.items = [this.queryForm, this.grid];

			Ext.tf.SimplePanel.superclass.initComponent.call(this);
		} catch (e) {
			console.log(e);
			throw e;
		}
	},

	// private
	edit : function() {
		var selections = this.grid.getSelections();
		if (selections.length == 0) {
			Ext.MessageBox.alert("提示", "请选择一条的记录！");
			return;
		} else if (selections.length != 1) {
			Ext.MessageBox.alert("提示", "不能选择多行编辑！");
			return;
		}
		this.editWin.show();
		this.editForm.getForm().loadRecord(selections[0]);
	},

	del : function() {
		var selections = this.grid.getSelections();
		if (selections.length == 0) {
			Ext.MessageBox.alert("提示", "请选择一条的记录！");
			return;
		}

		var fn = function(e) {
			if (e == "yes") {
				var ids = new Array();
				for (var i = 0, len = selections.length; i < len; i++) {
					try {
						// 如果选中的record没有在这一页显示，remove就会出问题
						selections[i].get("id");
						ids[i] = selections[i].get("id");
					} catch (e) {
						console.log(e);
					}
				}
				this.deleteUrl(ids.join(","), function() {
							Ext.MessageBox.alert("提示", "删除完毕！");
							this.store.reload();
						}.createDelegate(this));
			}
		}

		Ext.MessageBox.confirm("提示", "确认要删除所选择的记录么？", fn, this);

	},
	
	// public
	load : function() {
		return this.store.load({
					params : {
						start : 0,
						limit : this.pageSize
					}
				});
	}
});

Ext.tf.XnhInterfacePanel = Ext.extend(Ext.Panel, {
	closable : true,
	hasAdd : true,
	autoScroll : true,
	queryUrl : Ext.emptyFn,
	editUrl : Ext.emptyFn,
	deleteUrl : Ext.emptyFn,

	// toggle: in grid, whether double click fire edit
	dblclickToggle : true,

	// toggle: in grid, whether right mouse click fire context menu
	contextmenuToggle : true,
	// private
	initComponent : function() {
		try {
			Ext.applyIf(this, {
						pageSize : 10
					});
			this.pbar = new Ext.ProgressBar({ // 实例化进度条
				width : 300, // 进度条的宽度
				text : "单击按钮开始..." // 在进度条里的初始文本
			});
			this.reader = new Ext.data.JsonReader({
						totalProperty : "totalSize", // 总记录数
						root : "data", // 分页对象中的数据集
						id : "id" //
					}, Ext.data.Record.create(this.readerConfig));

			this.store = new Ext.data.Store({
				reader : this.reader
			});
			// 账户信息的READER
			this.accountReader = new Ext.data.JsonReader({
						totalProperty : "totalSize", // 总记录数
						root : "data", // 分页对象中的数据集
						id : "id" //
					}, Ext.data.Record.create(this.accountReaderConfig));
			this.accountStore = new Ext.data.Store({
						reader : this.accountReader
					});

			this.pagingBar = new App.PagingToolbar({
						pageSize : this.pageSize,
						store : this.store,
						displayInfo : true,
						displayMsg : '{0} - {1} of {2}',
						emptyMsg : "没有记录"
					});
			// 最开始的处方列表
			this.grid = new Ext.grid.GridPanel({
						gridConfigEx : this.gridConfigEx,
						edit : this.edit.createDelegate(this),
						del : this.del.createDelegate(this),
						store : this.store,
						cm : new Ext.grid.ColumnModel(this.gridCm),
						dblclickToggle : this.dblclickToggle,
						contextmenuToggle : this.contextmenuToggle,
						bbar : this.pagingBar,
						loadMask : {
							msg : '正在加载数据...'
						},
						viewConfig : {
							forceFit : true
						},
						width : 700,
						height : 160,
						frame : true,
						dblclickToggle : true,
						contextmenuToggle : true,
						initComponent : function() {
							Ext.apply(this, this.gridConfigEx);
							Ext.tf.SimpleGridPanel.superclass.initComponent
									.call(this);
							this.dblclickToggle
									&& this.on('rowdblclick', this.edit, this);
							// 右键菜单
							this.contextmenuToggle
									&& this.on('rowcontextmenu',
											this.contextmenu, this);
						},
						contextmenu : function(grid, rowIndex, e) {
							e.preventDefault();
							e.stopEvent();
							var updateMenu = new Ext.menu.Item({
										iconCls : 'edit',
										id : 'updateMenu',
										text : '修改',
										handler : this.edit
												.createDelegate(this)
									});
							var deleteMenu = new Ext.menu.Item({
										iconCls : 'delete',
										id : 'deleteMenu',
										text : '删除',
										handler : this.del.createDelegate(this)
									});
							var selections = this.getSelections();
							if (selections.length > 1) {
								updateMenu.disable();
							}
							var menuList = [updateMenu, deleteMenu];
							this.grid_menu = new Ext.menu.Menu({
										id : 'mainMenu',
										items : menuList
									});
							var coords = e.getXY();
							grid.getSelectionModel().selectRow(rowIndex);
							this.grid_menu.showAt([coords[0], coords[1]]);
						}
					});
			// 账户信息的列表
			this.accountGrid = new Ext.grid.GridPanel({
				gridConfigEx : this.gridConfigEx,
				edit : this.edit.createDelegate(this),
				// private
				f_rowclick : function() {
					var selections = this.accountGrid.getSelections();
					if (selections.length == 0) {
						Ext.MessageBox.alert("提示", "请选择一条的记录！");
						return;
					}
					// 选中一条记录时,将信息更新到下面的列中,并查询余额情况
					// alert(selections[0].data.familycardno);
					savedate (this.accountInfoForm,4,selections,"personmdno");
					savedate (this.accountInfoForm,5,selections,"familycardno");
					savedate (this.accountInfoForm,6,selections,"mdcardno");
					savedate (this.accountInfoForm,7,selections,"firstdate");
					savedate (this.accountInfoForm,8,selections,"relation");
					savedate (this.accountInfoForm,9,selections,"mdlevel");
					savedate (this.accountInfoForm,10,selections,"money1");
					savedate (this.accountInfoForm,11,selections,"count");
					savedate (this.accountInfoForm,12,selections,"money2");
					savedate (this.accountInfoForm,13,selections,"money3");
					savedate (this.accountInfoForm,14,selections,"money4");
					savedate (this.accountInfoForm,15,selections,"money5");
					savedate (this.accountInfoForm,16,selections,"money6");
					savedate (this.accountInfoForm,17,selections,"money7");
					savedate (this.accountInfoForm,18,selections,"money8");
					savedate (this.accountInfoForm,19,selections,"money9");
				}.createDelegate(this),
				// private
				f_rowdblclick : function() {
					var selections = this.accountGrid.getSelections();
					if (selections.length == 0) {
						Ext.MessageBox.alert("提示", "请选择一条的记录！");
						return;
					}
					// 选中一条记录时,将信息更新到下面的列中,并查询余额情况
					// alert(selections[0].data.familycardno);
					//医疗待遇类别
					//savedate (this.queryForm,1,selections,"mdlevel");
					savedate (this.queryForm,6,selections,"name");
					savedate (this.queryForm,7,selections,"sex");
					savedate (this.queryForm,8,selections,"birthday");
					savedate (this.queryForm,9,selections,"personno");
					savedate (this.queryForm,11,selections,"money1");
					savedate (this.queryForm,12,selections,"count");
					savedate (this.queryForm,13,selections,"money2");
					savedate (this.queryForm,14,selections,"money3");
					savedate (this.queryForm,15,selections,"money4");
					savedate (this.queryForm,16,selections,"money5");
					savedate (this.queryForm,17,selections,"money6");
					savedate (this.queryForm,18,selections,"money7");
					savedate (this.queryForm,19,selections,"money8");
					savedate (this.queryForm,20,selections,"money9");
					//写入编码
//					alert(rows[0].data[personno]);
//					alert(this.queryForm.getComponent(0).getComponent(31).xtype);
					this.queryForm.findById("personno").setValue(selections[0].data["personno"]);
					this.accountInfoWin.hide();
				}.createDelegate(this),
				del : this.del.createDelegate(this),
				store : this.accountStore,
				cm : new Ext.grid.ColumnModel(this.accountgridCm),
				dblclickToggle : this.dblclickToggle,
				contextmenuToggle : this.contextmenuToggle,
				bbar : this.pagingBar,
				loadMask : {
					msg : '正在加载数据...'
				},
				viewConfig : {
					forceFit : true
				},
				width : 700,
				height : 160,
				frame : true,
				dblclickToggle : true,
				contextmenuToggle : true,
				initComponent : function() {
					Ext.apply(this, this.gridConfigEx);
					Ext.tf.SimpleGridPanel.superclass.initComponent.call(this);
					this.dblclickToggle
							&& this.on('rowdblclick', this.f_rowdblclick, this);
					this.dblclickToggle
							&& this.on('rowclick', this.f_rowclick, this);
				}
			});
			this.accountInfoForm = new Ext.FormPanel({
						// this.accountInfoForm = new Ext.tf.SimpleFormPanel({
						width : 700,
						height : 180,
						labelAlign : 'left',
						buttonAlign : 'center',
						bodyStyle : 'padding:5px;',
						frame : true,
						// labelWidth : 65,
						monitorValid : true,
						queryConfigEx : this.queryConfigEx,
						items : this.accountInfoConfig,
						close : function() {
							this.accountInfoWin.hide();
						}.createDelegate(this),

						saveFn : function() {
							var formBean = this.accountInfoForm.getForm()
									.getValues(false);
							this.editUrl(formBean, function() {
										Ext.MessageBox.alert("提示", "保存成功！");
										this.accountInfoWin.hide();
										this.store.reload();
									}.createDelegate(this));
						}.createDelegate(this)
					});

			this.accountInfoWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 720,
						items : [this.accountGrid, this.accountInfoForm]
					});
			this.payForm = new Ext.FormPanel({
						// this.accountInfoForm = new Ext.tf.SimpleFormPanel({
						width : 700,
						height : 500,
						labelAlign : 'left',
						buttonAlign : 'center',
						bodyStyle : 'padding:5px;',
						frame : true,
						// labelWidth : 65,
						monitorValid : true,
						queryConfigEx : this.queryConfigEx,
						items : this.payConfig,
						close : function() {
							this.payWin.hide();
						}.createDelegate(this),

						saveFn : function() {
							var formBean = this.payForm.getForm()
									.getValues(false);
							this.editUrl(formBean, function() {
										Ext.MessageBox.alert("提示", "保存成功！");
										this.payWin.hide();
										this.store.reload();
									}.createDelegate(this));
						}.createDelegate(this)
					});

			this.payWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 720,
						items : [this.payForm]
					});
			// this.CardForm = Ext.extend( Ext.tf.SimpleFormPanel,{
			this.CardForm = new Ext.tf.SimpleFormPanel({
						monitorValid : true,
						confirmUrl : this.confirmUrl,
						items : this.cardConfig,
						close : function() {
							this.CardWin.hide();
						}.createDelegate(this),
						inputCard : function() {
							this.CardWin.show();
						}.createDelegate(this),
						saveFn : function() {
							var formBean = this.CardForm.getForm()
									.getValues(false);
							this.CardWin.setDisabled(true);
							try {
								this.confirmUrl(formBean, function(data) {
											this.CardWin.setDisabled(false);
											if (data.msg) {
												Ext.MessageBox.alert("错误", data.msg);
//												alert(data.msg);
											} else {
												this.accountStore
														.loadData(data.data);
												this.accountInfoForm.getForm()
														.reset();
												this.CardWin.hide();
											}
										}.createDelegate(this));
							} catch (e) {
								this.CardWin.setDisabled(false);
							}
						}.createDelegate(this)
					});
			this.CardWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 300,
						items : [this.CardForm]
					});
			this.drugForm = new Ext.tf.SimpleFormPanel({
						monitorValid : true,
						items : this.drugConfig,
						close : function() {
							this.drugWin.hide();
						}.createDelegate(this),
						saveFn : function() {
							var formBean = this.drugForm.getForm()
									.getValues(false);
							if(formBean.index == null ||formBean.index == "" ){
								var _rs = new Ext.data.Record(formBean) ;
//								for(var ttt in _rs.data){
//									alert(ttt+"==="+_rs.data[ttt])
//								}
								_rs.data["drugname"] =_rs.data["drugname"].substr(_rs.data["drugname"].indexOf("--")+2);
								_rs.data["index"] = this.grid.store.getCount()+1;
								this.grid.store.add(_rs) 
							}else{
								var lastrs = this.grid.store.getAt(formBean.index-1);
								lastrs.data = new Ext.data.Record(formBean).data;
								lastrs.commit();
								//this.grid.store.reload();
//								Ext.data.Record[] records = new Ext.data.Record[](new Ext.data.Record(formBean))
//								this.grid.store.remove(formBean.index-1);
//								this.grid.store.insert(formBean.index-1,records);
							}
							
							this.drugWin.hide();
						}.createDelegate(this)
					});

			this.drugWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 400,
						items : [this.drugForm]
					});
			this.editForm = new Ext.tf.SimpleFormPanel({
						items : this.editConfig,

						close : function() {
							this.editWin.hide();
						}.createDelegate(this),
						saveFn : function() {
							var formBean = this.editForm.getForm()
									.getValues(false);
							this.editUrl(formBean, function() {
										Ext.MessageBox.alert("提示", "保存成功！");
										this.editWin.hide();
										this.store.reload();
									}.createDelegate(this));
						}.createDelegate(this)
					});

			this.editWin = new Ext.Window({
						title : '',
						closeAction : 'hide',
						modal : true,
						autoHeight : true,
						// autoWidth : true,
						width : 300,
						items : [this.editForm]
					});
			this.addRecord = function() {
				this.editForm.getForm().reset();
				this.editWin.show();
			};
			this.query = function() {

				this.grid.selModel.clearSelections();
				this.store.reload();
			};
			this.queryForm = new Ext.FormPanel({
						width : 700,
						labelAlign : 'left',
						buttonAlign : 'center',
						bodyStyle : 'padding:5px;',
						frame : true,
						labelWidth : 65,
						monitorValid : true,
						queryConfigEx : this.queryConfigEx,
						// defaultType: 'textfield',
						items : this.queryConfig,
						keys : [Ext.tf.util.enterKey(this.query
								.createDelegate(this))]
					});
			this.items = [this.queryForm, this.grid];
			Ext.tf.XnhInterfacePanel.superclass.initComponent.call(this);
			selectComBoFirst(this.queryForm.findById("mdtype_query_id"));
			selectComBoFirst(this.queryForm.findById("mdlevel_id"));
			selectComBoFirst(this.queryForm.findById("disease_id"));
			selectComBoFirst(this.queryForm.findById("doc_id"));
			selectComBoFirst(this.queryForm.findById("depart_id"));
			selectComBoFirst(this.queryForm.findById("cmedicine_id"));
			this.queryForm.findById("paydate").setValue(new Date());
			this.queryForm.findById("prescno").setValue("5573");
			this.queryForm.findById("regno").setValue("1235");
			this.queryForm.findById("query_empcode").setValue("系统管理员");
			this.queryForm.findById("treatdate_query").setValue(new Date());
			
		} catch (e) {
			console.log(e);
			throw e;
		}
	},
	accountInfo : function() {
		this.accountInfoWin.show();
		// this.accountInfoWin.getForm().loadRecord(selections[0]);
	},
	// private
	edit : function() {
		var selections = this.grid.getSelections();
		if (selections.length == 0) {
			Ext.MessageBox.alert("提示", "请选择一条的记录！");
			return;
		} else if (selections.length != 1) {
			Ext.MessageBox.alert("提示", "不能选择多行编辑！");
			return;
		}
		this.drugWin.show();
		this.drugForm.getForm().loadRecord(selections[0]);
	},

	del : function() {
		var selections = this.grid.getSelections();
		if (selections.length == 0) {
			Ext.MessageBox.alert("提示", "请选择一条的记录！");
			return;
		}

		var fn = function(e) {
			if (e == "yes") {
				var ids = new Array();
				var msg  = selections.length - 1  + selections[0].data.index-1;
				for (var i = selections.length-1 +selections[0].data.index-1; i >= selections[0].data.index-1; i--) {
					this.grid.store.remove(this.grid.store.getAt(i));
				}
			}
		}

		Ext.MessageBox.confirm("提示", "确认要删除所选择的记录么？", fn, this);

	},

	// public
	load : function() {
//		return this.store.load({
//					params : {
//						start : 0,
//						limit : this.pageSize
//					}
//				});
	}
});

/**
 * 弹出窗口控件
 */
Ext.tf.PopSelect = Ext.extend(Ext.form.TriggerField, {

			triggerClass : 'x-form-date-trigger',
			readOnly : true,

			initComponent : function() {
				Ext.tf.PopSelect.superclass.initComponent(this);
			},

			/**
			 * Find ref element, set value
			 */
			setRefName : function(v) {
				var refName = this.refName || ''; // If not refName, then ??
				var form = this.findParentBy(function(v) {
							if (Ext.type(v.getForm) == 'function')
								return true;
						});
				if (form != null) {
					Ext.each(form.find("name", refName), function(field) {
								field.setValue(v);
							});
				}
				return this;
			},

			onDestroy : function() {
				Ext.destroy(this.win, this.panel);
				Ext.tf.PopSelect.superclass.onDestroy.call(this);
			},

			edit : function() {
				var grid = this.panel.grid;
				var store = this.panel.store;
				var view = grid.getView();
				var sm = grid.getSelectionModel();

				for (var i = 0; i < view.getRows().length; i++) {
					if (sm.isSelected(i)) {
						var record = store.getAt(i);
						var id = record.get('id');
						var name = record.get('name');
						this.setValue(name);
						this.setRefName(id);
					};
				};
				this.win.hide();
			},

			// pop select window
			onTriggerClick : function() {
				if (this.win == null) {

					this.panel = new Ext.tf.SimplePanel({
								title : '',
								pageSize : 10,
								hasAdd : false,

								dblclickToggle : false,
								contextmenuToggle : false,

								gridConfigEx : {
									height : 200
								},

								queryUrl : this.queryUrl,
								// 查询条件Form
								queryConfig : this.queryConfig,
								// Grid 读取数据时的reader
								readerConfig : this.readerConfig,
								// Grid的列
								gridCm : this.gridCm
							});

					this.panel.grid.on('rowdblclick', this.edit, this);

					this.win = new Ext.Window({
								title : this.title,
								modal : true,
								width : 520,
								autoHeight : true,
								closeAction : 'hide',
								items : [this.panel],
								buttons : [{
											text : '关闭',
											handler : function() {
												this.win.hide();
											}.createDelegate(this)
										}, {
											text : '清除',
											handler : function() {
												this.setValue('');
												this.setRefName('');
												this.win.hide();
											}.createDelegate(this)
										}, {
											text : '确认',
											handler : this.edit
													.createDelegate(this)
										}]
							});
				}
				this.win.show(this);
			}

		});
Ext.reg("popselect", Ext.tf.PopSelect);

