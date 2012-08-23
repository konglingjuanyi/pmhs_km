package cn.net.tongfang.web.service;

import cn.net.tongfang.web.service.bo.InfectionReportBO;

public class InfectionReportService extends HealthMainService<InfectionReportBO> {

	@Override
	public String save(InfectionReportBO data) throws Exception {
		return save_(data);
	}

	@Override
	public Object get(InfectionReportBO data) throws Exception {
		return get_(data);
	}

}
