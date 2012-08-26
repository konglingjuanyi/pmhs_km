Ext.ns("Ext.tf");

// /////////////
// 健康档案模板
// /////////////

var isFirst = 1;

function printdata(data){
	var msg = "";
	for(var item in data){
		if(item.toLowerCase().indexOf("history")>=0)
			msg = msg +item+"="+data[item]+"\n";
	}
	return msg;
}
function getPrintCfg01(data,orgmap){
	var retprintcfg = {
		title:{intTop:"0.26cm",intLeft:"0.26cm",intWidth:"20.8cm",intHeight:"14cm",strContent:"1、封面"},
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
	var retprintcfg = {
		title:{intTop:"0.26cm",intLeft:"0.26cm",intWidth:"20.8cm",intHeight:"14cm",strContent:"2、孕妇基本档案"},
		data:[	]
	};
	var i = 0 ;
	//国籍
	retprintcfg.data[i++] = {"strContent":"√",intTop:"10.26cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 

	//身份证,护照号
	retprintcfg.data[i++] = {"strContent":data.person.idnumber,intTop:"10.26cm",intLeft:"10.5cm",intWidth:"6cm",intHeight:"0.8cm"};
	//工作单位
	retprintcfg.data[i++] = {"strContent":data.person.workUnit,intTop:"11.0cm",intLeft:"3.26cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//户籍类别
	retprintcfg.data[i++] = {"strContent":"√",intTop:"11.0cm",intLeft:data.person.farmStatus==="是"?"10.26cm":"11.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//居住地区 : 无对应字段,默认选择4.其他地区
	retprintcfg.data[i++] = {"strContent":"√",intTop:"11.0cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//卫生机构公里数 : 无对应字段
	retprintcfg.data[i++] = {"strContent":"",intTop:"11.8cm",intLeft:"12.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//民族
	if(data.person.folk==="汉族"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"11.8cm",intLeft:"8.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"11.8cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.person.folkOther,intTop:"11.8cm",intLeft:"11cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//文化程度
	if(data.person.education==="文盲及半文盲" || data.person.education==="不详"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"4cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="小学" || data.person.education==="初中"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="高中/技校/中专"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.education==="大学专科及以上"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"12.6cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//职业
	if(data.person.occupation==="国家机关、党群组织、企业、事业单位负责人" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"13.4cm",intLeft:"3.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="专业技术人员" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"13.4cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="办事人员和有关人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"13.4cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="商业、服务业人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"13.4cm",intLeft:"18cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="农、林、牧、渔、水利业生产人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="生产、运输设备操作人员及有关人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="军人"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"13cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else if(data.person.occupation==="不便分类的其他从业人员"){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"14.2cm",intLeft:"15cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}
	//产后休养地
	//省
	retprintcfg.data[i++] = {"strContent":"云南",intTop:"15cm",intLeft:"3.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//市
	retprintcfg.data[i++] = {"strContent":"昆明",intTop:"15cm",intLeft:"5.26cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	//区
	retprintcfg.data[i++] = {"strContent":orgmap.getNodeById(data.file.fileNo.substr(0,6)).text,intTop:"15cm",intLeft:"7.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//街
	retprintcfg.data[i++] = {"strContent":data.file.township,intTop:"15cm",intLeft:"11.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//村
	retprintcfg.data[i++] = {"strContent":data.file.village,intTop:"15cm",intLeft:"14.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//门牌号
	retprintcfg.data[i++] = {"strContent":"无",intTop:"15cm",intLeft:"18.26cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫姓名
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandName,intTop:"15.8cm",intLeft:"4cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫年龄
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandAge,intTop:"15.8cm",intLeft:"7cm",intWidth:"3cm",intHeight:"0.8cm"}; 
	//丈夫联系电话
	retprintcfg.data[i++] = {"strContent":data.firstVisit.husbandTel,intTop:"15.8cm",intLeft:"10cm",intWidth:"4cm",intHeight:"0.8cm"}; 
	//丈夫文化程度 无字段 ,不填
	//丈夫职业 无字段 ,不填
	//丈夫工作单位 无字段 ,不填
	
		/**/
	return retprintcfg;
}

function getPrintCfg03(data,orgmap){
	alert("1,person  "+printdata(data.person));
	alert("2,file    "+printdata(data.file));
	alert("3,samTaxempcode   "+printdata(data.samTaxempcode));
	alert("4,firstVisit     "+printdata(data.firstVisit));
	alert("5,org   "+printdata(data.org));
	alert("6,feme  "+printdata(data.feme));
	/**/
	var retprintcfg = {
		title:{intTop:"0.26cm",intLeft:"0.26cm",intWidth:"20.8cm",intHeight:"14cm",strContent:"2、孕妇基本档案"},
		data:[	]
	};
	var i = 0 ;
	//初检日期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"Y"),intTop:"10.26cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"m"),intTop:"10.26cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.visitDate,"d"),intTop:"10.26cm",intLeft:"4.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//初检孕周
	retprintcfg.data[i++] = {"strContent":data.firstVisit.weeks,intTop:"10.26cm",intLeft:"9.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//基础血压
	retprintcfg.data[i++] = {"strContent":data.firstVisit.diastolicPressure,intTop:"10.26cm",intLeft:"13.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":data.firstVisit.systolicPressure,intTop:"10.26cm",intLeft:"15.8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-身高
	retprintcfg.data[i++] = {"strContent":data.firstVisit.height,intTop:"11.0cm",intLeft:"4cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-体重
	retprintcfg.data[i++] = {"strContent":data.firstVisit.weight,intTop:"11.0cm",intLeft:"8cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕前情况-体质指数
	var weight = parseFloat(data.firstVisit.weight);
	var height = parseFloat(data.firstVisit.height);
	var res = weight/(height*height/10000)
	retprintcfg.data[i++] = {"strContent":res.toFixed(2),intTop:"11.0cm",intLeft:"13cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//现病史 无对应字段
	retprintcfg.data[i++] = {"strContent":'无',intTop:"13.0cm",intLeft:"3cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//月经史-初潮年龄 无对应字段
	//retprintcfg.data[i++] = {"strContent":'无',intTop:"13.8cm",intLeft:"5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//月经史-周期 无对应字段
	//retprintcfg.data[i++] = {"strContent":'无',intTop:"13.8cm",intLeft:"7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//末次月经年月日
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"Y"),intTop:"14.6cm",intLeft:"5.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"m"),intTop:"14.6cm",intLeft:"6.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.lastMenses,"d"),intTop:"14.6cm",intLeft:"7.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//预产期
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"Y"),intTop:"14.6cm",intLeft:"11.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"m"),intTop:"14.6cm",intLeft:"12.7cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	retprintcfg.data[i++] = {"strContent":Ext.util.Format.date(data.firstVisit.edc,"d"),intTop:"14.6cm",intLeft:"13.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//孕次
	retprintcfg.data[i++] = {"strContent":data.firstVisit.gravidity,intTop:"15.4cm",intLeft:"3.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//产次
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity+data.firstVisit.parity1,intTop:"15.4cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//其中:阴道自然分娩次数
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity,intTop:"15.4cm",intLeft:"7.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//胎头吸引 无对应字段
	//产钳 无对应字段
	//臀位 无对应字段
	//剖宫产
	retprintcfg.data[i++] = {"strContent":data.firstVisit.parity1,intTop:"16.2cm",intLeft:"4.2cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	//末次分娩时间 无对应字段
	//既往史
	if(data.feme.femePastHistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.femePastHistory.indexOf("心脏病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("肾脏疾病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("肝脏疾病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("高血压")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"12cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("贫血")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"13.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("糖尿病")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"14.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femePastHistory.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17cm",intLeft:"15.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.pastHistoryOther,intTop:"17cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//家庭史
	if(data.feme.femeFamilyHistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"17.8cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.femeFamilyHistory.indexOf("遗传性疾病史")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17.8cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femeFamilyHistory.indexOf("精神疾病史")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17.8cm",intLeft:"10cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.femeFamilyHistory.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"17.8cm",intLeft:"11.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.familyHistoryOther,intTop:"17.8cm",intLeft:"12.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//个人史
	if(data.feme.exam01==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"7cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		if(data.feme.exam01.indexOf("吸烟")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"7.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("饮酒")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("服用药物")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"9.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("接触有毒有害物质")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"10.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("接触放射线")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"12.2cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
		if(data.feme.exam01.indexOf("其他")>=0 ){
			retprintcfg.data[i++] = {"strContent":"√",intTop:"18.6cm",intLeft:"15.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
			retprintcfg.data[i++] = {"strContent":data.firstVisit.personalHistoryOther,intTop:"18.6cm",intLeft:"16.5cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		}
	}
	//妇产科手术史 
	if(data.firstVisit.opshistory==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"19.4cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"19.4cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.firstVisit.opshistoryOther,intTop:"19.4cm",intLeft:"10cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}	
	//输血史
	if(data.feme.exam03==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"20.2cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"20.2cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(0,4),intTop:"20.2cm",intLeft:"10cm",intWidth:"6cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(4,2),intTop:"20.2cm",intLeft:"11cm",intWidth:"6cm",intHeight:"0.8cm"}; 
		retprintcfg.data[i++] = {"strContent":data.feme.exam03.substr(6,2),intTop:"20.2cm",intLeft:"11.5cm",intWidth:"6cm",intHeight:"0.8cm"}; 
	}	
	//药物过敏史
	if(data.feme.exam02==="无" ){
		retprintcfg.data[i++] = {"strContent":"√",intTop:"21cm",intLeft:"8cm",intWidth:"2cm",intHeight:"0.8cm"}; 
	}else{
		retprintcfg.data[i++] = {"strContent":"√",intTop:"21cm",intLeft:"9cm",intWidth:"2cm",intHeight:"0.8cm"}; 
		var allergies = data.feme.exam02;
		if(data.person.allergiesOther.length>0){
			allergies=allergies+","+data.person.allergiesOther;
		}
		retprintcfg.data[i++] = {"strContent":allergies,intTop:"21cm",intLeft:"10cm",intWidth:"10cm",intHeight:"0.8cm"}; 
	}
	
		/**/
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
										UserMenuTreeService.findFirstVisitRecords(cond,function(data){
											if(data){
												printObj.printPreview(getPrintCfg03(data.data[0],this.menu),-1);
											}else{
												showError('该户没有第一次产前随防记录,无法打印！');
											}
										}.createDelegate(this))
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