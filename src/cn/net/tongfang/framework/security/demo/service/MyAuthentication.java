package cn.net.tongfang.framework.security.demo.service;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.adapters.AbstractAdapterAuthenticationToken;

import cn.net.tongfang.framework.security.SecurityService;

public class MyAuthentication extends AbstractAdapterAuthenticationToken {

	private SecurityService securityService;
    private String password;
    private String username;
    
    
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return password;
	}

	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return username;
		
	}

	@Override
	public GrantedAuthority[] getAuthorities() {

		GrantedAuthority ga = new GrantedAuthorityImpl("ROLE_TELLER");
		
		return new GrantedAuthority[]{ga};
		
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


	/**
	 * Set securityService
	 * @param securityService
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}
	
	
	

}
