package cn.net.tongfang.framework.util.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.SecurityManager;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;

public class TaxOrgProvider extends HibernateDaoSupport {
	
	private Map<String, String> optionClassMap;
	private static final List<Object> empty = new ArrayList<Object>();
	private static final Log log = LogFactory.getLog(COptionProvider.class);

	public void setOptionClassMap(Map<String, String> optionClassMap) {
		this.optionClassMap = optionClassMap;
	}

    private String trimZeros(String str) {
        String res = str.replaceAll("0*$", "");
        return res;
    }

    private String getParentByLen(String userOrgCode, int len) {
        String prefix =  userOrgCode.substring(0, len);
        StringBuffer sb = new StringBuffer(prefix);
        for (int i = 0; i < 10 - len; ++i){
            sb.append("0");
        }
        return sb.toString();
    }
    
    private boolean isAccessable(String targetOrg, String userOrg){
        if (targetOrg.length() < userOrg.length()) {
            return isUnderneath(targetOrg, userOrg);
        } else {
            return isUnderneath(userOrg, targetOrg);
        }
    }

    private boolean isUnderneath(String highLevel, String lowerLevel){
        return (lowerLevel.startsWith(highLevel));
    }
        



	@SuppressWarnings("unchecked")
	public List<Object> getCOptsByVO(String optionName, Map vo) {
        TaxempDetail detail = SecurityManager.currentOperator();
        log.debug("detail is \n>>>>>>>>>>>>>>>" + detail);
        
	    if (detail != null){
	    	 //String userOrg = detail.getTaxorgcode();
            String userOrg = detail.getDistrictId();//临时修改为行政区域，在医疗中目前是不用的
            String trimmedUserOrg = trimZeros(userOrg);
            String parentId = (String)vo.get("parentId");
            String trimmedParentId = trimZeros(parentId);

            log.debug("userOrg " + userOrg);
            log.debug("trimmed userOrg " + trimmedUserOrg);
            log.debug("parentId" + parentId);
            log.debug("trimmed parentId" + trimmedParentId);
            
    		String entityName = optionClassMap.get(optionName);
            Class clazz = null;
            if (entityName == null) {
                return empty;
            } else {
                try {
                    clazz = Class.forName(entityName);
                } catch (Exception e){
                    e.printStackTrace();
                    log.error(e);
                    return empty;
                }
            }

            //if (trimmedUserOrg.startsWith(trimmedParentId)){
            //if (trimmedParentId.startsWith(trimmedUserOrg)){
            if (isAccessable(trimmedParentId, trimmedUserOrg)){
                if (trimmedUserOrg.length() > trimmedParentId.length()){
                    String userOrgParent = getParentByLen(userOrg,trimmedParentId.length() + 2);
                    System.out.println("userOrgParent " + userOrgParent);
                    vo.put("taxorgcode", userOrgParent);
                    List<Object> res = new ArrayList<Object>();
                    Object item = getHibernateTemplate().get(clazz, userOrgParent);
                    res.add(item);
                    return res;
                } 
                //下级机关
                else {
                    try {
                        Object o = clazz.newInstance();
                        BeanUtils.populate(o, vo);
                        List<Object> list = getHibernateTemplate().findByExample(o);
                        return list;
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error(e);
                        return empty;
                    }
                }
            } else {
                log.debug("should not happened.");
                return empty;
            }

        } else {
            return empty;
        }

	}
}
