package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * DiseaseAndHearScreenConsent entity. @author MyEclipse Persistence Tools
 */

public class DiseaseAndHearScreenConsent implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String pregnantWomanName;
	private String hospitalNumber;
	private String signature;
	private String linkTel;
	private Timestamp agreeTime;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public DiseaseAndHearScreenConsent() {
	}

	/** minimal constructor */
	public DiseaseAndHearScreenConsent(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public DiseaseAndHearScreenConsent(String fileNo, String pregnantWomanName,
			String hospitalNumber, String signature, String linkTel,
			Timestamp agreeTime, String inputPersonId, Timestamp inputDate,
			String execDistrictNum) {
		this.fileNo = fileNo;
		this.pregnantWomanName = pregnantWomanName;
		this.hospitalNumber = hospitalNumber;
		this.signature = signature;
		this.linkTel = linkTel;
		this.agreeTime = agreeTime;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.execDistrictNum = execDistrictNum;
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

	public String getPregnantWomanName() {
		return this.pregnantWomanName;
	}

	public void setPregnantWomanName(String pregnantWomanName) {
		this.pregnantWomanName = pregnantWomanName;
	}

	public String getHospitalNumber() {
		return this.hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getLinkTel() {
		return this.linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public Timestamp getAgreeTime() {
		return this.agreeTime;
	}

	public void setAgreeTime(Timestamp agreeTime) {
		this.agreeTime = agreeTime;
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

	public String getExecDistrictNum() {
		return this.execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}