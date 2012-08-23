package cn.net.tongfang.framework.util.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.vo.DwrOptionVO;
import cn.net.tongfang.framework.security.vo.DrugVO;
import cn.net.tongfang.framework.security.vo.NccmintcodeVO;

public class OptionProvider extends HibernateDaoSupport {

	private Map<String, String> optionClassMap;
	private static final List<Object> empty = new ArrayList<Object>();

	private static final Log log = LogFactory.getLog(OptionProvider.class);

	public void setOptionClassMap(Map<String, String> optionClassMap) {
		this.optionClassMap = optionClassMap;
	}
	

	@SuppressWarnings("unchecked")
	public List<Object> getOptions(String optionName) {
		String entityName = optionClassMap.get(optionName);
		String hql = null;
		if (entityName != null) {
//			hql = "from " + entityName + " order by " + "displayOrder";
			hql = "from " + entityName + " order by name";
		} else {
			log.warn("entityName not found ! [" + entityName + "]");
			return empty;
		}
		List<Object> list = getHibernateTemplate().find(hql);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getWhereOptions(String whereno) {
		String hql = null;
		if (whereno != null) {
			hql = " from NccmintcodeVO where primaryKey.TableNo='"+whereno+"' order by primaryKey.ItemNo";
		} else {
			log.warn("entityName not found ! [NccmintcodeVO]");
			return empty;
		}
		List<Object> list = getHibernateTemplate().find(hql);
		List<Object> retlist = new ArrayList();
		for(Object obj : list){
			NccmintcodeVO vo = (NccmintcodeVO)obj;
			DwrOptionVO optvo = new DwrOptionVO(vo.getPrimaryKey().getItemNo(),vo.getPrimaryKey().getItemNo()+"--"+vo.getItemValue());
			retlist.add(optvo);
		}
		return retlist;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getDrugOptions() {
		String hql = null;
		hql = " from DrugVO order by Pinyin";
		List<Object> list = getHibernateTemplate().find(hql);
		List<Object> retlist = new ArrayList();
		for(Object obj : list){
			DrugVO vo = (DrugVO)obj;
			vo.setName(vo.getPinYin()+"--"+vo.getName());
//			DwrOptionVO optvo = new DwrOptionVO(vo.getCode(),vo.getPinYin()+"--"+vo.getName());
//			retlist.add(optvo);
		}
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public List<Object> getOptionsByVO(String optionName, Map vo) {
		String entityName = optionClassMap.get(optionName);
		if (entityName == null) {
			return empty;
		} else {
			System.out.println("got entity: " + entityName);
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
