package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.BirthCertificate;
import cn.net.tongfang.framework.security.vo.BusinessDataGrid;
import cn.net.tongfang.framework.security.vo.IntInpatient;
import cn.net.tongfang.framework.security.vo.IntOutpatient;
import cn.net.tongfang.framework.security.vo.SummaryStatistics01;
import cn.net.tongfang.framework.security.vo.SummaryStatisticsHivandSyphilis;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.BirthCertifiQry;
import cn.net.tongfang.web.service.bo.PatientQry;
import cn.net.tongfang.web.service.bo.PersonalInfoFBO;
import cn.net.tongfang.web.service.bo.SummaryQry;

public class SummaryService extends HibernateDaoSupport{
	private PersonalInfoService person;
	public void setPerson(PersonalInfoService person) {
		this.person = person;
	}

	public PagingResult<SummaryStatistics01> querySummaryStatistics(SummaryQry qry,PagingParam pp){
		Query query = getSession().getNamedQuery("InputPersonProc");
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String str_where = " And A.InputDate >= '" + CommonConvertUtils.dateToStringWithDelimiter(qry.getStartDate()) +
				" 00:00:00' And A.InputDate <= '" + CommonConvertUtils.dateToStringWithDelimiter(qry.getEndDate()) +
				" 23:59:59' ";
		query.setParameter(0, user.getUsername());
		query.setParameter(1, qry.getStatisticType());
		query.setParameter(2, str_where);
		query.setParameter(3, qry.getStatisticResult());
		query.setParameter(4, qry.getIsQryWipeOut());
		List list = query.list();
		PagingResult<SummaryStatistics01> result = new PagingResult<SummaryStatistics01>(
				list.size(), list);
		return result;
	}
	
	public PagingResult<SummaryStatisticsHivandSyphilis> queryHIVAndSyphilis(SummaryQry qry,PagingParam pp){
		Query query = getSession().getNamedQuery("SummaryStatisticsHivandSyphilisProc");
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String str_where = " And A.InputDate >= '" + CommonConvertUtils.dateToStringWithDelimiter(qry.getStartDate()) +
				" 00:00:00' And A.InputDate <= '" + CommonConvertUtils.dateToStringWithDelimiter(qry.getEndDate()) +
				" 23:59:59' ";
		query.setParameter(0, str_where);
		query.setParameter(1, qry.getStatisticType());
		query.setParameter(2, user.getUsername());
		List list = query.list();
		PagingResult<SummaryStatisticsHivandSyphilis> result = new PagingResult<SummaryStatisticsHivandSyphilis>(
				list.size(), list);
		return result;
	}
	
	public List<BusinessDataGrid> queryBusinessData(String fileNo){
		Query query = getSession().getNamedQuery("BusinessDataProc");
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String username = EncryptionUtils.encry(fileNo);
		if(user != null){
			username = user.getUsername();
		}
		query.setParameter(0, EncryptionUtils.encry(fileNo));
		query.setParameter(1, username);
		List list = query.list();
		return list;
	}
	
	public List queryBusinessDataDelphi(String fileNo){
		List list = new ArrayList();
		PersonalInfoFBO personinfo = new PersonalInfoFBO();
		personinfo.setFileNo(fileNo);
		try {
			person.getBasicInfo(personinfo);
			personinfo.setIdnumber(EncryptionUtils.decipher(personinfo.getIdnumber()));
			list.add(personinfo);
			list.add(queryBusinessData(fileNo));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	private List queryBirth(BirthCertifiQry qry,PagingParam pp,Integer type,StringBuilder totals){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		Integer isLookAuthority = user.getIsLookAuthority();
		String districtNumber = user.getDistrictId();
		Integer orgId = user.getOrgId();
		String where = " Where 1 = 1 ";
//		if(isLookAuthority.equals(1)){
//			where = " Where A.inputPersonId in ( Select loginname From SamTaxempcode Where Substring(districtId,1,Len(" + districtNumber + ")) = :districtNumber)";
//		}else{
//			where = " Where A.inputPersonId in ( Select loginname From SamTaxempcode Where orgId = :orgId ) ";
//		}
		
		String queryType = qry.getQryType();
		String whereType = "";
		if(queryType.subSequence(0, 1).equals("1")){
			whereType = "2";
		}
		if(queryType.subSequence(1, 2).equals("1")){
			whereType = whereType.equals("") ? "3" : whereType + ",3";
		}
		if(queryType.subSequence(2, 3).equals("1")){
			whereType = whereType.equals("") ? "4" : whereType + ",4";
		}
		
		whereType = whereType.equals("") ? "" : " And A.isEffectived in (" + whereType + ")";
		
		String qryOrgId = qry.getOrgId();
		String joinHql = "";
		String joinWhere = "";
		if(!qryOrgId.equals("")){
			joinHql = ",BirthCertificateOrg B ";
			joinWhere = " And A.certifiId = B.certificateId And B.orgId = :qryOrgId ";
		}
		
		String whereStr = "";
		String certifiId = qry.getCertifiId().trim();
		if(!certifiId.equals("")){
			whereStr = " And SubString(A.certifiId,1," + certifiId.length() + ") = :certifiId ";
		}
		String childName = qry.getChildName().trim();
		if(!childName.equals("")){
			whereStr = whereStr + " And SubString(A.name,1," + childName.length() + ") = :name ";
		}
		String motherName = qry.getMotherName().trim();
		if(!motherName.equals("")){
			whereStr = whereStr + " And SubString(A.motherName,1," + motherName.length() + ") = :motherName ";
		}
		String fatherName = qry.getFatherName().trim();
		if(!fatherName.equals("")){
			whereStr = whereStr +  " SubString(And A.fatherName,1," + fatherName.length() + ") = :fatherName ";
		}
		Date birthday = qry.getChildBirthday();
		if(birthday != null){
			whereStr = whereStr +  " And CONVERT(varchar(100), A.birthday , 23) = :birthday ";
		}
		Date startDate = qry.getStartDate();
		if(startDate != null){
			whereStr = whereStr +  " And A.inputDate >= :startDate ";
		}
		Date endDate = qry.getEndDate();
		if(endDate != null){
			whereStr = whereStr +  " And A.inputDate <= :endDate ";
		}
		int totalSize = 0;
		if(type.equals(0)){
			String countHql = " Select count(*) From BirthCertificate A " + joinHql + where + whereType + joinWhere + whereStr;
			Query countQuery = getSession().createQuery(countHql);
//			if(isLookAuthority.equals(1)){
//				countQuery.setParameter("districtNumber", districtNumber);
//			}else{
//				countQuery.setParameter("orgId", orgId);
//			}
			if(!qryOrgId.equals("")){
				countQuery.setParameter("qryOrgId", Integer.valueOf(qryOrgId));
			}
			if(!certifiId.equals("")){
				countQuery.setParameter("certifiId", certifiId);
			}
			if(!childName.equals("")){
				countQuery.setParameter("name", childName);
			}
			if(!motherName.equals("")){
				countQuery.setParameter("motherName", motherName);
			}
			if(!fatherName.equals("")){
				countQuery.setParameter("fatherName", fatherName);
			}
			if(birthday != null){
				countQuery.setParameter("birthday", CommonConvertUtils.dateToStringWithDelimiter(birthday));
			}
			if(startDate != null){
				countQuery.setParameter("startDate",CommonConvertUtils.stringToDate(CommonConvertUtils.dateToStringWithDelimiter(startDate) + " 00:00:00"));
			}
			if(endDate != null){
				countQuery.setParameter("endDate", CommonConvertUtils.stringToDate(CommonConvertUtils.dateToStringWithDelimiter(endDate) + " 23:59:59"));
			}
			
			totalSize = ((Long) countQuery.uniqueResult()).intValue();
			totals.append(totalSize);
		}
		
		String hql = " Select A From BirthCertificate A " + joinHql + where + whereType + joinWhere + whereStr;
		Query query = getSession().createQuery(hql);
//		if(isLookAuthority.equals(1)){
//			query.setParameter("districtNumber", districtNumber);
//		}else{
//			query.setParameter("orgId", orgId);
//		}
		if(!qryOrgId.equals("")){
			query.setParameter("qryOrgId", Integer.valueOf(qryOrgId));
		}
		if(!certifiId.equals("")){
			query.setParameter("certifiId", certifiId);
		}
		if(!childName.equals("")){
			query.setParameter("name", childName);
		}
		if(!motherName.equals("")){
			query.setParameter("motherName", motherName);
		}
		if(!fatherName.equals("")){
			query.setParameter("fatherName", fatherName);
		}
		if(birthday != null){
			query.setParameter("birthday", CommonConvertUtils.dateToStringWithDelimiter(birthday));
		}
		if(startDate != null){
			query.setParameter("startDate",CommonConvertUtils.stringToDate(CommonConvertUtils.dateToStringWithDelimiter(startDate) + " 00:00:00"));
		}
		if(endDate != null){
			query.setParameter("endDate", CommonConvertUtils.stringToDate(CommonConvertUtils.dateToStringWithDelimiter(endDate) + " 23:59:59"));
		}
		if(type.equals(0)){
			query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		}
		List list = query.list();
		return list;
	}
	
	public PagingResult<BirthCertificate> queryBirthCertificate(BirthCertifiQry qry,PagingParam pp){
		StringBuilder totals = new StringBuilder();
		List list = queryBirth(qry, pp, 0, totals);
		PagingResult<BirthCertificate> birthcertifis = new PagingResult<BirthCertificate>(Integer.valueOf(totals.toString()), list);
		return birthcertifis;
	}
	
	public List<BirthCertificate> printAllBirth(BirthCertifiQry qry){
		List list = queryBirth(qry, null, 1, null);
		if(list.size() > 0){
			return list;
		}
		return null;
	}

	private String buildWhere(PatientQry qry,List params){
		Integer clickType = qry.getClickType();
		String retval = "";
		Timestamp date = null;
		Timestamp startDate = null;
		if(clickType.equals(0)){
			date = new Timestamp(System.currentTimeMillis());
			startDate = CommonConvertUtils.subDate(date, 90);
		}else if(clickType.equals(1)){
			//not add where condition
		}else if(clickType.equals(2)){
			date = qry.getEndDate();
			startDate = qry.getStartDate();
		}
		if(startDate != null){
			retval = retval + " Convert(Nvarchar(10),makeDate,120) >= ?";
			params.add(startDate);
		}
		if(date != null){
			retval = retval + (retval.equals("") ? "" : " And ") + "  Convert(Nvarchar(10),makeDate,120) <= ? ";
			params.add(date);
		}
		if(qry.getFileNo() != null && !qry.getFileNo().equals("")){
			retval  = retval + (retval.equals("") ? "" : " And ") + "  fileNo = ? ";
			params.add(qry.getFileNo());
		}
		return retval;
	}
	
	private <T> PagingResult<T> query(String hql,List params,PagingParam pp){
		if(pp == null) pp = new PagingParam();
		String hqlCount = "Select Count(*) " + hql; 
		Query query = getSession().createQuery(hqlCount);
		for(int i=0;i<params.size();i++){
			query.setParameter(i, params.get(i));
		}
		int count = ((Long) query.uniqueResult()).intValue();
		query = getSession().createQuery(hql);
		for(int i=0;i<params.size();i++){
			query.setParameter(i, params.get(i));
		}
		if(pp == null) pp = new PagingParam();
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List<T> list = query.list();
		return new PagingResult<T>(count, list);
	}
	
	public PagingResult<IntOutpatient> getOutpatient(PatientQry qry,PagingParam pp){
		List params = new ArrayList();
		String where = buildWhere(qry,params);
		where = where.equals("") ? "" : " Where " + where;
		String hql = "From IntOutpatient " + where;
		return query(hql,params,pp);
	}
	
	public PagingResult<IntInpatient> getInpatient(PatientQry qry,PagingParam pp){
		List params = new ArrayList();
		String where = buildWhere(qry,params);
		where = where.equals("") ? "" : " Where " + where;
		String hql = "From IntInpatient " + where;
		return query(hql,params,pp);
	}
}
