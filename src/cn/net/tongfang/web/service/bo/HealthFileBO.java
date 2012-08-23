package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.BloodTrans;
import cn.net.tongfang.framework.security.vo.DiseaseHistory;
import cn.net.tongfang.framework.security.vo.Opshistory;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.TraumaHistory;

public class HealthFileBO extends PersonalInfo{
	
	public List<Opshistory> opshistory;
	public List<TraumaHistory> traumaHistory;
	public List<DiseaseHistory> diseaseHistory;
	public List<BloodTrans> bloodTrans;
	public List<Opshistory> getOpshistory() {
		return opshistory;
	}
	public void setOpshistory(List<Opshistory> opshistory) {
		this.opshistory = opshistory;
	}
	public List<TraumaHistory> getTraumaHistory() {
		return traumaHistory;
	}
	public void setTraumaHistory(List<TraumaHistory> traumaHistory) {
		this.traumaHistory = traumaHistory;
	}
	public List<DiseaseHistory> getDiseaseHistory() {
		return diseaseHistory;
	}
	public void setDiseaseHistory(List<DiseaseHistory> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	public List<BloodTrans> getBloodTrans() {
		return bloodTrans;
	}
	public void setBloodTrans(List<BloodTrans> bloodTrans) {
		this.bloodTrans = bloodTrans;
	}
	

	
	
}
