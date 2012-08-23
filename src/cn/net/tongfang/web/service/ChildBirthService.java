package cn.net.tongfang.web.service;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.BirthCertificate;
import cn.net.tongfang.framework.security.vo.ChildBirthRecord;
import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.web.service.bo.ChildBirthBO;
import cn.net.tongfang.web.util.BOHelper;
import cn.net.tongfang.web.util.FileNoGen;

public class ChildBirthService extends HibernateDaoSupport {
	private static final Logger log = Logger.getLogger(PersonalInfoService.class);
	private static final Integer BIRTH_USED = 2;//已使用的出生证明
	
	private FileNoGen fileNoGen;
	BOHelper boHelper = new BOHelper(ChildBirthBO.class);
	
	public void setFileNoGen(FileNoGen fileNoGen) {
		this.fileNoGen = fileNoGen;
	}
	public synchronized String save(ChildBirthBO data) throws Exception{
		if(CommonConvertUtils.birthCertifiIsSupply(data.getBirthdaybo(),data.getIssuingDatebo()))
			throw new RuntimeException("您没有权限补发出生医学证明！");
		
		String id = data.getId();
		if(id != null && !id.equals("")){
			return update(data);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		String inputPersonId = user.getUsername();
		BirthCertificate certifi = new BirthCertificate();
		ChildBirthRecord childBirthRecord = new ChildBirthRecord();
		BeanUtils.copyProperties(data, certifi);		
		BeanUtils.copyProperties(data, childBirthRecord);
		childBirthRecord.setInputPersonId(inputPersonId);
		childBirthRecord.setInputDate(currentDate);
		childBirthRecord.setFileNo(EncryptionUtils.encry(childBirthRecord.getFileNo()));
		
		certifi.setInputPersonId(inputPersonId);
		certifi.setInputDate(currentDate);
		certifi.setBirthday(data.getBirthdaybo());
		certifi.setIssuingDate(data.getIssuingDatebo());
		certifi.setIsEffectived(BIRTH_USED);
		
		if(user.getOrg().getIsOrgDepart().equals(0)){
			String disNo = data.getDistrictNum().trim();
			String tmpFileNo = fileNoGen.getNextFileNo(disNo);
			String fileNo = EncryptionUtils.encry(tmpFileNo);
//			childBirthRecord.setFileNo(fileNo);
			certifi.setFileNo(fileNo);
			
			HealthFile hf = new HealthFile();
			PersonalInfo info = new PersonalInfo();
			hf.setFileNo(fileNo);
			hf.setName(EncryptionUtils.encry(data.getName()));
			hf.setDistrictNumber(disNo);
			hf.setStatus(0);//
			District district = (District)getHibernateTemplate().get(District.class, disNo);
			String village = district.getName();
			hf.setVillage(village);
			district = (District)getHibernateTemplate().get(District.class, district.getParentId());
			String township = district.getName();
			hf.setTownship(township);
			hf.setAddress(township + village);
			hf.setResidenceAddress(township + village);
			hf.setInputDate(currentDate);
			hf.setInputPersonId(inputPersonId);
			hf.setBuildDate(currentDate);
			
			info.setFileNo(fileNo);
			info.setFileNoSub(EncryptionUtils.encry(tmpFileNo.substring(tmpFileNo.length() - 7)));
			info.setSex(data.getSex());
			info.setBirthday(data.getBirthdaybo());
			info.setLinkman(data.getMotherName() + "," + data.getFatherName());
			info.setLinkmanTel(data.getLinkmanTel());
			info.setInputPersonId(inputPersonId);
			info.setIdnumber(EncryptionUtils.encry(""));
			info.setInputDate(currentDate);
			hf.setPersonalInfo(info);
			
			getHibernateTemplate().save(hf);
			getHibernateTemplate().save(info);
		}else{
			certifi.setFileNo("");
		}
		childBirthRecord.setExecDistrictNum(user.getDistrictId());
		getHibernateTemplate().save(childBirthRecord);
		certifi.setIsSupply(0);
		getHibernateTemplate().merge(certifi);
		return certifi.getCertifiId();
	}
	
	public ChildBirthBO get(ChildBirthBO data) throws Exception{
		ChildBirthRecord childBirthRecord = (ChildBirthRecord)getHibernateTemplate().get(ChildBirthRecord.class, data.getId());
		BirthCertificate certifi = (BirthCertificate)getHibernateTemplate().find(" from BirthCertificate p where p.certifiId = ?", childBirthRecord.getCertifiId()).get(0);
		BeanUtils.copyProperties(certifi, data); // spring beanutils
		BeanUtils.copyProperties(childBirthRecord, data); // spring beanutils
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}

	private String update(ChildBirthBO data) throws Exception{		
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		ChildBirthRecord childBirthRecord = new ChildBirthRecord();
		BeanUtils.copyProperties(data, childBirthRecord); // spring beanutils
		getHibernateTemplate().update(childBirthRecord);
		return EncryptionUtils.decipher(childBirthRecord.getFileNo());
	}
}
