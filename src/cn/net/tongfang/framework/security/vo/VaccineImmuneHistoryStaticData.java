package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * VaccineImmuneHistoryStaticData entity. @author MyEclipse Persistence Tools
 */

public class VaccineImmuneHistoryStaticData implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private Timestamp birthDay;
	private Timestamp limitDate;
	private Timestamp vaccinationDate;
	private String vaccinationName;
	private Integer vaccinationNum;
	private String colNum;
	private Integer rowNum;
	private String inputPersonId;
	private Timestamp inputDate;
	private Short state;

	// Constructors

	/** default constructor */
	public VaccineImmuneHistoryStaticData() {
	}

	/** minimal constructor */
	public VaccineImmuneHistoryStaticData(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public VaccineImmuneHistoryStaticData(String fileNo, Timestamp birthDay,
			Timestamp limitDate, Timestamp vaccinationDate,
			String vaccinationName, Integer vaccinationNum, String colNum,
			Integer rowNum, String inputPersonId, Timestamp inputDate,
			Short state) {
		this.fileNo = fileNo;
		this.birthDay = birthDay;
		this.limitDate = limitDate;
		this.vaccinationDate = vaccinationDate;
		this.vaccinationName = vaccinationName;
		this.vaccinationNum = vaccinationNum;
		this.colNum = colNum;
		this.rowNum = rowNum;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.state = state;
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

	public Timestamp getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}

	public Timestamp getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(Timestamp limitDate) {
		this.limitDate = limitDate;
	}

	public Timestamp getVaccinationDate() {
		return this.vaccinationDate;
	}

	public void setVaccinationDate(Timestamp vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccinationName() {
		return this.vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	public Integer getVaccinationNum() {
		return this.vaccinationNum;
	}

	public void setVaccinationNum(Integer vaccinationNum) {
		this.vaccinationNum = vaccinationNum;
	}

	public String getColNum() {
		return this.colNum;
	}

	public void setColNum(String colNum) {
		this.colNum = colNum;
	}

	public Integer getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
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

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}