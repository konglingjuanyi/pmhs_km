package cn.net.tongfang.framework.security.bo;

import cn.net.tongfang.framework.security.vo.SamModule;

/**
 * Role -> modules
 */
public class RoleModuleBo {

	private SamModule module;
	private boolean checked;
	
	public RoleModuleBo(SamModule module, boolean checked) {
		this.module = module;
		this.checked = checked;
	}
	public RoleModuleBo() {
	}
	public SamModule getModule() {
		return module;
	}
	public void setModule(SamModule module) {
		this.module = module;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
