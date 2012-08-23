package cn.net.tongfang.web.service;

import java.util.List;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.GravidityKey;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.WomanLastMedicalExamRecord;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.web.service.bo.VisitAfterBornBO;

public class VisitAfterBornService extends HealthMainService<VisitAfterBornBO> {
	private SystemInformationUtils sysInfo;
	private WomanLastMedicalExamRecordService womanRocordService; 
	public void setSysInfo(SystemInformationUtils sysInfo) {
		this.sysInfo = sysInfo;
	}
	public void setWomanRocordService(
			WomanLastMedicalExamRecordService womanRocordService) {
		this.womanRocordService = womanRocordService;
	}



	@Override
	public String save(VisitAfterBornBO data) throws Exception {
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		if(data.getId() == null){
			if(sysInfo.checkWomanMedicalExamIsInput(data.getFileNo(),data.getItem(),data.getRecordType(),data.getParities())){
				String msg = "";
				if(data.getRecordType().equals("0"))
					msg = "产后访视记录";
				else
					msg = "产后42天健康体检记录";
				throw new RuntimeException("编号为" + EncryptionUtils.decipher(data.getFileNo()) + "的孕产妇的此次产期的" + 
						msg + "已经录入系统，不可以重复录入。");
			}
		}
		
		if(data.getRecordType().equals("1")){
			PersonalInfo person = (PersonalInfo)getHibernateTemplate().find("From PersonalInfo Where fileNo = ?", data.getFileNo()).get(0);
			person.setBornStatus("否");
			getHibernateTemplate().save(person);
			List list = getHibernateTemplate().find("From GravidityKey Where fileNo = ?", data.getFileNo());
			if(list.size() > 0){
				GravidityKey gravidityKey = (GravidityKey)list.get(0);
				getHibernateTemplate().delete(gravidityKey);
			}
		}
		WomanLastMedicalExamRecord records = womanRocordService.getObj(data.getFileNo());
		if(records != null && records.getType().equals(1)){
			womanRocordService.update(data.getFileNo(), 0);
		}
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		return save_(data);
	}

	@Override
	public Object get(VisitAfterBornBO data) throws Exception {
		data = (VisitAfterBornBO)get_(data);;
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}

}
