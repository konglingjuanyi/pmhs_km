package cn.net.tongfang.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.bo.HealthFileQry;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;

public class ReportStat extends HibernateDaoSupport {

	// private static final String parentDistrict = "532328";
	public static final Integer DISEASE_HYP = 2;
	public static final Integer DISEASE_FURI = 8;
	public static final Integer DISEASE_DIAB = 3;
	
	
	private static final String keyId = "id";
	private static final String orgId = "orgId";
	private static final String orgName = "orgName";
	private static final String farmCount = "farmCount";
	private static final String nonFarmCount = "nonFarmCount";

	private static final String doctorName = "doctorName";
	private static final String oldExam = "oldExam";
	private static final String vaccBaby = "vaccBaby";
	private static final String hypVisit = "hypVisit";
	private static final String hypFile = "hypFile";
	private static final String diabVisit = "diabVisit";
	private static final String diabFile = "diabFile";
	private static final String furiousVisit = "furiousVisit";
	private static final String furiousFile = "furiousFile";
	private static final String childBabyVisit = "childBabyVisit";
	private static final String childFile = "childFile";
	private static final String childVisit = "childVisit";
	private static final String pregnantFile = "pregnantFile";
	
	private static final String pregnantBeforeVisit = "pregnantBeforeVisit";
	private static final String pregnantNatalVisit = "pregnantNatalVisit";

	private static final String inputPersonName = "inputPersonName";
	
	private static final Logger logger = Logger.getLogger(ReportStat.class);
	
	public PagingResult findReport01() throws Exception {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			SortedMap<String, Map<String, Object>> map = new TreeMap<String, Map<String, Object>>();
			String sql = "";
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			String parentDistrict = user.getDistrictId();
			List<District> districts = getHibernateTemplate().find(
					"from District where parentId = ? order by id",
					parentDistrict);
			for (District district : districts) {
				String id = district.getId();
				setMapValue(map, id, orgId, id, true);
				setMapValue(map, id, orgName, district.getName());
				// 农业户口
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b"
						+ " where a.fileNo = b.fileNo and b.farmStatus = '是' "
						+ "and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%'" + " group by substring(a.districtNumber,1,9)";
				fillMap(map, farmCount, id, sql);
				// 非农业户口
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b"
						+ " where a.fileNo = b.fileNo and b.farmStatus = '否'"
						+ " and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, nonFarmCount, id, sql);
				
				// 高血压档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
						+ "and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%' and c.personalInfoId = b.id and c.diseaseId = "
						+ DISEASE_HYP + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, hypFile, id, sql);
				// 高血压
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, HypertensionVisit b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, hypVisit, id, sql);
				
				// 糖尿病档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
						+ "and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%' and c.personalInfoId = b.id and c.diseaseId = "
						+ DISEASE_DIAB + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, diabFile, id, sql);
				// 糖尿病
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, DiabetesVisit b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";

				fillMap(map, diabVisit, id, sql);
				
				// 重性精神病档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
						+ "and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%' and c.personalInfoId = b.id and c.diseaseId = "
						+ DISEASE_FURI + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, furiousFile, id, sql);
				// 重性精神病
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, FuriousVisit b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, furiousVisit, id, sql);

				// 新生儿
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, BabyVisit b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, childBabyVisit, id, sql);
				
				// 0~6岁儿童档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b"
						+ " where a.fileNo = b.fileNo and (year(getDate()) - year(b.birthday)) <= 6"
						+ " and  b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, childFile, id, sql);
				
				// 0~3岁儿童
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, ChildrenMediExam b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				long tmp0_3child = 0;
				for (StatNode node : (List<StatNode>) getHibernateTemplate()
						.find(sql)) {
					tmp0_3child = node.getNum();
				}
				// 3~6岁儿童
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, ChildrenMediExam36 b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				long tmp3_6child = 0;
				for (StatNode n : (List<StatNode>) getHibernateTemplate().find(
						sql)) {
					tmp3_6child = n.getNum();
				}
				setMapValue(map, id, childVisit, tmp0_3child + tmp3_6child);

				// 孕产妇档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, PersonalInfo b"
						+ " where a.fileNo = b.fileNo and b.bornStatus = '是'"
						+ " and b.fileNo Like '"
						+ EncryptionUtils.encry(id)
						+ "%'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, pregnantFile, id, sql);
				
				// 第1次产前随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, FirstVistBeforeBorn b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				long tmpFirstVisit = 0;
				for (StatNode node : (List<StatNode>) getHibernateTemplate()
						.find(sql)) {
					tmpFirstVisit = node.getNum();
				}
				// 第2~5次产前随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, VisitBeforeBorn b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				long tmpVisit = 0;
				for (StatNode node : (List<StatNode>) getHibernateTemplate()
						.find(sql)) {
					tmpVisit = node.getNum();
				}
				setMapValue(map, id, pregnantBeforeVisit, tmpFirstVisit
						+ tmpVisit);
				// 产后随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, VisitAfterBorn b where a.fileNo = b.fileNo "
//						+ "and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'" + " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, pregnantNatalVisit, id, sql);
				// 65岁以上老年人
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
						+ " from HealthFile a, MedicalExam b where a.fileNo = b.fileNo "
						+ " and b.age >= 65"
//						+ " and b.fileNo Like '"
//						+ EncryptionUtils.encry(id)
						+ "and b.execDistrictNum = '" 
						+ id
						+ "'"
						+ " group by substring(a.districtNumber,1,9)";
				
				fillMap(map, oldExam, id, sql);

			}

			list.addAll(map.values());
			Map<String, Object> m = new HashMap<String, Object>();
			m.put(orgName, "总计");

			for (Map<String, Object> _m : list) {
				Set<String> keys = _m.keySet();
				for (String k : keys) {
					Object v = _m.get(k);

					if (v != null
							&& (v instanceof Integer || v instanceof Long)) {
						try {
							int n1 = Integer.valueOf(String.valueOf(v));
							Object o2 = m.get(k);
							if (o2 == null) {
								m.put(k, n1);
							} else {
								int n2 = Integer.valueOf(String.valueOf(o2));
								m.put(k, n1 + n2);
							}
						} catch (Exception e) {
							logger.warn(e);
						}
					}
				}
			}
			list.add(m);

			return new PagingResult(list.size(), list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PagingResult findReport02() throws Exception {
		try {
			List list = new ArrayList();
			SortedMap<String, Map<String, Object>> map = new TreeMap<String, Map<String, Object>>();
			Session sess = getSession();
			String sql = "";
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			String parentDistrict = user.getDistrictId();
			SQLQuery sqlQuery = sess
					.createSQLQuery("select a.loginname as loginname, a.username as username, b.name as districtName"
							+ " from sam_taxempcode a, district b"
							+ " where (a.type & 2) > 0 and "
							+ " substring(a.district_id, 1, 9) = b.id and "
							+ " b.parentId = ? order by b.id");
			List list01 = sqlQuery.addScalar("loginname", Hibernate.STRING)
					.addScalar("username", Hibernate.STRING)
					.addScalar("districtName", Hibernate.STRING)
					.setString(0, parentDistrict).list();
			for (Object obj : list01) {
				Object[] objs = (Object[]) obj;
				String id = (String) objs[0];
				String username = (String) objs[1];
				String districtName = (String) objs[2];

				setMapValue(map, id, keyId, id, true);
				setMapValue(map, id, doctorName, username);
				setMapValue(map, id, orgName, districtName);
			}

			sql = "select new cn.net.tongfang.web.service.StatNode(a.doctor, count(*)) "
					+ " from MedicalExam a where a.age >= 65 group by a.doctor";
			for (StatNode node : (List<StatNode>) getHibernateTemplate().find(
					sql)) {
				setMapValue(map, node.getId(), oldExam, node.getNum());
			}

			list.addAll(map.values());

			return new PagingResult(list.size(), list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public PagingResult findReport03() throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		SortedMap<String, Map<String, Object>> map = new TreeMap<String, Map<String, Object>>();
		String sql = "";
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		Integer orgId = user.getOrgId();
		List<SamTaxempcode> users = getHibernateTemplate().find(
				"from SamTaxempcode where orgId = ? order by loginname",
				orgId);
		for (SamTaxempcode u : users) {
			String loginname = u.getLoginname();
			String id = u.getDistrictId();
			setMapValue(map, loginname, inputPersonName, u.getUsername(), true);

			// 农业户口
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '是' "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			fillMap(map, farmCount, loginname, sql);
			// 非农业户口
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '否'"
					+ " and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, nonFarmCount, loginname, sql);
			
			// 高血压档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_HYP + " group by substring(a.districtNumber,1,9)";
			
			fillMap(map, hypFile, loginname, sql);
			// 高血压
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, HypertensionVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, hypVisit, loginname, sql);
			
			// 糖尿病档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_DIAB + " group by substring(a.districtNumber,1,9)";
			
			fillMap(map, diabFile, loginname, sql);
			// 糖尿病
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, DiabetesVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";

			fillMap(map, diabVisit, loginname, sql);
			
			// 重性精神病档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_FURI + " group by substring(a.districtNumber,1,9)";
			
			fillMap(map, furiousFile, loginname, sql);
			// 重性精神病
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FuriousVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, furiousVisit, loginname, sql);

			// 新生儿
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, BabyVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, childBabyVisit, loginname, sql);
			
			// 0~6岁儿童档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and (year(getDate()) - year(b.birthday)) <= 6"
					+ " and  b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, childFile, loginname, sql);
			
			// 0~3岁儿童
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			long tmp0_3child = 0;
			for (StatNode node : (List<StatNode>) getHibernateTemplate()
					.find(sql)) {
				tmp0_3child = node.getNum();
			}
			// 3~6岁儿童
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam36 b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			long tmp3_6child = 0;
			for (StatNode n : (List<StatNode>) getHibernateTemplate().find(
					sql)) {
				tmp3_6child = n.getNum();
			}
			setMapValue(map, loginname, childVisit, tmp0_3child + tmp3_6child);

			// 孕产妇档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.bornStatus = '是'"
					+ " and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, pregnantFile, id, sql);
			
			// 第1次产前随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FirstVistBeforeBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			long tmpFirstVisit = 0;
			for (StatNode node : (List<StatNode>) getHibernateTemplate()
					.find(sql)) {
				tmpFirstVisit = node.getNum();
			}
			// 第2~5次产前随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitBeforeBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			long tmpVisit = 0;
			for (StatNode node : (List<StatNode>) getHibernateTemplate()
					.find(sql)) {
				tmpVisit = node.getNum();
			}
			setMapValue(map, loginname, pregnantBeforeVisit, tmpFirstVisit
					+ tmpVisit);
			// 产后随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitAfterBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, pregnantNatalVisit, inputPersonName, sql);
			// 65岁以上老年人
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, MedicalExam b where a.fileNo = b.fileNo "
					+ " and b.age >= 65" 
//					+ " and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ " and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputPersonId = '" + loginname + "' group by substring(a.districtNumber,1,9)";
			
			fillMap(map, oldExam, loginname, sql);

		}

		list.addAll(map.values());
		Map<String, Object> m = new HashMap<String, Object>();
		m.put(inputPersonName, "总计");

		for (Map<String, Object> _m : list) {
			Set<String> keys = _m.keySet();
			for (String k : keys) {
				Object v = _m.get(k);

				if (v != null
						&& (v instanceof Integer || v instanceof Long)) {
					try {
						int n1 = Integer.valueOf(String.valueOf(v));
						Object o2 = m.get(k);
						if (o2 == null) {
							m.put(k, n1);
						} else {
							int n2 = Integer.valueOf(String.valueOf(o2));
							m.put(k, n1 + n2);
						}
					} catch (Exception e) {
						logger.warn(e);
					}
				}
			}
		}
		list.add(m);

		return new PagingResult(list.size(), list);
	}

	/**
	 * 设置map的orgid的一个map value (k,v)
	 * 
	 * @param map
	 * @param id
	 * @param k
	 * @param v
	 */
	private void setMapValue(Map<String, Map<String, Object>> map, String id,
			String k, Object v, boolean canCreate) {
		Map<String, Object> m = new HashMap<String, Object>();
		if (map.containsKey(id)) {
			m = map.get(id);
		} else {
			if (canCreate)
				map.put(id, m);
		}
		m.put(k, v);
	}

	private void setMapValue(Map<String, Map<String, Object>> map, String id,
			String k, Object v) {
		setMapValue(map, id, k, v, false);
	}

	// 自己新增的方法如下：
	private static final String fileNo = "fileNo";
	private static final String name = "name";

	
	public PagingResult querySum() {
		SortedMap<String, Map<String, Object>> map = new TreeMap<String, Map<String, Object>>();
		String hql = "select fileNo,name from HealthFile a";
		List<HealthFile> list = getHibernateTemplate().find(hql);
		System.out.println(list.size() + ":" + list.get(0));
		for (HealthFile hf : list) {
			setMapValue(map, hf.getFileNo(), fileNo, hf.getFileNo(), true);
			setMapValue(map, hf.getFileNo(), name, hf.getName());
		}

		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		list1.addAll(map.values());
		return new PagingResult(list.size(), list);
	}

	//各乡镇卫生院统计
	public PagingResult findReport04() throws Exception {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			SortedMap<String, Map<String, Object>> map = new TreeMap<String, Map<String, Object>>();
			String sql = "";
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
					.currentOperator();
			String parentDistrict = user.getDistrictId();
			String tmpOrgName = "";
			Integer tmpOrgId;
			Query query = null;
			List<District> districts = getHibernateTemplate().find(
					"from District where parentId = ? order by id",
					parentDistrict);
			for (District district : districts) {
				String id = district.getId();
				sql = "Select A.id,A.name From SamTaxorgcode A Where A.districtNumber = '" + 
						id + "'";
				query = getSession().createQuery(sql);
				List l = query.list();
				for (int i = 0; i < l.size(); i++) {
					Object[] objs = (Object[])l.get(i);
					tmpOrgId = (Integer)objs[0];
					tmpOrgName = (String)objs[1];
					setMapValue(map, tmpOrgName, orgId, tmpOrgId, true);
					setMapValue(map, tmpOrgName, orgName, tmpOrgName);
					// 农业户口
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
							+ " where a.fileNo = b.fileNo and b.farmStatus = '是' "
							+ "and b.inputPersonId = c.loginname And c.orgId ="
							+ tmpOrgId
							+ " group by substring(a.districtNumber,1,9)";
					fillMap(map, farmCount, tmpOrgName, sql);

					// 非农业户口
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
							+ " where a.fileNo = b.fileNo and b.farmStatus = '否'"
							+ " and b.inputPersonId = c.loginname And c.orgId ="
							+ tmpOrgId
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, nonFarmCount, tmpOrgName, sql);
					
					// 高血压档案
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId
							+ " and d.personalInfoId = b.id and d.diseaseId = "
							+ DISEASE_HYP + " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, hypFile, tmpOrgName, sql);
					// 高血压
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, HypertensionVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, hypVisit, tmpOrgName, sql);
					
					// 糖尿病档案
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId
							+ " and d.personalInfoId = b.id and d.diseaseId = "
							+ DISEASE_DIAB + " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, diabFile, tmpOrgName, sql);
					// 糖尿病
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, DiabetesVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, diabVisit, tmpOrgName, sql);
					// 重性精神病档案
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId
							+ " and d.personalInfoId = b.id and d.diseaseId = "
							+ DISEASE_FURI + " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, furiousFile, tmpOrgName, sql);
					// 重性精神病
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, FuriousVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, furiousVisit, tmpOrgName, sql);
					// 新生儿
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, BabyVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, childBabyVisit, tmpOrgName, sql);
					
					// 0~6岁儿童档案
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c "
							+ " where a.fileNo = b.fileNo and (year(getDate()) - year(b.birthday)) <= 6"
							+ " and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, childFile, tmpOrgName, sql);
					
					// 0~3岁儿童
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, ChildrenMediExam b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					long tmp0_3child = 0;
					for (StatNode node : (List<StatNode>) getHibernateTemplate().find(sql)) {
						tmp0_3child = node.getNum();
					}
					// 3~6岁儿童
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, ChildrenMediExam36 b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					long tmp3_6child = 0;
					for (StatNode n : (List<StatNode>) getHibernateTemplate().find(
							sql)) {
						tmp3_6child = n.getNum();
					}
					setMapValue(map, tmpOrgName, childVisit, tmp0_3child + tmp3_6child);

					// 孕产妇档案
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
							+ " where a.fileNo = b.fileNo and b.bornStatus = '是'"
							+ " and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, pregnantFile, tmpOrgName, sql);
					
					// 第1次产前随访
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, FirstVistBeforeBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					long tmpFirstVisit = 0;
					for (StatNode node : (List<StatNode>) getHibernateTemplate()
							.find(sql)) {
						tmpFirstVisit = node.getNum();
					}
					// 第2~5次产前随访
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, VisitBeforeBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, pregnantBeforeVisit, tmpOrgName, sql);
					// 产后随访
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, VisitAfterBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ "and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					
					fillMap(map, pregnantNatalVisit, tmpOrgName, sql);
					// 65岁以上老年人
					sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
							+ " from HealthFile a, MedicalExam b,SamTaxempcode c where a.fileNo = b.fileNo "
							+ " and b.age >= 65 and b.inputPersonId = c.loginname  And c.orgId ="
							+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
							+ " group by substring(a.districtNumber,1,9)";
					fillMap(map, oldExam, tmpOrgName, sql);
				}
			}

			list.addAll(map.values());
			Map<String, Object> m = new HashMap<String, Object>();
			m.put(orgName, "总计");

			for (Map<String, Object> _m : list) {
				Set<String> keys = _m.keySet();
				for (String k : keys) {
					Object v = _m.get(k);

					if (v != null
							&& (v instanceof Integer || v instanceof Long)) {
						try {
							int n1 = Integer.valueOf(String.valueOf(v));
							Object o2 = m.get(k);
							if (o2 == null) {
								m.put(k, n1);
							} else {
								int n2 = Integer.valueOf(String.valueOf(o2));
								m.put(k, n1 + n2);
							}
						} catch (Exception e) {
							logger.warn(e);
						}
					}
				}
			}
			list.add(m);

			return new PagingResult(list.size(), list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void fillMap(SortedMap<String, Map<String, Object>> map,String count,String id,String sql){
		List<StatNode> nodes = getHibernateTemplate().find(sql);
		long tmpFarm = 0;
		for (StatNode node : nodes) {
			tmpFarm = node.getNum();
		}
		setMapValue(map, id, count, tmpFarm);
	}
	
	
}
