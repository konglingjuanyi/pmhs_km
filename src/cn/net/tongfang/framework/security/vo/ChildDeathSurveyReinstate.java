package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * ChildDeathSurveyReinstate entity. @author MyEclipse Persistence Tools
 */

public class ChildDeathSurveyReinstate implements java.io.Serializable {

	// Fields

	private String id;
	private String childrenDeathSurvey01id;
	private Timestamp reinstateDate;
	private String reinstateHospital;
	private String reinstateSymbol;
	private String resinstateDeal;

	// Constructors

	/** default constructor */
	public ChildDeathSurveyReinstate() {
	}

	/** minimal constructor */
	public ChildDeathSurveyReinstate(String childrenDeathSurvey01id) {
		this.childrenDeathSurvey01id = childrenDeathSurvey01id;
	}

	/** full constructor */
	public ChildDeathSurveyReinstate(String childrenDeathSurvey01id,
			Timestamp reinstateDate, String reinstateHospital,
			String reinstateSymbol, String resinstateDeal) {
		this.childrenDeathSurvey01id = childrenDeathSurvey01id;
		this.reinstateDate = reinstateDate;
		this.reinstateHospital = reinstateHospital;
		this.reinstateSymbol = reinstateSymbol;
		this.resinstateDeal = resinstateDeal;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChildrenDeathSurvey01id() {
		return this.childrenDeathSurvey01id;
	}

	public void setChildrenDeathSurvey01id(String childrenDeathSurvey01id) {
		this.childrenDeathSurvey01id = childrenDeathSurvey01id;
	}

	public Timestamp getReinstateDate() {
		return this.reinstateDate;
	}

	public void setReinstateDate(Timestamp reinstateDate) {
		this.reinstateDate = reinstateDate;
	}

	public String getReinstateHospital() {
		return this.reinstateHospital;
	}

	public void setReinstateHospital(String reinstateHospital) {
		this.reinstateHospital = reinstateHospital;
	}

	public String getReinstateSymbol() {
		return this.reinstateSymbol;
	}

	public void setReinstateSymbol(String reinstateSymbol) {
		this.reinstateSymbol = reinstateSymbol;
	}

	public String getResinstateDeal() {
		return this.resinstateDeal;
	}

	public void setResinstateDeal(String resinstateDeal) {
		this.resinstateDeal = resinstateDeal;
	}

}