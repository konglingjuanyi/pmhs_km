package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * VaccineImmune entity. @author MyEclipse Persistence Tools
 */

public class VaccineImmune {

	// Fields

	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp vinputDate;
	private String vname;
	private String vsex;
	private Timestamp vbirthday;
//	private String vcuratorName;
//	private String vcuratorRelatedForChild;
//	private String vcuratorTel;
	private String vfamilyAddress;
	private String vcensusAddressCounty;
	private String vcensusAddressTown;
	private String vcensusAddressVillage;
	private Timestamp vbuildCardDate;
	private String vbuildCardPerson;
	private String vfatherName;
	private String vfatherWorkUnit;
	private String vfatherPhone;
	private String vmotherName;
	private String vmotherWorkUnit;
	private String vmotherPhone;
	private Timestamp vmovedDate;
	private String vmovedAddress;
	private String vvacciUnit;
	private String vcertifiUnit;
	private Double vweight;
	private String execDistrictNum;
	private String taboo;
	private String infectiousHistory;
	// Constructors

	/** default constructor */
	public VaccineImmune() {
	}

	/** minimal constructor */
	public VaccineImmune(String fileNo, String inputPersonId,
			Timestamp vinputDate, String vname, String vsex) {
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.vinputDate = vinputDate;
		this.vname = vname;
		this.vsex = vsex;
	}

	/** full constructor */
	

	// Property accessors

	public String getFileNo() {
		return fileNo;
	}

	public VaccineImmune(String id, String fileNo, String inputPersonId,
			Timestamp vinputDate, String vname, String vsex,
			Timestamp vbirthday, String vfamilyAddress,
			String vcensusAddressCounty, String vcensusAddressTown,
			String vcensusAddressVillage, Timestamp vbuildCardDate,
			String vbuildCardPerson, String vfatherName,
			String vfatherWorkUnit, String vfatherPhone, String vmotherName,
			String vmotherWorkUnit, String vmotherPhone, Timestamp vmovedDate,
			String vmovedAddress, String vvacciUnit, String vcertifiUnit,
			Double vweight, String execDistrictNum,String taboo,
			String infectiousHistory) {
		super();
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.vinputDate = vinputDate;
		this.vname = vname;
		this.vsex = vsex;
		this.vbirthday = vbirthday;
		this.vfamilyAddress = vfamilyAddress;
		this.vcensusAddressCounty = vcensusAddressCounty;
		this.vcensusAddressTown = vcensusAddressTown;
		this.vcensusAddressVillage = vcensusAddressVillage;
		this.vbuildCardDate = vbuildCardDate;
		this.vbuildCardPerson = vbuildCardPerson;
		this.vfatherName = vfatherName;
		this.vfatherWorkUnit = vfatherWorkUnit;
		this.vfatherPhone = vfatherPhone;
		this.vmotherName = vmotherName;
		this.vmotherWorkUnit = vmotherWorkUnit;
		this.vmotherPhone = vmotherPhone;
		this.vmovedDate = vmovedDate;
		this.vmovedAddress = vmovedAddress;
		this.vvacciUnit = vvacciUnit;
		this.vcertifiUnit = vcertifiUnit;
		this.vweight = vweight;
		this.execDistrictNum = execDistrictNum;
		this.taboo = taboo;
		this.infectiousHistory = infectiousHistory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getInputPersonId() {
		return inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getVinputDate() {
		return this.vinputDate;
	}

	public void setVinputDate(Timestamp vinputDate) {
		this.vinputDate = vinputDate;
	}

	public String getVname() {
		return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVsex() {
		return this.vsex;
	}

	public void setVsex(String vsex) {
		this.vsex = vsex;
	}

	public Timestamp getVbirthday() {
		return this.vbirthday;
	}

	public void setVbirthday(Timestamp vbirthday) {
		this.vbirthday = vbirthday;
	}

	public String getVfamilyAddress() {
		return this.vfamilyAddress;
	}

	public void setVfamilyAddress(String vfamilyAddress) {
		this.vfamilyAddress = vfamilyAddress;
	}
	
	public Timestamp getVbuildCardDate() {
		return this.vbuildCardDate;
	}

	public void setVbuildCardDate(Timestamp vbuildCardDate) {
		this.vbuildCardDate = vbuildCardDate;
	}

	public String getVbuildCardPerson() {
		return this.vbuildCardPerson;
	}

	public void setVbuildCardPerson(String vbuildCardPerson) {
		this.vbuildCardPerson = vbuildCardPerson;
	}

	public String getVfatherName() {
		return vfatherName;
	}

	public void setVfatherName(String vfatherName) {
		this.vfatherName = vfatherName;
	}

	public String getVfatherWorkUnit() {
		return vfatherWorkUnit;
	}

	public void setVfatherWorkUnit(String vfatherWorkUnit) {
		this.vfatherWorkUnit = vfatherWorkUnit;
	}

	public String getVfatherPhone() {
		return vfatherPhone;
	}

	public void setVfatherPhone(String vfatherPhone) {
		this.vfatherPhone = vfatherPhone;
	}

	public String getVmotherName() {
		return vmotherName;
	}

	public void setVmotherName(String vmotherName) {
		this.vmotherName = vmotherName;
	}

	public String getVmotherWorkUnit() {
		return vmotherWorkUnit;
	}

	public void setVmotherWorkUnit(String vmotherWorkUnit) {
		this.vmotherWorkUnit = vmotherWorkUnit;
	}

	public String getVmotherPhone() {
		return vmotherPhone;
	}

	public void setVmotherPhone(String vmotherPhone) {
		this.vmotherPhone = vmotherPhone;
	}

	public Timestamp getVmovedDate() {
		return vmovedDate;
	}

	public void setVmovedDate(Timestamp vmovedDate) {
		this.vmovedDate = vmovedDate;
	}

	public String getVmovedAddress() {
		return vmovedAddress;
	}

	public void setVmovedAddress(String vmovedAddress) {
		this.vmovedAddress = vmovedAddress;
	}

	public String getVvacciUnit() {
		return vvacciUnit;
	}

	public void setVvacciUnit(String vvacciUnit) {
		this.vvacciUnit = vvacciUnit;
	}

	public String getVcertifiUnit() {
		return vcertifiUnit;
	}

	public void setVcertifiUnit(String vcertifiUnit) {
		this.vcertifiUnit = vcertifiUnit;
	}

	public Double getVweight() {
		return vweight;
	}

	public void setVweight(Double vweight) {
		this.vweight = vweight;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

	public String getVcensusAddressCounty() {
		return vcensusAddressCounty;
	}

	public void setVcensusAddressCounty(String vcensusAddressCounty) {
		this.vcensusAddressCounty = vcensusAddressCounty;
	}

	public String getVcensusAddressTown() {
		return vcensusAddressTown;
	}

	public void setVcensusAddressTown(String vcensusAddressTown) {
		this.vcensusAddressTown = vcensusAddressTown;
	}

	public String getVcensusAddressVillage() {
		return vcensusAddressVillage;
	}

	public void setVcensusAddressVillage(String vcensusAddressVillage) {
		this.vcensusAddressVillage = vcensusAddressVillage;
	}

	public String getTaboo() {
		return taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public String getInfectiousHistory() {
		return infectiousHistory;
	}

	public void setInfectiousHistory(String infectiousHistory) {
		this.infectiousHistory = infectiousHistory;
	}

}