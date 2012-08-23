package cn.net.tongfang.web.service.bo;

import java.util.Date;

public class BirthCertifiQry {
	private String certifiId;
	private String childName;
	private String motherName;
	private String fatherName;
	private String orgId;
	private Date childBirthday;
	private Date startDate;
	private Date endDate;
	private String qryType;
	public String getCertifiId() {
		return certifiId;
	}
	public void setCertifiId(String certifiId) {
		this.certifiId = certifiId;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public Date getChildBirthday() {
		return childBirthday;
	}
	public void setChildBirthday(Date childBirthday) {
		this.childBirthday = childBirthday;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQryType() {
		return qryType;
	}
	public void setQryType(String qryType) {
		this.qryType = qryType;
	}
	
	
}
