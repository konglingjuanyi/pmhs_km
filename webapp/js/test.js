Ext.ns("Ext.tf");

// /////////////
// ��������ģ��
// /////////////

var isFirst = 1;

Ext.tf.HealthPanel = Ext.extend(Ext.Panel, {

	closable : true,
	currentNode : null, // ��ǰѡ������ڵ�
	layout : 'fit',
	title: '��2��5�β�ǰ��ü�¼',
	pageSize : 20,
	recordId : 'visit.id',
	recordPk : 'id',
	panelId : 'app.visitBeforeBornPanel',
	
	// height:700,
	// �Ƿ���Ҫ����ĩ���������ӣ�
	checkLastLevel : true,

	// ���ò�ѯurl
	queryUrl : UserMenuTreeService.findVisitBeforeBornRecords,
	deleteUrl : UserMenuTreeService.removeVisitBeforeBornRecords,
	dataExportUrl : DataExportService.dataExportVisitBeforeBorn,
	treeLoaderFn: UserMenuTreeService.getUserDistrictNodes,
	diseaseId : null,
	visitDoctor : null,
	getAddParams : function() {
		var node = this.getTreeSelNode();
		var districtNumber = node.id;
		var param = '?districtNumber=' + districtNumber;
		return param;
	},

	// ���ò�ѯ�õ���𣬱��絵������Ѫѹ�ȡ���
	queryType : 'demo',
	detailUrl: '/VisitBeforeBorn.html',
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
                     { "header" : "��������", "dataIndex" : "birthday",
                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                                         { "header" : "��Σ", "dataIndex" : "highRisk" },   
                     { "header" : "����", "dataIndex" : "weeks" },
                     { "header" : "��Ŀ", "dataIndex" : "item","renderer" : function(val){
                    	 return "��" + val + "��";
                     }},
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

	/**
	 * �༭����
	 */
	f_edit : function(record) {
		var fileNo = record.get(this.recordPk);
		var param = '?' + this.recordPk + '=' + fileNo;
		param = this.detailUrl + param;
		if (this.visitDoctor != null) {
			param = param + '&' + this.visitDoctor + '='
					+ escape(Ext.tf.currentUser.taxempname);
		}
		this.openWin(param);
	},

	/**
	 * ���ӹ���
	 */
	f_add : function(isSlient) {

		if (this.checkLastLevel) {
			// �ж��Ƿ��ǵ��弶��
			var node = this.getTreeSelNode();

			var level = node.attributes['data'].level;
			if (level != 5) {
				if (!isSlient) {
					Ext.Msg.alert('', 'ֻ�е��弶��������������Ӽ�¼��');
				}
				return;
			}
		}

		param = this.detailUrl + this.getAddParams();
		console.log(param);
		if (this.visitDoctor != null) {
			param = param + '&' + this.visitDoctor + '='
					+ escape(Ext.tf.currentUser.taxempname);
		}
		if (this.diseaseId != null) {
			// param = param +"&diseaseId="+this.diseaseId;
			this.openWin(param, {
				'diseaseId' : this.diseaseId,
				"confirmDate" : new Date()
			});
		} else {
			this.openWin(param);
		}

	},

	/**
	 * �򿪱༭����
	 */
	openWin : function(targetUrl, param) {

		var win = new Ext.Window({
			modal : true,
			title : '¼���¼',
			border : false
		// autoScroll : true
		});
		if (param != null) {
			window.other_init_param = param;
		}

		win.show();
		win.maximize();

		win.add({
			xtype : 'iframepanel',
			defaultSrc : targetUrl,
			// width: win.getInnerWidth() - 380,
			// height: win.getInnerHeight() - 10,
			title : '',
			loadMask : true,
			autoScroll : false,
			listeners : {
				message : function(f, data) {
					console.log("receive message...");
					console.log(data);
					if (data.data == 'quit') {
						win.close();
					} else if (data.data == 'saved') {
						this.load();
					}
				}.createDelegate(this)
			}
		});
		win.doLayout(true);
	},

	getTreeSelNode : function() {
		var selNode = this.currentNode;
		if (selNode) {
			// Ext.Msg.alert('', selNode.text);
		} else {
			Ext.Msg.show({
				icon : Ext.Msg.WARNING,
				buttons : Ext.Msg.OK,
				msg : '����ѡ��һ����������'
			});
		}
		;
		return selNode;
	},
	createActions : function() {
		var store = new Ext.data.SimpleStore({
			fields : [ 'type', 'display' ],
			data : [ [ 'a.name', '����' ], [ 'c.highRisk', '��Σɸѡ' ],
					[ 'a.inputDate', '¼������' ], [ 'a.lastModifyDate', '�޸�����' ],
					[ 'b.birthday', '��������' ], [ 'a.fileNo', '��������' ],
					[ 'b.idnumber', '���֤��' ], [ 'b.linkman', '��ϵ��' ],
					[ 'a.paperFileNo', 'ֽ�ʵ�����' ], [ 'b.workUnit', '������λ' ] ]
		});
		this.combo = new Ext.form.ComboBox({
			store : store,
			displayField : 'display',
			valueField : 'type',
			typeAhead : true,
			mode : 'local',
			triggerAction : 'all',
			selectOnFocus : true,
			editable : false,
			width : 100,
			value : 'a.name'
		});
		this.filterField = new Ext.form.TextField({
			fieldLabel : '',
			enableKeyEvents : true,
			listeners : {
				'keypress' : function(field, event) {
					if (event.getKey() == 13) {
						this.load(true);
					}
					;
				}.createDelegate(this)
			}
		});

		this.isFirst = new Ext.form.TextField({
			fieldLabel : '',
			id : 'isFirst',
			hidden : true
		});

		this.editFn = function() {
			var selections = this.grid.getSelections();
			if (selections.length == 1) {
				console.log(selections[0]);
				this.f_edit(selections[0]);
			}
		};

		this.editAction = new Ext.Action({
			text : '�޸�',
			iconCls : 'c_edit',
			handler : this.editFn.createDelegate(this)
		});

		return 
				this.combo,
				this.filterField,
				new Ext.Action({
					text : '��ѯ',
					iconCls : 'c_query',
					handler : function() {
						this.load(true);
					}.createDelegate(this)
				}) ];
	},

	/*
	 * ȡ���������Ľڵ� ����ڵ�û��ѡ�У���ʾ��Ϣ�����ؿ� ���ѡ�У���ȡ�ù�����������ϳɲ�ѯ������������֮
	 */
	getParams : function() {
		var selNode = this.getTreeSelNode();
		if (selNode) {
			var filterKey = this.combo.getValue();
			var filterValue = this.filterField.getValue();
			var isFirst = this.isFirst.getValue();
			var cond = {
				district : selNode.id,
				filterKey : filterKey,
				filterValue : filterValue,
				isFirst : isFirst
			};
			console.log(cond);
			return cond;
		}
		return null;
	},

	/*
	 * ��ѯ����, �����û��ѡ���˽ڵ㣬��ִ��
	 */
	load : function(isReset) {
		var selNode = this.getTreeSelNode();
		if (selNode) {
			if (isReset) {
				this.pagingBar.changePage(1);
			}
			this.grid.getStore().reload();
			this.doLayout(true);
		}
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

//		this.grid.on('rowdblclick', this.editFn, this);
		this.grid.on('rowdblclick', function(){
			var selections = this.grid.getSelections();
			if (selections.length == 1) {
				console.log(selections[0]);
				this.f_edit(selections[0]);
			}
		}, this);

		this.menu = new Ext.tree.TreePanel({
			// height : 465,
			layout : 'fit',
			animate : true,
			enableDD : false,
			loader : new Ext.ux.DWRTreeLoader({
				dwrCall : this.treeLoaderFn
			}),
			lines : true,
			autoScroll : true,
			border : false,
			root : new Ext.tree.AsyncTreeNode({
				text : 'root',
				draggable : false,
				id : 'org'
			}),
			rootVisible : false
		});

		this.menu.getRootNode().on({
			append : {
				stopEvent : true,
				fn : function(t, me, n, index) {
					// �Զ�չ�����ڵ�ĵ�һ������
					if (index == 0) {
						if (!n.leaf)
							n.expand();
						this.currentNode = n;
						this.isFirst.setValue(0);
						// this.load();
					}
				}.createDelegate(this)
			}
		});

		this.menu.on({
			click : {
				stopEvent : true,
				fn : function(n, e) {
					e.stopEvent();
					this.currentNode = n;
					this.isFirst.setValue(1);
					this.grid.setTitle(n.text);
					this.load();
				}.createDelegate(this)
			},
			dblclick : {
				fn : function(n, e) {
					this.f_add(true);
				}.createDelegate(this)
			}
		});

		var panel = new Ext.Panel({
			layout : 'border',
			autoScroll : true,
			id : this.panelId,
			tbar : this.createActions(),
			items : [ {
				region : 'west',
				layout : 'fit',
				frame : false,
				title : '��������',
				split : true,
				collapsible : true,
				layoutConfig : {
					animate : true
				},
				width : 200,
				minSize : 100,
				maxSize : 400,
				border : false,
				items : [ this.menu ]
			}, {
				region : 'center',
				layout : 'fit',
				frame : false,
				border : false,
				items : [ this.grid ]
			} ]
		});
		return panel;
	}
});

/**
 * ��������֯���� ���α༭
 */
Ext.tf.OrgTreePanel = Ext.extend(Ext.Panel, {
	title : 'δ����',
	closable : true,
	autoScroll : true,
	// height: 100,
	currentNode : null,
	saveFn : Ext.emptyFn,
	deleteFn : Ext.emptyFn,
	formItems : [],

	addEqAction : null,
	addDownAction : null,
	editAction : null,
	delAction : null,

	initComponent : function() {
		this.buildAction();
		this.buildTree();
		this.build();
		Ext.tf.OrgTreePanel.superclass.initComponent.call(this);
	},

	getTreeSelNode : function() {
		var selNode = this.currentNode;
		if (selNode) {
			console.log(selNode);
			// Ext.Msg.alert('', selNode.text);
		} else {
			Ext.Msg.alert('', '����ѡ��һ���ڵ㣡');
		}
		;
		return selNode;
	},
	/**
	 * ���� ���ڵ�me��Ϊ�գ���ʾ�Ǳ༭�ڵ� ��Ӧ��������� 1. ���� 2. �༭�Ǹ��ڵ� 3.
	 * �༭���ڵ㣨���ڸ��ڵ�û�и���ֵ���ڲ����̨����������£�����Դ���
	 */
	edit : function(sameLevel, parentNode, me) {

		var isEdit = false, parentLevel = null;

		if (me)
			isEdit = true;
		if (!isEdit) {
			parentLevel = parentNode.attributes['data'].level;
			// ������׵ļ��𳬹�6�ˣ����������ӽڵ�
			if (Ext.num(parentLevel) >= 5) {
				return;
			}
			;
		}
		;

		var form = new Ext.form.FormPanel({
			frame : true,
			defaultType : 'textfield',
			items : this.formItems,
			buttons : [ {
				text : '����',
				handler : function() {
					var formbean = form.getForm().getValues(false);
					this.saveFn(formbean, {
						callback : function(data) {
							Ext.Msg.alert('', '����ɹ���');
							console.log(data);
							if (!isEdit) {
								var child = new Ext.tree.TreeNode({
									id : data.id,
									text : data.name,
									cls : 'folder',
									leaf : false
								});
								child.attributes['data'] = data;
								parentNode.appendChild(child);
								this.menu.getSelectionModel().select(child);
							} else {
								me.attributes['data'] = data;
								me.setText(data.name);
							}
							win.close();
						}.createDelegate(this),
						errorHandler : function(msg) {
							console.log(msg);
							Ext.Msg.alert('', '�������');
						}
					});
				}.createDelegate(this)
			}, {
				text : '�ر�',
				handler : function() {
					win.close();
				}
			} ]
		});

		var win = new Ext.Window({
			title : this.title,
			modal : true,
			width : 300,
			closeAction : 'close',
			items : [ form ]
		});

		win.show();

		var baseForm = form.getForm();
		if (isEdit) {
			baseForm.loadRecord(new Ext.data.Record(me.attributes['data']));
			baseForm.findField('id').el.dom.readOnly = true;
		} else {
			baseForm.findField('level').setValue(parentLevel + 1);
		}
		;

		var parentNameField = baseForm.findField('parentName');
		if (parentNameField && parentNode) {
			parentNameField.setValue(parentNode.text);
		}
		;

		if (isEdit && !parentNode) {
			form.remove(parentNameField);
		}
		;
	},

	buildAction : function() {
		this.addEqAction = new Ext.Action({
			text : 'ƽ������',
			iconCls : 'c_add',
			handler : function() {
				var node = this.getTreeSelNode();
				if (!node)
					return;
				if (node.isRoot)
					return;
				this.edit(true, node.parentNode);
			}.createDelegate(this)
		});
		this.addDownAction = new Ext.Action({
			text : '�¼�����',
			iconCls : 'c_add',
			handler : function() {
				var node = this.getTreeSelNode();
				if (!node)
					return;
				this.edit(false, node);
			}.createDelegate(this)
		});
		this.editAction = new Ext.Action({
			text : '�༭',
			iconCls : 'c_edit',
			handler : function() {
				var node = this.getTreeSelNode();
				if (!node)
					return;
				if (node.isRoot) {
					this.edit(true, null, node);
				} else {
					this.edit(true, node.parentNode, node);
				}
			}.createDelegate(this)
		});
		this.delAction = new Ext.Action({
			text : 'ɾ��',
			iconCls : 'c_del',
			handler : function() {
				var node = this.getTreeSelNode();
				if (!node)
					return;
				if (node.isRoot)
					return;
				console.log(node.firstChild);
				if (node.firstChild) {
					Ext.Msg.alert('', '���ӽڵ㣬����ɾ����');
					return;
				}
				var del = function(e) {
					if (e == "yes") {
						this.deleteFn(node.id, {
							callback : function(data) {
								Ext.Msg.alert('', 'ɾ���ɹ���');
								if (node.nextSibling) {
									this.menu.getSelectionModel().select(
											node.nextSibling);
								} else {
									this.menu.getSelectionModel().select(
											node.parentNode);
								}
								node.remove();
							}.createDelegate(this),
							errorHandler : function(msg) {
								console.log(msg);
								Ext.Msg.alert('', 'ɾ������');
							}
						});
					}
					;
				};

				Ext.MessageBox.confirm("��ʾ", "ȷ��Ҫɾ����ѡ��ļ�¼ô��", del, this);

			}.createDelegate(this)
		});
	},

	buildTree : function() {
		this.menu = new Ext.tree.TreePanel({
			width : 552,
			height : 450,
			rootVisible : true,
			autoScroll : true,
			lines : false,
			animate : true,
			tbar : [ this.addEqAction, this.addDownAction, this.editAction,
					this.delAction ],
			loader : new Ext.ux.DWRTreeLoader({
				dwrCall : this.treeLoaderFn
			}),
			root : new Ext.tree.AsyncTreeNode({
				text : this.rootNodeData.name,
				hasChildren : true,
				id : this.rootNodeData.id
			})
		});
		var rootNode = this.menu.getRootNode();

		rootNode.attributes['data'] = this.rootNodeData;
		this.menu.on({
			click : {
				stopEvent : true,
				fn : function(n, e) {
					e.stopEvent();
					this.currentNode = n;
				}.createDelegate(this)
			}
		});

	},

	build : function() {
		this.items = [ this.menu ];
	}

});

function addTooltip(value, metadata, record, rowIndex, colIndex, store) {
	if (record.data.name == '') {
		return '<img src="../image/waitingPerfect.png" /><font color="#1900d8" size=2>������</font>';
	} else {
		return '<img src="../image/alreadyPerfect.png" /><font color="#000" size=2>������</font>';
	}
	return value;
}

function addTooltipImmnue(value, metadata, record, rowIndex, colIndex, store) {
	if (record.data.vaccineImmune == null) {
		return '<img src="../image/waitingPerfect.png" /><font color="#1900d8" size=2>δ����</font>';
	} else {
		return '<img src="../image/alreadyPerfect.png" /><font color="#000" size=2>�ѽ���</font>';
	}
	return value;
}
