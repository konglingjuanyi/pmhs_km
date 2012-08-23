package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * IntPersonInfo entity. @author MyEclipse Persistence Tools
 */

public class IntPersonInfo implements java.io.Serializable {

	// Fields

	private String id;
	private String intKey;
	private String hospitalName;
	private Short state;
	private String personName;
	private String sex;
	private Timestamp birthDay;
	private String address;
	private String directId;
	private Timestamp makeDate;
	private String makePerson;
	private Timestamp completeDate;
	private Short type;
	private Short checkState;
	private String idnumber;
	private String occupation;
	private Short serviceType;
	private String tagString;
	private String fileNo;

	// Constructors

	/** default constructor */
	public IntPersonInfo() {
	}

	/** minimal constructor */
	public IntPersonInfo(String intKey, Short type, Short checkState,
			Short serviceType) {
		this.intKey = intKey;
		this.type = type;
		this.checkState = checkState;
		this.serviceType = serviceType;
	}

	/** full constructor */
	public IntPersonInfo(String intKey, String hospitalName, Short state,
			String personName, String sex, Timestamp birthDay, String address,
			String directId, Timestamp makeDate, String makePerson,
			Timestamp completeDate, Short type, Short checkState,
			String idnumber, String occupation, Short serviceType,
			String tagString, String fileNo) {
		this.intKey = intKey;
		this.hospitalName = hospitalName;
		this.state = state;
		this.personName = personName;
		this.sex = sex;
		this.birthDay = birthDay;
		this.address = address;
		this.directId = directId;
		this.makeDate = makeDate;
		this.makePerson = makePerson;
		this.completeDate = completeDate;
		this.type = type;
		this.checkState = checkState;
		this.idnumber = idnumber;
		this.occupation = occupation;
		this.serviceType = serviceType;
		this.tagString = tagString;
		this.fileNo = fileNo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntKey() {
		return this.intKey;
	}

	public void setIntKey(String intKey) {
		this.intKey = intKey;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDirectId() {
		return this.directId;
	}

	public void setDirectId(String directId) {
		this.directId = directId;
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

	public Timestamp getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Timestamp completeDate) {
		this.completeDate = completeDate;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Short getCheckState() {
		return this.checkState;
	}

	public void setCheckState(Short checkState) {
		this.checkState = checkState;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Short getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Short serviceType) {
		this.serviceType = serviceType;
	}

	public String getTagString() {
		return this.tagString;
	}

	public void setTagString(String tagString) {
		this.tagString = tagString;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

}