package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BirthCertificateOrg entity. @author MyEclipse Persistence Tools
 */

public class BirthCertificateOrg implements java.io.Serializable {

	// Fields

	private String id;
	private Integer orgId;
	private String certificateId;
	private Timestamp distriDate;
	// Constructors

	/** default constructor */
	public BirthCertificateOrg() {
	}

	/** full constructor */
	public BirthCertificateOrg(Integer orgId, String certificateId,Timestamp distriDate) {
		this.orgId = orgId;
		this.certificateId = certificateId;
		this.distriDate = distriDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public Timestamp getDistriDate() {
		return distriDate;
	}

	public void setDistriDate(Timestamp distriDate) {
		this.distriDate = distriDate;
	}

}