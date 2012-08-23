package cn.net.tongfang.framework.security.demo.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.vo.DwrListVO;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;

public class UserServiceImpl extends HibernateDaoSupport implements UserService {

	Logger log = Logger.getLogger(UserServiceImpl.class);

	@Override
	public boolean findUser(SamTaxempcode queryVO) throws Exception {
		log.debug("call findUser()");
		System.out.println("==="+queryVO.getLoginname());
		List users = getHibernateTemplate().find("from SamTaxempcode where loginname=?", queryVO.getLoginname());
		return users == null || users.size() <= 0 ? false : true;
	}

	/**
	 * 登记
	 */
	@Override
	public String regUser(SamTaxempcode regVO) {
		log.debug("call findUsers()");
		regVO.setUsername(regVO.getLoginname());
		regVO.setDistrictId("0");
		regVO.setCreateDate(new Timestamp(new Date().getTime()));
		regVO.setValidFlag("0");
		regVO.setOrgId(1);
		try {
			getHibernateTemplate().save(regVO);
			return "注册成功!";
		} catch (Exception e) {
			return "注册失败!\n错误信息:"+e.getMessage()+"\n 错误原因:"+e.getCause().getMessage();
		}
	}

}
