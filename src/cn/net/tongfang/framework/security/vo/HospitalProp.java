package cn.net.tongfang.framework.security.vo;

/**
 * HospitalProp entity. @author MyEclipse Persistence Tools
 */

public class HospitalProp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String relatedName;

	// Constructors

	/** default constructor */
	public HospitalProp() {
	}

	/** full constructor */
	public HospitalProp(String name, String relatedName) {
		this.name = name;
		this.relatedName = relatedName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelatedName() {
		return this.relatedName;
	}

	public void setRelatedName(String relatedName) {
		this.relatedName = relatedName;
	}

}