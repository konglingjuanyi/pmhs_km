package cn.net.tongfang.framework.security.vo;

/**
 * VaccineImmuneRules entity. @author MyEclipse Persistence Tools
 */

public class VaccineImmuneRules implements java.io.Serializable {

	// Fields

	private Integer id;
	private String vaccineName;
	private String vaccinationObject;
	private Integer minMonthAge;
	private Integer maxMonthAge;
	private String vaccinationPosition;
	private String vaccinationWay;
	private String vaccinationDose;
	private Integer minTimeInterval;
	private Integer maxTimeInterval;
	private String remarks;
	private Integer type;
	private String number;
	private Integer dependId;
	private Integer rowNumber;
	private Integer rules;
	private Integer isSpecial;
	private String vaccineRemark;
	private Integer monthLimit;
	private Integer monthStart;
	// Constructors

	/** default constructor */
	public VaccineImmuneRules() {
	}

	/** minimal constructor */
	public VaccineImmuneRules(Integer id, String vaccineName,
			String vaccinationObject, Integer minMonthAge, Integer maxMonthAge,
			String vaccinationWay, String vaccinationDose, Integer type,
			Integer isSpecial) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.vaccinationObject = vaccinationObject;
		this.minMonthAge = minMonthAge;
		this.maxMonthAge = maxMonthAge;
		this.vaccinationWay = vaccinationWay;
		this.vaccinationDose = vaccinationDose;
		this.type = type;
		this.isSpecial = isSpecial;
	}

	/** full constructor */
	public VaccineImmuneRules(Integer id, String vaccineName,
			String vaccinationObject, Integer minMonthAge, Integer maxMonthAge,
			String vaccinationPosition, String vaccinationWay,
			String vaccinationDose, Integer minTimeInterval,
			Integer maxTimeInterval, String remarks, Integer type,
			String number, Integer dependId, Integer rowNumber, Integer rules,
			Integer isSpecial,String vaccineRemark,Integer monthLimit,Integer monthStart) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.vaccinationObject = vaccinationObject;
		this.minMonthAge = minMonthAge;
		this.maxMonthAge = maxMonthAge;
		this.vaccinationPosition = vaccinationPosition;
		this.vaccinationWay = vaccinationWay;
		this.vaccinationDose = vaccinationDose;
		this.minTimeInterval = minTimeInterval;
		this.maxTimeInterval = maxTimeInterval;
		this.remarks = remarks;
		this.type = type;
		this.number = number;
		this.dependId = dependId;
		this.rowNumber = rowNumber;
		this.rules = rules;
		this.isSpecial = isSpecial;
		this.vaccineRemark = vaccineRemark;
		this.monthLimit = monthLimit;
		this.monthStart = monthStart;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaccineName() {
		return this.vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccinationObject() {
		return this.vaccinationObject;
	}

	public void setVaccinationObject(String vaccinationObject) {
		this.vaccinationObject = vaccinationObject;
	}

	public Integer getMinMonthAge() {
		return this.minMonthAge;
	}

	public void setMinMonthAge(Integer minMonthAge) {
		this.minMonthAge = minMonthAge;
	}

	public Integer getMaxMonthAge() {
		return this.maxMonthAge;
	}

	public void setMaxMonthAge(Integer maxMonthAge) {
		this.maxMonthAge = maxMonthAge;
	}

	public String getVaccinationPosition() {
		return this.vaccinationPosition;
	}

	public void setVaccinationPosition(String vaccinationPosition) {
		this.vaccinationPosition = vaccinationPosition;
	}

	public String getVaccinationWay() {
		return this.vaccinationWay;
	}

	public void setVaccinationWay(String vaccinationWay) {
		this.vaccinationWay = vaccinationWay;
	}

	public String getVaccinationDose() {
		return this.vaccinationDose;
	}

	public void setVaccinationDose(String vaccinationDose) {
		this.vaccinationDose = vaccinationDose;
	}

	public Integer getMinTimeInterval() {
		return this.minTimeInterval;
	}

	public void setMinTimeInterval(Integer minTimeInterval) {
		this.minTimeInterval = minTimeInterval;
	}

	public Integer getMaxTimeInterval() {
		return this.maxTimeInterval;
	}

	public void setMaxTimeInterval(Integer maxTimeInterval) {
		this.maxTimeInterval = maxTimeInterval;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getDependId() {
		return this.dependId;
	}

	public void setDependId(Integer dependId) {
		this.dependId = dependId;
	}

	public Integer getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getRules() {
		return this.rules;
	}

	public void setRules(Integer rules) {
		this.rules = rules;
	}

	public Integer getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}

	public String getVaccineRemark() {
		return vaccineRemark;
	}

	public void setVaccineRemark(String vaccineRemark) {
		this.vaccineRemark = vaccineRemark;
	}

	public Integer getMonthLimit() {
		return monthLimit;
	}

	public void setMonthLimit(Integer monthLimit) {
		this.monthLimit = monthLimit;
	}

	public Integer getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(Integer monthStart) {
		this.monthStart = monthStart;
	}

}