package cn.net.tongfang.web.util;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.HomeInfoKey;

public class HomeNoGen extends HibernateDaoSupport{
	
	public String getNextHomeNo(String districtNumber){
		List<HomeInfoKey> c = getHibernateTemplate().find("select p from HomeInfoKey p where p.districtNumber = ?" , districtNumber);
		int key = 1;
		HomeInfoKey homeKey = null;
		if(c.size() > 0){
			homeKey = c.get(0);
			key = 1 + homeKey.getMaxKey();
			homeKey.setMaxKey(key);
		}else{
			homeKey = new HomeInfoKey();
			homeKey.setDistrictNumber(districtNumber);
			homeKey.setMaxKey(key);
		}
		getHibernateTemplate().saveOrUpdate(homeKey);
		
		String keyStr = key + "";
		
		if(keyStr.length() == 1){
			keyStr = "00" + keyStr;
		}else if(keyStr.length() == 2){
			keyStr = "0" + keyStr;
		}
		String nextHomeNo = districtNumber + keyStr;
		return nextHomeNo;
	}
}
