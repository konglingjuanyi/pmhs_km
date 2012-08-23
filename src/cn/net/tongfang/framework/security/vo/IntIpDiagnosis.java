package cn.net.tongfang.framework.security.vo;

/**
 * IntIpDiagnosis entity. @author MyEclipse Persistence Tools
 */

public class IntIpDiagnosis implements java.io.Serializable {

	// Fields

	private String id;
	private String intKey;
	private String ipKey;
	private String diagnosisId;
	private String diagnosisName;

	// Constructors

	/** default constructor */
	public IntIpDiagnosis() {
	}

	/** minimal constructor */
	public IntIpDiagnosis(String intKey, String ipKey) {
		this.intKey = intKey;
		this.ipKey = ipKey;
	}

	/** full constructor */
	public IntIpDiagnosis(String intKey, String ipKey, String diagnosisId,
			String diagnosisName) {
		this.intKey = intKey;
		this.ipKey = ipKey;
		this.diagnosisId = diagnosisId;
		this.diagnosisName = diagnosisName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntKey() {
		return this.intKey;
	}

	public void setIntKey(String intKey) {
		this.intKey = intKey;
	}

	public String getIpKey() {
		return this.ipKey;
	}

	public void setIpKey(String ipKey) {
		this.ipKey = ipKey;
	}

	public String getDiagnosisId() {
		return this.diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

}