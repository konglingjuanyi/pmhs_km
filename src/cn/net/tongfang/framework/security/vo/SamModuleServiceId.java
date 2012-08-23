package cn.net.tongfang.framework.security.vo;

/**
 * SamModuleServiceId entity. @author MyEclipse Persistence Tools
 */

public class SamModuleServiceId implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String serviceId;

	// Constructors

	/** default constructor */
	public SamModuleServiceId() {
	}

	/** full constructor */
	public SamModuleServiceId(String moduleId, String serviceId) {
		this.moduleId = moduleId;
		this.serviceId = serviceId;
	}

	// Property accessors

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SamModuleServiceId))
			return false;
		SamModuleServiceId castOther = (SamModuleServiceId) other;

		return ((this.getModuleId() == castOther.getModuleId()) || (this
				.getModuleId() != null
				&& castOther.getModuleId() != null && this.getModuleId()
				.equals(castOther.getModuleId())))
				&& ((this.getServiceId() == castOther.getServiceId()) || (this
						.getServiceId() != null
						&& castOther.getServiceId() != null && this
						.getServiceId().equals(castOther.getServiceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getModuleId() == null ? 0 : this.getModuleId().hashCode());
		result = 37 * result
				+ (getServiceId() == null ? 0 : this.getServiceId().hashCode());
		return result;
	}

}