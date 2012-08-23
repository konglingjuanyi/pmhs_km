package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

public class ChronicDiseaseWTBO {
	private String personId;
	private String wtId;
	private String patientId;
	private Integer type;
	private Integer serviceType;
	private String makeDate;
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getWtId() {
		return wtId;
	}
	public void setWtId(String wtId) {
		this.wtId = wtId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public String getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}
	
	
}
