package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.HomeInfo;
import cn.net.tongfang.framework.security.vo.PersonalInfo;

public class HomeInfoBO extends HomeInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String homeId;
	private String id;
	private String household;
	private String address;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String fileNo;
	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	private String residenceAddress;
	private String phone;
	private String township;
	private String village;
	private String buildUnit;
	private String buildPerson;
	private Timestamp buildDate;
	private String districtNumber;
	
	private PersonalInfo personalInfo;
	private HealthFile healthFile;
	
	public HealthFile getHealthFile() {
		return healthFile;
	}

	public void setHealthFile(HealthFile healthFile) {
		this.healthFile = healthFile;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}


	
	

	public HomeInfoBO() {
		this.buildDate = new java.sql.Timestamp(System.currentTimeMillis());
	}

	public String getHomeId() {
		return homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getBuildUnit() {
		return buildUnit;
	}

	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	public String getBuildPerson() {
		return buildPerson;
	}

	public void setBuildPerson(String buildPerson) {
		this.buildPerson = buildPerson;
	}

	public Timestamp getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Timestamp buildDate) {
		this.buildDate = buildDate;
	}

	public String getDistrictNumber() {
		return districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}
	
	
}
