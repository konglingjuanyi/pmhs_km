package cn.net.tongfang.web.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.util.EncryptionUtils;

public class StatisticService extends HibernateDaoSupport{
	public static final Integer DISEASE_HYP = 2;
	public static final Integer DISEASE_FURI = 8;
	public static final Integer DISEASE_DIAB = 3;
	
	private String createSql(String val){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String sql = val + " A.fileNo Like '" + EncryptionUtils.encry(user.getDistrictId()) + "%'";
		return sql;
	}
	
	public List<Long> queryTotalFiles(){
		String sql = "";
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		List<Long> totals = new ArrayList<Long>();
		
		//查询户籍档案总数
		sql = "Select Count(*) From HomeInfo A Where A.districtNumber Like '" + user.getDistrictId() + "%'";
		totals.add(execSQL(sql));
		
		//查询居民健康总数
		sql = createSql("Select Count(*) From HealthFile A Where ");
		totals.add(execSQL(sql));
		
		//查询健康体检总数
		sql = createSql("Select Count(*) From MedicalExam A Where ");
		totals.add(execSQL(sql));
		
		//查询高血压档案总数
		sql = createSql("Select Count(*) From PersonalInfo A,DiseaseHistory B Where A.id = B.personalInfoId And B.diseaseId = " + DISEASE_HYP + " And");
		totals.add(execSQL(sql));
		
		//查询2型糖尿病总数
		sql = createSql("Select Count(*) From PersonalInfo A,DiseaseHistory B Where A.id = B.personalInfoId And B.diseaseId = " + DISEASE_FURI + " And");
		totals.add(execSQL(sql));
		
		//查询重性精神病档案总数
		sql = createSql("Select Count(*) From PersonalInfo A,DiseaseHistory B Where A.id = B.personalInfoId And B.diseaseId = " + DISEASE_DIAB + " And");
		totals.add(execSQL(sql));
		
		return totals;
	}
	
	private String createSqlOther(String val){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String sql = val + " And fileNo Like '" + EncryptionUtils.encry(user.getDistrictId()) + "%'";
		return sql;
	}
	
	/**
	 * 执行SQL语句并返回值
	 * @param sql
	 * @return
	 */
	public long execSQL(String sql){
		Query query = null;
		query = getSession().createQuery(sql);
		List list = query.list();
		long count = -1;
		if(list.size() > 0){
			Object obj = (Object)list.get(0);
			count = (Long)obj;
		}
		return count;
	}
	
	
	/**
	 * 查询待办工作
	 * @return
	 */
	public List<Long> queryWorking(){
		String sql = "";		
		List<Long> workings = new ArrayList<Long>();
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		//今天高血压患者随访人数统计
		sql = createSqlOther("Select Count(*) From HypertensionVisit Where CONVERT(varchar(10),nextVistDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'");
		workings.add(execSQL(sql));
		
		//今天2型糖尿病患者随访人数统计
		sql = "Select Count(*) From DiabetesVisit Where CONVERT(varchar(10),nextVistDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天重性精神病随访人数统计
		sql = "Select Count(*) From FuriousVisit Where CONVERT(varchar(10),nextVistDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天新生儿体检人数统计
		sql = "Select Count(*) From BabyVisit Where CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天1岁儿童体检人数统计
		sql = "Select Count(*) From ChildrenMediExam Where dataType = 0 and  CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天2岁儿童体检人数统计
		sql = "Select Count(*) From ChildrenMediExam Where dataType = 1 and  CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));

		//今天第一次产前检查人数统计
		sql = "Select Count(*) From FirstVistBeforeBorn Where CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天第一次产前检查人数统计
		sql = "Select Count(*) From VisitBeforeBorn Where CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天产后访视人数统计
		sql = "Select Count(*) From VisitAfterBorn Where recordType = 0 And CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		//今天产后访视人数统计
		sql = "Select Count(*) From VisitAfterBorn Where recordType = 1 And CONVERT(varchar(10),nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) And fileNo Like '" + user.getDistrictId() + "%'";
		workings.add(execSQL(sql));
		
		return workings;
	}
}
