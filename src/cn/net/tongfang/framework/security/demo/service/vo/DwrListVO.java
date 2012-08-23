package cn.net.tongfang.framework.security.demo.service.vo;

import java.util.HashMap;
import java.util.Map;

import cn.net.tongfang.framework.util.service.vo.PagingResult;

public class DwrListVO {
	private String msg =null;
	private String returncode = "";
	private String returnParam = "";
	private HashMap returnParamMap = new HashMap();
	
	public HashMap getReturnParamMap() {
		return returnParamMap;
	}
	public void setReturnParamMap(HashMap returnParamMap) {
		this.returnParamMap = returnParamMap;
	}
	public String getReturnParam() {
		return returnParam;
	}
	public void setReturnParam(String returnParam) {
		this.returnParam = returnParam;
	}
	private PagingResult<Object> data=null;
	
	public DwrListVO(String returncode,String msg){
		this.returncode = returncode;
		this.msg = msg;
	}
	
	public DwrListVO(String returncode,String msg,String returnparam){
		this.returncode = returncode;
		this.msg = msg;
		this.returnParam = returnparam;
	}
	
	public DwrListVO(String returncode,String returnparam , HashMap returnMap){
		this.returncode = returncode;
		this.returnParam = returnparam;
		this.returnParamMap = returnMap;
	}
	public DwrListVO(PagingResult<Object> data){
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public PagingResult<Object> getData() {
		return data;
	}
	public void setData(PagingResult<Object> data) {
		this.data = data;
	}
	public String getReturncode() {
		return returncode;
	}
	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}
	
	

	
}
