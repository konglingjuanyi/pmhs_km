package cn.net.tongfang.framework.security;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.providers.encoding.MessageDigestPasswordEncoder;

import cn.net.tongfang.framework.security.bo.UserCond;
import cn.net.tongfang.framework.security.bo.UserInfo;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;
import cn.net.tongfang.framework.security.vo.SamTaxempcodeRole;
import cn.net.tongfang.framework.security.vo.SamTaxempcodeRoleId;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;


/**
 * @author Jack
 *
 */
public class UserServiceImpl extends HibernateDaoSupport implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public PagingResult<UserInfo> findUsers(UserCond qry, PagingParam pp) {
		logger.debug("call findUsers()");
		String loginname = null;
		if ( qry != null )
			loginname = qry.getLoginname().trim();
		
		if ( pp == null ) pp = new PagingParam();
		
		int end = pp.getStart() + pp.getLimit();
		
		List params = new ArrayList();
		
		String orderBy = " order by u.loginname";
		
		String sql = "select new cn.net.tongfang.framework.security.bo.UserInfo(u) from SamTaxempcode u ";
		StringBuffer hql = new StringBuffer(sql);
		StringBuffer cond = new StringBuffer();
		if ( loginname != null && ! loginname.trim().equals("")) {
			cond.append( " u.loginname like ? " );
			params.add("%" + loginname.trim() + "%");
		}
		if ( params.size() > 0 ) {
			hql.append(" where ").append( cond );
		}
		hql.append( orderBy );
		
		List list;
		if ( params.size() > 0 ) {
			list = getHibernateTemplate().find(hql.toString(), params.toArray());
		} else {
			list = getHibernateTemplate().find(hql.toString());
		}
		
		end = (end < list.size()) ? end : list.size();
		List<UserInfo> result = list.subList(pp.getStart(), end);
		
		return new PagingResult<UserInfo>(list.size(), result);
	}

	public PagingResult<UserInfo> findAllUsers(PagingParam pp) {
		
		return findUsers(null, pp);
	}

	/**
	 * md5加密密码
	 * @param password
	 * @return
	 */
	private String md5(String password){
		MessageDigestPasswordEncoder mdpeMd5 = new MessageDigestPasswordEncoder("MD5");
		mdpeMd5.setEncodeHashAsBase64(false);
		return mdpeMd5.encodePassword(password, null);
	}
	
	public void saveUser(UserInfo userInfo) {
		if ( userInfo == null ) return;
		
		SamTaxempcode user = userInfo.getUser();
		if ( user == null ) return;
		
		//TODO: only modify user, if user PK is null, then return
		String loginname = user.getLoginname();
		if (loginname == null || loginname.trim().equals("")) return;

		SamTaxempcode oriUser = (SamTaxempcode) getHibernateTemplate().get(SamTaxempcode.class, loginname);
		getHibernateTemplate().evict(oriUser);
		String password = user.getPassword();
		if ( password == null || password.trim().equals("")) {
			//keep original password
			user.setPassword(oriUser.getPassword());
		}else{
			user.setPassword(md5(user.getPassword()));
		}
		user.setCreateDate( oriUser.getCreateDate() );
//		user.setOrgId( oriUser.getOrgId());

		//save user
		logger.debug( "update user: " + user.getLoginname() );
		getHibernateTemplate().update( user );
		
		
		saveRoles(userInfo, loginname);
	}
	
	

	
	public void saveNewUser(UserInfo userInfo) {
		if ( userInfo == null ) return;
		
		SamTaxempcode user = userInfo.getUser();
		if ( user == null ) return;
		
		user.setCreateDate( new Timestamp(System.currentTimeMillis()));
//		user.setTaxorgcode( "" );
		
		//save user
		logger.debug( "save user: " + user.getLoginname() );
		user.setPassword(md5(user.getPassword()));
		getHibernateTemplate().save( user );
		
		String loginname = user.getLoginname();
		
		saveRoles(userInfo, loginname);
	}



	private void saveRoles(UserInfo userInfo, String loginname) {
		//handle roles
		List roles = userInfo.getRoles();
		if ( roles != null && roles.size() != 0 ) {
			
			//如果设置了对应的角色，则mapping他们
			logger.debug("user roles: " + roles.size() );
			
			List userRoleList = new ArrayList();
			
			for (int i = 0; i < roles.size(); i++) {
				String roleId = (String) roles.get(i);
				logger.debug("roleId is " + roleId );
				SamTaxempcodeRole userRole = new SamTaxempcodeRole(new SamTaxempcodeRoleId(loginname,roleId));
				userRoleList . add ( userRole );
			}
			
			List oriUserRole = getHibernateTemplate().find("from SamTaxempcodeRole where id.loginname = ?", loginname);
			getHibernateTemplate().deleteAll(oriUserRole);
			getHibernateTemplate().flush();
			getHibernateTemplate().saveOrUpdateAll(userRoleList);
			
			
		}
	}
	
	
	public List findAllRoles() {
		String hql = "from SamRole r order by r.id";
		List roles = getHibernateTemplate().find(hql);
		
		return roles;
	}

	
	public List findRoles(String loginname) {
		String hql = "select r from SamRole r, SamTaxempcodeRole tr " +
				"where r.id = tr.id.id and tr.id.loginname = ? " +
				"order by r.id";
		List roles = getHibernateTemplate().find(hql, loginname);
		
		return roles;
	}

	
	public List findOtherRoles(String loginname) {
		String hql = "select r from SamRole r " +
				"where r.id not in " +
				"(select tr.id.id from SamTaxempcodeRole tr where tr.id.loginname = ?) " +
				"order by r.id";
		List roles = getHibernateTemplate().find(hql, loginname);
		
		return roles;
	}

	
	public TaxempDetail getCurrentUser() {
		return SecurityManager.currentOperator();
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public boolean modifyPassword(String oldPwd, String newPwd) {
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		if(oldPwd != null && md5(oldPwd).equals(user.getPassword())){
			user.setPassword(md5(newPwd));
			SamTaxempcode samTaxempcode = (SamTaxempcode)getHibernateTemplate().get(SamTaxempcode.class, user.getUsername());
			samTaxempcode.setPassword(md5(newPwd));
			getHibernateTemplate().saveOrUpdate(samTaxempcode);
			return true;
		}
		return false;
	}

	
}
