package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * SystemInformation entity. @author MyEclipse Persistence Tools
 */

public class SystemInformation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String val;
	private String remarks;
	private Timestamp inputDate;
	private String inputPersonId;

	// Constructors

	/** default constructor */
	public SystemInformation() {
	}

	/** minimal constructor */
	public SystemInformation(String val) {
		this.val = val;
	}

	/** full constructor */
	public SystemInformation(String val, String remarks, Timestamp inputDate,
			String inputPersonId) {
		this.val = val;
		this.remarks = remarks;
		this.inputDate = inputDate;
		this.inputPersonId = inputPersonId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

}