package cn.net.tongfang.framework.util.service.vo;

import java.io.Serializable;

import cn.net.tongfang.framework.security.vo.SamModule;
import cn.net.tongfang.framework.security.vo.SamModuleCategory;

@SuppressWarnings("serial")
public class CatInfo implements Serializable{
	
	private SamModule module;
	private SamModuleCategory category;

	public CatInfo() {
		super();
	}

	public CatInfo(SamModule module, SamModuleCategory cate) {
		super();
		this.module = module;
		this.category = cate;
	}

	public SamModule getModule() {
		return module;
	}

	public void setModule(SamModule module) {
		this.module = module;
	}

	public SamModuleCategory getCategory() {
		return category;
	}

	public void setCategroy(SamModuleCategory cate) {
		this.category = cate;
	}

}
