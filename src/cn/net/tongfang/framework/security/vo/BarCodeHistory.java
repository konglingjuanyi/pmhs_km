package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BarCodeHistory entity. @author MyEclipse Persistence Tools
 */

public class BarCodeHistory implements java.io.Serializable {

	// Fields

	private String id;
	private String distriNo;
	private String years;
	private Integer minVal;
	private Integer maxVal;
	private String otherVal;
	private String inputPersonId;
	private Timestamp inputDate;
	private String type;
	// Constructors

	/** default constructor */
	public BarCodeHistory() {
	}


	/** full constructor */
	public BarCodeHistory(String distriNo,String years, Integer minVal, Integer maxVal,
			String otherVal, String inputPersonId, Timestamp inputDate,String type) {
		this.distriNo = distriNo;
		this.years = years;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.otherVal = otherVal;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.type = type;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getDistriNo() {
		return distriNo;
	}


	public void setDistriNo(String distriNo) {
		this.distriNo = distriNo;
	}


	public String getYears() {
		return years;
	}


	public void setYears(String years) {
		this.years = years;
	}


	public Integer getMinVal() {
		return this.minVal;
	}

	public void setMinVal(Integer minVal) {
		this.minVal = minVal;
	}

	public Integer getMaxVal() {
		return this.maxVal;
	}

	public void setMaxVal(Integer maxVal) {
		this.maxVal = maxVal;
	}

	public String getOtherVal() {
		return this.otherVal;
	}

	public void setOtherVal(String otherVal) {
		this.otherVal = otherVal;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}