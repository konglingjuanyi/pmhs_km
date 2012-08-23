package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BarCode entity. @author MyEclipse Persistence Tools
 */

public class BarCode implements java.io.Serializable {

	// Fields

	private String id;
	private Timestamp initDate;
	private String initPersonId;
	private String status;

	// Constructors

	/** default constructor */
	public BarCode() {
	}

	/** minimal constructor */
	public BarCode(Timestamp initDate, String initPersonId) {
		this.initDate = initDate;
		this.initPersonId = initPersonId;
	}

	/** full constructor */
	public BarCode(Timestamp initDate, String initPersonId, String status) {
		this.initDate = initDate;
		this.initPersonId = initPersonId;
		this.status = status;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getInitDate() {
		return this.initDate;
	}

	public void setInitDate(Timestamp initDate) {
		this.initDate = initDate;
	}

	public String getInitPersonId() {
		return this.initPersonId;
	}

	public void setInitPersonId(String initPersonId) {
		this.initPersonId = initPersonId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}