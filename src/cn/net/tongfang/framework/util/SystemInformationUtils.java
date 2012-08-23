package cn.net.tongfang.framework.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.BasicInformation;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam36;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.GravidityKey;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.SystemInformation;

public class SystemInformationUtils extends HibernateDaoSupport {
	
	/**
	 * 获得系统配置值
	 * @param id
	 * @return
	 */
	public String getVal(Integer id){
		SystemInformation sysInfo = (SystemInformation)getHibernateTemplate()
				.get(SystemInformation.class, id);
		return sysInfo.getVal();
	}
	
	/**
	 * 获得基础信息配置值
	 * @param type
	 * @return
	 */
	public List<BasicInformation> getBasicInformation(Integer type){
		String hql = "From BasicInformation Where type = ? And isMain = 0";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, type);
		List list = query.list();
		List<BasicInformation> ret = new ArrayList<BasicInformation>();
		for(Object obj : list){
			BasicInformation basicInfo = (BasicInformation)obj;
			ret.add(basicInfo);
		}
		return ret;
	}
	
	public String getPrintBasicInfo(String id,String tableName,String key,String tableKey){
		String hql = "From BasicInformation A," + tableName + " B Where A.id = B." + key + " And B." + tableKey + " = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		List list = query.list();
		String ret = "未测";
		if(list.size() > 0){
			ret = "";
			for(Object objs : list){
				Object[] obj = (Object[])objs;
				BasicInformation basicInformation = (BasicInformation)obj[0];
				ret = ret + basicInformation.getName() + ",";
			}
			if(!ret.equals(""))
				ret = ret.substring(0,ret.length() - 1);
		}
		return ret;
	}
	
	public boolean checkChildrenMedicalExamIsInput(String fileNo,String items,String tableName,Integer type){
		String typeHql = "";
		if(type != null)
			typeHql = " And dataType = ?";
		String hql = "From " + tableName + " Where fileNo = ? And checkItem = ? " + typeHql; 
		Query query = getSession().createQuery(hql);
		query.setParameter(0, fileNo);
		query.setParameter(1, items);
		if(type != null)
			query.setParameter(2, type);
		if(query.list().size() > 0){
			return true;
		}
		return false;
	}
	
	public Integer checkWomanMedicalExam(String fileNo){
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = "From GravidityKey Where fileNo = :fileNo ";
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		List list = query.list();
		if(list.size() > 0){
			GravidityKey gravidityKey = (GravidityKey)list.get(0);
			return gravidityKey.getCurrentGravidity();
		}
		return null;
	}
	
	public boolean checkWomanMedicalExamIsInput(String fileNo,Integer items,String tableName,String type){
		String typeHql = "";
		if(type != null)
			typeHql = " And recordType = :recordType";
		if(items != null)
			typeHql = typeHql + "  And item = :item ";
		String hql = "From " + tableName + " Where fileNo = :fileNo" + typeHql; 
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		if(items != null)
			query.setParameter("item", items);
		if(type != null)
			query.setParameter("recordType", type);
		if(query.list().size() > 0)
			return true;
		return false;
	}
	
	public boolean checkWomanGravidity(String fileNo,String tableName,Integer gravidity){
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = "From " + tableName + " Where fileNo = :fileNo And gravidity = :gravidity ";
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		query.setParameter("gravidity", gravidity);
		if(query.list().size() > 0)
			return true;
		return false;
	}
	
	public boolean checkWomanMedicalExamIsInput(String fileNo,String items,String recordType,Integer parities){
		String typeHql = "";
		if(items != null)
			typeHql = typeHql + "  And item = :item ";
		String hql = "From VisitAfterBorn Where fileNo = :fileNo And recordType = :recordType And parities = :parities" + typeHql; 
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		query.setParameter("recordType",recordType);
		query.setParameter("parities",parities);
		if(items != null)
			query.setParameter("item", items);
		if(query.list().size() > 0)
			return true;
		return false;
	}
	
	public FirstVistBeforeBorn checkWomanSeparateDate(String fileNo,Integer gravidity){
		String hql = "From FirstVistBeforeBorn Where fileNo = :fileNo And gravidity = :gravidity ";
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		query.setParameter("gravidity", gravidity);
		if(query.list().size() > 0){
			return (FirstVistBeforeBorn)query.list().get(0);
		}
		return null;
	}
	public PersonalInfo getPersonalInfo(String fileNo){
		fileNo = EncryptionUtils.encry(fileNo);
		return (PersonalInfo)getHibernateTemplate().find(" From PersonalInfo Where fileNo = ?", fileNo).get(0);
	}
	public boolean getPersonalInfo(String fileNo,String tableName){
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = " From PersonalInfo A, " + tableName + " B Where A.fileNo = ? And A.fileNo = B.fileNo ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, fileNo);
		if(query.list().size() > 0)
			return true;
		return false;
	}
	public String childExamInfo(String fileNo,Integer dataType){
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = "From ChildrenMediExam Where fileNo = :fileNo And dataType = :dataType Order By checkItem ASC ";
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		query.setParameter("dataType", dataType);
		List list = query.list();
		if(list.size() > 0){
			String result = "";
			for(Object obj : list){
				ChildrenMediExam childExam = (ChildrenMediExam)obj;
				result += childExam.getCheckItem() + ",";
			}
			result = result.equals("") ? "" : result.substring(0,result.length() - 1);
			return result;
		}
		return null;
	}
	public String childExam36Info(String fileNo,Integer dataType){
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = "From ChildrenMediExam36 Where fileNo = :fileNo Order By checkItem ASC ";
		Query query = getSession().createQuery(hql);
		query.setParameter("fileNo", fileNo);
		List list = query.list();
		if(list.size() > 0){
			String result = "";
			for(Object obj : list){
				ChildrenMediExam36 childExam = (ChildrenMediExam36)obj;
				result += childExam.getCheckItem() + ",";
			}
			result = result.equals("") ? "" : result.substring(0,result.length() - 1);
			return result;
		}
		return null;
	}
}
