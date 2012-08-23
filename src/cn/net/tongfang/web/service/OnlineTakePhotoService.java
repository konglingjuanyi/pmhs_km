package cn.net.tongfang.web.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class OnlineTakePhotoService {
	public static void save(String key,String picName){
		File parentFile = new File(Thread.currentThread().getContextClassLoader().getResource("log4j.properties").getPath()).getParentFile();
		File file = new File(parentFile.getPath() + "/onlineTakePhoto.properties");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		Properties prop = new Properties();
		OutputStream out = null;
		try {
			prop.load(new FileInputStream(file));
			picName = picName + ",0";
			prop.setProperty(key, picName);
			out = new FileOutputStream(file);
			prop.store(out,key + "=" + picName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public static String get(String key){
		File parentFile = new File(Thread.currentThread().getContextClassLoader().getResource("log4j.properties").getPath()).getParentFile();
		File file = new File(parentFile.getPath() + "/onlineTakePhoto.properties");
		Properties prop = new Properties();
		OutputStream out = null;
		try {
			prop.load(new FileInputStream(file));
			String props = prop.getProperty(key);
			String[] propsArray = props.split(",");
			String picName = propsArray[0];
			String isUsed = propsArray[1];
			if(isUsed.equals("0")){
				prop.setProperty(key, picName + ",1");
				out = new FileOutputStream(file);
				prop.store(out,key + "=" + picName + ",1");
				return picName;
			}else{
				return "";
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
