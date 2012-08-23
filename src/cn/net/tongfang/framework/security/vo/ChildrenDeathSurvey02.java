package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * ChildrenDeathSurvey02 entity. @author MyEclipse Persistence Tools
 */

public class ChildrenDeathSurvey02 implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String dbabyName;
	private Integer fmotherAge;
	private String fmotherFolk;
	private String fmotherFolkOther;
	private String fmotherEducation;
	private String fmotherOccupation;
	private String fmotherLocalResidence;
	private Double favgIncome;
	private String faddress;
	private String faddressOther;
	private String mbeforeExam;
	private Integer mbeforeExamTime;
	private String munBeforeExamReason;
	private String mcomplication;
	private String mcomplicationRemarks;
	private Integer mchildFetal;
	private Integer mchildYeild;
	private Integer mchildWeekly;
	private String mbirthWay;
	private String mbirthAddress;
	private String mbirthAddressReason;
	private String mchildDoctor;
	private String mchokeHistory;
	private String mexception;
	private String misHealth;
	private String munHealthRemarks;
	private String dbuexception;
	private Integer dbucontinuedDay;
	private String dbustep;
	private String dbureason;
	private String dbureasonCustom;
	private String dbureasonOther;
	private String dbufhelp;
	private String dbufhelpOther;
	private String dbuhelp;
	private String dbuhelpOther;
	private String dbfirstSelectHosp;
	private Integer dbcontinuedTime;
	private String dbdiagnoseHosp;
	private String dbdiagnose;
	private Integer dbcureDay;
	private String dbcommunityReason;
	private String dbcommunityReasonOther;
	private String dbquitCureReason;
	private String dbquitCureReasonOther;
	private Integer tdcontinueDay;
	private String tdisNeedTrans;
	private String tdfirstRemainTime;
	private String tdfirstRouteRemainTime;
	private String tdsecondRemainTime;
	private String tdsecondRouteRemainTime;
	private String tdsecondTranReason;
	private String tdfhelp;
	private String tdfhelpOther;
	private String tdhelp;
	private String tdhelpOther;
	private Timestamp bdtime;
	private Integer dbage;
	private String bdaddress;
	private String bdaddressOther;
	private String bddiagnose;
	private String bdbaseByDiagnose;
	private String tunit;
	private String toptPerson;
	private Timestamp tdate;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public ChildrenDeathSurvey02() {
	}

	/** minimal constructor */
	public ChildrenDeathSurvey02(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public ChildrenDeathSurvey02(String fileNo, String dbabyName,
			Integer fmotherAge, String fmotherFolk, String fmotherFolkOther,
			String fmotherEducation, String fmotherOccupation,
			String fmotherLocalResidence, Double favgIncome, String faddress,
			String faddressOther, String mbeforeExam, Integer mbeforeExamTime,
			String munBeforeExamReason, String mcomplication,
			String mcomplicationRemarks, Integer mchildFetal,
			Integer mchildYeild, Integer mchildWeekly, String mbirthWay,
			String mbirthAddress, String mbirthAddressReason,
			String mchildDoctor, String mchokeHistory, String mexception,
			String misHealth, String munHealthRemarks, String dbuexception,
			Integer dbucontinuedDay, String dbustep, String dbureason,
			String dbureasonCustom, String dbureasonOther, String dbufhelp,
			String dbufhelpOther, String dbuhelp, String dbuhelpOther,
			String dbfirstSelectHosp, Integer dbcontinuedTime,
			String dbdiagnoseHosp, String dbdiagnose, Integer dbcureDay,
			String dbcommunityReason, String dbcommunityReasonOther,
			String dbquitCureReason, String dbquitCureReasonOther,
			Integer tdcontinueDay, String tdisNeedTrans,
			String tdfirstRemainTime, String tdfirstRouteRemainTime,
			String tdsecondRemainTime, String tdsecondRouteRemainTime,
			String tdsecondTranReason, String tdfhelp, String tdfhelpOther,
			String tdhelp, String tdhelpOther, Timestamp bdtime, Integer dbage,
			String bdaddress, String bdaddressOther, String bddiagnose,
			String bdbaseByDiagnose, String tunit, String toptPerson,
			Timestamp tdate, String inputPersonId, Timestamp inputDate,
			String execDistrictNum) {
		this.fileNo = fileNo;
		this.dbabyName = dbabyName;
		this.fmotherAge = fmotherAge;
		this.fmotherFolk = fmotherFolk;
		this.fmotherFolkOther = fmotherFolkOther;
		this.fmotherEducation = fmotherEducation;
		this.fmotherOccupation = fmotherOccupation;
		this.fmotherLocalResidence = fmotherLocalResidence;
		this.favgIncome = favgIncome;
		this.faddress = faddress;
		this.faddressOther = faddressOther;
		this.mbeforeExam = mbeforeExam;
		this.mbeforeExamTime = mbeforeExamTime;
		this.munBeforeExamReason = munBeforeExamReason;
		this.mcomplication = mcomplication;
		this.mcomplicationRemarks = mcomplicationRemarks;
		this.mchildFetal = mchildFetal;
		this.mchildYeild = mchildYeild;
		this.mchildWeekly = mchildWeekly;
		this.mbirthWay = mbirthWay;
		this.mbirthAddress = mbirthAddress;
		this.mbirthAddressReason = mbirthAddressReason;
		this.mchildDoctor = mchildDoctor;
		this.mchokeHistory = mchokeHistory;
		this.mexception = mexception;
		this.misHealth = misHealth;
		this.munHealthRemarks = munHealthRemarks;
		this.dbuexception = dbuexception;
		this.dbucontinuedDay = dbucontinuedDay;
		this.dbustep = dbustep;
		this.dbureason = dbureason;
		this.dbureasonCustom = dbureasonCustom;
		this.dbureasonOther = dbureasonOther;
		this.dbufhelp = dbufhelp;
		this.dbufhelpOther = dbufhelpOther;
		this.dbuhelp = dbuhelp;
		this.dbuhelpOther = dbuhelpOther;
		this.dbfirstSelectHosp = dbfirstSelectHosp;
		this.dbcontinuedTime = dbcontinuedTime;
		this.dbdiagnoseHosp = dbdiagnoseHosp;
		this.dbdiagnose = dbdiagnose;
		this.dbcureDay = dbcureDay;
		this.dbcommunityReason = dbcommunityReason;
		this.dbcommunityReasonOther = dbcommunityReasonOther;
		this.dbquitCureReason = dbquitCureReason;
		this.dbquitCureReasonOther = dbquitCureReasonOther;
		this.tdcontinueDay = tdcontinueDay;
		this.tdisNeedTrans = tdisNeedTrans;
		this.tdfirstRemainTime = tdfirstRemainTime;
		this.tdfirstRouteRemainTime = tdfirstRouteRemainTime;
		this.tdsecondRemainTime = tdsecondRemainTime;
		this.tdsecondRouteRemainTime = tdsecondRouteRemainTime;
		this.tdsecondTranReason = tdsecondTranReason;
		this.tdfhelp = tdfhelp;
		this.tdfhelpOther = tdfhelpOther;
		this.tdhelp = tdhelp;
		this.tdhelpOther = tdhelpOther;
		this.bdtime = bdtime;
		this.dbage = dbage;
		this.bdaddress = bdaddress;
		this.bdaddressOther = bdaddressOther;
		this.bddiagnose = bddiagnose;
		this.bdbaseByDiagnose = bdbaseByDiagnose;
		this.tunit = tunit;
		this.toptPerson = toptPerson;
		this.tdate = tdate;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.execDistrictNum = execDistrictNum;
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

	public String getDbabyName() {
		return this.dbabyName;
	}

	public void setDbabyName(String dbabyName) {
		this.dbabyName = dbabyName;
	}

	public Integer getFmotherAge() {
		return this.fmotherAge;
	}

	public void setFmotherAge(Integer fmotherAge) {
		this.fmotherAge = fmotherAge;
	}

	public String getFmotherFolk() {
		return this.fmotherFolk;
	}

	public void setFmotherFolk(String fmotherFolk) {
		this.fmotherFolk = fmotherFolk;
	}

	public String getFmotherFolkOther() {
		return this.fmotherFolkOther;
	}

	public void setFmotherFolkOther(String fmotherFolkOther) {
		this.fmotherFolkOther = fmotherFolkOther;
	}

	public String getFmotherEducation() {
		return this.fmotherEducation;
	}

	public void setFmotherEducation(String fmotherEducation) {
		this.fmotherEducation = fmotherEducation;
	}

	public String getFmotherOccupation() {
		return this.fmotherOccupation;
	}

	public void setFmotherOccupation(String fmotherOccupation) {
		this.fmotherOccupation = fmotherOccupation;
	}

	public String getFmotherLocalResidence() {
		return this.fmotherLocalResidence;
	}

	public void setFmotherLocalResidence(String fmotherLocalResidence) {
		this.fmotherLocalResidence = fmotherLocalResidence;
	}

	public Double getFavgIncome() {
		return this.favgIncome;
	}

	public void setFavgIncome(Double favgIncome) {
		this.favgIncome = favgIncome;
	}

	public String getFaddress() {
		return this.faddress;
	}

	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}

	public String getFaddressOther() {
		return this.faddressOther;
	}

	public void setFaddressOther(String faddressOther) {
		this.faddressOther = faddressOther;
	}

	public String getMbeforeExam() {
		return this.mbeforeExam;
	}

	public void setMbeforeExam(String mbeforeExam) {
		this.mbeforeExam = mbeforeExam;
	}

	public Integer getMbeforeExamTime() {
		return this.mbeforeExamTime;
	}

	public void setMbeforeExamTime(Integer mbeforeExamTime) {
		this.mbeforeExamTime = mbeforeExamTime;
	}

	public String getMunBeforeExamReason() {
		return this.munBeforeExamReason;
	}

	public void setMunBeforeExamReason(String munBeforeExamReason) {
		this.munBeforeExamReason = munBeforeExamReason;
	}

	public String getMcomplication() {
		return this.mcomplication;
	}

	public void setMcomplication(String mcomplication) {
		this.mcomplication = mcomplication;
	}

	public String getMcomplicationRemarks() {
		return this.mcomplicationRemarks;
	}

	public void setMcomplicationRemarks(String mcomplicationRemarks) {
		this.mcomplicationRemarks = mcomplicationRemarks;
	}

	public Integer getMchildFetal() {
		return this.mchildFetal;
	}

	public void setMchildFetal(Integer mchildFetal) {
		this.mchildFetal = mchildFetal;
	}

	public Integer getMchildYeild() {
		return this.mchildYeild;
	}

	public void setMchildYeild(Integer mchildYeild) {
		this.mchildYeild = mchildYeild;
	}

	public Integer getMchildWeekly() {
		return this.mchildWeekly;
	}

	public void setMchildWeekly(Integer mchildWeekly) {
		this.mchildWeekly = mchildWeekly;
	}

	public String getMbirthWay() {
		return this.mbirthWay;
	}

	public void setMbirthWay(String mbirthWay) {
		this.mbirthWay = mbirthWay;
	}

	public String getMbirthAddress() {
		return this.mbirthAddress;
	}

	public void setMbirthAddress(String mbirthAddress) {
		this.mbirthAddress = mbirthAddress;
	}

	public String getMbirthAddressReason() {
		return this.mbirthAddressReason;
	}

	public void setMbirthAddressReason(String mbirthAddressReason) {
		this.mbirthAddressReason = mbirthAddressReason;
	}

	public String getMchildDoctor() {
		return this.mchildDoctor;
	}

	public void setMchildDoctor(String mchildDoctor) {
		this.mchildDoctor = mchildDoctor;
	}

	public String getMchokeHistory() {
		return this.mchokeHistory;
	}

	public void setMchokeHistory(String mchokeHistory) {
		this.mchokeHistory = mchokeHistory;
	}

	public String getMexception() {
		return this.mexception;
	}

	public void setMexception(String mexception) {
		this.mexception = mexception;
	}

	public String getMisHealth() {
		return this.misHealth;
	}

	public void setMisHealth(String misHealth) {
		this.misHealth = misHealth;
	}

	public String getMunHealthRemarks() {
		return this.munHealthRemarks;
	}

	public void setMunHealthRemarks(String munHealthRemarks) {
		this.munHealthRemarks = munHealthRemarks;
	}

	public String getDbuexception() {
		return this.dbuexception;
	}

	public void setDbuexception(String dbuexception) {
		this.dbuexception = dbuexception;
	}

	public Integer getDbucontinuedDay() {
		return this.dbucontinuedDay;
	}

	public void setDbucontinuedDay(Integer dbucontinuedDay) {
		this.dbucontinuedDay = dbucontinuedDay;
	}

	public String getDbustep() {
		return this.dbustep;
	}

	public void setDbustep(String dbustep) {
		this.dbustep = dbustep;
	}

	public String getDbureason() {
		return this.dbureason;
	}

	public void setDbureason(String dbureason) {
		this.dbureason = dbureason;
	}

	public String getDbureasonCustom() {
		return this.dbureasonCustom;
	}

	public void setDbureasonCustom(String dbureasonCustom) {
		this.dbureasonCustom = dbureasonCustom;
	}

	public String getDbureasonOther() {
		return this.dbureasonOther;
	}

	public void setDbureasonOther(String dbureasonOther) {
		this.dbureasonOther = dbureasonOther;
	}

	public String getDbufhelp() {
		return this.dbufhelp;
	}

	public void setDbufhelp(String dbufhelp) {
		this.dbufhelp = dbufhelp;
	}

	public String getDbufhelpOther() {
		return this.dbufhelpOther;
	}

	public void setDbufhelpOther(String dbufhelpOther) {
		this.dbufhelpOther = dbufhelpOther;
	}

	public String getDbuhelp() {
		return this.dbuhelp;
	}

	public void setDbuhelp(String dbuhelp) {
		this.dbuhelp = dbuhelp;
	}

	public String getDbuhelpOther() {
		return this.dbuhelpOther;
	}

	public void setDbuhelpOther(String dbuhelpOther) {
		this.dbuhelpOther = dbuhelpOther;
	}

	public String getDbfirstSelectHosp() {
		return this.dbfirstSelectHosp;
	}

	public void setDbfirstSelectHosp(String dbfirstSelectHosp) {
		this.dbfirstSelectHosp = dbfirstSelectHosp;
	}

	public Integer getDbcontinuedTime() {
		return this.dbcontinuedTime;
	}

	public void setDbcontinuedTime(Integer dbcontinuedTime) {
		this.dbcontinuedTime = dbcontinuedTime;
	}

	public String getDbdiagnoseHosp() {
		return this.dbdiagnoseHosp;
	}

	public void setDbdiagnoseHosp(String dbdiagnoseHosp) {
		this.dbdiagnoseHosp = dbdiagnoseHosp;
	}

	public String getDbdiagnose() {
		return this.dbdiagnose;
	}

	public void setDbdiagnose(String dbdiagnose) {
		this.dbdiagnose = dbdiagnose;
	}

	public Integer getDbcureDay() {
		return this.dbcureDay;
	}

	public void setDbcureDay(Integer dbcureDay) {
		this.dbcureDay = dbcureDay;
	}

	public String getDbcommunityReason() {
		return this.dbcommunityReason;
	}

	public void setDbcommunityReason(String dbcommunityReason) {
		this.dbcommunityReason = dbcommunityReason;
	}

	public String getDbcommunityReasonOther() {
		return this.dbcommunityReasonOther;
	}

	public void setDbcommunityReasonOther(String dbcommunityReasonOther) {
		this.dbcommunityReasonOther = dbcommunityReasonOther;
	}

	public String getDbquitCureReason() {
		return this.dbquitCureReason;
	}

	public void setDbquitCureReason(String dbquitCureReason) {
		this.dbquitCureReason = dbquitCureReason;
	}

	public String getDbquitCureReasonOther() {
		return this.dbquitCureReasonOther;
	}

	public void setDbquitCureReasonOther(String dbquitCureReasonOther) {
		this.dbquitCureReasonOther = dbquitCureReasonOther;
	}

	public Integer getTdcontinueDay() {
		return this.tdcontinueDay;
	}

	public void setTdcontinueDay(Integer tdcontinueDay) {
		this.tdcontinueDay = tdcontinueDay;
	}

	public String getTdisNeedTrans() {
		return this.tdisNeedTrans;
	}

	public void setTdisNeedTrans(String tdisNeedTrans) {
		this.tdisNeedTrans = tdisNeedTrans;
	}

	public String getTdfirstRemainTime() {
		return this.tdfirstRemainTime;
	}

	public void setTdfirstRemainTime(String tdfirstRemainTime) {
		this.tdfirstRemainTime = tdfirstRemainTime;
	}

	public String getTdfirstRouteRemainTime() {
		return this.tdfirstRouteRemainTime;
	}

	public void setTdfirstRouteRemainTime(String tdfirstRouteRemainTime) {
		this.tdfirstRouteRemainTime = tdfirstRouteRemainTime;
	}

	public String getTdsecondRemainTime() {
		return this.tdsecondRemainTime;
	}

	public void setTdsecondRemainTime(String tdsecondRemainTime) {
		this.tdsecondRemainTime = tdsecondRemainTime;
	}

	public String getTdsecondRouteRemainTime() {
		return this.tdsecondRouteRemainTime;
	}

	public void setTdsecondRouteRemainTime(String tdsecondRouteRemainTime) {
		this.tdsecondRouteRemainTime = tdsecondRouteRemainTime;
	}

	public String getTdsecondTranReason() {
		return this.tdsecondTranReason;
	}

	public void setTdsecondTranReason(String tdsecondTranReason) {
		this.tdsecondTranReason = tdsecondTranReason;
	}

	public String getTdfhelp() {
		return this.tdfhelp;
	}

	public void setTdfhelp(String tdfhelp) {
		this.tdfhelp = tdfhelp;
	}

	public String getTdfhelpOther() {
		return this.tdfhelpOther;
	}

	public void setTdfhelpOther(String tdfhelpOther) {
		this.tdfhelpOther = tdfhelpOther;
	}

	public String getTdhelp() {
		return this.tdhelp;
	}

	public void setTdhelp(String tdhelp) {
		this.tdhelp = tdhelp;
	}

	public String getTdhelpOther() {
		return this.tdhelpOther;
	}

	public void setTdhelpOther(String tdhelpOther) {
		this.tdhelpOther = tdhelpOther;
	}

	public Timestamp getBdtime() {
		return this.bdtime;
	}

	public void setBdtime(Timestamp bdtime) {
		this.bdtime = bdtime;
	}

	public Integer getDbage() {
		return this.dbage;
	}

	public void setDbage(Integer dbage) {
		this.dbage = dbage;
	}

	public String getBdaddress() {
		return this.bdaddress;
	}

	public void setBdaddress(String bdaddress) {
		this.bdaddress = bdaddress;
	}

	public String getBdaddressOther() {
		return this.bdaddressOther;
	}

	public void setBdaddressOther(String bdaddressOther) {
		this.bdaddressOther = bdaddressOther;
	}

	public String getBddiagnose() {
		return this.bddiagnose;
	}

	public void setBddiagnose(String bddiagnose) {
		this.bddiagnose = bddiagnose;
	}

	public String getBdbaseByDiagnose() {
		return this.bdbaseByDiagnose;
	}

	public void setBdbaseByDiagnose(String bdbaseByDiagnose) {
		this.bdbaseByDiagnose = bdbaseByDiagnose;
	}

	public String getTunit() {
		return this.tunit;
	}

	public void setTunit(String tunit) {
		this.tunit = tunit;
	}

	public String getToptPerson() {
		return this.toptPerson;
	}

	public void setToptPerson(String toptPerson) {
		this.toptPerson = toptPerson;
	}

	public Timestamp getTdate() {
		return this.tdate;
	}

	public void setTdate(Timestamp tdate) {
		this.tdate = tdate;
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

	public String getExecDistrictNum() {
		return this.execDistrictNum;
	}

	public void setExecDistrictNum(String execDistrictNum) {
		this.execDistrictNum = execDistrictNum;
	}

}