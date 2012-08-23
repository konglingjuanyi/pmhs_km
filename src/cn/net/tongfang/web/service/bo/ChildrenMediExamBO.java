package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.CheckDirect;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam;
import cn.net.tongfang.framework.security.vo.ChildrenMediExamExam09;
import cn.net.tongfang.framework.security.vo.ChildrenMediExamExam10;

public class ChildrenMediExamBO extends ChildrenMediExam{
	List<CheckDirect> checkDirect;
	List<ChildrenMediExamExam09> childrenMediExamExam09;
	List<ChildrenMediExamExam10> childrenMediExamExam10;

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
	private String evaluateChild;
	private String dietDirect;
	private String earlyDirect;
	private String protectDirect;
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
	private String throatFlatRemark;
	private String lymphNodeRemark;
	private String pleuraRemark;
	
	public List<CheckDirect> getCheckDirect() {
		return checkDirect;
	}

	public void setCheckDirect(List<CheckDirect> checkDirect) {
		this.checkDirect = checkDirect;
	}

	public List<ChildrenMediExamExam09> getChildrenMediExamExam09() {
		return childrenMediExamExam09;
	}

	public void setChildrenMediExamExam09(
			List<ChildrenMediExamExam09> childrenMediExamExam09) {
		this.childrenMediExamExam09 = childrenMediExamExam09;
	}

	public List<ChildrenMediExamExam10> getChildrenMediExamExam10() {
		return childrenMediExamExam10;
	}

	public void setChildrenMediExamExam10(
			List<ChildrenMediExamExam10> childrenMediExamExam10) {
		this.childrenMediExamExam10 = childrenMediExamExam10;
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

	public String getHeartChild() {
		return heartChild;
	}

	public void setHeartChild(String heartChild) {
		this.heartChild = heartChild;
	}

	public String getEvaluateChild() {
		return evaluateChild;
	}

	public void setEvaluateChild(String evaluateChild) {
		this.evaluateChild = evaluateChild;
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
