package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * TuberSuperDetail entity. @author MyEclipse Persistence Tools
 */

public class TuberSuperDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp timeForSupervise;
	private String judgmentForSupervise;
	private Integer noForSpecies;
	private Integer loseTime;
	private String loseReason;
	private Integer fillTime;
	private Integer stopTime;
	private String visitPerson;
	private String baseId;

	// Constructors

	/** default constructor */
	public TuberSuperDetail() {
	}

	/** minimal constructor */
	public TuberSuperDetail(Integer id, String judgmentForSupervise,
			String baseId) {
		this.id = id;
		this.judgmentForSupervise = judgmentForSupervise;
		this.baseId = baseId;
	}

	/** full constructor */
	public TuberSuperDetail(Integer id, Timestamp timeForSupervise,
			String judgmentForSupervise, Integer noForSpecies,
			Integer loseTime, String loseReason, Integer fillTime,
			Integer stopTime, String visitPerson, String baseId) {
		this.id = id;
		this.timeForSupervise = timeForSupervise;
		this.judgmentForSupervise = judgmentForSupervise;
		this.noForSpecies = noForSpecies;
		this.loseTime = loseTime;
		this.loseReason = loseReason;
		this.fillTime = fillTime;
		this.stopTime = stopTime;
		this.visitPerson = visitPerson;
		this.baseId = baseId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTimeForSupervise() {
		return this.timeForSupervise;
	}

	public void setTimeForSupervise(Timestamp timeForSupervise) {
		this.timeForSupervise = timeForSupervise;
	}

	public String getJudgmentForSupervise() {
		return this.judgmentForSupervise;
	}

	public void setJudgmentForSupervise(String judgmentForSupervise) {
		this.judgmentForSupervise = judgmentForSupervise;
	}

	public Integer getNoForSpecies() {
		return this.noForSpecies;
	}

	public void setNoForSpecies(Integer noForSpecies) {
		this.noForSpecies = noForSpecies;
	}

	public Integer getLoseTime() {
		return this.loseTime;
	}

	public void setLoseTime(Integer loseTime) {
		this.loseTime = loseTime;
	}

	public String getLoseReason() {
		return this.loseReason;
	}

	public void setLoseReason(String loseReason) {
		this.loseReason = loseReason;
	}

	public Integer getFillTime() {
		return this.fillTime;
	}

	public void setFillTime(Integer fillTime) {
		this.fillTime = fillTime;
	}

	public Integer getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Integer stopTime) {
		this.stopTime = stopTime;
	}

	public String getVisitPerson() {
		return this.visitPerson;
	}

	public void setVisitPerson(String visitPerson) {
		this.visitPerson = visitPerson;
	}

	public String getBaseId() {
		return this.baseId;
	}

	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}

}