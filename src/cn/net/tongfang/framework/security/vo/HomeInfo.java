package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * HomeInfo entity. @author MyEclipse Persistence Tools
 */

public class HomeInfo implements java.io.Serializable {

	// Fields

	private String homeId;
	private String household;
	private Integer personCount;
	private String address;
	private String phone;
	private String township;
	private String village;
	private String buildUnit;
	private String buildPersonId;
	private Timestamp buildDate;
	private String residenceAddress;
	private String districtNumber;
	private Timestamp updateDate;
	
	private PersonalInfo personalInfo;
	private HealthFile healthFile;
	
	// Constructors

	

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public HealthFile getHealthFile() {
		return healthFile;
	}

	public void setHealthFile(HealthFile healthFile) {
		this.healthFile = healthFile;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	/** default constructor */
	public HomeInfo() {
	}

	/** minimal constructor */
	public HomeInfo(String homeId, String household, Integer personCount) {
		this.homeId = homeId;
		this.household = household;
		this.personCount = personCount;
	}

	/** full constructor */
	public HomeInfo(String homeId, String household, Integer personCount,
			String address, String phone, String township, String village,
			String buildUnit, String buildPersonId, Timestamp buildDate,
			String residenceAddress, String districtNumber, Timestamp updateDate) {
		this.homeId = homeId;
		this.household = household;
		this.personCount = personCount;
		this.address = address;
		this.phone = phone;
		this.township = township;
		this.village = village;
		this.buildUnit = buildUnit;
		this.buildPersonId = buildPersonId;
		this.buildDate = buildDate;
		this.residenceAddress = residenceAddress;
		this.districtNumber = districtNumber;
		this.updateDate = updateDate;
	}

	// Property accessors

	public String getHomeId() {
		return this.homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getHousehold() {
		return this.household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public Integer getPersonCount() {
		return this.personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTownship() {
		return this.township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getBuildUnit() {
		return this.buildUnit;
	}

	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	public String getBuildPersonId() {
		return this.buildPersonId;
	}

	public void setBuildPersonId(String buildPersonId) {
		this.buildPersonId = buildPersonId;
	}

	public Timestamp getBuildDate() {
		return this.buildDate;
	}

	public void setBuildDate(Timestamp buildDate) {
		this.buildDate = buildDate;
	}

	public String getResidenceAddress() {
		return this.residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getDistrictNumber() {
		return this.districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}