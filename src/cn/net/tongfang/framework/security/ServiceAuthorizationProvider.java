package cn.net.tongfang.framework.security;

import java.lang.reflect.Method;

public interface ServiceAuthorizationProvider {
		String[] getAuthorization(Method m);
}
