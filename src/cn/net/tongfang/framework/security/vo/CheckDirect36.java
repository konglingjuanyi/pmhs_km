package cn.net.tongfang.framework.security.vo;

/**
 * CheckDirect36 entity. @author MyEclipse Persistence Tools
 */

public class CheckDirect36 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String childrenMediExam36id;
	private Integer checkDirect36id;

	// Constructors

	/** default constructor */
	public CheckDirect36() {
	}

	/** full constructor */
	public CheckDirect36(String id, String childrenMediExam36id,
			Integer checkDirect36id) {
		this.id = id;
		this.childrenMediExam36id = childrenMediExam36id;
		this.checkDirect36id = checkDirect36id;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChildrenMediExam36id() {
		return this.childrenMediExam36id;
	}

	public void setChildrenMediExam36id(String childrenMediExam36id) {
		this.childrenMediExam36id = childrenMediExam36id;
	}

	public Integer getCheckDirect36id() {
		return this.checkDirect36id;
	}

	public void setCheckDirect36id(Integer checkDirect36id) {
		this.checkDirect36id = checkDirect36id;
	}

}