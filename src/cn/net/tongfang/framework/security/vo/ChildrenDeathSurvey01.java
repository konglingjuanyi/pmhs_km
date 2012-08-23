package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * ChildrenDeathSurvey01 entity. @author MyEclipse Persistence Tools
 */

public class ChildrenDeathSurvey01 implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String dbabyName;
	private String dbabyHospital;
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
	private Timestamp pstartDate;
	private String phospAndDepart;
	private String pdiagnoses;
	private String pdealRemarks;
	private String tisNeedTrans;
	private String tfirstRemainTime;
	private String tfirstRouteRemainTime;
	private String tsecondRemainTime;
	private String tsecondRouteRemainTime;
	private String tsecondTranReason;
	private String tdoctorDeal;
	private String tdoctorDealDetails;
	private String ddiagnose;
	private String ddiagnoseProc;
	private String bddiagnose;
	private String bdreason;
	private String bddissect;
	private String bddiscuss;
	private String tunit;
	private String toptPerson;
	private Timestamp tdate;
	private String inputPersonId;
	private Timestamp inputDate;
	private String execDistrictNum;

	// Constructors

	/** default constructor */
	public ChildrenDeathSurvey01() {
	}

	/** minimal constructor */
	public ChildrenDeathSurvey01(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public ChildrenDeathSurvey01(String fileNo, String dbabyName,
			String dbabyHospital, Integer fmotherAge, String fmotherFolk,
			String fmotherFolkOther, String fmotherEducation,
			String fmotherOccupation, String fmotherLocalResidence,
			Double favgIncome, String faddress, String faddressOther,
			String mbeforeExam, Integer mbeforeExamTime,
			String munBeforeExamReason, String mcomplication,
			String mcomplicationRemarks, Integer mchildFetal,
			Integer mchildYeild, Integer mchildWeekly, String mbirthWay,
			String mbirthAddress, String mbirthAddressReason,
			String mchildDoctor, String mchokeHistory, String misHealth,
			String munHealthRemarks, Timestamp pstartDate,
			String phospAndDepart, String pdiagnoses, String pdealRemarks,
			String tisNeedTrans, String tfirstRemainTime,
			String tfirstRouteRemainTime, String tsecondRemainTime,
			String tsecondRouteRemainTime, String tsecondTranReason,
			String tdoctorDeal, String tdoctorDealDetails, String ddiagnose,
			String ddiagnoseProc, String bddiagnose, String bdreason,
			String bddissect, String bddiscuss, String tunit,
			String toptPerson, Timestamp tdate, String inputPersonId,
			Timestamp inputDate, String execDistrictNum,String mexception) {
		this.fileNo = fileNo;
		this.dbabyName = dbabyName;
		this.dbabyHospital = dbabyHospital;
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
		this.misHealth = misHealth;
		this.munHealthRemarks = munHealthRemarks;
		this.pstartDate = pstartDate;
		this.phospAndDepart = phospAndDepart;
		this.pdiagnoses = pdiagnoses;
		this.pdealRemarks = pdealRemarks;
		this.tisNeedTrans = tisNeedTrans;
		this.tfirstRemainTime = tfirstRemainTime;
		this.tfirstRouteRemainTime = tfirstRouteRemainTime;
		this.tsecondRemainTime = tsecondRemainTime;
		this.tsecondRouteRemainTime = tsecondRouteRemainTime;
		this.tsecondTranReason = tsecondTranReason;
		this.tdoctorDeal = tdoctorDeal;
		this.tdoctorDealDetails = tdoctorDealDetails;
		this.ddiagnose = ddiagnose;
		this.ddiagnoseProc = ddiagnoseProc;
		this.bddiagnose = bddiagnose;
		this.bdreason = bdreason;
		this.bddissect = bddissect;
		this.bddiscuss = bddiscuss;
		this.tunit = tunit;
		this.toptPerson = toptPerson;
		this.tdate = tdate;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.execDistrictNum = execDistrictNum;
		this.mexception = mexception;
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

	public String getDbabyHospital() {
		return this.dbabyHospital;
	}

	public void setDbabyHospital(String dbabyHospital) {
		this.dbabyHospital = dbabyHospital;
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

	public Timestamp getPstartDate() {
		return this.pstartDate;
	}

	public void setPstartDate(Timestamp pstartDate) {
		this.pstartDate = pstartDate;
	}

	public String getPhospAndDepart() {
		return this.phospAndDepart;
	}

	public void setPhospAndDepart(String phospAndDepart) {
		this.phospAndDepart = phospAndDepart;
	}

	public String getPdiagnoses() {
		return this.pdiagnoses;
	}

	public void setPdiagnoses(String pdiagnoses) {
		this.pdiagnoses = pdiagnoses;
	}

	public String getPdealRemarks() {
		return this.pdealRemarks;
	}

	public void setPdealRemarks(String pdealRemarks) {
		this.pdealRemarks = pdealRemarks;
	}

	public String getTisNeedTrans() {
		return this.tisNeedTrans;
	}

	public void setTisNeedTrans(String tisNeedTrans) {
		this.tisNeedTrans = tisNeedTrans;
	}

	public String getTfirstRemainTime() {
		return this.tfirstRemainTime;
	}

	public void setTfirstRemainTime(String tfirstRemainTime) {
		this.tfirstRemainTime = tfirstRemainTime;
	}

	public String getTfirstRouteRemainTime() {
		return this.tfirstRouteRemainTime;
	}

	public void setTfirstRouteRemainTime(String tfirstRouteRemainTime) {
		this.tfirstRouteRemainTime = tfirstRouteRemainTime;
	}

	public String getTsecondRemainTime() {
		return this.tsecondRemainTime;
	}

	public void setTsecondRemainTime(String tsecondRemainTime) {
		this.tsecondRemainTime = tsecondRemainTime;
	}

	public String getTsecondRouteRemainTime() {
		return this.tsecondRouteRemainTime;
	}

	public void setTsecondRouteRemainTime(String tsecondRouteRemainTime) {
		this.tsecondRouteRemainTime = tsecondRouteRemainTime;
	}

	public String getTsecondTranReason() {
		return this.tsecondTranReason;
	}

	public void setTsecondTranReason(String tsecondTranReason) {
		this.tsecondTranReason = tsecondTranReason;
	}

	public String getTdoctorDeal() {
		return this.tdoctorDeal;
	}

	public void setTdoctorDeal(String tdoctorDeal) {
		this.tdoctorDeal = tdoctorDeal;
	}

	public String getTdoctorDealDetails() {
		return this.tdoctorDealDetails;
	}

	public void setTdoctorDealDetails(String tdoctorDealDetails) {
		this.tdoctorDealDetails = tdoctorDealDetails;
	}

	public String getDdiagnose() {
		return this.ddiagnose;
	}

	public void setDdiagnose(String ddiagnose) {
		this.ddiagnose = ddiagnose;
	}

	public String getDdiagnoseProc() {
		return this.ddiagnoseProc;
	}

	public void setDdiagnoseProc(String ddiagnoseProc) {
		this.ddiagnoseProc = ddiagnoseProc;
	}

	public String getBddiagnose() {
		return this.bddiagnose;
	}

	public void setBddiagnose(String bddiagnose) {
		this.bddiagnose = bddiagnose;
	}

	public String getBdreason() {
		return this.bdreason;
	}

	public void setBdreason(String bdreason) {
		this.bdreason = bdreason;
	}

	public String getBddissect() {
		return this.bddissect;
	}

	public void setBddissect(String bddissect) {
		this.bddissect = bddissect;
	}

	public String getBddiscuss() {
		return this.bddiscuss;
	}

	public void setBddiscuss(String bddiscuss) {
		this.bddiscuss = bddiscuss;
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

	public String getMexception() {
		return mexception;
	}

	public void setMexception(String mexception) {
		this.mexception = mexception;
	}

}