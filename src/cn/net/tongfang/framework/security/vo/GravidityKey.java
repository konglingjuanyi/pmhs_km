package cn.net.tongfang.framework.security.vo;

/**
 * GravidityKey entity. @author MyEclipse Persistence Tools
 */

public class GravidityKey implements java.io.Serializable {

	// Fields

	private String id;
	private String fileNo;
	private Integer currentGravidity;

	// Constructors

	/** default constructor */
	public GravidityKey() {
	}

	/** full constructor */
	public GravidityKey(String fileNo, Integer currentGravidity) {
		this.fileNo = fileNo;
		this.currentGravidity = currentGravidity;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Integer getCurrentGravidity() {
		return this.currentGravidity;
	}

	public void setCurrentGravidity(Integer currentGravidity) {
		this.currentGravidity = currentGravidity;
	}

}