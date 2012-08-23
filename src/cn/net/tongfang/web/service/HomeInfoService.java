package cn.net.tongfang.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.HomeInfo;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.service.ModuleMgr;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.HomeInfoBO;
import cn.net.tongfang.web.util.BOHelper;
import cn.net.tongfang.web.util.HomeNoGen;

public class HomeInfoService extends HibernateDaoSupport{
	private static final Logger log = Logger.getLogger(PersonalInfoService.class);
	
	private HomeNoGen homeNoGen;
	private ModuleMgr mgr;
	public void setMgr(ModuleMgr mgr) {
		this.mgr = mgr;
	}

	public void setHomeNoGen(HomeNoGen homeNoGen) {
		this.homeNoGen = homeNoGen;
	}

	BOHelper boHelper = new BOHelper(HomeInfoBO.class);
	
	
	
	/**
	 * 新增户籍信息
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public synchronized String save(HomeInfoBO data) throws Exception{
		
		// save routine
		String id = data.getHomeId();
		if(id.length() == 16){
			System.out.println("updating...");
			return update(data);
		}
		log.debug("save HomeInfo...");
		String disNo = data.getDistrictNumber();
		if (disNo == null || disNo.trim().equals("")) {
			throw new RuntimeException("no districtNum!!!");
		}
		
		String homeId = disNo + id;
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		
		HomeInfo home = new HomeInfo();
		BeanUtils.copyProperties(data, home); // spring beanutils
		home.setHomeId(homeId);
		home.setBuildPersonId(user.getUsername());
		java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		home.setBuildDate(ts);
		home.setUpdateDate(ts);
		try{
			getHibernateTemplate().save(home);
		}catch(Exception ex){
			throw new RuntimeException("家庭编号已经存在!!!");
		}
		log.debug("save successed!");
		return homeId;
	}
	
	/**
	 * 删除家庭成员信息
	 * @param fileNoList
	 */
	public void removeModules(String modules) {
		if (!StringUtils.hasText(modules))
			return;
		
		List<String> list = new ArrayList<String>();
		String[] ids = modules.split(",");
		for(String id : ids){
			list.add(id);
		}
		mgr.removeHealthFiles(list);
	}
	
	/**
	 * 获得家庭成员的档案信息
	 * @param data
	 * @param pp
	 * @return
	 * @throws Exception
	 */
	public  PagingResult<HealthFile> getHealthFile(HomeInfoBO data,PagingParam pp) throws Exception{
		String id = data.getId();
		List params = new ArrayList();
		params.add(id);
		StringBuilder hql = new StringBuilder("from HealthFile a,PersonalInfo b,HomeInfo c ")
			.append("where c.homeId = ? ").append(" and a.fileNo = b.fileNo and ")
			.append("b.homeId = c.homeId order by c.homeId DESC");
		PagingResult<HealthFile> result = mgr.queryHealthFiles(pp, params, hql);
		return result;
	}
	
	/**
	 * 获得户籍信息
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public HomeInfo get(HomeInfoBO data) throws Exception{
		String id = data.getHomeId();
		HomeInfo home = new HomeInfo();
		StringBuilder sql = new StringBuilder("from HomeInfo c ").append("where c.homeId = '").append(id).append("'");
		Query q = getSession().createQuery(sql.toString());
		List list = q.list();
			home = (HomeInfo)list.get(0);
//		}
		return home;
	}
	
	/**
	 * 更新户籍信息
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String update(HomeInfoBO data) throws Exception{
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		
		HomeInfo home = new HomeInfo();
		BeanUtils.copyProperties(data, home);
		java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		
		home.setUpdateDate(ts);
		getHibernateTemplate().update(home);
		
		
		return home.getHomeId();
	}
	
	/**
	 * 将健康档案信息指定到户
	 * @param homeId
	 * @param fileNo
	 * @return
	 */
	public String saveToHome(String homeId,String fileNo){
		String sqlQueryHomeId = "from PersonalInfo where FileNo = \'" + fileNo + "\'";
		Query query;
		query = getSession().createQuery(sqlQueryHomeId);
		PersonalInfo obj = (PersonalInfo)query.uniqueResult();
		if(obj.getHomeId() == null || obj.getHomeId().equals("")){
			String sql = "update PersonalInfo set HomeID = \'" + homeId + "\' where FileNo = \'" + fileNo + "\'";
			query = getSession().createQuery(sql);
			return String.valueOf(query.executeUpdate());
		}
		String sqlQueryHome = "from HomeInfo where HomeID = \'" + obj.getHomeId() + "\'";
		query = getSession().createQuery(sqlQueryHome);
		HomeInfo home = (HomeInfo)query.uniqueResult();
		return home.getHomeId() + "," + home.getHousehold();
	}
	
	/**
	 * 从户移除档档案信息
	 * @param homeId
	 * @param fileNo
	 * @return 0表示成功，-1表示档案还没有添加到户，-2代表该档案不是此户的档案，-3表示更新失败
	 */
	public int delFromHome(String homeId,String fileNo){
		String sqlQueryHomeId = "from PersonalInfo where FileNo = \'" + fileNo + "\'";
		Query query;
		query = getSession().createQuery(sqlQueryHomeId);
		PersonalInfo obj = (PersonalInfo)query.uniqueResult();
		String id = obj.getHomeId();
		if(id != null && !id.equals("")){
			if(id.equals(homeId)){
				String sql = "update PersonalInfo set HomeID = \'\' where FileNo = \'" + fileNo + "\'";
				query = getSession().createQuery(sql);
				int i = query.executeUpdate();
				if(i >= 1)
					return 0;
				else
					return -3;
			}else{
				return -2;
			}
		}
		return -1;
	}
}
