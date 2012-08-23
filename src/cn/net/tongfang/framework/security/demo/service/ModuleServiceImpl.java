package cn.net.tongfang.framework.security.demo.service;

import java.util.List;

import org.apache.log4j.Logger;

import cn.net.tongfang.framework.security.SecurityService;
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


public class ModuleServiceImpl implements ModuleService {
	
	Logger log = Logger.getLogger(ModuleServiceImpl.class);
	
	private SecurityService securityService;
	
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public List<String[]> getModuleServices() {		
		return this.securityService.getModuleServices();
	}

	public String addModule(ModuleServiceBo moduleServiceBo) {
		return this.securityService.addModule(moduleServiceBo);
	}

	public List<SamModuleCategory> getAllModuleCategories() {
		return this.securityService.getAllModuleCategories();
	}

	public ModuleServiceBo getModuleById(String id) {
		return this.securityService.getModuleById(id);
	}

	public List<SamService> queryServiceByName(String name) {
		return this.securityService.queryServiceByName(name);
	}

	public String updateModule(ModuleServiceBo moduleServiceBo) {
		return this.securityService.updateModule(moduleServiceBo);
	}

	public List<SamModule> queryModuleByNameCat(String moduleName, String catId) {
		return this.securityService.queryModuleByNameCat(moduleName, catId);
	}
	
	public PagingResult<SamModuleCategory> findModuleCategory(SamModuleCategory qryCond, PagingParam pp) {
		return this.securityService.findModuleCategory(qryCond, pp);
	}
	public SamModuleCategory editModuleCategory(SamModuleCategory category) {
		return this.securityService.editModuleCategory(category);
	}

	@Override
	public void removeModuleCategory(String categoryIds) {
		this.securityService.removeModuleCategory(categoryIds);
	}

	@Override
	public PagingResult<SamRole> findRoles(SamRole qryCond, PagingParam pp) {
		return this.securityService.findRoles(qryCond, pp);
	}

	@Override
	public SamRole editRole(SamRole role) {
		return this.securityService.editRole(role);
	}

	@Override
	public void removeRoles(String roles) {
		this.securityService.removeRoles(roles);
	}

	@Override
	public PagingResult<SamModule> findModules(SamModule qryCond, PagingParam pp) {
		return this.securityService.findModules(qryCond, pp);
	}

	@Override
	public PagingResult<ResidentPopulation> findResidentPopulation(ResidentPopulation qryCond, PagingParam pp) {
		return this.securityService.findResidentPopulation(qryCond, pp);
	}
	
	@Override
	public SamModule editModule(SamModule module) {
		return this.securityService.editModule(module);
	}

	@Override
	public void removeModules(String modules) {
		this.securityService.removeModules(modules);
	}

	@Override
	public List<RoleModuleBo> findModulesByRole(String roleId) {
		return this.securityService.findModulesByRole(roleId);
	}

	@Override
	public void saveRoleModules(String roleId, List<String> moduleIds) {
		this.securityService.saveRoleModules(roleId, moduleIds);
	}
	
	@Override
	public ResidentPopulation editResidentPopulation(ResidentPopulation population){
		return this.securityService.editResidentPopulation(population);
	}
	@Override
	public String getHospitalRelatedName(int id){
		return this.securityService.getHospitalRelatedName(id);
	}

	@Override
	public DoctorsBO editDoctors(DoctorsBO data) {
		// TODO Auto-generated method stub
		return this.securityService.editDoctors(data);
	}
	@Override
	public PagingResult<DoctorsBO> findDoctors(DoctorsBO qryCond, PagingParam pp){
		return this.securityService.findDoctors(qryCond, pp);
	}

	@Override
	public void removeDoctors(String doctors) {
		this.securityService.removeDoctors(doctors);
	}
	
	@Override
	public PagingResult<HighRisk> findHighRisk(HighRisk qryCond,
			PagingParam pp) {
		return this.securityService.findHighRisk(qryCond, pp);
	}

	@Override
	public HighRisk editHighRisk(HighRisk data) {
		return this.securityService.editHighRisk(data);
	}

	@Override
	public void removeHighRisk(String highRiskId) {
		this.securityService.removeHighRisk(highRiskId);
	}
}
