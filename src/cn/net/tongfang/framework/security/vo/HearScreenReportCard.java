package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * HearScreenReportCard entity. @author MyEclipse Persistence Tools
 */

public class HearScreenReportCard implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String examUnit;
	private String serialNumber;
	private String parentsName;
	private String babyName;
	private String babySex;
	private Timestamp babyBirthday;
	private Timestamp examDate;
	private Timestamp reviewExamDate;
	private String examWay;
	private String rightEar;
	private String leftEar;
	private String suggestion;
	private String examerSign;
	private Timestamp reportDate;
	private String dataType;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public HearScreenReportCard() {
	}

	/** minimal constructor */
	public HearScreenReportCard(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public HearScreenReportCard(String fileNo, String examUnit,
			String serialNumber, String parentsName, String babyName,
			String babySex, Timestamp babyBirthday, Timestamp examDate,
			Timestamp reviewExamDate, String examWay, String rightEar,
			String leftEar, String suggestion, 
			String examerSign, Timestamp reportDate, String dataType,
			String inputPersonId, Timestamp inputDate, String execDistrictNum) {
		this.fileNo = fileNo;
		this.examUnit = examUnit;
		this.serialNumber = serialNumber;
		this.parentsName = parentsName;
		this.babyName = babyName;
		this.babySex = babySex;
		this.babyBirthday = babyBirthday;
		this.examDate = examDate;
		this.reviewExamDate = reviewExamDate;
		this.examWay = examWay;
		this.rightEar = rightEar;
		this.leftEar = leftEar;
		this.suggestion = suggestion;
		this.examerSign = examerSign;
		this.reportDate = reportDate;
		this.dataType = dataType;
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

	public String getExamUnit() {
		return this.examUnit;
	}

	public void setExamUnit(String examUnit) {
		this.examUnit = examUnit;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getParentsName() {
		return this.parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getBabyName() {
		return this.babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public String getBabySex() {
		return this.babySex;
	}

	public void setBabySex(String babySex) {
		this.babySex = babySex;
	}

	public Timestamp getBabyBirthday() {
		return this.babyBirthday;
	}

	public void setBabyBirthday(Timestamp babyBirthday) {
		this.babyBirthday = babyBirthday;
	}

	public Timestamp getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Timestamp examDate) {
		this.examDate = examDate;
	}

	public Timestamp getReviewExamDate() {
		return this.reviewExamDate;
	}

	public void setReviewExamDate(Timestamp reviewExamDate) {
		this.reviewExamDate = reviewExamDate;
	}

	public String getExamWay() {
		return this.examWay;
	}

	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}

	public String getRightEar() {
		return this.rightEar;
	}

	public void setRightEar(String rightEar) {
		this.rightEar = rightEar;
	}

	public String getLeftEar() {
		return this.leftEar;
	}

	public void setLeftEar(String leftEar) {
		this.leftEar = leftEar;
	}

	public String getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getExamerSign() {
		return this.examerSign;
	}

	public void setExamerSign(String examerSign) {
		this.examerSign = examerSign;
	}

	public Timestamp getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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