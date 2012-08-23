package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;

import cn.net.tongfang.framework.security.bean.VacciProgram;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.BirthCertificate;
import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.VaccineImmune;
import cn.net.tongfang.framework.security.vo.VaccineImmuneInfo;
import cn.net.tongfang.framework.security.vo.VaccineImmuneRules;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.PrintVacciImmuneInfoBO;
import cn.net.tongfang.web.service.bo.VaccinationBO;
import cn.net.tongfang.web.service.bo.VaccineImmuneInfoBO;

public class VaccinationService extends HealthMainService<VaccinationBO> {
	private static final Logger log = Logger
			.getLogger(VaccinationService.class);

	@Override
	public String save(VaccinationBO data) throws Exception {
		data.setFileNo(EncryptionUtils.encry(data.getFileNo()));
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		data.setInputPersonId(user.getUsername());
		if (data.getId() == null || data.getId().equals("")) {
			data.setVinputDate(new Timestamp(System.currentTimeMillis()));
		}
		HealthFile file = (HealthFile)getHibernateTemplate().get(HealthFile.class, data.getFileNo());
		if(file.getName().trim().equals("") && !data.getVname().trim().equals("")){
			file.setName(EncryptionUtils.encry(data.getVname().trim()));
			getHibernateTemplate().update(file);
		}
		return save_(data);
	}

	@Override
	public Object get(VaccinationBO data) throws Exception {
		data = (VaccinationBO) get_(data);
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}

	@SuppressWarnings("unchecked")
	public List<VaccineImmuneRules> getVaccineImmuneRules() {
		return getHibernateTemplate().find(" From VaccineImmuneRules ");

	}

	public List getBirthCertificateInfo(String fileNo) {
		fileNo = EncryptionUtils.encry(fileNo);
		List list = getHibernateTemplate().find(
				" From BirthCertificate Where fileNo = ? ", fileNo);
		List retList = new ArrayList();
		if (list.size() > 0) {
			retList.add((BirthCertificate) list.get(0));
			retList.add(null);
			return retList;
		} else {
			retList.add(null);
			HealthFile file = (HealthFile) getHibernateTemplate().get(
					HealthFile.class, fileNo);
			String districtNum = file.getDistrictNumber().trim();
			districtNum = districtNum.substring(0, districtNum.length() - 3);
			District dis = (District) getHibernateTemplate().get(
					District.class, districtNum);
			retList.add(dis.getParentName());
		}
		return retList;
	}

	public List<VacciProgram> vacciProgram(String fileNo) {
		fileNo = EncryptionUtils.encry(fileNo);
		String sql = " EXEC Proc_Vacci ? ";
		List list = getSession().createSQLQuery(sql)
				.setResultSetMapping("vacciProgramResultSet")
				.setParameter(0, fileNo).list();
		return list;
	}

	public VaccineImmuneRules getVaccineImmuneRules(String col, Integer row,
			Integer isSpecail) {
		String hql = " From VaccineImmuneRules Where vaccineName = ? And rowNumber = ? ";
		if (isSpecail.equals(1)) {
			hql = " From VaccineImmuneRules Where vaccineName = ? ";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, col);
		if (!isSpecail.equals(1)) {
			query.setParameter(1, row);
		}
		List list = query.list();
		if (list.size() > 0) {
			return (VaccineImmuneRules) list.get(0);
		}
		return null;
	}

	public VaccineImmuneInfo saveVaccineImmuneInfo(VaccineImmuneInfoBO vacciInfo) {
//		if (vacciInfo.getLimitDate() != null) {
//			if (vacciInfo.getVaccinationDate().compareTo(
//					vacciInfo.getLimitDate()) > 0) {
//				throw new RuntimeException("请重新填写接种日期");
//			}
//		}
		if (vacciInfo.getVaccinationDate().compareTo(vacciInfo.getBirthday()) >= 0) {
			if (vacciInfo.getId() != null) {
				TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
						.currentOperator();
				if (user.getUsername().equals(vacciInfo.getInputPersonId())) {
					VaccineImmuneInfo info = new VaccineImmuneInfo();
					BeanUtils.copyProperties(vacciInfo, info);
					getHibernateTemplate().update(info);
					log.debug("VaccineImmuneInfo Updated Successed...");
					return info;
				} else {
					throw new RuntimeException("你无权限修改其他人录入的接种信息");
				}
			}
			String fileNo = EncryptionUtils.encry(vacciInfo.getFileNo());
			vacciInfo.setFileNo(fileNo);
			if (vacciInfo.getIsSpecail().equals(1)) {
				String hql = " From VaccineImmuneInfo Where fileNo = ? And colNum = ? ";
				Query query = getSession().createQuery(hql);
				query.setParameter(0, fileNo);
				query.setParameter(1, vacciInfo.getColNum());
				List list = query.list();
				if (list.size() == 2) {
					throw new RuntimeException("规划内A群流脑疫苗接种完毕");
				} else if (list.size() == 1) {
					vacciInfo.setNumber(2);
				} else if (list.size() == 0) {
					vacciInfo.setNumber(1);
				}
			}
			vacciInfo.setIsPlan(0);// 计划内
			VaccineImmuneInfo info = new VaccineImmuneInfo();
			BeanUtils.copyProperties(vacciInfo, info);
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			info.setInputPersonId(user.getUsername());
			info.setInputDate(new Timestamp(System.currentTimeMillis()));
			getHibernateTemplate().save(info);
			return info;
		} else {
			throw new RuntimeException("请重新填写接种日期");
		}
	}
	
	public void saveVaccineImmuneInfoUnPlaned(VaccineImmuneInfoBO vacciInfo){
		if (vacciInfo.getVaccinationDate().compareTo(vacciInfo.getBirthday()) >= 0) {
			if (vacciInfo.getId() != null && !vacciInfo.getId().equals("")) {
				TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
						.currentOperator();
				if (user.getUsername().equals(vacciInfo.getInputPersonId())) {
					VaccineImmuneInfo info = new VaccineImmuneInfo();
					BeanUtils.copyProperties(vacciInfo, info);
					info.setFileNo(EncryptionUtils.encry(info.getFileNo()));
					getHibernateTemplate().update(info);
					log.debug("VaccineImmuneInfo Updated Successed...");
				} else {
					throw new RuntimeException("你无权限修改其他人录入的接种信息");
				}
				return;
			}
			
			String fileNo = EncryptionUtils.encry(vacciInfo.getFileNo());
			vacciInfo.setFileNo(fileNo);
			vacciInfo.setIsPlan(1);// 计划外
			VaccineImmuneInfo info = new VaccineImmuneInfo();
			BeanUtils.copyProperties(vacciInfo, info);
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			info.setInputPersonId(user.getUsername());
			info.setInputDate(new Timestamp(System.currentTimeMillis()));
			getHibernateTemplate().save(info);
		} else {
			throw new RuntimeException("请重新填写接种日期");
		}
	}
	
	public List getVaccineImmuneInfo(String col, Integer row, String fileNo,
			Integer isSpecail) {
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = " From VaccineImmuneInfo A,VaccineImmuneRules B Where A.fileNo = ? And A.colNum = ? And A.rowNumber = ? "
				+ " And A.colNum = B.vaccineName AND A.rowNumber = B.rowNumber ";
		if (isSpecail.equals(1)) {
			hql = " From VaccineImmuneInfo A Where A.fileNo = ? And A.colNum = ? And A.rowNumber = ? ";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, fileNo);
		query.setParameter(1, col);
		query.setParameter(2, row);
		List list = query.list();
		List retList = new ArrayList();
		if (list.size() > 0) {
			if (isSpecail.equals(1)) {
				VaccineImmuneInfo vacciInfo = (VaccineImmuneInfo) list.get(0);
				retList.add(vacciInfo);
				return retList;
			} else {
				Object[] objs = (Object[]) list.get(0);
				VaccineImmuneInfo vacciInfo = (VaccineImmuneInfo) objs[0];
				VaccineImmuneRules vacciRules = (VaccineImmuneRules) objs[1];
				retList.add(vacciInfo);
				retList.add(vacciRules);
				return retList;
			}

		}
		return null;
	}

	public PagingResult<VaccineImmuneRules> queryVacciRulesInfo(PagingParam pp) {
		String hql = " From VaccineImmuneRules Where id in (Select min(id) From VaccineImmuneRules Where rules = 0 Group By vaccineRemark) ";
		String countHql = " Select Count(*) " + hql;
		Query query = getSession().createQuery(countHql);
		int totalSize = ((Long) query.uniqueResult()).intValue();
		query = getSession().createQuery(hql + " Order By id ");
		if (pp == null)
			pp = new PagingParam();
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		PagingResult<VaccineImmuneRules> result = new PagingResult<VaccineImmuneRules>(
				totalSize, list);
		return result;
	}
	
	public PagingResult<VaccineImmuneInfo> queryVacciInfo(String fileNo,PagingParam pp) {
		String hql = " From VaccineImmuneInfo Where fileNo = ? And isPlan = 1 ";
		String countHql = " Select Count(*) " + hql;
		fileNo = EncryptionUtils.encry(fileNo);
		Query query = getSession().createQuery(countHql);
		query.setParameter(0, fileNo);
		int totalSize = ((Long) query.uniqueResult()).intValue();
		query = getSession().createQuery(hql + " Order By vaccinationDate ");
		query.setParameter(0, fileNo);
		if (pp == null)
			pp = new PagingParam();
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		PagingResult<VaccineImmuneInfo> result = new PagingResult<VaccineImmuneInfo>(
				totalSize, list);
		return result;
	}
	
	public VaccineImmune getVaccineImmune(String id){
		VaccineImmune vacci = (VaccineImmune)getHibernateTemplate().get(VaccineImmune.class, id);
		vacci.setFileNo(EncryptionUtils.decipher(vacci.getFileNo()));
		return vacci;
	}
	
	public PagingResult<VaccineImmuneInfo> getPrintVacciImmuneInfo(PrintVacciImmuneInfoBO info){
		String hql = " From VaccineImmuneInfo vii,BasicInformation bi Where vii.colNum = bi.id And bi.printPage = ? And vii.fileNo = ? Order By bi.id,vii.number ASC ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, info.getPrintPage());
		query.setParameter(1, EncryptionUtils.encry(info.getFileNo()));
		List list = query.list();
		List retVal = new ArrayList();
		if(list.size() > 0){
			for(Object objs : list){
				Object[] obj = (Object[])objs;
				retVal.add(obj[0]);
			}
		}
		PagingResult<VaccineImmuneInfo> result = new PagingResult<VaccineImmuneInfo>(
				list.size(), retVal);
		return result;
	}
	
	public void printSuccess(List<String> ids){
		for(String id : ids){
			VaccineImmuneInfo info = (VaccineImmuneInfo)getHibernateTemplate().get(VaccineImmuneInfo.class, id);
			info.setIsPrint(1);//1代表打印成功
			getHibernateTemplate().update(info);
		}
	}
}
