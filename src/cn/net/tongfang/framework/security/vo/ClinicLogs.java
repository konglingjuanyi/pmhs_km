package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * AbstractClinicLogs entity provides the base persistence definition of the
 * ClinicLogs entity. @author MyEclipse Persistence Tools
 */

public class ClinicLogs implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileNo;
	private Timestamp inputTime;
	private Timestamp startIll;
	private String symptom;
	private Double temperature;
	private String diagnose;
	private String suggustion;
	private String doctor;
	private Timestamp recepTime;
	private String remark;
	private Boolean isModify;
	private String modifyTime;
	private Integer presure01;
	private Integer presure02;
	private SickInfo sickInfo;
	// Constructors

	public SickInfo getSickInfo() {
		return sickInfo;
	}

	public void setSickInfo(SickInfo sickInfo) {
		this.sickInfo = sickInfo;
	}

	/** default constructor */
	public ClinicLogs() {
	}

	/** minimal constructor */
	public ClinicLogs(String id, String fileNo, Timestamp inputTime,
			String modifyTime) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputTime = inputTime;
		this.modifyTime = modifyTime;
	}

	/** full constructor */
	public ClinicLogs(String id, String fileNo, Timestamp inputTime,
			Timestamp startIll, String symptom, Double temperature,
			String diagnose, String suggustion, String doctor,
			Timestamp recepTime, String remark, Boolean isModify,
			String modifyTime, Integer presure01, Integer presure02) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputTime = inputTime;
		this.startIll = startIll;
		this.symptom = symptom;
		this.temperature = temperature;
		this.diagnose = diagnose;
		this.suggustion = suggustion;
		this.doctor = doctor;
		this.recepTime = recepTime;
		this.remark = remark;
		this.isModify = isModify;
		this.modifyTime = modifyTime;
		this.presure01 = presure01;
		this.presure02 = presure02;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Timestamp getStartIll() {
		return this.startIll;
	}

	public void setStartIll(Timestamp startIll) {
		this.startIll = startIll;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getDiagnose() {
		return this.diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getSuggustion() {
		return this.suggustion;
	}

	public void setSuggustion(String suggustion) {
		this.suggustion = suggustion;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Timestamp getRecepTime() {
		return this.recepTime;
	}

	public void setRecepTime(Timestamp recepTime) {
		this.recepTime = recepTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getIsModify() {
		return this.isModify;
	}

	public void setIsModify(Boolean isModify) {
		this.isModify = isModify;
	}

	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getPresure01() {
		return this.presure01;
	}

	public void setPresure01(Integer presure01) {
		this.presure01 = presure01;
	}

	public Integer getPresure02() {
		return this.presure02;
	}

	public void setPresure02(Integer presure02) {
		this.presure02 = presure02;
	}

}