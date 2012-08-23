package cn.net.tongfang.framework.security.vo;

/**
 * SamModuleCategory entity. @author MyEclipse Persistence Tools
 */

public class SamModuleCategory {

	// Fields

	private String id;
	private String name;
	private Integer displayOrder;
	private String clsSetting;
	// Constructors

	/** default constructor */
	public SamModuleCategory() {
	}

	/** full constructor */
	public SamModuleCategory(String name, Integer displayOrder,String clsSetting) {
		this.name = name;
		this.displayOrder = displayOrder;
		this.clsSetting = clsSetting;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getClsSetting() {
		return clsSetting;
	}

	public void setClsSetting(String clsSetting) {
		this.clsSetting = clsSetting;
	}

	
}