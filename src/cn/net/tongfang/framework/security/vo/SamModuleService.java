package cn.net.tongfang.framework.security.vo;

/**
 * SamModuleService entity. @author MyEclipse Persistence Tools
 */

public class SamModuleService implements java.io.Serializable {

	// Fields

	private SamModuleServiceId id;

	// Constructors

	/** default constructor */
	public SamModuleService() {
	}

	/** full constructor */
	public SamModuleService(SamModuleServiceId id) {
		this.id = id;
	}

	// Property accessors

	public SamModuleServiceId getId() {
		return this.id;
	}

	public void setId(SamModuleServiceId id) {
		this.id = id;
	}

}