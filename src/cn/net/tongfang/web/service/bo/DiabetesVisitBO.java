package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.DiabetesMedications;
import cn.net.tongfang.framework.security.vo.DiabetesSymptom;
import cn.net.tongfang.framework.security.vo.DiabetesVisit;

public class DiabetesVisitBO extends DiabetesVisit{
	List<DiabetesSymptom> diabetesSymptom;
	List<DiabetesMedications> diabetesMedications;
	
	public List<DiabetesSymptom> getDiabetesSymptom() {
		return diabetesSymptom;
	}

	public void setDiabetesSymptom(List<DiabetesSymptom> diabetesSymptom) {
		this.diabetesSymptom = diabetesSymptom;
	}

	public List<DiabetesMedications> getDiabetesMedications() {
		return diabetesMedications;
	}

	public void setDiabetesMedications(List<DiabetesMedications> diabetesMedications) {
		this.diabetesMedications = diabetesMedications;
	}
	
	
}
