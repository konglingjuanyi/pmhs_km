package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.BabyVisit;
import cn.net.tongfang.framework.security.vo.BasicInformation;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.WomanPhysicalItems;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.web.service.bo.MedicalExamPrintBO;

public class MedicalExamPrintService extends HibernateDaoSupport {
	private static final String UNTEST = "未测";
	private static final String EXCEPTION = "异常";
	
	/**
	 * 获得新生儿的体检记录打印信息
	 * @param id
	 * @return
	 */
	public MedicalExamPrintBO getBabyVisitInfoById(String id){
		BabyVisit babyVisit = (BabyVisit)getHibernateTemplate().get(BabyVisit.class, id);
		String fileNo = babyVisit.getFileNo();
		WomanPhysicalItems womanItems = (WomanPhysicalItems)getHibernateTemplate().find("From WomanPhysicalItems Where id = ?",id).get(0);
		HealthFile file = (HealthFile)getHibernateTemplate().get(HealthFile.class, fileNo);
		MedicalExamPrintBO medicalExamPrintbo = new MedicalExamPrintBO();
		BeanUtils.copyProperties(womanItems,medicalExamPrintbo);
		medicalExamPrintbo.setName(file.getName());
		medicalExamPrintbo.setSex(babyVisit.getSex());
		medicalExamPrintbo.setWeight(babyVisit.getExam29());
		medicalExamPrintbo.setHeight(babyVisit.getExam03());
		String babySkinOther = babyVisit.getBabySkinsOther();
		String babySkin = getBasicInfor(id,"BabySkin","babyVisitId","babySkinId");
		if(!babySkin.equals(UNTEST)){
			if(!babySkin.equals("") && babySkin.indexOf("其它") > 0 && !babySkinOther.equals("")){
				babySkin += babySkinOther;
			}
		}
		medicalExamPrintbo.setBabySkin(babySkin);
		medicalExamPrintbo.setSkull01(babyVisit.getExam09());
		medicalExamPrintbo.setSkull02(babyVisit.getExam10());
		medicalExamPrintbo.setNose(isOtherRemarks(babyVisit.getExam14(),babyVisit.getExam14other()));
		medicalExamPrintbo.setEar(isOtherRemarks(babyVisit.getExam13(),babyVisit.getExam13other()));
		medicalExamPrintbo.setHearing(isTest(babyVisit.getExam01()));
		medicalExamPrintbo.setGenitals(isOtherRemarks(babyVisit.getExam23(),babyVisit.getExam23other()));
		medicalExamPrintbo.setBackbone(isOtherRemarks(babyVisit.getExam24(),babyVisit.getExam24other()));
		
		Timestamp visitDate = babyVisit.getVisitDate();
		Timestamp birthday = babyVisit.getBirthday();
		if(visitDate != null){
			Calendar vsCalendar = CommonConvertUtils.timestampToCalendar(visitDate);
			Calendar birthCalendar = CommonConvertUtils.timestampToCalendar(birthday);
//			medicalExamPrintbo.setAge(getBabyAge(vsCalendar,birthCalendar));
		}
		
		return medicalExamPrintbo;
	}
	
	
	
	/**
	 * 获得子表的信息
	 * @param id
	 * @param tableName
	 * @param visitId
	 * @param basicId
	 * @return
	 */
	private String getBasicInfor(String id,String tableName,String visitId,String basicId){
		String hql = "From BasicInformation A," + tableName + " B Where B." + visitId + "= ?" +
				" And B." + basicId + "=A.id";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		List list = query.list();
		String ret = "";
		if(list.size() > 0){
			for(Object objs : list){
				Object[] obj = (Object[])objs;
				BasicInformation basicInfo = (BasicInformation)obj[0];
				ret = ret + basicInfo.getName() + ",";
			}
		}
		if(!ret.equals(""))
			ret = ret.substring(0,ret.length());
		else
			ret = UNTEST;
		return ret;
	}
	
	/**
	 * 如果有其它描述，则显示
	 * @param remarks
	 * @param otherRemarks
	 * @return
	 */
	private String isOtherRemarks(String remarks,String otherRemarks){
		return !remarks.equals(EXCEPTION) ? isTest(remarks) : remarks + ":" + otherRemarks;
	}
	
	/**
	 * 数据是否采集
	 * @param remarks
	 * @return
	 */
	private String isTest(String remarks){
		return (remarks == null || remarks.equals("")) ? UNTEST : remarks;
	}
}
