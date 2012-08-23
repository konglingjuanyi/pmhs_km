package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.AfterBornDirect;
import cn.net.tongfang.framework.security.vo.DiabetesMedications;
import cn.net.tongfang.framework.security.vo.DiabetesSymptom;
import cn.net.tongfang.framework.security.vo.VisitAfterBorn;

public class VisitAfterBornBO extends VisitAfterBorn{
	List<AfterBornDirect> afterBornDirect;

	public List<AfterBornDirect> getAfterBornDirect() {
		return afterBornDirect;
	}

	public void setAfterBornDirect(List<AfterBornDirect> afterBornDirect) {
		this.afterBornDirect = afterBornDirect;
	}
	
	
}
