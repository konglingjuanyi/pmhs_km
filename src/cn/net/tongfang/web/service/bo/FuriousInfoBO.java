package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.FuriousInfo;
import cn.net.tongfang.framework.security.vo.FuriousSymptom;

public class FuriousInfoBO extends FuriousInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<FuriousSymptom> furiousSymptom;

	public List<FuriousSymptom> getFuriousSymptom() {
		return furiousSymptom;
	}

	public void setFuriousSymptom(List<FuriousSymptom> furiousSymptom) {
		this.furiousSymptom = furiousSymptom;
	}

}
