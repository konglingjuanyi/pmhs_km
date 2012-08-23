package cn.net.tongfang.framework.security.vo;

/**
 * SamRole entity. @author MyEclipse Persistence Tools
 */

public class SamRole implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String descr;

	// Constructors

	/** default constructor */
	public SamRole() {
	}

	/** minimal constructor */
	public SamRole(String id) {
		this.id = id;
	}

	/** full constructor */
	public SamRole(String id, String name, String descr) {
		this.id = id;
		this.name = name;
		this.descr = descr;
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

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}