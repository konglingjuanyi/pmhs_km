package cn.net.tongfang.web.service;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.web.service.bo.CureSwitchBO;

public class CureSwitchService extends HealthMainService<CureSwitchBO> {

	@Override
	public String save(CureSwitchBO data) throws Exception {
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		return save_(data);
	}

	@Override
	public Object get(CureSwitchBO data) throws Exception {
		data = (CureSwitchBO)get_(data);
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}

}
