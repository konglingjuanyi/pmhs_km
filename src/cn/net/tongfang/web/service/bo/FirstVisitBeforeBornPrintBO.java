package cn.net.tongfang.web.service.bo;

import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;

public class FirstVisitBeforeBornPrintBO extends FirstVistBeforeBorn {
	private String femePastHistory;
	private String femeFamilyHistory;
	private String femeSecretion;
//	private String personalHistory;
	private String beforeBornCheckDirect;
	public String getFemePastHistory() {
		return femePastHistory;
	}
	public void setFemePastHistory(String femePastHistory) {
		this.femePastHistory = femePastHistory;
	}
	public String getFemeFamilyHistory() {
		return femeFamilyHistory;
	}
	public void setFemeFamilyHistory(String femeFamilyHistory) {
		this.femeFamilyHistory = femeFamilyHistory;
	}
	public String getFemeSecretion() {
		return femeSecretion;
	}
	public void setFemeSecretion(String femeSecretion) {
		this.femeSecretion = femeSecretion;
	}
	public String getBeforeBornCheckDirect() {
		return beforeBornCheckDirect;
	}
	public void setBeforeBornCheckDirect(String beforeBornCheckDirect) {
		this.beforeBornCheckDirect = beforeBornCheckDirect;
	}
	
}
