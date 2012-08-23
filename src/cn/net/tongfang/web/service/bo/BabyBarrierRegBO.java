package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.vo.BabyBarrierReg;
import cn.net.tongfang.framework.security.vo.OtotoxicityDrugHistory;

public class BabyBarrierRegBO extends BabyBarrierReg {
	private List<OtotoxicityDrugHistory> ototoxicityDrugHistory;

	public List<OtotoxicityDrugHistory> getOtotoxicityDrugHistory() {
		return ototoxicityDrugHistory;
	}

	public void setOtotoxicityDrugHistory(
			List<OtotoxicityDrugHistory> ototoxicityDrugHistory) {
		this.ototoxicityDrugHistory = ototoxicityDrugHistory;
	}
	
}
