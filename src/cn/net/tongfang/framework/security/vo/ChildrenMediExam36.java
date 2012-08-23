package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * ChildrenMediExam36 entity. @author MyEclipse Persistence Tools
 */

public class ChildrenMediExam36 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileNo;
	private String inputPersonId;
	private Timestamp inputDate;
	private String checkItem;
	private Timestamp visitDate;
	private Double weight;
	private String weightScore;
	private Double height;
	private String heightScore;
	private String body;
	private Double sight;
	private String hearing;
	private Integer tooth;
	private Integer caries;
	private String heart;
	private String heartOther;
	private String venter;
	private String venterOther;
	private Double hemoglobin;
	private Integer checkSickness;
	private Integer scour;
	private String checkSicknessOther;
	private Integer wound;
	private Integer pneumonia;
	private String other;
	private Integer transfer;
	private String transReason;
	private String transUnit;
	private String directOther;
	private Timestamp nextVisitDate;
	private String visitDoctor;
	private String highRisk;
	private String highRiskRemark;
	private String execDistrictNum;
	private String highRiskSearch;
	// Constructors

	/** default constructor */
	public ChildrenMediExam36() {
	}

	/** minimal constructor */
	public ChildrenMediExam36(String id, String fileNo, String inputPersonId,
			Timestamp inputDate, String checkItem) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.checkItem = checkItem;
	}

	/** full constructor */
	public ChildrenMediExam36(String id, String fileNo, String inputPersonId,
			Timestamp inputDate, String checkItem, Timestamp visitDate,
			Double weight, String weightScore, Double height,
			String heightScore, String body, Double sight, String hearing,
			Integer tooth, Integer caries, String heart, String heartOther,
			String venter, String venterOther, Double hemoglobin,
			Integer checkSickness, Integer scour, String checkSicknessOther,
			Integer wound, Integer pneumonia, String other, Integer transfer,
			String transReason, String transUnit, String directOther,
			Timestamp nextVisitDate, String visitDoctor,String highRisk,
			String highRiskRemark,String execDistrictNum,String highRiskSearch) {
		this.id = id;
		this.fileNo = fileNo;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.checkItem = checkItem;
		this.visitDate = visitDate;
		this.weight = weight;
		this.weightScore = weightScore;
		this.height = height;
		this.heightScore = heightScore;
		this.body = body;
		this.sight = sight;
		this.hearing = hearing;
		this.tooth = tooth;
		this.caries = caries;
		this.heart = heart;
		this.heartOther = heartOther;
		this.venter = venter;
		this.venterOther = venterOther;
		this.hemoglobin = hemoglobin;
		this.checkSickness = checkSickness;
		this.scour = scour;
		this.checkSicknessOther = checkSicknessOther;
		this.wound = wound;
		this.pneumonia = pneumonia;
		this.other = other;
		this.transfer = transfer;
		this.transReason = transReason;
		this.transUnit = transUnit;
		this.directOther = directOther;
		this.nextVisitDate = nextVisitDate;
		this.visitDoctor = visitDoctor;
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

	public Integer getCheckSickness() {
		return checkSickness;
	}

	public void setCheckSickness(Integer checkSickness) {
		this.checkSickness = checkSickness;
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

	public String getCheckItem() {
		return this.checkItem;
	}

	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}

	public Timestamp getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getWeightScore() {
		return this.weightScore;
	}

	public void setWeightScore(String weightScore) {
		this.weightScore = weightScore;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getHeightScore() {
		return this.heightScore;
	}

	public void setHeightScore(String heightScore) {
		this.heightScore = heightScore;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Double getSight() {
		return this.sight;
	}

	public void setSight(Double sight) {
		this.sight = sight;
	}

	public String getHearing() {
		return this.hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}

	public Integer getTooth() {
		return this.tooth;
	}

	public void setTooth(Integer tooth) {
		this.tooth = tooth;
	}

	public Integer getCaries() {
		return this.caries;
	}

	public void setCaries(Integer caries) {
		this.caries = caries;
	}

	public String getHeart() {
		return this.heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public String getHeartOther() {
		return this.heartOther;
	}

	public void setHeartOther(String heartOther) {
		this.heartOther = heartOther;
	}

	public String getVenter() {
		return this.venter;
	}

	public void setVenter(String venter) {
		this.venter = venter;
	}

	public String getVenterOther() {
		return this.venterOther;
	}

	public void setVenterOther(String venterOther) {
		this.venterOther = venterOther;
	}

	public Double getHemoglobin() {
		return this.hemoglobin;
	}

	public void setHemoglobin(Double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}


	public Integer getScour() {
		return this.scour;
	}

	public void setScour(Integer scour) {
		this.scour = scour;
	}

	public String getCheckSicknessOther() {
		return this.checkSicknessOther;
	}

	public void setCheckSicknessOther(String checkSicknessOther) {
		this.checkSicknessOther = checkSicknessOther;
	}

	public Integer getWound() {
		return this.wound;
	}

	public void setWound(Integer wound) {
		this.wound = wound;
	}

	public Integer getPneumonia() {
		return this.pneumonia;
	}

	public void setPneumonia(Integer pneumonia) {
		this.pneumonia = pneumonia;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getTransfer() {
		return transfer;
	}

	public void setTransfer(Integer transfer) {
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

	public String getDirectOther() {
		return this.directOther;
	}

	public void setDirectOther(String directOther) {
		this.directOther = directOther;
	}


	public Timestamp getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Timestamp nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getVisitDoctor() {
		return this.visitDoctor;
	}

	public void setVisitDoctor(String visitDoctor) {
		this.visitDoctor = visitDoctor;
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