package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

public class TuberculosisBO{

	private String fileNo;
	private String name;
	private String sex;
	private Integer age;
	private String address;
	private String typeForSick;
	private String regNo;
	private String caseHisNo;
	private String judgmentForSupervise;
	private Timestamp timeForSupervise;
	private Integer noForSpecies;
	private String loseReason;
	private Integer loseTime;
	private Integer fillTime;
	private Integer stopTime;
	private String visitPerson;
	private String districtNumber;
	
	public String getDistrictNumber() {
		return districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TuberculosisBO() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTypeForSick() {
		return typeForSick;
	}

	public void setTypeForSick(String typeForSick) {
		this.typeForSick = typeForSick;
	}
	
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getCaseHisNo() {
		return caseHisNo;
	}
	public void setCaseHisNo(String caseHisNo) {
		this.caseHisNo = caseHisNo;
	}
	public String getJudgmentForSupervise() {
		return judgmentForSupervise;
	}
	public void setJudgmentForSupervise(String judgmentForSupervise) {
		this.judgmentForSupervise = judgmentForSupervise;
	}
	public Timestamp getTimeForSupervise() {
		return timeForSupervise;
	}
	public void setTimeForSupervise(Timestamp timeForSupervise) {
		this.timeForSupervise = timeForSupervise;
	}
	public Integer getNoForSpecies() {
		return noForSpecies;
	}
	public void setNoForSpecies(Integer noForSpecies) {
		this.noForSpecies = noForSpecies;
	}
	public String getLoseReason() {
		return loseReason;
	}
	public void setLoseReason(String loseReason) {
		this.loseReason = loseReason;
	}
	public Integer getLoseTime() {
		return loseTime;
	}
	public void setLoseTime(Integer loseTime) {
		this.loseTime = loseTime;
	}
	public Integer getFillTime() {
		return fillTime;
	}
	public void setFillTime(Integer fillTime) {
		this.fillTime = fillTime;
	}
	public Integer getStopTime() {
		return stopTime;
	}
	public void setStopTime(Integer stopTime) {
		this.stopTime = stopTime;
	}
	public String getVisitPerson() {
		return visitPerson;
	}
	public void setVisitPerson(String visitPerson) {
		this.visitPerson = visitPerson;
	}
	
	
}
