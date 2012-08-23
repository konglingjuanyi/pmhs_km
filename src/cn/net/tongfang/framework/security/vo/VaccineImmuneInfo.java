package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * VaccineImmuneInfo entity. @author MyEclipse Persistence Tools
 */

public class VaccineImmuneInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String colNum;
	private Integer rowNumber;
	private Integer number;
	private String fileNo;
	private String vaccinationName;
	private Timestamp vaccinationDate;
	private String vaccinationPosition;
	private String immuneBatchNum;
	private String vaccinationDoctor;
	private Integer immuneDose;
	private String vaccinationWay;
	private String inputPersonId;
	private Timestamp inputDate;
	private String remarks;
	private Integer isPlan;
	private String vacciAddress;
	private String vacciDose;
	private Integer companyId;
	private Integer isPrint;
	// Constructors

	/** default constructor */
	public VaccineImmuneInfo() {
	}

	/** minimal constructor */
	public VaccineImmuneInfo(String colNum, Integer rowNumber, Integer number,
			String fileNo) {
		this.colNum = colNum;
		this.rowNumber = rowNumber;
		this.number = number;
		this.fileNo = fileNo;
	}

	/** full constructor */
	public VaccineImmuneInfo(String colNum, Integer rowNumber, Integer number,
			String fileNo, String vaccinationName, Timestamp vaccinationDate,
			String vaccinationPosition, String immuneBatchNum,
			String vaccinationDoctor, Integer immuneDose,
			String vaccinationWay, String inputPersonId, Timestamp inputDate,
			String remarks, Integer isPlan,String vacciAddress,String vacciDose,
			Integer companyId,Integer isPrint) {
		this.colNum = colNum;
		this.rowNumber = rowNumber;
		this.number = number;
		this.fileNo = fileNo;
		this.vaccinationName = vaccinationName;
		this.vaccinationDate = vaccinationDate;
		this.vaccinationPosition = vaccinationPosition;
		this.immuneBatchNum = immuneBatchNum;
		this.vaccinationDoctor = vaccinationDoctor;
		this.immuneDose = immuneDose;
		this.vaccinationWay = vaccinationWay;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.remarks = remarks;
		this.isPlan = isPlan;
		this.vacciAddress = vacciAddress;
		this.vacciDose = vacciDose;
		this.companyId = companyId;
		this.isPrint = isPrint;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColNum() {
		return this.colNum;
	}

	public void setColNum(String colNum) {
		this.colNum = colNum;
	}

	public Integer getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getVaccinationName() {
		return this.vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	public Timestamp getVaccinationDate() {
		return this.vaccinationDate;
	}

	public void setVaccinationDate(Timestamp vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccinationPosition() {
		return this.vaccinationPosition;
	}

	public void setVaccinationPosition(String vaccinationPosition) {
		this.vaccinationPosition = vaccinationPosition;
	}

	public String getImmuneBatchNum() {
		return this.immuneBatchNum;
	}

	public void setImmuneBatchNum(String immuneBatchNum) {
		this.immuneBatchNum = immuneBatchNum;
	}

	public String getVaccinationDoctor() {
		return this.vaccinationDoctor;
	}

	public void setVaccinationDoctor(String vaccinationDoctor) {
		this.vaccinationDoctor = vaccinationDoctor;
	}

	public Integer getImmuneDose() {
		return this.immuneDose;
	}

	public void setImmuneDose(Integer immuneDose) {
		this.immuneDose = immuneDose;
	}

	public String getVaccinationWay() {
		return this.vaccinationWay;
	}

	public void setVaccinationWay(String vaccinationWay) {
		this.vaccinationWay = vaccinationWay;
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIsPlan() {
		return this.isPlan;
	}

	public void setIsPlan(Integer isPlan) {
		this.isPlan = isPlan;
	}

	public String getVacciAddress() {
		return vacciAddress;
	}

	public void setVacciAddress(String vacciAddress) {
		this.vacciAddress = vacciAddress;
	}

	public String getVacciDose() {
		return vacciDose;
	}

	public void setVacciDose(String vacciDose) {
		this.vacciDose = vacciDose;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(Integer isPrint) {
		this.isPrint = isPrint;
	}

}