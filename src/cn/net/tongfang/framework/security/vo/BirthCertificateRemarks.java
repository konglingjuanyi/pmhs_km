package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BirthCertificateRemarks entity. @author MyEclipse Persistence Tools
 */

public class BirthCertificateRemarks implements java.io.Serializable {

	// Fields

	private String id;
	private String remarks;
	private Integer type;
	private String otherCondition;
	private String prex;
	private String inputPersonId;
	private Timestamp inputDate;
	private Integer orgId;

	// Constructors

	/** default constructor */
	public BirthCertificateRemarks() {
	}

	/** minimal constructor */
	public BirthCertificateRemarks(String remarks, Integer type, String prex,Integer orgId) {
		this.remarks = remarks;
		this.type = type;
		this.prex = prex;
		this.orgId = orgId;
	}

	/** full constructor */
	public BirthCertificateRemarks(String remarks, Integer type,
			String otherCondition, String prex,
			String inputPersonId, Timestamp inputDate,Integer orgId) {
		this.remarks = remarks;
		this.type = type;
		this.otherCondition = otherCondition;
		this.prex = prex;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.orgId = orgId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOtherCondition() {
		return this.otherCondition;
	}

	public void setOtherCondition(String otherCondition) {
		this.otherCondition = otherCondition;
	}

	public String getPrex() {
		return this.prex;
	}

	public void setPrex(String prex) {
		this.prex = prex;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
 
}