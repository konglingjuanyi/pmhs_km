package cn.net.tongfang.framework.dwr.convert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.directwebremoting.ConversionException;
import org.directwebremoting.extend.AbstractConverter;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.NonNestedOutboundVariable;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;

public class TimestampConverter extends AbstractConverter {
	private static final Logger logger = Logger.getLogger(TimestampConverter.class);
	private static String PATTERN = "yyyy-MM-dd";
	private static String PATTERN_FALLBACK = "yyyyMMdd";
	private static String PATTERN_HOUR_FALLBACK = "yyyyMMddHHmmss";
	
	public Object convertInbound(Class<?> paramType, InboundVariable data)
			throws ConversionException {
		if (data.isNull()) {
			return null;
		}

		String value = data.getValue();

		Timestamp date = null;
		if ( value.length() > 0 ) {
			DateFormat df = new SimpleDateFormat(PATTERN); 
			DateFormat dfFallback = new SimpleDateFormat(PATTERN_FALLBACK);
			DateFormat dfHourFallback = new SimpleDateFormat(PATTERN_HOUR_FALLBACK); 
			try {
				date = new Timestamp( dfHourFallback.parse(value).getTime() );
			} catch (ParseException e1) {
				logger.warn("invalid date format: " + value);
				try {
					date = new Timestamp(df.parse(value).getTime());				
				} catch (ParseException e2) {
					logger.warn("invalid date format: " + value);
					try{
						date = new Timestamp(dfFallback.parse(value).getTime());
					}catch (ParseException e3) {
						logger.warn("invalid date format: " + value);
						return null;
					}
				}
			}
			
		}

		return date;
	}

	public OutboundVariable convertOutbound(Object data, OutboundContext outctx)
			throws ConversionException {
        long millis;

        if (data instanceof Calendar)
        {
            Calendar cal = (Calendar) data;
            millis = cal.getTime().getTime();
        }
        else if (data instanceof Date)
        {
            Date date = (Date) data;
            millis = date.getTime();
        }
        else
        {
            throw new ConversionException(data.getClass());
        }

        return new NonNestedOutboundVariable("new Date(" + millis + ")");
	}

}
