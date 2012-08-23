package cn.net.tongfang.web.service.bo;

public class CertificateBO {
	private int successNum;
	private int failureNum;
	private String failureCertificate;
	public int getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}
	public int getFailureNum() {
		return failureNum;
	}
	public void setFailureNum(int failureNum) {
		this.failureNum = failureNum;
	}
	public String getFailureCertificate() {
		return failureCertificate;
	}
	public void setFailureCertificate(String failureCertificate) {
		this.failureCertificate = failureCertificate;
	}
	
	
}
