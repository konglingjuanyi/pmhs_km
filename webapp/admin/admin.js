ModuleMgr = {};
Ext.ns('App','App.mainframe');
Ext.override(Ext.form.Field,{
	destroy:function(){
		Ext.form.Field.superclass.destroy.call(this);
		if(this.isFormField){
			if(this.el){
   			  Ext.Element.uncache(this.container);
   			  delete this.container.dom;
			  //delete this.el.dom;
			}
		}
		
		
	}
});
Ext.override(Ext.Panel,{
	beforeDestroy:function(){
	   if(this.header) {//remove header's listeners.
            this.header.removeAllListeners();
            if (this.headerAsText){
                Ext.Element.uncache(this.header.child('span'));
            }
        }
//^^^^^^^^^^^^^^^ add by guig
        Ext.Element.uncache(
            this.header,
            this.tbar,
            this.bbar,
            this.footer,
            this.body
            ,this.bwrap //add by guig
        );
        if(this.tools){
            for(var k in this.tools){
                Ext.destroy(this.tools[k]);
            }
        }
        if(this.innerCt){
        	Ext.Element.uncache(this.innerCt);
        }
        if(this.buttons){
        	var len = this.buttons.length;
            for(var i=0;i<len;i++){
                this.buttons[i].destroy();
            }
        }
        Ext.destroy(
            this.topToolbar,
            this.bottomToolbar
        );
        Ext.Panel.superclass.beforeDestroy.call(this);
        if(this.footer){
        	this.footer.removeAllListeners();
        	this.footer.remove();
        	delete this.footer.dom;
        }
   
       
	},
	onDestroy:function(){
		Ext.Panel.superclass.onDestroy.call(this);
		if(this.bwrap && this.bwrap.dom){
          this.bwrap.remove();
          this.bwrap=null;
        }
	}
});
Ext.override(Ext.Button,{
	beforeDestroy: function(){
    	if(this.rendered){
	        var btn = this.el.child(this.buttonSelector);
	        if(btn){
                Ext.Element.uncache(btn);
                if(this.tooltip){
                    if(typeof this.tooltip == 'object'){
                        Ext.QuickTips.unregister(btn);
                    }
                }
	            btn.removeAllListeners();
	        }
	    }
        if(this.menu){
            Ext.destroy(this.menu);
        }
    },
    destroy:function(){
    	Ext.Button.superclass.destroy.call(this);
    	if(this.container){
    		Ext.Element.uncache(this.container);
    		delete this.container;
    		
    	}
    	
    	
    }
});
Ext.override(Ext.form.DateField,{
	beforeDestroy:function(){
	  if(this.menu){
	  	this.menu.hide();
	  } 
	  Ext.Element.uncache(this.container);
	  Ext.Element.uncache(this);
	},
	onDestroy:function(){
		if(this.menu){
		  Ext.destroy(this.menu.picker.mbtn,this.menu.picker.todayBtn);
	      ul = this.menu.ul;
	    }
	    this.container.remove();
	  //if(App.DateField.superclass)
		//	App.DateField.superclass.onDestroy.call(this);
		if(this.trigger){
	    	this.trigger.removeAllListeners();
 	  		this.trigger.dom=null;
 	  		this.wrap.dom=null;
 	  		delete this.trigger.dom;	
 	  		if(this.menu){
 	  		 delete this.menu.picker.cells.el.dom;
 	  		 delete this.menu.picker.el.dom;
 	  		 delete this.menu.ul.dom;
 	  		 delete this.menu.el.dom;
 	  		}
 	  		
 	  		delete this.wrap.dom;
 	  		delete this.trigger.dom;
	    }
		if(this.menu){
			
        	if(this.menu.picker.cells.elements){
	        	len =this.menu.picker.cells.elements.length;
	        	for(var i=0;i<len;i++){
	        		delete this.menu.picker.cells.elements[i];
	        	}
	        	delete this.menu.picker.cells.elements;
        	}
            len = this.menu.picker.textNodes.length;
            for(var j=0;j<len;j++){
	        		delete this.menu.picker.textNodes[j];
	       	}
	       	if(this.menu.picker.mpMonths){
		       	len = this.menu.picker.mpMonths.elements.length;
		       	for(var k=0;k<len;k++){
		       		delete this.menu.picker.mpMonths.elements[k];
		       	}
		       	len = this.menu.picker.mpYears.elements.length;
		       	for(var p=0;p<len;p++){
		       		delete this.menu.picker.mpYears.elements[p];
		       	}
	       	}
	       	var picker = this.menu.picker;
	      	Ext.Element.uncache(ul);
	      	Ext.Element.uncache(this.menu.focusEl);
        	delete this.menu.el.dom;
        	delete picker.todayKeyListener.el.dom;
        	delete picker.leftcr.el.dom;
        	delete picker.rightcr.el.dom;
        	delete this.menu.focusEl.dom;
        	delete picker.todayBtn.el.dom;
        	delete picker.mbtn.el.dom;
        	delete picker.todayBtn.el.dom;
        	if(picker.mbtn.container){
        	 delete picker.mbtn.container.dom;
        	}
        	delete picker.container.dom;
        	delete picker.monthPicker.dom;
        	delete this.menu.keyNav.el.dom;
		   
        }
	}
}
);
Ext.override(Ext.form.TriggerField,{
	 onDestroy : function(){
	 	
        if(this.trigger && this.trigger.dom){
        	//必须先删除此事件，否则控件销毁后还会执行triggerBlur事件导致JS报错
        	
		    Ext.get(Ext.isIE ? document.body : document).un("mousedown", this.mimicBlur,this);
		   	Ext.Element.uncache(this.trigger);
            this.trigger.removeAllListeners();
            this.trigger.remove();
            delete this.trigger.dom;
        }
        if(this.wrap && this.wrap.dom){
        	this.wrap.removeClass('x-trigger-wrap-focus');
        	Ext.Element.uncache(this.wrap);
            this.wrap.remove();
            //delete this.wrap.dom;
        }
        Ext.Element.uncache(this.el);
        Ext.form.TriggerField.superclass.onDestroy.call(this);
        
    }
});
App.PagingToolbar = function(config) {
	App.PagingToolbar.superclass.constructor.call(this,Ext.apply(config));
};
/*
 * 分页工具条，增加释放内存的代码
 */
Ext.extend(App.PagingToolbar, Ext.PagingToolbar, {
   beforeDestroy:function(){
   		if(this.items && this.items.length){
	      var len = this.items.length;
	      for(var i=0;i<len;i++){
	      	if(this.items.items[i].destroy){
	      	   this.items.items[i].destroy();
	      	}
	      }
	    }
      App.PagingToolbar.superclass.beforeDestroy.call(this);	
    },
	destroy : function(){
		
        if(this.fireEvent("beforedestroy", this) !== false){
        	
            this.beforeDestroy();
            var len =this.items.items.length;
            if(this.rendered && !Ext.isIE){//if is ie then do this follow! //change by guig
                this.el.removeAllListeners();
                this.el.remove();
                if(this.actionMode == "container"){
                    this.container.remove();
                }
            }
            this.onDestroy();
            Ext.ComponentMgr.unregister(this);
            this.fireEvent("destroy", this);
            this.purgeListeners();
            if(this.rendered && Ext.isIE){
                this.el.removeAllListeners();
                this.el.remove();
                delete this.el.dom;
                delete this.afterTextEl.el;
                delete this.container.dom;
                delete this.field.dom;
                delete this.first.el.dom;
                delete this.last.el.dom;
                delete this.next.el.dom;
                delete this.prev.el.dom;
                delete this.tr;
                for(i=0;i<len  ;i++){
                	delete this.items.items[i].el;
                	if(this.items.items[i].container){
                	 delete this.items.items[i].container.dom;
                	 
                	}
                	if(this.items.items[i].td){
				     delete this.items.items[i].td;
			     	}
                }
                if(this.actionMode == "container"){
                    this.container.remove();
                }
           }
	       if (this._parentDivForAutoEl) {//remove the parent div for autoEl
                Ext.removeNode(this._parentDivForAutoEl);
                this._parentDivForAutoEl = null;
            }

        }
    }
});
Ext.override(Ext.form.BasicForm,{
	destroy: function() {
		//改变了BasicForm中的销毁顺序，先销毁ITEMS，此tems里的控件类型都是field的
        this.items.each(function(f){
            Ext.destroy(f);
          
        });
        //放在FormPanel中的button和label不能自动销毁，只能手动 
        //以下是销毁按钮
        if( this.el && this.el.dom && this.el.dom.length&& this.el.dom.length >0){
        	var btn;
        	while(this.el.dom[0] && this.el.dom[0].nodeName =='BUTTON'){
        		btn = Ext.getCmp(this.el.dom[0].parentNode.parentNode.parentNode.parentNode.parentNode.id);
        		if(btn){
        			btn.destroy();
        			delete btn.el;
        		}
        		
        	}
        }
        
        //以下是销毁label
        
        if(this.el && this.el.dom){
	        var labels = this.el.dom.getElementsByTagName("label");
	        var len = labels.length;
	        if(len >0){
	        	for(var i=0;i<len;i++){
	        	   if(labels[i] && labels[i].id !=""){
	        	   	 var com = Ext.getCmp(labels[i].id);
	        	   	 if(com){
	        	   	 	 Ext.Element.uncache(com.el);
	        	   	 	 com.el.removeAllListeners();
	                     com.el.remove();
	                     delete com.el;
	        	   	 }
	        	   }	
	        	}
	        }
        }
      
        if(this.el && this.el.dom){
        	Ext.Element.uncache(this.el);
			this.el.removeAllListeners();
			this.el.remove();
        }
		this.purgeListeners();
	}
});
Ext.override(Ext.grid.GridPanel,{
	beforeDestroy:function(){
	    var reader = this.store.reader;
	    if(reader.jsonData){
          reader.getRoot =null;
	      reader.getTotal =null;
	      reader.getId = null;
	      reader.getJsonAccessor =null;
        }
		//清除grid的模板产生的动态eval代码
		var tpl=this.view.templates;
		tpl.body.compiled=null;
		tpl.cell.compiled=null;
		tpl.hcell.compiled=null;
		tpl.header.compiled=null;
		tpl.master.compiled=null;
		tpl.row.compiled=null;
		if(this.plugins && this.plugins.length >0 && this.plugins[0].cellTpl){
			this.plugins[0].cellTpl.compiled=null;
			this.plugins[0].rowTpl.compiled=null;
			this.store.un('add', this.plugins[0].refreshSummary, this);
		    this.store.un('remove', this.plugins[0].refreshSummary, this);
		    this.store.un('clear', this.plugins[0].refreshSummary, this);
		}
        if(this.buttons){
        	var len = this.buttons.length;
            for(var i=0;i<len;i++){
                this.buttons[i].destroy();
                if(this.buttons[i].container){
                 delete this.buttons[i].container.dom;
                }
                delete this.buttons[i].el.dom;
            }
            this.buttons = null;
        }      
		Ext.grid.GridPanel.superclass.beforeDestroy.call(this);
	},
	onDestroy : function(){
        if(this.rendered){
            if(this.loadMask){
                this.loadMask.destroy();
            }
            var c = this.body;
            c.removeAllListeners();
            this.view.destroy();
           
        }
        this.colModel.purgeListeners();
       	var view=this.view;
    	view.resizeProxy.remove();
    	delete view.resizeProxy.dom;
    	view.resizeMarker.remove();
    	delete view.resizeMarker.dom;
    	view.focusEl.remove();
    	view.focusEl.dom = null;
    	view.mainBody.remove();
    	view.mainBody.dom = null;
    	view.scroller.remove();
    	view.scroller.dom = null;
    	Ext.removeNode(view.innerHd);
    	delete view.innerHd;
    	view.mainHd.remove();
    	view.mainHd.dom = null;
    	view.mainWrap.remove();
    	view.mainWrap.dom = null;
    	
    	delete view.focusEl.dom;
    	delete view.innerHd;
    	delete view.mainBody.dom;
    	delete view.scroller.dom;
    	delete view.mainHd.dom;
    	delete view.mainWrap.dom;
		delete view.el.dom;
		delete this.container.dom;
		delete this.body.dom;
		delete this.bwrap.dom;
		if(this.view.summary){
			this.view.summary.remove();
			delete this.view.summary.dom;
		}
		if(this.view.summaryWrap){
			this.view.summaryWrap.remove();
			delete this.view.summaryWrap.dom;
		}
    }
});
App.TabPagePanel=Ext.extend(Ext.Panel, {
    closable: true,
    autoScroll:true,
    destroy :function(){
    
    App.TabPagePanel.superclass.destroy.call(this);
    	if(!this || !this.items || !this.items.items || !this.items.items.length){
    		return;
    	}
     	var len=this.items.items.length;
    	var items=this.items.items;
    	var bar;
    	for(var i=0;i<len;i++){
			if(items[i].items){
				var citems = items[i].items.items;
				for(var j=0;j<citems.length;j++){
	          	 citems[j].body.dom=null;	
	             citems[j].el.dom=null;
	             delete citems[j].el.dom;
	          	}
	          	if(citems[0] && citems[0].container){
	              citems[0].container.dom=null;
	     	      delete citems[0].container.dom; 
	          	}

			}
			items[i].body.dom=null;
	        items[i].el.dom=null;
	        delete items[i].body.dom;
            delete items[i].el.dom;
       
    	}
    	
	    this.el.dom=null;
	    this.body.dom=null;
	    delete this.el.dom;
	    delete this.body.dom;
	    var jss = document.getElementsByTagName("script");
	    var hd = document.getElementsByTagName("head")[0];
	    if(this.wins){
	    	for(var p=0;p<this.wins.length;p++){
	    		if(this.wins[p]){
	    		 this.wins[p].destroy();
	    		}
	    	}
	    }
	    var jsArray = this.jscript.split(","); 
	    var nodes = [];
	    for(var i=0;i<jss.length;i++){
	       for(j=0;j<jsArray.length;j++){
	     	if(jss[i].src.indexOf(jsArray[j]) >= 0){
	     		 nodes.push(jss[i]);
	       		
	     	}
	       }
	     }
	     for(var i=0;i<nodes.length;i++){
	     	hd.removeChild(nodes[i]);
	     }
    }  
    ,
    beforeDestroy:function(){
      
    	if(this.header) {
            this.header.removeAllListeners();
            if (this.headerAsText){
                Ext.Element.uncache(this.header.child('span'));
            }
        }
    

        Ext.Element.uncache(
            this.header,
            this.tbar,
            this.bbar,
            this.footer,
            this.body
            ,this.bwrap 
        );
             
        if(this.tools){
            for(var k in this.tools){
                Ext.destroy(this.tools[k]);
            }
        }
        if(this.buttons){
            for(var b in this.buttons){
                Ext.destroy(this.buttons[b]);
            }
        }
      
        if(this.items && this.items.items && this.items.items.dom && this.items.items.dom.id){
            Ext.destroy.apply(Ext, this.items.items);
        }
        if(this.monitorResize){
            Ext.EventManager.removeResizeListener(this.doLayout, this);
        }
        if (this.layout && this.layout.destroy) {
            this.layout.destroy();
            if(this.layout.innerCt){
              delete this.layout.innerCt.dom;
            }
        }
        if(this.bwrap){
          this.bwrap.remove();
          delete this.bwrap.dom;
          delete this.body.dom;
         
        }
        this.itemTabStrip = null;
    }
});



var navigation = new Ext.Panel({
//	width : 1000,
//	height : 400,
	bodyBorder : false,
	html : '<div id="navigateContainer" onclick="hideNavigageMenu()" class="navigateContainer">'+
			'<div id="hud" class="formError userformError navigageMenu" style="position:absolute; opacity: 0.9; display:none">'
		    + '<div class="formErrorContent">'
		    +   ' * This field is required<br>'
		    +   ' * No special caracters allowed<br>'
		    + '</div>'
		    + '<div class="formErrorArrow">'
		    + '      <div class="line10"><!-- --></div> '
		    + '      <div class="line9"><!-- --></div>'
		    + '      <div class="line8"><!-- --></div>'
		    + '      <div class="line7"><!-- --></div>'
		    + '      <div class="line6"><!-- --></div>'
		    + '      <div class="line5"><!-- --></div>'
		    + '      <div class="line4"><!-- --></div>'
		    + '      <div class="line3"><!-- --></div>'
		    + '      <div class="line2"><!-- --></div>'
		    + '      <div class="line1"><!-- --></div>'
		    + '  </div> </div>' +
		    '<img src="jk.jpg" border="0" usemap="#Map" class="menuImage" />' +
				'<map name="Map" id="Map">' +
				  '<area shape="circle" coords="128,356,65" href="#" onmouseover="showMenu(7,this)"/>' +
				  '<area shape="circle" coords="311,539,62" href="#" onmouseover="showMenu(6,this)" />' +
				  '<area shape="circle" coords="512,562,62" href="#" onmouseover="showMenu(5,this)" />' +
				  '<area shape="circle" coords="664,428,62" href="#" onmouseover="showMenu(4,this)" />' +
				  '<area shape="circle" coords="639,222,62" href="#" onmouseover="showMenu(3,this)" />' +
				  '<area shape="circle" coords="445,129,63" href="#" onmouseover="showMenu(2,this)" />' +
				'<area shape="circle" coords="257,198,62" href="#" onmouseover="showMenu(1,this)" />' +
			'</map></div>'
});

App.mainframe.MainPanel = function() {
	App.mainframe.MainPanel.superclass.constructor.call(this, {
		 region : 'center',
  id:'tabbody',
  activeTab : 0,
  frame : true,
  autoScroll : true,
  enableTabScroll: true,
  plugins : new Ext.ux.TabCloseMenu(),
  items : [ {
    contentEl : 'center2',
    title : '昆明市国家公共卫生服务管理系统',
    closable : false,
    autoScroll : true,
    items : [navigation]
  } ]
	});
};
Ext.extend(App.mainframe.MainPanel, Ext.TabPanel, {
	register:function(mod){
		var tab = Ext.getCmp(this.tabid);
	  tab.add(mod);
	  if (tab.layout.innerCt) {
			tab.layout.innerCt.dom.innerHTML = null;
			delete tab.layout.innerCt;
		}
	  //debugger;
	  tab.doLayout();
	  
  }
})

/**
 * 每次加载js模块时，调用这个函数，增加tab
 */


var taskCheckSession;
var menu_tree;
function checkSession() {
  UserService.getCurrentUser(
    {
      callback: function(data) {
        if ( typeof data == 'undefined' || data == null ) {
          Ext.Msg.alert('', '登录状态失效，请退出重新登录！', logout);
        }
      },
      timeout: 120000,
      errorHandler: function(msg) {
//        console.log(msg);
        Ext.Msg.alert('', '通讯中断，请退出重新登录！', logout);
      }
    }
  );
};
function stopTask() {
  Ext.TaskMgr.stop(taskCheckSession);
};
function logout() {
  stopTask();
  window.location = "/j_spring_security_logout";
}

//待办事宜消息通知
var changeid = 0;
function changeColor(){
	if(changeid % 2 == 0){
		$('.rc_box2').css('background-color','#FF7F00');
		$('.rc_box3').css('background-color','#FF7F00');
		$('.ov1').css('border-bottom-color','#FF7F10');
		$('.ov2').css('border-bottom-color','#FF7F00');
		$('.rc_box3').css('color','#FFF');
	}else{
		$('.rc_box2').css('background-color','#f3f3f3');
		$('.rc_box3').css('background-color','#f3f3f3');
		$('.ov1').css('border-bottom-color','#ddd');
		$('.ov2').css('border-bottom-color','#f3f3f3');
		$('.rc_box3').css('color','#000');
	}
	changeid = changeid + 1;
}
function redderToPage(){
	clearInterval(changeColor);
	$('.rc_box1').hide();
	var id = "/js/app/waitingthing.js";
	var tab = null;
    var items = tabPanel.find('id', id);
    if (items.length > 0) {
    	tab = items[0];
    }
    if (tab) {
    	tabPanel.setActiveTab(tab);
    }else{
    	var autoLoad = {
    		url : "/autoload.jsp?jsurl=" + id,
    		scripts : true,
    		nocache : true,
    		border : false
    	};
    	tab = new App.TabPagePanel({
    		id : id,
    		autoLoad : autoLoad,
    		title : '待办事宜',
    		autoScroll : true,
    		closable : true,
    		border : false
    	});
    	var p = tabPanel.add(tab);
    	tabPanel.tabid = id;
    	tab.jscript=id;
    	tabPanel.activate(p);
    }
}
var tabPanel;

Ext.onReady(function() {
	Ext.QuickTips.init();
	waitingThingService.isNewWaitingThing(function(data){
		if(!data){
			$('.rc_box1').hide();
		}else{
			$('.rc_box1').show();
			//待办事宜
			$('.rc_box1').click(function(){
				redderToPage();
			});
			setInterval(changeColor,1000);
		}
	});
	
	tabPanel = new App.mainframe.MainPanel();
	tabPanel.on("tabchange", function(tabs, tab) {
		tabPanel.tabid = tab.id;
	});
	
	init = function(data) {
  /* data的格式样例
  var json = [ {
    "text" : "登记信息管理",
    "id" : 'regMgr',
    "leaf" : false,
    "cls" : "folder",
    "children" : [ {
      "text" : "个人预登记信息审核",
      "id" : '/js/app/ireg.js',
      "leaf" : true,
      "cls" : "file"
    }, {
      "text" : "个人预登记信息查询",
      "id" : 'individualQry.js',
      "leaf" : true,
      "cls" : "file"
    } ]
  } ];
  */
  menu_tree = new Ext.tree.TreePanel( {
    animate : true,
    enableDD : false,
    icon : 'next.gif',
    loader : new Ext.tree.TreeLoader(),
//    lines : false,
    autoScroll : true,
    border : false,
    root : new Ext.tree.AsyncTreeNode( {
      text : 'Autos',
      draggable : false,
      id : 'source',
      icon : 'next.gif',
      children : data
    }),
    rootVisible : false
  });

  menu_tree.on( {
    click : {
      stopEvent : true,
      fn : function(n, e) {
        e.stopEvent();
        if (n.isLeaf()) {
          if (n.id.indexOf('.html') != -1) {
            var iframeId = n.text + '_' + n.id;
//            alert(iframeId);
            if (!Ext.get(iframeId)) {
              var newFrame = tabPanel.add( {
                xtype : 'iframepanel',
                id : iframeId,
                //title : n.text,
                loadMask : true,
                // frameConfig: {{autoCreate:{id: 'frame1'}}, //optional, give
                // the frame your own id and name
                defaultSrc : n.id,
                listeners : {
                  domready : function(frame) { // only raised for "same-origin"
                                                // documents
                    // Set the tab Title to the Document Title
                    var doc = frame.getDocument();
                    if (doc) {
                      frame.ownerCt.setTitle(doc.title);
                    }
                  }
                }
              });
              tabPanel.doLayout(); // if TabPanel is already rendered
              tabPanel.setActiveTab(newFrame);
            }

          } else {
//            console.log("loading " + n.id);
            var tab = null;
            var items = tabPanel.find('id', n.id);
            if (items.length > 0) {
              tab = items[0];
            }
            if (tab) {
              tabPanel.setActiveTab(tab);
            } else {
            	//debugger;
            	var autoLoad = {
								url : "/autoload.jsp?jsurl="+n.id,
								scripts : true,
								nocache : true,
								border : false
							};
							tab = new App.TabPagePanel({
								id : n.id,
								autoLoad : autoLoad,
								title : n.text,
								autoScroll : true,
								closable : true,
								//layout : "column",
								border : false
							});
							var p = tabPanel.add(tab);
							tabPanel.tabid = n.id;
						  tab.jscript=n.id;
			       	tabPanel.activate(p);
              /*
              new Ext.ux.JSLoader( {
                url : n.id,
                onError : function(options, e) {
                  console.log(e);
                  alert(e.description);
                  alert('模块加载失败[' + n.id + ']');
                }
              });*/
            }
          }
        }
      }
    }
  });

 
  Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
  var viewport = null;  
  
  UserMenuTreeService.getUserCatInfo(function(data){
//	  console.log(data);
	  var items = [{title : '功能模块',autoScroll : true,border : false,iconCls : 'settings'}];
	  if(data != null){
		  var catCount = 0;
		  var len = data.length;
		  for(var i = 0;i<len;i++){
			  var catName = data[i].category.name;
			  var catId = data[i].category.id;
			  var cls = data[i].category.clsSetting;
			  var modItems = '<div><ul class="menu">';
			  var modCount = 0;
			  for(var j = i;j<len;j++){
				  var modCatId = data[j].module.categoryId;
				  var modName = data[j].module.name;
				  var modId = data[j].module.id;
				  var url = data[j].module.url;
				  var modDefaultCls = 'settingsModDefault publicSettingMod';
				  var modCls = data[j].module.clsSetting;
				  if(modCls != null && modCls != ''){
					  modDefaultCls = modCls;
				  }
				  if(catId == modCatId){
					  modItems = modItems + '<li class="' + modDefaultCls + '"><a class="menubar" onclick="toUrl(\'' + modId 
					  	+ '\',\'' + modName + '\',\'' + url + '\')" id="\'' + url + '\'">' + modName + '</a></li>';
					  i++;
				  }
			  }
			  modItems = modItems + '</ul></div>';
			  var itemsPanel = new Ext.Panel({
				  bodyBorder : false,
				  html : modItems
			  });
			  var settings = 'settings';
			  
			  if(cls != null && cls != ''){
				  settings = cls;
			  }
			  var isLasted = true;
			  if(i == len)
				  isLasted = false;
			  items[catCount] = {title : catName,collapsed:isLasted,autoScroll : true,border : false,iconCls : settings,
					  items : [itemsPanel],baseCls:"font=宋体"};
			  catCount++;
			  i--;
			  
		  }
	  }
//	  var items = [{title : data[0].category.name,autoScroll : true,border : false,iconCls : 'settings'}];
//	  items[1] = {title : data[0].category.name,autoScroll : true,border : false,iconCls : 'settings'};
	  
	  viewport = new Ext.Viewport( {
		    layout : 'border',
		    items : [ new Ext.BoxComponent( { // raw
		      region : 'north',
		      el : 'north',
		      height : 32
		    }), {
		      region : 'west',
		      id : 'west-panel',
		      title : '菜单',
		      split : true,
		      width : 200,
		      minSize : 175,
		      maxSize : 400,
		      collapseMode:'mini',
		      collapsible : true,
		      margins : '0 0 0 5',
		      layout : 'accordion',
		      
		      margins:{left: 10, top: 0, right: 0, bottom: 0},
		      layoutConfig : {
//		        animate : true,
		    	  titleCollapse: true
//		    	  hideCollapseTool : true,
//		    	  collapseFirst : true
		      },
		      items : items
		    }, tabPanel ]
		  });
  });
}
  Ext.BLANK_IMAGE_URL = '/resources/images/default/s.gif';

  var onGotMenuData = function(data) {
    if (data != null && typeof data == 'object') {
      // console.debug(data);
      init(data);
    } else {
      alert("Loading user menu failed.");
    }
  }

  UserMenuTreeService.genUserMenuTree(onGotMenuData);

  var showUserInfo = function(data) {
//    console.log(data);
    if ( ! data ) {
      logout();
      return;
    } else {
      Ext.tf.currentUser = data;
      Ext.get('_user_info').dom.innerHTML = "用户：" + data.taxempname;
    }
  }
  UserService.getCurrentUser(showUserInfo);

  //定时与server通讯，保存永久session哈 :0)
  taskCheckSession = {
      run: checkSession,//执行任务时执行的函数
      interval: 60*1000//任务间隔，毫秒为单位
  }
  Ext.TaskMgr.start(taskCheckSession);//初始化时就启动任务
});


ModuleMgr.register = function(mod) {
	
	/*
	var tab = Ext.getCmp(tabPanel.tabid);
	tab.add(mod);
	tab.doLayout();
	*/
	if(mod.title)
	mod.title = null;
	if(mod.border)
	mod.border=false;
	//mod.height  = '100%';
  //mod.width  = Ext.getCmp('tabbody').getActiveTab().getInnerWidth();
  mod.height  = Ext.getCmp('tabbody').getActiveTab().getInnerHeight();
  //mod.width = '99%';
		Ext.getCmp("tabbody").register(mod);
	//tabPanel.setActiveTab(tab);
  //var newCmp = tabPanel.add(mod);
  //debugger;
  // newCmp.autoScroll = true,
  //tabPanel.doLayout();
  //tabPanel.setActiveTab(newCmp);
  //return newCmp;
}

var treeArray = new Array();
var count = 0;
function findchildnode(node){
    for(var i=0;i<node.length;i++){  //从节点中取出子节点依次遍历
        var rootnode = node[i];
        rootnode.expand(true);
//        alert(rootnode.text + "---" + rootnode.id  + "---" + rootnode.childNodes.length);
        if(rootnode.childNodes.length>0){  //判断子节点下是否存在子节点，个人觉得判断是否leaf不太合理，因为有时候不是leaf的节点也可能没有子节点
//            findchildnode(rootnode);    //如果存在子节点  递归
        	for(var j = 0;j < rootnode.childNodes.length;j++){
        		var leafNode = rootnode.childNodes[j];
        		if(leafNode.isLeaf()){
        			treeArray[count] = leafNode.id;
        		}else{
        			findchildnode(leafNode);
        		}
        		count++;
        	}
        }
        rootnode.collapse();
    }
}

function idIsExists(id){
	var flag = false;
	for(var i = 0;i < treeArray.length;i++){
		if(treeArray[i] == id){
			flag = true;
			break;
		}
	}
	return flag;
}

function showMenu(type,val){
	var $thisNavigate = $(val);
	var pix = $thisNavigate.attr('coords').split(',');
	var pos = $thisNavigate.position();
	pos.left = pix[0];
	pos.top = pix[1];
    $(".navigageMenu").css({ top: pos.top - (130 + navigateContainer.scrollTop), left: pos.left - (70 + navigateContainer.scrollLeft)});
    $('.navigageMenu').css('display','inline');
    var $html = '';
    if(type == 1){
    	$html = '<a href="#" onclick="navigatorAction(\'/js/app/firstvisit.js\',\'第一次产前随访记录\')">第1次产前随访</a><br/>'+
    		'<a href="#" onclick="navigatorAction(\'/js/app/VisitBeforeBorn.js\',\'第2至5次产前随访记录\')">第2至5次产前随访</a><br/>'+
    		'<a href="#" onclick="navigatorAction(\'/js/app/VisitAfterBorn.js\',\'产后访视记录\')">产后访视</a><br/>'+
    		'<a href="#" onclick="navigatorAction(\'/js/app/VisitAfterBorn42.js\',\'产后42天健康检查记录\')">产后42天健康检查</a>';
    }else if(type == 2){
    	$html = '<a href="#" onclick="navigatorAction(\'/js/app/useCertificate.js\',\'出生医学证明使用\')">出生医学证明使用</a><br/>' +
    	'<a href="#" onclick="navigatorAction(\'/js/app/childfile.js\',\'儿童健康档案管理\')">儿童健康档案</a>';
    }else if(type == 3){
    	$html = '<a href="#" onclick="navigatorAction(\'/js/app/babyvisit.js\',\'新生儿家庭访视记录\')">新生儿家庭访视</a><br/>'+
			'<a href="#" onclick="navigatorAction(\'/js/app/childexam1.js\',\'1岁以内儿童体检记录\')">1岁以内儿童体检</a><br/>'+
			'<a href="#" onclick="navigatorAction(\'/js/app/childexam2.js\',\'1至2岁儿童体检记录\')">1至2岁儿童体检</a><br/>'+
			'<a href="#" onclick="navigatorAction(\'/js/app/childexam36.js\',\'3~6岁儿童体检记录\')">3~6岁儿童体检</a>';
    }else if(type == 4){
    	$html = '<a href="#" onclick="navigatorAction(\'/js/app/medicalexam.js\',\'健康体检记录\')">健康体检</a><br/>'+
		'<a href="#" onclick="navigatorAction(\'/js/app/hyp_visit.js\',\'高血压患者随访\')">高血压患者随访</a><br/>'+
		'<a href="#" onclick="navigatorAction(\'/js/app/t2dm_visit.js\',\'2型糖尿病患者随访\')">2型糖尿病患者随访</a><br/>'+
		'<a href="#" onclick="navigatorAction(\'/js/app/furious_visit.js\',\'重性精神疾病患者随访\')">重性精神疾病患者随访</a>';
    }else if(type == 7){
    	$html = '<a href="#" onclick="navigatorAction(\'/js/app/BusinessDataForPerson.js\',\'个人健康记录索引\')">个人健康记录索引</a>';
    }else{
    	$html = '<font color="#FFF">暂无</font>';
    }
    $('.formErrorContent').html($html);
}

function hideNavigageMenu(){
	$('.navigageMenu').css('display','none');
}

//导航图
function navigatorAction(id,title){
//	findchildnode(this.menu_tree.getRootNode().childNodes);
	var flag = false;
	
	$('li a').each(function(){
		var treeId = $(this).attr('id');
		treeId = treeId.substring(1,treeId.length - 1);
//		console.log(treeId);
		if(id == treeId)
			flag = true;
	});
	if(flag){  
//		 console.log("loading " + id);
	     var tab = null;
	     var items = tabPanel.find('id', id);
	     if (items.length > 0) {
	    	 tab = items[0];
	     }
	     if (tab) {
	    	 tabPanel.setActiveTab(tab);
	     } else {
	    	 var autoLoad = {
	    			 url : "/autoload.jsp?jsurl=" + id,
	    			 scripts : true,
	    			 nocache : true,
	    			 border : false
	    	 	};
	    	 tab = new App.TabPagePanel({
				id : id,
				autoLoad : autoLoad,
				title : title,
				autoScroll : true,
				closable : true,
				border : false
			});
			var p = tabPanel.add(tab);
			tabPanel.tabid = id;
			tab.jscript=id;
			tabPanel.activate(p);
	     }
	}else{
		Ext.Msg.show({
			title : '警告',
			msg : '你没有权限访问！',
			buttons : Ext.Msg.OK,
			icon: Ext.MessageBox.WARNING,
			animEl: 'elId'
		});
	}
}

function showError(msg){
	Ext.Msg.show({
		title : '错误',
		msg : msg,
		buttons : Ext.Msg.OK,
		animEl: 'elId',
		icon: Ext.MessageBox.ERROR
	});
}

function toUrl(modId,modName,url){
    if (url.indexOf('.html') != -1) {
      var iframeId = modName + '_' + url;
//      alert(iframeId);
      if (!Ext.get(iframeId)) {
        var newFrame = tabPanel.add( {
          xtype : 'iframepanel',
          id : iframeId,
          //title : n.text,
          loadMask : true,
          // frameConfig: {{autoCreate:{id: 'frame1'}}, //optional, give
          // the frame your own id and name
          defaultSrc : url,
          listeners : {
            domready : function(frame) { // only raised for "same-origin"
                                          // documents
              // Set the tab Title to the Document Title
              var doc = frame.getDocument();
              if (doc) {
                frame.ownerCt.setTitle(doc.title);
              }
            }
          }
        });
        tabPanel.doLayout(); // if TabPanel is already rendered
        tabPanel.setActiveTab(newFrame);
        
      }

    } else {
//      console.log("loading " + url);
      var tab = null;
      var items = tabPanel.find('id', url);
      if (items.length > 0) {
        tab = items[0];
      }
      if (tab) {
        tabPanel.setActiveTab(tab);
      } else {
      	//debugger;
      	var autoLoad = {
							url : "/autoload.jsp?jsurl="+url,
							scripts : true,
							nocache : true,
							border : false
						};
						tab = new App.TabPagePanel({
							id : url,
							autoLoad : autoLoad,
							title : modName,
							autoScroll : true,
							closable : true,
							//layout : "column",
							border : false
						});
						var p = tabPanel.add(tab);
						tabPanel.tabid = url;
					  tab.jscript=url;
		       	tabPanel.activate(p);
        /*
        new Ext.ux.JSLoader( {
          url : n.id,
          onError : function(options, e) {
            console.log(e);
            alert(e.description);
            alert('模块加载失败[' + n.id + ']');
          }
        });*/
      }
    }
}

function modifyPassword(){
	var panel = new Ext.form.FormPanel({
		frame : true,
		width : "300px",
		height: "130px",
		labelWidth : 55,
		labelAlign : 'right',
		items : [{
			xtype : 'textfield',
			inputType : 'password',
			name : 'oldPassword',
			fieldLabel : '旧密码',
			id : 'oldPassword',
			width : 200
		},{
			xtype : 'textfield',
			inputType : 'password',
			name : 'newPassword',
			fieldLabel : '新密码',
			id : 'newPassword',
			width : 200
		},{
			xtype : 'textfield',
			inputType : 'password', 
			name : 'sureNewPassword',
			fieldLabel : '确认密码',
			id : 'sureNewPassword',
			width : 200
		}],
		buttons : [{
			text : '修改',
			handler : function(){
				var oldPassword = Ext.getDom('oldPassword').value;
				var newPassword = Ext.getDom('newPassword').value;
				var sureNewPassword = Ext.getDom('sureNewPassword').value;
				if(newPassword != sureNewPassword){
					showError('新输入的两次密码不一致！');
				}else{
					UserService.modifyPassword(oldPassword,newPassword,function(data){
						if(data){
							Ext.Msg.show({
								title : '错误',
								msg : '修改成功',
								buttons : Ext.Msg.OK,
								animEl: 'elId',
								icon: Ext.MessageBox.INFO
							});
							win.close();
						}else{
							showError('旧密码错误！');
							
						}
					})
				}
			}
		},{
			text : '关闭',
			handler : function(){
				win.close();
			}
		}]
	});
	
	var win = new Ext.Window({
		height: 160,
		title : '修改密码',
		width : 300,
		draggable:false,
		resizable:false,
		modal:true,
		items : [panel]
	});
	win.show();
}