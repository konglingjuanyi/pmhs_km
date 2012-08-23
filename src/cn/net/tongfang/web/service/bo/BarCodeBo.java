package cn.net.tongfang.web.service.bo;

public class BarCodeBo {
	private Integer successNum;
	private Integer failureNum;
	private String failureStr;
	private String errorCode;
	public Integer getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
	public Integer getFailureNum() {
		return failureNum;
	}
	public void setFailureNum(Integer failureNum) {
		this.failureNum = failureNum;
	}
	public String getFailureStr() {
		return failureStr;
	}
	public void setFailureStr(String failureStr) {
		this.failureStr = failureStr;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
