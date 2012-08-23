package cn.net.tongfang.framework.security.vo;

/**
 * ResidentPopulation entity. @author MyEclipse Persistence Tools
 */

public class ResidentPopulation implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String years;
	private Long populationNumber;
	private Long townNumber;
	private Long farmNumber;
	private Integer orgId;

	// Constructors

	/** default constructor */
	public ResidentPopulation() {
	}

	/** full constructor */
	public ResidentPopulation(String id, String name, String years,
			Long populationNumber, Long townNumber, Long farmNumber,
			Integer orgId) {
		this.id = id;
		this.name = name;
		this.years = years;
		this.populationNumber = populationNumber;
		this.townNumber = townNumber;
		this.farmNumber = farmNumber;
		this.orgId = orgId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYears() {
		return this.years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Long getPopulationNumber() {
		return this.populationNumber;
	}

	public void setPopulationNumber(Long populationNumber) {
		this.populationNumber = populationNumber;
	}

	public Long getTownNumber() {
		return this.townNumber;
	}

	public void setTownNumber(Long townNumber) {
		this.townNumber = townNumber;
	}

	public Long getFarmNumber() {
		return this.farmNumber;
	}

	public void setFarmNumber(Long farmNumber) {
		this.farmNumber = farmNumber;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}


}