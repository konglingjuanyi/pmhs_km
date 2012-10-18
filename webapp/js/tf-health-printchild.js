Ext.ns("Ext.tf");

// /////////////
// 健康档案模板
// /////////////

function getChildPrintCfg01(data,orgmap){
	
	alert(printdata(data));
	alert(printdata(data.personalInfo));
	//1.封面(封面 封底.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"1、封面"},
		data:[	]
	}
	var i = 0 ;
	//18位编号
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(0,1),intTop:"10.26cm",intLeft:"10.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(1,1),intTop:"10.26cm",intLeft:"10.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(2,1),intTop:"10.26cm",intLeft:"10.8cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(3,1),intTop:"10.26cm",intLeft:"11.1cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(4,1),intTop:"10.26cm",intLeft:"11.4cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(5,1),intTop:"10.26cm",intLeft:"11.7cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(6,1),intTop:"10.26cm",intLeft:"12.3cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(7,1),intTop:"10.26cm",intLeft:"12.6cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(8,1),intTop:"10.26cm",intLeft:"12.9cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(9,1),intTop:"10.26cm",intLeft:"13.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(10,1),intTop:"10.26cm",intLeft:"13.8cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(11,1),intTop:"10.26cm",intLeft:"14.1cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(12,1),intTop:"10.26cm",intLeft:"14.7cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(13,1),intTop:"10.26cm",intLeft:"15.0cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(14,1),intTop:"10.26cm",intLeft:"15.3cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(15,1),intTop:"10.26cm",intLeft:"15.6cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(16,1),intTop:"10.26cm",intLeft:"15.9cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.fileNo.substr(17,1),intTop:"10.26cm",intLeft:"16.2cm",intWidth:"6cm",intHeight:"0.8cm"};
	//姓名
	retprintcfg.data[i++] = {"strContent":data.name,intTop:"15.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//性别
	retprintcfg.data[i++] = {"strContent":data.personalInfo.sex,intTop:"15.26cm",intLeft:"6.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//过敏史
	retprintcfg.data[i++] = {"strContent":data.personalInfo.Allergies,intTop:"15.26cm",intLeft:"8.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//父亲姓名
	
	//母亲姓名
	
	//建册日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.buildDate,"Y-m-d"),intTop:"18.26cm",intLeft:"12.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"16.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"16.26cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.fileNo.substr(0,6)).text,intTop:"16.26cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.township,intTop:"16.26cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.village,intTop:"16.26cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"16.26cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"17.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"17.26cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.fileNo.substr(0,6)).text,intTop:"17.26cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.township,intTop:"17.26cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.village,intTop:"17.26cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"17.26cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//辖区妇幼保健院联系电话
	retprintcfg.data[i++] = {"strContent":data.tel,intTop:"15.26cm",intLeft:"12.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	
	return retprintcfg;
}

function getChildPrintCfg02(data,orgmap){
	//2.儿童基本档案(1-2.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"2、孕妇基本档案"},
		data:[	]
	};
	var i = 0 ;
	//	出生日期
	//	出生体重
	//	出生身长
	//	Apgar评分
	//	ABO血型
	//	RH血型
	//	出生孕周
	//	孕次
	//	产次
	//	胎数
	//	分娩方式
	//	助产机构名称
	//	父亲-生育年龄
	//	民族
	//	文化程度
	//	职业
	//	母亲-生育年龄
	//	民族
	//	文化程度
	//	职业
	//	母亲孕周异常情况
	//	小儿围产期异常情况
	//	出生缺陷
	//	新生儿疾病筛查情况 
	//	家庭遗传性疾病

	return retprintcfg;
}

function getChildPrintCfg03(data,orgmap){
	//3.新生儿访视记录表-第1页(3-4.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"3、首次产前检查记录表第1页"},
		data:[	]
	};
	var i = 0 ;
	//	访视日期
	//	访视日龄
	//	听力筛查
	//	体重(公斤)
	//	身长(厘米)
	//	头围(厘米)
	//	喂养方式
	//	吃奶量(ml/次)
	//	吃奶次数(次/天)
	//	呕吐
	//	大便-性状
	//	大便-次数
	//	体温
	//	脉率
	//	呼吸频率
	//	面色
	//	黄疸部位
	//	前囟
	//	眼外观
	//	耳外观
	return retprintcfg;
}

function getChildPrintCfg04(data,orgmap){
	//4.新生儿访视记录表-第2页(5-6.jpg) 
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"4、首次产前检查记录表第2页"},
		data:[	]
	};
	var i = 0 ;
	//	鼻
	//	口腔
	//	心肺听诊
	//	腹部触诊
	//	脐带
	//	四肢活动程度
	//	颈部包块
	//	皮肤
	//	肛门
	//	外生殖器
	//	脊柱
	//	行为神经判断
	//	访视结果
	//	转诊建议
	//	指导
	//	下次随访日期
	//	随访医生签名
	return retprintcfg;
}

function getChildPrintCfg05(data,orgmap){
	//5.1岁以内儿童健康检查记录表-第1页 (5-6.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"5、首次产前检查记录表第3页"},
		data:[	]
	};
	var i = 0 ;
	//	月龄
	//	随访日期
	//	体重
	//	身长
	//	头围
	//	体格发育评价
	//	面色
	//	皮肤
	//	前囟
	//	颈部包块
	//	眼外观
	//	耳外观

	return retprintcfg;
}

function getChildPrintCfg06(data,page,row){
	//6.1岁以内儿童健康检查记录表-第2页(7-8.jpg)
	var starttop1 = 3;//第一页的起始行位置
	var starttop2 = 3;//第二页的起始行位置
	var startleft1 = 3;//第一页的起始行位置
	var startleft2 = 3;//第二页的起始行位置
	var rowheight = 0.8;//行间隔高度
	var starttop = 0; 
	var startleft = 0;
	if(page == "1"){
		starttop = starttop1;
		startleft = startleft1;
	}else{
		starttop = starttop2;
		startleft = startleft2;
	}
	
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	听力-左
	//	听力-右
	//	鼻部
	//	咽部,扁桃体
	//	口腔
	//	心肺
	//	腹部
	//	脐部
	//	四肢
	//	可疑佝偻病休征
	//	肛门/外生殖器
	//	先天性髋关节发育不良筛查结果
	//	血红蛋白值
	//	户外活动
	//	喂养方式
	return retprintcfg;
}

function getChildPrintCfg07(data){
	//7.1岁以内儿童健康检查记录表-第3页(7-8.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表-转诊信息"},
		data:[	]
	};
	var i = 0 ;
	//	吃奶量
	//	辅食添加
	//	服用维生素类
	//	发育评估
	//	随访间患病情况 
	//	体检结果
	//	转诊建议
	//	指导
	//	下次随访日期
	//	检查机构
	//	随访医生签名

	return retprintcfg;
}

function getChildPrintCfg08(data){
	//8.1-2岁儿童健康检查记录表-第1页(9-10.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"7、分娩记录打印"},
		data:[	]
	};
	var i = 0 ;
	//	月龄
	//	随访日期
	//	体重
	//	身长
	//	头围
	//	体格发育评价
	//	面色
	//	皮肤
	//	前囟
	//	颈部包块
	//	眼外观
	//	耳外观


	return retprintcfg;
}
function getChildPrintCfg09(data){
	//9.1-2岁儿童健康检查记录表-第2页(9-10.jpg)
	//alert(printdata(data));
	
	//alert("1,person   "+printdata(data.person));
	//alert("2,birthRecord  "+printdata(data.birthRecord));
	//alert("3,file   "+printdata(data.file));
	//alert("4,samTaxempcode "+printdata(data.samTaxempcode));
	//alert("5,org  "+printdata(data.org));
	//alert("6,cert  "+printdata(data.cert));
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"7、分娩记录打印-新生儿情况"},
		data:[	]
	};
	var i = 0 ;	
	//	听力-左
	//	听力-右
	//	鼻部
	//	咽部,扁桃体
	//	出牙/龋齿数(颗)
	//	心肺
	//	腹部
	//	四肢
	//	步态
	//	可疑佝偻病休征
	//	肛门/外生殖器
	//	血红蛋白值
	//	户外活动
	//	服用维生素D

	return retprintcfg;
}

function getChildPrintCfg10(data,rownum){
	//10.1-2岁儿童健康检查记录表-第3页(11-12.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	发育评估
	//	两次随访间患病情况
	//	其他
	//	体检结果
	//	转诊建议
	//	指导
	//	下次随访日期
	//	检查机构
	//	随访医生签名
	return retprintcfg;
}

function getChildPrintCfg11(data){
	//11.儿童入托儿园(所)健康检查记录表(11-12.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	检查日期
	//	年龄
	//	过敏史
	//	既往病史
	//	儿童家长确认
	//	体重
	//	身长
	//	评价
	//	皮肤
	//	眼-左
	//	眼-右
	//	视力-左
	//	视力-右
	//	耳-左
	//	耳-右
	//	口腔-牙齿数
	//	口腔-龋齿数
	//	头颅
	//	胸廓
	//	脊柱四肢
	//	咽部
	//	心肺
	//	肝脾
	//	外生殖器
	//	其他
	//	血红蛋白
	//	丙氨酸氨基转移酶
	//	其他
	//	检查结果
	//	医生意见
	//	医生签名
	//	检查单位
	//	体检日期
	return retprintcfg;
}

function getChildPrintCfg12(data){
	//12.3-6岁儿童健康检查记录表-第1页(13-14.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	月龄
	//	随访日期
	//	体重
	//	身长
	//	体格发育情况 
	//	视力
	//	听力
	//	牙数/龋齿数
	//	心肺
	//	腹部
	//	血红蛋白
	//	其他

	return retprintcfg;
}

function getChildPrintCfg13(data){
	//13.3-6岁儿童健康检查记录表-第2页(13-14.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	两次随访间患病情况
	//	转诊建议
	//	指导
	//	下次随访记录
	//	随访医生签名

	return retprintcfg;
}

function getChildPrintCfg14(data){
	//14.异常情况记录表(15-16.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//	日期
	//	异常情况记录
	//	处理意见
	//	医生签名

	return retprintcfg;
}

function getChildPrintCfg15(data){
	//15.女童年龄别体重(17-18.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//月龄/体重

	return retprintcfg;
}

function getChildPrintCfg16(data){
	//16.男童年龄别体重(17-18.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;
	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//月龄/体重
	return retprintcfg;
}
/**/
Ext.tf.HealthPrintChildPanel = Ext.extend(Ext.Panel, {
	closable : true,
	currentNode : null, // 当前选择的树节点
	layout : 'fit',
	title : '档案',
	pageSize : 20,
	recordId : 'id',
	recordPk : 'id',
	orgmap:null,//机关
	panelId : 'app.residentPanel',
	
	// height:700,
	// 是否需要在最末级才能增加？
	checkLastLevel : true,

	// 设置查询url
	queryUrl : Ext.emptyFn,
	deleteUrl : Ext.emptyFn,
	dataExportUrl : Ext.emptyFn,
	treeLoaderFn : Ext.emptyFn,
	diseaseId : null,
	visitDoctor : null,
	getAddParams : function() {
		var node = this.getTreeSelNode();
		var districtNumber = node.id;
		var param = '?districtNumber=' + districtNumber;
		return param;
	},

	// 设置查询用的类别，比如档案，高血压等。。
	queryType : 'demo',
	detailUrl : '/personalInfo.html',
	readerConfig : [],
	gridCmConfig : [],
	gridViewConfig : {},
	initComponent : function() {
		this.build();
		Ext.tf.HealthPrintPanel.superclass.initComponent.call(this);
	},

	build : function() {
//		this.tbar = this.createActions();
		this.items = [ this.createPanel() ];
	},

	/**
	 * 编辑功能
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
	 * 增加功能
	 */
	f_add : function(isSlient) {

		if (this.checkLastLevel) {
			// 判断是否是第五级别
			var node = this.getTreeSelNode();

			var level = node.attributes['data'].level;
			if (level != 5) {
				if (!isSlient) {
					Ext.Msg.alert('', '只有第五级行政区域才能增加记录！');
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
	 * 打开编辑窗口
	 */
	openWin : function(targetUrl, param) {

		var win = new Ext.Window({
			modal : true,
			title : '录入记录',
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
				msg : '请先选择一个行政区域！'
			});
		}
		;
		return selNode;
	},
	createActions : function() {
		var store = new Ext.data.SimpleStore({
			fields : [ 'type', 'display' ],
			data : [ [ 'a.name', '姓名' ], [ 'c.highRisk', '高危筛选' ],
					[ 'a.inputDate', '录入日期' ], [ 'a.lastModifyDate', '修改日期' ],
					[ 'b.birthday', '出生日期' ], [ 'a.fileNo', '档案编码' ],
					[ 'b.idnumber', '身份证号' ], [ 'b.linkman', '联系人' ],
					[ 'a.paperFileNo', '纸质档案号' ], [ 'b.workUnit', '工作单位' ] ]
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
			text : '修改',
			iconCls : 'c_edit',
			handler : this.editFn.createDelegate(this)
		});
		/*
		UserMenuTreeService.getOrgMap(function(data){
				if(data){
					this.orgmap = data;
				}
			}.createDelegate(this));
		*/
		return [
				new Ext.Button({
					text: '打印',
					iconCls: 'c_print',
					menu: new Ext.menu.Menu({
						items: [{
							text : '1、封面打印',
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
										UserMenuTreeService.findChildHealthFiles(cond,function(data){
											if(data){
												printObj.printPreview(getChildPrintCfg01(data.data[0],this.menu),-1);
											}else{
												showError('该户没有第一次产前随防记录,无法打印！');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},
						{
							text : '2、儿童基本档案打印',
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
												printObj.printPreview(getChildPrintCfg02(data.data[0],this.menu),-1);
											}else{
												showError('该户没有第一次产前随防记录,无法打印！');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},
						{
							text : '3、新生儿访视记录表打印',
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
											pageSize : 20,
											recordId : 'firstVisit.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findFirstVisitRecords,

											// 设置查询用的类别，比如档案，高血压等。。
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'firstVisit.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'firstVisit.highRisk'},
															{name:'weeks', mapping: 'firstVisit.weeks'},
															{name:'visitDate', mapping: 'firstVisit.visitDate'},
															{name:'nextVisitDate', mapping: 'firstVisit.nextVisitDate'},
															{name:'visitDoctor', mapping: 'firstVisit.visitDoctor'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															{ "header" : "执行机构", "dataIndex" : "execOrgName"}, 
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
															 { "header" : "姓名", "dataIndex" : "name" },
															 { "header" : "出生日期", "dataIndex" : "birthday",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "高危", "dataIndex" : "highRisk" },
															 { "header" : "孕周", "dataIndex" : "weeks" },
															 { "header" : "随访日期", "dataIndex" : "visitDate",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "下次随访日期", "dataIndex" : "nextVisitDate",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "随访医生", "dataIndex" : "visitDoctor" },
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
													[2,"第二页"], 
													[3,"第三页"]
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
														colspan: 2,
														width : 626,
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
																if(pagenum =="1"){
																	printObj.printPreview(getChildPrintCfg03(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
																}else if(pagenum =="2"){
																	printObj.printPreview(getChildPrintCfg04(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
																}else{
																	printObj.printPreview(getChildPrintCfg05(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
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
														]
													} ]
												});
												
												return panel;
											}
										});
										var ppanel = new printpanel();
										var win = new Ext.Window(
											{width:720,height:500,title:"3、首次产前检查记录表打印",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},
						{
							text : '4、1岁以内儿童健康检查记录表打印',
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
										UserMenuTreeService.findVisitBeforeBornRecords(cond,function(data){
											if(data){
												var printpanel = Ext.extend(Ext.Panel, {
                                                    closable : true,
                                                    currentNode : null, // 当前选择的树节点
                                                    layout : 'fit',
													border: false,
                                                    pageSize : 20,
                                                    recordId : 'visit.id',
                                                    recordPk : 'id',
                                                    // 是否需要在最末级才能增加？
                                                    checkLastLevel : true,

                                                    // 设置查询url
                                                    queryUrl : UserMenuTreeService.findVisitBeforeBornRecords,

                                                    // 设置查询用的类别，比如档案，高血压等。。
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
                                                                    {name:'visitDoctor', mapping: 'visit.visitDoctor'}
                                                                    
                                                                   ],
                                                    gridCmConfig :
                                                                   [
                                                                    { "header" : "执行机构", "dataIndex" : "execOrgName"}, 
                                                                     { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
                                                                     { "header" : "姓名", "dataIndex" : "name" },
                                                                     { "header" : "项目", "dataIndex" : "item","renderer" : function(val){
                                                                         return "第" + val + "次产前检查";
                                                                     }},
																	 { "header" : "随访日期", "dataIndex" : "visitDate",
                                                                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
																	{ "header" : "随访医生", "dataIndex" : "visitDoctor" },
																	{ "header" : "下次随访日期", "dataIndex" : "nextVisitDate",
                                                                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                                                                     { "header" : "出生日期", "dataIndex" : "birthday",
                                                                                         "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
                                                                                         { "header" : "高危", "dataIndex" : "highRisk" },   
                                                                     { "header" : "孕周", "dataIndex" : "weeks" },
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
														/*行选择*/
														this.rowdata1 = [ 
															[1,"第一行"], 
															[2,"第二行"], 
															[3,"第三行"], 
															[4,"第四行"], 
															[5,"第五行"], 
															[6,"第六行"], 
															[7,"第七行"], 
															[8,"第八行"]
															];
														this.rowdata2 = [ 
															[1,"第一行"], 
															[2,"第二行"],
															[3,"第三行"], 
															[4,"第四行"], 
															[5,"第五行"]
															];
														var rowstore = new Ext.data.SimpleStore({ 
															fields:[ 
															{name:"id"}, 
															{name:"name"}
															] 
														}); 
														var rowsm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
														var rowcm = new Ext.grid.ColumnModel([ 
																rowsm, 
																{header:"行数",dataIndex:"name"}, 
																]); 
														rowstore.loadData(this.rowdata1);
														this.rowgrid = new Ext.grid.GridPanel({ 
															cm:rowcm, 
															height:430,
															width:80,
															sm:rowsm, 
															store:rowstore, 
															loadMask:true 
															});
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
																singleSelect:true,
																listeners:{"rowselect":function (mode ,rowIndex ,record ){
																		if(record.json[0] == "1"){
																			this.rowgrid.store.loadData(this.rowdata1)
																		}else{
																			this.rowgrid.store.loadData(this.rowdata2)
																		}
																		//this.rowgrid.getSelectionModel().selectFirstRow();
																	}.createDelegate(this)
																	}
																});
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
															loadMask:true,
															listeners:{
															"afterlayout":function (obj){
																	obj.getSelectionModel().selectFirstRow();
																}
															}
															});
														//
                                                        var panel = new Ext.Panel({
                                                            layout : 'table',
                                                            autoScroll : false,
															layoutConfig: {
																// The total column count must be specified here
																columns: 3
															},
															
															border:false,
                                                            //id : this.panelId,
                                                            items : [  {
                                                                title : '第一步：选择要打印的记录',
                                                                region : 'east',
                                                                //layout : 'fit',
                                                                width : 626,
                                                                height: 430,
                                                                frame : false,
                                                                border : true,
                                                                items : [ this.grid ]
                                                            },{
                                                                region : 'center',
                                                                //layout : 'fit',
                                                                frame : false,
                                                                title : '第二步：<br>选择页数',
                                                                split : false,
                                                                collapsible : false,
                                                               
                                                                width : 80,
                                                                height:430,
                                                                border : true,
                                                                items : [ this.pagegrid ]
                                                            },{
                                                                region : 'west',
                                                                //layout : 'fit',
                                                                frame : false,
                                                                title : '第三步：<br>选择行数',
                                                                split : false,
                                                                collapsible : false,
                                                   
                                                                width : 80,
                                                                height:430,
                                                                border : true,
                                                                items :[this.rowgrid]
                                                            },{
                                                                region : 'south',
																colspan: 3,
                                                                layout : 'table',
                                                                frame : false,
                                                                //title : '第三111',
                                                                split : false,
																border : false,
                                                                collapsible : false,
                                                                layoutConfig: {
																	columns: 3
																},
                                                                //width : 800,
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
																	columns: 5
																},
                                                                //width : 800,
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
																	text:"打印检查记录",
																	handler : function (){
																		if(!this.grid.getSelectionModel().hasSelection()){
																			Ext.Msg.alert('提示', '请选择要打印的记录!');
																			return;
																		}
																		if(!this.pagegrid.getSelectionModel().hasSelection()){
																			Ext.Msg.alert('提示', '请选择页数!');
																			return;
																		}
																		if(!this.rowgrid.getSelectionModel().hasSelection()){
																			Ext.Msg.alert("提示","请选择行数!");
																			return;
																		}
																		//alert("11111111111111"+this.grid.getSelectionModel().getSelected());
																		//alert("11111111111111"+printdata(this.grid.getSelectionModel().getSelected()));
																		var pagenum = this.pagegrid.getSelectionModel().getSelected().json[0];
																		
																		var rownum = this.rowgrid.getSelectionModel().getSelected().json[0];
																		//alert("页数=="+pagenum+"行数=="+rownum);
																		printObj.printPreview(getChildPrintCfg06(this.grid.getSelectionModel().getSelected().json,pagenum,rownum),-1);
																	}.createDelegate(this)
																},{xtype:'button',
																	iconCls: 'c_print',
																	text:"打印转诊情况",
																	handler : function (){
																		if(!this.grid.getSelectionModel().hasSelection()){
																			Ext.Msg.alert('提示', '请选择要打印的记录!');
																			return;
																		}
																		printObj.printPreview(getChildPrintCfg07(this.grid.getSelectionModel().getSelected().json),-1);
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
                                                    {width:800,height:500,title:"6、产前检查记录打印",layout : 'fit',items:[ppanel]}
                                                );
                                                win.show();
                                                win.doLayout(true);
												ppanel.grid.doLayout(true);
											}else{
												showError('该户没有产前随防记录,无法打印！');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},{
							text : '5、1-2岁儿童健康检查记录表打印',
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
											pageSize : 20,
											recordId : 'birthRecord.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
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
															{ "header" : "分娩日期", "dataIndex" : "birthRecordDate" },
															{ "header" : "高危", "dataIndex" : "highRisk" }, 
															{ "header" : "出生日期", "dataIndex" : "birthday", 
																	 "renderer": Ext.util.Format.dateRenderer('Y-m-d') }, 
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
													items : [  
													{
														title : '第一步：选择要打印的记录',
														region : 'east',
														colspan: 2,
														width : 626,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},
													{
														region : 'center',
														frame : false,
														title : '第二步：<br>选择页数',
														split : false,
														collapsible : false,
													   
														width : 80,
														height:430,
														border : true,
														items : [ this.pagegrid ]
													},
													{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														height:8,
														border : false
													},
													{
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
														},
														{xtype:'button',
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
																if(pagenum =="1"){
																	printObj.printPreview(getChildPrintCfg08(this.grid.getSelectionModel().getSelected().json),-1);
																}else{
																	printObj.printPreview(getChildPrintCfg09(this.grid.getSelectionModel().getSelected().json),-1);
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
											{width:720,height:500,title:"5、分娩记录打印",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},{
							text : '6、儿童入托儿园(所)健康检查表打印',
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
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findVisitAfterBornRecords,
											// 设置查询用的类别，比如档案，高血压等。。
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'visit.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'visit.highRisk'},
															{name:'visitDate', mapping: 'visit.visitDate'},
															{name:'result', mapping: 'visit.result'},
															{name:'nextVisitDate', mapping: 'visit.nextVisitDate'},
															{name:'visitDoctor', mapping: 'visit.visitDoctor'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															 { "header" : "执行机构", "dataIndex" : "execOrgName"}, 
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
															 { "header" : "姓名", "dataIndex" : "name" },
															 { "header" : "出生日期", "dataIndex" : "birthday",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
																				 { "header" : "高危", "dataIndex" : "highRisk" },
															 { "header" : "随访日期", "dataIndex" : "visitDate",
																				   "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "分类", "dataIndex" : "result" },
															 { "header" : "下次随访日期", "dataIndex" : "nextVisitDate",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "随访医生", "dataIndex" : "visitDoctor" },
															 { "header" : "录入人", "dataIndex" : "username" }
														   ],
											gridViewConfig : {},
											initComponent : function() {
												this.build();
												Ext.tf.HealthPanel.superclass.initComponent.call(this);
											},

											build : function() {
												this.items = [ this.createPanel() ];
											},
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
													[1,"第一行"], 
													[2,"第二行"], 
													[3,"第三行"]
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
													items : [  
													{
														title : '选择要打印的记录',
														region : 'east',
														colspan: 2,
														width : 626,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},
													{
														region : 'center',
														frame : false,
														title : '第二步：<br>选择行数',
														split : false,
														collapsible : false,
													   
														width : 80,
														height:430,
														border : true,
														items : [ this.pagegrid ]
													},
													{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														height:8,
														border : false
													},
													{
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
														},
														{xtype:'button',
															iconCls: 'c_print',
															text:"打印",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择要打印的记录!');
																	return;
																}
																if(!this.pagegrid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择行数!');
																	return;
																}
																var rownum = this.pagegrid.getSelectionModel().getSelected().json[0];
																printObj.printPreview(getChildPrintCfg10(this.grid.getSelectionModel().getSelected().json,rownum),-1);
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
											{width:720,height:500,title:"6、产后访视记录表",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},{
							text : '7、3-6岁儿童健康检查记录表打印',
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
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findVisitAfterBorn42Records,
											// 设置查询用的类别，比如档案，高血压等。。
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'visit.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'visit.highRisk'},
															{name:'visitDate', mapping: 'visit.visitDate'},
															{name:'result', mapping: 'visit.result'},
															{name:'visitDoctor', mapping: 'visit.visitDoctor'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															 { "header" : "执行机构", "dataIndex" : "execOrgName"},
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
															 { "header" : "姓名", "dataIndex" : "name" },
															 { "header" : "出生日期", "dataIndex" : "birthday",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
																				 { "header" : "高危", "dataIndex" : "highRisk" },
															 { "header" : "随访日期", "dataIndex" : "visitDate",
																				   "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "分类", "dataIndex" : "result" },
															 { "header" : "随访医生", "dataIndex" : "visitDoctor" },
															 { "header" : "录入人", "dataIndex" : "username" }
														   ],
											gridViewConfig : {},
											initComponent : function() {
												this.build();
												Ext.tf.HealthPanel.superclass.initComponent.call(this);
											},

											build : function() {
												this.items = [ this.createPanel() ];
											},
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
												var panel = new Ext.Panel({
													layout : 'table',
													autoScroll : false,
													layoutConfig: {
														columns: 3
													},
													border:false,
													items : [  
													{
														title : '选择要打印的记录',
														region : 'east',
														colspan: 3,
														width : 706,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},
													{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														height:8,
														border : false
													},
													{
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
														},
														{xtype:'button',
															iconCls: 'c_print',
															text:"打印",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择要打印的记录!');
																	return;
																}
																printObj.printPreview(getChildPrintCfg11(this.grid.getSelectionModel().getSelected().json),-1);
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
											{width:720,height:500,title:"7、产后42天检查记录表",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},{
							text : '8、异常情况记录表打印',
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
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findVisitAfterBorn42Records,
											// 设置查询用的类别，比如档案，高血压等。。
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'visit.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'visit.highRisk'},
															{name:'visitDate', mapping: 'visit.visitDate'},
															{name:'result', mapping: 'visit.result'},
															{name:'visitDoctor', mapping: 'visit.visitDoctor'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															 { "header" : "执行机构", "dataIndex" : "execOrgName"},
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
															 { "header" : "姓名", "dataIndex" : "name" },
															 { "header" : "出生日期", "dataIndex" : "birthday",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
																				 { "header" : "高危", "dataIndex" : "highRisk" },
															 { "header" : "随访日期", "dataIndex" : "visitDate",
																				   "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "分类", "dataIndex" : "result" },
															 { "header" : "随访医生", "dataIndex" : "visitDoctor" },
															 { "header" : "录入人", "dataIndex" : "username" }
														   ],
											gridViewConfig : {},
											initComponent : function() {
												this.build();
												Ext.tf.HealthPanel.superclass.initComponent.call(this);
											},

											build : function() {
												this.items = [ this.createPanel() ];
											},
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
												var panel = new Ext.Panel({
													layout : 'table',
													autoScroll : false,
													layoutConfig: {
														columns: 3
													},
													border:false,
													items : [  
													{
														title : '选择要打印的记录',
														region : 'east',
														colspan: 3,
														width : 706,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},
													{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														height:8,
														border : false
													},
													{
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
														},
														{xtype:'button',
															iconCls: 'c_print',
															text:"打印",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择要打印的记录!');
																	return;
																}
																printObj.printPreview(getChildPrintCfg11(this.grid.getSelectionModel().getSelected().json),-1);
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
											{width:720,height:500,title:"7、产后42天检查记录表",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},{
							text : '9、儿童年龄别体重图打印',
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
											pageSize : 20,
											recordId : 'visit.id',
											recordPk : 'id',
											//panelId : 'print_childBirthRecordPanel',
											// 是否需要在最末级才能增加？
											checkLastLevel : true,

											// 设置查询url
											queryUrl : UserMenuTreeService.findVisitAfterBorn42Records,
											// 设置查询用的类别，比如档案，高血压等。。
											queryType : 'demo',
											readerConfig : [
															{name:'execOrgName', mapping: 'org.name'},
															{name:'id', mapping: 'visit.id'},
															{name:'fileNo', mapping: 'file.fileNo'},
															{name:'name', mapping: 'file.name'},
															{name:'birthday', mapping: 'person.birthday'},
															{name:'highRisk', mapping: 'visit.highRisk'},
															{name:'visitDate', mapping: 'visit.visitDate'},
															{name:'result', mapping: 'visit.result'},
															{name:'visitDoctor', mapping: 'visit.visitDoctor'},
															{name:'username', mapping: 'samTaxempcode.username'}
														   ],
											gridCmConfig :
														   [
															 { "header" : "执行机构", "dataIndex" : "execOrgName"},
															 { "header" : "编号", "dataIndex" : "fileNo", "width":130 },
															 { "header" : "姓名", "dataIndex" : "name" },
															 { "header" : "出生日期", "dataIndex" : "birthday",
																				 "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
																				 { "header" : "高危", "dataIndex" : "highRisk" },
															 { "header" : "随访日期", "dataIndex" : "visitDate",
																				   "renderer": Ext.util.Format.dateRenderer('Y-m-d') },
															 { "header" : "分类", "dataIndex" : "result" },
															 { "header" : "随访医生", "dataIndex" : "visitDoctor" },
															 { "header" : "录入人", "dataIndex" : "username" }
														   ],
											gridViewConfig : {},
											initComponent : function() {
												this.build();
												Ext.tf.HealthPanel.superclass.initComponent.call(this);
											},

											build : function() {
												this.items = [ this.createPanel() ];
											},
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
												var panel = new Ext.Panel({
													layout : 'table',
													autoScroll : false,
													layoutConfig: {
														columns: 3
													},
													border:false,
													items : [  
													{
														title : '选择要打印的记录',
														region : 'east',
														colspan: 3,
														width : 706,
														height: 430,
														frame : false,
														border : true,
														items : [ this.grid ]
													},
													{
														region : 'south',
														colspan: 3,
														layout : 'table',
														frame : false,
														split : false,
														border : false,
														collapsible : false,
														height:8,
														border : false
													},
													{
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
														},
														{xtype:'button',
															iconCls: 'c_print',
															text:"打印",
															handler : function (){
																if(!this.grid.getSelectionModel().hasSelection()){
																	Ext.Msg.alert('提示', '请选择要打印的记录!');
																	return;
																}
																printObj.printPreview(getChildPrintCfg11(this.grid.getSelectionModel().getSelected().json),-1);
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
											{width:720,height:500,title:"7、产后42天检查记录表",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						}
						
						]
					})
				}),
				new Ext.Action({
					text : '增加',
					iconCls : 'c_add',
					handler : function() {
						var selNode = this.getTreeSelNode();
						if (selNode) {
							this.f_add();
						}
					}.createDelegate(this)
				}),
				this.editAction,
				new Ext.Action({
					text : '删除',
					iconCls : 'c_del',
					handler : function() {
						var selections = this.grid.getSelections();
						if (selections.length > 0) {
							var array = [];

							var pk = this.recordPk;
							Ext.each(selections, function(v) {
								array.push(v.get(pk));
							});

							var del = function(e) {
								if (e == "yes") {
									this.deleteUrl(array, {
										callback : function(data) {
											Ext.Msg.alert('', '删除成功！');
											this.load();
										}.createDelegate(this),
										errorHandler : function(msg) {
											console.log(msg);
											Ext.Msg.alert('', '删除出错！');
										}
									});
								}
							};
							Ext.MessageBox.confirm("提示", "确认要删除所选择的记录么？", del,
									this);
						}
					}.createDelegate(this)
				}),
				'-',
				this.combo,
				this.filterField,
				new Ext.Action({
					text : '查询',
					iconCls : 'c_query',
					handler : function() {
						this.load(true);
					}.createDelegate(this)
				}),

				new Ext.Action({
					text : '数据导出',
					iconCls : 'c_add',
					handler : function() {
						var selNode = this.getTreeSelNode();
						if (selNode) {
							var disNo = selNode.id;
							var id = this.panelId;
							Ext.getCmp(id).getEl().mask('导出数据加载中...');
							var filterKey = this.combo.getValue();
							var filterValue = this.filterField.getValue();
							this.dataExportUrl(disNo, filterKey, filterValue,
									function(data) {
										window.location.href = data;
										// UserMenuTreeService.removeDataExportFile(data);
										Ext.getCmp(id).getEl().unmask();
									});
						}
					}.createDelegate(this)
				}) ];
	},

	/*
	 * 取得行政树的节点 如果节点没有选中，提示信息，返回空 如果选中，再取得过滤条件，组合成查询条件，并返回之
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
	 * 查询数据, 如果树没有选择了节点，不执行
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
			emptyMsg : "没有记录"
		});
		var sm = new Ext.grid.CheckboxSelectionModel();
		this.gridCmConfig.unshift(sm);
		this.grid = new Ext.grid.GridPanel({
			title : '请选择一个行政区划',
			bbar : this.pagingBar,
			layout : 'fit',
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
					// 自动展开根节点的第一个孩子
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
				title : '行政区划',
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