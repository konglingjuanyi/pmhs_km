package cn.net.tongfang.framework.security.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.SpringSecurityMessageSource;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import cn.net.tongfang.framework.security.SecurityService;
import cn.net.tongfang.framework.security.bo.ModuleBo;
import cn.net.tongfang.framework.security.bo.OperatorBo;


public class MyUserDetailsServiceImpl implements UserDetailsService {

	Logger log = Logger.getLogger(MyUserDetailsServiceImpl.class);
	
	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	protected SecurityService securityService;
	protected ControlVersion controlVersion;
	
	public void setControlVersion(ControlVersion controlVersion) {
		this.controlVersion = controlVersion;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println("==="+controlVersion.control());
//		if(!controlVersion.control())
//			return null;
		
		log.debug("load user by username[" + username + "]");
		
		OperatorBo operatorBo = securityService.getOperatorByUsername(username);
		
		if ( operatorBo == null || "0".equals(operatorBo.getValidFlag()) ) {
			throw new UsernameNotFoundException(
                    messages.getMessage("securityService.notFound", new Object[]{username}, "Username {0} not found"), username);
		}
		
        String password = operatorBo.getPassword();
        
		boolean enabled = true;
		
		//GrantedAuthority[] combinedAuthorities = new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_TELLER")};
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		List<ModuleBo> modules = operatorBo.getModules();
		
		//处理用户没有关联模块的情况
		if ( modules != null ) {
			for (ModuleBo moduleBo : modules) {
				String mm = moduleBo.getId();
				GrantedAuthority grant = new GrantedAuthorityImpl(mm);
				grantList.add(grant);
			}
		}
		GrantedAuthority[] combinedAuthorities = grantList.toArray(new GrantedAuthority[grantList.size()]);
		//edit by Daved 2009-03-17
//		return new User(username, password,enabled,true, true, true, combinedAuthorities);
		return new TaxempDetail(operatorBo.getId(), operatorBo.getUsername(), operatorBo.getPassword(), operatorBo.getDistrict(), operatorBo.getOrg(), operatorBo.getOrgId(), operatorBo.getDistrictId(), enabled, combinedAuthorities,operatorBo.getIsLookAuthority());
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

}
