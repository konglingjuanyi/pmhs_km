package cn.net.tongfang.framework.security;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.intercept.method.MethodDefinitionSource;

//public interface MethodDefinitionSource extends ObjectDefinitionSource {
//    public ConfigAttributeDefinition getAttributes(Method method, Class targetClass);
//}
public class SimpleDbMethodDefinitionSource implements MethodDefinitionSource {
	public ConfigAttributeDefinition getAttributes(Method method,
			Class targetClass) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>getAttributes m t");
		if (targetClass
				.getName()
				.equals(
						"cn.net.tongfang.framework.security.demo.service.SimpleServiceImpl")
				&& method.getName().equals("sayHello"))
			return new ConfigAttributeDefinition(new String[] { "ROLE_TELLER" });
		else
			return null;

	}

	public ConfigAttributeDefinition getAttributes(Object object)
			throws IllegalArgumentException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>getAttributes obj"
				+ object);
		if (object instanceof MethodInvocation){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is MethodInvocation ");
			MethodInvocation mi = (MethodInvocation)object;
			if (

			mi.getThis().getClass().getName().equals("cn.net.tongfang.framework.security.demo.service.SimpleServiceImpl")
			&& mi.getMethod().getName().equals("sayHello"))
			{
				return new ConfigAttributeDefinition(new String[] { "ROLE_TELLER" });
			}
		} else
		{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>is not MethodInvocation ");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public Collection getConfigAttributeDefinitions() {
		System.out
				.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>getConfigAttributeDefinitions");
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class clazz) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>supports");
		return (MethodInvocation.class.isAssignableFrom(clazz) || JoinPoint.class.isAssignableFrom(clazz));

	}
}

// public class DbMethodDefinitionSource extends
// AbstractFallbackMethodDefinitionSource {
//	
// private Properties conf;
//	
// public Properties getConf() {
// return conf;
// }
//
// public void setConf(Properties conf) {
// this.conf = conf;
// System.out.println("=========================================");
// System.out.println(conf.toString());
// System.out.println("=========================================");
// }
//
// protected ConfigAttributeDefinition findAttributes(Class clazz) {
// // return processAnnotation(clazz.getAnnotation(Secured.class));
// System.out.println(">>>>>>>>ConfigAttributeDefinition");
// System.out.println("clazz is " + clazz);
// if (conf.containsKey(clazz.getName())){
// System.out.println(">>>>>>>><<got you");
// return new ConfigAttributeDefinition(new String[]{"ROLE_TELLER"});
// }
// return null;
// }
//
// protected ConfigAttributeDefinition findAttributes(Method method,
// Class targetClass) {
// System.out.println(">>>>>>>>findAttributes");
// System.out.println("clazz is " + targetClass);
// System.out.println("Method is " + method);
// if (conf.containsKey(targetClass.getName())){
// System.out.println(">>>>>>>>got you");
// return new ConfigAttributeDefinition(new String[]{"ROLE_TELLER"});
// }
// return null;
// // return processAnnotation(AnnotationUtils.findAnnotation(method,
// // Secured.class));
// }
//
// public Collection getConfigAttributeDefinitions() {
// return null;
// }
//	
//	
//
//
// }
