package cn.net.tongfang.framework.security.vo;

/**
 * HighRiskStatus entity. @author MyEclipse Persistence Tools
 */

public class HighRiskStatus implements java.io.Serializable {

	// Fields

	private String id;
	private String highRiskId;
	private String childFemaleId;

	// Constructors

	/** default constructor */
	public HighRiskStatus() {
	}

	/** full constructor */
	public HighRiskStatus(String highRiskId, String childFemaleId) {
		this.highRiskId = highRiskId;
		this.childFemaleId = childFemaleId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHighRiskId() {
		return this.highRiskId;
	}

	public void setHighRiskId(String highRiskId) {
		this.highRiskId = highRiskId;
	}

	public String getChildFemaleId() {
		return this.childFemaleId;
	}

	public void setChildFemaleId(String childFemaleId) {
		this.childFemaleId = childFemaleId;
	}

}