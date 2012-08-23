package cn.net.tongfang.framework.security;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

/**
 * 
 * TODO 暂时没考虑拦截interface的情形
 *
 */
public class ServiceAuthorizationProviderImpl implements
		ServiceAuthorizationProvider {
	private static final Log logger = LogFactory
			.getLog(ServiceAuthorizationProviderImpl.class);

	Map<String, List<ServiceAuthorization>> conf;

	/**
	 * 测试用构造器，webservice注入后，在setter中直接调用buildConf(service.getPojos())即可
	 */
	public ServiceAuthorizationProviderImpl(SecurityService securityClient) {
//		List<String[]> pojos = new ArrayList<String[]>();
//		String[] item1 = new String[]{"1", "cn.net.tongfang.framework.security.demo.service.SimpleServiceImpl.*"};
//		String[] item2 = new String[]{"1", "cn.net.tongfang.framework.security.demo.service.SimpleServiceImpl.sayHello"};
//		String[] item3 = new String[]{"2", "cn.net.tongfang.framework.security.demo.service.SimpleServiceImpl.sayHello"};
//		String[] item4 = new String[]{"3", "cn.net.tongfang.framework.security.demo.service.Dummy.sayHello"};
//		pojos.add(item1);
//		pojos.add(item2);
//		pojos.add(item3);
//		pojos.add(item4);
		List<String[]> pojos = null;
		try {
			pojos = securityClient.getModuleServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.." + pojos);
		conf = buildConf(pojos);
	}

	public String[] getAuthorization(Method m) {
		Assert.notNull(conf, "ServiceAuthorization conf cannot be null");
		//logger.debug("getting Authorization for method: " + m);

		if (conf.containsKey(m.getDeclaringClass().getName())) {
			List<ServiceAuthorization> auths = conf.get(m.getDeclaringClass()
					.getName());
			for (ServiceAuthorization auth : auths) {
				if (isMatch(m, auth.getMethodPattern())) {
					//logger.debug("returing Authorities");
					return auth.getAuthorities();
				}
			}
		}
		return null;

	}

	/**
	 *  简化版本
	 *  匹配* xxx*  *xxx三种情形
	 * @param mi
	 * @param methodPattern
	 * @return
	 */
	public static boolean isMatch(Method mi, String methodPattern) {
		boolean isMatch = false;
		logger.debug("try matching method: " + mi + "\n methodPattern:"
				+ methodPattern);
		try {
			// 判断方法是否匹配
			if (mi.getName().equals(methodPattern)
					|| methodPattern.equals("*")
					|| ((methodPattern.endsWith("*") && mi.getName()
							.startsWith(
									methodPattern.substring(0, methodPattern
											.length() - 1))) || (methodPattern
							.startsWith("*") && mi.getName().endsWith(
							methodPattern.substring(1, methodPattern.length())))))
				isMatch = true;

		} catch (Exception e) {
			logger.debug("got exception");
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
		logger.debug("match result: " + isMatch);
		return isMatch;
	}
	
	/**
	 * TODO 没有加异常检测，某些错误的配置会导致此方法抛出Runtime异常
	 * @param pojos
	 * @return
	 */
	private Map<String, List<ServiceAuthorization>> buildConf(List<String[]> pojos)
	{
		
		Map<String, List<ServiceAuthorization>> result = new HashMap<String, List<ServiceAuthorization>>();
		
		if ( pojos == null || pojos.size() == 0 ) {
			return result; //TODO: 没有要干的活
		}
		
		HashMap<String, Map<String, Set<String>>> tmpConf = new HashMap<String, Map<String, Set<String>>>();

		for(String[] pojo : pojos){
			String modId = pojo[0];
			String methodDesc = pojo[1];
			String className = methodDesc.substring(0,methodDesc.lastIndexOf('.'));
			String methodName = methodDesc.substring(methodDesc.lastIndexOf('.') + 1, methodDesc.length());
			Map<String, Set<String>> authorizations  = tmpConf.get(className);
			if (authorizations == null){
				authorizations = new HashMap<String, Set<String>>();	
				tmpConf.put(className, authorizations);
			}
			Set<String> mods = authorizations.get(methodName);
			if (mods == null){
				mods = new HashSet<String>();
				authorizations.put(methodName, mods);							
			}
			mods.add(modId);	
		}
		
		
		for( String className : tmpConf.keySet()){
			Map<String, Set<String>> authorizations  = tmpConf.get(className);
			List<ServiceAuthorization> authorizationList = new ArrayList<ServiceAuthorization>();
			for(String methodPattern : authorizations.keySet()) {
				Set<String> modIds = authorizations.get(methodPattern);
				String[] idsArray = modIds.toArray(new String[]{});
				ServiceAuthorization sa = new ServiceAuthorization(methodPattern, idsArray);
				authorizationList.add(sa);
			}
			result.put(className, authorizationList);			
		}
		if (logger.isDebugEnabled()){
			logger.debug("============= ServiceAuthorization Info ===================");
			for(String className : result.keySet()){
				logger.debug("classname: " + className);
				List<ServiceAuthorization> authorizationList  = result.get(className);
				for(ServiceAuthorization sa : authorizationList) {
					logger.debug("ServiceAuthorization: \n" + sa);
				}
				
			}
		}
		return result;
	}
}
