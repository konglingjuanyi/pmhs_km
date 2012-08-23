package cn.net.tongfang.framework.security.vo;

/**
 * SamTaxempcodeRole entity. @author MyEclipse Persistence Tools
 */

public class SamTaxempcodeRole implements java.io.Serializable {

	// Fields

	private SamTaxempcodeRoleId id;

	// Constructors

	/** default constructor */
	public SamTaxempcodeRole() {
	}

	/** full constructor */
	public SamTaxempcodeRole(SamTaxempcodeRoleId id) {
		this.id = id;
	}

	// Property accessors

	public SamTaxempcodeRoleId getId() {
		return this.id;
	}

	public void setId(SamTaxempcodeRoleId id) {
		this.id = id;
	}

}