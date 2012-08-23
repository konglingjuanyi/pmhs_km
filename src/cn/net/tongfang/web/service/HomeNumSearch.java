package cn.net.tongfang.web.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.web.service.bo.PagedList;

public class HomeNumSearch extends HibernateDaoSupport {
	static int pageSize = 10;
    public  PagedList listCodePage(int pageNo, String mcode, boolean startWith){
    	String likePrefix = startWith ? "" : "%";
    	System.out.println("prefix is " + likePrefix);
    	System.out.println("mcode is " + mcode);
    	PagedList res = new PagedList();
    	long count = (Long)getHibernateTemplate().find("select count(*) from HomeInfo h " +
    			"where h.id like ?", likePrefix + mcode + "%").get(0);
    	System.out.println("total line is : " + count);
    	res.totalLines = count;
    	res.pageSize = pageSize;
    	res.totalPages = (int) (count / pageSize) + ((count % pageSize > 0) ? 1 : 0);
    	int from = pageNo * pageSize;
    	Query qry = getSession().createQuery("select h.homeId,h.household,h.address from HomeInfo as h " +
    			"where h.homeId like ?");
    	qry.setParameter(0, likePrefix + mcode + "%");
    	qry.setMaxResults(pageSize);
    	qry.setFirstResult(from);
    	List list = qry.list();
    	System.out.println("res line is : " + list.size());
    	res.res = list;
    	res.currentPage = pageNo + 1;
    	return res;
    	
    }
    public  List getItem(String code){
    	
    	return getHibernateTemplate().find("select h.homeId,h.household,h.address from HomeInfo h " +
    			"where h.homeId = ?", code);

    }
}
