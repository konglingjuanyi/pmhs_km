package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.ClinicLogs;
import cn.net.tongfang.framework.security.vo.SickInfo;

public class ClinicLogsService extends HibernateDaoSupport {
	/**
	 * 保存
	 * @param data
	 * @return
	 */
	public String save(ClinicLogs data){
		String id = data.getId();
		if(id != null && !id.equals("")){
			System.out.println("updating......");
			update(data);
			return id;
		}
		data.setInputTime(new Timestamp((new Date()).getTime()));
		getHibernateTemplate().save(data);
		return data.getId();
	}
	
	private void update(ClinicLogs data){
		data.setIsModify(true);
		getHibernateTemplate().update(data);
	}
	
	/**
	 * 通过档案编号获得个人信息
	 * @param fileNo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getPersonalInfo(String fileNo){
		String sql = "from SickInfo A Where A.fileNo = \'" + fileNo + "\'";
		List sickList = ExecSQLStr(sql);
		List list = new ArrayList();
		if(sickList.size() <= 0){
			list = save_Update_Get(fileNo,null);
		}else{
			SickInfo sick = (SickInfo)sickList.get(0);
			save_Update_Get(fileNo,sick);
			list.add(sick.getName());
			list.add(sick.getAddress());
			list.add(sick.getSex());
			list.add(sick.getBirthday());
			list.add(sick.getIsHypertensionVisit());
			list.add(sick.getIsFuriousInfo());
			list.add(sick.getIsDiabetesVisit());
			list.add(sick.getAllergies());
		}
		return list;
	}
	/**
	 * 保存、更新、查询基本信息
	 * @param fileNo
	 * @param sickInfo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List save_Update_Get(String fileNo,SickInfo sickInfo){
		if(sickInfo == null)
			sickInfo = new SickInfo();
		String sql = "Select B.name,B.address,A.sex,A.birthday From PersonalInfo A,HealthFile B "
				+ "Where A.fileNo = B.fileNo and A.fileNo = \'" + fileNo + "\'";
		List basicSql = ExecSQLStr(sql);
		List list = new ArrayList();
		//个人基础信息
		if (basicSql.size() > 0) {
			Object[] objs = (Object[]) basicSql.get(0);
			List tempList = new ArrayList();
			for (int i = 0; i < objs.length; i++) {
				tempList.add(objs[i]);
			}

			sickInfo.setName(tempList.get(0).toString());
			sickInfo.setSex(tempList.get(2).toString());
			sickInfo.setAddress(tempList.get(1).toString());
			sickInfo.setBirthday((Date) (tempList.get(3)));
			
			sql = "Select A.allergiesOther,Max(Case B.allergiesId When 999 Then C.name Else Null End),"+
				"Max(Case B.allergiesId When 1123 Then C.name Else Null End),"+
				"Max(Case B.allergiesId When 1124 Then C.name Else Null End),"+
				"Max(Case B.allergiesId When 1125 Then C.name Else Null End) "+
				"From PersonalInfo A,AllergiesHistory B,BasicInformation C "+
				"Where B.allergiesId = C.id And A.id = B.personalInfoId And A.fileNo = \'" + fileNo +"\'"+
				" Group By A.allergiesOther";
			List allergiesList = ExecSQLStr(sql);
			String allergies = "";
			if(allergiesList.size() > 0){
				Object[] allergiesObjs = (Object[]) allergiesList.get(0);
				for (int i = 0; i < allergiesObjs.length; i++) {
					String str = (String) allergiesObjs[i];
					if (str != null && !str.equals(null))
						allergies += str + ",";
				}
			}
			sickInfo.setAllergies(allergies);
			// 高血压
			sql = "from HypertensionVisit A Where A.fileNo = \'" + fileNo
					+ "\'";
			sickInfo.setIsHypertensionVisit(ExecSQL(sql));
			tempList.add(sickInfo.getIsHypertensionVisit());
			// 精神病
			sql = "from FuriousInfo A Where A.fileNo = \'" + fileNo + "\'";
			sickInfo.setIsFuriousInfo(ExecSQL(sql));
			tempList.add(sickInfo.getIsFuriousInfo());
			// 糖尿病
			sql = "from DiabetesVisit A Where A.fileNo = \'" + fileNo + "\'";
			sickInfo.setIsDiabetesVisit(ExecSQL(sql));
			tempList.add(sickInfo.getIsDiabetesVisit());
			sickInfo.setFileNo(fileNo);
			getHibernateTemplate().saveOrUpdate(sickInfo);
			tempList.add(sickInfo.getAllergies());
			list = tempList;
		}
		return list;
	}
	
	/**
	 * 执行脚本查看是否有高血压、糖尿病等
	 * @param sql
	 * @return
	 */
	private Boolean ExecSQL(String sql){
		Query query = getSession().createQuery(sql);
		if(query.list().size() > 0)
			return true;
		return false;
	}
	
	/**
	 * 执行脚本获得姓名、性别、过敏史等基础信息
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List ExecSQLStr(String sql){
		Query query = getSession().createQuery(sql);
		return query.list();
	}
	
	public ClinicLogs get(ClinicLogs data){
		ClinicLogs clinic = (ClinicLogs)getHibernateTemplate().get(ClinicLogs.class, data.getId());
		return clinic;
	}
}
