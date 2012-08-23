package cn.net.tongfang.framework.security.vo;

/**
 * SamModule entity. @author MyEclipse Persistence Tools
 */

public class SamModule {

	// Fields

	private String id;
	private String name;
	private String categoryId;
	private String url;
	private Integer ordinal;
	private String clsSetting;
	private SamModuleCategory category;
	private boolean isNavigate;
	private String inputPage;
	private Integer type;
	// Constructors

	/** default constructor */
	public SamModule() {
	}

	public SamModule(String id, String name, String categoryId, String url,
			Integer ordinal, String clsSetting, boolean isNavigate, String inputPage,Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.url = url;
		this.ordinal = ordinal;
		this.clsSetting = clsSetting;
		this.isNavigate = isNavigate;
		this.inputPage = inputPage;
		this.type = type;
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

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public SamModuleCategory getCategory() {
		return category;
	}

	public void setCategory(SamModuleCategory category) {
		this.category = category;
	}

	public String getClsSetting() {
		return clsSetting;
	}

	public void setClsSetting(String clsSetting) {
		this.clsSetting = clsSetting;
	}

	public boolean getIsNavigate() {
		return isNavigate;
	}

	public void setIsNavigate(boolean isNavigate) {
		this.isNavigate = isNavigate;
	}

	public String getInputPage() {
		return inputPage;
	}

	public void setInputPage(String inputPage) {
		this.inputPage = inputPage;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}