package cn.net.tongfang.framework.security.vo;

/**
 * ChildrenMediExamExam09 entity. @author MyEclipse Persistence Tools
 */

public class ChildrenMediExamExam09 implements java.io.Serializable {

	// Fields

	private String id;
	private String childrenMediExamId;
	private Integer childrenMediExamExam09id;

	// Constructors

	/** default constructor */
	public ChildrenMediExamExam09() {
	}

	/** full constructor */
	public ChildrenMediExamExam09(String childrenMediExamId,
			Integer childrenMediExamExam09id) {
		this.childrenMediExamId = childrenMediExamId;
		this.childrenMediExamExam09id = childrenMediExamExam09id;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChildrenMediExamId() {
		return this.childrenMediExamId;
	}

	public void setChildrenMediExamId(String childrenMediExamId) {
		this.childrenMediExamId = childrenMediExamId;
	}

	public Integer getChildrenMediExamExam09id() {
		return this.childrenMediExamExam09id;
	}

	public void setChildrenMediExamExam09id(Integer childrenMediExamExam09id) {
		this.childrenMediExamExam09id = childrenMediExamExam09id;
	}

}