package cn.net.tongfang.framework.security.vo;

/**
 * SamTaxempcodeRoleId entity. @author MyEclipse Persistence Tools
 */

public class SamTaxempcodeRoleId implements java.io.Serializable {

	// Fields

	private String loginname;
	private String id;

	// Constructors

	/** default constructor */
	public SamTaxempcodeRoleId() {
	}

	/** full constructor */
	public SamTaxempcodeRoleId(String loginname, String id) {
		this.loginname = loginname;
		this.id = id;
	}

	// Property accessors

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SamTaxempcodeRoleId))
			return false;
		SamTaxempcodeRoleId castOther = (SamTaxempcodeRoleId) other;

		return ((this.getLoginname() == castOther.getLoginname()) || (this
				.getLoginname() != null
				&& castOther.getLoginname() != null && this.getLoginname()
				.equals(castOther.getLoginname())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLoginname() == null ? 0 : this.getLoginname().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

}