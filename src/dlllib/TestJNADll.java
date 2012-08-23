package dlllib;

import java.nio.Buffer;


import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class TestJNADll{
	static {
		System.loadLibrary("wsock32");
		System.loadLibrary("Card");
		System.loadLibrary("eapagent");
		System.loadLibrary("enhisif");
		System.loadLibrary("libjcc");
		System.loadLibrary("VerifyLicAuth");
		System.loadLibrary("SiInterface");
        Native.register("SiInterface");
    }

    public static native int INIT(String s);
    public static native int BUSINESS_HANDLE(String s,Pointer r);

    public static void main(String[] args) throws Exception {
    	int ret1 = INIT("");
        String r = "                                                         ";
        Pointer p = new Memory(8000);
        Pointer p1 = new Memory(8000);
        //Pointer
        int ret2 = BUSINESS_HANDLE("9100^11111111^BY_1^^201012301821590001^0000^|^1^",p);
        int ret3 = BUSINESS_HANDLE("2150^11111111^BY_1^1111-0000BY_1-20101227050^201012302010080002^0000^5309221012090052703|^1^",p1);
        System.out.println("==========="+ret1);
        System.out.println("==========="+ret2);
        System.out.println("==========="+p.getString(0));
        System.out.println("==========="+new String(p1.getByteArray(0, 8000),"gbk"));
    }

}