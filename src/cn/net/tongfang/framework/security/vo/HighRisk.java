package cn.net.tongfang.framework.security.vo;

/**
 * HighRisk entity. @author MyEclipse Persistence Tools
 */

public class HighRisk implements java.io.Serializable {

	// Fields

	private String id;
	private String number;
	private String exception;
	private String type;
	private String exceptionPng;
	// Constructors

	/** default constructor */
	public HighRisk() {
	}

	/** full constructor */
	public HighRisk(String number, String exception, String type,String exceptionPng) {
		this.number = number;
		this.exception = exception;
		this.type = type;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExceptionPng() {
		return exceptionPng;
	}

	public void setExceptionPng(String exceptionPng) {
		this.exceptionPng = exceptionPng;
	}

}