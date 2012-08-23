package cn.net.tongfang.framework.security.demo.service;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.SamTaxorgcode;

public class TaxempDetail implements UserDetails {

    private String password;
    private String username;//对应operatoerbo.loginname
    private GrantedAuthority[] authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Integer isLookAuthority;
    
    //------------扩展业务属性----------
    //用户数据权限
    //暂空
    //用户信息（包括税务机关等信息）
    private String taxempname;
    private Integer orgId;
    private String districtId;
    
	private District district;
	private SamTaxorgcode org;
	
	public TaxempDetail(String loginname, String taxempname, String password,
			District district, SamTaxorgcode org,
			Integer orgId, String districtId, boolean validFlag,
			GrantedAuthority[] authorities,Integer isLookAuthority) {
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.authorities = authorities;
		this.credentialsNonExpired = true;
		this.enabled = true;
		this.password = password;
		this.taxempname = taxempname;
		this.districtId = districtId;
		this.orgId = orgId;
		this.username = loginname;
		this.district = district;
		this.org = org;
		this.isLookAuthority = isLookAuthority;
	}
	public String getTaxempname() {
		return taxempname;
	}
	public void setTaxempname(String taxempname) {
		this.taxempname = taxempname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GrantedAuthority[] getAuthorities() {
		return authorities;
	}
	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public SamTaxorgcode getOrg() {
		return org;
	}
	public void setOrg(SamTaxorgcode org) {
		this.org = org;
	}
	
	public Integer getIsLookAuthority() {
		return isLookAuthority;
	}
	public void setIsLookAuthority(Integer isLookAuthority) {
		this.isLookAuthority = isLookAuthority;
	}
	@Override
	public String toString() {
		String s = "username: "+username+", password: "+password+", authorities: "+authorities+"";
		return s;
	}
	
	
}
