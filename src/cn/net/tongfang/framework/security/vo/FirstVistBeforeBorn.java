package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * FirstVistBeforeBorn entity. @author MyEclipse Persistence Tools
 */

public class FirstVistBeforeBorn implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp inputDate;
	private Timestamp visitDate;
	private Double diastolicPressure;
	private Double systolicPressure;
	private String evaluation;
	private Boolean transfer;
	private String transReason;
	private String transUnit;
	private String visitDoctor;
	private Timestamp nextVisitDate;
	private String weeks;
	private String husbandName;
	private Integer husbandAge;
	private String husbandTel;
	private Integer gravidity;
	private Integer parity;
	private Timestamp lastMenses;
	private Timestamp edc;
	private String pastHistoryOther;
	private String familyHistoryOther;
	private String opshistory;
	private String opshistoryOther;
	private Integer pregnant1;
	private Integer pregnant2;
	private Integer pregnant3;
	private Integer pregnant4;
	private Double height;
	private Double weight;
	private Double habitus;
	private String exam01;
	private String exam01other;
	private String exam02;
	private String exam02other;
	private String exam03;
	private String exam03other;
	private String exam04;
	private String exam04other;
	private String exam05;
	private String exam05other;
	private String exam06;
	private String exam06other;
	private String exam07;
	private String exam07other;
	private String exam08;
	private Double exam09;
	private Double exam10;
	private String exam11;
	private String exam12;
	private String exam13;
	private String exam14;
	private String exam15;
	private String exam16;
	private Double exam17;
	private Double exam18;
	private Double exam19;
	private Double exam20;
	private Double exam21;
	private Double exam22;
	private Double exam23;
	private Double exam24;
	private Double exam25;
	private String exam26;
	private String exam26other;
	private String exam27;
	private String exam28;
	private String beforeBornDirectOther;
	private Integer bornAge;
	private Integer parity1;
	private String personalHistoryOther;
	private Integer pregnant5;
	private String bloodTypeAbo;
	private String bloodTypeRh;
	private Double bloodSugar;
	private String femeClean;
	private String hepatitis01;
	private String hepatitis02;
	private String hepatitis03;
	private String hepatitis04;
	private String hepatitis05;
	private String exam29;
	private String beforeBornCheckDirectOther;
	private String highRisk;
	private String highRiskRemark;
	private String execDistrictNum;
	private String highRiskSearch;
	// Constructors

	/** default constructor */
	public FirstVistBeforeBorn() {
	}

	/** minimal constructor */
	public FirstVistBeforeBorn(String id, String fileNo, Timestamp inputDate,
			Timestamp visitDate) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputDate = inputDate;
		this.visitDate = visitDate;
	}

	/** full constructor */
	public FirstVistBeforeBorn(String id, String fileNo, String inputPersonId,
			Timestamp inputDate, Timestamp visitDate, Double diastolicPressure,
			Double systolicPressure, String evaluation, Boolean transfer,
			String transReason, String transUnit, String visitDoctor,
			Timestamp nextVisitDate, String weeks, String husbandName,
			Integer husbandAge, String husbandTel, Integer gravidity,
			Integer parity, Timestamp lastMenses, Timestamp edc,
			String pastHistoryOther, String familyHistoryOther,
			String opshistory, String opshistoryOther, Integer pregnant1,
			Integer pregnant2, Integer pregnant3, Integer pregnant4,
			Double height, Double weight, Double habitus, String exam01,
			String exam01other, String exam02, String exam02other,
			String exam03, String exam03other, String exam04,
			String exam04other, String exam05, String exam05other,
			String exam06, String exam06other, String exam07,
			String exam07other, String exam08, Double exam09, Double exam10,
			String exam11, String exam12, String exam13, String exam14,
			String exam15, String exam16, Double exam17, Double exam18,
			Double exam19, Double exam20, Double exam21, Double exam22,
			Double exam23, Double exam24, Double exam25, String exam26,
			String exam26other, String exam27, String exam28,
			String beforeBornDirectOther, Integer bornAge, Integer parity1,
			String personalHistoryOther, Integer pregnant5,
			String bloodTypeAbo, String bloodTypeRh, Double bloodSugar,
			String femeClean, String hepatitis01, String hepatitis02,
			String hepatitis03, String hepatitis04, String hepatitis05,
			String exam29, String beforeBornCheckDirectOther,String highRisk,
			String highRiskRemark,String execDistrictNum,String highRiskSearch) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.visitDate = visitDate;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.evaluation = evaluation;
		this.transfer = transfer;
		this.transReason = transReason;
		this.transUnit = transUnit;
		this.visitDoctor = visitDoctor;
		this.nextVisitDate = nextVisitDate;
		this.weeks = weeks;
		this.husbandName = husbandName;
		this.husbandAge = husbandAge;
		this.husbandTel = husbandTel;
		this.gravidity = gravidity;
		this.parity = parity;
		this.lastMenses = lastMenses;
		this.edc = edc;
		this.pastHistoryOther = pastHistoryOther;
		this.familyHistoryOther = familyHistoryOther;
		this.opshistory = opshistory;
		this.opshistoryOther = opshistoryOther;
		this.pregnant1 = pregnant1;
		this.pregnant2 = pregnant2;
		this.pregnant3 = pregnant3;
		this.pregnant4 = pregnant4;
		this.height = height;
		this.weight = weight;
		this.habitus = habitus;
		this.exam01 = exam01;
		this.exam01other = exam01other;
		this.exam02 = exam02;
		this.exam02other = exam02other;
		this.exam03 = exam03;
		this.exam03other = exam03other;
		this.exam04 = exam04;
		this.exam04other = exam04other;
		this.exam05 = exam05;
		this.exam05other = exam05other;
		this.exam06 = exam06;
		this.exam06other = exam06other;
		this.exam07 = exam07;
		this.exam07other = exam07other;
		this.exam08 = exam08;
		this.exam09 = exam09;
		this.exam10 = exam10;
		this.exam11 = exam11;
		this.exam12 = exam12;
		this.exam13 = exam13;
		this.exam14 = exam14;
		this.exam15 = exam15;
		this.exam16 = exam16;
		this.exam17 = exam17;
		this.exam18 = exam18;
		this.exam19 = exam19;
		this.exam20 = exam20;
		this.exam21 = exam21;
		this.exam22 = exam22;
		this.exam23 = exam23;
		this.exam24 = exam24;
		this.exam25 = exam25;
		this.exam26 = exam26;
		this.exam26other = exam26other;
		this.exam27 = exam27;
		this.exam28 = exam28;
		this.beforeBornDirectOther = beforeBornDirectOther;
		this.bornAge = bornAge;
		this.parity1 = parity1;
		this.personalHistoryOther = personalHistoryOther;
		this.pregnant5 = pregnant5;
		this.bloodTypeAbo = bloodTypeAbo;
		this.bloodTypeRh = bloodTypeRh;
		this.bloodSugar = bloodSugar;
		this.femeClean = femeClean;
		this.hepatitis01 = hepatitis01;
		this.hepatitis02 = hepatitis02;
		this.hepatitis03 = hepatitis03;
		this.hepatitis04 = hepatitis04;
		this.hepatitis05 = hepatitis05;
		this.exam29 = exam29;
		this.beforeBornCheckDirectOther = beforeBornCheckDirectOther;
		this.highRisk = highRisk;
		this.highRiskRemark = highRiskRemark;
		this.execDistrictNum = execDistrictNum;
		this.highRiskSearch = highRiskSearch;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	public Timestamp getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public Double getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(Double diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public Double getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(Double systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Boolean getTransfer() {
		return this.transfer;
	}

	public void setTransfer(Boolean transfer) {
		this.transfer = transfer;
	}

	public String getTransReason() {
		return this.transReason;
	}

	public void setTransReason(String transReason) {
		this.transReason = transReason;
	}

	public String getTransUnit() {
		return this.transUnit;
	}

	public void setTransUnit(String transUnit) {
		this.transUnit = transUnit;
	}

	public String getVisitDoctor() {
		return this.visitDoctor;
	}

	public void setVisitDoctor(String visitDoctor) {
		this.visitDoctor = visitDoctor;
	}

	public Timestamp getNextVisitDate() {
		return this.nextVisitDate;
	}

	public void setNextVisitDate(Timestamp nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getWeeks() {
		return this.weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getHusbandName() {
		return this.husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public Integer getHusbandAge() {
		return this.husbandAge;
	}

	public void setHusbandAge(Integer husbandAge) {
		this.husbandAge = husbandAge;
	}

	public String getHusbandTel() {
		return this.husbandTel;
	}

	public void setHusbandTel(String husbandTel) {
		this.husbandTel = husbandTel;
	}

	public Integer getGravidity() {
		return this.gravidity;
	}

	public void setGravidity(Integer gravidity) {
		this.gravidity = gravidity;
	}

	public Integer getParity() {
		return this.parity;
	}

	public void setParity(Integer parity) {
		this.parity = parity;
	}

	public Timestamp getLastMenses() {
		return this.lastMenses;
	}

	public void setLastMenses(Timestamp lastMenses) {
		this.lastMenses = lastMenses;
	}

	public Timestamp getEdc() {
		return this.edc;
	}

	public void setEdc(Timestamp edc) {
		this.edc = edc;
	}

	public String getPastHistoryOther() {
		return this.pastHistoryOther;
	}

	public void setPastHistoryOther(String pastHistoryOther) {
		this.pastHistoryOther = pastHistoryOther;
	}

	public String getFamilyHistoryOther() {
		return this.familyHistoryOther;
	}

	public void setFamilyHistoryOther(String familyHistoryOther) {
		this.familyHistoryOther = familyHistoryOther;
	}

	public String getOpshistory() {
		return this.opshistory;
	}

	public void setOpshistory(String opshistory) {
		this.opshistory = opshistory;
	}

	public String getOpshistoryOther() {
		return this.opshistoryOther;
	}

	public void setOpshistoryOther(String opshistoryOther) {
		this.opshistoryOther = opshistoryOther;
	}

	public Integer getPregnant1() {
		return this.pregnant1;
	}

	public void setPregnant1(Integer pregnant1) {
		this.pregnant1 = pregnant1;
	}

	public Integer getPregnant2() {
		return this.pregnant2;
	}

	public void setPregnant2(Integer pregnant2) {
		this.pregnant2 = pregnant2;
	}

	public Integer getPregnant3() {
		return this.pregnant3;
	}

	public void setPregnant3(Integer pregnant3) {
		this.pregnant3 = pregnant3;
	}

	public Integer getPregnant4() {
		return this.pregnant4;
	}

	public void setPregnant4(Integer pregnant4) {
		this.pregnant4 = pregnant4;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHabitus() {
		return this.habitus;
	}

	public void setHabitus(Double habitus) {
		this.habitus = habitus;
	}

	public String getExam01() {
		return this.exam01;
	}

	public void setExam01(String exam01) {
		this.exam01 = exam01;
	}

	public String getExam01other() {
		return this.exam01other;
	}

	public void setExam01other(String exam01other) {
		this.exam01other = exam01other;
	}

	public String getExam02() {
		return this.exam02;
	}

	public void setExam02(String exam02) {
		this.exam02 = exam02;
	}

	public String getExam02other() {
		return this.exam02other;
	}

	public void setExam02other(String exam02other) {
		this.exam02other = exam02other;
	}

	public String getExam03() {
		return this.exam03;
	}

	public void setExam03(String exam03) {
		this.exam03 = exam03;
	}

	public String getExam03other() {
		return this.exam03other;
	}

	public void setExam03other(String exam03other) {
		this.exam03other = exam03other;
	}

	public String getExam04() {
		return this.exam04;
	}

	public void setExam04(String exam04) {
		this.exam04 = exam04;
	}

	public String getExam04other() {
		return this.exam04other;
	}

	public void setExam04other(String exam04other) {
		this.exam04other = exam04other;
	}

	public String getExam05() {
		return this.exam05;
	}

	public void setExam05(String exam05) {
		this.exam05 = exam05;
	}

	public String getExam05other() {
		return this.exam05other;
	}

	public void setExam05other(String exam05other) {
		this.exam05other = exam05other;
	}

	public String getExam06() {
		return this.exam06;
	}

	public void setExam06(String exam06) {
		this.exam06 = exam06;
	}

	public String getExam06other() {
		return this.exam06other;
	}

	public void setExam06other(String exam06other) {
		this.exam06other = exam06other;
	}

	public String getExam07() {
		return this.exam07;
	}

	public void setExam07(String exam07) {
		this.exam07 = exam07;
	}

	public String getExam07other() {
		return this.exam07other;
	}

	public void setExam07other(String exam07other) {
		this.exam07other = exam07other;
	}

	public String getExam08() {
		return this.exam08;
	}

	public void setExam08(String exam08) {
		this.exam08 = exam08;
	}

	public Double getExam09() {
		return this.exam09;
	}

	public void setExam09(Double exam09) {
		this.exam09 = exam09;
	}

	public Double getExam10() {
		return this.exam10;
	}

	public void setExam10(Double exam10) {
		this.exam10 = exam10;
	}

	public String getExam11() {
		return this.exam11;
	}

	public void setExam11(String exam11) {
		this.exam11 = exam11;
	}

	public String getExam12() {
		return this.exam12;
	}

	public void setExam12(String exam12) {
		this.exam12 = exam12;
	}

	public String getExam13() {
		return this.exam13;
	}

	public void setExam13(String exam13) {
		this.exam13 = exam13;
	}

	public String getExam14() {
		return this.exam14;
	}

	public void setExam14(String exam14) {
		this.exam14 = exam14;
	}

	public String getExam15() {
		return this.exam15;
	}

	public void setExam15(String exam15) {
		this.exam15 = exam15;
	}

	public String getExam16() {
		return this.exam16;
	}

	public void setExam16(String exam16) {
		this.exam16 = exam16;
	}

	public Double getExam17() {
		return this.exam17;
	}

	public void setExam17(Double exam17) {
		this.exam17 = exam17;
	}

	public Double getExam18() {
		return this.exam18;
	}

	public void setExam18(Double exam18) {
		this.exam18 = exam18;
	}

	public Double getExam19() {
		return this.exam19;
	}

	public void setExam19(Double exam19) {
		this.exam19 = exam19;
	}

	public Double getExam20() {
		return this.exam20;
	}

	public void setExam20(Double exam20) {
		this.exam20 = exam20;
	}

	public Double getExam21() {
		return this.exam21;
	}

	public void setExam21(Double exam21) {
		this.exam21 = exam21;
	}

	public Double getExam22() {
		return this.exam22;
	}

	public void setExam22(Double exam22) {
		this.exam22 = exam22;
	}

	public Double getExam23() {
		return this.exam23;
	}

	public void setExam23(Double exam23) {
		this.exam23 = exam23;
	}

	public Double getExam24() {
		return this.exam24;
	}

	public void setExam24(Double exam24) {
		this.exam24 = exam24;
	}

	public Double getExam25() {
		return this.exam25;
	}

	public void setExam25(Double exam25) {
		this.exam25 = exam25;
	}

	public String getExam26() {
		return this.exam26;
	}

	public void setExam26(String exam26) {
		this.exam26 = exam26;
	}

	public String getExam26other() {
		return this.exam26other;
	}

	public void setExam26other(String exam26other) {
		this.exam26other = exam26other;
	}

	public String getExam27() {
		return this.exam27;
	}

	public void setExam27(String exam27) {
		this.exam27 = exam27;
	}

	public String getExam28() {
		return this.exam28;
	}

	public void setExam28(String exam28) {
		this.exam28 = exam28;
	}

	public String getBeforeBornDirectOther() {
		return this.beforeBornDirectOther;
	}

	public void setBeforeBornDirectOther(String beforeBornDirectOther) {
		this.beforeBornDirectOther = beforeBornDirectOther;
	}

	public Integer getBornAge() {
		return this.bornAge;
	}

	public void setBornAge(Integer bornAge) {
		this.bornAge = bornAge;
	}

	public Integer getParity1() {
		return this.parity1;
	}

	public void setParity1(Integer parity1) {
		this.parity1 = parity1;
	}

	public String getPersonalHistoryOther() {
		return this.personalHistoryOther;
	}

	public void setPersonalHistoryOther(String personalHistoryOther) {
		this.personalHistoryOther = personalHistoryOther;
	}

	public Integer getPregnant5() {
		return this.pregnant5;
	}

	public void setPregnant5(Integer pregnant5) {
		this.pregnant5 = pregnant5;
	}

	public String getBloodTypeAbo() {
		return this.bloodTypeAbo;
	}

	public void setBloodTypeAbo(String bloodTypeAbo) {
		this.bloodTypeAbo = bloodTypeAbo;
	}

	public String getBloodTypeRh() {
		return this.bloodTypeRh;
	}

	public void setBloodTypeRh(String bloodTypeRh) {
		this.bloodTypeRh = bloodTypeRh;
	}

	public Double getBloodSugar() {
		return this.bloodSugar;
	}

	public void setBloodSugar(Double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public String getFemeClean() {
		return this.femeClean;
	}

	public void setFemeClean(String femeClean) {
		this.femeClean = femeClean;
	}

	public String getHepatitis01() {
		return this.hepatitis01;
	}

	public void setHepatitis01(String hepatitis01) {
		this.hepatitis01 = hepatitis01;
	}

	public String getHepatitis02() {
		return this.hepatitis02;
	}

	public void setHepatitis02(String hepatitis02) {
		this.hepatitis02 = hepatitis02;
	}

	public String getHepatitis03() {
		return this.hepatitis03;
	}

	public void setHepatitis03(String hepatitis03) {
		this.hepatitis03 = hepatitis03;
	}

	public String getHepatitis04() {
		return this.hepatitis04;
	}

	public void setHepatitis04(String hepatitis04) {
		this.hepatitis04 = hepatitis04;
	}

	public String getHepatitis05() {
		return this.hepatitis05;
	}

	public void setHepatitis05(String hepatitis05) {
		this.hepatitis05 = hepatitis05;
	}

	public String getExam29() {
		return this.exam29;
	}

	public void setExam29(String exam29) {
		this.exam29 = exam29;
	}

	public String getBeforeBornCheckDirectOther() {
		return this.beforeBornCheckDirectOther;
	}

	public void setBeforeBornCheckDirectOther(String beforeBornCheckDirectOther) {
		this.beforeBornCheckDirectOther = beforeBornCheckDirectOther;
	}

	public String getHighRisk() {
		return highRisk;
	}

	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}

	public String getHighRiskRemark() {
		return highRiskRemark;
	}

	public void setHighRiskRemark(String highRiskRemark) {
		this.highRiskRemark = highRiskRemark;
	}

	public String getExecDistrictNum() {
		return execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

	public String getHighRiskSearch() {
		return highRiskSearch;
	}

	public void setHighRiskSearch(String highRiskSearch) {
		this.highRiskSearch = highRiskSearch;
	}
	
	
}