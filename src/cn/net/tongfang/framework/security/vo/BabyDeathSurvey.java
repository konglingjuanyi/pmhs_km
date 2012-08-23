package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BabyDeathSurvey entity. @author MyEclipse Persistence Tools
 */

public class BabyDeathSurvey implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private String dbabyName;
	private String dbabyHospital;
	private String ddataOrigin;
	private String ddataOriginOther;
	private Integer fmotherAge;
	private String fmotherFolk;
	private String fmotherFolkOther;
	private String fmotherEducation;
	private String fmotherOccupation;
	private String fmotherLocalResidence;
	private Double favgIncome;
	private String faddress;
	private String faddressOther;
	private Integer mgestationTime;
	private Integer mbirthTime;
	private Integer mmiscarryTime;
	private Integer mdeathTime;
	private Integer mprmatureTime;
	private String mabnormal;
	private String mabnormalName;
	private String mheritable;
	private String mheritableName;
	private String mbeforeExam;
	private Integer mbeforeExamTime;
	private String munBeforeExamReason;
	private String mcomplication;
	private String mcomplicationRemarks;
	private String mbirthAddress;
	private String mbirthAddressReason;
	private String mbirthStart;
	private String mleadWay;
	private String mleadWayOther;
	private String mleadSpesia;
	private String mbirthWay;
	private String mhelpDoctor;
	private String mhelpDoctorOther;
	private String mbirthWeekly;
	private String mbirthComplication;
	private String mbirthComplicationRemarks;
	private Timestamp bbirthday;
	private String bsex;
	private String bweight;
	private Double bweightMeasure;
	private Double bweightEstimate;
	private String bfetalNum;
	private String bapgarOne;
	private Integer bapgarOneMinutes;
	private String bapgarFive;
	private Integer bapgarFiveMinutes;
	private String bsheepWater;
	private String brecovery;
	private String brecoveryDoctor;
	private Double benvironmentTemp;
	private String brecovOxygen;
	private String brecovVentilate;
	private String brecovTrachea;
	private String brecovPress;
	private String brecovGland;
	private String brecovOther;
	private String bmilk;
	private Integer bbirthMinutes;
	private Integer bbirthHours;
	private String bfeedWay;
	private String bfeedWayOther;
	private String bsavingWay;
	private String bsavingWayOther;
	private Timestamp etime;
	private String ehospiAndDepart;
	private String eisTrans;
	private String etransHospiAndDepart;
	private String edealProc;
	private String diagnose;
	private String cureProc;
	private Timestamp bdhospiTime;
	private Integer bdhospiAgeDay;
	private Integer bdhospiAgeHour;
	private Timestamp bddeathTime;
	private Integer bddeathAgeDay;
	private Integer bddeathAgeHour;
	private String bdaddress;
	private String bdaddressOther;
	private String bddiagnose;
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
	public BabyDeathSurvey() {
	}

	/** minimal constructor */
	public BabyDeathSurvey(String fileNo) {
		this.fileNo = fileNo;
	}

	/** full constructor */
	public BabyDeathSurvey(String fileNo, String dbabyName,
			String dbabyHospital, String ddataOrigin, Integer fmotherAge,
			String fmotherFolk, String fmotherFolkOther,
			String fmotherEducation, String fmotherOccupation,
			String fmotherLocalResidence, Double favgIncome, String faddress,
			Integer mgestationTime, Integer mbirthTime, Integer mmiscarryTime,
			Integer mdeathTime, Integer mprmatureTime, String mabnormal,
			String mabnormalName, String mheritable, String mheritableName,
			String mbeforeExam, Integer mbeforeExamTime,
			String munBeforeExamReason, String mcomplication,
			String mcomplicationRemarks, String mbirthAddress,
			String mbirthAddressReason, String mbirthStart, String mleadWay,
			String mleadSpesia, String mbirthWay, String mhelpDoctor,
			String mbirthWeekly, String mbirthComplication,
			String mbirthComplicationRemarks, Timestamp bbirthday, String bsex,
			String bweight, Double bweightMeasure, Double bweightEstimate,
			String bfetalNum, String bapgarOne, Integer bapgarOneMinutes,
			String bapgarFive, Integer bapgarFiveMinutes, String bsheepWater,
			String brecovery, String brecoveryDoctor, Double benvironmentTemp,
			String brecovOxygen, String brecovVentilate, String brecovTrachea,
			String brecovPress, String brecovGland, String brecovOther,
			String bmilk, Integer bbirthMinutes, Integer bbirthHours,
			String bfeedWay, String bfeedWayOther, String bsavingWay,
			String bsavingWayOther, Timestamp etime, String ehospiAndDepart,
			String eisTrans, String etransHospiAndDepart, String edealProc,
			String diagnose, String cureProc, Timestamp bdhospiTime,
			Integer bdhospiAgeDay, Integer bdhospiAgeHour,
			Timestamp bddeathTime, Integer bddeathAgeDay,
			Integer bddeathAgeHour, String bdaddress, String bddiagnose,
			String bddissect, String bddiscuss, String tunit,
			String toptPerson, Timestamp tdate, String inputPersonId,
			Timestamp inputDate, String execDistrictNum,String ddataOriginOther,
			String faddressOther,String mleadWayOther,String mhelpDoctorOther,
			String bdaddressOther) {
		this.fileNo = fileNo;
		this.dbabyName = dbabyName;
		this.dbabyHospital = dbabyHospital;
		this.ddataOrigin = ddataOrigin;
		this.fmotherAge = fmotherAge;
		this.fmotherFolk = fmotherFolk;
		this.fmotherFolkOther = fmotherFolkOther;
		this.fmotherEducation = fmotherEducation;
		this.fmotherOccupation = fmotherOccupation;
		this.fmotherLocalResidence = fmotherLocalResidence;
		this.favgIncome = favgIncome;
		this.faddress = faddress;
		this.mgestationTime = mgestationTime;
		this.mbirthTime = mbirthTime;
		this.mmiscarryTime = mmiscarryTime;
		this.mdeathTime = mdeathTime;
		this.mprmatureTime = mprmatureTime;
		this.mabnormal = mabnormal;
		this.mabnormalName = mabnormalName;
		this.mheritable = mheritable;
		this.mheritableName = mheritableName;
		this.mbeforeExam = mbeforeExam;
		this.mbeforeExamTime = mbeforeExamTime;
		this.munBeforeExamReason = munBeforeExamReason;
		this.mcomplication = mcomplication;
		this.mcomplicationRemarks = mcomplicationRemarks;
		this.mbirthAddress = mbirthAddress;
		this.mbirthAddressReason = mbirthAddressReason;
		this.mbirthStart = mbirthStart;
		this.mleadWay = mleadWay;
		this.mleadSpesia = mleadSpesia;
		this.mbirthWay = mbirthWay;
		this.mhelpDoctor = mhelpDoctor;
		this.mbirthWeekly = mbirthWeekly;
		this.mbirthComplication = mbirthComplication;
		this.mbirthComplicationRemarks = mbirthComplicationRemarks;
		this.bbirthday = bbirthday;
		this.bsex = bsex;
		this.bweight = bweight;
		this.bweightMeasure = bweightMeasure;
		this.bweightEstimate = bweightEstimate;
		this.bfetalNum = bfetalNum;
		this.bapgarOne = bapgarOne;
		this.bapgarOneMinutes = bapgarOneMinutes;
		this.bapgarFive = bapgarFive;
		this.bapgarFiveMinutes = bapgarFiveMinutes;
		this.bsheepWater = bsheepWater;
		this.brecovery = brecovery;
		this.brecoveryDoctor = brecoveryDoctor;
		this.benvironmentTemp = benvironmentTemp;
		this.brecovOxygen = brecovOxygen;
		this.brecovVentilate = brecovVentilate;
		this.brecovTrachea = brecovTrachea;
		this.brecovPress = brecovPress;
		this.brecovGland = brecovGland;
		this.brecovOther = brecovOther;
		this.bmilk = bmilk;
		this.bbirthMinutes = bbirthMinutes;
		this.bbirthHours = bbirthHours;
		this.bfeedWay = bfeedWay;
		this.bfeedWayOther = bfeedWayOther;
		this.bsavingWay = bsavingWay;
		this.bsavingWayOther = bsavingWayOther;
		this.etime = etime;
		this.ehospiAndDepart = ehospiAndDepart;
		this.eisTrans = eisTrans;
		this.etransHospiAndDepart = etransHospiAndDepart;
		this.edealProc = edealProc;
		this.diagnose = diagnose;
		this.cureProc = cureProc;
		this.bdhospiTime = bdhospiTime;
		this.bdhospiAgeDay = bdhospiAgeDay;
		this.bdhospiAgeHour = bdhospiAgeHour;
		this.bddeathTime = bddeathTime;
		this.bddeathAgeDay = bddeathAgeDay;
		this.bddeathAgeHour = bddeathAgeHour;
		this.bdaddress = bdaddress;
		this.bddiagnose = bddiagnose;
		this.bddissect = bddissect;
		this.bddiscuss = bddiscuss;
		this.tunit = tunit;
		this.toptPerson = toptPerson;
		this.tdate = tdate;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.execDistrictNum = execDistrictNum;
		this.ddataOriginOther = ddataOriginOther;
		this.faddressOther = faddressOther;
		this.mleadWayOther = mleadWayOther;
		this.mhelpDoctorOther = mhelpDoctorOther;
		this.bdaddressOther = bdaddressOther;
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

	public String getDdataOrigin() {
		return this.ddataOrigin;
	}

	public void setDdataOrigin(String ddataOrigin) {
		this.ddataOrigin = ddataOrigin;
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

	public Integer getMgestationTime() {
		return this.mgestationTime;
	}

	public void setMgestationTime(Integer mgestationTime) {
		this.mgestationTime = mgestationTime;
	}

	public Integer getMbirthTime() {
		return this.mbirthTime;
	}

	public void setMbirthTime(Integer mbirthTime) {
		this.mbirthTime = mbirthTime;
	}

	public Integer getMmiscarryTime() {
		return this.mmiscarryTime;
	}

	public void setMmiscarryTime(Integer mmiscarryTime) {
		this.mmiscarryTime = mmiscarryTime;
	}

	public Integer getMdeathTime() {
		return this.mdeathTime;
	}

	public void setMdeathTime(Integer mdeathTime) {
		this.mdeathTime = mdeathTime;
	}

	public Integer getMprmatureTime() {
		return this.mprmatureTime;
	}

	public void setMprmatureTime(Integer mprmatureTime) {
		this.mprmatureTime = mprmatureTime;
	}

	public String getMabnormal() {
		return this.mabnormal;
	}

	public void setMabnormal(String mabnormal) {
		this.mabnormal = mabnormal;
	}

	public String getMabnormalName() {
		return this.mabnormalName;
	}

	public void setMabnormalName(String mabnormalName) {
		this.mabnormalName = mabnormalName;
	}

	public String getMheritable() {
		return this.mheritable;
	}

	public void setMheritable(String mheritable) {
		this.mheritable = mheritable;
	}

	public String getMheritableName() {
		return this.mheritableName;
	}

	public void setMheritableName(String mheritableName) {
		this.mheritableName = mheritableName;
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

	public String getMbirthStart() {
		return this.mbirthStart;
	}

	public void setMbirthStart(String mbirthStart) {
		this.mbirthStart = mbirthStart;
	}

	public String getMleadWay() {
		return this.mleadWay;
	}

	public void setMleadWay(String mleadWay) {
		this.mleadWay = mleadWay;
	}

	public String getMleadSpesia() {
		return this.mleadSpesia;
	}

	public void setMleadSpesia(String mleadSpesia) {
		this.mleadSpesia = mleadSpesia;
	}

	public String getMbirthWay() {
		return this.mbirthWay;
	}

	public void setMbirthWay(String mbirthWay) {
		this.mbirthWay = mbirthWay;
	}

	public String getMhelpDoctor() {
		return this.mhelpDoctor;
	}

	public void setMhelpDoctor(String mhelpDoctor) {
		this.mhelpDoctor = mhelpDoctor;
	}

	public String getMbirthWeekly() {
		return this.mbirthWeekly;
	}

	public void setMbirthWeekly(String mbirthWeekly) {
		this.mbirthWeekly = mbirthWeekly;
	}

	public String getMbirthComplication() {
		return this.mbirthComplication;
	}

	public void setMbirthComplication(String mbirthComplication) {
		this.mbirthComplication = mbirthComplication;
	}

	public String getMbirthComplicationRemarks() {
		return this.mbirthComplicationRemarks;
	}

	public void setMbirthComplicationRemarks(String mbirthComplicationRemarks) {
		this.mbirthComplicationRemarks = mbirthComplicationRemarks;
	}

	public Timestamp getBbirthday() {
		return this.bbirthday;
	}

	public void setBbirthday(Timestamp bbirthday) {
		this.bbirthday = bbirthday;
	}

	public String getBsex() {
		return this.bsex;
	}

	public void setBsex(String bsex) {
		this.bsex = bsex;
	}

	public String getBweight() {
		return this.bweight;
	}

	public void setBweight(String bweight) {
		this.bweight = bweight;
	}

	public Double getBweightMeasure() {
		return this.bweightMeasure;
	}

	public void setBweightMeasure(Double bweightMeasure) {
		this.bweightMeasure = bweightMeasure;
	}

	public Double getBweightEstimate() {
		return this.bweightEstimate;
	}

	public void setBweightEstimate(Double bweightEstimate) {
		this.bweightEstimate = bweightEstimate;
	}

	public String getBfetalNum() {
		return this.bfetalNum;
	}

	public void setBfetalNum(String bfetalNum) {
		this.bfetalNum = bfetalNum;
	}

	public String getBapgarOne() {
		return this.bapgarOne;
	}

	public void setBapgarOne(String bapgarOne) {
		this.bapgarOne = bapgarOne;
	}

	public Integer getBapgarOneMinutes() {
		return this.bapgarOneMinutes;
	}

	public void setBapgarOneMinutes(Integer bapgarOneMinutes) {
		this.bapgarOneMinutes = bapgarOneMinutes;
	}

	public String getBapgarFive() {
		return this.bapgarFive;
	}

	public void setBapgarFive(String bapgarFive) {
		this.bapgarFive = bapgarFive;
	}

	public Integer getBapgarFiveMinutes() {
		return this.bapgarFiveMinutes;
	}

	public void setBapgarFiveMinutes(Integer bapgarFiveMinutes) {
		this.bapgarFiveMinutes = bapgarFiveMinutes;
	}

	public String getBsheepWater() {
		return this.bsheepWater;
	}

	public void setBsheepWater(String bsheepWater) {
		this.bsheepWater = bsheepWater;
	}

	public String getBrecovery() {
		return this.brecovery;
	}

	public void setBrecovery(String brecovery) {
		this.brecovery = brecovery;
	}

	public String getBrecoveryDoctor() {
		return this.brecoveryDoctor;
	}

	public void setBrecoveryDoctor(String brecoveryDoctor) {
		this.brecoveryDoctor = brecoveryDoctor;
	}

	public Double getBenvironmentTemp() {
		return this.benvironmentTemp;
	}

	public void setBenvironmentTemp(Double benvironmentTemp) {
		this.benvironmentTemp = benvironmentTemp;
	}

	public String getBrecovOxygen() {
		return this.brecovOxygen;
	}

	public void setBrecovOxygen(String brecovOxygen) {
		this.brecovOxygen = brecovOxygen;
	}

	public String getBrecovVentilate() {
		return this.brecovVentilate;
	}

	public void setBrecovVentilate(String brecovVentilate) {
		this.brecovVentilate = brecovVentilate;
	}

	public String getBrecovTrachea() {
		return this.brecovTrachea;
	}

	public void setBrecovTrachea(String brecovTrachea) {
		this.brecovTrachea = brecovTrachea;
	}

	public String getBrecovPress() {
		return this.brecovPress;
	}

	public void setBrecovPress(String brecovPress) {
		this.brecovPress = brecovPress;
	}

	public String getBrecovGland() {
		return this.brecovGland;
	}

	public void setBrecovGland(String brecovGland) {
		this.brecovGland = brecovGland;
	}

	public String getBrecovOther() {
		return this.brecovOther;
	}

	public void setBrecovOther(String brecovOther) {
		this.brecovOther = brecovOther;
	}

	public String getBmilk() {
		return this.bmilk;
	}

	public void setBmilk(String bmilk) {
		this.bmilk = bmilk;
	}

	public Integer getBbirthMinutes() {
		return this.bbirthMinutes;
	}

	public void setBbirthMinutes(Integer bbirthMinutes) {
		this.bbirthMinutes = bbirthMinutes;
	}

	public Integer getBbirthHours() {
		return this.bbirthHours;
	}

	public void setBbirthHours(Integer bbirthHours) {
		this.bbirthHours = bbirthHours;
	}

	public String getBfeedWay() {
		return this.bfeedWay;
	}

	public void setBfeedWay(String bfeedWay) {
		this.bfeedWay = bfeedWay;
	}

	public String getBfeedWayOther() {
		return this.bfeedWayOther;
	}

	public void setBfeedWayOther(String bfeedWayOther) {
		this.bfeedWayOther = bfeedWayOther;
	}

	public String getBsavingWay() {
		return this.bsavingWay;
	}

	public void setBsavingWay(String bsavingWay) {
		this.bsavingWay = bsavingWay;
	}

	public String getBsavingWayOther() {
		return this.bsavingWayOther;
	}

	public void setBsavingWayOther(String bsavingWayOther) {
		this.bsavingWayOther = bsavingWayOther;
	}

	public Timestamp getEtime() {
		return this.etime;
	}

	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}

	public String getEhospiAndDepart() {
		return this.ehospiAndDepart;
	}

	public void setEhospiAndDepart(String ehospiAndDepart) {
		this.ehospiAndDepart = ehospiAndDepart;
	}

	public String getEisTrans() {
		return this.eisTrans;
	}

	public void setEisTrans(String eisTrans) {
		this.eisTrans = eisTrans;
	}

	public String getEtransHospiAndDepart() {
		return this.etransHospiAndDepart;
	}

	public void setEtransHospiAndDepart(String etransHospiAndDepart) {
		this.etransHospiAndDepart = etransHospiAndDepart;
	}

	public String getEdealProc() {
		return this.edealProc;
	}

	public void setEdealProc(String edealProc) {
		this.edealProc = edealProc;
	}

	public String getDiagnose() {
		return this.diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getCureProc() {
		return this.cureProc;
	}

	public void setCureProc(String cureProc) {
		this.cureProc = cureProc;
	}

	public Timestamp getBdhospiTime() {
		return this.bdhospiTime;
	}

	public void setBdhospiTime(Timestamp bdhospiTime) {
		this.bdhospiTime = bdhospiTime;
	}

	public Integer getBdhospiAgeDay() {
		return this.bdhospiAgeDay;
	}

	public void setBdhospiAgeDay(Integer bdhospiAgeDay) {
		this.bdhospiAgeDay = bdhospiAgeDay;
	}

	public Integer getBdhospiAgeHour() {
		return this.bdhospiAgeHour;
	}

	public void setBdhospiAgeHour(Integer bdhospiAgeHour) {
		this.bdhospiAgeHour = bdhospiAgeHour;
	}

	public Timestamp getBddeathTime() {
		return this.bddeathTime;
	}

	public void setBddeathTime(Timestamp bddeathTime) {
		this.bddeathTime = bddeathTime;
	}

	public Integer getBddeathAgeDay() {
		return this.bddeathAgeDay;
	}

	public void setBddeathAgeDay(Integer bddeathAgeDay) {
		this.bddeathAgeDay = bddeathAgeDay;
	}

	public Integer getBddeathAgeHour() {
		return this.bddeathAgeHour;
	}

	public void setBddeathAgeHour(Integer bddeathAgeHour) {
		this.bddeathAgeHour = bddeathAgeHour;
	}

	public String getBdaddress() {
		return this.bdaddress;
	}

	public void setBdaddress(String bdaddress) {
		this.bdaddress = bdaddress;
	}

	public String getBddiagnose() {
		return this.bddiagnose;
	}

	public void setBddiagnose(String bddiagnose) {
		this.bddiagnose = bddiagnose;
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

	public String getDdataOriginOther() {
		return ddataOriginOther;
	}

	public void setDdataOriginOther(String ddataOriginOther) {
		this.ddataOriginOther = ddataOriginOther;
	}

	public String getFaddressOther() {
		return faddressOther;
	}

	public void setFaddressOther(String faddressOther) {
		this.faddressOther = faddressOther;
	}

	public String getMleadWayOther() {
		return mleadWayOther;
	}

	public void setMleadWayOther(String mleadWayOther) {
		this.mleadWayOther = mleadWayOther;
	}

	public String getMhelpDoctorOther() {
		return mhelpDoctorOther;
	}

	public void setMhelpDoctorOther(String mhelpDoctorOther) {
		this.mhelpDoctorOther = mhelpDoctorOther;
	}

	public String getBdaddressOther() {
		return bdaddressOther;
	}

	public void setBdaddressOther(String bdaddressOther) {
		this.bdaddressOther = bdaddressOther;
	}

}