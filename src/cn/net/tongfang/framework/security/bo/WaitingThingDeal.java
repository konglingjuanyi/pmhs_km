package cn.net.tongfang.framework.security.bo;

import java.sql.Timestamp;

public class WaitingThingDeal {
	private String id;
	private String fileNo;
	private Integer serviceType;
	private String districtNum;
	private Timestamp transDate;
	private Integer type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public String getDistrictNum() {
		return districtNum;
	}
	public void setDistrictNum(String districtNum) {
		this.districtNum = districtNum;
	}
	public Timestamp getTransDate() {
		return transDate;
	}
	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
		
}
