package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BirthCertifiDestroyReason entity. @author MyEclipse Persistence Tools
 */

public class BirthCertifiDestroyReason implements java.io.Serializable {

	// Fields

	private String id;
	private String certifiId;
	private Integer type;
	private String reasonRemarks;
	private Timestamp reasonDate;
	private String inputPersonId;
	private String otherDestroyReason;

	// Constructors

	/** default constructor */
	public BirthCertifiDestroyReason() {
	}

	/** minimal constructor */
	public BirthCertifiDestroyReason(String certifiId, Integer type) {
		this.certifiId = certifiId;
		this.type = type;
	}

	/** full constructor */
	public BirthCertifiDestroyReason(String certifiId, Integer type,
			String reasonRemarks, Timestamp reasonDate,String inputPersonId,
			String otherDestroyReason) {
		this.certifiId = certifiId;
		this.type = type;
		this.reasonRemarks = reasonRemarks;
		this.reasonDate = reasonDate;
		this.inputPersonId = inputPersonId;
		this.otherDestroyReason = otherDestroyReason;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCertifiId() {
		return this.certifiId;
	}

	public void setCertifiId(String certifiId) {
		this.certifiId = certifiId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReasonRemarks() {
		return this.reasonRemarks;
	}

	public void setReasonRemarks(String reasonRemarks) {
		this.reasonRemarks = reasonRemarks;
	}

	public Timestamp getReasonDate() {
		return this.reasonDate;
	}

	public void setReasonDate(Timestamp reasonDate) {
		this.reasonDate = reasonDate;
	}

	public String getInputPersonId() {
		return inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public String getOtherDestroyReason() {
		return otherDestroyReason;
	}

	public void setOtherDestroyReason(String otherDestroyReason) {
		this.otherDestroyReason = otherDestroyReason;
	}

}