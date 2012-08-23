package cn.net.tongfang.web.service.bo;

import cn.net.tongfang.framework.security.vo.BirthCertificate;

public class BirthCertificateBO extends BirthCertificate {
	private Integer type;
	private String reasonRemarks;
	private String otherDestroyReason;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getReasonRemarks() {
		return reasonRemarks;
	}
	public void setReasonRemarks(String reasonRemarks) {
		this.reasonRemarks = reasonRemarks;
	}

	public String getOtherDestroyReason() {
		return otherDestroyReason;
	}
	public void setOtherDestroyReason(String otherDestroyReason) {
		this.otherDestroyReason = otherDestroyReason;
	}
	
}
