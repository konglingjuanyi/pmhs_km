package cn.net.tongfang.web.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InitMainDataService extends HibernateDaoSupport {
	private Date date;
	
	public InitMainDataService(){
		//获得当前日期
		date = new Date();
	}
	/**
	 * 执行SQL
	 * @param sql
	 * @return
	 */
	private List execSQL(String sql){
		Query query = getSession().createQuery(sql);
		query.setParameter(0, date);
		return query.list();
	}
	
	/**
	 * 获得待办事宜
	 * @return
	 */
	public String getWaitDoingData(){
		String sql = "select id from HypertensionVisit where nextVistDate <= ?";
		List list = execSQL(sql);
		String 	result = "";
		if(list.size() > 0){
			result = "高血压患者随访：";
			result = result + list.size() + "人;";
			for(Object o : list){
				result = result + (String)o + ":";
			}
		}
		return result;
	}
}
