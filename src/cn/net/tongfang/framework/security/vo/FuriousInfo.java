package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * FuriousInfo entity. @author MyEclipse Persistence Tools
 */

public class FuriousInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp inputDate;
	private String name;
	private String guardianName;
	private String relation;
	private String guardianAddress;
	private String guardianTel;
	private String contact;
	private String firstOccur;
	private String symptomOther;
	private String outpatient;
	private Integer inpatientTimes;
	private String recentDiagnose;
	private String hospital;
	private Timestamp confirmDate;
	private String recentCure;
	private Integer effect1;
	private Integer effect2;
	private Integer effect3;
	private Integer effect4;
	private Integer effect5;
	private String lockStatus;
	private String doctor;
	private String agreeSign;
	private Timestamp agreeSignDate;
	private String agree;
	private Timestamp outpatientDate;
	private String incomeStatus;
	private String doctorAdvice;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public FuriousInfo() {
	}

	/** minimal constructor */
	public FuriousInfo(String id, String fileNo, String inputPersonId,
			Timestamp inputDate, String name, Integer inpatientTimes,
			Timestamp confirmDate) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.name = name;
		this.inpatientTimes = inpatientTimes;
		this.confirmDate = confirmDate;
	}

	/** full constructor */
	public FuriousInfo(String id, String fileNo, String inputPersonId,
			Timestamp inputDate, String name, String guardianName,
			String relation, String guardianAddress, String guardianTel,
			String contact, String firstOccur, String symptomOther,
			String outpatient, Integer inpatientTimes, String recentDiagnose,
			String hospital, Timestamp confirmDate, String recentCure,
			Integer effect1, Integer effect2, Integer effect3, Integer effect4,
			Integer effect5, String lockStatus, String doctor,
			String agreeSign, Timestamp agreeSignDate, String agree,
			Timestamp outpatientDate, String incomeStatus, String doctorAdvice,
			String execDistrictNum) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.name = name;
		this.guardianName = guardianName;
		this.relation = relation;
		this.guardianAddress = guardianAddress;
		this.guardianTel = guardianTel;
		this.contact = contact;
		this.firstOccur = firstOccur;
		this.symptomOther = symptomOther;
		this.outpatient = outpatient;
		this.inpatientTimes = inpatientTimes;
		this.recentDiagnose = recentDiagnose;
		this.hospital = hospital;
		this.confirmDate = confirmDate;
		this.recentCure = recentCure;
		this.effect1 = effect1;
		this.effect2 = effect2;
		this.effect3 = effect3;
		this.effect4 = effect4;
		this.effect5 = effect5;
		this.lockStatus = lockStatus;
		this.doctor = doctor;
		this.agreeSign = agreeSign;
		this.agreeSignDate = agreeSignDate;
		this.agree = agree;
		this.outpatientDate = outpatientDate;
		this.incomeStatus = incomeStatus;
		this.doctorAdvice = doctorAdvice;
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

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getGuardianAddress() {
		return this.guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}

	public String getGuardianTel() {
		return this.guardianTel;
	}

	public void setGuardianTel(String guardianTel) {
		this.guardianTel = guardianTel;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFirstOccur() {
		return this.firstOccur;
	}

	public void setFirstOccur(String firstOccur) {
		this.firstOccur = firstOccur;
	}

	public String getSymptomOther() {
		return this.symptomOther;
	}

	public void setSymptomOther(String symptomOther) {
		this.symptomOther = symptomOther;
	}

	public String getOutpatient() {
		return this.outpatient;
	}

	public void setOutpatient(String outpatient) {
		this.outpatient = outpatient;
	}

	public Integer getInpatientTimes() {
		return this.inpatientTimes;
	}

	public void setInpatientTimes(Integer inpatientTimes) {
		this.inpatientTimes = inpatientTimes;
	}

	public String getRecentDiagnose() {
		return this.recentDiagnose;
	}

	public void setRecentDiagnose(String recentDiagnose) {
		this.recentDiagnose = recentDiagnose;
	}

	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Timestamp getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Timestamp confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getRecentCure() {
		return this.recentCure;
	}

	public void setRecentCure(String recentCure) {
		this.recentCure = recentCure;
	}

	public Integer getEffect1() {
		return this.effect1;
	}

	public void setEffect1(Integer effect1) {
		this.effect1 = effect1;
	}

	public Integer getEffect2() {
		return this.effect2;
	}

	public void setEffect2(Integer effect2) {
		this.effect2 = effect2;
	}

	public Integer getEffect3() {
		return this.effect3;
	}

	public void setEffect3(Integer effect3) {
		this.effect3 = effect3;
	}

	public Integer getEffect4() {
		return this.effect4;
	}

	public void setEffect4(Integer effect4) {
		this.effect4 = effect4;
	}

	public Integer getEffect5() {
		return this.effect5;
	}

	public void setEffect5(Integer effect5) {
		this.effect5 = effect5;
	}

	public String getLockStatus() {
		return this.lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getAgreeSign() {
		return this.agreeSign;
	}

	public void setAgreeSign(String agreeSign) {
		this.agreeSign = agreeSign;
	}

	public Timestamp getAgreeSignDate() {
		return this.agreeSignDate;
	}

	public void setAgreeSignDate(Timestamp agreeSignDate) {
		this.agreeSignDate = agreeSignDate;
	}

	public String getAgree() {
		return this.agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public Timestamp getOutpatientDate() {
		return this.outpatientDate;
	}

	public void setOutpatientDate(Timestamp outpatientDate) {
		this.outpatientDate = outpatientDate;
	}

	public String getIncomeStatus() {
		return this.incomeStatus;
	}

	public void setIncomeStatus(String incomeStatus) {
		this.incomeStatus = incomeStatus;
	}

	public String getDoctorAdvice() {
		return this.doctorAdvice;
	}

	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}