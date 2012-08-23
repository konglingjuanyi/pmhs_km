package cn.net.tongfang.web.service;

import cn.net.tongfang.web.service.bo.ChildrenMediExam3BO;

public class ChildrenMediExam3Service extends HealthMainService<ChildrenMediExam3BO> {

	@Override
	public String save(ChildrenMediExam3BO data) throws Exception {
		return save_(data);
	}

	@Override
	public Object get(ChildrenMediExam3BO data) throws Exception {
		return get_(data);
	}

}
