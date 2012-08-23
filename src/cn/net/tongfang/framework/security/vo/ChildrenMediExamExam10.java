package cn.net.tongfang.framework.security.vo;

/**
 * ChildrenMediExamExam10 entity. @author MyEclipse Persistence Tools
 */

public class ChildrenMediExamExam10 implements java.io.Serializable {

	// Fields

	private String id;
	private String childrenMediExamId;
	private Integer childrenMediExamExam10id;

	// Constructors

	/** default constructor */
	public ChildrenMediExamExam10() {
	}

	/** full constructor */
	public ChildrenMediExamExam10(String childrenMediExamId,
			Integer childrenMediExamExam10id) {
		this.childrenMediExamId = childrenMediExamId;
		this.childrenMediExamExam10id = childrenMediExamExam10id;
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

	public Integer getChildrenMediExamExam10id() {
		return this.childrenMediExamExam10id;
	}

	public void setChildrenMediExamExam10id(Integer childrenMediExamExam10id) {
		this.childrenMediExamExam10id = childrenMediExamExam10id;
	}

}