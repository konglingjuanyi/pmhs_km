package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;
import java.util.List;

import cn.net.tongfang.framework.security.vo.CheckDirect36;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam36;

public class ChildrenMediExam36BO extends ChildrenMediExam36{
	/**
	 * 
	 */
	List<CheckDirect36> checkDirect36;
	
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
	private String heartChild;
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
	private String directAge;
	private String pelvisOther;
	private String nerveMentalOther;
	private String backbone;
	private String backboneOther;
	private String hearingChild;
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
	
	public List<CheckDirect36> getCheckDirect36() {
		return checkDirect36;
	}
	public void setCheckDirect36(List<CheckDirect36> checkDirect36) {
		this.checkDirect36 = checkDirect36;
	}
	public String getMedicalExamId() {
		return medicalExamId;
	}
	public void setMedicalExamId(String medicalExamId) {
		this.medicalExamId = medicalExamId;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getOnlinePhoto() {
		return onlinePhoto;
	}
	public void setOnlinePhoto(String onlinePhoto) {
		this.onlinePhoto = onlinePhoto;
	}
	public String getPleura() {
		return pleura;
	}
	public void setPleura(String pleura) {
		this.pleura = pleura;
	}
	public String getMikTooth() {
		return mikTooth;
	}
	public void setMikTooth(String mikTooth) {
		this.mikTooth = mikTooth;
	}
	public String getDecayedTooth() {
		return decayedTooth;
	}
	public void setDecayedTooth(String decayedTooth) {
		this.decayedTooth = decayedTooth;
	}
	public String getThroatFlat() {
		return throatFlat;
	}
	public void setThroatFlat(String throatFlat) {
		this.throatFlat = throatFlat;
	}
	public String getLeftEyes() {
		return leftEyes;
	}
	public void setLeftEyes(String leftEyes) {
		this.leftEyes = leftEyes;
	}
	public String getRightEyes() {
		return rightEyes;
	}
	public void setRightEyes(String rightEyes) {
		this.rightEyes = rightEyes;
	}
	public String getLung() {
		return lung;
	}
	public void setLung(String lung) {
		this.lung = lung;
	}
	public String getLymphNode() {
		return lymphNode;
	}
	public void setLymphNode(String lymphNode) {
		this.lymphNode = lymphNode;
	}
	public String getLiver() {
		return liver;
	}
	public void setLiver(String liver) {
		this.liver = liver;
	}
	public String getSpleen() {
		return spleen;
	}
	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}
	public String getNerveMental() {
		return nerveMental;
	}
	public void setNerveMental(String nerveMental) {
		this.nerveMental = nerveMental;
	}
	public String getPelvis() {
		return pelvis;
	}
	public void setPelvis(String pelvis) {
		this.pelvis = pelvis;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getDietDirect() {
		return dietDirect;
	}
	public void setDietDirect(String dietDirect) {
		this.dietDirect = dietDirect;
	}
	public String getEarlyDirect() {
		return earlyDirect;
	}
	public void setEarlyDirect(String earlyDirect) {
		this.earlyDirect = earlyDirect;
	}
	public String getProtectDirect() {
		return protectDirect;
	}
	public void setProtectDirect(String protectDirect) {
		this.protectDirect = protectDirect;
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
	public String getHeartChild() {
		return heartChild;
	}
	public void setHeartChild(String heartChild) {
		this.heartChild = heartChild;
	}
	public String getHearingChild() {
		return hearingChild;
	}
	public void setHearingChild(String hearingChild) {
		this.hearingChild = hearingChild;
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
