package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;

import cn.net.tongfang.framework.security.vo.VaccineImmuneInfo;

public class VaccineImmuneInfoBO extends VaccineImmuneInfo {
	private Timestamp birthday;
	private Integer monthLimit;
	private Integer monthStart;
	private Timestamp plantedDate;
	private Timestamp limitDate;
	private Integer isSpecail;
	
	public VaccineImmuneInfoBO() {
		setInputDate(new Timestamp(System.currentTimeMillis()));
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Integer getMonthLimit() {
		return monthLimit;
	}

	public void setMonthLimit(Integer monthLimit) {
		this.monthLimit = monthLimit;
	}

	public Integer getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(Integer monthStart) {
		this.monthStart = monthStart;
	}

	public Timestamp getPlantedDate() {
		return plantedDate;
	}

	public void setPlantedDate(Timestamp plantedDate) {
		this.plantedDate = plantedDate;
	}

	public Timestamp getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Timestamp limitDate) {
		this.limitDate = limitDate;
	}

	public Integer getIsSpecail() {
		return isSpecail;
	}

	public void setIsSpecail(Integer isSpecail) {
		this.isSpecail = isSpecail;
	}
	
}
