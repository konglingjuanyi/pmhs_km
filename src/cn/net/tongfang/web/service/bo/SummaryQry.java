package cn.net.tongfang.web.service.bo;

import java.util.Date;

public class SummaryQry {
	private Date startDate;
	private Date endDate;
	private String statisticType;
	private String statisticResult;
	private String fileNo;
	private String isQryWipeOut;
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatisticType() {
		return statisticType;
	}
	public void setStatisticType(String statisticType) {
		this.statisticType = statisticType;
	}
	public String getStatisticResult() {
		return statisticResult;
	}
	public void setStatisticResult(String statisticResult) {
		this.statisticResult = statisticResult;
	}
	public String getIsQryWipeOut() {
		return isQryWipeOut;
	}
	public void setIsQryWipeOut(String isQryWipeOut) {
		this.isQryWipeOut = isQryWipeOut;
	}
	
}
