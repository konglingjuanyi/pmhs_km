package cn.net.tongfang.framework.security.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.SamModule;
import cn.net.tongfang.framework.security.vo.SamService;

public class ModuleServiceBo {

	private SamModule module;
	private List<SamService> services;
	
	public ModuleServiceBo() {
		super();
	}
	
	public ModuleServiceBo(SamModule module, List<SamService> services) {
		super();
		this.module = module;
		this.services = services;
	}

	public SamModule getModule() {
		return module;
	}
	public void setModule(SamModule module) {
		this.module = module;
	}
	public List<SamService> getServices() {
		return services;
	}
	public void setServices(List<SamService> services) {
		this.services = services;
	}
	
	
}
