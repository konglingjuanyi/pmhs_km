package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;
import java.util.List;

import cn.net.tongfang.framework.security.vo.AllergiesHistory;
import cn.net.tongfang.framework.security.vo.BloodTrans;
import cn.net.tongfang.framework.security.vo.BrotherHistory;
import cn.net.tongfang.framework.security.vo.DisabilityStatus;
import cn.net.tongfang.framework.security.vo.DiseaseHistory;
import cn.net.tongfang.framework.security.vo.ExposeHistory;
import cn.net.tongfang.framework.security.vo.FamilyHistory;
import cn.net.tongfang.framework.security.vo.FatherHistory;
import cn.net.tongfang.framework.security.vo.MatherHistory;
import cn.net.tongfang.framework.security.vo.Opshistory;
import cn.net.tongfang.framework.security.vo.PaymentMode;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.TraumaHistory;

public class PersonalInfoFBO extends PersonalInfo{
	
	private String fileNo;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private String name;
	private String address;
	private String residenceAddress;
	private String tel0;
	private String township;
	private String village;
	private String buildUnit;
	private String buildPerson;
	private String doctor;
	private Timestamp buildDate;
	private String districtNumber;
	private String namePng;
	private String inputPersonId; //当前登录的人
	private Timestamp inputDate;	
	private String barCode;
	private String paperFileNo;
	private Integer status;
	public PersonalInfoFBO(){
		inputDate = new java.sql.Timestamp(System.currentTimeMillis());
	}
	
	public List<Opshistory> opshistory;
	public List<TraumaHistory> traumaHistory;
	public List<DiseaseHistory> diseaseHistory;
	public List<BloodTrans> bloodTrans;
	
	public List<FatherHistory> fatherHistory;
	public List<MatherHistory> matherHistory;
	public List<BrotherHistory> brotherHistory;
	public List<FamilyHistory> familyHistory;
	
	public List<PaymentMode> paymentMode;
	public List<AllergiesHistory> allergiesHistory;
	public List<DisabilityStatus> disabilityStatus;
	
	public List<ExposeHistory> exposeHistory;
	
	
	public List<ExposeHistory> getExposeHistory() {
		return exposeHistory;
	}
	public void setExposeHistory(List<ExposeHistory> exposeHistory) {
		this.exposeHistory = exposeHistory;
	}
	public List<PaymentMode> getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(List<PaymentMode> paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<AllergiesHistory> getAllergiesHistory() {
		return allergiesHistory;
	}
	public void setAllergiesHistory(List<AllergiesHistory> allergiesHistory) {
		this.allergiesHistory = allergiesHistory;
	}
	public List<DisabilityStatus> getDisabilityStatus() {
		return disabilityStatus;
	}
	public void setDisabilityStatus(List<DisabilityStatus> disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}
	public List<FatherHistory> getFatherHistory() {
		return fatherHistory;
	}
	public void setFatherHistory(List<FatherHistory> fatherHistory) {
		this.fatherHistory = fatherHistory;
	}
	public List<MatherHistory> getMatherHistory() {
		return matherHistory;
	}
	public void setMatherHistory(List<MatherHistory> matherHistory) {
		this.matherHistory = matherHistory;
	}
	public List<BrotherHistory> getBrotherHistory() {
		return brotherHistory;
	}
	public void setBrotherHistory(List<BrotherHistory> brotherHistory) {
		this.brotherHistory = brotherHistory;
	}
	public List<FamilyHistory> getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(List<FamilyHistory> familyHistory) {
		this.familyHistory = familyHistory;
	}
	public List<Opshistory> getOpshistory() {
		return opshistory;
	}
	public void setOpshistory(List<Opshistory> opshistory) {
		this.opshistory = opshistory;
	}
	public List<TraumaHistory> getTraumaHistory() {
		return traumaHistory;
	}
	public void setTraumaHistory(List<TraumaHistory> traumaHistory) {
		this.traumaHistory = traumaHistory;
	}
	public List<DiseaseHistory> getDiseaseHistory() {
		return diseaseHistory;
	}
	public void setDiseaseHistory(List<DiseaseHistory> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	public List<BloodTrans> getBloodTrans() {
		return bloodTrans;
	}
	public void setBloodTrans(List<BloodTrans> bloodTrans) {
		this.bloodTrans = bloodTrans;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public String getTel0() {
		return tel0;
	}
	public void setTel0(String tel0) {
		this.tel0 = tel0;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getBuildUnit() {
		return buildUnit;
	}
	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}
	public String getBuildPerson() {
		return buildPerson;
	}
	public void setBuildPerson(String buildPerson) {
		this.buildPerson = buildPerson;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Timestamp getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Timestamp buildDate) {
		this.buildDate = buildDate;
	}
	public String getDistrictNumber() {
		return districtNumber;
	}
	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}
	public String getNamePng() {
		return namePng;
	}
	public void setNamePng(String namePng) {
		this.namePng = namePng;
	}
	public String getInputPersonId() {
		return inputPersonId;
	}
	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}
	public Timestamp getInputDate() {
		return inputDate;
	}
	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getPaperFileNo() {
		return paperFileNo;
	}
	public void setPaperFileNo(String paperFileNo) {
		this.paperFileNo = paperFileNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
