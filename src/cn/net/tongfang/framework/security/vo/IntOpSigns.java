package cn.net.tongfang.framework.security.vo;

/**
 * IntOpSigns entity. @author MyEclipse Persistence Tools
 */

public class IntOpSigns implements java.io.Serializable {

	// Fields

	private String id;
	private String intKey;
	private String opKey;
	private String signsId;
	private String signsName;
	private String signsValue;
	private String signsUnit;

	// Constructors

	/** default constructor */
	public IntOpSigns() {
	}

	/** minimal constructor */
	public IntOpSigns(String intKey, String opKey) {
		this.intKey = intKey;
		this.opKey = opKey;
	}

	/** full constructor */
	public IntOpSigns(String intKey, String opKey, String signsId,
			String signsName, String signsValue, String signsUnit) {
		this.intKey = intKey;
		this.opKey = opKey;
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

	public String getOpKey() {
		return this.opKey;
	}

	public void setOpKey(String opKey) {
		this.opKey = opKey;
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