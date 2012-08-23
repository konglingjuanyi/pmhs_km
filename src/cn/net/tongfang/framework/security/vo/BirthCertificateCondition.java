package cn.net.tongfang.framework.security.vo;

/**
 * BirthCertificateCondition entity. @author MyEclipse Persistence Tools
 */

public class BirthCertificateCondition implements java.io.Serializable {

	// Fields

	private String id;
	private Long startCondition;
	private Long endCondition;
	private String remarkId;

	// Constructors

	/** default constructor */
	public BirthCertificateCondition() {
	}

	/** full constructor */
	public BirthCertificateCondition(Long startCondition, Long endCondition,String remarkId) {
		this.startCondition = startCondition;
		this.endCondition = endCondition;
		this.remarkId = remarkId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getStartCondition() {
		return this.startCondition;
	}

	public void setStartCondition(Long startCondition) {
		this.startCondition = startCondition;
	}

	public Long getEndCondition() {
		return this.endCondition;
	}

	public void setEndCondition(Long endCondition) {
		this.endCondition = endCondition;
	}

	public String getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(String remarkId) {
		this.remarkId = remarkId;
	}

}