package cn.net.tongfang.framework.security.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.SamTaxempcode;

public class UserInfo {

	private SamTaxempcode user;

	private List roles;

	public UserInfo() {
		super();
	}

	public UserInfo(SamTaxempcode user) {
		super();
		this.user = user;
	}

	public UserInfo(SamTaxempcode user, List roles) {
		super();
		this.user = user;
		this.roles = roles;
	}

	public SamTaxempcode getUser() {
		return user;
	}

	public void setUser(SamTaxempcode user) {
		this.user = user;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

}
