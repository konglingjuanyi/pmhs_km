package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.BeforeBornDirect;
import cn.net.tongfang.framework.security.vo.VisitBeforeBorn;

public class VisitBeforeBornBO extends VisitBeforeBorn{
	List<BeforeBornDirect> beforeBornDirect;

	public List<BeforeBornDirect> getBeforeBornDirect() {
		return beforeBornDirect;
	}

	public void setBeforeBornDirect(List<BeforeBornDirect> beforeBornDirect) {
		this.beforeBornDirect = beforeBornDirect;
	}
	
}
