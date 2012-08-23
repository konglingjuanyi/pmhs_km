package cn.net.tongfang.framework.security.vo;

/**
 * SummaryStatisticsHivandSyphilis entity. @author MyEclipse Persistence Tools
 */

public class SummaryStatisticsHivandSyphilis implements java.io.Serializable {

	// Fields

	private String id;
	private Integer rowId;
	private String inputPersonId;
	private Long hivnegative;
	private Long hivmasculine;
	private Long hivothers;
	private Long syphilisNegative;
	private Long syphilisMasculine;
	private Long syphilisOthers;
	private String orgName;
	private String userName;
	private String groupDate;
	private String optPersonId;

	// Constructors

	/** default constructor */
	public SummaryStatisticsHivandSyphilis() {
	}

	/** minimal constructor */
	public SummaryStatisticsHivandSyphilis(Integer rowId, String inputPersonId,
			Long hivnegative, Long hivmasculine, Long hivothers,
			Long syphilisNegative, Long syphilisMasculine, Long syphilisOthers,
			String optPersonId) {
		this.rowId = rowId;
		this.inputPersonId = inputPersonId;
		this.hivnegative = hivnegative;
		this.hivmasculine = hivmasculine;
		this.hivothers = hivothers;
		this.syphilisNegative = syphilisNegative;
		this.syphilisMasculine = syphilisMasculine;
		this.syphilisOthers = syphilisOthers;
		this.optPersonId = optPersonId;
	}

	/** full constructor */
	public SummaryStatisticsHivandSyphilis(Integer rowId, String inputPersonId,
			Long hivnegative, Long hivmasculine, Long hivothers,
			Long syphilisNegative, Long syphilisMasculine, Long syphilisOthers,
			String orgName, String userName, String groupDate,
			String optPersonId) {
		this.rowId = rowId;
		this.inputPersonId = inputPersonId;
		this.hivnegative = hivnegative;
		this.hivmasculine = hivmasculine;
		this.hivothers = hivothers;
		this.syphilisNegative = syphilisNegative;
		this.syphilisMasculine = syphilisMasculine;
		this.syphilisOthers = syphilisOthers;
		this.orgName = orgName;
		this.userName = userName;
		this.groupDate = groupDate;
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

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Long getHivnegative() {
		return this.hivnegative;
	}

	public void setHivnegative(Long hivnegative) {
		this.hivnegative = hivnegative;
	}

	public Long getHivmasculine() {
		return this.hivmasculine;
	}

	public void setHivmasculine(Long hivmasculine) {
		this.hivmasculine = hivmasculine;
	}

	public Long getHivothers() {
		return this.hivothers;
	}

	public void setHivothers(Long hivothers) {
		this.hivothers = hivothers;
	}

	public Long getSyphilisNegative() {
		return this.syphilisNegative;
	}

	public void setSyphilisNegative(Long syphilisNegative) {
		this.syphilisNegative = syphilisNegative;
	}

	public Long getSyphilisMasculine() {
		return this.syphilisMasculine;
	}

	public void setSyphilisMasculine(Long syphilisMasculine) {
		this.syphilisMasculine = syphilisMasculine;
	}

	public Long getSyphilisOthers() {
		return this.syphilisOthers;
	}

	public void setSyphilisOthers(Long syphilisOthers) {
		this.syphilisOthers = syphilisOthers;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupDate() {
		return this.groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public String getOptPersonId() {
		return this.optPersonId;
	}

	public void setOptPersonId(String optPersonId) {
		this.optPersonId = optPersonId;
	}

}