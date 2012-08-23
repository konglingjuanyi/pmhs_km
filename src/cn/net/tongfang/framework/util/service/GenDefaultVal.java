package cn.net.tongfang.framework.util.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.WomanDirect;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;

public class GenDefaultVal extends HibernateDaoSupport{
	private static final String ERROR_DATE_OVER = "随访日期小于出生日期，无法计算年龄，请填写正确的随访日期！";
	private static final String TEXT_YEARS = "岁";
	private static final String TEXT_MONTH = "月";
	private static final String TEXT_DAY = "天";
	
	private static final Integer[] LEAP_YEAR = new Integer[]{31,29,31,30,31,30,31,31,30,31,30,31};
	private static final Integer[] UN_LEAP_YEAR = new Integer[]{31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	/**
	 * 根据出生日期获得健康指导
	 * @param fileNo
	 * @param visitDate
	 * @return
	 */
	public List<String> get(String fileNo,String visitDate){
		Calendar vsCalendar = CommonConvertUtils.stringToCalendar(visitDate);
		if(vsCalendar == null)
			return null;
		String hql = "From PersonalInfo Where fileNo = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, EncryptionUtils.encry(fileNo));
		List list = query.list();
		if(list.size() > 0){
			PersonalInfo person = (PersonalInfo)list.get(0);
			Calendar cBirthday = CommonConvertUtils.timestampToCalendar(person.getBirthday());
			String age = getBabyAge(vsCalendar,cBirthday);
			List<String> retList = new ArrayList<String>();
			String dietDirect = getWomanDirect(age,0);
			String earlyDirect = getWomanDirect(age,1);
			String preventDirect = getWomanDirect(age,2);
			retList.add(dietDirect);
			retList.add(earlyDirect);
			retList.add(preventDirect);
			return retList;
		}
		
		return null;
	}
	
	/**
	 * 获得年龄
	 * @param birthday
	 * @return
	 */
	public String getAge(Date birthday,Timestamp visitDate){
		Calendar cBirthday = CommonConvertUtils.timestampToCalendar(new Timestamp(birthday.getTime()));
		Calendar vsCalendar = CommonConvertUtils.timestampToCalendar(visitDate);
		return getBabyAge(vsCalendar,cBirthday);
	}
	
	/**
	 * 根据档案编号与随访日期获得年龄
	 * @param fileNo
	 * @param visitDate
	 * @return
	 */
	public String getAge(String fileNo,Timestamp visitDate){
		List list = getHibernateTemplate().find("From PersonalInfo Where fileNo = ?",fileNo);
		if(list.size() > 0){
			PersonalInfo person = (PersonalInfo)list.get(0);
			Timestamp birthday = person.getBirthday();
			if(birthday != null){
				Calendar cBirthday = CommonConvertUtils.timestampToCalendar(birthday);
				Calendar vsCalendar = CommonConvertUtils.timestampToCalendar(visitDate);
				return getBabyAge(vsCalendar,cBirthday);
			}
		}
		return null;
	}
	
	/**
	 * 依据年龄和指导类型获得指导描述
	 * @param age
	 * @param type
	 * @return
	 */
	public String getWomanDirect(String age,Integer type){
		String hql = "From WomanDirect Where type = ? And age Like ? Order By ID";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, type);
		query.setParameter(1, "%" + age + "%");
		List list = query.list();
		String ret = "";
		if(list.size() > 0){
			WomanDirect womanDirect = (WomanDirect)list.get(0);
			ret = womanDirect.getRemarks();
		}else{
			query.setParameter(1, "其它");
			List l = query.list();
			if(l.size() > 0){
				WomanDirect womanDirect = (WomanDirect)l.get(0);
				ret = womanDirect.getRemarks();
			}
		}
		return ret;
	}
	
	/**
	 * 计算年龄
	 * @param vsCalendar
	 * @param birthCalendar
	 * @return
	 */
	public String getBabyAge(Calendar vsCalendar,Calendar birthCalendar){
		if(vsCalendar.before(birthCalendar)){
			throw new RuntimeException(ERROR_DATE_OVER);
		}
		Integer vsDay = vsCalendar.get(Calendar.DAY_OF_MONTH);
		Integer vsMonth = vsCalendar.get(Calendar.MONTH) + 1;
		Integer vsYear = vsCalendar.get(Calendar.YEAR);
		Integer birthDay = birthCalendar.get(Calendar.DAY_OF_MONTH);
		Integer birthMonth = birthCalendar.get(Calendar.MONTH) + 1;
		Integer birthYear = birthCalendar.get(Calendar.YEAR);
		String age = "";
		int yearFlag = vsYear.compareTo(birthYear);
		int monthFlag = vsMonth.compareTo(birthMonth);
		int dayFlag = vsDay.compareTo(birthDay);

		Integer poorYear = vsYear - birthYear;
		Integer poorMonth = vsMonth - birthMonth;
		Integer poorDay = vsDay - birthDay;
		if(yearFlag > 0){
			if(monthFlag > 0){
				if(dayFlag >= 0){
					age = poorYear + TEXT_YEARS + poorMonth + TEXT_MONTH;
				}else{
					if(poorMonth.equals(1)){
						age = poorYear + TEXT_YEARS;
					}else{
						age = poorYear + TEXT_YEARS + (poorMonth - 1) + TEXT_MONTH;
					}
					
				}
			}else if(monthFlag == 0){
				if(dayFlag >= 0){
					age = poorYear + TEXT_YEARS;
				}else{
					age = (poorYear - 1) + TEXT_YEARS + (vsMonth + 12 - birthMonth) + TEXT_MONTH;
				}
			}else{
				if(poorYear.equals(1)){
					if(dayFlag >= 0){//Tested
						age = (vsMonth + 12 - birthMonth) + TEXT_MONTH;
					}else{
						Integer newPoorMonth = vsMonth + 12 - birthMonth;
						if(newPoorMonth.equals(1)){
							boolean isLeapYear = (birthYear % 4 == 0 && birthYear % 100 != 0) || birthYear % 400 == 0;
							if(isLeapYear){
								age = (LEAP_YEAR[vsMonth - 1] + vsDay - birthDay) + TEXT_DAY;
							}else{//Tested
								age = (UN_LEAP_YEAR[vsMonth - 1] + vsDay - birthDay) + TEXT_DAY;
							}
						}else{
							age = (newPoorMonth - 1) + TEXT_MONTH;
						}
					}
				}else{
					Integer newPoorMonth = vsMonth + 12 - birthMonth;
					if(dayFlag >= 0){
						age = (poorYear - 1) + TEXT_YEARS + newPoorMonth + TEXT_MONTH;
					}else{
						if(newPoorMonth.equals(1)){
							age = (poorYear - 1) + TEXT_YEARS;
						}else{
							age = (poorYear - 1) + TEXT_YEARS + (newPoorMonth - 1) + TEXT_MONTH;
						}
					}
				}
			}
		}else if(yearFlag == 0){
			if(monthFlag == 0){
				if(dayFlag >= 0){//Tested
					age = poorDay + TEXT_DAY;
				}
			}else if(monthFlag > 0){
				if(dayFlag >= 0){
					age = poorMonth + TEXT_MONTH;
				}else{
					if(poorMonth.equals(1)){
						boolean isLeapYear = (vsYear % 4 == 0 && vsYear % 100 != 0) || vsYear % 400 == 0;
						if(isLeapYear){
							age = (LEAP_YEAR[vsMonth - 1] + vsDay - birthDay) + TEXT_DAY;
						}else{
							age = (UN_LEAP_YEAR[vsMonth - 1] + vsDay - birthDay) + TEXT_DAY;
						}
					}else{
						age = (poorMonth - 1) + TEXT_MONTH;
					}
				}
			}
		}
		return age;
	}
}
