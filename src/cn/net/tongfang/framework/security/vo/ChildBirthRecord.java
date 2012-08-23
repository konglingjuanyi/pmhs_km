package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * ChildBirthRecord entity. @author MyEclipse Persistence Tools
 */

public class ChildBirthRecord implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private Integer childbirthYear;
	private Integer childbirthMonth;
	private Integer childbirthDay;
	private Double flooding;
	private String childbirthAddress;
	private String borthWeekly;
	private String childbirthWay;
	private String deliverWay;
	private String lacerationOfPerineum;
	private Integer outerFissure;
	private String bloodPressure;
	private String deal;
	private String comorbidity;
	private String comorbidityOther;
	private String criticalWoman;
	private String criticalSymptom;
	private String babySurvive;
	private String babyBirth;
	private String babyBirthOther;
	private String babyComorbidity;
	private String babyComorbidityOther;
	private String nurseTime;
	private String diagnosis;
	private String certifiId;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;
	// Constructors

	/** default constructor */
	public ChildBirthRecord() {
	}

	/** minimal constructor */
	public ChildBirthRecord(String fileNo, String certifiId) {
		this.fileNo = fileNo;
		this.certifiId = certifiId;
	}

	/** full constructor */
	public ChildBirthRecord(String fileNo, Integer childbirthYear,
			Integer childbirthMonth, Integer childbirthDay, Double flooding,
			String childbirthAddress, String borthWeekly, String childbirthWay,
			String deliverWay, String lacerationOfPerineum,
			Integer outerFissure, String bloodPressure, String deal,
			String comorbidity, String comorbidityOther, String criticalWoman,
			String criticalSymptom, String babySurvive, String babyBirth,
			String babyBirthOther, String babyComorbidity,
			String babyComorbidityOther, String nurseTime, String diagnosis,
			String certifiId,String inputPersonId,Timestamp inputDate,
			String execDistrictNum) {
		this.fileNo = fileNo;
		this.childbirthYear = childbirthYear;
		this.childbirthMonth = childbirthMonth;
		this.childbirthDay = childbirthDay;
		this.flooding = flooding;
		this.childbirthAddress = childbirthAddress;
		this.borthWeekly = borthWeekly;
		this.childbirthWay = childbirthWay;
		this.deliverWay = deliverWay;
		this.lacerationOfPerineum = lacerationOfPerineum;
		this.outerFissure = outerFissure;
		this.bloodPressure = bloodPressure;
		this.deal = deal;
		this.comorbidity = comorbidity;
		this.comorbidityOther = comorbidityOther;
		this.criticalWoman = criticalWoman;
		this.criticalSymptom = criticalSymptom;
		this.babySurvive = babySurvive;
		this.babyBirth = babyBirth;
		this.babyBirthOther = babyBirthOther;
		this.babyComorbidity = babyComorbidity;
		this.babyComorbidityOther = babyComorbidityOther;
		this.nurseTime = nurseTime;
		this.diagnosis = diagnosis;
		this.certifiId = certifiId;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.execDistrictNum = execDistrictNum;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Integer getChildbirthYear() {
		return this.childbirthYear;
	}

	public void setChildbirthYear(Integer childbirthYear) {
		this.childbirthYear = childbirthYear;
	}

	public Integer getChildbirthMonth() {
		return this.childbirthMonth;
	}

	public void setChildbirthMonth(Integer childbirthMonth) {
		this.childbirthMonth = childbirthMonth;
	}

	public Integer getChildbirthDay() {
		return this.childbirthDay;
	}

	public void setChildbirthDay(Integer childbirthDay) {
		this.childbirthDay = childbirthDay;
	}

	public Double getFlooding() {
		return this.flooding;
	}

	public void setFlooding(Double flooding) {
		this.flooding = flooding;
	}

	public String getChildbirthAddress() {
		return this.childbirthAddress;
	}

	public void setChildbirthAddress(String childbirthAddress) {
		this.childbirthAddress = childbirthAddress;
	}

	public String getBorthWeekly() {
		return this.borthWeekly;
	}

	public void setBorthWeekly(String borthWeekly) {
		this.borthWeekly = borthWeekly;
	}

	public String getChildbirthWay() {
		return this.childbirthWay;
	}

	public void setChildbirthWay(String childbirthWay) {
		this.childbirthWay = childbirthWay;
	}

	public String getDeliverWay() {
		return this.deliverWay;
	}

	public void setDeliverWay(String deliverWay) {
		this.deliverWay = deliverWay;
	}

	public String getLacerationOfPerineum() {
		return this.lacerationOfPerineum;
	}

	public void setLacerationOfPerineum(String lacerationOfPerineum) {
		this.lacerationOfPerineum = lacerationOfPerineum;
	}

	public Integer getOuterFissure() {
		return this.outerFissure;
	}

	public void setOuterFissure(Integer outerFissure) {
		this.outerFissure = outerFissure;
	}

	public String getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getDeal() {
		return this.deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public String getComorbidity() {
		return this.comorbidity;
	}

	public void setComorbidity(String comorbidity) {
		this.comorbidity = comorbidity;
	}

	public String getComorbidityOther() {
		return this.comorbidityOther;
	}

	public void setComorbidityOther(String comorbidityOther) {
		this.comorbidityOther = comorbidityOther;
	}

	public String getCriticalWoman() {
		return this.criticalWoman;
	}

	public void setCriticalWoman(String criticalWoman) {
		this.criticalWoman = criticalWoman;
	}

	public String getCriticalSymptom() {
		return this.criticalSymptom;
	}

	public void setCriticalSymptom(String criticalSymptom) {
		this.criticalSymptom = criticalSymptom;
	}

	public String getBabySurvive() {
		return this.babySurvive;
	}

	public void setBabySurvive(String babySurvive) {
		this.babySurvive = babySurvive;
	}

	public String getBabyBirth() {
		return this.babyBirth;
	}

	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}

	public String getBabyBirthOther() {
		return this.babyBirthOther;
	}

	public void setBabyBirthOther(String babyBirthOther) {
		this.babyBirthOther = babyBirthOther;
	}

	public String getBabyComorbidity() {
		return this.babyComorbidity;
	}

	public void setBabyComorbidity(String babyComorbidity) {
		this.babyComorbidity = babyComorbidity;
	}

	public String getBabyComorbidityOther() {
		return this.babyComorbidityOther;
	}

	public void setBabyComorbidityOther(String babyComorbidityOther) {
		this.babyComorbidityOther = babyComorbidityOther;
	}

	public String getNurseTime() {
		return this.nurseTime;
	}

	public void setNurseTime(String nurseTime) {
		this.nurseTime = nurseTime;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getCertifiId() {
		return this.certifiId;
	}

	public void setCertifiId(String certifiId) {
		this.certifiId = certifiId;
	}

	public String getInputPersonId() {
		return inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getInputDate() {
		return inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}