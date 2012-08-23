package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * WaitingThing entity. @author MyEclipse Persistence Tools
 */

public class WaitingThing implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String districtNum;
	private String transPerson;
	private Timestamp transDate;
	private String hospitalName;
	private String hisid;
	private Integer status;
	private String diagnoseId;
	private String diagnoseName;
	private Integer type;
	private Integer serviceType;
	private Timestamp dealDate;
	private String dealPerson;
	private String subId;
	// Constructors

	/** default constructor */
	public WaitingThing() {
	}

	/** minimal constructor */
	public WaitingThing(String fileNo, String hisid, Integer status,
			String diagnoseId, String diagnoseName) {
		this.fileNo = fileNo;
		this.hisid = hisid;
		this.status = status;
		this.diagnoseId = diagnoseId;
		this.diagnoseName = diagnoseName;
	}

	/** full constructor */
	public WaitingThing(String fileNo, String districtNum, String transPerson,
			Timestamp transDate, String hospitalName, String hisid,
			Integer status, String diagnoseId, String diagnoseName,
			Integer type,Integer serviceType,Timestamp dealDate,
			String dealPerson,String subId) {
		this.fileNo = fileNo;
		this.districtNum = districtNum;
		this.transPerson = transPerson;
		this.transDate = transDate;
		this.hospitalName = hospitalName;
		this.hisid = hisid;
		this.status = status;
		this.diagnoseId = diagnoseId;
		this.diagnoseName = diagnoseName;
		this.type = type;
		this.serviceType = serviceType;
		this.dealDate = dealDate;
		this.dealPerson = dealPerson;
		this.subId = subId;
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

	public String getDistrictNum() {
		return this.districtNum;
	}

	public void setDistrictNum(String districtNum) {
		this.districtNum = districtNum;
	}

	public String getTransPerson() {
		return this.transPerson;
	}

	public void setTransPerson(String transPerson) {
		this.transPerson = transPerson;
	}

	public Timestamp getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHisid() {
		return this.hisid;
	}

	public void setHisid(String hisid) {
		this.hisid = hisid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDiagnoseId() {
		return this.diagnoseId;
	}

	public void setDiagnoseId(String diagnoseId) {
		this.diagnoseId = diagnoseId;
	}

	public String getDiagnoseName() {
		return this.diagnoseName;
	}

	public void setDiagnoseName(String diagnoseName) {
		this.diagnoseName = diagnoseName;
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

	public Timestamp getDealDate() {
		return dealDate;
	}

	public void setDealDate(Timestamp dealDate) {
		this.dealDate = dealDate;
	}

	public String getDealPerson() {
		return dealPerson;
	}

	public void setDealPerson(String dealPerson) {
		this.dealPerson = dealPerson;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

}