package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

public class PatientQry {
	private Integer clickType;
	private Timestamp startDate;
	private Timestamp endDate;
	private String fileNo;
	public Integer getClickType() {
		return clickType;
	}
	public void setClickType(Integer clickType) {
		this.clickType = clickType;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
}
