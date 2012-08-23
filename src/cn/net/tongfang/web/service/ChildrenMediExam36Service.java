package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam36;
import cn.net.tongfang.framework.security.vo.WomanPhysicalItems;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.framework.util.service.GenDefaultVal;
import cn.net.tongfang.web.service.bo.ChildrenMediExam36BO;
import cn.net.tongfang.web.util.BOHelper;

public class ChildrenMediExam36Service extends HibernateDaoSupport {
	private GenDefaultVal childDirect;
	private SystemInformationUtils sysInfo;
	BOHelper boHelper = new BOHelper(ChildrenMediExam36BO.class);
	private ChildLastMedicalExamRecordService childRocordService;
    public void setChildDirect(GenDefaultVal childDirect) {
		this.childDirect = childDirect;
	}
    public void setSysInfo(SystemInformationUtils sysInfo) {
		this.sysInfo = sysInfo;
	}
    public void setChildRocordService(
			ChildLastMedicalExamRecordService childRocordService) {
		this.childRocordService = childRocordService;
	}
	private String update(ChildrenMediExam36BO data) throws Exception{
//		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		ChildrenMediExam36 childrenMediExam36 = new ChildrenMediExam36();
		WomanPhysicalItems womanItems = new WomanPhysicalItems();
		BeanUtils.copyProperties(data, childrenMediExam36); 
		getHibernateTemplate().update(childrenMediExam36);
		
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
		womanItems.setHearing(data.getHearingChild());
		womanItems.setDirectAge(childDirect.getAge(data.getFileNo(),data.getVisitDate()));
		if(data.getMedicalExamId() != null){
			getHibernateTemplate().update(womanItems);
		}else{
			womanItems.setInputDate(new Timestamp(System.currentTimeMillis()));
			getHibernateTemplate().merge(womanItems);
		}
		
		String id = childrenMediExam36.getId();
		boHelper.deleteDetails(data, getSession(), "childrenMediExam36id", id);
		boHelper.setFK(data, id, "childrenMediExam36id");
		boHelper.saveDetails(data, getHibernateTemplate());
		return id;
	}
    
//	@Override
	public String save(ChildrenMediExam36BO data) throws Exception {
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
		
		
		if(sysInfo.checkChildrenMedicalExamIsInput(data.getFileNo(),data.getCheckItem(),"ChildrenMediExam36",null)){
			throw new RuntimeException("编号为" + EncryptionUtils.decipher(data.getFileNo()) + "的" + 
					data.getCheckItem() + "儿童体检记录已经录入系统，不可以重复录入。");
		}
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String inputPersonId = user.getUsername();
		Timestamp currentDate = new java.sql.Timestamp(System.currentTimeMillis());
		
		data.setExecDistrictNum(user.getDistrictId());
		data.setInputPersonId(inputPersonId);
		data.setInputDate(currentDate);
		ChildrenMediExam36 childrenMediExam36 = new ChildrenMediExam36();
		WomanPhysicalItems womanItems = new WomanPhysicalItems();
		BeanUtils.copyProperties(data, childrenMediExam36); 
		BeanUtils.copyProperties(data, womanItems);
		getHibernateTemplate().save(childrenMediExam36);
		
		womanItems.setId(childrenMediExam36.getId());
		womanItems.setHeart(data.getHeartChild());
		womanItems.setHearing(data.getHearingChild());
		womanItems.setDirectAge(childDirect.getAge(data.getFileNo(),data.getVisitDate()));
		getHibernateTemplate().save(womanItems);
		
		boHelper.setFK(data, childrenMediExam36.getId(), "childrenMediExam36id");
		boHelper.saveDetails(data, getHibernateTemplate());
		return childrenMediExam36.getId();
	}
	
//	@Override
	public Object get(ChildrenMediExam36BO data) throws Exception {
//		data = (ChildrenMediExam36BO)get_(data);
//		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
//		return data;
		ChildrenMediExam36 childrenMediExam36 = (ChildrenMediExam36)getHibernateTemplate().get(ChildrenMediExam36.class,data.getId());
		List womanItemsList = getHibernateTemplate().find("From WomanPhysicalItems Where id = ?",data.getId());
		if(womanItemsList.size() > 0){
			WomanPhysicalItems womanItems = (WomanPhysicalItems)womanItemsList.get(0);
			BeanUtils.copyProperties(womanItems, data);
			data.setHeartChild(womanItems.getHeart());
			data.setHearingChild(womanItems.getHearing());
		}
		BeanUtils.copyProperties(childrenMediExam36, data); 
//		data = (BabyVisitBO) boHelper.readAll(data, getHibernateTemplate());
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
//		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
//		data.setExecDistrictNum(user.getDistrictId());
		boHelper.loadDetails(data, getHibernateTemplate(), "childrenMediExam36id", childrenMediExam36.getId());
		return data;
	}

}
