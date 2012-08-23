package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * WomanPhysicalItems entity. @author MyEclipse Persistence Tools
 */
public class WomanPhysicalItems implements java.io.Serializable {

	// Fields

	private String id;
	private String medicalExamId;
	private String pressure;
	private String onlinePhoto;
	private String pleura;
	private String mikTooth;
	private String decayedTooth;
	private String throatFlat;
	private String leftEyes;
	private String rightEyes;
	private String lung;
	private String heart;
	private String lymphNode;
	private String liver;
	private String spleen;
	private String nerveMental;
	private String pelvis;
	private String illness;
	private String evaluate;
	private String dietDirect;
	private String earlyDirect;
	private String protectDirect;
	private String inputPersonId;
	private Timestamp inputDate;
	private String directAge;
	private String pelvisOther;
	private String nerveMentalOther;
	private String backbone;
	private String backboneOther;
	private String hearing;
	private String hearingOther;
	private String nose;
	private String noseother;
	private String spleenOther;
	private String liverOther;
	private String heartChildOther;
	private String lungOther;
	private String genitals;
	private String genitalsOther;
	private String ears;
	private String earsOther;
	private String skins;
	private String skinsOther;
	private String fourLimbs;
	private String fourLimbsOther;
	private Double beforeSkull01;
	private Double beforeSkull02;
	private String throatFlatRemark;
	private String lymphNodeRemark;
	private String pleuraRemark;
	// Constructors

	/** default constructor */
	public WomanPhysicalItems() {
	}

	/** minimal constructor */
	public WomanPhysicalItems(String medicalExamId) {
		this.medicalExamId = medicalExamId;
	}

	public WomanPhysicalItems(String id, String medicalExamId, String pressure,
			String onlinePhoto, String pleura, String mikTooth,
			String decayedTooth, String throatFlat, String leftEyes,
			String rightEyes, String lung, String heart, String lymphNode,
			String liver, String spleen, String nerveMental, String pelvis,
			String illness, String evaluate, String dietDirect,
			String earlyDirect, String protectDirect, String inputPersonId,
			Timestamp inputDate, String directAge, String pelvisOther,
			String nerveMentalOther, String backbone, String backboneOther,
			String hearing, String hearingOther, String nose, String noseother,
			String spleenOther, String liverOther, String heartChildOther,
			String lungOther, String genitals, String genitalsOther,
			String ears, String earsOther, String skins, String skinsOther,
			String fourLimbs, String fourLimbsOther, Double beforeSkull01,
			Double beforeSkull02,String throatFlatRemark,String lymphNodeRemark,
			String pleuraRemark) {
		super();
		this.id = id;
		this.medicalExamId = medicalExamId;
		this.pressure = pressure;
		this.onlinePhoto = onlinePhoto;
		this.pleura = pleura;
		this.mikTooth = mikTooth;
		this.decayedTooth = decayedTooth;
		this.throatFlat = throatFlat;
		this.leftEyes = leftEyes;
		this.rightEyes = rightEyes;
		this.lung = lung;
		this.heart = heart;
		this.lymphNode = lymphNode;
		this.liver = liver;
		this.spleen = spleen;
		this.nerveMental = nerveMental;
		this.pelvis = pelvis;
		this.illness = illness;
		this.evaluate = evaluate;
		this.dietDirect = dietDirect;
		this.earlyDirect = earlyDirect;
		this.protectDirect = protectDirect;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.directAge = directAge;
		this.pelvisOther = pelvisOther;
		this.nerveMentalOther = nerveMentalOther;
		this.backbone = backbone;
		this.backboneOther = backboneOther;
		this.hearing = hearing;
		this.hearingOther = hearingOther;
		this.nose = nose;
		this.noseother = noseother;
		this.spleenOther = spleenOther;
		this.liverOther = liverOther;
		this.heartChildOther = heartChildOther;
		this.lungOther = lungOther;
		this.genitals = genitals;
		this.genitalsOther = genitalsOther;
		this.ears = ears;
		this.earsOther = earsOther;
		this.skins = skins;
		this.skinsOther = skinsOther;
		this.fourLimbs = fourLimbs;
		this.fourLimbsOther = fourLimbsOther;
		this.beforeSkull01 = beforeSkull01;
		this.beforeSkull02 = beforeSkull02;
		this.throatFlatRemark = throatFlatRemark;
		this.lymphNodeRemark = lymphNodeRemark;
		this.pleuraRemark = pleuraRemark;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicalExamId() {
		return this.medicalExamId;
	}

	public void setMedicalExamId(String medicalExamId) {
		this.medicalExamId = medicalExamId;
	}

	public String getPressure() {
		return this.pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getOnlinePhoto() {
		return this.onlinePhoto;
	}

	public void setOnlinePhoto(String onlinePhoto) {
		this.onlinePhoto = onlinePhoto;
	}

	public String getPleura() {
		return this.pleura;
	}

	public void setPleura(String pleura) {
		this.pleura = pleura;
	}

	public String getMikTooth() {
		return this.mikTooth;
	}

	public void setMikTooth(String mikTooth) {
		this.mikTooth = mikTooth;
	}

	public String getDecayedTooth() {
		return this.decayedTooth;
	}

	public void setDecayedTooth(String decayedTooth) {
		this.decayedTooth = decayedTooth;
	}

	public String getThroatFlat() {
		return this.throatFlat;
	}

	public void setThroatFlat(String throatFlat) {
		this.throatFlat = throatFlat;
	}

	public String getLeftEyes() {
		return this.leftEyes;
	}

	public void setLeftEyes(String leftEyes) {
		this.leftEyes = leftEyes;
	}

	public String getRightEyes() {
		return this.rightEyes;
	}

	public void setRightEyes(String rightEyes) {
		this.rightEyes = rightEyes;
	}

	public String getLung() {
		return this.lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}

	public String getHeart() {
		return this.heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public String getLymphNode() {
		return this.lymphNode;
	}

	public void setLymphNode(String lymphNode) {
		this.lymphNode = lymphNode;
	}

	public String getLiver() {
		return this.liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getSpleen() {
		return this.spleen;
	}

	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}

	public String getNerveMental() {
		return this.nerveMental;
	}

	public void setNerveMental(String nerveMental) {
		this.nerveMental = nerveMental;
	}

	public String getPelvis() {
		return this.pelvis;
	}

	public void setPelvis(String pelvis) {
		this.pelvis = pelvis;
	}

	public String getIllness() {
		return this.illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getDietDirect() {
		return this.dietDirect;
	}

	public void setDietDirect(String dietDirect) {
		this.dietDirect = dietDirect;
	}

	public String getEarlyDirect() {
		return this.earlyDirect;
	}

	public void setEarlyDirect(String earlyDirect) {
		this.earlyDirect = earlyDirect;
	}

	public String getProtectDirect() {
		return this.protectDirect;
	}

	public void setProtectDirect(String protectDirect) {
		this.protectDirect = protectDirect;
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

	public String getDirectAge() {
		return directAge;
	}

	public void setDirectAge(String directAge) {
		this.directAge = directAge;
	}

	public String getPelvisOther() {
		return pelvisOther;
	}

	public void setPelvisOther(String pelvisOther) {
		this.pelvisOther = pelvisOther;
	}

	public String getNerveMentalOther() {
		return nerveMentalOther;
	}

	public void setNerveMentalOther(String nerveMentalOther) {
		this.nerveMentalOther = nerveMentalOther;
	}

	public String getBackbone() {
		return backbone;
	}

	public void setBackbone(String backbone) {
		this.backbone = backbone;
	}

	public String getBackboneOther() {
		return backboneOther;
	}

	public void setBackboneOther(String backboneOther) {
		this.backboneOther = backboneOther;
	}

	public String getHearing() {
		return hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}

	public String getHearingOther() {
		return hearingOther;
	}

	public void setHearingOther(String hearingOther) {
		this.hearingOther = hearingOther;
	}

	public String getNose() {
		return nose;
	}

	public void setNose(String nose) {
		this.nose = nose;
	}

	public String getNoseother() {
		return noseother;
	}

	public void setNoseother(String noseother) {
		this.noseother = noseother;
	}

	public String getSpleenOther() {
		return spleenOther;
	}

	public void setSpleenOther(String spleenOther) {
		this.spleenOther = spleenOther;
	}

	public String getLiverOther() {
		return liverOther;
	}

	public void setLiverOther(String liverOther) {
		this.liverOther = liverOther;
	}

	public String getHeartChildOther() {
		return heartChildOther;
	}

	public void setHeartChildOther(String heartChildOther) {
		this.heartChildOther = heartChildOther;
	}

	public String getLungOther() {
		return lungOther;
	}

	public void setLungOther(String lungOther) {
		this.lungOther = lungOther;
	}

	public String getGenitals() {
		return genitals;
	}

	public void setGenitals(String genitals) {
		this.genitals = genitals;
	}

	public String getGenitalsOther() {
		return genitalsOther;
	}

	public void setGenitalsOther(String genitalsOther) {
		this.genitalsOther = genitalsOther;
	}

	public String getEars() {
		return ears;
	}

	public void setEars(String ears) {
		this.ears = ears;
	}

	public String getEarsOther() {
		return earsOther;
	}

	public void setEarsOther(String earsOther) {
		this.earsOther = earsOther;
	}

	public String getSkins() {
		return skins;
	}

	public void setSkins(String skins) {
		this.skins = skins;
	}

	public String getSkinsOther() {
		return skinsOther;
	}

	public void setSkinsOther(String skinsOther) {
		this.skinsOther = skinsOther;
	}

	public String getFourLimbs() {
		return fourLimbs;
	}

	public void setFourLimbs(String fourLimbs) {
		this.fourLimbs = fourLimbs;
	}

	public String getFourLimbsOther() {
		return fourLimbsOther;
	}

	public void setFourLimbsOther(String fourLimbsOther) {
		this.fourLimbsOther = fourLimbsOther;
	}

	public Double getBeforeSkull01() {
		return beforeSkull01;
	}

	public void setBeforeSkull01(Double beforeSkull01) {
		this.beforeSkull01 = beforeSkull01;
	}

	public Double getBeforeSkull02() {
		return beforeSkull02;
	}

	public void setBeforeSkull02(Double beforeSkull02) {
		this.beforeSkull02 = beforeSkull02;
	}

	public String getThroatFlatRemark() {
		return throatFlatRemark;
	}

	public void setThroatFlatRemark(String throatFlatRemark) {
		this.throatFlatRemark = throatFlatRemark;
	}

	public String getLymphNodeRemark() {
		return lymphNodeRemark;
	}

	public void setLymphNodeRemark(String lymphNodeRemark) {
		this.lymphNodeRemark = lymphNodeRemark;
	}

	public String getPleuraRemark() {
		return pleuraRemark;
	}

	public void setPleuraRemark(String pleuraRemark) {
		this.pleuraRemark = pleuraRemark;
	}

}