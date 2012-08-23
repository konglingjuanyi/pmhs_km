package cn.net.tongfang.framework.security;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;

public class SecurityManager {

	public final static SecurityContext currentSecurityContext() {
		SecurityContext context = SecurityContextHolder.getContext();
		return context;
	}
	
	/**
	 * Get current operator
	 * 
	 * @return current operator <p> if not exist, return null 
	 * 
	 */
	public final static TaxempDetail currentOperator() {
		TaxempDetail operator = null;
		Authentication auth = currentSecurityContext().getAuthentication();
		System.out.println( "auth is " + auth );
		
		if ( auth != null && auth.getPrincipal() != null) {
			Object principal = auth.getPrincipal();
			if ( principal instanceof TaxempDetail ) {
				operator = (TaxempDetail) principal;
			}
		}
		return operator;
	}
	
	
	
}
