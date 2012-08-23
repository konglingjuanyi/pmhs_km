package cn.net.tongfang.framework.security.demo.service;

import cn.net.tongfang.framework.security.demo.service.vo.DwrListVO;
import cn.net.tongfang.framework.security.vo.RecipeVO;


public interface XnhInterfaceService {
	DwrListVO findSick(RecipeVO qryCond) throws Exception;
	
	DwrListVO regBill(RecipeVO recipeVO) throws Exception;
	
	DwrListVO uploadBill(RecipeVO recipeVO ,String type) throws Exception;
	
	DwrListVO prePayBill(RecipeVO recipeVO ,String type) throws Exception;
	
	DwrListVO comBussines(String inputparam ,String type) throws Exception;
	
}
