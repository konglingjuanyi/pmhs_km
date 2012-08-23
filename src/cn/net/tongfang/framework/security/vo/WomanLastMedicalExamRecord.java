package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * WomanLastMedicalExamRecord entity. @author MyEclipse Persistence Tools
 */

public class WomanLastMedicalExamRecord implements java.io.Serializable {

	// Fields
	private String fileNo;
	private Timestamp lastExamDate;
	private String highRiskRemarks;
	private Integer type;

	// Constructors

	/** default constructor */
	public WomanLastMedicalExamRecord() {
	}

	/** minimal constructor */
	public WomanLastMedicalExamRecord(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public WomanLastMedicalExamRecord(String fileNo, Timestamp lastExamDate,
			String highRiskRemarks, Integer type) {
		this.fileNo = fileNo;
		this.lastExamDate = lastExamDate;
		this.highRiskRemarks = highRiskRemarks;
		this.type = type;
	}

	// Property accessors

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Timestamp getLastExamDate() {
		return this.lastExamDate;
	}

	public void setLastExamDate(Timestamp lastExamDate) {
		this.lastExamDate = lastExamDate;
	}

	public String getHighRiskRemarks() {
		return this.highRiskRemarks;
	}

	public void setHighRiskRemarks(String highRiskRemarks) {
		this.highRiskRemarks = highRiskRemarks;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}