package cn.net.tongfang.framework.security.vo;

/**
 * IntOpDiagnosis entity. @author MyEclipse Persistence Tools
 */

public class IntOpDiagnosis implements java.io.Serializable {

	// Fields

	private String id;
	private String intKey;
	private String opKey;
	private String diagnosisId;
	private String diagnosisName;

	// Constructors

	/** default constructor */
	public IntOpDiagnosis() {
	}

	/** minimal constructor */
	public IntOpDiagnosis(String intKey, String opKey) {
		this.intKey = intKey;
		this.opKey = opKey;
	}

	/** full constructor */
	public IntOpDiagnosis(String intKey, String opKey, String diagnosisId,
			String diagnosisName) {
		this.intKey = intKey;
		this.opKey = opKey;
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

	public String getOpKey() {
		return this.opKey;
	}

	public void setOpKey(String opKey) {
		this.opKey = opKey;
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