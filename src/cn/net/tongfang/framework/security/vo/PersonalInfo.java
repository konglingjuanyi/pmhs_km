package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * PersonalInfo entity. @author MyEclipse Persistence Tools
 */

public class PersonalInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileNo;
	private String fileNoSub;
	private String sex;
	private Timestamp birthday;
	private String idnumber;
	private String workUnit;
	private String tel;
	private String linkman;
	private String linkmanTel;
	private String resideType;
	private String folk;
	private String folkOther;
	private String bloodTypeAbo;
	private String bloodTypeRh;
	private String education;
	private String occupation;
	private String maritalStatus;
	private String paymentModeOther;
	private String allergiesOther;
	private String fhistoryOther;
	private String mhistoryOther;
	private String bhistoryOther;
	private String fmHistoryOther;
	private String geneticHistory;
	private String geneticHistoryOther;
	private String disabilityStatusOther;
	private String inputPersonId;
	private Timestamp inputDate;
	private String farmStatus;
	private String homeId;
	private String kitchen;
	private String bunkers;
	private String drinkingWater;
	private String toilet;
	private String poultry;
	private String townStatus;
	private String bornStatus;
	
	// Constructors

	/** default constructor */
	public PersonalInfo() {
	}

	/** minimal constructor */
	public PersonalInfo(String id, String fileNo, String fileNoSub, String sex,
			Timestamp birthday, String idnumber) {
		this.id = id;
		this.fileNo = fileNo;
		this.fileNoSub = fileNoSub;
		this.sex = sex;
		this.birthday = birthday;
		this.idnumber = idnumber;
	}

	/** full constructor */
	

	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getBunkers() {
		return bunkers;
	}

	public void setBunkers(String bunkers) {
		this.bunkers = bunkers;
	}

	public String getDrinkingWater() {
		return drinkingWater;
	}

	public void setDrinkingWater(String drinkingWater) {
		this.drinkingWater = drinkingWater;
	}

	public String getToilet() {
		return toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	public String getPoultry() {
		return poultry;
	}

	public void setPoultry(String poultry) {
		this.poultry = poultry;
	}

	public PersonalInfo(String id, String fileNo, String fileNoSub, String sex,
			Timestamp birthday, String idnumber, String workUnit, String tel,
			String linkman, String linkmanTel, String resideType, String folk,
			String folkOther, String bloodTypeAbo, String bloodTypeRh,
			String education, String occupation, String maritalStatus,
			String paymentModeOther, String allergiesOther,
			String fhistoryOther, String mhistoryOther, String bhistoryOther,
			String fmHistoryOther, String geneticHistory,
			String geneticHistoryOther, String disabilityStatusOther,
			String inputPersonId, Timestamp inputDate, String farmStatus,
			String homeId, String kitchen, String bunkers,
			String drinkingWater, String toilet, String poultry,String townStatus,
			String bornStatus) {
		super();
		this.id = id;
		this.fileNo = fileNo;
		this.fileNoSub = fileNoSub;
		this.sex = sex;
		this.birthday = birthday;
		this.idnumber = idnumber;
		this.workUnit = workUnit;
		this.tel = tel;
		this.linkman = linkman;
		this.linkmanTel = linkmanTel;
		this.resideType = resideType;
		this.folk = folk;
		this.folkOther = folkOther;
		this.bloodTypeAbo = bloodTypeAbo;
		this.bloodTypeRh = bloodTypeRh;
		this.education = education;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.paymentModeOther = paymentModeOther;
		this.allergiesOther = allergiesOther;
		this.fhistoryOther = fhistoryOther;
		this.mhistoryOther = mhistoryOther;
		this.bhistoryOther = bhistoryOther;
		this.fmHistoryOther = fmHistoryOther;
		this.geneticHistory = geneticHistory;
		this.geneticHistoryOther = geneticHistoryOther;
		this.disabilityStatusOther = disabilityStatusOther;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
		this.farmStatus = farmStatus;
		this.homeId = homeId;
		this.kitchen = kitchen;
		this.bunkers = bunkers;
		this.drinkingWater = drinkingWater;
		this.toilet = toilet;
		this.poultry = poultry;
		this.townStatus = townStatus;
		this.bornStatus = bornStatus;
	}

	public String getTownStatus() {
		return townStatus;
	}

	public void setTownStatus(String townStatus) {
		this.townStatus = townStatus;
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

	public String getFileNoSub() {
		return this.fileNoSub;
	}

	public void setFileNoSub(String fileNoSub) {
		this.fileNoSub = fileNoSub;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanTel() {
		return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}

	public String getResideType() {
		return this.resideType;
	}

	public void setResideType(String resideType) {
		this.resideType = resideType;
	}

	public String getFolk() {
		return this.folk;
	}

	public void setFolk(String folk) {
		this.folk = folk;
	}

	public String getFolkOther() {
		return this.folkOther;
	}

	public void setFolkOther(String folkOther) {
		this.folkOther = folkOther;
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

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPaymentModeOther() {
		return this.paymentModeOther;
	}

	public void setPaymentModeOther(String paymentModeOther) {
		this.paymentModeOther = paymentModeOther;
	}

	public String getAllergiesOther() {
		return this.allergiesOther;
	}

	public void setAllergiesOther(String allergiesOther) {
		this.allergiesOther = allergiesOther;
	}

	public String getFhistoryOther() {
		return this.fhistoryOther;
	}

	public void setFhistoryOther(String fhistoryOther) {
		this.fhistoryOther = fhistoryOther;
	}

	public String getMhistoryOther() {
		return this.mhistoryOther;
	}

	public void setMhistoryOther(String mhistoryOther) {
		this.mhistoryOther = mhistoryOther;
	}

	public String getBhistoryOther() {
		return this.bhistoryOther;
	}

	public void setBhistoryOther(String bhistoryOther) {
		this.bhistoryOther = bhistoryOther;
	}

	public String getFmHistoryOther() {
		return this.fmHistoryOther;
	}

	public void setFmHistoryOther(String fmHistoryOther) {
		this.fmHistoryOther = fmHistoryOther;
	}

	public String getGeneticHistory() {
		return this.geneticHistory;
	}

	public void setGeneticHistory(String geneticHistory) {
		this.geneticHistory = geneticHistory;
	}

	public String getGeneticHistoryOther() {
		return this.geneticHistoryOther;
	}

	public void setGeneticHistoryOther(String geneticHistoryOther) {
		this.geneticHistoryOther = geneticHistoryOther;
	}

	public String getDisabilityStatusOther() {
		return this.disabilityStatusOther;
	}

	public void setDisabilityStatusOther(String disabilityStatusOther) {
		this.disabilityStatusOther = disabilityStatusOther;
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

	public String getFarmStatus() {
		return this.farmStatus;
	}

	public void setFarmStatus(String farmStatus) {
		this.farmStatus = farmStatus;
	}

	public String getHomeId() {
		return this.homeId;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public String getBornStatus() {
		return bornStatus;
	}

	public void setBornStatus(String bornStatus) {
		this.bornStatus = bornStatus;
	}
	
}