package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.FuriousHealing;
import cn.net.tongfang.framework.security.vo.FuriousMedications;
import cn.net.tongfang.framework.security.vo.FuriousVisit;
import cn.net.tongfang.framework.security.vo.FuriousVisitSymptom;

public class FuriousVisitBO extends FuriousVisit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<FuriousVisitSymptom> furiousVisitSymptom;
	List<FuriousMedications> furiousMedications;
	List<FuriousHealing> furiousHealing;
	
	public List<FuriousVisitSymptom> getFuriousVisitSymptom() {
		return furiousVisitSymptom;
	}
	public void setFuriousVisitSymptom(List<FuriousVisitSymptom> furiousVisitSymptom) {
		this.furiousVisitSymptom = furiousVisitSymptom;
	}
	public List<FuriousMedications> getFuriousMedications() {
		return furiousMedications;
	}
	public void setFuriousMedications(List<FuriousMedications> furiousMedications) {
		this.furiousMedications = furiousMedications;
	}
	public List<FuriousHealing> getFuriousHealing() {
		return furiousHealing;
	}
	public void setFuriousHealing(List<FuriousHealing> furiousHealing) {
		this.furiousHealing = furiousHealing;
	}
	
	
}
