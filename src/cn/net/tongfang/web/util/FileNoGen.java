package cn.net.tongfang.web.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.HealthFileKey;

public class FileNoGen extends HibernateDaoSupport{
	private static final Logger log = Logger.getLogger(FileNoGen.class);
	
	public String getNextFileNo(String districtNumber){
		List<HealthFileKey> c = getHibernateTemplate().find("select p from HealthFileKey p where p.districtNumber = ?" , districtNumber);
		int key = 1;
		HealthFileKey hf = null;
		if (c.size() > 0 ) {
			hf = c.get(0);
			key =  1 + c.get(0).getMaxKey();
			hf.setMaxKey(key);
		} else {
			hf = new HealthFileKey();
			hf.setDistrictNumber(districtNumber);
			hf.setMaxKey(key);
		}
		
		getHibernateTemplate().saveOrUpdate(hf);
		
		String strKey = key + "";
		
		int spaces = 6 - strKey.length();
		
		if (spaces < 0) {
			String msg = "流水号超长！！！！！";
			log.error(msg);
			throw new RuntimeException(msg);
		}
		
		for(int i = 0; i < spaces; i++) {
			strKey = "0" + strKey;
		}
		
		return districtNumber + strKey;
		
	}
}
