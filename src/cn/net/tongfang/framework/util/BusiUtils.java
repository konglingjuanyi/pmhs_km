package cn.net.tongfang.framework.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class BusiUtils {
	/**
	 * 截去字符串结尾的特征串
	 * @param s
	 * @param tailString
	 * @return
	 */
	public static String trimTailSeq (final String s, final String tailString) {
		if ( s == null ) return s;
		String r = s;
		if ( r.endsWith( tailString ) )  {
			r = r.substring(0, r.length() - tailString.length());
			r = trimTailSeq(r, tailString);
		}
		return r;
	}
	
	
	public static Timestamp getChildAge() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 7);
		
		return new Timestamp( cal.getTimeInMillis() );
	}
}
