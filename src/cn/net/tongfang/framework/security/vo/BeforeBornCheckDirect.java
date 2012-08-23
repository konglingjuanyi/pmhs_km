package cn.net.tongfang.framework.security.vo;

/**
 * BeforeBornCheckDirect entity. @author MyEclipse Persistence Tools
 */

public class BeforeBornCheckDirect implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstVistBeforeBornId;
	private Integer beforeBornCheckDirectId;

	// Constructors

	/** default constructor */
	public BeforeBornCheckDirect() {
	}

	/** full constructor */
	public BeforeBornCheckDirect(String id, String firstVistBeforeBornId,
			Integer beforeBornCheckDirectId) {
		this.id = id;
		this.firstVistBeforeBornId = firstVistBeforeBornId;
		this.beforeBornCheckDirectId = beforeBornCheckDirectId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstVistBeforeBornId() {
		return this.firstVistBeforeBornId;
	}

	public void setFirstVistBeforeBornId(String firstVistBeforeBornId) {
		this.firstVistBeforeBornId = firstVistBeforeBornId;
	}

	public Integer getBeforeBornCheckDirectId() {
		return this.beforeBornCheckDirectId;
	}

	public void setBeforeBornCheckDirectId(Integer beforeBornCheckDirectId) {
		this.beforeBornCheckDirectId = beforeBornCheckDirectId;
	}

}