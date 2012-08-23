package dlllib;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public class DllUtil{
	static{
		System.loadLibrary("wsock32");
		System.loadLibrary("Card");
		System.loadLibrary("eapagent");
		System.loadLibrary("enhisif");
		System.loadLibrary("libjcc");
		System.loadLibrary("VerifyLicAuth");
		System.loadLibrary("SiInterface");
        Native.register("SiInterface");
    }

	
	private static long serialno = 1;
	
    public static native int INIT(String s);
    public static native int BUSINESS_HANDLE(ByteBuffer s,Buffer r);

    
    public static void main(String[] args) throws Exception {
    	//String param1 = handParam(new String[]{"9100","11111111","BY_1","","201012301821590001","0000",inputParam(new String[]{""}),"1"});
    	test();
    }
    
    public static String handParam(String[] strs){
    	String ret = "";
    	for(String s : strs){
    		ret = ret+s+"^";
    	}
    	return ret;
    }
    
    public static String inputParam(String[] strs){
    	String ret = "";
    	for(String s : strs){
    		ret = ret+s+"|";
    	}
    	return ret;
    }
    
    public static void test() throws Exception{
    	int ret1 = INIT("");
        String r = "                                                         ";
        ByteBuffer pref = ByteBuffer.allocate(8000);
        ByteBuffer pref1 = ByteBuffer.allocate(8000);
        ByteBuffer buff = ByteBuffer.wrap(getGBKStr("9100^11111111^BY_1^^201012301821590001^0000^|^1^"));
        ByteBuffer buff1 = ByteBuffer.wrap(getGBKStr("2150^11111111^BY_1^1111-0000BY_1-20101227050^201012302010080002^0000^5309221012090052703|^1^"));
        //Pointer
        int ret2 = BUSINESS_HANDLE(buff,pref);
        int ret3 = BUSINESS_HANDLE(buff1,pref1);
        //====inparam=======2150^11111111^BY_1^^1111-0000BY_1-20101227050^0000^5309221012070051701|^1^
        System.out.println("==========="+ret1);
        System.out.println("==========="+ret2);
        System.out.println("==========="+new String(pref.array(),"gbk"));
        System.out.println("==========="+new String(pref1.array(),"gbk"));
        System.out.println("===========");
    }
    
    public static Map businessParam(Map param) throws UnsupportedEncodingException{
    	Map retMap = new HashMap();
    	String type = param.get("type")== null?"9100":(String)param.get("type");
    	String hospitalcode = param.get("hospitalcode")== null?"11111111":(String)param.get("hospitalcode");
    	String optempcode = param.get("optempcode")== null?"BY_1":(String)param.get("optempcode");
    	String circleNum = param.get("circleNum")== null?"":(String)param.get("circleNum");
    	String businessSerialno = param.get("businessSerialno")==null ?getBusinessSerialno(hospitalcode): (String)param.get("businessSerialno");
    	String centerCode = param.get("centerCode")== null?"0000":(String)param.get("centerCode");
    	String otherParam = param.get("otherParam")== null?"|":(String)param.get("otherParam");
    	String onlineFlag = param.get("onlineFlag")== null?"1":(String)param.get("onlineFlag");
    	ByteBuffer pref = ByteBuffer.allocate(8000);
    	String inputparam = handParam(new String[]{
    			type,hospitalcode,optempcode,circleNum,businessSerialno,centerCode,otherParam,onlineFlag
    	});
//    	ByteBuffer buff = ByteBuffer.wrap(inputparam.getBytes("gb2312"));
    	ByteBuffer buff = ByteBuffer.wrap(getGBKStr(inputparam));
    	int ret = BUSINESS_HANDLE(buff,pref);
    	retMap.put("returncode", ret);
    	String retStr = new String(pref.array(),"gbk").trim();
    	if(ret ==0){
			String[] retparam =  retStr.trim().split("\\^");
			retMap.put("businessSerialno", retparam[0]);
			retMap.put("onlineFlag", retparam[1]);
			retMap.put("returnparams", retparam[2]);
			if(retparam.length>3)
				retMap.put("otherMsg", retparam[3]);
    	}else{
    		retMap.put("errorMsg", retStr.trim());
    	}
    	return retMap;
    }
    
    private static byte[] getGBKStr(String str) throws UnsupportedEncodingException{
    	byte[] sor = str.getBytes("gbk");
    	byte[] t = new byte[sor.length+1];
    	for(int i = 0 ; i <t.length-1;i++){
    		t[i] = sor[i];
    	}
    	t[t.length-1]="\0".getBytes()[0];
    	return t;
    }
    public static String getBusinessSerialno(String hospitalcode){
    	String datestr = new java.sql.Date(new java.util.Date().getTime()).toString();
    	String serialno = "0000"+getSerialno();
    	return datestr +  hospitalcode + serialno.substring(serialno.length()-4);
    }
	public static long getSerialno() {
		return serialno++;
	}
    
    
    
}