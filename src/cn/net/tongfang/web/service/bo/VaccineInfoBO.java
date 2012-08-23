package cn.net.tongfang.web.service.bo;

import java.util.List;
import cn.net.tongfang.framework.security.vo.VaccineInfo;

public class VaccineInfoBO extends VaccineInfo {
	private List<VaccineInfo> vaccineInfo;

	public List<VaccineInfo> getVaccineInfo() {
		return vaccineInfo;
	}

	public void setVaccineInfo(List<VaccineInfo> vaccineInfo) {
		this.vaccineInfo = vaccineInfo;
	}
	
}
