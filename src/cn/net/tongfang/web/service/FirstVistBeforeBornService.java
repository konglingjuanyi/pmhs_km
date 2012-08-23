package cn.net.tongfang.web.service;

import org.springframework.beans.BeanUtils;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.GravidityKey;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.web.service.bo.FirstVisitBeforeBornPrintBO;
import cn.net.tongfang.web.service.bo.FirstVistBeforeBornBO;

public class FirstVistBeforeBornService extends HealthMainService<FirstVistBeforeBornBO> {
	private SystemInformationUtils sysUtils;
	private WomanLastMedicalExamRecordService womanRocordService; 
	
	public void setSysUtils(SystemInformationUtils sysUtils) {
		this.sysUtils = sysUtils;
	}
	
	public void setWomanRocordService(
			WomanLastMedicalExamRecordService womanRocordService) {
		this.womanRocordService = womanRocordService;
	}

	@Override
	public String save(FirstVistBeforeBornBO data) throws Exception {
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));		
		PersonalInfo person = (PersonalInfo)getHibernateTemplate().find("From PersonalInfo Where fileNo = ?", data.getFileNo()).get(0);
		person.setBornStatus("是");
		GravidityKey gravidityKey = new GravidityKey();
		gravidityKey.setFileNo(data.getFileNo());
		gravidityKey.setCurrentGravidity(data.getGravidity());
		getHibernateTemplate().save(person);		
		getHibernateTemplate().save(gravidityKey);		
		
		if(data.getHighRisk().equals("是")){
			womanRocordService.save(data.getFileNo(), data.getVisitDate(), data.getHighRiskRemark(), 1);
		}
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		return save_(data);
	}

	
	@Override
	public Object get(FirstVistBeforeBornBO data) throws Exception {
		data = (FirstVistBeforeBornBO)get_(data);;
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}
	public FirstVisitBeforeBornPrintBO getPrintInfo(FirstVisitBeforeBornPrintBO data){
		String id = data.getId();
		FirstVistBeforeBorn FirstVistBeforeBorn = (FirstVistBeforeBorn)getHibernateTemplate().get(FirstVistBeforeBorn.class, id);
		BeanUtils.copyProperties(FirstVistBeforeBorn, data);
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		String femePastHistory = sysUtils.getPrintBasicInfo(id,"FemePastHistory","femePastHistoryId","firstVistBeforeBornId");
		String femeFamilyHistory = sysUtils.getPrintBasicInfo(id,"FemeFamilyHistory","femeFamilyHistoryId","firstVistBeforeBornId");
		String femeSecretion = sysUtils.getPrintBasicInfo(id,"FemeSecretion","femeSecretionId","firstVistBeforeBornId");
//		String beforeBornCheckDirect = sysUtils.getPrintBasicInfo(id,"BeforeBornCheckDirect","beforeBornCheckDirectId","firstVistBeforeBornId");
		data.setFemePastHistory(femePastHistory);
		data.setFemeFamilyHistory(femeFamilyHistory);
		data.setFemeSecretion(femeSecretion);
		return data;
	}
}
