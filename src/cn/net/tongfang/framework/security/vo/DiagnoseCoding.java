package cn.net.tongfang.framework.security.vo;

/**
 * DiagnoseCoding entity. @author MyEclipse Persistence Tools
 */

public class DiagnoseCoding implements java.io.Serializable {

	// Fields

	private String id;
	private String diagnoseName;
	private String diagnoseNamePng;
	private Integer serviceType;
	private Integer number;
	// Constructors

	/** default constructor */
	public DiagnoseCoding() {
	}

	/** full constructor */
	public DiagnoseCoding(String id, String diagnoseName,
			String diagnoseNamePng, Integer serviceType,
			Integer number) {
		this.id = id;
		this.diagnoseName = diagnoseName;
		this.diagnoseNamePng = diagnoseNamePng;
		this.serviceType = serviceType;
		this.number = number;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiagnoseName() {
		return this.diagnoseName;
	}

	public void setDiagnoseName(String diagnoseName) {
		this.diagnoseName = diagnoseName;
	}

	public String getDiagnoseNamePng() {
		return this.diagnoseNamePng;
	}

	public void setDiagnoseNamePng(String diagnoseNamePng) {
		this.diagnoseNamePng = diagnoseNamePng;
	}

	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}