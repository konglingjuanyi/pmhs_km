package cn.net.tongfang.web.service;

import cn.net.tongfang.framework.security.vo.VaccineInfo;
import cn.net.tongfang.web.service.bo.VaccineInfoBO;

public class VaccineInfoService extends HealthMainService<VaccineInfoBO> {

	@Override
	public String save(VaccineInfoBO data) throws Exception {
		String result = "";
		
		for(VaccineInfo  vaccineInfo: data.getVaccineInfo()){
			getHibernateTemplate().saveOrUpdate(vaccineInfo);
		}
		return result;
	}

	@Override
	public Object get(VaccineInfoBO data) throws Exception {
		return get_(data);
	}

}
