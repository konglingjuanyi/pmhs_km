package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.DangerControl;
import cn.net.tongfang.framework.security.vo.DrinkHabit;
import cn.net.tongfang.framework.security.vo.EatHabit;
import cn.net.tongfang.framework.security.vo.ExamMedications;
import cn.net.tongfang.framework.security.vo.ExamSymptom;
import cn.net.tongfang.framework.security.vo.EyeSick;
import cn.net.tongfang.framework.security.vo.Galactophore;
import cn.net.tongfang.framework.security.vo.HarnsSick;
import cn.net.tongfang.framework.security.vo.HealthDirect;
import cn.net.tongfang.framework.security.vo.HeartSick;
import cn.net.tongfang.framework.security.vo.Hospitalization;
import cn.net.tongfang.framework.security.vo.KidneySick;
import cn.net.tongfang.framework.security.vo.MedicalExam;
import cn.net.tongfang.framework.security.vo.VaccinateHistory;
import cn.net.tongfang.framework.security.vo.VasSick;

public class MedicalExamBO extends MedicalExam {
	
	List<ExamSymptom> examSymptom;
	List<EatHabit> eatHabit;

	List<DrinkHabit> drinkHabit;
	List<Galactophore> galactophore;

	// page2
	List<HarnsSick> harnsSick;
	List<KidneySick> kidneySick;
	List<HeartSick> heartSick;
	List<VasSick> vasSick;
	List<EyeSick> eyeSick;

	List<ExamMedications> examMedications;

	List<VaccinateHistory> vaccinateHistory;
	List<DangerControl> dangerControl;
	
	List<Hospitalization> hospitalization;
	List<HealthDirect> healthDirect;
	
	public List<ExamSymptom> getExamSymptom() {
		return examSymptom;
	}
	public void setExamSymptom(List<ExamSymptom> examSymptom) {
		this.examSymptom = examSymptom;
	}
	public List<EatHabit> getEatHabit() {
		return eatHabit;
	}
	public void setEatHabit(List<EatHabit> eatHabit) {
		this.eatHabit = eatHabit;
	}
	public List<DrinkHabit> getDrinkHabit() {
		return drinkHabit;
	}
	public void setDrinkHabit(List<DrinkHabit> drinkHabit) {
		this.drinkHabit = drinkHabit;
	}
	public List<Galactophore> getGalactophore() {
		return galactophore;
	}
	public void setGalactophore(List<Galactophore> galactophore) {
		this.galactophore = galactophore;
	}
	public List<HarnsSick> getHarnsSick() {
		return harnsSick;
	}
	public void setHarnsSick(List<HarnsSick> harnsSick) {
		this.harnsSick = harnsSick;
	}
	public List<KidneySick> getKidneySick() {
		return kidneySick;
	}
	public void setKidneySick(List<KidneySick> kidneySick) {
		this.kidneySick = kidneySick;
	}
	public List<HeartSick> getHeartSick() {
		return heartSick;
	}
	public void setHeartSick(List<HeartSick> heartSick) {
		this.heartSick = heartSick;
	}
	public List<VasSick> getVasSick() {
		return vasSick;
	}
	public void setVasSick(List<VasSick> vasSick) {
		this.vasSick = vasSick;
	}
	public List<EyeSick> getEyeSick() {
		return eyeSick;
	}
	public void setEyeSick(List<EyeSick> eyeSick) {
		this.eyeSick = eyeSick;
	}
	public List<ExamMedications> getExamMedications() {
		return examMedications;
	}
	public void setExamMedications(List<ExamMedications> examMedications) {
		this.examMedications = examMedications;
	}
	public List<VaccinateHistory> getVaccinateHistory() {
		return vaccinateHistory;
	}
	public void setVaccinateHistory(List<VaccinateHistory> vaccinateHistory) {
		this.vaccinateHistory = vaccinateHistory;
	}
	public List<DangerControl> getDangerControl() {
		return dangerControl;
	}
	public void setDangerControl(List<DangerControl> dangerControl) {
		this.dangerControl = dangerControl;
	}
	public List<Hospitalization> getHospitalization() {
		return hospitalization;
	}
	public void setHospitalization(List<Hospitalization> hospitalization) {
		this.hospitalization = hospitalization;
	}
	public List<HealthDirect> getHealthDirect() {
		return healthDirect;
	}
	public void setHealthDirect(List<HealthDirect> healthDirect) {
		this.healthDirect = healthDirect;
	}
	
	
}
