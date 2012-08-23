package cn.net.tongfang.web.service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.web.util.BOHelper;

public abstract class HealthMainService<T> extends HibernateDaoSupport {
	
	protected BOHelper boHelper;

	public HealthMainService() {
		 Class clazz = getTypeArguments(HealthMainService.class, getClass()).get(0);
		 boHelper = new BOHelper(clazz);
	}

	protected String save_(T data) throws Exception {
		Object o = boHelper.saveOrUpdateAll(data, getHibernateTemplate(),
				getSession()).toString();
		System.out.println("res is " + o);
		return o.toString();
	}

	protected Object get_(T data) throws Exception {
		return  boHelper.readAll(data, getHibernateTemplate());
	}
	
	public abstract String save(T data) throws Exception ;
	public abstract Object get(T data) throws Exception ;
	
	

	public List<String> hasAllThese(List<String> props) {
		List<String> res = new ArrayList<String>();
		PropertyDescriptor[] ps = boHelper.getPorps();
		Set<String> propSet = new HashSet<String>();
		for (PropertyDescriptor p : ps) {
			propSet.add(p.getName());
		}
		for (String inP : props) {
			if (!propSet.contains(inP)) {
				res.add(inP);
			}
		}
		return res;
	}
	
	  /**
	   * Get the actual type arguments a child class has used to extend a generic base class.
	   *
	   * @param baseClass the base class
	   * @param childClass the child class
	   * @return a list of the raw classes for the actual type arguments.
	   */
	  public static <T> List<Class<?>> getTypeArguments(
	    Class<T> baseClass, Class<? extends T> childClass) {
	    Map<Type, Type> resolvedTypes = new HashMap<Type, Type>();
	    Type type = childClass;
	    // start walking up the inheritance hierarchy until we hit baseClass
	    while (! getClass(type).equals(baseClass)) {
	      if (type instanceof Class) {
	        // there is no useful information for us in raw types, so just keep going.
	        type = ((Class) type).getGenericSuperclass();
	      }
	      else {
	        ParameterizedType parameterizedType = (ParameterizedType) type;
	        Class<?> rawType = (Class) parameterizedType.getRawType();
	  
	        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
	        TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
	        for (int i = 0; i < actualTypeArguments.length; i++) {
	          resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
	        }
	  
	        if (!rawType.equals(baseClass)) {
	          type = rawType.getGenericSuperclass();
	        }
	      }
	    }
	  
	    // finally, for each actual type argument provided to baseClass, determine (if possible)
	    // the raw class for that type argument.
	    Type[] actualTypeArguments;
	    if (type instanceof Class) {
	      actualTypeArguments = ((Class) type).getTypeParameters();
	    }
	    else {
	      actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
	    }
	    List<Class<?>> typeArgumentsAsClasses = new ArrayList<Class<?>>();
	    // resolve types by chasing down type variables.
	    for (Type baseType: actualTypeArguments) {
	      while (resolvedTypes.containsKey(baseType)) {
	        baseType = resolvedTypes.get(baseType);
	      }
	      typeArgumentsAsClasses.add(getClass(baseType));
	    }
	    return typeArgumentsAsClasses;
	  }
	  
	  /**
	   * Get the underlying class for a type, or null if the type is a variable type.
	   * @param type the type
	   * @return the underlying class
	   */
	  public static Class<?> getClass(Type type) {
	    if (type instanceof Class) {
	      return (Class) type;
	    }
	    else if (type instanceof ParameterizedType) {
	      return getClass(((ParameterizedType) type).getRawType());
	    }
	    else if (type instanceof GenericArrayType) {
	      Type componentType = ((GenericArrayType) type).getGenericComponentType();
	      Class<?> componentClass = getClass(componentType);
	      if (componentClass != null ) {
	        return Array.newInstance(componentClass, 0).getClass();
	      }
	      else {
	        return null;
	      }
	    }
	    else {
	      return null;
	    }
	  }
}
