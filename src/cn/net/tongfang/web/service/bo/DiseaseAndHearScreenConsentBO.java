package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.AgreeConsentItems;
import cn.net.tongfang.framework.security.vo.DiseaseAndHearScreenConsent;

public class DiseaseAndHearScreenConsentBO extends DiseaseAndHearScreenConsent {
	private List<AgreeConsentItems> agreeConsentItems;

	public List<AgreeConsentItems> getAgreeConsentItems() {
		return agreeConsentItems;
	}

	public void setAgreeConsentItems(List<AgreeConsentItems> agreeConsentItems) {
		this.agreeConsentItems = agreeConsentItems;
	}

	
}
