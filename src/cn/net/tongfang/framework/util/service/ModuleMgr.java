package cn.net.tongfang.framework.util.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import cn.net.tongfang.framework.security.SecurityManager;
import cn.net.tongfang.framework.security.bo.Condition;
import cn.net.tongfang.framework.security.bo.HealthFileQry;
import cn.net.tongfang.framework.security.bo.QryCondition;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.BabyBarrierReg;
import cn.net.tongfang.framework.security.vo.BabyDeathSurvey;
import cn.net.tongfang.framework.security.vo.BabyVisit;
import cn.net.tongfang.framework.security.vo.ChildBirthRecord;
import cn.net.tongfang.framework.security.vo.ChildLastMedicalExamRecord;
import cn.net.tongfang.framework.security.vo.ChildrenDeathSurvey01;
import cn.net.tongfang.framework.security.vo.ChildrenDeathSurvey02;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam3;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam36;
import cn.net.tongfang.framework.security.vo.ClinicLogs;
import cn.net.tongfang.framework.security.vo.Consultation;
import cn.net.tongfang.framework.security.vo.CureBack;
import cn.net.tongfang.framework.security.vo.CureSwitch;
import cn.net.tongfang.framework.security.vo.DiabetesVisit;
import cn.net.tongfang.framework.security.vo.DiseaseAndHearScreenConsent;
import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.FuriousInfo;
import cn.net.tongfang.framework.security.vo.FuriousVisit;
import cn.net.tongfang.framework.security.vo.HealthEducat;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.HearScreenReportCard;
import cn.net.tongfang.framework.security.vo.HomeInfo;
import cn.net.tongfang.framework.security.vo.HypertensionVisit;
import cn.net.tongfang.framework.security.vo.InfectionReport;
import cn.net.tongfang.framework.security.vo.MedicalExam;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.Reception;
import cn.net.tongfang.framework.security.vo.SamModule;
import cn.net.tongfang.framework.security.vo.SamModuleCategory;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;
import cn.net.tongfang.framework.security.vo.SamTaxorgcode;
import cn.net.tongfang.framework.security.vo.SickInfo;
import cn.net.tongfang.framework.security.vo.Stat;
import cn.net.tongfang.framework.security.vo.Tuberculosis;
import cn.net.tongfang.framework.security.vo.Vaccination;
import cn.net.tongfang.framework.security.vo.VaccineInfo;
import cn.net.tongfang.framework.security.vo.VisitAfterBorn;
import cn.net.tongfang.framework.security.vo.VisitBeforeBorn;
import cn.net.tongfang.framework.security.vo.WomanLastMedicalExamRecord;
import cn.net.tongfang.framework.util.BusiUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.vo.CatInfo;
import cn.net.tongfang.framework.util.service.vo.ExtJSTreeNode;
import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import cn.net.tongfang.web.service.bo.ChildBirthRecordBO;

public class ModuleMgr extends HibernateDaoSupport {

	private static final Logger log = Logger.getLogger(ModuleMgr.class);
	public static final Integer DISEASE_HYP = 2;
	public static final Integer DISEASE_FURI = 8;
	public static final Integer DISEASE_DIAB = 3;
	// public static final Integer DISEASE_HYP = 527;
	// public static final Integer DISEASE_FURI = 533;
	// public static final Integer DISEASE_DIAB = 528;
	public static final String VISIT_AFTER_DEFAULT = "0";
	public static final String VISIT_AFTER_42 = "1";

	public List<CatInfo> getCatInfo() {

		String hql = "select new cn.net.tongfang.framework.util.service.vo.CatInfo(m,c)  from "
				+ " SamModule m, SamModuleCategory c where m.categoryId = c.id";
		try {
			List<CatInfo> list = getHibernateTemplate().find(hql);
			log.debug("List size is " + list.size());
			return list;
		} catch (Throwable t) {
			t.printStackTrace();
			return new ArrayList<CatInfo>();
		}

	}

	@SuppressWarnings("unchecked")
	public List<CatInfo> getUserCatInfo() {

		final String sql = "select {module.*}, {mc.*} from sam_module_category mc, ( select m.* from"
				+ " sam_module m where m.id in ( select rm.module_id from sam_role_module rm "
				+ " where rm.role_id in ( select ur.id from sam_taxempcode_role ur,"
				+ " sam_taxempcode u where u.loginname = :loginname and u.loginname = ur.loginname) ) ) module where mc.id = module.category_id order by mc.ordinal, module.ordinal";

		try {

			List<CatInfo> list = (List<CatInfo>) this.getHibernateTemplate()
					.execute(new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery sqlQry = session.createSQLQuery(sql)
									.addEntity("mc", SamModuleCategory.class)
									.addEntity("module", SamModule.class);

							sqlQry.setString("loginname", SecurityManager
									.currentOperator().getUsername());
							List<Object[]> objs = sqlQry.list();
							List<CatInfo> results = new ArrayList<CatInfo>();
							for (Object[] items : objs) {
								SamModule mod = (SamModule) items[1];
								SamModuleCategory cat = (SamModuleCategory) items[0];
								results.add(new CatInfo(mod, cat));
							}

							return results;
						}

					});

			// log.debug("List size is " + list.size());
			return list;
		} catch (Throwable t) {
			t.printStackTrace();
			return new ArrayList<CatInfo>();
		}

	}

	public List<ExtJSTreeNode> genUserMenuTree() {
		List<CatInfo> catInfos = getUserCatInfo();
		ExtJSTreeNode last = null;
		List<ExtJSTreeNode> res = new ArrayList<ExtJSTreeNode>();

		for (CatInfo ci : catInfos) {
			String catName = ci.getCategory().getName();
			String catId = ci.getCategory().getId();
			if (last == null) {
				last = new ExtJSTreeNode(catName, catId, "folder", false);
				last.addChild(new ExtJSTreeNode(ci.getModule().getName(), ci
						.getModule().getUrl(), "file", true));
				res.add(last);
			} else if (last.getId().equals(ci.getCategory().getId())) {
				last.addChild(new ExtJSTreeNode(ci.getModule().getName(), ci
						.getModule().getUrl(), "file", true));
			} else {
				last = new ExtJSTreeNode(catName, catId, "folder", false);
				last.addChild(new ExtJSTreeNode(ci.getModule().getName(), ci
						.getModule().getUrl(), "file", true));
				res.add(last);
			}
		}
		return res;
	}

	private List<ExtJSTreeNode> getOrgByParentId(Integer id,ExtJSTreeNode l,List<ExtJSTreeNode> res,Integer type){
		List<SamTaxorgcode> orgs = new ArrayList<SamTaxorgcode>();
		String hql = "";
		if(type.equals(0)){
			hql = "From SamTaxorgcode Where id = ?";
		}else if(type.equals(1)){
			hql = "From SamTaxorgcode Where parentId = ?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		orgs = query.list();
		ExtJSTreeNode last = l;
		for (SamTaxorgcode org : orgs) {
			String orgName = org.getName();
			String orgId = String.valueOf(org.getId());
			if (last == null) {
				if(org.getIsDetail().equals(0)){
					last = new ExtJSTreeNode(orgName, orgId, "folder", false);
					getOrgByParentId(org.getId(),last,res,1);
					res.add(last);
				}else{
					last = new ExtJSTreeNode(orgName, orgId, "file", true);
					res.add(last);
				}
			} else {
				if(org.getIsDetail().equals(0)){
					last = new ExtJSTreeNode(orgName, orgId, "folder", false);
					getOrgByParentId(org.getId(),last,res,1);
					res.add(last);
				}else{
					last.addChild(new ExtJSTreeNode(orgName, orgId, "file", true));
				}
			}
		}
		return res;
	}
	
	public List<ExtJSTreeNode> getOrgMenuTree() {
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String districtId = user.getDistrictId();
		Integer id = user.getOrgId();
		List<ExtJSTreeNode> res = new ArrayList<ExtJSTreeNode>();
		return getOrgByParentId(id,null,res,0);
	}
	
	private List<District> getUserDistrict() {
//		Integer orgId = SecurityManager.currentOperator().getOrgId();
		String disId = SecurityManager.currentOperator().getDistrictId();
		log.debug("currunt user disId: " + disId);
		List<District> list = getHibernateTemplate().find(
				"from District where id=?", disId);
		return list;
	}
	private List<District> getUserDistrictIgnore() {
//		Integer orgId = SecurityManager.currentOperator().getOrgId();
		String disId = SecurityManager.currentOperator().getDistrictId();
		log.debug("currunt user disId: " + disId);
		List<District> list = getHibernateTemplate().find(
				"from District where id=?", disId.substring(0, 6));
		return list;
	}
	
	
	/**
	 * 获得当前用户的组织机构
	 * @return
	 */
	private List<SamTaxorgcode> getUserOrganization() {
		Integer orgId = SecurityManager.currentOperator().getOrgId();
		log.debug("currunt user orgId: " + orgId);
		List<SamTaxorgcode> list = getHibernateTemplate().find(
				"from SamTaxorgcode where id=?", orgId);
		return list;
	}
	
	/**
	 * 获得当前用户的组织机构
	 * @return
	 */
	public Map<String ,String> getOrgMap() {
		List<District> list = getHibernateTemplate().find("from District");
		Map<String ,String> map = new HashMap<String ,String>();
		for(District org : list){
			map.put(""+org.getId(), org.getName());
		}
		return map;
	}

	
	
	public List<District> getSelectedUserDistrict() {
//		String disId = SecurityManager.currentOperator().getDistrictId();
		Integer level = SecurityManager.currentOperator().getDistrict().getLevel();
		String disId = "";
		if(level > 3){
			disId = SecurityManager.currentOperator().getDistrict().getParentId();
		}else{
			disId = SecurityManager.currentOperator().getDistrictId();
		}
		
		log.debug("currunt user disId: " + disId);
		List<District> list = getHibernateTemplate().find(
				"from District where id=?", disId);
		return list;
	}
	
	public List<ExtJSTreeNode> getDistricts(String pid,ExtJSTreeNode node,List<ExtJSTreeNode> nodes) {
		List<District> list = getHibernateTemplate().find(
				"from District where parentId = ?", pid);
		for (District district : list) {
			if (district.getOrgId() != null) {
				SamTaxorgcode org = (SamTaxorgcode) getHibernateTemplate().get(
						SamTaxorgcode.class, district.getOrgId());
				if (org != null)
					district.setOrg(org);
			}
			boolean isDetail = district.isIsDetail();
			if(isDetail){
				node.addChild(new ExtJSTreeNode(district.getName(),district.getId(), "file", isDetail));
				//nodes.add(node);
			}else{
				ExtJSTreeNode tmpNode = new ExtJSTreeNode(district.getName(),
						district.getId(), "folder", isDetail);
				node.addChild(tmpNode);
				getDistricts(district.getId(),tmpNode,nodes);
			}
		}
		return nodes;
	}
	
	public List<ExtJSTreeNode> getSelectedUserDistrictNodes(){
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		List<District> list = getSelectedUserDistrict();
		if(list.size() > 0){
			for (District district : list) {
				boolean isDetail = district.isIsDetail();
				if(isDetail){
					ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
							district.getId(), "file", isDetail);
					nodes.add(node);
				}else{
					ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
							district.getId(), "folder", isDetail);
					getDistricts(district.getId(),node,nodes);
					nodes.add(node);
				}
				
			}
		}
		return nodes;
	}
	
	/**
	 * 获得组织机构的树
	 * @param orgOrDistrict
	 * @return
	 */
	public List<ExtJSTreeNode> getOrganizationNodes(String orgOrDistrict) {

		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();

		log.debug("orgId or DistrictId : " + orgOrDistrict);

		if (orgOrDistrict == null || "org".equalsIgnoreCase(orgOrDistrict)) {
			List<SamTaxorgcode> list = getUserOrganization();
			for (SamTaxorgcode org : list) {
				ExtJSTreeNode node = new ExtJSTreeNode(org.getName(),
						String.valueOf(org.getId()), org.getIsDetail() == 0 ? false : true, org);
				nodes.add(node);
			}
		} else {
			nodes = getOrganization(orgOrDistrict);
		}
		return nodes;
	}
	
	/**
	 * 如果参数是组织机构：字符串：'org' or NULL ，则返回该组织机构所对应的行政区域 如果参数是行政区域Id，则返回其下级
	 * 
	 * @param orgOrDistrict
	 * @return
	 */
	public List<ExtJSTreeNode> getUserDistrictNodes(String orgOrDistrict) {

		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();

		log.debug("orgId or DistrictId : " + orgOrDistrict);

		if (orgOrDistrict == null || "org".equalsIgnoreCase(orgOrDistrict) || "orgIgnoreDistrict".equalsIgnoreCase(orgOrDistrict)) {
			List<District> list = null;
			if("orgIgnoreDistrict".equalsIgnoreCase(orgOrDistrict))
				list = getUserDistrictIgnore();
			else
				list = getUserDistrict();
			for (District district : list) {
				ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
						district.getId(), district.isIsDetail(), district);
				nodes.add(node);
			}
		} else {
			nodes = getDistricts(orgOrDistrict);
		}
		return nodes;
	}

	/**
	 * 根据父节点取得子节点，是递归的 此方法要慎用！！
	 * 
	 * @param pid
	 * @return
	 */
	public List<ExtJSTreeNode> getUserDistrictTree(String pid) {
		List<District> list = getHibernateTemplate().find(
				"from District where parentId = ?", pid);
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		for (District district : list) {
			List<ExtJSTreeNode> children = getUserDistrictTree(district.getId());
			if (children.size() != 0) {
				ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
						district.getId(), "folder", false);
				node.addChildren(children);
				nodes.add(node);
			} else {
				ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
						district.getId(), "file", true);
				nodes.add(node);
			}
		}
		return nodes;
	}

	/**
	 * 根据父节点取得子节点，非递归的
	 * @param pid
	 * @return
	 */
	public List<ExtJSTreeNode> getOrganization(String pid) {
		List<SamTaxorgcode> list = getHibernateTemplate().find(
				"from SamTaxorgcode where parentId = ?", Integer.parseInt(pid));
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		for (SamTaxorgcode org : list) {
			ExtJSTreeNode node = new ExtJSTreeNode(org.getName(),
					String.valueOf(org.getId()), org.getIsDetail() == 0 ? false : true, org);
			nodes.add(node);
		}
		return nodes;
	}
	
	/**
	 * 根据父节点取得子节点，非递归的
	 * 
	 * @param pid
	 * @return
	 */
	public List<ExtJSTreeNode> getDistricts(String pid) {
		List<District> list = getHibernateTemplate().find(
				"from District where parentId = ?", pid);
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		for (District district : list) {
			if (district.getOrgId() != null) {
				SamTaxorgcode org = (SamTaxorgcode) getHibernateTemplate().get(
						SamTaxorgcode.class, district.getOrgId());
				if (org != null)
					district.setOrg(org);
			}
			ExtJSTreeNode node = new ExtJSTreeNode(district.getName(),
					district.getId(), district.isIsDetail(), district);
			nodes.add(node);
		}
		return nodes;
	}

	/**
	 * 根据父节点取得子节点，非递归的
	 * 
	 * @param pid
	 * @return
	 */
	public List<ExtJSTreeNode> getOrgs(Integer pid) {
		List<SamTaxorgcode> list = getHibernateTemplate().find(
				"from SamTaxorgcode where parentId = ?", pid);
		List<ExtJSTreeNode> nodes = new ArrayList<ExtJSTreeNode>();
		for (SamTaxorgcode org : list) {
			ExtJSTreeNode node = new ExtJSTreeNode(org.getName(), org.getId()
					.toString(), "folder", false, org);
			nodes.add(node);
		}
		return nodes;
	}

	public District saveDistrict(District district) {
		log.debug("district: " + district);
		int level = district.getLevel();
		if (level == 6)
			district.setIsDetail(true);
		getHibernateTemplate().saveOrUpdate(district);
		district = (District) getHibernateTemplate().get(District.class,
				district.getId());
		return district;
	}

	public void removeDistrict(String districtId) {
		log.debug("district id: " + districtId);
		District district = (District) getHibernateTemplate().get(
				District.class, districtId);
		if (district != null)
			getHibernateTemplate().delete(district);
		return;
	}

	public SamTaxorgcode saveOrg(SamTaxorgcode org) {
		org.setIsDetail(1);
		org.setIsOrgDepart(0);
		getHibernateTemplate().saveOrUpdate(org);
		District dis = (District)getHibernateTemplate().get(District.class,
				org.getDistrictNumber());
		dis.setOrgId(org.getId());
		getHibernateTemplate().update(dis);
		org = (SamTaxorgcode) getHibernateTemplate().get(SamTaxorgcode.class,
				org.getId());
		return org;
	}

	public void removeOrg(Integer orgId) {
		SamTaxorgcode org = (SamTaxorgcode) getHibernateTemplate().get(
				SamTaxorgcode.class, orgId);
		if (org != null){
			District dis = org.getDistrict();
			dis.setOrgId(0);
			getHibernateTemplate().update(dis);
			getHibernateTemplate().delete(org);
		}
		return;
	}

	public PagingResult<SamTaxorgcode> findOrgs(SamTaxorgcode qryCond,
			PagingParam pp) {
		StringBuilder where = new StringBuilder();
		List params = new ArrayList();

		String name = qryCond.getName();
		if (StringUtils.hasText(name)) {
			params.add(name);
			where.append(" and substring(name,1," + name.trim().length() + ") = ?");
		}

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from SamTaxorgcode").append(
				where).append(" order by id");
		log.debug("hql: " + hql.toString());

		return query(hql, params, pp);
	}

	/**
	 * 特殊的，qryCond中的id，表示所查询的district只能是其本身和其孩子
	 * 
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<District> findDistricts(District qryCond, PagingParam pp) {
		StringBuilder where = new StringBuilder();
		List params = new ArrayList();

		String districtId = qryCond.getId();
		if (StringUtils.hasText(districtId) && !districtId.equals("0")) {
			String districtPrefix = BusiUtils.trimTailSeq(districtId, "00");
			params.add(districtPrefix);
			where.append(" and substring(id,1," + districtPrefix.trim().length() + ") = ?");
		}

		String name = qryCond.getName();
		if (StringUtils.hasText(name)) {
			params.add(name);
			where.append(" and substring(name,1," + name.trim().length() + ") = ?");
		}

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from District").append(where)
				.append(" order by id");
		log.debug("hql: " + hql.toString());

		return query(hql, params, pp);
	}

	private <T> PagingResult<T> query(StringBuilder hql, List params,
			PagingParam pp) {
		if (pp == null)
			pp = new PagingParam();

		int fromPos = hql.indexOf("from ");
		int orderBy = hql.indexOf(" order by ");
		String countSql = "select count(*) " + hql.substring(fromPos, orderBy);
		log.debug("countSql: " + countSql);

		Query q = getSession().createQuery(countSql.toString());
		for (int i = 0; i < params.size(); i++) {
			q.setParameter(i, params.get(i));
		}
		int totalSize = ((Long) q.uniqueResult()).intValue();
		log.debug("totalSize: " + totalSize);

		Query query = getSession().createQuery(hql.toString());
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}

		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List<T> list = query.list();
		return new PagingResult<T>(totalSize, list);
	}

	public PagingResult<HealthFile> findHealthFiles(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildHealthHql(qryCond, params);
		return queryHealthFiles(pp, params, hql);
	}

	public PagingResult<HealthFile> queryHealthFiles(PagingParam pp,
			List params, StringBuilder hql) {
		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<HealthFile> files = new ArrayList<HealthFile>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
				tmpFileNo = file.getFileNo();
			}		
			
			
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			file.setPersonalInfo(person);

			files.add(file);
		}
		PagingResult<HealthFile> result = new PagingResult<HealthFile>(
				p.getTotalSize(), files);
		return result;
	}

	private StringBuilder buildHealthHql(HealthFileQry qryCond, List params) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhereHealthFile(qryCond, params, where);

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b").append(where).append(
				" order by a.name ASC");
		log.debug("hql: " + hql.toString());
		return hql;
	}
	
	private void buildGeneralWhereHealthFile(HealthFileQry qryCond, List params,
			StringBuilder where) {
		String districtId = qryCond.getDistrict();
		if (StringUtils.hasText(districtId)) {
			params.add(districtId);
			where.append(" and substring(a.districtNumber,1," + districtId.trim().length() + ") = ? ");
		}
		genQueryParams(qryCond, params, where);

		where.append(" and a.fileNo = b.fileNo and a.status = 0 ");
	}

	private void genQueryParams(HealthFileQry qryCond, List params,
			StringBuilder where) {
		String filterKey = qryCond.getFilterKey();
		if (StringUtils.hasText(filterKey)) {
			String filterValue = qryCond.getFilterValue();
			if(filterKey.equals("a.name") || filterKey.equals("a.fileNo")){
				filterValue = EncryptionUtils.encry(filterValue);
			}
			if(filterKey.equals("a.inputDate") || filterKey.equals("b.birthday") || filterKey.equals("a.lastModifyDate")){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
				try {
					Date startDate = null;
					Date endDate = null;
					if(filterValue.indexOf("-") > 0){
						String[] valArray = filterValue.split("-");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else if(filterValue.indexOf("－") > 0){
						String[] valArray = filterValue.split("－");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else{
						startDate = format.parse(filterValue + " 00:00:00");
						endDate = format.parse(filterValue + " 23:59:59");
					}
					params.add(startDate);
					params.add(endDate);
					where.append(" and " + filterKey + " >= ? and " + filterKey + " <= ? ");
				} catch (ParseException e) {
					throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
				}				
			}else{
				if (StringUtils.hasText(filterValue)) {
					params.add(filterValue);
					where.append(" and substring(" + filterKey + ",1," + filterValue.length() + ") = ?");
				}
			}
		}
	}

	private void buildGeneralWhere(HealthFileQry qryCond, List params,
			StringBuilder where) {
		String districtId = qryCond.getDistrict();
		if (StringUtils.hasText(districtId)) {
			params.add(districtId + '%');
			params.add(districtId + '%');
			where.append(" and (a.districtNumber like ? or c.execDistrictNum like ?) ");
		}
		String filterKey = qryCond.getFilterKey();
		if (StringUtils.hasText(filterKey)) {
			String filterValue = qryCond.getFilterValue();
			if(filterKey.equals("a.name") || filterKey.equals("a.fileNo")){
				filterValue = EncryptionUtils.encry(filterValue);
				params.add(filterValue);
				where.append(" and substring(" + filterKey + ",1," + filterValue.trim().length() + ") = ?");
			}else if(filterKey.equals("a.inputDate") || filterKey.equals("b.birthday") || filterKey.equals("a.lastModifyDate")){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
				try {
					Date startDate = null;
					Date endDate = null;
					if(filterValue.indexOf("-") > 0){
						String[] valArray = filterValue.split("-");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else if(filterValue.indexOf("－") > 0){
						String[] valArray = filterValue.split("－");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else{
						startDate = format.parse(filterValue + " 00:00:00");
						endDate = format.parse(filterValue + " 23:59:59");
					}
					params.add(startDate);
					params.add(endDate);
					if(filterKey.equals("a.inputDate"))
						filterKey = "c.inputDate";
					where.append(" and " + filterKey + " >= ? and " + filterKey + "<= ? ");
				} catch (ParseException e) {
					throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
				}
			}else if(filterKey.equals("c.highRisk")){
				if (StringUtils.hasText(filterValue)) {
					params.add(filterValue);
					where.append(" and " + filterKey + " = ?");
				}
			}else{
				if (StringUtils.hasText(filterValue)) {
					params.add(filterValue);
					where.append(" and substring(" + filterKey + ",1," + filterValue.trim().length() + ") = ?");
				}
			}
		}

		where.append(" and a.fileNo = b.fileNo and a.status = 0 ");
	}

	public PagingResult<HealthFile> findChildHealthFiles(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildChildHealthHql(qryCond, params);
		return queryHealthFiles(pp, params, hql);
	}

	public PagingResult<HealthFile> findWomanBirthHealthFiles(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildWomanBirthHealthHql(qryCond, params);
		return queryHealthFiles(pp, params, hql);
	}
	
	public PagingResult<HealthFile> findHypHealthFiles(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildDiseaseHealthHql(qryCond, params, DISEASE_HYP);
		return queryHealthFiles(pp, params, hql);
	}

	public PagingResult<HealthFile> findFuriosusHealthFiles(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildDiseaseHealthHql(qryCond, params, DISEASE_FURI);
		return queryHealthFiles(pp, params, hql);
	}

	public PagingResult<HealthFile> findDiabetesHealthFiles(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildDiseaseHealthHql(qryCond, params, DISEASE_DIAB);
		return queryHealthFiles(pp, params, hql);
	}

	private StringBuilder buildWomanBirthHealthHql(HealthFileQry qryCond, List params) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhereHealthFile(qryCond, params, where);

		where.append(" and b.bornStatus >= ?");
		params.add("是");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b").append(where).append(
				" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}
	
	private StringBuilder buildChildHealthHql(HealthFileQry qryCond, List params) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhereHealthFile(qryCond, params, where);

		Timestamp childAge = BusiUtils.getChildAge();

		where.append(" and b.birthday >= ?");
		params.add(childAge);

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b").append(where).append(
				" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}

	private StringBuilder buildHypHealthHql(HealthFileQry qryCond, List params) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and c.diseaseId = ?");
		params.add(DISEASE_HYP);

		where.append(" and c.personalInfoId = b.id");
		
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, DiseaseHistory c").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}

	private StringBuilder buildDiseaseHealthHql(HealthFileQry qryCond,
			List params, Integer DiseaseType) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhereHealthFile(qryCond, params, where);

		where.append(" and c.diseaseId = ?");
		params.add(DiseaseType);

		where.append(" and c.personalInfoId = b.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, DiseaseHistory c").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}

	public void removeHealthFile(String fileNo) {
		HealthFile file = (HealthFile) getHibernateTemplate().get(
				HealthFile.class, fileNo);
		if (file != null) {
			List personList = getHibernateTemplate().find(
					"from PersonalInfo where fileNo = ?", fileNo);
			TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
			if(user.getUsername().equals(file.getInputPersonId())){
				getHibernateTemplate().deleteAll(personList);
				getHibernateTemplate().delete(file);
			}
		}

		return;
	}

	public void removeHealthFiles(List<String> fileNoList) {
		for (String fileNo : fileNoList) {
			fileNo = EncryptionUtils.encry(fileNo);
			removeHealthFile(fileNo);
		}
		return;
	}

	/**
	 * 原密码不正确，返回失败，新密码不匹配也返回失败
	 * 
	 * @param pwd
	 * @param newPwd
	 * @param newPwd2
	 * @return
	 */
	public boolean changePwd(String pwd, String newPwd, String newPwd2) {
		TaxempDetail o = SecurityManager.currentOperator();
		SamTaxempcode user = (SamTaxempcode) getHibernateTemplate().get(
				SamTaxempcode.class, o.getUsername());
		log.debug("input password: " + pwd);
		log.debug("old password: " + user.getPassword());

		if (pwd.equals(user.getPassword())) {
			if (newPwd.equals(newPwd2)) {
				user.setPassword(newPwd);
				getHibernateTemplate().update(user);
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	private void removeRecords(final List<String> recordIdList,
			final Class clazz) {
		if (recordIdList == null || recordIdList.size() == 0) {
			return;
		}

		final String pkName = "id";

		try {
			getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
					String hql = "delete from " + clazz.getName() + " where "
							+ pkName + " = ?";
					for (String id : recordIdList) {
						String inputPersonId = (String)session.createQuery("Select inputPersonId From " 
								+ clazz.getName() + " where " + pkName + " = ?").setParameter(0, id).list().get(0);
						if(user.getUsername().equals(inputPersonId)){
							session.createQuery(hql).setParameter(0, id)
								.executeUpdate();
						}
					}
					return null;
				}
			});
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void removeBabyVisitRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, BabyVisit.class);
	}

	public void removeChildExamRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildrenMediExam.class);
	}

	public void removeChildExam3Records(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildrenMediExam3.class);
	}

	public PagingResult<Map<String, Object>> findBabyVisitRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, BabyVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			BabyVisit babyVisit = (BabyVisit) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(babyVisit);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", babyVisit);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public PagingResult<Map<String, Object>> findChildExam1Records(
			HealthFileQry qryCond, PagingParam pp) {
		return findChildExamRecords(qryCond, pp, 0);
	}

	public PagingResult<Map<String, Object>> findChildExam2Records(
			HealthFileQry qryCond, PagingParam pp) {
		return findChildExamRecords(qryCond, pp, 1);
	}

	private PagingResult<Map<String, Object>> findChildExamRecords(
			HealthFileQry qryCond, PagingParam pp, Integer type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		if (type != null) {
			where.append(" and c.dataType = ?");
			params.add(type);
		}

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenMediExam c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenMediExam childrenMediExam = (ChildrenMediExam) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childrenMediExam);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", childrenMediExam);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public PagingResult<Map<String, Object>> findChildExam3Records(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenMediExam3 c, SamTaxempcode d")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenMediExam3 childrenMediExam3 = (ChildrenMediExam3) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childrenMediExam3);
			getHibernateTemplate().evict(samTaxempcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", childrenMediExam3);
			map.put("samTaxempcode", samTaxempcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}

	public PagingResult<Map<String, Object>> findMedicalExamRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, MedicalExam c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		String tmpFileNo = "";
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			MedicalExam medicalExam = (MedicalExam) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(medicalExam);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("medicalExam", medicalExam);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeMedicalExamRecords(List ids) {
		removeRecords(ids, MedicalExam.class);
	}

	public PagingResult<Map<String, Object>> findHypVisitRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql;
		if(qryCond.getIsFirst() == 0){
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, HypertensionVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" and CONVERT(varchar(10),c.nextVistDate,112) = CONVERT(varchar(10),getDate(),112) order by a.fileNo");
		}else{
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, HypertensionVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		}
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			HypertensionVisit hypVisit = (HypertensionVisit) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(hypVisit);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("hyp", hypVisit);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeHypVisitRecords(List ids) {
		removeRecords(ids, HypertensionVisit.class);
	}

	public PagingResult<Map<String, Object>> findDiabVisitRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql;
		if(qryCond.getIsFirst() == 0){
			hql = new StringBuilder(
					"from HealthFile a, PersonalInfo b, DiabetesVisit c, SamTaxempcode d,SamTaxorgcode e")
					.append(where).append(" and CONVERT(varchar(10),c.nextVistDate,112) = CONVERT(varchar(10),getDate(),112) order by a.fileNo");
		}else{
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, DiabetesVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		}
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			DiabetesVisit DiabVisit = (DiabetesVisit) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(DiabVisit);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("diab", DiabVisit);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeDiabVisitRecords(List ids) {
		removeRecords(ids, DiabetesVisit.class);
	}

	public PagingResult<Map<String, Object>> findFuriousVisitRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql;
		if(qryCond.getIsFirst() == 0){
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, FuriousVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" and CONVERT(varchar(10),c.nextVistDate,112) = CONVERT(varchar(10),getDate(),112) order by a.fileNo");
		}else{
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, FuriousVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		}
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			FuriousVisit furiousVisit = (FuriousVisit) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(furiousVisit);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("furiousVisit", furiousVisit);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeFuriousVisitRecords(List ids) {
		removeRecords(ids, FuriousVisit.class);
	}

	public PagingResult<Map<String, Object>> findFuriousInfoRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, FuriousInfo c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			FuriousInfo furiousInfo = (FuriousInfo) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(furiousInfo);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("furiousInfo", furiousInfo);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeFuriousInfoRecords(List ids) {
		removeRecords(ids, FuriousInfo.class);
	}

	public PagingResult<Map<String, Object>> findFirstVisitRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);
		
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, FirstVistBeforeBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			FirstVistBeforeBorn firstVist = (FirstVistBeforeBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];	
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(firstVist);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("firstVisit", firstVist);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeFirstVisitRecords(List ids) {
		removeRecords(ids, FirstVistBeforeBorn.class);
	}

	public PagingResult<Map<String, Object>> findVisitBeforeBornRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VisitBeforeBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			VisitBeforeBorn visitBeforeBorn = (VisitBeforeBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(visitBeforeBorn);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("visit", visitBeforeBorn);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeVisitBeforeBornRecords(List ids) {
		removeRecords(ids, VisitBeforeBorn.class);
	}

	public PagingResult<Map<String, Object>> findVisitAfterBornRecords(
			HealthFileQry qryCond, PagingParam pp) {
		return findVisitAfterBornRecords(qryCond, pp, VISIT_AFTER_DEFAULT);
	}

	public PagingResult<Map<String, Object>> findVisitAfterBorn42Records(
			HealthFileQry qryCond, PagingParam pp) {
		return findVisitAfterBornRecords(qryCond, pp, VISIT_AFTER_42);
	}

	private PagingResult<Map<String, Object>> findVisitAfterBornRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and c.recordType = ?");
		params.add(type);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql ;
		if(qryCond.getIsFirst() == 0){
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VisitAfterBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" and CONVERT(varchar(10),c.nextVisitDate,112) = CONVERT(varchar(10),getDate(),112) order by a.fileNo");
		}else{
			hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VisitAfterBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		}
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			VisitAfterBorn visitAfterBorn = (VisitAfterBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(visitAfterBorn);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("visit", visitAfterBorn);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeVisitAfterBornRecords(List ids) {
		removeRecords(ids, VisitAfterBorn.class);
	}

	public PagingResult<Map<String, Object>> findReceptionRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and c.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, Reception c, SamTaxempcode d, SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			Reception reception = (Reception) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(reception);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("reception", reception);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeReceptionRecords(List ids) {
		removeRecords(ids, Reception.class);
	}

	public PagingResult<Map<String, Object>> findConsultationRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, Consultation c,SamTaxempcode d,SamTaxorgcode e").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
				tmpFileNo = file.getFileNo();
			}
			Consultation consultation = (Consultation) objs[2];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(consultation);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("consultation", consultation);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeConsultationRecords(List ids) {
		removeRecords(ids, Consultation.class);
	}

	public PagingResult<Map<String, Object>> findCureswitchRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and c.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, CureSwitch c, SamTaxempcode d, SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			CureSwitch cureSwitch = (CureSwitch) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(cureSwitch);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("cureswitch", cureSwitch);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeCureswitchRecords(List ids) {
		removeRecords(ids, CureSwitch.class);
	}

	public PagingResult<Map<String, Object>> findCurebackRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, CureBack c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			CureBack cureBack = (CureBack) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(cureBack);
			getHibernateTemplate().evict(samTaxempcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("cureback", cureBack);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeCurebackRecords(List ids) {
		removeRecords(ids, CureBack.class);
	}

	public PagingResult<Map<String, Object>> findHealtheducatRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and c.orgId = e.id");

		where.replace(0, 4, " where ");
		// if ( params.size() != 0 ) {
		// where.replace(0, 4, " where ");
		// }
		StringBuilder hql = new StringBuilder(
				"from HealthEducat c, SamTaxempcode d, SamTaxorgcode e")
				.append(where).append(" order by c.inputDate desc");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthEducat healthEducat = (HealthEducat) objs[0];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[1];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[2];
			getHibernateTemplate().evict(healthEducat);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("healthEducat", healthEducat);
			map.put("samTaxempcode", samTaxempcode);
			map.put("samTaxorgcode", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeHealtheducatRecords(List ids) {
		removeRecords(ids, HealthEducat.class);
	}

	public PagingResult<Map<String, Object>> findVaccineInfoRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VaccineInfo c").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			VaccineInfo vaccineInfo = (VaccineInfo) objs[2];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(vaccineInfo);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("vaccineInfo", vaccineInfo);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeVaccineInfoRecords(List ids) {
		removeRecords(ids, VaccineInfo.class);
	}

	public PagingResult<Map<String, Object>> findVaccinationRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, Vaccination c,SamTaxempcode d,SamTaxorgcode e").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				person.setIdnumber(EncryptionUtils.decipher(person.getFileNo()));
				tmpFileNo = file.getFileNo();
			}
			Vaccination vaccination = (Vaccination) objs[2];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(vaccination);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("vaccination", vaccination);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeVaccinationRecords(List ids) {
		removeRecords(ids, Vaccination.class);
	}

	public PagingResult<Map<String, Object>> findInfectionReportRecords(
			HealthFileQry qryCond, PagingParam pp, String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and c.orgId = e.id");

		where.replace(0, 4, " where ");

		StringBuilder hql = new StringBuilder(
				"from InfectionReport c, SamTaxempcode d, SamTaxorgcode e")
				.append(where).append(" order by c.name");
		log.debug("hql: " + hql.toString());

		PagingResult<InfectionReport> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			InfectionReport infectionReport = (InfectionReport) objs[0];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[1];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[2];
			getHibernateTemplate().evict(infectionReport);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);

			Map map = new HashMap();
			map.put("infectionReport", infectionReport);
			map.put("samTaxempcode", samTaxempcode);
			map.put("samTaxorgcode", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}

	public void removeInfectionReportRecords(List ids) {
		removeRecords(ids, InfectionReport.class);
	}

	public PagingResult<Stat> findStats(HealthFileQry qryCond, PagingParam pp,
			String type) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from Stat c").append(where)
				.append(" order by c.reportMonth desc");
		log.debug("hql: " + hql.toString());

		PagingResult<Stat> p = query(hql, params, pp);

		return p;

	}

	public void removeStats(List ids) {
		removeRecords(ids, Stat.class);
	}

	/**
	 * 按条件获得户
	 * 
	 * @param qryCond
	 * @param pp
	 */
	public PagingResult<HomeInfo> getHomeResidents(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildWhereByHome(qryCond, params, where);
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from HomeInfo a").append(where)
				.append(" order by a.homeId");
		log.debug("hql: " + hql.toString());
		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<HomeInfo> homes = new ArrayList<HomeInfo>();
		for (Object object : list) {
			HomeInfo home = (HomeInfo) object;
			getHibernateTemplate().evict(home);
			homes.add(home);
		}
		PagingResult<HomeInfo> result = new PagingResult<HomeInfo>(
				p.getTotalSize(), homes);

		return result;
	}

	/**
	 * 按条件查询结核病人信息
	 * 
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Tuberculosis> getTuberSupervise(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildWhereByHome(qryCond, params, where);
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from Tuberculosis a").append(
				where).append(" order by a.id");
		log.debug("hql: " + hql.toString());
		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Tuberculosis> tubers = new ArrayList<Tuberculosis>();
		for (Object object : list) {
			Tuberculosis tuber = (Tuberculosis) object;
			getHibernateTemplate().evict(tuber);
			tubers.add(tuber);
		}
		PagingResult<Tuberculosis> result = new PagingResult<Tuberculosis>(
				p.getTotalSize(), tubers);

		return result;
	}

	/***
	 * 构建户的查询条件
	 * 
	 * @param qryCond
	 * @param params
	 * @param where
	 */
	private void buildWhereByHome(HealthFileQry qryCond, List params,
			StringBuilder where) {
		String districtId = qryCond.getDistrict();
		if (StringUtils.hasText(districtId)) {
			params.add(districtId + '%');
			where.append(" and a.districtNumber like ?");
		}
		String filterKey = qryCond.getFilterKey();
		if (StringUtils.hasText(filterKey)) {
			String filterValue = qryCond.getFilterValue();
			if (StringUtils.hasText(filterValue)) {
				params.add('%' + filterValue + '%');
				where.append(" and " + filterKey + " like ?");
			}
		}
	}

	/**
	 * 要删除的户籍信息列表
	 * 
	 * @param homeIdList
	 */
	public void removeHomeInfos(List<String> homeIdList) {
		for (String homeId : homeIdList) {
			removeHomeInfo(homeId);
		}
		return;
	}

	/**
	 * 删除单个户籍信息
	 * 
	 * @param homeId
	 */
	public void removeHomeInfo(String homeId) {

		HomeInfo home = (HomeInfo) getHibernateTemplate().get(HomeInfo.class,
				homeId);
		if (home != null) {
			List personList = getHibernateTemplate().find(
					"from PersonalInfo where homeId = ?", homeId);
			if (personList.size() > 0)
				return;

			getHibernateTemplate().delete(home);
		}
		return;
	}

	/**
	 * 要删除的结核病人列表
	 * 
	 * @param homeIdList
	 */
	public String removeTubers(List<String> idList) {
		String result = "";
		for (String id : idList) {
			result = result + removeTuber(id);
		}
		if (!result.equals("") && result != null)
			result = result.substring(0, result.length() - 1);
		return result;
	}

	/**
	 * 删除单个结核病人信息
	 * 
	 * @param homeId
	 */
	public String removeTuber(String id) {

		Tuberculosis tuber = (Tuberculosis) getHibernateTemplate().get(
				Tuberculosis.class, id);
		if (tuber != null) {
			List tuberDetailList = getHibernateTemplate().find(
					"from TuberSuperDetail where baseId = ?", id);
			if (tuberDetailList.size() > 0)
				return id + "、";

			getHibernateTemplate().delete(tuber);
		}
		return "";
	}

	/**
	 * 建立一户式查询的条件
	 * 
	 * @param qryCond
	 * @param params
	 * @param where
	 */
	private void buildQueryHomeWhere(HealthFileQry qryCond, List params,
			StringBuilder where) {
		String districtId = qryCond.getDistrict();
		// if (StringUtils.hasText(districtId)) {
		params.add(districtId);
		where.append(" and b.homeId = ?");
		// }

		where.append(" and a.fileNo = b.fileNo");
	}

	/**
	 * 建立一户式查询的SQL
	 * 
	 * @param qryCond
	 * @param params
	 * @return
	 */
	private StringBuilder buildQueryHomeHql(HealthFileQry qryCond, List params) {
		StringBuilder where = new StringBuilder();
		buildQueryHomeWhere(qryCond, params, where);

		// if (params.size() != 0) {
		where.replace(0, 4, " where ");
		// }
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b").append(where).append(
				" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}

	/**
	 * 一户式查询
	 * 
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<HealthFile> queryByHome(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildQueryHomeHql(qryCond, params);
		return queryHealthFiles(pp, params, hql);
	}

	/**
	 * 门诊日志查询
	 * 
	 * @param pp
	 * @param params
	 * @param hql
	 * @return
	 */
	private PagingResult<ClinicLogs> ExecSQLClinicLogs(PagingParam pp,
			List params, StringBuilder hql) {
		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<ClinicLogs> files = new ArrayList<ClinicLogs>();
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			ClinicLogs clinicLogs = (ClinicLogs) objs[0];
			SickInfo sickInfo = (SickInfo) objs[1];
			getHibernateTemplate().evict(sickInfo);
			getHibernateTemplate().evict(sickInfo);
			clinicLogs.setSickInfo(sickInfo);
			files.add(clinicLogs);
		}
		PagingResult<ClinicLogs> result = new PagingResult<ClinicLogs>(
				p.getTotalSize(), files);
		return result;
	}

	/**
	 * 门诊日志查询
	 * 
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<ClinicLogs> queryClinicLogs(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuffer where = new StringBuffer();
		String districtId = qryCond.getDistrict();
		if (StringUtils.hasText(districtId)) {
			params.add(EncryptionUtils.encry(districtId));
			where.append(" and substring(a.fileNo,1," + districtId.trim().length() + ") = ?");
		}
		String filterKey = qryCond.getFilterKey();
		if (StringUtils.hasText(filterKey)) {
			String filterValue = qryCond.getFilterValue();
			if (StringUtils.hasText(filterValue)) {
				params.add(filterValue);
				where.append(" and substring(" + filterKey + ",1," + filterValue.trim().length() + ") = ?");
			}
		}
		where.append(" and a.fileNo = b.fileNo");
		if (params.size() > 0) {
			where.replace(0, 4, "where");
		}
		StringBuilder hql = new StringBuilder("from ClinicLogs a,SickInfo b ")
				.append(where).append(" order by a.fileNo,a.inputTime DESC");
		return ExecSQLClinicLogs(pp, params, hql);
	}
	
	/**
	 * 老年人档案查询
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<HealthFile> findOldManHealthFiles(HealthFileQry qryCond,
			PagingParam pp) {
		List params = new ArrayList();
		StringBuilder hql = buildOldManHealthHql(qryCond, params);
		return queryHealthFiles(pp, params, hql);
	}
	
	/**
	 * 建立老年人档案查询的SQL语句
	 * @param qryCond
	 * @param params
	 * @param DiseaseType
	 * @return
	 */
	private StringBuilder buildOldManHealthHql(HealthFileQry qryCond,
			List params) {
		StringBuilder where = new StringBuilder();
		buildGeneralWhereHealthFile(qryCond, params, where);

		where.append(" and (year(getDate()) - year(b.birthday)) >= 65  ");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b ").append(
				where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());
		return hql;
	}
	/**
	 * 获得老年人的健康体检记录
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findOldManExamRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and c.age >= 65");
		
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, MedicalExam c, SamTaxempcode d")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			MedicalExam medicalExam = (MedicalExam) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(medicalExam);
			getHibernateTemplate().evict(samTaxempcode);

			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("medicalExam", medicalExam);
			map.put("samTaxempcode", samTaxempcode);
			files.add(map);
		}
		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	
	/**
	 * 获得3~6岁儿童的健康体检记录
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findChildExam36Records(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenMediExam36 c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenMediExam36 childrenMediExam36 = (ChildrenMediExam36) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childrenMediExam36);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", childrenMediExam36);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	
	/**
	 * 移除3~6岁儿童的健康体检记录
	 * @param recordIdList
	 */
	public void removeChildExam36Records(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildrenMediExam36.class);
	}
	
	
	/**
	 * 分娩记录
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findBirthChildRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildBirthRecord c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildBirthRecord childBirthRecord = (ChildBirthRecord) objs[2];
			ChildBirthRecordBO childBirthRecordBo = new ChildBirthRecordBO();
			BeanUtils.copyProperties(childBirthRecord, childBirthRecordBo);
			if(childBirthRecord.getChildbirthYear() != null && childBirthRecord.getChildbirthMonth() != null
					&& childBirthRecord.getChildbirthDay() != null)
				childBirthRecordBo.setBirthRecordDate(childBirthRecord.getChildbirthYear() + "年" +
					childBirthRecord.getChildbirthMonth() + "月" + childBirthRecord.getChildbirthDay() + "日");
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childBirthRecord);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("birthRecord", childBirthRecordBo);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	
	public void removeBirthChildRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildBirthRecord.class);
	}
	
	public PagingResult<HealthFile> findVaccineImmune(HealthFileQry qryCond, PagingParam pp){
		StringBuilder where = new StringBuilder();
		genVaccineImmuneWhere(qryCond,where);
		String hql = " From HealthFile a left join fetch a.personalInfo b left join fetch a.vaccineImmune c " +
				" Where Substring(a.districtNumber,1," + 
				qryCond.getDistrict().length() + ") = '" + qryCond.getDistrict() + "' " + where.toString();
		Query q = getSession().createQuery(" select count(*) From HealthFile a,PersonalInfo b " + 
				" Where Substring(a.districtNumber,1," + 
				qryCond.getDistrict().length() + ") = '" + qryCond.getDistrict() + "' And a.fileNo = b.fileNo " + where.toString());
		
		int totalSize = ((Long) q.uniqueResult()).intValue();
//		int totalSize = 100;
		
		Query query = getSession().createQuery(hql);
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		List<HealthFile> files = new ArrayList<HealthFile>();
		String tmpFileNo = "";
		if(list.size() > 0){
			for(Object obj : list){
				HealthFile file = (HealthFile) obj;
				PersonalInfo person = file.getPersonalInfo();
				if(!tmpFileNo.equals(file.getFileNo())){
					file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
					file.setName(EncryptionUtils.decipher(file.getName()));
					tmpFileNo = file.getFileNo();
					person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
				}
				getHibernateTemplate().evict(person);				
				file.setPersonalInfo(person);
				getHibernateTemplate().evict(file);
				files.add(file);
			}
		}
		PagingResult<HealthFile> result = new PagingResult<HealthFile>(
				totalSize, files);
		return result;
	}
	private void genVaccineImmuneWhere(HealthFileQry qryCond, StringBuilder where) {
		String filterKey = qryCond.getFilterKey();
		if (StringUtils.hasText(filterKey)) {
			String filterValue = qryCond.getFilterValue();
			if(filterKey.equals("a.name") || filterKey.equals("a.fileNo")){
				filterValue = EncryptionUtils.encry(filterValue);
			}
			if(filterKey.equals("a.inputDate") || filterKey.equals("b.birthday") || filterKey.equals("a.lastModifyDate")){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
				try {
					Date startDate = null;
					Date endDate = null;
					if(filterValue.indexOf("-") > 0){
						String[] valArray = filterValue.split("-");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else if(filterValue.indexOf("－") > 0){
						String[] valArray = filterValue.split("－");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else{
						startDate = format.parse(filterValue + " 00:00:00");
						endDate = format.parse(filterValue + " 23:59:59");
					}
					where.append(" and " + filterKey + " >= '" + startDate + "' and " + filterKey + " <= '" + endDate + "'");
				} catch (ParseException e) {
					throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
				}				
			}else{
				if (StringUtils.hasText(filterValue)) {
					where.append(" and substring(" + filterKey + ",1," + filterValue.length() + ") = '" + filterValue + "'");
				}
			}
		}
	}
	
	public PagingResult<Map<String, Object>> findHighRiskRecords(
			QryCondition qryCond, PagingParam pp) {
		String where = genQryCondition(qryCond);
		String hql = " From HealthFile a,PersonalInfo b,WomanLastMedicalExamRecord c " + where;
		
		Query query = getSession().createQuery(" Select Count(*)" + hql);
		query.setParameter(0, qryCond.getDistrict());
		int totalSize = ((Long)query.uniqueResult()).intValue();
		
		query =  getSession().createQuery(hql + " order by c.lastExamDate ASC");
		query.setParameter(0, qryCond.getDistrict());
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
			WomanLastMedicalExamRecord record = (WomanLastMedicalExamRecord) objs[2];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(record);
			Map map = new HashMap();
			map.put("file", file);
			map.put("personalInfo", person);
			map.put("record", record);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				totalSize, files);
		return result;
	}

	public PagingResult<Map<String, Object>> findChildHighRiskRecords(
			QryCondition qryCond, PagingParam pp) {
		String where = genQryCondition(qryCond);
		String hql = " From HealthFile a,PersonalInfo b,ChildLastMedicalExamRecord c " + where;
		
		Query query = getSession().createQuery(" Select Count(*)" + hql);
		query.setParameter(0, qryCond.getDistrict());
		int totalSize = ((Long)query.uniqueResult()).intValue();
		
		query =  getSession().createQuery(hql + " order by c.lastExamDate ASC");
		query.setParameter(0, qryCond.getDistrict());
		query.setFirstResult(pp.getStart()).setMaxResults(pp.getLimit());
		List list = query.list();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			person.setIdnumber(EncryptionUtils.decipher(person.getIdnumber()));
			ChildLastMedicalExamRecord record = (ChildLastMedicalExamRecord) objs[2];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(record);
			Map map = new HashMap();
			map.put("file", file);
			map.put("personalInfo", person);
			map.put("record", record);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				totalSize, files);
		return result;
	}
	
	public List getPrintHighRiskRecords(QryCondition qryCond){
		String where = genQryCondition(qryCond);
		String hql = " From HealthFile a,PersonalInfo b,WomanLastMedicalExamRecord c " + where;
		Query query =  getSession().createQuery(hql + " order by c.lastExamDate ASC");
		query.setParameter(0, qryCond.getDistrict());
		return query.list();
	}
	
	public List getChildPrintHighRiskRecords(QryCondition qryCond){
		String where = genQryCondition(qryCond);
		String hql = " From HealthFile a,PersonalInfo b,ChildLastMedicalExamRecord c " + where;
		Query query =  getSession().createQuery(hql + " order by c.lastExamDate ASC");
		query.setParameter(0, qryCond.getDistrict());
		return query.list();
	}
	
	private String genQryCondition(QryCondition qryCond) {
		String where = "";
		if(qryCond.getConditions() != null){
			for(Condition cond : qryCond.getConditions()){
				if(cond.getFilterVal() != null && !cond.getFilterVal().equals("")){
					String filterKey  = cond.getFilterKey();
					if(cond.getFilterKey().equals("a.name") || cond.getFilterKey().equals("a.fileNo") ||
							 cond.getFilterKey().equals("b.idnumber")){
						cond.setFilterVal(EncryptionUtils.encry(cond.getFilterVal()));
						filterKey = " SubString(" + cond.getFilterKey() + ",1," + cond.getFilterVal().trim().length() + ") "; 
					}else if(cond.getFilterKey().equals("b.birthday")){
						filterKey = " Convert(Varchar(20)," + cond.getFilterKey() + ",23) ";
					}else if(cond.getFilterKey().equals("startDate")){
						where = where + " And Convert(Varchar(30),c.lastExamDate,120) >= '" + cond.getFilterVal() + " 00:00:00' ";
						continue;
					}else if(cond.getFilterKey().equals("endDate")){
						where = where + " And Convert(Varchar(30),c.lastExamDate,120) <= '" + cond.getFilterVal() + " 23:59:59' ";
						continue;
					}
					where = where + " And " + filterKey + " = '" + cond.getFilterVal() + "' ";
				}
			}
		}
		
		if(qryCond.getManPerson().equals("10")){//10查询在管人员
			where = where + " And c.type = 1"; 
		}else if(qryCond.getManPerson().equals("01")){//01查询转归人员
			where = where + " And c.type = 0";
		}else{//11 || 00查询所有人员
			//不需要加条件
		}
		
		where = " Where " +
				" Substring(a.districtNumber,1," + qryCond.getDistrict().length() + ")=? And a.fileNo = b.fileNo " +
				" And a.fileNo = c.fileNo " + where;
		return where;
	}
	
	/**
	 * 新生儿死亡调查表
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findBabyDeathRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, BabyDeathSurvey c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			BabyDeathSurvey babydeath = (BabyDeathSurvey) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(babydeath);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", babydeath);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}
	public void removeBabyDeathRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, BabyDeathSurvey.class);
	}
	
	/**
	 * 28天至4岁儿童死亡调查表
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findChildDeath01Records(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenDeathSurvey01 c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenDeathSurvey01 childdeath = (ChildrenDeathSurvey01) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childdeath);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", childdeath);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}
	public void removeChildDeath01Records(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildrenDeathSurvey01.class);
	}
	
	/**
	 * 5岁以下儿童死亡调查表
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findChildDeath02Records(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenDeathSurvey02 c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenDeathSurvey02 childdeath = (ChildrenDeathSurvey02) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(childdeath);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("child", childdeath);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;

	}
	public void removeChildDeath02Records(final List<String> recordIdList) {
		removeRecords(recordIdList, ChildrenDeathSurvey02.class);
	}
	
	/**
	 * 听力筛查同意书
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findConsentBookRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, DiseaseAndHearScreenConsent c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			DiseaseAndHearScreenConsent consentBook = (DiseaseAndHearScreenConsent) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(consentBook);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("consentBook", consentBook);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	public void removeConsentBookRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, DiseaseAndHearScreenConsent.class);
	}
	/**
	 * 听力筛查同意书
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findExportCardRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, HearScreenReportCard c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			HearScreenReportCard exportCard = (HearScreenReportCard) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(exportCard);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("exportCard", exportCard);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	public void removeExportCardRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, HearScreenReportCard.class);
	}
	/**
	 * 听力障碍儿童个案登记表
	 * @param qryCond
	 * @param pp
	 * @return
	 */
	public PagingResult<Map<String, Object>> findBabyBarrierRegRecords(
			HealthFileQry qryCond, PagingParam pp) {
		List params = new ArrayList();

		StringBuilder where = new StringBuilder();
		buildGeneralWhere(qryCond, params, where);

		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, BabyBarrierReg c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		log.debug("hql: " + hql.toString());

		PagingResult<Object> p = query(hql, params, pp);
		List list = p.getData();
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>();
		String tmpFileNo = "";
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			if(!tmpFileNo.equals(file.getFileNo())){
				file.setFileNo(EncryptionUtils.decipher(file.getFileNo()));
				file.setName(EncryptionUtils.decipher(file.getName()));
				tmpFileNo = file.getFileNo();
			}
			PersonalInfo person = (PersonalInfo) objs[1];
			BabyBarrierReg babyBarrierReg = (BabyBarrierReg) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			getHibernateTemplate().evict(file);
			getHibernateTemplate().evict(person);
			getHibernateTemplate().evict(babyBarrierReg);
			getHibernateTemplate().evict(samTaxempcode);
			getHibernateTemplate().evict(samTaxorgcode);
			Map map = new HashMap();
			map.put("file", file);
			map.put("person", person);
			map.put("babyBarrierReg", babyBarrierReg);
			map.put("samTaxempcode", samTaxempcode);
			map.put("org", samTaxorgcode);
			files.add(map);
		}

		PagingResult<Map<String, Object>> result = new PagingResult<Map<String, Object>>(
				p.getTotalSize(), files);

		return result;
	}
	public void removeBabyBarrierRegRecords(final List<String> recordIdList) {
		removeRecords(recordIdList, BabyBarrierReg.class);
	}
}
