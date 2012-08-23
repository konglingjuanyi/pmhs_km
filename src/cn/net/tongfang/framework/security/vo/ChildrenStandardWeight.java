package cn.net.tongfang.framework.security.vo;

/**
 * ChildrenStandardWeight entity. @author MyEclipse Persistence Tools
 */

public class ChildrenStandardWeight implements java.io.Serializable {

	// Fields

	private String id;
	private String sex;
	private String ageGroup;
	private Integer minMonth;
	private Integer maxMonth;
	private Double s;
	private Double sub2s;
	private Double sub1s;
	private Double avg;
	private Double add1s;
	private Double add2s;

	// Constructors

	/** default constructor */
	public ChildrenStandardWeight() {
	}

	/** full constructor */
	public ChildrenStandardWeight(String id, String sex, String ageGroup,
			Integer minMonth, Integer maxMonth, Double s, Double sub2s,
			Double sub1s, Double avg, Double add1s, Double add2s) {
		super();
		this.id = id;
		this.sex = sex;
		this.ageGroup = ageGroup;
		this.minMonth = minMonth;
		this.maxMonth = maxMonth;
		this.s = s;
		this.sub2s = sub2s;
		this.sub1s = sub1s;
		this.avg = avg;
		this.add1s = add1s;
		this.add2s = add2s;
	}
	// Property accessors

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAgeGroup() {
		return this.ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Double getS() {
		return this.s;
	}

	public void setS(Double s) {
		this.s = s;
	}

	public Double getSub2s() {
		return this.sub2s;
	}

	public void setSub2s(Double sub2s) {
		this.sub2s = sub2s;
	}

	public Double getSub1s() {
		return this.sub1s;
	}

	public void setSub1s(Double sub1s) {
		this.sub1s = sub1s;
	}

	public Double getAvg() {
		return this.avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getAdd1s() {
		return this.add1s;
	}

	public void setAdd1s(Double add1s) {
		this.add1s = add1s;
	}

	public Double getAdd2s() {
		return this.add2s;
	}

	public void setAdd2s(Double add2s) {
		this.add2s = add2s;
	}

	public Integer getMinMonth() {
		return minMonth;
	}

	public void setMinMonth(Integer minMonth) {
		this.minMonth = minMonth;
	}

	public Integer getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(Integer maxMonth) {
		this.maxMonth = maxMonth;
	}

}