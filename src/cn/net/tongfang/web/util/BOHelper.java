package cn.net.tongfang.web.util;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.net.tongfang.framework.security.SecurityManager;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.AllergiesHistory;
import cn.net.tongfang.web.service.bo.PersonalInfoFBO;

//import org.springframework.beans.BeanUtils;

public class BOHelper {

	public static final String INPUT_PERSON_ID = "inputPersonId";
	public static final String INPUT_DATE = "inputDate";

	private Class clazz;
	private Class superClass;
	private String fkName;
	PropertyDescriptor[] props;
	List<PropertyDescriptor> listProps = new ArrayList();

	public BOHelper(Class boClazz) {
		this.clazz = boClazz;
		this.superClass = clazz.getSuperclass();
		props = BeanUtils.getPropertyDescriptors(clazz);
		for (PropertyDescriptor pd : props) {
			if (pd.getPropertyType().isAssignableFrom(java.util.List.class)) {
				listProps.add(pd);
			}
		}
		fkName = superClass.getName().substring(
				superClass.getPackage().getName().length() + 1);
		if ( fkName.matches(".*\\d$")) {
			//if end with digit [0-9]
			fkName = decapitalizeFirstChar(fkName) + "id";
		} else {
			fkName = decapitalizeFirstChar(fkName) + "Id";
		}

		//System.out.println("fkName is " + fkName);
	}
	
	public PropertyDescriptor[] getPorps() {
		return props;
	}

	public Object saveOrUpdateAll(Object obj, HibernateTemplate ht, Session session)
			throws Exception {
		//System.out.println("saveOrUpdateAll");
		Object id = getEntityId(obj, ht);
		if (id != null && !id.toString().trim().equals("")) {
			//System.out.println("saving");
			Object old = ht.get(superClass, (Serializable)id);
			ht.evict(old);
			setInputInfo(old, obj);
			return updateAll(obj, ht, session);
		} else {
			setInputInfo( obj );
			Object main = superClass.newInstance();
			BeanUtils.copyProperties(obj, main);
			//System.out.println("fkName is " + fkName);
			ht.save(main);
			id = getEntityId(main, ht);
			setFK(obj, id, fkName);

			saveDetails(obj, ht);
			return id;
		}
	}

	private void setInputInfo(final Object src, Object dest) {
		try {
			PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(superClass,
					INPUT_PERSON_ID);
			if (pd != null) {
				Object property = PropertyUtils.getProperty(src,
						INPUT_PERSON_ID);
				PropertyUtils.setProperty(dest, INPUT_PERSON_ID, property);
			}
			pd = BeanUtils.getPropertyDescriptor(superClass, INPUT_DATE);
			if (pd != null) {
				Object property = PropertyUtils.getProperty(src, INPUT_DATE);
				PropertyUtils.setProperty(dest, INPUT_DATE, property);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error on setting input person/date.", e);
		}

	}

	private void setInputInfo(Object main) {
		try {
			PropertyDescriptor pd = BeanUtils.getPropertyDescriptor( superClass, INPUT_PERSON_ID);
			if ( pd != null ) {
				String username = "";
				TaxempDetail currentOperator = SecurityManager.currentOperator();
				if ( currentOperator != null ) username = currentOperator.getUsername();
				pd.getWriteMethod().invoke(main, username);
			}
			pd = BeanUtils.getPropertyDescriptor( superClass, INPUT_DATE);
			if ( pd != null ) {
				pd.getWriteMethod().invoke(main, new Timestamp(System.currentTimeMillis()));
			}
		} catch (Exception e) {
			throw new RuntimeException("Error on setting input person/date.", e);
		}
	}

	public Object readAll(Object obj, HibernateTemplate ht) throws Exception {
		Object id = getEntityId(obj, ht);
		//System.out.println("entity id is " + id);
		Object main = ht
				.get(superClass, (java.io.Serializable) id);
		//todo entity no found
//		List r = ht.find("from BabyVisit where id = ?", id);
//		System.out.println("main is " + main);
//		System.out.println(r.size());
		BeanUtils.copyProperties(main, obj); // spring beanutils
		loadDetails(obj, ht, fkName, id);
		return obj;
	}

	public Object updateAll(Object obj, HibernateTemplate ht, Session session) throws Exception {
		Object id = getEntityId(obj, ht);
		Object main = superClass.newInstance();
		BeanUtils.copyProperties(obj, main);
		ht.update(main);
		deleteDetails(obj, session, fkName,
				id);
		setFK(obj, id, fkName);
		saveDetails(obj, ht);
		return id;

	}

	private Object getEntityId(Object obj, HibernateTemplate ht)
			throws IllegalAccessException, InvocationTargetException {
		ClassMetadata cm = ht.getSessionFactory().getClassMetadata(superClass);
		String idCol =cm.getIdentifierPropertyName();
		PropertyDescriptor idPropDescr = BeanUtils.getPropertyDescriptor(
				superClass, idCol);
		return idPropDescr.getReadMethod().invoke(obj);
	}

	public void setFK(Object target, Object val, String fkName)
			throws Exception {
		for (PropertyDescriptor pd : listProps) {
			List list = (List) pd.getReadMethod().invoke(target);
			if (list != null) {
				for (Object item : list) {
					PropertyDescriptor _pd = BeanUtils.getPropertyDescriptor(
							item.getClass(), fkName);
					_pd.getWriteMethod().invoke(item, val);
				}
			}
		}
	}

	private static String capitalizeFirstChar(String name) {
		return (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}

	private static String decapitalizeFirstChar(String name) {
		return (name.charAt(0) + "").toLowerCase() + name.substring(1);
	}

	public void loadDetails(Object target, HibernateTemplate ht, String fkName,
			Object key) throws Exception {

		for (PropertyDescriptor pd : listProps) {
			String hsql = "from " + capitalizeFirstChar(pd.getName())
					+ " p where p." + fkName + " = ?";
			//System.out.println("hsql is " + hsql);
			List items = ht.find(hsql, key);
			pd.getWriteMethod().invoke(target, items);
		}

	}

	public void saveDetails(Object target, HibernateTemplate ht)
			throws Exception {
		for (PropertyDescriptor pd : listProps) {
			List list = (List) pd.getReadMethod().invoke(target);
			if (list != null) {
				ht.saveOrUpdateAll(list);

			}
		}
	}

	public void deleteDetails(Object target, Session session, String fkName,
			Object key) throws Exception {
		for (PropertyDescriptor pd : listProps) {
			String hsql = "delete from " + capitalizeFirstChar(pd.getName())
					+ " p where p." + fkName + " = ?";
			//System.out.println("hsql is " + hsql);
			session.createQuery(hsql).setParameter(0, key).executeUpdate(); // use
			// bulkUpdate?
		}
	}

	// getSuperclass

	public static void main(String[] args) throws Exception {
		BOHelper bo = new BOHelper(PersonalInfoFBO.class);
		PersonalInfoFBO testBean = new PersonalInfoFBO();
		AllergiesHistory hist = new AllergiesHistory(null, 1);
		List<AllergiesHistory> histList = new ArrayList<AllergiesHistory>();
		histList.add(hist);
		testBean.setAllergiesHistory(histList);
		bo.setFK(testBean, "123", "personalInfoId");
		for (AllergiesHistory o : histList) {
			System.out.println("id is : " + o.getPersonalInfoId());
		}
		// bo.saveAll(testBean);
		// bo.setFK();
	}
}
