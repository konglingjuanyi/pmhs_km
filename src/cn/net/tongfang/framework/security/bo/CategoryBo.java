package cn.net.tongfang.framework.security.bo;

public class CategoryBo {
	private String id;
	private String name;
	
	
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
	
	@Override
	public String toString() {
		String s = "name:["+name+"]";
		return s;
	}
}
