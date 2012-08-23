package cn.net.tongfang.framework.security.vo;

/**
 * SamRoleModule entity. @author MyEclipse Persistence Tools
 */

public class SamRoleModule implements java.io.Serializable {

	// Fields

	private SamRoleModuleId id;

	// Constructors

	/** default constructor */
	public SamRoleModule() {
	}

	/** full constructor */
	public SamRoleModule(SamRoleModuleId id) {
		this.id = id;
	}

	// Property accessors

	public SamRoleModuleId getId() {
		return this.id;
	}

	public void setId(SamRoleModuleId id) {
		this.id = id;
	}

}