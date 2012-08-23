package cn.net.tongfang.web.service.bo;

import java.sql.Timestamp;
import java.util.List;

import cn.net.tongfang.framework.security.vo.BabyDirect;
import cn.net.tongfang.framework.security.vo.BabySkin;
import cn.net.tongfang.framework.security.vo.BabyVisit;
import cn.net.tongfang.framework.security.vo.BornStatus;
import cn.net.tongfang.framework.security.vo.FaceColor;
import cn.net.tongfang.framework.security.vo.HighRiskStatus;
import cn.net.tongfang.framework.security.vo.PregnantSick;

public class BabyVisitBO extends BabyVisit{
	List<PregnantSick> pregnantSick;
	List<BornStatus> bornStatus;
	List<FaceColor> faceColor;
	List<BabySkin> babySkin;
	List<BabyDirect> babyDirect;
	
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
	private String directAge;
	private String spleenOther;
	private String liverOther;
	private String heartChildOther;
	private String lungOther;
	private String genitalsOther;
	private String nerveMentalOther;
	private String pelvisOther;
	private String throatFlatRemark;
	private String lymphNodeRemark;
	private String pleuraRemark;
//	List<HighRiskStatus> highRiskStatus;

	public List<PregnantSick> getPregnantSick() {
		return pregnantSick;
	}
	public String getDirectAge() {
		return directAge;
	}
	public void setDirectAge(String directAge) {
		this.directAge = directAge;
	}
	public void setPregnantSick(List<PregnantSick> pregnantSick) {
		this.pregnantSick = pregnantSick;
	}
	public List<BornStatus> getBornStatus() {
		return bornStatus;
	}
	public void setBornStatus(List<BornStatus> bornStatus) {
		this.bornStatus = bornStatus;
	}
	public List<FaceColor> getFaceColor() {
		return faceColor;
	}
	public void setFaceColor(List<FaceColor> faceColor) {
		this.faceColor = faceColor;
	}
	public List<BabySkin> getBabySkin() {
		return babySkin;
	}
	public void setBabySkin(List<BabySkin> babySkin) {
		this.babySkin = babySkin;
	}
	public List<BabyDirect> getBabyDirect() {
		return babyDirect;
	}
	public void setBabyDirect(List<BabyDirect> babyDirect) {
		this.babyDirect = babyDirect;
	}
//	public List<HighRiskStatus> getHighRiskStatus() {
//		return highRiskStatus;
//	}
//	public void setHighRiskStatus(List<HighRiskStatus> highRiskStatus) {
//		this.highRiskStatus = highRiskStatus;
//	}
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
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
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
	public String getMedicalExamId() {
		return medicalExamId;
	}
	public void setMedicalExamId(String medicalExamId) {
		this.medicalExamId = medicalExamId;
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
	public String getGenitalsOther() {
		return genitalsOther;
	}
	public void setGenitalsOther(String genitalsOther) {
		this.genitalsOther = genitalsOther;
	}
	public String getNerveMentalOther() {
		return nerveMentalOther;
	}
	public void setNerveMentalOther(String nerveMentalOther) {
		this.nerveMentalOther = nerveMentalOther;
	}
	public String getPelvisOther() {
		return pelvisOther;
	}
	public void setPelvisOther(String pelvisOther) {
		this.pelvisOther = pelvisOther;
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
