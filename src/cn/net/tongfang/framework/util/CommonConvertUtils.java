package cn.net.tongfang.framework.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author Jackstraw
 *
 */
public final class CommonConvertUtils {
	private static final Logger logger = Logger.getLogger(CommonConvertUtils.class);
	/**
	 * Timestamp转换为Date
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(Timestamp timestamp){
		return new Date(timestamp.getTime());
	}
	
	/**
	 * Timestamp转换为Calendar
	 * @param timestamp
	 * @return
	 */
	public static Calendar timestampToCalendar(Timestamp timestamp){
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		return cal;
	}
	
	/**
	 * String转换为Calendar
	 * @param date
	 * @return
	 */
	public static Calendar stringToCalendar(String date){
		Date d = stringToDate(date);
		if(d != null)
			return timestampToCalendar(new Timestamp(d.getTime()));
		return null;
	}
	
	/**
	 * String转换为Date，转换格式为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			logger.warn("invalid date format: " + e);
			try{
				d = format1.parse(date);
			} catch (ParseException e1) {
				logger.warn("invalid date format: " + e1);
				try{
					d = format2.parse(date);
				} catch (ParseException e2) {
					logger.warn("invalid date format: " + e2);
					return null;
				}
			}
		}
		return d;
	}
	
	
	/**
	 * Date转换为String，转换格式为：yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String d = null;
		try{
			d = format.format(date);
		}catch (Exception e) {
			logger.warn("invalid date format: " + e);
		}
		return d;
	}
	
	/**
	 * Date转换为String，转换格式为：yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToStringWithDelimiter(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d = null;
		try{
			d = format.format(date);
		}catch (Exception e) {
			logger.warn("invalid date format: " + e);
		}
		return d;
	}
	
	/**
	 * 两个日期比较获得天数
	 * @param birthday
	 * @param issuingDate
	 * @return
	 */
	public static long compareDate(Timestamp birthday,Timestamp issuingDate){
		return (issuingDate.getTime() - birthday.getTime())/(24*60*60*1000);
	}
	
//	public static int monthSubByDate(Timestamp birthday,Timestamp issuingDate){
//		
//		return 0;
//	}
	
	/**
	 * 判断出生医学证明的签发日期与出生日期的天数是否大于两个月
	 * @param birthday
	 * @param issuingDate
	 * @return
	 */
	public static boolean birthCertifiIsSupply(Timestamp birthday,Timestamp issuingDate){
		if(compareDate(birthday,issuingDate) > 61)
			return true;
		return false;
	}
	
	/**
	 * 一个日期减去指定天数
	 * @param date
	 * @param day
	 * @return
	 */
	public static Timestamp subDate(Timestamp date,long day){
		long time = date.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time = time - day;
		return new Timestamp(time);
	}
}
