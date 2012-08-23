package cn.net.tongfang.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.BasicInformation;
import cn.net.tongfang.framework.security.vo.MedicalExam;
import cn.net.tongfang.framework.util.EncryptionUtils;

public class QueryByHomeService extends HibernateDaoSupport {
	/**
	 * 明细查询
	 * @param fileNo
	 * @param selectNo
	 * 1代表健康体检记录
	 * 2代表新生儿家庭访视记录
	 * 3代表1岁以内儿童体检记录
	 * 4代表1岁至2岁儿童体检记录
	 * 5代表3岁儿童体检记录
	 * 6代表第一次产前随访记录
	 * 7代表第2至5次产前随访记录
	 * 8代表产后访视记录
	 * 9代表产后42天健康体检记录
	 * 10代表高血压患者随访记录
	 * 11代表2型糖尿病患者随访记录
	 * 12代表重性精神病患者随访记录
	 * 13代表接诊记录
	 * 14代表会诊记录
	 * 15代表双向转诊记录
	 * 16代表双向转诊回转记录
	 * 17代表预防接种
	 * @return
	 */
	public List queryByHomeAtFileNo(String fileNo, int selectNo) {
		StringBuffer sql = new StringBuffer();
		sql = getSQL(selectNo);
		Query query = getSession().createQuery(sql.toString());
		fileNo = EncryptionUtils.encry(fileNo);
		query.setParameter(0,fileNo);
		List list = query.list();
		List resultList = new ArrayList();
		switch (selectNo) {
		case 1:
		case 2:
		case 5:
		case 6:
		case 8:
		case 9:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
			resultList = getResult(list,selectNo);
			break;
		default:
			return list;
		}
		return resultList;
	}
	
	private List getResult(List list,int selectNo){
		Query query;
		List resultList = new ArrayList();
		for(Object o : list){
			Object[] obj = new Object[100];
			obj = (Object[])o;
			String id = (String)obj[0];
			String tempSql = "";
			switch (selectNo) {
			case 1:
				tempSql = "select c.name from HealthDirect b,BasicInformation c where b.medicalExamId = ? and b.healthDirectId = c.id";
				break;
			case 2:
				tempSql = "select b.name from BasicInformation b,BabyDirect c where c.babyVisitId = ? and  b.id = c.babyDirectId";
				break;
			case 5:
				tempSql = "select b.name from BasicInformation b,CheckDirect3 c where c.childrenMediExam3id = ? and b.id = c.checkDirect3id";
				break;
			case 6:
				tempSql = "select b.name from BasicInformation b,FemePastHistory c where b.id = c.femePastHistoryId and firstVistBeforeBornId = ?";
				break;
			case 7:
				tempSql = "select b.name from BasicInformation b,BeforeBornDirect c where b.id = c.beforeBornDirectId and c.visitBeforeBornId = ?";
				break;
			case 8:
			case 9:
				tempSql = "select b.name from BasicInformation b,AfterBornDirect c where b.id = c.afterBornDirectId and visitAfterBornId = ?";
				break;
			case 12:
				tempSql = "select b.name from BasicInformation b,FuriousVisitSymptom c where c.furiousVisitId = ? and b.id = furiousVisitSymptomId";
				break;
			default:
				break;
			}
			String name = "";
			if(!tempSql.equals("")){
				query = getSession().createQuery(tempSql);
				query.setParameter(0, id);
				List l = query.list();
				if(l.size() > 0){
					for(Object tempO :l){
						name = name + (String)tempO + "、";
					}
				}
			}
			Object[] result = new Object[100];
			if(!name.equals(""))
				result[0] = name.substring(0, name.length() - 1);
			else
				result[0] = name;
			for(int i=1;i<=obj.length;i++){
				result[i] = obj[i-1];
			}
			Object resultO = (Object)result;
			resultList.add(resultO);
		}
		return resultList;
	}
	
	private StringBuffer getSQL(int selectNo){
		StringBuffer sql = new StringBuffer();
		switch (selectNo) {
		case 1:
			sql.append("select a.id,a.examDate,b.username,a.doctor,a.judge01,a.judge02,a.judge03,a.judge04,a.judge05"+
					" from MedicalExam a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.examDate DESC");
			break;
		case 2:
			sql.append("select a.id,b.username,a.visitDate,a.nextVisitDate,a.visitDoctor"+ 
					" from BabyVisit a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname"+
					" order by a.visitDate DESC");
			break;
		case 3:
			sql.append("from ChildrenMediExam a where a.dataType = 0 and a.fileNo = ? order by a.checkItem ASC");
			break;
		case 4:
			sql.append("from ChildrenMediExam a where a.dataType = 1 and a.fileNo = ? order by a.checkItem ASC");
			break;
		case 5:
			sql.append("select a.id,a.visitDate,b.username,a.visitDoctor,a.directOther"+
					" from ChildrenMediExam3 a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname"+
					" order by a.visitDate DESC");
			break;
		case 6:
			sql.append("select a.id,a.visitDate,b.username,a.visitDoctor,a.nextVisitDate "+
					"from FirstVistBeforeBorn a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.visitDate DESC");
			break;
		case 7:
			sql.append("from VisitBeforeBorn a where a.fileNo = ? order by a.item ASC");
			break;
		case 8:
			sql.append("select a.id,a.visitDate,b.username,a.visitDoctor"+
					" from VisitAfterBorn a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname"+
					" and a.recordType = 0 order by a.visitDate DESC");
			break;
		case 9:
			sql.append("select a.id,a.visitDate,b.username,a.visitDoctor"+
					" from VisitAfterBorn a,SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname "+
					"and a.recordType = 1 order by a.visitDate DESC");
			break;
		case 10:
			sql.append("from HypertensionVisit a where a.fileNo = ? order by a.visitDate ASC");
			break;
		case 11:
			sql.append("from DiabetesVisit a where a.fileNo = ? order by a.visitDate ASC");
			break;
		case 12:
			sql.append("select a.id,b.username,a.visitDate,a.nextVistDate,a.visitDoctor from FuriousVisit a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.visitDate DESC");
			break;
		case 13:
			sql.append("select a.id,a.date,a.doctor,a.evaluation,b.username from Reception a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.date DESC");
			break;
		case 14:
			sql.append("select a.id,a.date,a.doctor,a.reason,b.username from Consultation a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.date DESC");
			break;
		case 15:
			sql.append("select a.id,a.date,a.exportOrg,a.fromOrg,b.username,a.doctor from CureSwitch a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.date DESC");
			break;
		case 16:
			sql.append("select a.id,a.date,a.exportOrg,a.fromOrg,b.username,a.doctor from CureBack a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.date DESC");
			break;
		case 17:
			sql.append("select a.id,a.buildDate,b.username,a.guardian,a.relation from Vaccination a,"+
					"SamTaxempcode b where a.fileNo = ? and a.inputPersonId = b.loginname order by a.buildDate DESC");
			break;
		default:
			break;
		}
		return sql;
	}
	
	public String queryDirectById(String[] id,int selectNo){
		String sql = "";
		switch (selectNo) {
		case 3:
		case 4:
			sql = "select b.name from BasicInformation b,CheckDirect c where b.id = c.checkDirectId and c.childrenMediExamId = ?";
			break;
		case 7:
			sql = "select b.name from BasicInformation b,BeforeBornDirect c where b.id = c.beforeBornDirectId and c.visitBeforeBornId = ?";
			break;
		case 10:
			sql = "select b.name from BasicInformation b,HypertensionSymptom c where b.id = c.hypertensionSymptomId and c.hypertensionVisitId = ?";
			break;
		case 11:
			sql = "select b.name from BasicInformation b,DiabetesSymptom c where b.id = c.diabetesSymptomId and c.diabetesVisitId = ?";
			break;
		default:
			break;
		}
		String result = "";
		Query query = getSession().createQuery(sql);;
		for(int i = 0; i < id.length;i++){
			query.setParameter(0, id[i]);
			List list = query.list();
			result = result + id[i] + ":";
			if(list.size() > 0){
				for(Object o : list){
					result = result + (String)o + "、";
				}
			}
			result = result + ',';
		}
		if(!result.equals("")){
			result = result.substring(0,result.length()-1);
		}
		return result;
	}
	
	public String queryUseDrugById(String[] ids,int selectNo){
		String sql = "";
		if(selectNo == 10){
			sql = "select drugName,usage,dosage from HypertensionMedications where HypertensionVisitID = ?";
		}else if(selectNo == 11){
			sql = "select drugName,usage,dosage from DiabetesMedications where diabetesVisitId = ?";
		}
		Query query = getSession().createQuery(sql);
		String result = "";
		for(int i=0;i<ids.length;i++){
			query.setParameter(0, ids[i]);
			List list = query.list();
			result = result + ids[i] + ":";
			if(list.size() > 0){
				for(Object o : list){
					Object[] objs = (Object[])o;
					result = result + (String)objs[0] + "、" + (String)objs[1] + "、" + (String)objs[2] + ";";
				}
			}
			result = result + ',';
		}
		if(!result.equals("")){
			result = result.substring(0,result.length()-1);
		}
		return result;
	}
}
