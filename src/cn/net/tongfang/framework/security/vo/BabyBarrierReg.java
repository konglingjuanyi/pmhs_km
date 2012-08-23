package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BabyBarrierReg entity. @author MyEclipse Persistence Tools
 */

public class BabyBarrierReg implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String name;
	private String sex;
	private String nation;
	private Timestamp birthday;
	private Integer age;
	private Integer ageMonth;
	private Integer ageDay;
	private Integer ageHours;
	private String familyAddress;
	private String post;
	private String tel;
	private String fatherName;
	private Integer fatherAge;
	private String fatherOccupation;
	private String motherName;
	private Integer motherAge;
	private String motherOccupation;
	private String screeningWay;
	private Timestamp screeningDate;
	private String screeningResult;
	private Integer fetalNumber;
	private Integer yieldNumber;
	private Double weight;
	private String fetalWay;
	private String childBirthWay;
	private String birthDefact;
	private String birthDefactOther;
	private String birthDistress;
	private String apgar;
	private String apgarOther;
	private String yieldHurt;
	private String yieldHurtOther;
	private String amnioticFluid;
	private String childBirthException;
	private String deformity;
	private String deformityOther;
	private String infection;
	private String infectionReason;
	private String infectionCourse;
	private String ill;
	private String illReason;
	private String illCourse;
	private String headHurt;
	private String headHurtOther;
	private String otitisHistory;
	private String otitisHistoryOther;
	private String nicu;
	private String nicureason;
	private String nicudate;
	private String ventilator;
	private String ventilatorReason;
	private String ventilatorDate;
	private String otherReaction;
	private Integer childBirthAge;
	private String abortionHistory;
	private Timestamp abortionDate;
	private String abortionReasion;
	private String abortionWay;
	private String infectionHistory;
	private String infectionHistoryOther;
	private String infectionHistoryWeek;
	private String infectionHistory1;
	private String infectionHistory1other;
	private String infectionHistory1week;
	private String contactHistory;
	private Timestamp contactHistoryDate;
	private String contactHistoryWeek;
	private String appHistory;
	private String appHistoryDrugName;
	private Timestamp appHistoryDrugDate;
	private String contactHistory1;
	private Timestamp contactHistory1date;
	private String smoking;
	private String dreaking;
	private String drugging;
	private String illHistory;
	private String illHistoryOther;
	private String exceptionHistory;
	private String exceptionHistoryOther;
	private String familySmoking;
	private String familyDreaking;
	private String familyDrugging;
	private String deaf;
	private String deafRelation;
	private String deafSituation;
	private String intermarriage;
	private String intermarriageRelation;
	private String hearExamResult;
	private String diagnosisResult;
	private String diagnosisDoctor;
	private String ototoxicityDrugHistoryId;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public BabyBarrierReg() {
	}

	/** minimal constructor */
	public BabyBarrierReg(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public BabyBarrierReg(String fileNo, String name, String sex,
			String nation, Timestamp birthday, Integer age, Integer ageMonth,
			Integer ageDay, Integer ageHours, String familyAddress,
			String post, String tel, String fatherName, Integer fatherAge,
			String fatherOccupation, String motherName, Integer motherAge,
			String motherOccupation, String screeningWay,
			Timestamp screeningDate, String screeningResult,
			Integer fetalNumber, Integer yieldNumber, Double weight,
			String fetalWay, String childBirthWay, String birthDefact,
			String birthDefactOther, String birthDistress, String apgar,
			String apgarOther, String yieldHurt, String yieldHurtOther,
			String amnioticFluid, String childBirthException, String deformity,
			String deformityOther, String infection, String infectionReason,
			String infectionCourse, String ill, String illReason,
			String illCourse, String headHurt, String headHurtOther,
			String otitisHistory, String otitisHistoryOther, String nicu,
			String nicureason, String nicudate, String ventilator,
			String ventilatorReason, String ventilatorDate,
			String otherReaction, Integer childBirthAge,
			String abortionHistory, Timestamp abortionDate,
			String abortionReasion, String abortionWay,
			String infectionHistory, String infectionHistoryOther,
			String infectionHistoryWeek, String infectionHistory1,
			String infectionHistory1other, String infectionHistory1week,
			String contactHistory, Timestamp contactHistoryDate,
			String contactHistoryWeek, String appHistory,
			String appHistoryDrugName, Timestamp appHistoryDrugDate,
			String contactHistory1, Timestamp contactHistory1date,
			String smoking, String dreaking, String drugging,
			String illHistory, String illHistoryOther, String exceptionHistory,
			String exceptionHistoryOther, String familySmoking,
			String familyDreaking, String familyDrugging, String deaf,
			String deafRelation, String deafSituation, String intermarriage,
			String intermarriageRelation, String hearExamResult,
			String diagnosisResult, String diagnosisDoctor,
			String ototoxicityDrugHistoryId, String inputPersonId,
			Timestamp inputDate, String execDistrictNum) {
		this.fileNo = fileNo;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.age = age;
		this.ageMonth = ageMonth;
		this.ageDay = ageDay;
		this.ageHours = ageHours;
		this.familyAddress = familyAddress;
		this.post = post;
		this.tel = tel;
		this.fatherName = fatherName;
		this.fatherAge = fatherAge;
		this.fatherOccupation = fatherOccupation;
		this.motherName = motherName;
		this.motherAge = motherAge;
		this.motherOccupation = motherOccupation;
		this.screeningWay = screeningWay;
		this.screeningDate = screeningDate;
		this.screeningResult = screeningResult;
		this.fetalNumber = fetalNumber;
		this.yieldNumber = yieldNumber;
		this.weight = weight;
		this.fetalWay = fetalWay;
		this.childBirthWay = childBirthWay;
		this.birthDefact = birthDefact;
		this.birthDefactOther = birthDefactOther;
		this.birthDistress = birthDistress;
		this.apgar = apgar;
		this.apgarOther = apgarOther;
		this.yieldHurt = yieldHurt;
		this.yieldHurtOther = yieldHurtOther;
		this.amnioticFluid = amnioticFluid;
		this.childBirthException = childBirthException;
		this.deformity = deformity;
		this.deformityOther = deformityOther;
		this.infection = infection;
		this.infectionReason = infectionReason;
		this.infectionCourse = infectionCourse;
		this.ill = ill;
		this.illReason = illReason;
		this.illCourse = illCourse;
		this.headHurt = headHurt;
		this.headHurtOther = headHurtOther;
		this.otitisHistory = otitisHistory;
		this.otitisHistoryOther = otitisHistoryOther;
		this.nicu = nicu;
		this.nicureason = nicureason;
		this.nicudate = nicudate;
		this.ventilator = ventilator;
		this.ventilatorReason = ventilatorReason;
		this.ventilatorDate = ventilatorDate;
		this.otherReaction = otherReaction;
		this.childBirthAge = childBirthAge;
		this.abortionHistory = abortionHistory;
		this.abortionDate = abortionDate;
		this.abortionReasion = abortionReasion;
		this.abortionWay = abortionWay;
		this.infectionHistory = infectionHistory;
		this.infectionHistoryOther = infectionHistoryOther;
		this.infectionHistoryWeek = infectionHistoryWeek;
		this.infectionHistory1 = infectionHistory1;
		this.infectionHistory1other = infectionHistory1other;
		this.infectionHistory1week = infectionHistory1week;
		this.contactHistory = contactHistory;
		this.contactHistoryDate = contactHistoryDate;
		this.contactHistoryWeek = contactHistoryWeek;
		this.appHistory = appHistory;
		this.appHistoryDrugName = appHistoryDrugName;
		this.appHistoryDrugDate = appHistoryDrugDate;
		this.contactHistory1 = contactHistory1;
		this.contactHistory1date = contactHistory1date;
		this.smoking = smoking;
		this.dreaking = dreaking;
		this.drugging = drugging;
		this.illHistory = illHistory;
		this.illHistoryOther = illHistoryOther;
		this.exceptionHistory = exceptionHistory;
		this.exceptionHistoryOther = exceptionHistoryOther;
		this.familySmoking = familySmoking;
		this.familyDreaking = familyDreaking;
		this.familyDrugging = familyDrugging;
		this.deaf = deaf;
		this.deafRelation = deafRelation;
		this.deafSituation = deafSituation;
		this.intermarriage = intermarriage;
		this.intermarriageRelation = intermarriageRelation;
		this.hearExamResult = hearExamResult;
		this.diagnosisResult = diagnosisResult;
		this.diagnosisDoctor = diagnosisDoctor;
		this.ototoxicityDrugHistoryId = ototoxicityDrugHistoryId;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAgeMonth() {
		return this.ageMonth;
	}

	public void setAgeMonth(Integer ageMonth) {
		this.ageMonth = ageMonth;
	}

	public Integer getAgeDay() {
		return this.ageDay;
	}

	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}

	public Integer getAgeHours() {
		return this.ageHours;
	}

	public void setAgeHours(Integer ageHours) {
		this.ageHours = ageHours;
	}

	public String getFamilyAddress() {
		return this.familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getFatherAge() {
		return this.fatherAge;
	}

	public void setFatherAge(Integer fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getFatherOccupation() {
		return this.fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Integer getMotherAge() {
		return this.motherAge;
	}

	public void setMotherAge(Integer motherAge) {
		this.motherAge = motherAge;
	}

	public String getMotherOccupation() {
		return this.motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public String getScreeningWay() {
		return this.screeningWay;
	}

	public void setScreeningWay(String screeningWay) {
		this.screeningWay = screeningWay;
	}

	public Timestamp getScreeningDate() {
		return this.screeningDate;
	}

	public void setScreeningDate(Timestamp screeningDate) {
		this.screeningDate = screeningDate;
	}

	public String getScreeningResult() {
		return this.screeningResult;
	}

	public void setScreeningResult(String screeningResult) {
		this.screeningResult = screeningResult;
	}

	public Integer getFetalNumber() {
		return this.fetalNumber;
	}

	public void setFetalNumber(Integer fetalNumber) {
		this.fetalNumber = fetalNumber;
	}

	public Integer getYieldNumber() {
		return this.yieldNumber;
	}

	public void setYieldNumber(Integer yieldNumber) {
		this.yieldNumber = yieldNumber;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getFetalWay() {
		return this.fetalWay;
	}

	public void setFetalWay(String fetalWay) {
		this.fetalWay = fetalWay;
	}

	public String getChildBirthWay() {
		return this.childBirthWay;
	}

	public void setChildBirthWay(String childBirthWay) {
		this.childBirthWay = childBirthWay;
	}

	public String getBirthDefact() {
		return this.birthDefact;
	}

	public void setBirthDefact(String birthDefact) {
		this.birthDefact = birthDefact;
	}

	public String getBirthDefactOther() {
		return this.birthDefactOther;
	}

	public void setBirthDefactOther(String birthDefactOther) {
		this.birthDefactOther = birthDefactOther;
	}

	public String getBirthDistress() {
		return this.birthDistress;
	}

	public void setBirthDistress(String birthDistress) {
		this.birthDistress = birthDistress;
	}

	public String getApgar() {
		return this.apgar;
	}

	public void setApgar(String apgar) {
		this.apgar = apgar;
	}

	public String getApgarOther() {
		return this.apgarOther;
	}

	public void setApgarOther(String apgarOther) {
		this.apgarOther = apgarOther;
	}

	public String getYieldHurt() {
		return this.yieldHurt;
	}

	public void setYieldHurt(String yieldHurt) {
		this.yieldHurt = yieldHurt;
	}

	public String getYieldHurtOther() {
		return this.yieldHurtOther;
	}

	public void setYieldHurtOther(String yieldHurtOther) {
		this.yieldHurtOther = yieldHurtOther;
	}

	public String getAmnioticFluid() {
		return this.amnioticFluid;
	}

	public void setAmnioticFluid(String amnioticFluid) {
		this.amnioticFluid = amnioticFluid;
	}

	public String getChildBirthException() {
		return this.childBirthException;
	}

	public void setChildBirthException(String childBirthException) {
		this.childBirthException = childBirthException;
	}

	public String getDeformity() {
		return this.deformity;
	}

	public void setDeformity(String deformity) {
		this.deformity = deformity;
	}

	public String getDeformityOther() {
		return this.deformityOther;
	}

	public void setDeformityOther(String deformityOther) {
		this.deformityOther = deformityOther;
	}

	public String getInfection() {
		return this.infection;
	}

	public void setInfection(String infection) {
		this.infection = infection;
	}

	public String getInfectionReason() {
		return this.infectionReason;
	}

	public void setInfectionReason(String infectionReason) {
		this.infectionReason = infectionReason;
	}

	public String getInfectionCourse() {
		return this.infectionCourse;
	}

	public void setInfectionCourse(String infectionCourse) {
		this.infectionCourse = infectionCourse;
	}

	public String getIll() {
		return this.ill;
	}

	public void setIll(String ill) {
		this.ill = ill;
	}

	public String getIllReason() {
		return this.illReason;
	}

	public void setIllReason(String illReason) {
		this.illReason = illReason;
	}

	public String getIllCourse() {
		return this.illCourse;
	}

	public void setIllCourse(String illCourse) {
		this.illCourse = illCourse;
	}

	public String getHeadHurt() {
		return this.headHurt;
	}

	public void setHeadHurt(String headHurt) {
		this.headHurt = headHurt;
	}

	public String getHeadHurtOther() {
		return this.headHurtOther;
	}

	public void setHeadHurtOther(String headHurtOther) {
		this.headHurtOther = headHurtOther;
	}

	public String getOtitisHistory() {
		return this.otitisHistory;
	}

	public void setOtitisHistory(String otitisHistory) {
		this.otitisHistory = otitisHistory;
	}

	public String getOtitisHistoryOther() {
		return this.otitisHistoryOther;
	}

	public void setOtitisHistoryOther(String otitisHistoryOther) {
		this.otitisHistoryOther = otitisHistoryOther;
	}

	public String getNicu() {
		return this.nicu;
	}

	public void setNicu(String nicu) {
		this.nicu = nicu;
	}

	public String getNicureason() {
		return this.nicureason;
	}

	public void setNicureason(String nicureason) {
		this.nicureason = nicureason;
	}

	public String getNicudate() {
		return this.nicudate;
	}

	public void setNicudate(String nicudate) {
		this.nicudate = nicudate;
	}

	public String getVentilator() {
		return this.ventilator;
	}

	public void setVentilator(String ventilator) {
		this.ventilator = ventilator;
	}

	public String getVentilatorReason() {
		return this.ventilatorReason;
	}

	public void setVentilatorReason(String ventilatorReason) {
		this.ventilatorReason = ventilatorReason;
	}

	public String getVentilatorDate() {
		return this.ventilatorDate;
	}

	public void setVentilatorDate(String ventilatorDate) {
		this.ventilatorDate = ventilatorDate;
	}

	public String getOtherReaction() {
		return this.otherReaction;
	}

	public void setOtherReaction(String otherReaction) {
		this.otherReaction = otherReaction;
	}

	public Integer getChildBirthAge() {
		return this.childBirthAge;
	}

	public void setChildBirthAge(Integer childBirthAge) {
		this.childBirthAge = childBirthAge;
	}

	public String getAbortionHistory() {
		return this.abortionHistory;
	}

	public void setAbortionHistory(String abortionHistory) {
		this.abortionHistory = abortionHistory;
	}

	public Timestamp getAbortionDate() {
		return this.abortionDate;
	}

	public void setAbortionDate(Timestamp abortionDate) {
		this.abortionDate = abortionDate;
	}

	public String getAbortionReasion() {
		return this.abortionReasion;
	}

	public void setAbortionReasion(String abortionReasion) {
		this.abortionReasion = abortionReasion;
	}

	public String getAbortionWay() {
		return this.abortionWay;
	}

	public void setAbortionWay(String abortionWay) {
		this.abortionWay = abortionWay;
	}

	public String getInfectionHistory() {
		return this.infectionHistory;
	}

	public void setInfectionHistory(String infectionHistory) {
		this.infectionHistory = infectionHistory;
	}

	public String getInfectionHistoryOther() {
		return this.infectionHistoryOther;
	}

	public void setInfectionHistoryOther(String infectionHistoryOther) {
		this.infectionHistoryOther = infectionHistoryOther;
	}

	public String getInfectionHistoryWeek() {
		return this.infectionHistoryWeek;
	}

	public void setInfectionHistoryWeek(String infectionHistoryWeek) {
		this.infectionHistoryWeek = infectionHistoryWeek;
	}

	public String getInfectionHistory1() {
		return this.infectionHistory1;
	}

	public void setInfectionHistory1(String infectionHistory1) {
		this.infectionHistory1 = infectionHistory1;
	}

	public String getInfectionHistory1other() {
		return this.infectionHistory1other;
	}

	public void setInfectionHistory1other(String infectionHistory1other) {
		this.infectionHistory1other = infectionHistory1other;
	}

	public String getInfectionHistory1week() {
		return this.infectionHistory1week;
	}

	public void setInfectionHistory1week(String infectionHistory1week) {
		this.infectionHistory1week = infectionHistory1week;
	}

	public String getContactHistory() {
		return this.contactHistory;
	}

	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}

	public Timestamp getContactHistoryDate() {
		return this.contactHistoryDate;
	}

	public void setContactHistoryDate(Timestamp contactHistoryDate) {
		this.contactHistoryDate = contactHistoryDate;
	}

	public String getContactHistoryWeek() {
		return this.contactHistoryWeek;
	}

	public void setContactHistoryWeek(String contactHistoryWeek) {
		this.contactHistoryWeek = contactHistoryWeek;
	}

	public String getAppHistory() {
		return this.appHistory;
	}

	public void setAppHistory(String appHistory) {
		this.appHistory = appHistory;
	}

	public String getAppHistoryDrugName() {
		return this.appHistoryDrugName;
	}

	public void setAppHistoryDrugName(String appHistoryDrugName) {
		this.appHistoryDrugName = appHistoryDrugName;
	}

	public Timestamp getAppHistoryDrugDate() {
		return this.appHistoryDrugDate;
	}

	public void setAppHistoryDrugDate(Timestamp appHistoryDrugDate) {
		this.appHistoryDrugDate = appHistoryDrugDate;
	}

	public String getContactHistory1() {
		return this.contactHistory1;
	}

	public void setContactHistory1(String contactHistory1) {
		this.contactHistory1 = contactHistory1;
	}

	public Timestamp getContactHistory1date() {
		return this.contactHistory1date;
	}

	public void setContactHistory1date(Timestamp contactHistory1date) {
		this.contactHistory1date = contactHistory1date;
	}

	public String getSmoking() {
		return this.smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDreaking() {
		return this.dreaking;
	}

	public void setDreaking(String dreaking) {
		this.dreaking = dreaking;
	}

	public String getDrugging() {
		return this.drugging;
	}

	public void setDrugging(String drugging) {
		this.drugging = drugging;
	}

	public String getIllHistory() {
		return this.illHistory;
	}

	public void setIllHistory(String illHistory) {
		this.illHistory = illHistory;
	}

	public String getIllHistoryOther() {
		return this.illHistoryOther;
	}

	public void setIllHistoryOther(String illHistoryOther) {
		this.illHistoryOther = illHistoryOther;
	}

	public String getExceptionHistory() {
		return this.exceptionHistory;
	}

	public void setExceptionHistory(String exceptionHistory) {
		this.exceptionHistory = exceptionHistory;
	}

	public String getExceptionHistoryOther() {
		return this.exceptionHistoryOther;
	}

	public void setExceptionHistoryOther(String exceptionHistoryOther) {
		this.exceptionHistoryOther = exceptionHistoryOther;
	}

	public String getFamilySmoking() {
		return this.familySmoking;
	}

	public void setFamilySmoking(String familySmoking) {
		this.familySmoking = familySmoking;
	}

	public String getFamilyDreaking() {
		return this.familyDreaking;
	}

	public void setFamilyDreaking(String familyDreaking) {
		this.familyDreaking = familyDreaking;
	}

	public String getFamilyDrugging() {
		return this.familyDrugging;
	}

	public void setFamilyDrugging(String familyDrugging) {
		this.familyDrugging = familyDrugging;
	}

	public String getDeaf() {
		return this.deaf;
	}

	public void setDeaf(String deaf) {
		this.deaf = deaf;
	}

	public String getDeafRelation() {
		return this.deafRelation;
	}

	public void setDeafRelation(String deafRelation) {
		this.deafRelation = deafRelation;
	}

	public String getDeafSituation() {
		return this.deafSituation;
	}

	public void setDeafSituation(String deafSituation) {
		this.deafSituation = deafSituation;
	}

	public String getIntermarriage() {
		return this.intermarriage;
	}

	public void setIntermarriage(String intermarriage) {
		this.intermarriage = intermarriage;
	}

	public String getIntermarriageRelation() {
		return this.intermarriageRelation;
	}

	public void setIntermarriageRelation(String intermarriageRelation) {
		this.intermarriageRelation = intermarriageRelation;
	}

	public String getHearExamResult() {
		return this.hearExamResult;
	}

	public void setHearExamResult(String hearExamResult) {
		this.hearExamResult = hearExamResult;
	}

	public String getDiagnosisResult() {
		return this.diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getDiagnosisDoctor() {
		return this.diagnosisDoctor;
	}

	public void setDiagnosisDoctor(String diagnosisDoctor) {
		this.diagnosisDoctor = diagnosisDoctor;
	}

	public String getOtotoxicityDrugHistoryId() {
		return this.ototoxicityDrugHistoryId;
	}

	public void setOtotoxicityDrugHistoryId(String ototoxicityDrugHistoryId) {
		this.ototoxicityDrugHistoryId = ototoxicityDrugHistoryId;
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

	public String getExecDistrictNum() {
		return this.execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}