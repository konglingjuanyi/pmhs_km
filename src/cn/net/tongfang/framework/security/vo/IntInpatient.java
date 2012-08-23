package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * IntInpatient entity. @author MyEclipse Persistence Tools
 */

public class IntInpatient implements java.io.Serializable {

	// Fields

	private String id;
	private String directId;
	private String districtNumber;
	private String hospitalName;
	private String inKey;
	private Short inType;
	private Short state;
	private Timestamp inDate;
	private Timestamp outDate;
	private String section;
	private String doctor;
	private String nurse;
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
	public IntInpatient() {
	}

	/** minimal constructor */
	public IntInpatient(String directId, String districtNumber, Short inType,
			Short state, Short gatherType, Double allMoney, Double wipeMoney,
			String fileNo) {
		this.directId = directId;
		this.districtNumber = districtNumber;
		this.inType = inType;
		this.state = state;
		this.gatherType = gatherType;
		this.allMoney = allMoney;
		this.wipeMoney = wipeMoney;
		this.fileNo = fileNo;
	}

	/** full constructor */
	public IntInpatient(String directId, String districtNumber,
			String hospitalName, String inKey, Short inType, Short state,
			Timestamp inDate, Timestamp outDate, String section, String doctor,
			String nurse, String emrnsoFileNo, String emrpdfFileNo,
			String diagnosis, String signs, Short gatherType, Double allMoney,
			Double wipeMoney, String fileNo, Timestamp makeDate,
			String makePerson, String emrFilePdf, String emrFileNso) {
		this.directId = directId;
		this.districtNumber = districtNumber;
		this.hospitalName = hospitalName;
		this.inKey = inKey;
		this.inType = inType;
		this.state = state;
		this.inDate = inDate;
		this.outDate = outDate;
		this.section = section;
		this.doctor = doctor;
		this.nurse = nurse;
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

	public String getInKey() {
		return this.inKey;
	}

	public void setInKey(String inKey) {
		this.inKey = inKey;
	}

	public Short getInType() {
		return this.inType;
	}

	public void setInType(Short inType) {
		this.inType = inType;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public Timestamp getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
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

	public String getNurse() {
		return this.nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
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