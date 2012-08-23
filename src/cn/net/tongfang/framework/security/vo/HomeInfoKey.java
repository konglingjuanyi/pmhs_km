package cn.net.tongfang.framework.security.vo;

/**
 * HomeInfoKey entity. @author MyEclipse Persistence Tools
 */

public class HomeInfoKey implements java.io.Serializable {

	// Fields

	private String districtNumber;
	private Integer maxKey;

	// Constructors

	/** default constructor */
	public HomeInfoKey() {
	}

	/** full constructor */
	public HomeInfoKey(String districtNumber, Integer maxKey) {
		this.districtNumber = districtNumber;
		this.maxKey = maxKey;
	}

	// Property accessors

	public String getDistrictNumber() {
		return this.districtNumber;
	}

	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}

	public Integer getMaxKey() {
		return this.maxKey;
	}

	public void setMaxKey(Integer maxKey) {
		this.maxKey = maxKey;
	}

}