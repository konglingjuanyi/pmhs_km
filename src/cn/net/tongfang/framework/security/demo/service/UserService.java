package cn.net.tongfang.framework.security.demo.service;

import cn.net.tongfang.framework.security.demo.service.vo.DwrListVO;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;


public interface UserService {
	
	boolean findUser(SamTaxempcode qryCond) throws Exception;
	
	String regUser(SamTaxempcode regVO) throws Exception;
		
}
