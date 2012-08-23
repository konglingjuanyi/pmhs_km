package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

import cn.net.tongfang.framework.security.vo.ChildBirthRecord;

public class ChildBirthBO extends ChildBirthRecord {
	private String certifiId;
	private String name;
	private String sex;
	private Timestamp birthdaybo;
	private String borthWeekly;
	private String healthStatus;
	private Double weight;
	private Double height;
	private String motherName;
	private Integer motherAge;
	private String motherNationality;
	private String motherNation;
	private String motherIdCard;
	private String fatherName;
	private Integer fatherAge;
	private String fatherNationality;
	private String fatherNation;
	private String fatherIdCard;
	private String borthAddressCategory;
	private String borthOrganization;
	private Timestamp issuingDatebo;
	private String issuingOrganization;
	private Integer isEffectived;
	private String otherBorthAddressCategory;
	private String widwife;
	private String province;
	private String city;
	private String county;
	private String township;
	private String familyAddress;
	private String districtNum;
	private String fileNo;
	private Integer isPrint;
	private String linkmanTel;
	public String getLinkmanTel() {
		return linkmanTel;
	}
	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}
	public String getCertifiId() {
		return certifiId;
	}
	public void setCertifiId(String certifiId) {
		this.certifiId = certifiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBorthWeekly() {
		return borthWeekly;
	}
	public void setBorthWeekly(String borthWeekly) {
		this.borthWeekly = borthWeekly;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Integer getMotherAge() {
		return motherAge;
	}
	public void setMotherAge(Integer motherAge) {
		this.motherAge = motherAge;
	}
	public String getMotherNationality() {
		return motherNationality;
	}
	public void setMotherNationality(String motherNationality) {
		this.motherNationality = motherNationality;
	}
	public String getMotherNation() {
		return motherNation;
	}
	public void setMotherNation(String motherNation) {
		this.motherNation = motherNation;
	}
	public String getMotherIdCard() {
		return motherIdCard;
	}
	public void setMotherIdCard(String motherIdCard) {
		this.motherIdCard = motherIdCard;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Integer getFatherAge() {
		return fatherAge;
	}
	public void setFatherAge(Integer fatherAge) {
		this.fatherAge = fatherAge;
	}
	public String getFatherNationality() {
		return fatherNationality;
	}
	public void setFatherNationality(String fatherNationality) {
		this.fatherNationality = fatherNationality;
	}
	public String getFatherNation() {
		return fatherNation;
	}
	public void setFatherNation(String fatherNation) {
		this.fatherNation = fatherNation;
	}
	public String getFatherIdCard() {
		return fatherIdCard;
	}
	public void setFatherIdCard(String fatherIdCard) {
		this.fatherIdCard = fatherIdCard;
	}
	public String getBorthAddressCategory() {
		return borthAddressCategory;
	}
	public void setBorthAddressCategory(String borthAddressCategory) {
		this.borthAddressCategory = borthAddressCategory;
	}
	public String getBorthOrganization() {
		return borthOrganization;
	}
	public void setBorthOrganization(String borthOrganization) {
		this.borthOrganization = borthOrganization;
	}
	
	public Timestamp getBirthdaybo() {
		return birthdaybo;
	}
	public void setBirthdaybo(Timestamp birthdaybo) {
		this.birthdaybo = birthdaybo;
	}
	public Timestamp getIssuingDatebo() {
		return issuingDatebo;
	}
	public void setIssuingDatebo(Timestamp issuingDatebo) {
		this.issuingDatebo = issuingDatebo;
	}
	public String getIssuingOrganization() {
		return issuingOrganization;
	}
	public void setIssuingOrganization(String issuingOrganization) {
		this.issuingOrganization = issuingOrganization;
	}
	public Integer getIsEffectived() {
		return isEffectived;
	}
	public void setIsEffectived(Integer isEffectived) {
		this.isEffectived = isEffectived;
	}
	public String getOtherBorthAddressCategory() {
		return otherBorthAddressCategory;
	}
	public void setOtherBorthAddressCategory(String otherBorthAddressCategory) {
		this.otherBorthAddressCategory = otherBorthAddressCategory;
	}
	public String getWidwife() {
		return widwife;
	}
	public void setWidwife(String widwife) {
		this.widwife = widwife;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public String getDistrictNum() {
		return districtNum;
	}
	public void setDistrictNum(String districtNum) {
		this.districtNum = districtNum;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public Integer getIsPrint() {
		return isPrint;
	}
	public void setIsPrint(Integer isPrint) {
		this.isPrint = isPrint;
	}
	
}
