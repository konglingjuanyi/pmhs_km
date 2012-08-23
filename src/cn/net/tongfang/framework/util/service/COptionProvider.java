package cn.net.tongfang.framework.util.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class COptionProvider extends HibernateDaoSupport {
	
	private Map<String, String> optionClassMap;
	private static final List<Object> empty = new ArrayList<Object>();
	private static final Log log = LogFactory.getLog(COptionProvider.class);

	public void setOptionClassMap(Map<String, String> optionClassMap) {
		this.optionClassMap = optionClassMap;
	}

	@SuppressWarnings("unchecked")	
	public List<Object> getCascadeOpts(String key, String parent) {
		String entityName = optionClassMap.get(key);
		String hql = null;
		if (entityName != null) {
			hql = "from " + entityName + " where parentId = ?";
		} else {
			return empty;
		}
		List<Object> list = getHibernateTemplate().find(hql, new String[]{parent});
		return list;
	}	

	@SuppressWarnings("unchecked")
	public List<Object> getCOptsByVO(String optionName, Map vo) {
		String entityName = optionClassMap.get(optionName);
		if (entityName == null) {
			return empty;
		} else {
			try {
				Object o = Class.forName(entityName).newInstance();
				BeanUtils.populate(o, vo);
				List<Object> list = getHibernateTemplate().findByExample(o);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				return empty;
			}
		}
	}
}
