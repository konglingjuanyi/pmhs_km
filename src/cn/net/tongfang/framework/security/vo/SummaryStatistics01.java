package cn.net.tongfang.framework.security.vo;

/**
 * SummaryStatistics01 entity. @author MyEclipse Persistence Tools
 */

public class SummaryStatistics01 implements java.io.Serializable {

	// Fields

	private String id;
	private Integer rowId;
	private Integer orgId;
	private String inputPersonId;
	private String groupDate;
	private Long vhealthCount;
	private Long chealthCount;
	private Long babyVisitCount;
	private Long babyHealthCount;
	private Long children01count;
	private Long children02count;
	private Long children36count;
	private Long babyAllVisitCount;
	private Long maternalCount;
	private Long firstVistBeforeBornCount;
	private Long visitBeforeBornCount;
	private Long prenatalVisitCount;
	private Long visitAfterBornCount;
	private Long visitAfterBorn42count;
	private Long hypertensionVisitCount;
	private Long hypertensionHealthCount;
	private Long diabetesVisitCount;
	private Long diabetesHealthCount;
	private Long furiousVisitCount;
	private Long furiousHealthCount;
	private String userName;
	private String orgName;
	private String optPersonId;

	// Constructors

	/** default constructor */
	public SummaryStatistics01() {
	}

	/** minimal constructor */
	public SummaryStatistics01(Integer rowId, Integer orgId,
			String inputPersonId, Long vhealthCount, Long chealthCount,
			Long babyVisitCount, Long babyHealthCount, Long children01count,
			Long children02count, Long children36count, Long babyAllVisitCount,
			Long maternalCount, Long firstVistBeforeBornCount,
			Long visitBeforeBornCount, Long prenatalVisitCount,
			Long visitAfterBornCount, Long visitAfterBorn42count,
			Long hypertensionVisitCount, Long hypertensionHealthCount,
			Long diabetesVisitCount, Long diabetesHealthCount,
			Long furiousVisitCount, Long furiousHealthCount, String optPersonId) {
		this.rowId = rowId;
		this.orgId = orgId;
		this.inputPersonId = inputPersonId;
		this.vhealthCount = vhealthCount;
		this.chealthCount = chealthCount;
		this.babyVisitCount = babyVisitCount;
		this.babyHealthCount = babyHealthCount;
		this.children01count = children01count;
		this.children02count = children02count;
		this.children36count = children36count;
		this.babyAllVisitCount = babyAllVisitCount;
		this.maternalCount = maternalCount;
		this.firstVistBeforeBornCount = firstVistBeforeBornCount;
		this.visitBeforeBornCount = visitBeforeBornCount;
		this.prenatalVisitCount = prenatalVisitCount;
		this.visitAfterBornCount = visitAfterBornCount;
		this.visitAfterBorn42count = visitAfterBorn42count;
		this.hypertensionVisitCount = hypertensionVisitCount;
		this.hypertensionHealthCount = hypertensionHealthCount;
		this.diabetesVisitCount = diabetesVisitCount;
		this.diabetesHealthCount = diabetesHealthCount;
		this.furiousVisitCount = furiousVisitCount;
		this.furiousHealthCount = furiousHealthCount;
		this.optPersonId = optPersonId;
	}

	/** full constructor */
	public SummaryStatistics01(Integer rowId, Integer orgId,
			String inputPersonId, String groupDate, Long vhealthCount,
			Long chealthCount, Long babyVisitCount, Long babyHealthCount,
			Long children01count, Long children02count, Long children36count,
			Long babyAllVisitCount, Long maternalCount,
			Long firstVistBeforeBornCount, Long visitBeforeBornCount,
			Long prenatalVisitCount, Long visitAfterBornCount,
			Long visitAfterBorn42count, Long hypertensionVisitCount,
			Long hypertensionHealthCount, Long diabetesVisitCount,
			Long diabetesHealthCount, Long furiousVisitCount,
			Long furiousHealthCount, String userName, String orgName,
			String optPersonId) {
		this.rowId = rowId;
		this.orgId = orgId;
		this.inputPersonId = inputPersonId;
		this.groupDate = groupDate;
		this.vhealthCount = vhealthCount;
		this.chealthCount = chealthCount;
		this.babyVisitCount = babyVisitCount;
		this.babyHealthCount = babyHealthCount;
		this.children01count = children01count;
		this.children02count = children02count;
		this.children36count = children36count;
		this.babyAllVisitCount = babyAllVisitCount;
		this.maternalCount = maternalCount;
		this.firstVistBeforeBornCount = firstVistBeforeBornCount;
		this.visitBeforeBornCount = visitBeforeBornCount;
		this.prenatalVisitCount = prenatalVisitCount;
		this.visitAfterBornCount = visitAfterBornCount;
		this.visitAfterBorn42count = visitAfterBorn42count;
		this.hypertensionVisitCount = hypertensionVisitCount;
		this.hypertensionHealthCount = hypertensionHealthCount;
		this.diabetesVisitCount = diabetesVisitCount;
		this.diabetesHealthCount = diabetesHealthCount;
		this.furiousVisitCount = furiousVisitCount;
		this.furiousHealthCount = furiousHealthCount;
		this.userName = userName;
		this.orgName = orgName;
		this.optPersonId = optPersonId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRowId() {
		return this.rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public String getGroupDate() {
		return this.groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public Long getVhealthCount() {
		return this.vhealthCount;
	}

	public void setVhealthCount(Long vhealthCount) {
		this.vhealthCount = vhealthCount;
	}

	public Long getChealthCount() {
		return this.chealthCount;
	}

	public void setChealthCount(Long chealthCount) {
		this.chealthCount = chealthCount;
	}

	public Long getBabyVisitCount() {
		return this.babyVisitCount;
	}

	public void setBabyVisitCount(Long babyVisitCount) {
		this.babyVisitCount = babyVisitCount;
	}

	public Long getBabyHealthCount() {
		return this.babyHealthCount;
	}

	public void setBabyHealthCount(Long babyHealthCount) {
		this.babyHealthCount = babyHealthCount;
	}

	public Long getChildren01count() {
		return this.children01count;
	}

	public void setChildren01count(Long children01count) {
		this.children01count = children01count;
	}

	public Long getChildren02count() {
		return this.children02count;
	}

	public void setChildren02count(Long children02count) {
		this.children02count = children02count;
	}

	public Long getChildren36count() {
		return this.children36count;
	}

	public void setChildren36count(Long children36count) {
		this.children36count = children36count;
	}

	public Long getBabyAllVisitCount() {
		return this.babyAllVisitCount;
	}

	public void setBabyAllVisitCount(Long babyAllVisitCount) {
		this.babyAllVisitCount = babyAllVisitCount;
	}

	public Long getMaternalCount() {
		return this.maternalCount;
	}

	public void setMaternalCount(Long maternalCount) {
		this.maternalCount = maternalCount;
	}

	public Long getFirstVistBeforeBornCount() {
		return this.firstVistBeforeBornCount;
	}

	public void setFirstVistBeforeBornCount(Long firstVistBeforeBornCount) {
		this.firstVistBeforeBornCount = firstVistBeforeBornCount;
	}

	public Long getVisitBeforeBornCount() {
		return this.visitBeforeBornCount;
	}

	public void setVisitBeforeBornCount(Long visitBeforeBornCount) {
		this.visitBeforeBornCount = visitBeforeBornCount;
	}

	public Long getPrenatalVisitCount() {
		return this.prenatalVisitCount;
	}

	public void setPrenatalVisitCount(Long prenatalVisitCount) {
		this.prenatalVisitCount = prenatalVisitCount;
	}

	public Long getVisitAfterBornCount() {
		return this.visitAfterBornCount;
	}

	public void setVisitAfterBornCount(Long visitAfterBornCount) {
		this.visitAfterBornCount = visitAfterBornCount;
	}

	public Long getVisitAfterBorn42count() {
		return this.visitAfterBorn42count;
	}

	public void setVisitAfterBorn42count(Long visitAfterBorn42count) {
		this.visitAfterBorn42count = visitAfterBorn42count;
	}

	public Long getHypertensionVisitCount() {
		return this.hypertensionVisitCount;
	}

	public void setHypertensionVisitCount(Long hypertensionVisitCount) {
		this.hypertensionVisitCount = hypertensionVisitCount;
	}

	public Long getHypertensionHealthCount() {
		return this.hypertensionHealthCount;
	}

	public void setHypertensionHealthCount(Long hypertensionHealthCount) {
		this.hypertensionHealthCount = hypertensionHealthCount;
	}

	public Long getDiabetesVisitCount() {
		return this.diabetesVisitCount;
	}

	public void setDiabetesVisitCount(Long diabetesVisitCount) {
		this.diabetesVisitCount = diabetesVisitCount;
	}

	public Long getDiabetesHealthCount() {
		return this.diabetesHealthCount;
	}

	public void setDiabetesHealthCount(Long diabetesHealthCount) {
		this.diabetesHealthCount = diabetesHealthCount;
	}

	public Long getFuriousVisitCount() {
		return this.furiousVisitCount;
	}

	public void setFuriousVisitCount(Long furiousVisitCount) {
		this.furiousVisitCount = furiousVisitCount;
	}

	public Long getFuriousHealthCount() {
		return this.furiousHealthCount;
	}

	public void setFuriousHealthCount(Long furiousHealthCount) {
		this.furiousHealthCount = furiousHealthCount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOptPersonId() {
		return this.optPersonId;
	}

	public void setOptPersonId(String optPersonId) {
		this.optPersonId = optPersonId;
	}

}