package cn.net.tongfang.framework.security.vo;

// Generated by Hibernate Tools 3.2.4.GA

/**
 * AfterBornDirect generated by hbm2java
 */
public class AfterBornDirect implements java.io.Serializable {

	private String id;
	private String visitAfterBornId;
	private Integer afterBornDirectId;

	public AfterBornDirect() {
	}

	public AfterBornDirect(String visitAfterBornId, Integer afterBornDirectId) {
		this.visitAfterBornId = visitAfterBornId;
		this.afterBornDirectId = afterBornDirectId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVisitAfterBornId() {
		return this.visitAfterBornId;
	}

	public void setVisitAfterBornId(String visitAfterBornId) {
		this.visitAfterBornId = visitAfterBornId;
	}

	public Integer getAfterBornDirectId() {
		return this.afterBornDirectId;
	}

	public void setAfterBornDirectId(Integer afterBornDirectId) {
		this.afterBornDirectId = afterBornDirectId;
	}

}
