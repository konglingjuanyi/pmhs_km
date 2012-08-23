package cn.net.tongfang.web.service.bo;

import java.math.BigDecimal;

import cn.net.tongfang.framework.security.vo.WomanPhysicalItems;

public class MedicalExamPrintBO extends WomanPhysicalItems {
	private String name;
	private String sex;
	private String age;
	private BigDecimal weight;
	private BigDecimal height;
	private String babySkin;
	private BigDecimal skull01;
	private BigDecimal skull02;
	private String nose;
	private String ear;
	private String hearing;
	private String genitals;//外生殖器
	private String backbone;//脊柱四肢
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public String getBabySkin() {
		return babySkin;
	}
	public void setBabySkin(String babySkin) {
		this.babySkin = babySkin;
	}
	public BigDecimal getSkull01() {
		return skull01;
	}
	public void setSkull01(BigDecimal skull01) {
		this.skull01 = skull01;
	}
	public BigDecimal getSkull02() {
		return skull02;
	}
	public void setSkull02(BigDecimal skull02) {
		this.skull02 = skull02;
	}
	public String getNose() {
		return nose;
	}
	public void setNose(String nose) {
		this.nose = nose;
	}
	public String getEar() {
		return ear;
	}
	public void setEar(String ear) {
		this.ear = ear;
	}
	public String getHearing() {
		return hearing;
	}
	public void setHearing(String hearing) {
		this.hearing = hearing;
	}
	public String getGenitals() {
		return genitals;
	}
	public void setGenitals(String genitals) {
		this.genitals = genitals;
	}
	public String getBackbone() {
		return backbone;
	}
	public void setBackbone(String backbone) {
		this.backbone = backbone;
	}
	
}
