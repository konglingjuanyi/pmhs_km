package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * IntOutpatient entity. @author MyEclipse Persistence Tools
 */

public class IntOutpatient implements java.io.Serializable {

	// Fields

	private String id;
	private String directId;
	private String districtNumber;
	private String hospitalName;
	private String opKey;
	private Short opType;
	private Short state;
	private Timestamp date;
	private String section;
	private String doctor;
	private String emrnsoFileNo;
	private String emrpdfFileNo;
	private String diagnosis;
	private String signs;
	private Short gatherType;
	private Double allMoney;
	private Double wipeMoney;
	private String fileNo;
	private Timestamp makeDate;
	private String makePerson;
	private String emrFilePdf;
	private String emrFileNso;

	// Constructors

	/** default constructor */
	public IntOutpatient() {
	}

	/** minimal constructor */
	public IntOutpatient(String directId, String districtNumber, String opKey,
			Short opType, Short state, Short gatherType, Double allMoney,
			Double wipeMoney, String fileNo) {
		this.directId = directId;
		this.districtNumber = districtNumber;
		this.opKey = opKey;
		this.opType = opType;
		this.state = state;
		this.gatherType = gatherType;
		this.allMoney = allMoney;
		this.wipeMoney = wipeMoney;
		this.fileNo = fileNo;
	}

	/** full constructor */
	public IntOutpatient(String directId, String districtNumber,
			String hospitalName, String opKey, Short opType, Short state,
			Timestamp date, String section, String doctor, String emrnsoFileNo,
			String emrpdfFileNo, String diagnosis, String signs,
			Short gatherType, Double allMoney, Double wipeMoney, String fileNo,
			Timestamp makeDate, String makePerson, String emrFilePdf,
			String emrFileNso) {
		this.directId = directId;
		this.districtNumber = districtNumber;
		this.hospitalName = hospitalName;
		this.opKey = opKey;
		this.opType = opType;
		this.state = state;
		this.date = date;
		this.section = section;
		this.doctor = doctor;
		this.emrnsoFileNo = emrnsoFileNo;
		this.emrpdfFileNo = emrpdfFileNo;
		this.diagnosis = diagnosis;
		this.signs = signs;
		this.gatherType = gatherType;
		this.allMoney = allMoney;
		this.wipeMoney = wipeMoney;
		this.fileNo = fileNo;
		this.makeDate = makeDate;
		this.makePerson = makePerson;
		this.emrFilePdf = emrFilePdf;
		this.emrFileNso = emrFileNso;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDirectId() {
		return this.directId;
	}

	public void setDirectId(String directId) {
		this.directId = directId;
	}

	public String getDistrictNumber() {
		return this.districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getOpKey() {
		return this.opKey;
	}

	public void setOpKey(String opKey) {
		this.opKey = opKey;
	}

	public Short getOpType() {
		return this.opType;
	}

	public void setOpType(Short opType) {
		this.opType = opType;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getEmrnsoFileNo() {
		return this.emrnsoFileNo;
	}

	public void setEmrnsoFileNo(String emrnsoFileNo) {
		this.emrnsoFileNo = emrnsoFileNo;
	}

	public String getEmrpdfFileNo() {
		return this.emrpdfFileNo;
	}

	public void setEmrpdfFileNo(String emrpdfFileNo) {
		this.emrpdfFileNo = emrpdfFileNo;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getSigns() {
		return this.signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	public Short getGatherType() {
		return this.gatherType;
	}

	public void setGatherType(Short gatherType) {
		this.gatherType = gatherType;
	}

	public Double getAllMoney() {
		return this.allMoney;
	}

	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}

	public Double getWipeMoney() {
		return this.wipeMoney;
	}

	public void setWipeMoney(Double wipeMoney) {
		this.wipeMoney = wipeMoney;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Timestamp getMakeDate() {
		return this.makeDate;
	}

	public void setMakeDate(Timestamp makeDate) {
		this.makeDate = makeDate;
	}

	public String getMakePerson() {
		return this.makePerson;
	}

	public void setMakePerson(String makePerson) {
		this.makePerson = makePerson;
	}

	public String getEmrFilePdf() {
		return this.emrFilePdf;
	}

	public void setEmrFilePdf(String emrFilePdf) {
		this.emrFilePdf = emrFilePdf;
	}

	public String getEmrFileNso() {
		return this.emrFileNso;
	}

	public void setEmrFileNso(String emrFileNso) {
		this.emrFileNso = emrFileNso;
	}

}