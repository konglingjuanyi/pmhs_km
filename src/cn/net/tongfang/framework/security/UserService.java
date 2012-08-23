package cn.net.tongfang.framework.security;

import java.util.List;

import cn.net.tongfang.framework.security.bo.UserCond;
import cn.net.tongfang.framework.security.bo.UserInfo;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;




public interface UserService {

	PagingResult<UserInfo> findUsers(UserCond qry, PagingParam pp);
	
	PagingResult<UserInfo> findAllUsers(PagingParam pp);
	
	
	void saveUser(UserInfo userInfo);
	void saveNewUser(UserInfo userInfo);
	
	List findRoles(String loginname);
	List findAllRoles();
	List findOtherRoles(String loginname);
	
	TaxempDetail getCurrentUser();
	
	public boolean modifyPassword(String oldPwd,String newPwd);
}
