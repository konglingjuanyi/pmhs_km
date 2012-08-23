package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

public class NewHealthFileWTBO {
	private String address;
	private Timestamp birthDay;
	private String id;
	private String idnumber;
	private String occupation;
	private String personName;
	private String sex;
	private String districtNumber;
	private String fileNo;
	public NewHealthFileWTBO() {
		super();
	}
	
	public NewHealthFileWTBO(String address, Timestamp birthDay, String id,
			String idnumber, String occupation, String personName, String sex,
			String districtNumber,String fileNo) {
		super();
		this.address = address;
		this.birthDay = birthDay;
		this.id = id;
		this.idnumber = idnumber;
		this.occupation = occupation;
		this.personName = personName;
		this.sex = sex;
		this.districtNumber = districtNumber;
		this.fileNo = fileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDistrictNumber() {
		return districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
}
