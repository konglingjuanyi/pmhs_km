package cn.net.tongfang.framework.security.vo;

/**
 * OtotoxicityDrugHistory entity. @author MyEclipse Persistence Tools
 */

public class OtotoxicityDrugHistory implements java.io.Serializable {

	// Fields

	private String id;
	private String babyBarrierRegId;
	private String drugName;
	private String drugDose;
	private String treatment;

	// Constructors

	/** default constructor */
	public OtotoxicityDrugHistory() {
	}

	/** minimal constructor */
	public OtotoxicityDrugHistory(String babyBarrierRegId) {
		this.babyBarrierRegId = babyBarrierRegId;
	}

	/** full constructor */
	public OtotoxicityDrugHistory(String babyBarrierRegId, String drugName,
			String drugDose, String treatment) {
		this.babyBarrierRegId = babyBarrierRegId;
		this.drugName = drugName;
		this.drugDose = drugDose;
		this.treatment = treatment;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBabyBarrierRegId() {
		return this.babyBarrierRegId;
	}

	public void setBabyBarrierRegId(String babyBarrierRegId) {
		this.babyBarrierRegId = babyBarrierRegId;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugDose() {
		return this.drugDose;
	}

	public void setDrugDose(String drugDose) {
		this.drugDose = drugDose;
	}

	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

}