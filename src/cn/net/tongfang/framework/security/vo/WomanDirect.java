package cn.net.tongfang.framework.security.vo;

/**
 * WomanDirect entity. @author MyEclipse Persistence Tools
 */

public class WomanDirect implements java.io.Serializable {

	// Fields

	private Integer id;
	private String remarks;
	private Integer type;
	private String property;
	private String age;

	// Constructors

	/** default constructor */
	public WomanDirect() {
	}

	/** full constructor */
	public WomanDirect(String remarks, Integer type, String property, String age) {
		this.remarks = remarks;
		this.type = type;
		this.property = property;
		this.age = age;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}