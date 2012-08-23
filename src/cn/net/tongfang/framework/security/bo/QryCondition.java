package cn.net.tongfang.framework.security.bo;

import java.util.List;


public class QryCondition {
	private String district;
	private String manPerson;
	private List<Condition> conditions;
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public String getManPerson() {
		return manPerson;
	}
	public void setManPerson(String manPerson) {
		this.manPerson = manPerson;
	}
	
}
