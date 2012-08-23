package cn.net.tongfang.framework.security.demo.service;

import java.util.List;

import cn.net.tongfang.framework.security.bo.ModuleServiceBo;
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


public interface ModuleService {
	
	/**
	 * 获得所有模块以及对应服务
	 * @return
	 */
	List<String[]> getModuleServices();
	
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
	
	
	/**
	 * 查询模块
	 * @param moduleName 模糊查询模块明朝
	 * @param catId 模块目录ID
	 * @return
	 */
	List<SamModule> queryModuleByNameCat(String moduleName, String catId);
	
	/**
	 * 根据名称取得模块目录，名称以like方式查询
	 * @param name 模块目录名词
	 * @param pp Paging parameter
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
