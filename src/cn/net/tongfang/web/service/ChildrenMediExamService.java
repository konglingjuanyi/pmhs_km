package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam;
import cn.net.tongfang.framework.security.vo.WomanPhysicalItems;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.framework.util.service.GenDefaultVal;
import cn.net.tongfang.web.service.bo.ChildrenMediExamBO;

public class ChildrenMediExamService extends HealthMainService<ChildrenMediExamBO> {
	private GenDefaultVal childDirect;
	private SystemInformationUtils sysInfo;
	private ChildLastMedicalExamRecordService childRocordService;
    public void setChildDirect(GenDefaultVal childDirect) {
		this.childDirect = childDirect;
	}
    
    public void setChildRocordService(
			ChildLastMedicalExamRecordService childRocordService) {
		this.childRocordService = childRocordService;
	}

	public void setSysInfo(SystemInformationUtils sysInfo) {
		this.sysInfo = sysInfo;
	}

	private String update(ChildrenMediExamBO data) throws Exception{
//		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		ChildrenMediExam childrenMediExam = new ChildrenMediExam();
		WomanPhysicalItems womanItems = new WomanPhysicalItems();
		BeanUtils.copyProperties(data, childrenMediExam); 
		getHibernateTemplate().update(childrenMediExam);
		
		//如果更新照片，则把已经存在的照片删除
//		WomanPhysicalItems womanPicture = (WomanPhysicalItems)getHibernateTemplate().find("From WomanPhysicalItems Where id = ?",babyVisit.getId()).get(0);
//		String picture = womanPicture.getOnlinePhoto();
//		if(picture != null && !picture.equals("")){
//			File file = new File("/" + picture);
//			if(file.exists()){
//				file.delete();
//			}
//		}
		BeanUtils.copyProperties(data, womanItems);
		womanItems.setHeart(data.getHeartChild());
		womanItems.setEvaluate(data.getEvaluateChild());
		womanItems.setDirectAge(childDirect.getAge(data.getFileNo(),data.getVisitDate()));
		if(data.getMedicalExamId() != null){
			getHibernateTemplate().update(womanItems);
		}else{
			womanItems.setInputDate(new Timestamp(System.currentTimeMillis()));
			getHibernateTemplate().merge(womanItems);
		}
		String id = childrenMediExam.getId();
		boHelper.deleteDetails(data, getSession(), "childrenMediExamId", id);
		boHelper.setFK(data, id, "childrenMediExamId");
		boHelper.saveDetails(data, getHibernateTemplate());
		return id;
	}
    
//	@Override
	public String save(ChildrenMediExamBO data) throws Exception {
//		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
//		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
//		data.setExecDistrictNum(user.getDistrictId());
//		return save_(data);
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		if(data.getHighRisk().equals("是")){
			childRocordService.save(data.getFileNo(), data.getVisitDate(), data.getHighRiskRemark(), 1);
		}else if(data.getHighRisk().equals("否")){
			if(childRocordService.get(data.getFileNo())){
				childRocordService.update(data.getFileNo(), 0);
			}
		}
		
		if(data.getId() != null && !data.getId().equals("")){
			System.out.println("Updating...");
			return update(data);
		}
		
		
		if(sysInfo.checkChildrenMedicalExamIsInput(data.getFileNo(),data.getCheckItem(),"ChildrenMediExam",data.getDataType())){
			throw new RuntimeException("编号为" + EncryptionUtils.decipher(data.getFileNo()) + "的" + 
					data.getCheckItem() + "儿童体检记录已经录入系统，不可以重复录入。");
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String inputPersonId = user.getUsername();
		Timestamp currentDate = new java.sql.Timestamp(System.currentTimeMillis());
		
		data.setExecDistrictNum(user.getDistrictId());
		data.setInputPersonId(inputPersonId);
		data.setInputDate(currentDate);
		ChildrenMediExam childrenMediExam = new ChildrenMediExam();
		WomanPhysicalItems womanItems = new WomanPhysicalItems();
		BeanUtils.copyProperties(data, childrenMediExam); 
		BeanUtils.copyProperties(data, womanItems);
		getHibernateTemplate().save(childrenMediExam);
		
		womanItems.setId(childrenMediExam.getId());
		womanItems.setHeart(data.getHeartChild());
		womanItems.setEvaluate(data.getEvaluateChild());
		womanItems.setDirectAge(childDirect.getAge(data.getFileNo(),data.getVisitDate()));
		getHibernateTemplate().save(womanItems);
		
		boHelper.setFK(data, childrenMediExam.getId(), "childrenMediExamId");
		boHelper.saveDetails(data, getHibernateTemplate());
		return childrenMediExam.getId();
	}
	
//	@Override
//	public Object get(ChildrenMediExamBO data) throws Exception {
//		data = (ChildrenMediExamBO)get_(data);
//		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
//		return data;
//	}
	public ChildrenMediExamBO get(ChildrenMediExamBO data) throws Exception {
		ChildrenMediExam childrenMediExam = (ChildrenMediExam)getHibernateTemplate().get(ChildrenMediExam.class,data.getId());
		List womanItemsList = getHibernateTemplate().find("From WomanPhysicalItems Where id = ?",data.getId());
		if(womanItemsList.size() > 0){
			WomanPhysicalItems womanItems = (WomanPhysicalItems)womanItemsList.get(0);
			BeanUtils.copyProperties(womanItems, data);
			data.setHeartChild(womanItems.getHeart());
			data.setEvaluateChild(womanItems.getEvaluate());
		}
		BeanUtils.copyProperties(childrenMediExam, data); 
//		data = (BabyVisitBO) boHelper.readAll(data, getHibernateTemplate());
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
//		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
//		data.setExecDistrictNum(user.getDistrictId());
		boHelper.loadDetails(data, getHibernateTemplate(), "childrenMediExamId", childrenMediExam.getId());
		return data;
	}
}
