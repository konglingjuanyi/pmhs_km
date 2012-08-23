package cn.net.tongfang.framework.security.bo;

public class ModuleBo {

	private String id;
	private String name;
	private String categoryId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		String s = "name:["+name+"]";
		return s;
	}
}
