package cn.net.tongfang.framework.security.vo;

/**
 * SummaryStatisticsBirthCertifi entity. @author MyEclipse Persistence Tools
 */

public class SummaryStatisticsBirthCertifi implements java.io.Serializable {

	// Fields

	private String id;
	private Integer rowId;
	private String orgName;
	private String username;
	private String groupDate;
	private Long unUsedCount;
	private Long usedCount;
	private Long destroyCount;
	private Long archiveCount;
	private String inputPersonId;

	// Constructors

	/** default constructor */
	public SummaryStatisticsBirthCertifi() {
	}

	/** full constructor */
	public SummaryStatisticsBirthCertifi(Integer rowId, String orgName,
			String username, String groupDate, Long unUsedCount,
			Long usedCount, Long destroyCount, Long archiveCount,
			String inputPersonId) {
		this.rowId = rowId;
		this.orgName = orgName;
		this.username = username;
		this.groupDate = groupDate;
		this.unUsedCount = unUsedCount;
		this.usedCount = usedCount;
		this.destroyCount = destroyCount;
		this.archiveCount = archiveCount;
		this.inputPersonId = inputPersonId;
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

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroupDate() {
		return this.groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public Long getUnUsedCount() {
		return this.unUsedCount;
	}

	public void setUnUsedCount(Long unUsedCount) {
		this.unUsedCount = unUsedCount;
	}

	public Long getUsedCount() {
		return this.usedCount;
	}

	public void setUsedCount(Long usedCount) {
		this.usedCount = usedCount;
	}

	public Long getDestroyCount() {
		return this.destroyCount;
	}

	public void setDestroyCount(Long destroyCount) {
		this.destroyCount = destroyCount;
	}

	public Long getArchiveCount() {
		return this.archiveCount;
	}

	public void setArchiveCount(Long archiveCount) {
		this.archiveCount = archiveCount;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

}