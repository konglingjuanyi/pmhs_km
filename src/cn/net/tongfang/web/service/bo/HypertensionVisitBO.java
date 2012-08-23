package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.HypertensionMedications;
import cn.net.tongfang.framework.security.vo.HypertensionSymptom;
import cn.net.tongfang.framework.security.vo.HypertensionVisit;

public class HypertensionVisitBO extends HypertensionVisit {
	public List<HypertensionSymptom> hypertensionSymptom;
	public List<HypertensionMedications> hypertensionMedications;
	
	public List<HypertensionSymptom> getHypertensionSymptom() {
		return hypertensionSymptom;
	}
	public void setHypertensionSymptom(List<HypertensionSymptom> hypertensionSymptom) {
		this.hypertensionSymptom = hypertensionSymptom;
	}
	public List<HypertensionMedications> getHypertensionMedications() {
		return hypertensionMedications;
	}
	public void setHypertensionMedications(
			List<HypertensionMedications> hypertensionMedications) {
		this.hypertensionMedications = hypertensionMedications;
	}
	
	
}
