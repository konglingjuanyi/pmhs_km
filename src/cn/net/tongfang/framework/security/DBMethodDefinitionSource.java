package cn.net.tongfang.framework.security;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.intercept.method.MethodDefinitionSource;

public class DBMethodDefinitionSource implements MethodDefinitionSource {

	private static final Log logger = LogFactory
			.getLog(DBMethodDefinitionSource.class);

	private ServiceAuthorizationProvider saProvider;

	public void setSaProvider(ServiceAuthorizationProvider saProvider) {
		this.saProvider = saProvider;
	}

	@SuppressWarnings("unchecked")
	public ConfigAttributeDefinition getAttributes(Method method,
			Class targetClass) {
		//logger.debug("method: " + method);
		//logger.debug("targetClass: " + targetClass);
		String[] defs = saProvider.getAuthorization(method);
		if (defs != null) {
			return new ConfigAttributeDefinition(defs);
		} else {
			return null;
		}
	}

	public ConfigAttributeDefinition getAttributes(Object object)
			throws IllegalArgumentException {
		if (object instanceof MethodInvocation) {
			MethodInvocation mi = (MethodInvocation) object;
			logger.debug("MethodInvocation: " + mi);

			String[] defs = saProvider.getAuthorization(mi.getMethod());
			if (defs != null) {
				return new ConfigAttributeDefinition(defs);
			} else {
				return null;
			}
		} else {
			logger.debug("not a MethodInvocation");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Collection getConfigAttributeDefinitions() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		// return (MethodInvocation.class.isAssignableFrom(clazz) ||
		// JoinPoint.class
		// .isAssignableFrom(clazz));
		return (MethodInvocation.class.isAssignableFrom(clazz));

	}
}
