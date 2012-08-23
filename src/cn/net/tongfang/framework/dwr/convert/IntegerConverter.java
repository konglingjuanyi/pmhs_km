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

public class IntegerConverter extends AbstractConverter {
	private static final Logger logger = Logger.getLogger(IntegerConverter.class);

	
	public Object convertInbound(Class<?> paramType, InboundVariable data)
			throws ConversionException {
		if (data.isNull()) {
			return null;
		}
		String value = data.getValue();
		Integer num = null;
		if(value == null || "".equals(value.trim())){
			return null;
		}else{
			num = Integer.parseInt(value);
		}
		return num;
	}

	public OutboundVariable convertOutbound(Object data, OutboundContext outctx)
			throws ConversionException {
        long millis;

        if(data == null){
        	return new NonNestedOutboundVariable("");
        }else{
        	return new NonNestedOutboundVariable(""+data+"");
        }
        //return new NonNestedOutboundVariable("new Date(" + millis + ")");
	}

}
