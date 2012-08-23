package cn.net.tongfang.framework.security;

import java.util.List;

import javax.jws.WebService;

import cn.net.tongfang.framework.security.bo.ModuleServiceBo;
import cn.net.tongfang.framework.security.bo.OperatorBo;
import cn.net.tongfang.framework.security.bo.RoleModuleBo;
import cn.net.tongfang.framework.security.vo.HighRisk;
import cn.net.tongfang.framework.security.vo.ResidentPopulation;
import cn.net.tongfang.framework.security.vo.SamModule;
import cn.net.tongfang.framework.security.vo.SamModuleCategory;
import cn.net.tongfang.framework.security.vo.SamRole;
import cn.net.tongfang.framework.security.vo.SamService;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.DoctorsBO;


@WebService
public interface SecurityService {
	
	/**
	 * 取得所有的模块服务方法的对应
	 * @return list中为字符串数组，[0]moduleId, [1]serviceValue
	 */
	List<String[]> getModuleServices();
	
	
	
	
	/**
	 * Get Operator by username
	 * @param username username
	 * @return plain operator
	 */
	OperatorBo getOperatorByUsername(String username);
	
	
	/**
	 * 新增模块
	 * @return
	 */
	String addModule(ModuleServiceBo moduleServiceBo);
	
	/**
	 * 取所有模块目录
	 * @return
	 */
	List<SamModuleCategory> getAllModuleCategories();
	
	/**
	 * 查询服务方法
	 * @param name
	 * @return
	 */
	List<SamService> queryServiceByName(String name);
	
	/**
	 * 取得模块
	 * @param id
	 * @return
	 */
	ModuleServiceBo getModuleById(String id);
	
	/**
	 * 修改模块
	 * @return
	 */
	String updateModule(ModuleServiceBo moduleServiceBo);
	
	
	List<SamModule> queryModuleByNameCat(String moduleName, String catId);
	

	
	/**
	 * 根据名称取得模块目录，名称以like方式查询
	 * @param name 模块目录名词
	 * @return 模块目录列表
	 */
	PagingResult<SamModuleCategory> findModuleCategory(SamModuleCategory qryCond, PagingParam pp);




	/**
	 * 增加或更新模块目录
	 * @param category
	 * @return
	 */
	SamModuleCategory editModuleCategory(SamModuleCategory category);
	
	/**
	 * 删除模块目录
	 * @param category
	 * @return
	 */
	void removeModuleCategory(String categoryIds);
	
	
	PagingResult<SamRole> findRoles(SamRole qryCond, PagingParam pp);
	SamRole editRole(SamRole role);
	void removeRoles(String roles);
	
	PagingResult<SamModule> findModules(SamModule qryCond, PagingParam pp);
	SamModule editModule(SamModule module);
	void removeModules(String modules);
	
	List<RoleModuleBo> findModulesByRole(String roleId);
	void saveRoleModules(String roleId, List<String> moduleIds);
	
	ResidentPopulation editResidentPopulation(ResidentPopulation population);
	String getHospitalRelatedName(int id);
	
	PagingResult<ResidentPopulation> findResidentPopulation(ResidentPopulation qryCond, PagingParam pp);
	
	DoctorsBO editDoctors(DoctorsBO data);
	PagingResult<DoctorsBO> findDoctors(DoctorsBO qryCond, PagingParam pp);
	void removeDoctors(String doctors);
	
	PagingResult<HighRisk> findHighRisk(HighRisk qryCond,PagingParam pp);
	HighRisk editHighRisk(HighRisk data);
	void removeHighRisk(String highRiskId);
}
