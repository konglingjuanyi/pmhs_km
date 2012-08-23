package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.BeforeBornCheckDirect;
import cn.net.tongfang.framework.security.vo.FemeFamilyHistory;
import cn.net.tongfang.framework.security.vo.FemePastHistory;
import cn.net.tongfang.framework.security.vo.FemeSecretion;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.PersonalHistory;

public class FirstVistBeforeBornBO extends FirstVistBeforeBorn{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<FemePastHistory> femePastHistory;
	List<FemeFamilyHistory> femeFamilyHistory;
	List<FemeSecretion> femeSecretion;
	List<PersonalHistory> personalHistory;
	List<BeforeBornCheckDirect> beforeBornCheckDirect;
	
	public List<BeforeBornCheckDirect> getBeforeBornCheckDirect() {
		return beforeBornCheckDirect;
	}
	public void setBeforeBornCheckDirect(
			List<BeforeBornCheckDirect> beforeBornCheckDirect) {
		this.beforeBornCheckDirect = beforeBornCheckDirect;
	}
	public List<FemePastHistory> getFemePastHistory() {
		return femePastHistory;
	}
	public void setFemePastHistory(List<FemePastHistory> femePastHistory) {
		this.femePastHistory = femePastHistory;
	}
	public List<FemeFamilyHistory> getFemeFamilyHistory() {
		return femeFamilyHistory;
	}
	public void setFemeFamilyHistory(List<FemeFamilyHistory> femeFamilyHistory) {
		this.femeFamilyHistory = femeFamilyHistory;
	}
	public List<FemeSecretion> getFemeSecretion() {
		return femeSecretion;
	}
	public void setFemeSecretion(List<FemeSecretion> femeSecretion) {
		this.femeSecretion = femeSecretion;
	}
	public List<PersonalHistory> getPersonalHistory() {
		return personalHistory;
	}
	public void setPersonalHistory(List<PersonalHistory> personalHistory) {
		this.personalHistory = personalHistory;
	}
}
