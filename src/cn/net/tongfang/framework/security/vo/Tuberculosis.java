package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * Tuberculosis entity. @author MyEclipse Persistence Tools
 */

public class Tuberculosis implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String sex;
	private Integer age;
	private String address;
	private String typeForSick;
	private Timestamp timeForStart;
	private String regNo;
	private String caseHisNo;
	private String fileNo;
	private String districtNumber;

	// Constructors

	/** default constructor */
	public Tuberculosis() {
	}
	private TuberSuperDetail tuberSuperDetail;
	
	public TuberSuperDetail getTuberSuperDetail() {
		return tuberSuperDetail;
	}

	public void setTuberSuperDetail(TuberSuperDetail tuberSuperDetail) {
		this.tuberSuperDetail = tuberSuperDetail;
	}

	/** minimal constructor */
	public Tuberculosis(String id, String name, String sex, Integer age,
			String typeForSick, Timestamp timeForStart, String fileNo,
			String districtNumber) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.typeForSick = typeForSick;
		this.timeForStart = timeForStart;
		this.fileNo = fileNo;
		this.districtNumber = districtNumber;
	}

	/** full constructor */
	public Tuberculosis(String id, String name, String sex, Integer age,
			String address, String typeForSick, Timestamp timeForStart,
			String regNo, String caseHisNo, String fileNo, String districtNumber) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.typeForSick = typeForSick;
		this.timeForStart = timeForStart;
		this.regNo = regNo;
		this.caseHisNo = caseHisNo;
		this.fileNo = fileNo;
		this.districtNumber = districtNumber;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeForSick() {
		return this.typeForSick;
	}

	public void setTypeForSick(String typeForSick) {
		this.typeForSick = typeForSick;
	}

	public Timestamp getTimeForStart() {
		return this.timeForStart;
	}

	public void setTimeForStart(Timestamp timeForStart) {
		this.timeForStart = timeForStart;
	}

	public String getRegNo() {
		return this.regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCaseHisNo() {
		return this.caseHisNo;
	}

	public void setCaseHisNo(String caseHisNo) {
		this.caseHisNo = caseHisNo;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getDistrictNumber() {
		return this.districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

}