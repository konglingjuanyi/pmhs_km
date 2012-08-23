package cn.net.tongfang.web.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HighRiskService extends HibernateDaoSupport {
	public List getException(String type,String filterVal){
		type = type.equals("0") ? "儿童" : "妇女";
		String sql = "From HighRisk Where type = ? And (number = ? Or exception Like ? Or exceptionPng Like ?)";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, type);
		query.setParameter(1, filterVal);
		query.setParameter(2, "%" + filterVal + "%");
		query.setParameter(3, "%" + filterVal + "%");
		List list = query.list(); 
		if(list.size() > 0)
			return list;
		return null;
	}
}
