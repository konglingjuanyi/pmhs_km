package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.Consultation;
import cn.net.tongfang.framework.security.vo.ConsultationOrg;

public class ConsultationBO extends Consultation{
	List<ConsultationOrg> consultationOrg;

	public List<ConsultationOrg> getConsultationOrg() {
		return consultationOrg;
	}

	public void setConsultationOrg(List<ConsultationOrg> consultationOrg) {
		this.consultationOrg = consultationOrg;
	}
	
	
	
}
