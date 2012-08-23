package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.CheckDirect3;
import cn.net.tongfang.framework.security.vo.CheckSickness;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam3;

public class ChildrenMediExam3BO extends ChildrenMediExam3{
	List<CheckSickness> checkSickness;
	List<CheckDirect3> checkDirect3;
	
	public List<CheckSickness> getCheckSickness() {
		return checkSickness;
	}
	public void setCheckSickness(List<CheckSickness> checkSickness) {
		this.checkSickness = checkSickness;
	}
	public List<CheckDirect3> getCheckDirect3() {
		return checkDirect3;
	}
	public void setCheckDirect3(List<CheckDirect3> checkDirect3) {
		this.checkDirect3 = checkDirect3;
	}
	
}
