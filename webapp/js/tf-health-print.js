Ext.ns("Ext.tf");

// /////////////
// 健康档案模板
// /////////////

var isFirst = 1;

function printdata(data){
	var msg = "";
	for(var item in data){
		//if(item.toLowerCase().indexOf("input")>=0)
			msg = msg +item+"="+data[item]+"\n";
	}
	return msg;
}
//打印纸张设定
var title_initTop = "0.26cm";
var title_intLeft = "0.26cm";
var title_intWidth = "20.8cm";
var title_intHeight = "14cm";
function getPrintCfg01(data,orgmap){
	//1.封面(封面 封底.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"1、封面"},
		data:[	]
	}
	var i = 0 ;
	//18位编号
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(0,1),intTop:"10.26cm",intLeft:"10.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(1,1),intTop:"10.26cm",intLeft:"10.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(2,1),intTop:"10.26cm",intLeft:"10.8cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(3,1),intTop:"10.26cm",intLeft:"11.1cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(4,1),intTop:"10.26cm",intLeft:"11.4cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(5,1),intTop:"10.26cm",intLeft:"11.7cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(6,1),intTop:"10.26cm",intLeft:"12.3cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(7,1),intTop:"10.26cm",intLeft:"12.6cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(8,1),intTop:"10.26cm",intLeft:"12.9cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(9,1),intTop:"10.26cm",intLeft:"13.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(10,1),intTop:"10.26cm",intLeft:"13.8cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(11,1),intTop:"10.26cm",intLeft:"14.1cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(12,1),intTop:"10.26cm",intLeft:"14.7cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(13,1),intTop:"10.26cm",intLeft:"15.0cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(14,1),intTop:"10.26cm",intLeft:"15.3cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(15,1),intTop:"10.26cm",intLeft:"15.6cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(16,1),intTop:"10.26cm",intLeft:"15.9cm",intWidth:"6cm",intHeight:"0.8cm"};
	retprintcfg.data[i++] = {"strContent":data.file.fileNo.substr(17,1),intTop:"10.26cm",intLeft:"16.2cm",intWidth:"6cm",intHeight:"0.8cm"};
	//姓名
	retprintcfg.data[i++] = {"strContent":data.file.name,intTop:"15.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//年龄
	retprintcfg.data[i++] = {"strContent":parseInt(Ext.util.Format.date(new Date(),"Y"))-parseInt(Ext.util.Format.date(data.person.birthday,"Y") ),intTop:"15.26cm",intLeft:"6.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//联系电话
	retprintcfg.data[i++] = {"strContent":data.file.tel,intTop:"15.26cm",intLeft:"8.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//急救电话
	retprintcfg.data[i++] = {"strContent":data.file.tel,intTop:"15.26cm",intLeft:"12.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"16.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"16.26cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.file.fileNo.substr(0,6)).text,intTop:"16.26cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.file.township,intTop:"16.26cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.file.village,intTop:"16.26cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"16.26cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"17.26cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"17.26cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.file.fileNo.substr(0,6)).text,intTop:"17.26cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.file.township,intTop:"17.26cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.file.village,intTop:"17.26cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"17.26cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//高危代码
	var risk = data.firstVisit.highRiskRemark;
	risk = "0"+risk.substring(0,risk.indexOf("、"));
	risk = risk.substring(risk.length-2,2);
	retprintcfg.data[i++] = {"strContent":risk,intTop:"18.26cm",intLeft:"3.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//建册机构
	retprintcfg.data[i++] = {"strContent":data.org.name,intTop:"18.26cm",intLeft:"6.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//年
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.file.buildDate,"Y"),intTop:"18.26cm",intLeft:"12.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//月
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.file.buildDate,"m"),intTop:"18.26cm",intLeft:"13.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//日
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.file.buildDate,"d"),intTop:"18.26cm",intLeft:"14.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	
	return retprintcfg;
}

function getPrintCfg02(data,orgmap){
	//2.孕妇基本档案(1-2.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"2、孕妇基本档案"},
		data:[	]
	};
	var i = 0 ;
	//国籍
	retprintcfg.data[i++] = {"strContent":"√",intTop:"1.26cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 

	//身份证,护照号
	retprintcfg.data[i++] = {"strContent":data.person.idnumber,intTop:"1.26cm",intLeft:"10.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	//工作单位
	retprintcfg.data[i++] = {"strContent":data.person.workUnit,intTop:"2.0cm",intLeft:"3.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//户籍类别
	retprintcfg.data[i++] = {"strContent":"√",intTop:"2.0cm",intLeft:data.person.farmStatus==="是"?"10.26cm":"11.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//居住地区 : 无对应字段,默认选择4.其他地区
	retprintcfg.data[i++] = {"strContent":"√",intTop:"2.0cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//卫生机构公里数 : 无对应字段
	retprintcfg.data[i++] = {"strContent":"",intTop:"2.8cm",intLeft:"12.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//民族
	if(data.person.folk==="汉族"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"2.8cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"2.8cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.person.folkOther,intTop:"2.8cm",intLeft:"11cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//文化程度
	if(data.person.education==="文盲及半文盲" || data.person.education==="不详"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"3.6cm",intLeft:"4cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="小学" || data.person.education==="初中"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"3.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="高中/技校/中专"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"3.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="大学专科及以上"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"3.6cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//职业
	if(data.person.occupation==="国家机关、党群组织、企业、事业单位负责人" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4.4cm",intLeft:"3.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="专业技术人员" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4.4cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="办事人员和有关人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4.4cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="商业、服务业人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4.4cm",intLeft:"18cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="农、林、牧、渔、水利业生产人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="生产、运输设备操作人员及有关人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="军人"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="不便分类的其他从业人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"15cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//产后休养地
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"6cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"6cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.file.fileNo.substr(0,6)).text,intTop:"6cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.file.township,intTop:"6cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.file.village,intTop:"6cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"6cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫姓名
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandName,intTop:"6.8cm",intLeft:"4cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫年龄
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandAge,intTop:"6.8cm",intLeft:"7cm",intWidth:"3cm",intHeight:"0.8cm"}; 
	//丈夫联系电话
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandTel,intTop:"6.8cm",intLeft:"10cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫文化程度 无字段 ,不填
	//丈夫职业 无字段 ,不填
	//丈夫工作单位 无字段 ,不填
	
		/**/
	return retprintcfg;
}

function getPrintCfg03(data,orgmap){
	//3.首次产前检查表-第1页(3-4.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"3、首次产前检查记录表第1页"},
		data:[	]
	};
	var i = 0 ;
	//初检日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"Y"),intTop:"1.26cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"m"),intTop:"1.26cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"d"),intTop:"1.26cm",intLeft:"4.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//初检孕周
	retprintcfg.data[i++] = {"strContent":data.firstVisit.weeks,intTop:"1.26cm",intLeft:"9.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//基础血压
	retprintcfg.data[i++] = {"strContent":data.firstVisit.diastolicPressure,intTop:"1.26cm",intLeft:"13.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.firstVisit.systolicPressure,intTop:"1.26cm",intLeft:"15.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-身高
	retprintcfg.data[i++] = {"strContent":data.firstVisit.height,intTop:"2.0cm",intLeft:"4cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-体重
	retprintcfg.data[i++] = {"strContent":data.firstVisit.weight,intTop:"2.0cm",intLeft:"8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-体质指数
	var weight = parseFloat(data.firstVisit.weight);
	var height = parseFloat(data.firstVisit.height);
	var res = weight/(height*height/10000)
	retprintcfg.data[i++] = {"strContent":res.toFixed(2),intTop:"2.0cm",intLeft:"13cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//现病史 无对应字段
	retprintcfg.data[i++] = {"strContent":'无',intTop:"4.0cm",intLeft:"3cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//月经史-初潮年龄 无对应字段
	//retprintcfg.data[i++] = {"strContent":'无',intTop:"4.8cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//月经史-周期 无对应字段
	//retprintcfg.data[i++] = {"strContent":'无',intTop:"4.8cm",intLeft:"7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//末次月经年月日
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"Y"),intTop:"5.6cm",intLeft:"5.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"m"),intTop:"5.6cm",intLeft:"6.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"d"),intTop:"5.6cm",intLeft:"7.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//预产期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"Y"),intTop:"5.6cm",intLeft:"11.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"m"),intTop:"5.6cm",intLeft:"12.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"d"),intTop:"5.6cm",intLeft:"13.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕次
	retprintcfg.data[i++] = {"strContent":data.firstVisit.gravidity,intTop:"6.4cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//产次
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity+data.firstVisit.parity1,intTop:"6.4cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//其中:阴道自然分娩次数
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity,intTop:"6.4cm",intLeft:"7.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//胎头吸引 无对应字段
	//产钳 无对应字段
	//臀位 无对应字段
	//剖宫产
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity1,intTop:"7.2cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//末次分娩时间 无对应字段
	//既往史
	if(data.feme.femePastHistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.femePastHistory.indexOf("心脏病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("肾脏疾病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("肝脏疾病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("高血压")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"12cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("贫血")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"13.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("糖尿病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"14.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8cm",intLeft:"15.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.pastHistoryOther,intTop:"17cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//家庭史
	if(data.feme.femeFamilyHistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.femeFamilyHistory.indexOf("遗传性疾病史")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femeFamilyHistory.indexOf("精神疾病史")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femeFamilyHistory.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"11.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.familyHistoryOther,intTop:"17.8cm",intLeft:"12.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//个人史
	if(data.feme.exam01==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.exam01.indexOf("吸烟")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("饮酒")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("服用药物")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("接触有毒有害物质")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("接触放射线")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"12.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"15.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.personalHistoryOther,intTop:"18.6cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//妇产科手术史 
	if(data.firstVisit.opshistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.4cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.4cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.opshistoryOther,intTop:"19.4cm",intLeft:"10cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}	
	//输血史
	if(data.feme.exam03==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"11.2cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"11.2cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(0,4),intTop:"11.2cm",intLeft:"10cm",intWidth:"6cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(4,2),intTop:"11.2cm",intLeft:"11cm",intWidth:"6cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(6,2),intTop:"11.2cm",intLeft:"11.5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}	
	//药物过敏史
	if(data.feme.exam02==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		var allergies = data.feme.exam02;
		if(data.person.allergiesOther.length>0){
			allergies=allergies+","+data.person.allergiesOther;
		}
		retprintcfg.data[i++] = {"strContent":allergies,intTop:"12cm",intLeft:"10cm",intWidth:"10cm",intHeight:"0.8cm"}; 
	}
	
		/**/
	return retprintcfg;
}

function getPrintCfg04(data,orgmap){
	//4.首次产前检查表-第2页 (5-6.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"4、首次产前检查记录表第2页"},
		data:[	]
	};
	var i = 0 ;
	//避孕史 无此字段
	
	//孕产史-流产 
	retprintcfg.data[i++] = {"strContent":data.firstVisit.pregnant1,intTop:"4cm",intLeft:"5cm",intWidth:"2cm",intHeight:"0.8cm"}
	//末次流产时间 无此字段
	//死胎
	retprintcfg.data[i++] = {"strContent":data.firstVisit.pregnant2,intTop:"4.8cm",intLeft:"5cm",intWidth:"2cm",intHeight:"0.8cm"}
	//死产
	retprintcfg.data[i++] = {"strContent":data.firstVisit.pregnant3,intTop:"5.6cm",intLeft:"5cm",intWidth:"2cm",intHeight:"0.8cm"}
	//新生儿死亡
	if(data.firstVisit.pregnant4===0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"6.4cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"6.4cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//死亡时间 无此字段
	//死亡原因 无此字段
	//出生缺陷儿 
	if(data.firstVisit.pregnant5===0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"7.2cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"7.2cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//早产 无此字段
	//存活子女情况 无此字段
	//既往妊娠合并症及并发症 无此字段
	//体重 
	retprintcfg.data[i++] = {"strContent":data.firstVisit.weight,intTop:"11.2cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//血压
	retprintcfg.data[i++] = {"strContent":data.firstVisit.diastolicPressure,intTop:"11.2cm",intLeft:"8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.firstVisit.systolicPressure,intTop:"11.2cm",intLeft:"9cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//体格检查心率
	if(data.firstVisit.exam01==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam01other,intTop:"12cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//呼吸
	if(data.firstVisit.exam02==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.8cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.8cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam02other,intTop:"12.8cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//肝脏 无此字段
	//脾脏 无此字段 
	//乳房 无此字段 
	//其他检查 无此字段
	//妇科检查-外阴
	if(data.firstVisit.exam03==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam03other,intTop:"16cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//阴道
	if(data.firstVisit.exam04==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16cm",intLeft:"12cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam04other,intTop:"16cm",intLeft:"14cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//宫颈
	if(data.firstVisit.exam05==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16.8cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16.8cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam05other,intTop:"16.8cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//子宫
	if(data.firstVisit.exam06==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16.8cm",intLeft:"12cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"16.8cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam06other,intTop:"16.8cm",intLeft:"14cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//附件
	if(data.firstVisit.exam07==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"17.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"17.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.exam07other,intTop:"17.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	return retprintcfg;
}

function getPrintCfg05(data,orgmap){
	//5.首次产前检查表-第3页 (5-6.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"5、首次产前检查记录表第3页"},
		data:[	]
	};
	var i = 0 ;
	//HIV抗体首次检测时间 exam28是检查结果,没检查时间
	//梅毒血清学检测时间 exam27是检查结果,没检查时间
	//乙肝病源学检测时间 hepatitis01-hepatitis05是检查结果,没检查时间
	//总体评估 无诊断结果字段
	if(data.firstVisit.evaluation==="未见异常" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"6.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"6.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.beforeBornDirectOther,intTop:"6.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//高危因素判断 无高危评分字段
	//alert(data.firstVisit.highRisk)
	if(data.firstVisit.highRisk==="否" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		var risk = data.firstVisit.highRiskRemark;
		//alert(risk);
		risk = "0"+risk.substring(0,risk.indexOf("、"));
		risk = ("0"+data.firstVisit.highRiskRemark).substring(risk.length-2);
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":risk,intTop:"8.6cm",intLeft:"9.5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}
	//保健指导 
	if(data.feme.exam04.indexOf("个人卫生")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.feme.exam04.indexOf("心理")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.feme.exam04.indexOf("营养")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.feme.exam04.indexOf("避免致畸因素和疾病对胚胎的不良影响")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.feme.exam04.indexOf("产前筛查宣传告知")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.feme.exam04.indexOf("其他")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.6cm",intLeft:"15.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.beforeBornCheckDirectOther,intTop:"10.6cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}

	//转诊
	if(data.firstVisit.transfer==="否" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.transReason,intTop:"12.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		//建议转入机构及科室
		retprintcfg.data[i++] = {"strContent":data.firstVisit.transUnit,intTop:"13.4cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	
	//下次随访时间
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.nextVisitDate,"Y"),intTop:"14.2cm",intLeft:"9.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.nextVisitDate,"m"),intTop:"14.2cm",intLeft:"10.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.nextVisitDate,"d"),intTop:"14.2cm",intLeft:"10.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//检查单位 无此字段
	
	//主治医师
	retprintcfg.data[i++] = {"strContent":data.firstVisit.visitDoctor,intTop:"15cm",intLeft:"14.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	return retprintcfg;
}

function getPrintCfg06(data,page,row){
	//6.产前检查记录表 第一页 和第二页的表格打印
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
	//日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.visitDate,"Y-m-d"),intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+0)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//孕周
	retprintcfg.data[i++] = {"strContent":data.visit.weeks,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+0.8)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//血压
	retprintcfg.data[i++] = {"strContent":data.visit.diastolicPressure+"/"+data.visit.systolicPressure,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+1.5)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//主诉
	retprintcfg.data[i++] = {"strContent":data.visit.cc,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+2.3)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//体重
	retprintcfg.data[i++] = {"strContent":data.visit.weight,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+3.1)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//宫高
	retprintcfg.data[i++] = {"strContent":data.visit.exam01,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+3.9)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//腹围
	retprintcfg.data[i++] = {"strContent":data.visit.exam02,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+4.7)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//胎位
	retprintcfg.data[i++] = {"strContent":data.visit.exam07,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+5.5)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//胎心(次/分)
	retprintcfg.data[i++] = {"strContent":data.visit.exam03,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+6.3)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//尿蛋白
	retprintcfg.data[i++] = {"strContent":data.visit.exam05,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+7.1)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//其他辅助检查
	retprintcfg.data[i++] = {"strContent":data.visit.exam06,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+7.9)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//诊断
	if(data.visit.result !=="异常"){
		retprintcfg.data[i++] = {"strContent":data.visit.result,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+8.7)+"cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":data.visit.resultOther,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+8.7)+"cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//指导 beforeBornDirect  beforeBornDirectOther
	retprintcfg.data[i++] = {"strContent":data.beforeBornDirect+" "+data.visit.beforeBornDirectOther,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+10.7)+"cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//预约产检日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.nextVisitDate,"Y-m-d"),intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+12.7)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//检查单位
	retprintcfg.data[i++] = {"strContent":data.org.execOrgName,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+13.7)+"cm",intWidth:"1.2cm",intHeight:"0.8cm"}; 
	//检查医生
	retprintcfg.data[i++] = {"strContent":data.visit.visitDoctor,intTop:(starttop+row*rowheight)+"cm",intLeft:(startleft+14.9)+"cm",intWidth:"1.2cm",intHeight:"0.8cm"}; 
	return retprintcfg;
}

function getPrintCfg07(data){
	//7.产前检查记录表 第二页的转诊信息打印
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表-转诊信息"},
		data:[	]
	};
	var i = 0 ;
	//转诊
	if(data.visit.transfer==="否" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.visit.transReason,intTop:"12.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		//建议转入机构及科室
		retprintcfg.data[i++] = {"strContent":data.visit.transUnit,intTop:"13.4cm",intLeft:"9.5cm",intWidth:"5cm",intHeight:"0.8cm"}; 
	}
	//保健指导 
	if(data.beforeBornDirect.indexOf("个人卫生")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("膳食")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("心理")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("运动")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("自我监护")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("分娩准备")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"11.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("母乳喂养")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"12.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.beforeBornDirect.indexOf("其他")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"15cm",intLeft:"5.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		//retprintcfg.data[i++] = {"strContent":data.visit.beforeBornDirectOther,intTop:"10.6cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	return retprintcfg;
}

function getPrintCfg08(data){
	//8.分娩记录 第1页(13-14.jpg)
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"7、分娩记录打印"},
		data:[	]
	};
	var i = 0 ;
	//分娩时间
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.birthRecord.childbirthMonth,"Y"),intTop:"4cm",intLeft:"4cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.birthRecord.childbirthMonth,"n"),intTop:"4cm",intLeft:"5cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.birthRecord.childbirthMonth,"j"),intTop:"4cm",intLeft:"5.5cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//小时和分钟未记录
	//retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.birthRecord.childbirthMonth,"G"),intTop:"4cm",intLeft:"6cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.birthRecord.childbirthMonth,"i"),intTop:"4cm",intLeft:"6.5cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//分娩孕周
	retprintcfg.data[i++] = {"strContent":data.birthRecord.borthWeekly,intTop:"4cm",intLeft:"10cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//总产程 无此字段
	//分娩方式
	if(data.birthRecord.childbirthWay == "顺产"){
		//1.自然分娩
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"5cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}else if(data.birthRecord.childbirthWay == "臀产" || data.birthRecord.childbirthWay == "胎吸" ||  data.birthRecord.childbirthWay == "产钳"){
		//2.手术助产
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"7cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}else if(data.birthRecord.childbirthWay == "剖宫产"){
		//3.剖宫产
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"12cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}else if(data.birthRecord.childbirthWay == "难产"){
		//其他
		retprintcfg.data[i++] = {"strContent":"√",intTop:"5.2cm",intLeft:"16cm",intWidth:"1cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.birthRecord.childbirthWay,intTop:"5.2cm",intLeft:"17cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//胎盘娩出时间 无此字段
	
	//是否完整 无此字段
	//会阴情况 无此字段
	if(data.birthRecord.lacerationOfPerineum =="无"){
		//1.完整
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"4cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.birthRecord.lacerationOfPerineum =="Ⅰ" || data.birthRecord.lacerationOfPerineum =="Ⅱ" ||  data.birthRecord.lacerationOfPerineum =="Ⅲ"){
		//3.撕裂伤
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"6cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		//4.切开
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//宫颈裂伤 无此字段
	//分娩出血量
	retprintcfg.data[i++] = {"strContent":data.birthRecord.flooding,intTop:"11.2cm",intLeft:"5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//产后2小时出血量 无此字段
	//产后24小时出血量 无此字段
	//产后2小时血压 无此字段
	//产后并发症 无此字段

	return retprintcfg;
}
function getPrintCfg09(data){
	//9.分娩记录 第2页(13-14.jpg)
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
	//新生儿-出生体重
	retprintcfg.data[i++] = {"strContent":data.cert.weight,intTop:"4cm",intLeft:"4cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//身长
	retprintcfg.data[i++] = {"strContent":data.cert.height,intTop:"4cm",intLeft:"6cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//性别
	if(data.cert.sex=="男"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4cm",intLeft:"9cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}else if(data.cert.sex=="女"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4cm",intLeft:"10cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"4cm",intLeft:"11cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	}
	//apgar评分 无此字段
	//窒息 无此字段
	//产伤 无此字段
	//出生缺陷 无此字段
	//新生儿免疫接种 无此字段
	//新生儿疾病筛查 无此字段
	//产妇出院诊断 无此字段
	//新生儿出院诊断 无此字段
	//接产单位 
	retprintcfg.data[i++] = {"strContent":data.cert.borthOrganization,intTop:"10cm",intLeft:"8cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//接生者
	retprintcfg.data[i++] = {"strContent":data.cert.widwife,intTop:"10cm",intLeft:"15cm",intWidth:"4cm",intHeight:"0.8cm"}; 

	return retprintcfg;
}

function getPrintCfg10(data,rownum){
	//10.产后访视记录表(15-16.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;

	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//访视日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.visitDate,"Y-m-d"),intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+0)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//产后天数
	retprintcfg.data[i++] = {"strContent":data.visit.item,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+1)+"cm",intWidth:"0.7cm",intHeight:"0.8cm"}; 
	//体温
	retprintcfg.data[i++] = {"strContent":data.visit.bodyHeat,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+1.7)+"cm",intWidth:"0.7cm",intHeight:"0.8cm"}; 
	//脉搏次/分 无此字段
	//血压
	retprintcfg.data[i++] = {"strContent":data.visit.diastolicPressure+"/"+data.visit.systolicPressure,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+2.4)+"cm",intWidth:"0.7cm",intHeight:"0.8cm"}; 
	//乳汁多  无此字段
	//乳汁少  无此字段
	//红肿有  无此字段
	//红肿无  无此字段
	//乳头皲裂有  无此字段
	//乳头皲裂无  无此字段
	//宫底高度  无此字段
	//伤口愈合好  无此字段
	//伤口愈合差  无此字段
	//恶露-色,量  无此字段
	//恶露-异味-有  无此字段
	//恶露-异味-无  无此字段
	//健康情况
	retprintcfg.data[i++] = {"strContent":data.visit.health,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+6)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//心理状况
	retprintcfg.data[i++] = {"strContent":data.visit.mind,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+7)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//其他
	retprintcfg.data[i++] = {"strContent":data.visit.other,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+8)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//指导 afterBornDirect,afterBornDirectOther
	retprintcfg.data[i++] = {"strContent":data.afterBornDirect+" "+data.visit.afterBornDirectOther,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+9)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//预约时间
	retprintcfg.data[i++] = {"strContent":data.visit.nextVisitDate,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+10)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	//检查者
	retprintcfg.data[i++] = {"strContent":data.visit.visitDoctor,intTop:(starttop+rownum*rowheight)+"cm",intLeft:(startleft+11)+"cm",intWidth:"1cm",intHeight:"0.8cm"}; 
	return retprintcfg;
}

function getPrintCfg11(data){
	//11.产后42天检查记录表(15-16.jpg)
	var rowheight = 1.2;//行间隔高度
	var starttop = 3; 
	var startleft = 3;

	/**/
	var retprintcfg = {
		title:{intTop:title_initTop,intLeft:title_intLeft,intWidth:title_intWidth,intHeight:title_intHeight,strContent:"6、产前检查记录表"},
		data:[	]
	};
	var i = 0 ;
	//访视日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.visitDate,"Y"),intTop:"3cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.visitDate,"m"),intTop:"3cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.visit.visitDate,"d"),intTop:"3cm",intLeft:"4.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//产后天数 无此字段
	//体重 无此字段
	//血压
	retprintcfg.data[i++] = {"strContent":data.visit.diastolicPressure,intTop:"3cm",intLeft:"10cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.visit.systolicPressure,intTop:"3cm",intLeft:"11cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//一般健康情况 
	retprintcfg.data[i++] = {"strContent":data.visit.health,intTop:"4cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//一般心理状况
	retprintcfg.data[i++] = {"strContent":data.visit.mind,intTop:"4.8cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//乳房
	retprintcfg.data[i++] = {"strContent":data.visit.breast,intTop:"5.6cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//恶露
	retprintcfg.data[i++] = {"strContent":data.visit.lochia,intTop:"5.6cm",intLeft:"15cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//子宫
	retprintcfg.data[i++] = {"strContent":data.visit.metra,intTop:"6.4cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//宫颈   无此字段
	//retprintcfg.data[i++] = {"strContent":data.visit.metra,intTop:"6.4cm",intLeft:"15cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//附件 无此字段
	//伤口 
	retprintcfg.data[i++] = {"strContent":data.visit.wound,intTop:"7.2cm",intLeft:"15cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//外阴 无此字段
	//其他
	retprintcfg.data[i++] = {"strContent":data.visit.other,intTop:"8cm",intLeft:"15cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//分类
	if(data.visit.result ==="已恢复"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"4cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"8.8cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.visit.resultOther,intTop:"8.8cm",intLeft:"6cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}
	//指导内容
	if(data.afterBornDirect.indexOf("性保健")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"4cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.afterBornDirect.indexOf("避孕")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"5.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.afterBornDirect.indexOf("婴儿喂养及营养")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"6.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	if(data.afterBornDirect.indexOf("其他")>=0 ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"9.6cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.visit.afterBornDirectOther,intTop:"9.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//处理
	if(data.visit.transfer==="结案"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.4cm",intLeft:"4cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"10.4cm",intLeft:"5.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.visit.transReason,intTop:"10.4cm",intLeft:"6.5cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	}
	//转诊日期 无此字段
	//建议转入机构及科室
	retprintcfg.data[i++] = {"strContent":data.visit.transUnit,intTop:"11.2cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//检查单位
	retprintcfg.data[i++] = {"strContent":data.org.execOrgName,intTop:"12cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//检查医生
	retprintcfg.data[i++] = {"strContent":data.visit.visitDoctor,intTop:"12.8cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 

	return retprintcfg;
}

/**/
Ext.tf.HealthPrintPanel = Ext.extend(Ext.Panel, {
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
										UserMenuTreeService.findFirstVisitRecords(cond,function(data){
											if(data){
												printObj.printPreview(getPrintCfg01(data.data[0],this.menu),-1);
											}else{
												showError('该户没有第一次产前随防记录,无法打印！');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},
						{
							text : '2、孕妇基本档案打印',
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
												printObj.printPreview(getPrintCfg02(data.data[0],this.menu),-1);
											}else{
												showError('该户没有第一次产前随防记录,无法打印！');
											}
										}.createDelegate(this))
									}
								}
							}.createDelegate(this)
						},
						{
							text : '3、首次产前检查记录表打印',
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
																	printObj.printPreview(getPrintCfg03(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
																}else if(pagenum =="2"){
																	printObj.printPreview(getPrintCfg04(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
																}else{
																	printObj.printPreview(getPrintCfg05(this.grid.getSelectionModel().getSelected().json,this.menu),-1);
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
							text : '4、产前检查记录表打印',
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
																		printObj.printPreview(getPrintCfg06(this.grid.getSelectionModel().getSelected().json,pagenum,rownum),-1);
																	}.createDelegate(this)
																},{xtype:'button',
																	iconCls: 'c_print',
																	text:"打印转诊情况",
																	handler : function (){
																		if(!this.grid.getSelectionModel().hasSelection()){
																			Ext.Msg.alert('提示', '请选择要打印的记录!');
																			return;
																		}
																		printObj.printPreview(getPrintCfg07(this.grid.getSelectionModel().getSelected().json),-1);
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
							text : '5、分娩记录打印',
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
											{width:720,height:500,title:"5、分娩记录打印",layout : 'fit',items:[ppanel]}
										);
										win.show();
										win.doLayout(true);
										ppanel.grid.doLayout(true);
									}
								}
							}.createDelegate(this)
						},{
							text : '6、产后访视记录表打印',
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
																printObj.printPreview(getPrintCfg10(this.grid.getSelectionModel().getSelected().json,rownum),-1);
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
							text : '7、产后42天检查记录表打印',
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
																printObj.printPreview(getPrintCfg11(this.grid.getSelectionModel().getSelected().json),-1);
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