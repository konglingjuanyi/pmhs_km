package cn.net.tongfang.framework.security.vo;

/**
 * PersonalHistory entity. @author MyEclipse Persistence Tools
 */

public class PersonalHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstVistBeforeBornId;
	private Integer personalHistoryId;

	// Constructors

	/** default constructor */
	public PersonalHistory() {
	}

	/** full constructor */
	public PersonalHistory(String id, String firstVistBeforeBornId,
			Integer personalHistoryId) {
		this.id = id;
		this.firstVistBeforeBornId = firstVistBeforeBornId;
		this.personalHistoryId = personalHistoryId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstVistBeforeBornId() {
		return this.firstVistBeforeBornId;
	}

	public void setFirstVistBeforeBornId(String firstVistBeforeBornId) {
		this.firstVistBeforeBornId = firstVistBeforeBornId;
	}

	public Integer getPersonalHistoryId() {
		return this.personalHistoryId;
	}

	public void setPersonalHistoryId(Integer personalHistoryId) {
		this.personalHistoryId = personalHistoryId;
	}

}