package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.GravidityKey;
import cn.net.tongfang.framework.security.vo.VisitBeforeBorn;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.web.service.bo.VisitBeforeBornBO;

public class VisitBeforeBornService extends HealthMainService<VisitBeforeBornBO> {
	private SystemInformationUtils sysInfo;
	private WomanLastMedicalExamRecordService womanRocordService; 
	public void setSysInfo(SystemInformationUtils sysInfo) {
		this.sysInfo = sysInfo;
	}
	
	public void setWomanRocordService(
			WomanLastMedicalExamRecordService womanRocordService) {
		this.womanRocordService = womanRocordService;
	}

	@Override
	public String save(VisitBeforeBornBO data) throws Exception {
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		
		if(data.getItem().equals(2)){
			FirstVistBeforeBorn fvb = sysInfo.checkWomanSeparateDate(data.getFileNo(),data.getGravidity());
			if(fvb != null){
				Timestamp preVisitDate = fvb.getVisitDate();
				Timestamp CurrentVisitDate = data.getVisitDate();
				long day = CommonConvertUtils.compareDate(preVisitDate, CurrentVisitDate);
				if(day < 28)
					throw new RuntimeException("第2次产前随访与第1次产前随访的时间间隔至少为4周。");
			}
		}
		
		if(sysInfo.checkWomanMedicalExam(data.getFileNo()) == null){
			GravidityKey gravidityKey = new GravidityKey();
			gravidityKey.setFileNo(data.getFileNo());
			gravidityKey.setCurrentGravidity(data.getGravidity());
			getHibernateTemplate().save(gravidityKey);
		}
		
		if(data.getHighRisk().equals("是")){
			womanRocordService.save(data.getFileNo(), data.getVisitDate(), data.getHighRiskRemark(), 1);
		}else if(data.getHighRisk().equals("否")){
			if(womanRocordService.get(data.getFileNo())){
				womanRocordService.update(data.getFileNo(), 0);
			}
		}
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		return save_(data);
	}

	@Override
	public Object get(VisitBeforeBornBO data) throws Exception {
		data = (VisitBeforeBornBO)get_(data);;
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}
	
	public VisitBeforeBornBO getPrintInfo(VisitBeforeBornBO data){
		try{
			data = (VisitBeforeBornBO)get(data);
			Integer items = data.getItem();
			if(items > 5){
				return null;
			}
		}catch(Exception ex){
			return null;
		}
		return data;
	}
	
	public String getItems(String fileNo){
		List list = getHibernateTemplate().find("From VisitBeforeBorn Where fileNo = ? Order By item ASC", EncryptionUtils.encry(fileNo));
		String result = "";
		if(list.size() > 0){
			for(Object obj : list){
				VisitBeforeBorn visitBeforeBorn = (VisitBeforeBorn)obj;
				result += visitBeforeBorn.getItem() + ",";				
			}
		}
		if(!result.equals(""))
			result = result.substring(0,result.length() - 1);
		return result;
	}
	
	public String getLastMensesAndDay(String fileNo,Integer item){
		List list = getHibernateTemplate().find("From FirstVistBeforeBorn Where fileNo = ?", EncryptionUtils.encry(fileNo));
		if(list.size() > 0){
			FirstVistBeforeBorn firstVistBeforeBorn = (FirstVistBeforeBorn)list.get(0);
			if(firstVistBeforeBorn.getLastMenses() != null){
				Calendar cal = CommonConvertUtils.timestampToCalendar(firstVistBeforeBorn.getLastMenses());
				if(item.equals(2) || item.equals(3)){
					cal.add(Calendar.DATE, (item - 1) * 30 + 140);
					return CommonConvertUtils.dateToString(cal.getTime());
				}else if(item >= 4 && item <= 6){
					cal.add(Calendar.DATE, (item - 3) * 14 + 210);
					return CommonConvertUtils.dateToString(cal.getTime());
				}else{
					cal.add(Calendar.DATE, (item - 6) * 7 + 252);
					return CommonConvertUtils.dateToString(cal.getTime());
				}
			}
		}
		return null;
	}
}
