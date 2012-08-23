package cn.net.tongfang.framework.security.vo;

// Generated by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * HypertensionVisit generated by hbm2java
 */
public class HypertensionVisit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp inputDate;
	private Timestamp visitDate;
	private String visitKind;
	private String symptomOther;
	private String compliance;
	private String adr;
	private String adrother;
	private String visitType;
	private Integer transfer;
	private String transReason;
	private String transUnit;
	private Timestamp nextVistDate;
	private String visitDoctor;
	private BigDecimal diastolicPressure;
	private BigDecimal systolicPressure;
	private BigDecimal weight;
	private BigDecimal habitus;
	private Integer heartRate;
	private String other;
	private Integer smoke;
	private String drink;
	private Integer sportTimes;
	private Integer sportDuration;
	private String salt;
	private String mindStatus;
	private String action;
	private String assistantExam;
	private String execDistrictNum;

	public HypertensionVisit() {
	}

	public HypertensionVisit(String fileNo, String inputPersonId,
			Timestamp inputDate, Timestamp visitDate) {
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.visitDate = visitDate;
	}

	public HypertensionVisit(String fileNo, String inputPersonId,
			Timestamp inputDate, Timestamp visitDate, String visitKind,
			String symptomOther, String compliance, String adr,
			String adrother, String visitType, Integer transfer,
			String transReason, String transUnit, Timestamp nextVistDate,
			String visitDoctor, BigDecimal diastolicPressure,
			BigDecimal systolicPressure, BigDecimal weight, BigDecimal habitus,
			Integer heartRate, String other, Integer smoke, String drink,
			Integer sportTimes, Integer sportDuration, String salt,
			String mindStatus, String action, String assistantExam,
			String execDistrictNum) {
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.visitDate = visitDate;
		this.visitKind = visitKind;
		this.symptomOther = symptomOther;
		this.compliance = compliance;
		this.adr = adr;
		this.adrother = adrother;
		this.visitType = visitType;
		this.transfer = transfer;
		this.transReason = transReason;
		this.transUnit = transUnit;
		this.nextVistDate = nextVistDate;
		this.visitDoctor = visitDoctor;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.weight = weight;
		this.habitus = habitus;
		this.heartRate = heartRate;
		this.other = other;
		this.smoke = smoke;
		this.drink = drink;
		this.sportTimes = sportTimes;
		this.sportDuration = sportDuration;
		this.salt = salt;
		this.mindStatus = mindStatus;
		this.action = action;
		this.assistantExam = assistantExam;
		this.execDistrictNum = execDistrictNum;
	}

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

	public Timestamp getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitKind() {
		return this.visitKind;
	}

	public void setVisitKind(String visitKind) {
		this.visitKind = visitKind;
	}

	public String getSymptomOther() {
		return this.symptomOther;
	}

	public void setSymptomOther(String symptomOther) {
		this.symptomOther = symptomOther;
	}

	public String getCompliance() {
		return this.compliance;
	}

	public void setCompliance(String compliance) {
		this.compliance = compliance;
	}

	public String getAdr() {
		return this.adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getAdrother() {
		return this.adrother;
	}

	public void setAdrother(String adrother) {
		this.adrother = adrother;
	}

	public String getVisitType() {
		return this.visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public Integer getTransfer() {
		return this.transfer;
	}

	public void setTransfer(Integer transfer) {
		this.transfer = transfer;
	}

	public String getTransReason() {
		return this.transReason;
	}

	public void setTransReason(String transReason) {
		this.transReason = transReason;
	}

	public String getTransUnit() {
		return this.transUnit;
	}

	public void setTransUnit(String transUnit) {
		this.transUnit = transUnit;
	}

	public Timestamp getNextVistDate() {
		return this.nextVistDate;
	}

	public void setNextVistDate(Timestamp nextVistDate) {
		this.nextVistDate = nextVistDate;
	}

	public String getVisitDoctor() {
		return this.visitDoctor;
	}

	public void setVisitDoctor(String visitDoctor) {
		this.visitDoctor = visitDoctor;
	}

	public BigDecimal getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(BigDecimal diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public BigDecimal getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(BigDecimal systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHabitus() {
		return this.habitus;
	}

	public void setHabitus(BigDecimal habitus) {
		this.habitus = habitus;
	}

	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getSmoke() {
		return this.smoke;
	}

	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}

	public String getDrink() {
		return this.drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public Integer getSportTimes() {
		return this.sportTimes;
	}

	public void setSportTimes(Integer sportTimes) {
		this.sportTimes = sportTimes;
	}

	public Integer getSportDuration() {
		return this.sportDuration;
	}

	public void setSportDuration(Integer sportDuration) {
		this.sportDuration = sportDuration;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMindStatus() {
		return this.mindStatus;
	}

	public void setMindStatus(String mindStatus) {
		this.mindStatus = mindStatus;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAssistantExam() {
		return this.assistantExam;
	}

	public void setAssistantExam(String assistantExam) {
		this.assistantExam = assistantExam;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}
