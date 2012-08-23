package cn.net.tongfang.framework.security.vo;

/**
 * ExposeHistory entity. @author MyEclipse Persistence Tools
 */

public class ExposeHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String personalInfoId;
	private Integer exposeId;

	// Constructors

	/** default constructor */
	public ExposeHistory() {
	}

	/** full constructor */
	public ExposeHistory(String id, String personalInfoId, Integer exposeId) {
		this.id = id;
		this.personalInfoId = personalInfoId;
		this.exposeId = exposeId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonalInfoId() {
		return this.personalInfoId;
	}

	public void setPersonalInfoId(String personalInfoId) {
		this.personalInfoId = personalInfoId;
	}

	public Integer getExposeId() {
		return this.exposeId;
	}

	public void setExposeId(Integer exposeId) {
		this.exposeId = exposeId;
	}

}