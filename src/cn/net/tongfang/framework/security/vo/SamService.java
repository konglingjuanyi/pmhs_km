package cn.net.tongfang.framework.security.vo;

/**
 * SamService entity. @author MyEclipse Persistence Tools
 */

public class SamService implements java.io.Serializable {

	// Fields

	private String id;
	private String value;
	private String memo;

	// Constructors

	/** default constructor */
	public SamService() {
	}

	/** minimal constructor */
	public SamService(String value) {
		this.value = value;
	}

	/** full constructor */
	public SamService(String value, String memo) {
		this.value = value;
		this.memo = memo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}