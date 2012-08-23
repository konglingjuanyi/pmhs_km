package cn.net.tongfang.framework.security.vo;

/**
 * Producers entity. @author MyEclipse Persistence Tools
 */

public class Producers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String companyId;
	private String name;
	private String companyName;
	private Integer isEnabled;

	// Constructors

	/** default constructor */
	public Producers() {
	}

	/** full constructor */
	public Producers(Integer id, String companyId, String name,
			String companyName, Integer isEnabled) {
		this.id = id;
		this.companyId = companyId;
		this.name = name;
		this.companyName = companyName;
		this.isEnabled = isEnabled;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

}