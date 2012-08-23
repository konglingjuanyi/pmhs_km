package cn.net.tongfang.framework.security.vo;

/**
 * IntIpSigns entity. @author MyEclipse Persistence Tools
 */

public class IntIpSigns implements java.io.Serializable {

	// Fields

	private String id;
	private String intKey;
	private String ipKey;
	private String signsId;
	private String signsName;
	private String signsValue;
	private String signsUnit;

	// Constructors

	/** default constructor */
	public IntIpSigns() {
	}

	/** minimal constructor */
	public IntIpSigns(String intKey, String ipKey) {
		this.intKey = intKey;
		this.ipKey = ipKey;
	}

	/** full constructor */
	public IntIpSigns(String intKey, String ipKey, String signsId,
			String signsName, String signsValue, String signsUnit) {
		this.intKey = intKey;
		this.ipKey = ipKey;
		this.signsId = signsId;
		this.signsName = signsName;
		this.signsValue = signsValue;
		this.signsUnit = signsUnit;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntKey() {
		return this.intKey;
	}

	public void setIntKey(String intKey) {
		this.intKey = intKey;
	}

	public String getIpKey() {
		return this.ipKey;
	}

	public void setIpKey(String ipKey) {
		this.ipKey = ipKey;
	}

	public String getSignsId() {
		return this.signsId;
	}

	public void setSignsId(String signsId) {
		this.signsId = signsId;
	}

	public String getSignsName() {
		return this.signsName;
	}

	public void setSignsName(String signsName) {
		this.signsName = signsName;
	}

	public String getSignsValue() {
		return this.signsValue;
	}

	public void setSignsValue(String signsValue) {
		this.signsValue = signsValue;
	}

	public String getSignsUnit() {
		return this.signsUnit;
	}

	public void setSignsUnit(String signsUnit) {
		this.signsUnit = signsUnit;
	}

}