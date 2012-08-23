package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.bo.WaitingThingDeal;
import cn.net.tongfang.framework.security.bo.WaitingThingQry;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.DiagnoseCoding;
import cn.net.tongfang.framework.security.vo.DiseaseHistory;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.IntPersonInfo;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;
import cn.net.tongfang.framework.security.vo.WaitingThing;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.vo.ExtJSTreeNode;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.ChronicDiseaseWTBO;
import cn.net.tongfang.web.service.bo.NewHealthFileWTBO;
import cn.net.tongfang.web.util.FileNoGen;

public class WaitingThingService extends HibernateDaoSupport {
	private static final Integer NEW_HEALTHFILE = -1;// 新建档案
	private static final Integer HYPERTENSION = 1;// 高血压
	private static final Integer DIABETES = 2;// 糖尿病
	private static final Integer HOLERGASIA = 3;// 重性精神病

	public static final Integer DISEASE_HYP = 2;
	public static final Integer DISEASE_FURI = 8;
	public static final Integer DISEASE_DIAB = 3;

	private static final Integer DEALED = 1;// 待办事宜已成功办理
	private static final Integer RETURNED = 2;// 待办事宜已成功回退

	private FileNoGen fileNoGen;

	public void setFileNoGen(FileNoGen fileNoGen) {
		this.fileNoGen = fileNoGen;
	}

	public boolean isNewWaitingThing() {
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		int districtNumLen = user.getDistrictId().length();

		String hql = " From WaitingThing A,DiagnoseCoding B Where A.status = 0 And A.diagnoseId = B.id And substring(A.districtNum,1,"
				+ districtNumLen + ") = ? ";
		String countSql = "select count(*) " + hql;
		Query query = getSession().createQuery(countSql);
		query.setParameter(0, user.getDistrictId());
		int totalSize = ((Long) query.uniqueResult()).intValue();
		if (totalSize > 0)
			return true;
		return false;
	}

	public PagingResult<Map<String, Object>> getWaitingThingInfos(
			WaitingThingQry qry, PagingParam pp) {
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		int districtNumLen = user.getDistrictId().length();

		String hql = "";
		if(qry.getStatus().equals(0)){
			hql = " From WaitingThing A,DiagnoseCoding B Where A.status = 0 And A.diagnoseId = B.id And substring(A.districtNum,1,"
					+ districtNumLen + ") = :districtNum ";
		}else{
			hql = " From WaitingThing A,DiagnoseCoding B,SamTaxempcode C Where A.status != 0 And A.diagnoseId = B.id And substring(A.districtNum,1,"
					+ districtNumLen + ") = :districtNum And A.dealPerson = C.loginname ";
		}
		if (qry.getType() != null) {
			hql = hql + " And B.serviceType = :serviceType ";
		}

		String countSql = "select count(*) " + hql;
		Query query = getSession().createQuery(countSql);
		query.setParameter("districtNum", user.getDistrictId());
		if (qry.getType() != null) {
			query.setParameter("serviceType", qry.getType());
		}
		int totalSize = ((Long) query.uniqueResult()).intValue();

		query = getSession().createQuery(hql + " Order By B.diagnoseName ");
		query.setParameter("districtNum", user.getDistrictId());
		if (qry.getType() != null) {
			query.setParameter("serviceType", qry.getType());
		}
		if (pp == null)
			pp = new PagingParam();
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			WaitingThing wt = (WaitingThing) objs[0];
			DiagnoseCoding dc = (DiagnoseCoding) objs[1];
			SamTaxempcode stCode = new SamTaxempcode();
			if (!qry.getStatus().equals(0)) {
				wt.setFileNo(EncryptionUtils.decipher(wt.getFileNo()));
				stCode = (SamTaxempcode)objs[2];
			}
			getHibernateTemplate().evict(wt);
			getHibernateTemplate().evict(dc);
			Map map = new HashMap();
			map.put("waitingthing", wt);
			map.put("diagnose", dc);
			map.put("orguser", stCode);
			lists.add(map);
		}
		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				totalSize, lists);
		return result;
	}

	public void dealWaitingThing(List<WaitingThingDeal> deals) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		for (WaitingThingDeal deal : deals) {
			Integer serviceType = deal.getServiceType();
			if (serviceType.equals(NEW_HEALTHFILE)) {
				String fileNo = fileNoGen.getNextFileNo(deal.getDistrictNum()
						.trim());
				fileNo = EncryptionUtils.encry(fileNo);
				String subFileNo = fileNo.substring(fileNo.length() - 7);
				String tmpFileNo = deal.getFileNo();
				getSession()
						.createQuery(
								" Update HealthFile Set fileNo = ?,status = 0 Where fileNo = ?")
						.setParameter(0, fileNo).setParameter(1, tmpFileNo)
						.executeUpdate();
				getSession()
						.createQuery(
								" Update PersonalInfo Set fileNo = ?,fileNoSub = ? Where fileNo = ?")
						.setParameter(0, fileNo).setParameter(1, subFileNo)
						.setParameter(2, tmpFileNo).executeUpdate();
				WaitingThing wt = (WaitingThing) getHibernateTemplate().get(
						WaitingThing.class, deal.getId());
				wt.setStatus(DEALED);
				wt.setFileNo(fileNo);
				wt.setDealDate(now);
				wt.setDealPerson(user.getUsername());
				getSession()
						.createQuery(
								" Update IntPersonInfo Set state = 2 Where id = ?")
						.setParameter(0, tmpFileNo).executeUpdate();
				getHibernateTemplate().update(wt);
			} else {
				String fileNo = EncryptionUtils.encry(deal.getFileNo().trim());
				String hql = " From PersonalInfo A,DiseaseHistory B Where A.fileNo = ? And A.id = B.personalInfoId And B.diseaseId = ? ";
				Query query = getSession().createQuery(hql);
				query.setParameter(0, fileNo);
				if (serviceType.equals(HYPERTENSION)) {
					query.setParameter(1,DISEASE_HYP);
				} else if (serviceType.equals(DIABETES)) {
					query.setParameter(1,DISEASE_DIAB);
				} else if (serviceType.equals(HOLERGASIA)) {
					query.setParameter(1,DISEASE_FURI);
				}
				List list = query.list();
				if (list.size() == 0) {
					PersonalInfo person = (PersonalInfo) list.get(0);
					/**
					 * 检查此居民是否已经标记为高血压、糖尿病、重性精神病在触发器检查，如果已经标记，则不在待办事宜里显示
					 */
					DiseaseHistory disHistory = new DiseaseHistory();
					disHistory.setPersonalInfoId(person.getId());
					if (serviceType.equals(HYPERTENSION)) {
						disHistory.setDiseaseId(DISEASE_HYP);
					} else if (serviceType.equals(DIABETES)) {
						disHistory.setDiseaseId(DISEASE_DIAB);
					} else if (serviceType.equals(HOLERGASIA)) {
						disHistory.setDiseaseId(DISEASE_FURI);
					}
					disHistory.setRemark("");
					disHistory.setConfirmDate(CommonConvertUtils
							.dateToString(deal.getTransDate()));
					getHibernateTemplate().save(disHistory);
					WaitingThing wt = (WaitingThing) getHibernateTemplate()
							.get(WaitingThing.class, deal.getId());
					wt.setStatus(DEALED);
					wt.setDealDate(now);
					wt.setDealPerson(user.getUsername());
					getHibernateTemplate().update(wt);
				}
			}
		}

	}

	public List<ExtJSTreeNode> getWaitCatagery(String cateId) {
		List<DiagnoseCoding> list = getHibernateTemplate().find(
				"from DiagnoseCoding Order By number ");
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		for (DiagnoseCoding dc : list) {
			ExtJSTreeNode node = new ExtJSTreeNode(dc.getDiagnoseName(),
					String.valueOf(dc.getServiceType()), true, dc);
			nodes.add(node);
		}
		return nodes;
	}

	public List getWaitingThingInfo(String id) {
		String hql = " From WaitingThing A,HealthFile B,IntPersonInfo C Where A.fileNo = B.fileNo And A.subId = C.id And A.id = ? ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		return query.list();
	}
	
	public List getWaitingThingInfo(String id,String fileNo) {
		fileNo = EncryptionUtils.encry(fileNo.trim());
		String hql = " From WaitingThing A,HealthFile B,IntPersonInfo C Where B.fileNo = ? And A.subId = C.id And A.id = ? ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, fileNo);
		query.setParameter(1, id);
		return query.list();
	}
	
	public List getWaitingThingInfo(String id, Integer type, String fileNo) {
		fileNo = EncryptionUtils.encry(fileNo.trim());
		String hql = "";
		if (type.equals(0)) {
			hql = " From WaitingThing A,HealthFile B,PersonalInfo C,IntOutpatient D Where A.id = ? And B.fileNo = ? And B.fileNo = C.fileNo And A.hisid = D.opKey";
		} else if (type.equals(1)) {
			hql = " From WaitingThing A,HealthFile B,PersonalInfo C,IntInpatient D Where A.id = ? And B.fileNo = ? And B.fileNo = C.fileNo And A.hisid = D.inKey";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		query.setParameter(1, fileNo);
		List list = query.list();
		if (list.size() > 0) {
			Object[] objs = (Object[]) list.get(0);
			HealthFile file = (HealthFile) objs[1];
			PersonalInfo person = (PersonalInfo) objs[2];
			file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
			file.setName(EncryptionUtils.decipher(file.getName()));
			person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			objs[1] = file;
			objs[2] = person;
			List retval = new ArrayList();
			retval.add(objs);
			return retval;
		}
		return null;
	}

	public void saveNewHealthFileWt(NewHealthFileWTBO file) {
		String fileNo = fileNoGen
				.getNextFileNo(file.getDistrictNumber().trim());
		fileNo = EncryptionUtils.encry(fileNo);
		String subFileNo = fileNo.substring(fileNo.length() - 7);
		String tmpFileNo = file.getFileNo();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		getSession()
				.createQuery(
						" Update HealthFile Set fileNo = ?,status = 0,name = ?,address = ?,inputPersonId = ?,inputDate = ? Where fileNo = ?")
				.setParameter(0, fileNo)
				.setParameter(1, EncryptionUtils.encry(file.getPersonName()))
				.setParameter(2, file.getAddress())
				.setParameter(3, user.getUsername()).setParameter(4, now)
				.setParameter(5, tmpFileNo).executeUpdate();
		getSession()
				.createQuery(
						" Update PersonalInfo Set fileNo = :fileNo,fileNoSub = :subFileNo,idnumber = :idnumber,"
								+ "sex = :sex,occupation = :occupation,birthDay = :birthDay,inputPersonId = :inputPersonId,"
								+ "inputDate = :inputDate Where fileNo = :tmpFileNo")
				.setParameter("fileNo", fileNo)
				.setParameter("subFileNo", subFileNo)
				.setParameter("idnumber",
						EncryptionUtils.encry(file.getIdnumber()))
				.setParameter("sex", file.getSex())
				.setParameter("occupation", file.getOccupation())
				.setParameter("birthDay", file.getBirthDay())
				.setParameter("inputPersonId", user.getUsername())
				.setParameter("inputDate", now)
				.setParameter("tmpFileNo", tmpFileNo).executeUpdate();
		WaitingThing wt = (WaitingThing) getHibernateTemplate().get(
				WaitingThing.class, file.getId());
		wt.setStatus(DEALED);
		wt.setFileNo(fileNo);
		wt.setDealDate(now);
		wt.setDealPerson(user.getUsername());
		getSession()
				.createQuery(
						" Update IntPersonInfo Set state = 2,fileNo = ? Where id = ?")
				.setParameter(0, fileNo).setParameter(1, tmpFileNo)
				.executeUpdate();
		getHibernateTemplate().update(wt);
	}

	public void saveMBInfoWt(ChronicDiseaseWTBO mb) {
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String hql = " From DiseaseHistory Where personalInfoId = ? And diseaseId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, mb.getPersonId());
		Integer mbType = -1;
		switch (mb.getServiceType()) {
		case 1:
			mbType = DISEASE_HYP;
			break;
		case 2:
			mbType = DISEASE_DIAB;
			break;
		case 3:
			mbType = DISEASE_FURI;
			break;
		default:
			break;
		}
		if(!mbType.equals(-1)) 
			query.setParameter(1, mbType);
		else
			throw new RuntimeException();
		List list = query.list();
		if(list.size() == 0){
			DiseaseHistory dh = new DiseaseHistory();
			dh.setPersonalInfoId(mb.getPersonId().trim());
			dh.setDiseaseId(mbType);
			dh.setConfirmDate(mb.getMakeDate());
			dh.setRemark("");
			getHibernateTemplate().save(dh);
		}
		WaitingThing wt = (WaitingThing) getHibernateTemplate().get(
				WaitingThing.class, mb.getWtId());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		wt.setStatus(DEALED);
		wt.setDealDate(now);
		wt.setDealPerson(user.getUsername());
		wt.setFileNo(EncryptionUtils.encry(wt.getFileNo().trim()));
		getHibernateTemplate().update(wt);
//		if(mb.getType().equals(0)){
//			IntInpatient inpatient = (IntInpatient)getHibernateTemplate().get(IntInpatient.class, mb.getPatientId());
//			inpatient.setState(state)
//		}else if(mb.getType().equals(1)){
//			
//		}
	}
	
	public void saveMatchHealthFileWT(NewHealthFileWTBO file){
		String fileNo = file.getFileNo();
		fileNo = EncryptionUtils.encry(fileNo);
		String hql = " From HealthFile A,PersonalInfo B Where A.fileNo = B.fileNo And A.fileNo = ? ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, fileNo);
		List list = query.list();
		if(list.size() > 0){
			Object[] objs = (Object[])list.get(0);
			HealthFile hfile = (HealthFile)objs[0];
			PersonalInfo person = (PersonalInfo)objs[1];
			hfile.setName(EncryptionUtils.encry(file.getPersonName()));
			hfile.setAddress(file.getAddress());
			person.setIdnumber(EncryptionUtils.encry(file.getIdnumber()));
			person.setSex(file.getSex());
			person.setBirthday(file.getBirthDay());
			getHibernateTemplate().update(hfile);
			getHibernateTemplate().update(person);
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			WaitingThing wt = (WaitingThing) getHibernateTemplate().get(
					WaitingThing.class, file.getId());
			Timestamp now = new Timestamp(System.currentTimeMillis());
			wt.setStatus(DEALED);
			wt.setDealDate(now);
			wt.setDealPerson(user.getUsername());
			wt.setFileNo(fileNo);
			getHibernateTemplate().update(wt);
			IntPersonInfo ip = (IntPersonInfo)getHibernateTemplate().get(IntPersonInfo.class, wt.getSubId());
			ip.setState(new Short("2"));//已处理
			ip.setFileNo(fileNo);
			ip.setCheckState(new Short("1"));//比对成功
			getHibernateTemplate().update(ip);
		}
	}
	
	public void returnWT(String id,Integer type){
		WaitingThing wt = (WaitingThing) getHibernateTemplate().get(
				WaitingThing.class, id);
		if(!type.equals(0)){
			List list = getHibernateTemplate().find(" From HealthFile A,PersonalInfo B Where A.fileNo = B.fileNo And A.fileNo = ?",id);
			if(list.size() > 0){
				Object[] objs = (Object[])list.get(0);
				HealthFile file = (HealthFile)objs[0];
				PersonalInfo person = (PersonalInfo)objs[1];
				getHibernateTemplate().delete(file);
				getHibernateTemplate().delete(person);
			}
		}
		wt.setStatus(RETURNED);
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		wt.setDealDate(now);
		wt.setDealPerson(user.getUsername());
		getHibernateTemplate().update(wt);
	}
}
