package cn.net.tongfang.web.service.bo;

import cn.net.tongfang.framework.security.vo.Doctors;

public class DoctorsBO extends Doctors {
	private String hospitalName;
	private String hospitalPropId;

	public String getHospitalPropId() {
		return hospitalPropId;
	}

	public void setHospitalPropId(String hospitalPropId) {
		this.hospitalPropId = hospitalPropId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
}
