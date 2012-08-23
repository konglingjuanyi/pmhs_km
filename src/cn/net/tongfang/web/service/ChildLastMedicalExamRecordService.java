package cn.net.tongfang.web.service;

import java.sql.Timestamp;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.ChildLastMedicalExamRecord;

public class ChildLastMedicalExamRecordService extends HibernateDaoSupport {
	
	public void save(String fileNo,Timestamp lastExamDate,String highRiskRemarks,Integer type){
		ChildLastMedicalExamRecord records = new ChildLastMedicalExamRecord();
		records.setFileNo(fileNo);
		records.setLastExamDate(lastExamDate);
		records.setHighRiskRemarks(highRiskRemarks);
		records.setType(type);
		getHibernateTemplate().merge(records);
	}
	
	public void update(String fileNo,Integer type){
		ChildLastMedicalExamRecord records = (ChildLastMedicalExamRecord)getHibernateTemplate().get(ChildLastMedicalExamRecord.class, fileNo);
		records.setType(type);
		getHibernateTemplate().merge(records);
	}
	
	public boolean get(String fileNo){
		ChildLastMedicalExamRecord records = getObj(fileNo);
		if(records == null)
			return false;
		return true;
	}
	
	public ChildLastMedicalExamRecord getObj(String fileNo){
		return (ChildLastMedicalExamRecord)getHibernateTemplate().get(ChildLastMedicalExamRecord.class, fileNo);
	}
}
