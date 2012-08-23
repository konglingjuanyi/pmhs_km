package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.Doctors;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.ModuleMgr;
import cn.net.tongfang.framework.util.service.vo.CatInfo;
import cn.net.tongfang.web.service.bo.PersonalInfoFBO;
import cn.net.tongfang.web.util.BOHelper;
import cn.net.tongfang.web.util.FileNoGen;

public class PersonalInfoService extends HibernateDaoSupport {
	private static final Logger log = Logger.getLogger(PersonalInfoService.class);

	private FileNoGen fileNoGen;
	BOHelper boHelper = new BOHelper(PersonalInfoFBO.class);
	private ModuleMgr moduleMgr;
	public void setFileNoGen(FileNoGen fileNoGen) {
		this.fileNoGen = fileNoGen;
	}
	
	public void setModuleMgr(ModuleMgr moduleMgr) {
		this.moduleMgr = moduleMgr;
	}

	public synchronized String save(PersonalInfoFBO data) throws Exception{
		
		// update switch
		String fileno = data.getFileNo();
		
		//if (fileno.length() == 18){
		if(fileno != null && !fileno.equals("")){
			System.out.println("updating...");
			return update(data);
		}
		// save routine
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();

		String disNo = data.getDistrictNumber();
//		String disNo = data.getId();
		
		//检查该档案是否已经存在，如果存在，则不允许保存，以防止一个人建多份档案，检查的条件：姓名、年龄、乡镇(街道)名称、村(居)委会名称
		String checkName = data.getName();
		Timestamp checkBirthday = data.getBirthday();
		String checkTownship = data.getTownship();
		String checkVillage = data.getVillage();
		String checkSex = data.getSex();
		String sql = "From HealthFile A,PersonalInfo B Where A.fileNo = B.fileNo And A.name = '" + EncryptionUtils.encry(checkName) + "' And " +
				"A.township = '" + checkTownship + "' And A.village = '" + checkVillage + "' And B.birthday = '" + checkBirthday + "' And " + 
				"B.sex = '" + checkSex + "'";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		if(list.size() > 0){
			throw new RuntimeException(checkName + "已经建立档案，不需要重新建立!!!");
		}
		
		if (disNo == null || disNo.trim().equals("")) {
			throw new RuntimeException("no districtNum!!!");
		}
		
		/*if(fileno.length() != 5 && fileno.length() != 2){
			throw new RuntimeException("输入正确的个人编码!!!");
		}
		
		String fileNo = disNo + fileno; 
		if(fileNo.length() != 18){
			fileNo = data.getHomeId() + fileno;
		}*/
		String fileNo = fileNoGen.getNextFileNo(disNo);
		String tmpFileNo = fileNo;
//		String tmpFileNo = EncryptionUtils.encry(fileNo);
		PersonalInfo info = new PersonalInfo();
		HealthFile hf = new HealthFile();

		BeanUtils.copyProperties(data, info); // spring beanutilsfil
		BeanUtils.copyProperties(data, hf); // spring beanutils
		hf.setTel(data.getTel0());
		fileNo = EncryptionUtils.encry(fileNo);
		hf.setFileNo(fileNo);
		hf.setName(EncryptionUtils.encry(data.getName()));
		System.out.println("file no " + fileNo);
		System.out.println("disno " + hf.getDistrictNumber());
		System.out.println("buildPersion " + hf.getBuildPerson());
		

		hf.setNamePng("nmpng");
		hf.setInputPersonId(user.getUsername());
		hf.setStatus(0);
		getHibernateTemplate().save(hf);
		
		
		info.setIdnumber(EncryptionUtils.encry(data.getIdnumber()));
		info.setFileNo(fileNo);
		info.setFileNoSub(EncryptionUtils.encry(tmpFileNo.substring(tmpFileNo.length() - 7)));
		info.setInputDate(new java.sql.Timestamp(System.currentTimeMillis()));
		info.setInputPersonId(user.getUsername()); //当前登录用户
		
		getHibernateTemplate().save(info);
		boHelper.setFK(data, info.getId(), "personalInfoId");
		boHelper.saveDetails(data, getHibernateTemplate());

		return EncryptionUtils.decipher(fileNo);
	}
	
	public PersonalInfoFBO get(PersonalInfoFBO data) throws Exception{
		String fileNo = EncryptionUtils.encry(data.getFileNo());
		HealthFile hf = (HealthFile)getHibernateTemplate().get(HealthFile.class, fileNo);
		PersonalInfo pi = (PersonalInfo)getHibernateTemplate().find(" from PersonalInfo p where p.fileNo = ?", fileNo).get(0);
		BeanUtils.copyProperties(hf, data); // spring beanutils
		BeanUtils.copyProperties(pi, data); // spring beanutils
		data.setTel0(hf.getTel());
		data.setFileNo(EncryptionUtils.decipher(fileNo));
		data.setName(EncryptionUtils.decipher(data.getName()));
		data.setIdnumber(EncryptionUtils.decipher(data.getIdnumber()));
		boHelper.loadDetails(data, getHibernateTemplate(), "personalInfoId", pi.getId());
		return data;
	}

	public PersonalInfoFBO getBasicInfo(PersonalInfoFBO data) throws Exception{
		String hql = "From HealthFile A,PersonalInfo B Where A.fileNo = ? And A.fileNo = B.fileNo";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, EncryptionUtils.encry(data.getFileNo()));
		List list = query.list();
		if(list.size() > 0){
			Object[] obj = (Object[])list.get(0);
			HealthFile hf = (HealthFile)obj[0];
			PersonalInfo pi = (PersonalInfo)obj[1];
			BeanUtils.copyProperties(hf, data); // spring beanutils
			BeanUtils.copyProperties(pi, data); // spring beanutils
			data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
			data.setName(EncryptionUtils.decipher(data.getName()));
			data.setIdnumber(EncryptionUtils.decipher(data.getIdnumber()));
		}
		return data;
	}
	
	public String update(PersonalInfoFBO data) throws Exception{
		
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();

		PersonalInfo info = new PersonalInfo();
		HealthFile hf = new HealthFile();
		
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		
		BeanUtils.copyProperties(data, info); // spring beanutils
		BeanUtils.copyProperties(data, hf); // spring beanutils
		hf.setTel(data.getTel0());
		hf.setName(EncryptionUtils.encry(data.getName()));
		hf.setNamePng("nmpng");
		hf.setInputPersonId(user.getUsername());
		hf.setModifyPerson(user.getUsername());
		java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		
		String sql = "Select hf.inputDate ,info.inputDate From HealthFile hf,PersonalInfo info Where" +
					" hf.fileNo = info.fileNo And hf.fileNo = '" + hf.getFileNo() + "'";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		if(list.size() > 0){
			for(Object objs : list){
				Object[] obj = (Object[])objs;
				if(obj[0] == null){
					hf.setInputDate(ts);
				}else{
					Timestamp hfTimestamp = (Timestamp)obj[0];
					hf.setInputDate(hfTimestamp);
				}
				if(obj[1] == null){
					info.setInputDate(ts);
				}else{
					Timestamp hfTimestamp = (Timestamp)obj[1];
					info.setInputDate(hfTimestamp);
				}
			}
		}
		
		hf.setLastModifyDate(ts);
		
		info.setInputPersonId(user.getUsername()); //当前登录用户
		info.setIdnumber(EncryptionUtils.encry(data.getIdnumber()));
		getHibernateTemplate().update(hf);
		getHibernateTemplate().update(info);
		String id = info.getId();
		boHelper.deleteDetails(data, getSession(), "personalInfoId", id);
		boHelper.setFK(data, info.getId(), "personalInfoId");
		boHelper.saveDetails(data, getHibernateTemplate());
		return EncryptionUtils.decipher(info.getFileNo());
	}

	/**
	 * 通过fileNo查找姓名、出生日期
	 * @param fileNo
	 * @return
	 */

	public List getPersonInfo(String fileNo) throws Exception{
		fileNo = EncryptionUtils.encry(fileNo);
		String sql = "from PersonalInfo a,HealthFile b where a.fileNo = b.fileNo and a.fileNo = ?";
		List list = getHibernateTemplate().find(sql,fileNo);
		String result = "";
		if(list.size() > 0){
//			for(Object obj : list){
				Object[] o = (Object[])list.get(0);
				PersonalInfo p = (PersonalInfo)o[0];
				HealthFile h = (HealthFile)o[1];
				Calendar cal = Calendar.getInstance();
				
				result = EncryptionUtils.decipher(h.getFileNo()) + ',' + EncryptionUtils.decipher(h.getName()) + "," + 
					p.getBirthday() + "," + p.getSex() + "," + (cal.get(Calendar.YEAR) - CommonConvertUtils.timestampToCalendar(p.getBirthday()).get(Calendar.YEAR));
//			}
			log.debug("get information success");
		}
		List<CatInfo> catInfos =  moduleMgr.getUserCatInfo();
		List results = new ArrayList();
		results.add(result);
		results.add(catInfos);
		return results;
	}
	
	/**
	 * 获得建档单位
	 * @return
	 */
	public List getOrg(){
		String sql = "Select id,name From SamTaxorgcode Where id > 1";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		if(list.size() > 0)
			return list;
		return null;
	}
	
	/**
	 * 获得本医院的医生
	 * @param hospId
	 * @return
	 */
	public List getDoctors(int hospId){
		String sql = "Select id,name From Doctors Where hospId = " + hospId;
		Query query = getSession().createQuery(sql);
		List list = query.list();
		if(list.size() > 0)
			return list;
		return null;
	}
	
	/**
	 * 保存
	 * @param doctor
	 */
	public void saveDoctors(String[] doctor){
		Doctors doctors = new Doctors();
		doctors.setName(doctor[0]);
		doctors.setSex(doctor[1]);
		doctors.setBirthday(new Timestamp(stringToDate(doctor[2]).getTime()));
		doctors.setTel(doctor[4]);
		doctors.setAddress(doctor[5]);
		doctors.setHospId((Integer.parseInt(doctor[6])));
		getHibernateTemplate().save(doctors);
	}
	
	private Date stringToDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 获得头像
	 * @return
	 */
	public String getHeadPicture(){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return OnlineTakePhotoService.get(user.getUsername());
	}
}
