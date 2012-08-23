package cn.net.tongfang.framework.security.vo;

// Generated by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * VisitBeforeBorn generated by hbm2java
 */
public class VisitBeforeBorn implements java.io.Serializable {

	/**
	 * 
	 */
	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp inputDate;
	private Integer item;
	private Timestamp visitDate;
	private BigDecimal diastolicPressure;
	private BigDecimal systolicPressure;
	private String result;
	private String resultOther;
	private String beforeBornDirectOther;
	private Integer transfer;
	private String transReason;
	private String transUnit;
	private String visitDoctor;
	private Timestamp nextVisitDate;
	private String weeks;
	private String cc;
	private BigDecimal weight;
	private BigDecimal exam01;
	private BigDecimal exam02;
	private String exam03;
	private BigDecimal exam04;
	private String exam05;
	private String exam06;
	private String exam07;
	private String highRisk;
	private String highRiskRemark;
	private String execDistrictNum;
	private String highRiskSearch;
	private Integer gravidity;
	public VisitBeforeBorn() {
	}

	public VisitBeforeBorn(String fileNo, String inputPersonId,
			Timestamp inputDate, Integer item) {
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.item = item;
	}

	public VisitBeforeBorn(String fileNo, String inputPersonId,
			Timestamp inputDate, Integer item, Timestamp visitDate,
			BigDecimal diastolicPressure, BigDecimal systolicPressure,
			String result, String resultOther, String beforeBornDirectOther,
			Integer transfer, String transReason, String transUnit,
			String visitDoctor, Timestamp nextVisitDate, String weeks,
			String cc, BigDecimal weight, BigDecimal exam01, BigDecimal exam02,
			String exam03, BigDecimal exam04, String exam05, String exam06,String exam07,
			String highRisk,String highRiskRemark,String execDistrictNum,String highRiskSearch,
			Integer gravidity) {
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.item = item;
		this.visitDate = visitDate;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.result = result;
		this.resultOther = resultOther;
		this.beforeBornDirectOther = beforeBornDirectOther;
		this.transfer = transfer;
		this.transReason = transReason;
		this.transUnit = transUnit;
		this.visitDoctor = visitDoctor;
		this.nextVisitDate = nextVisitDate;
		this.weeks = weeks;
		this.cc = cc;
		this.weight = weight;
		this.exam01 = exam01;
		this.exam02 = exam02;
		this.exam03 = exam03;
		this.exam04 = exam04;
		this.exam05 = exam05;
		this.exam06 = exam06;
		this.exam07 = exam07;
		this.highRisk = highRisk;
		this.highRiskRemark = highRiskRemark;
		this.execDistrictNum = execDistrictNum;
		this.highRiskSearch = highRiskSearch;
		this.gravidity = gravidity;
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

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Timestamp getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
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

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultOther() {
		return this.resultOther;
	}

	public void setResultOther(String resultOther) {
		this.resultOther = resultOther;
	}

	public String getBeforeBornDirectOther() {
		return this.beforeBornDirectOther;
	}

	public void setBeforeBornDirectOther(String beforeBornDirectOther) {
		this.beforeBornDirectOther = beforeBornDirectOther;
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

	public String getVisitDoctor() {
		return this.visitDoctor;
	}

	public void setVisitDoctor(String visitDoctor) {
		this.visitDoctor = visitDoctor;
	}

	public Timestamp getNextVisitDate() {
		return this.nextVisitDate;
	}

	public void setNextVisitDate(Timestamp nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getWeeks() {
		return this.weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getExam01() {
		return this.exam01;
	}

	public void setExam01(BigDecimal exam01) {
		this.exam01 = exam01;
	}

	public BigDecimal getExam02() {
		return this.exam02;
	}

	public void setExam02(BigDecimal exam02) {
		this.exam02 = exam02;
	}

	public String getExam03() {
		return this.exam03;
	}

	public void setExam03(String exam03) {
		this.exam03 = exam03;
	}

	public BigDecimal getExam04() {
		return this.exam04;
	}

	public void setExam04(BigDecimal exam04) {
		this.exam04 = exam04;
	}

	public String getExam05() {
		return this.exam05;
	}

	public void setExam05(String exam05) {
		this.exam05 = exam05;
	}

	public String getExam06() {
		return this.exam06;
	}

	public void setExam06(String exam06) {
		this.exam06 = exam06;
	}

	public String getExam07() {
		return exam07;
	}

	public void setExam07(String exam07) {
		this.exam07 = exam07;
	}

	public String getHighRisk() {
		return highRisk;
	}

	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}

	public String getHighRiskRemark() {
		return highRiskRemark;
	}

	public void setHighRiskRemark(String highRiskRemark) {
		this.highRiskRemark = highRiskRemark;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

	public String getHighRiskSearch() {
		return highRiskSearch;
	}

	public void setHighRiskSearch(String highRiskSearch) {
		this.highRiskSearch = highRiskSearch;
	}

	public Integer getGravidity() {
		return gravidity;
	}

	public void setGravidity(Integer gravidity) {
		this.gravidity = gravidity;
	}

}
