package cn.net.tongfang.web.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import cn.net.tongfang.framework.security.bo.QryCondition;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.BabyVisit;
import cn.net.tongfang.framework.security.vo.BirthCertificate;
import cn.net.tongfang.framework.security.vo.ChildLastMedicalExamRecord;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam;
import cn.net.tongfang.framework.security.vo.ChildrenMediExam36;
import cn.net.tongfang.framework.security.vo.FirstVistBeforeBorn;
import cn.net.tongfang.framework.security.vo.HealthFile;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.SamTaxempcode;
import cn.net.tongfang.framework.security.vo.SamTaxorgcode;
import cn.net.tongfang.framework.security.vo.VisitAfterBorn;
import cn.net.tongfang.framework.security.vo.VisitBeforeBorn;
import cn.net.tongfang.framework.security.vo.WomanLastMedicalExamRecord;
import cn.net.tongfang.framework.util.BusiUtils;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.ExcelUtils;
import cn.net.tongfang.framework.util.SystemInformationUtils;
import cn.net.tongfang.framework.util.service.ModuleMgr;
import cn.net.tongfang.web.service.bo.BirthCertifiQry;

/**
 * @author Jackstraw
 *
 */
public class DataExportService extends HibernateDaoSupport{
	//1岁以内、1~2岁、3~6岁儿童数据导出标题
	private static String[] headerChildren = {"执行机构","档案编号","姓名","性别","出生日期","项目","高危","随访日期","下次随访日期","随访医生","操作人员"};
	//儿童档案导出标题
	private static String[] headerChildrenFile = {"档案编号","姓名","性别","出生日期","身份证号","家庭住址","行政区划","联系人电话","联系人"};
	//孕产妇档案导出标题
	private static String[] headerWomanBirthFile = {"档案编号","姓名","性别","出生日期","身份证号","家庭住址","行政区划","联系人电话","联系人"};
	//高危孕产妇信息导出标题
	private static String[] headerHighRiskInfo = {"档案编号","姓名","性别","出生日期","身份证号","最近一次产检时间","高危因素","家庭住址","联系人","电话"};
	//高危儿童信息导出标题
	private static String[] headerChildHighRiskInfo = {"档案编号","姓名","性别","出生日期","身份证号","最近一次体检时间","高危因素","家庭住址","联系人","电话"};

	
	//第1次产前随访
	private static String[] headerFirstVistBeforeBorn = {"执行机构","档案编号","姓名","性别","出生日期","孕周","高危","随访日期","下次随访日期","随访医生","操作人员"};
	//第2至5次产前随访
	private static String[] headerVistBeforeBorn = {"执行机构","档案编号","姓名","性别","出生日期","孕周","项目","高危","随访日期","下次随访日期","随访医生","操作人员"};
	//产后访视
	private static String[] headerVistAfterBorn = {"执行机构","档案编号","姓名","性别","出生日期","高危","随访日期","下次随访日期","随访医生","操作人员"};
	//乡镇汇总统计
	private static String[] headerStatisticTownship = {"乡镇名称","农业人口建档数","城镇人口建档数","新生儿访视次数	",
									"0~6岁儿童建档数","0~6岁儿童随访次数","孕产妇建档数","孕产妇产前访视次数",
									"孕产妇产后访视次数","65岁以上老年人保健次数","高血压建档数	","高血压病随访次数",
									"糖尿病建档数","糖尿病随访次数","重性精神病建档数","重性精神病随访次数"};
	//高危汇总统计
	private static String[] headerStatisticHighRisk = {"乡镇名称","第1次产前随访","第2~5次产前随访","产后访视",
									"产后42天访视","新生儿家庭访视记录","1岁以内儿童健康体检","1~2岁儿童健康体检",
									"3~6岁儿童健康体检"};
	
	//月报表统计一
	private static String[] headerStatisticMonth01 = {"卫生院名称","常住人口数","户藉人口数","城镇居民人口数",
									"乡村居民人口数","孕产妇数","活产数","0-6岁儿童数","15岁以上人口数",
									"35岁以上人口数","65岁以上人口数","应管理高血压人数","应管理糖尿病人数",
									"应管理精神病人数"};
	
	public static final String VISIT_AFTER_DEFAULT = "0";
	public static final String VISIT_AFTER_42 = "1";
	
	private static final String BABYVISIT = "babyvisit";
	private static final String CHILDFILE = "childfile";
	private static final String CHILDREN01 = "children01";
	private static final String CHILDREN02 = "children02";
	private static final String CHILDREN36 = "children36";
	private static final String FIRSTVISIT = "firstvisit";
	private static final String VISITBEFOREBORN = "visitbeforeborn";
	private static final String VISITAFTERBORN = "visitafterborn";
	private static final String VISITAFTERBORN42 = "visitafterborn42";
	private static final String STATISTICTOWNSHIP = "statistictownship";
	private static final String STATISTICHIGHRISK = "statistichighrisk";
	private static final String STATISTICMONTH01 = "statisticmonth01";
	private static final String STATISTICMONTH02 = "statisticmonth02";
	private static final String HIGHRISKINFO = "highriskinfo";
	private static final String CHILDHIGHRISKINFO = "childhighriskinfo";
	private static final String STATISTICDAY = "statisticday";
	private static final String STATISTICREGISTERBABY = "statisticregisterbaby";
	private static final String WOMANBIRTHFILE = "womanbirthfile";
	
	private static final String BABYVISIT_TITLE = "新生儿家庭访视记录";
	private static final String CHILDFILE_TITLE = "儿童档案";
	private static final String CHILDREN01_TITLE = "1岁以内儿童体检记录";
	private static final String CHILDREN02_TITLE = "1~2岁儿童体检记录";
	private static final String CHILDREN36_TITLE = "3~6岁儿童体检记录";
	private static final String FIRSTVISIT_TITLE = "第1次产前随访记录";
	private static final String VISITBEFOREBORN_TITLE = "第2~5次产前随访记录";
	private static final String VISITAFTERBORN_TITLE = "产后访视记录";
	private static final String VISITAFTERBORN42_TITLE = "产后42天访视记录";
	private static final String STATISTICTOWNSHIP_TITLE = "乡镇汇总统计";
	private static final String STATISTICHOSPITAL_TITLE = "卫生院汇总统计";
	private static final String STATISTICHIGHRISK_TITLE = "高危汇总统计";
	private static final String STATISTICMONTH01_TITLE = "月报表统计（一）";
	private static final String STATISTICMONTH02_TITLE = "月报表统计（二）";
	private static final String STATISTICDAY_TITLE = "日报表统计";
	private static final String STATISTICREGISTERBABY_TITLE = "医疗保健机构出生登记月报表";
	private static final String HIGHRISKINFO_TITLE = "高危孕产妇信息";
	private static final String CHILDHIGHRISKINFO_TITLE = "高危儿童信息";
	private static final String WOMANBIRTHFILE_TITLE = "孕产妇档案";
	
	private ReportService reportService;	
	private SystemInformationUtils sysInfos;
	private SummaryService summaryService;
	private ModuleMgr userMenuTreeService;
	
	public void setSysInfos(SystemInformationUtils sysInfos) {
		this.sysInfos = sysInfos;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public void setUserMenuTreeService(ModuleMgr userMenuTreeService) {
		this.userMenuTreeService = userMenuTreeService;
	}

	/**
	 * 写Excel文件
	 * @param disNo
	 * @param list
	 * @return
	 */
	private String writeExecl(String disNo,List list,String type,String title){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String fileName = DateToStr(new Date()) + "_" + disNo + "_" +user.getUsername() + "_" + type + ".xls";
		File file = new File(getWebRootAbsolutePath() + "data/" + fileName);
		
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(file);
			WritableSheet sheet = wwb.createSheet("sheet1",1000000);
			Label labTitle = new Label(0, 0, title);
			sheet.addCell(labTitle);
			sheet.mergeCells(0, 0, ((List)list.get(0)).size() - 1, 0);
			int i = 1;
			for (Object object : list) {
				List l = (List)object;
				for(int j=0;j<l.size();j++){
					Label lab = new Label(j, i, isNull(String.valueOf(l.get(j))));
					sheet.addCell(lab);
				}				
				i++;
			}
			wwb.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally{
			 try {
				 wwb.close(); 
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}    
			 
		}
		return fileName;
	}
	
	public String dataExportChildFile(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where," and a.districtNumber like ? ");
		Timestamp childAge = BusiUtils.getChildAge();
		params.add(childAge);
		where.append(" and b.birthday >= ?");
		
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from HealthFile a, PersonalInfo b ").append(where).append(" order by a.fileNo");
		List list = query(hql,params);
		
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerChildrenFile.length;i++){
			headerList.add(headerChildrenFile[i]);
		}
		dataList.add(headerList);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			
			List contentList = new ArrayList();
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(EncryptionUtils.decipher(person.getIdnumber()));
			contentList.add(file.getAddress());
			contentList.add(file.getDistrictNumber());
			contentList.add(person.getLinkmanTel());
			contentList.add(person.getLinkman());
			dataList.add(contentList);
		}
		
		String fileName = writeExecl(disNo,dataList,CHILDFILE,CHILDFILE_TITLE);
		return getDownloadURL() + fileName;
	}
	
	public String dataExportWomanBirthFile(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where," and a.districtNumber like ? ");
		params.add("是");
		where.append(" and b.bornStatus >= ?");
		
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder("from HealthFile a, PersonalInfo b ").append(where).append(" order by a.fileNo");
		List list = query(hql,params);
		
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerWomanBirthFile.length;i++){
			headerList.add(headerWomanBirthFile[i]);
		}
		dataList.add(headerList);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			
			List contentList = new ArrayList();
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(EncryptionUtils.decipher(person.getIdnumber()));
			contentList.add(file.getAddress());
			contentList.add(file.getDistrictNumber());
			contentList.add(person.getLinkmanTel());
			contentList.add(person.getLinkman());
			dataList.add(contentList);
		}
		
		String fileName = writeExecl(disNo,dataList,WOMANBIRTHFILE,WOMANBIRTHFILE_TITLE);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 新生儿家庭访视记录
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportBabyVisit(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");

		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, BabyVisit c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerVistAfterBorn.length;i++){
			headerList.add(headerVistAfterBorn[i]);
		}
		dataList.add(headerList);
		List list = query(hql,params);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			BabyVisit babyVisit = (BabyVisit) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			
			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(babyVisit.getHighRisk());
			contentList.add(DateToStr(babyVisit.getVisitDate()));
			contentList.add(DateToStr(babyVisit.getNextVisitDate()));
			contentList.add(babyVisit.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		
		String fileName = writeExecl(disNo,dataList,BABYVISIT,BABYVISIT_TITLE);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 1岁以内、1~2岁儿童数据访问
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @param type
	 * @return
	 */
	private String dataExportChild(String disNo,String filterKey,String filterVal,Integer type,String status,String title){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		where.append(" and c.dataType = " + type);
		StringBuilder hql = new StringBuilder(
			"from HealthFile a, PersonalInfo b, ChildrenMediExam c, SamTaxempcode d,SamTaxorgcode e")
			.append(where).append(" order by a.fileNo");
		List list = query(hql,params);
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerChildren.length;i++){
			headerList.add(headerChildren[i]);
		}
		dataList.add(headerList);
		for(Object object : list){
			Object[] objs = (Object[]) object;
			HealthFile healthFile = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenMediExam childrenMediExam = (ChildrenMediExam) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];

			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(healthFile.getFileNo()));
			contentList.add(EncryptionUtils.decipher(healthFile.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(childrenMediExam.getCheckItem());
			contentList.add(childrenMediExam.getHighRisk());
			contentList.add(DateToStr(childrenMediExam.getVisitDate()));
			contentList.add(childrenMediExam.getNextVisitDate());
			contentList.add(childrenMediExam.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		
		String fileName = writeExecl(disNo,dataList,status,title);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 1岁以内儿童
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportChildExam(String disNo,String filterKey,String filterVal){
		return dataExportChild(disNo,filterKey,filterVal,0,CHILDREN01,CHILDREN01_TITLE);
	}
	
	/**
	 * 1~2岁儿童
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportChildExam2(String disNo,String filterKey,String filterVal){
		return dataExportChild(disNo,filterKey,filterVal,1,CHILDREN02,CHILDREN02_TITLE);
	}
	
	/**
	 * 3~6岁儿童数据导出
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportChildExam36(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, ChildrenMediExam36 c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");

		List list = query(hql,params);
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerChildren.length;i++){
			headerList.add(headerChildren[i]);
		}
		dataList.add(headerList);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildrenMediExam36 childrenMediExam36 = (ChildrenMediExam36) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(childrenMediExam36.getCheckItem());
			contentList.add(childrenMediExam36.getHighRisk());
			contentList.add(DateToStr(childrenMediExam36.getVisitDate()));
			contentList.add(DateToStr(childrenMediExam36.getNextVisitDate()));
			contentList.add(childrenMediExam36.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		String fileName = writeExecl(disNo,dataList,CHILDREN36,CHILDREN36_TITLE);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 第一次产前随访
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportFirstBabyVisit(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, FirstVistBeforeBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerFirstVistBeforeBorn.length;i++){
			headerList.add(headerFirstVistBeforeBorn[i]);
		}
		dataList.add(headerList);
		List list = query(hql,params);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			FirstVistBeforeBorn firstVist = (FirstVistBeforeBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];	

			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(firstVist.getWeeks());
			contentList.add(firstVist.getHighRisk());
			contentList.add(DateToStr(firstVist.getVisitDate()));
			contentList.add(DateToStr(firstVist.getNextVisitDate()));
			contentList.add(firstVist.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		String fileName = writeExecl(disNo,dataList,FIRSTVISIT,FIRSTVISIT_TITLE);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 第2至5次产前随访数据导出
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportVisitBeforeBorn(String disNo,String filterKey,String filterVal){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VisitBeforeBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerVistBeforeBorn.length;i++){
			headerList.add(headerVistBeforeBorn[i]);
		}
		dataList.add(headerList);
		List list = query(hql,params);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			VisitBeforeBorn visitBeforeBorn = (VisitBeforeBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(visitBeforeBorn.getWeeks());
			contentList.add("第" + visitBeforeBorn.getItem() + "次");
			contentList.add(visitBeforeBorn.getHighRisk());
			contentList.add(DateToStr(visitBeforeBorn.getVisitDate()));
			contentList.add(DateToStr(visitBeforeBorn.getNextVisitDate()));
			contentList.add(visitBeforeBorn.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		String fileName = writeExecl(disNo,dataList,VISITBEFOREBORN,VISITBEFOREBORN_TITLE);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 产后访视记录数据导出
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @param type
	 * @return
	 */
	private String dataExportVisitAfter(String disNo,String filterKey,String filterVal,String type,
			String status,String title){
		List params = new ArrayList();
		StringBuilder where = new StringBuilder();
		buildExportDataGeneralWhere(disNo,filterKey,filterVal,params,where,null);
		
		where.append(" and c.recordType = ?");
		params.add(type);
		where.append(" and a.fileNo = c.fileNo");
		where.append(" and c.inputPersonId = d.loginname");
		where.append(" and d.orgId = e.id");
		if (params.size() != 0) {
			where.replace(0, 4, " where ");
		}
		StringBuilder hql = new StringBuilder(
				"from HealthFile a, PersonalInfo b, VisitAfterBorn c, SamTaxempcode d,SamTaxorgcode e")
				.append(where).append(" order by a.fileNo");
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerVistAfterBorn.length;i++){
			headerList.add(headerVistAfterBorn[i]);
		}
		dataList.add(headerList);
		List list = query(hql,params);
		for (Object object : list) {
			Object[] objs = (Object[]) object;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			VisitAfterBorn visitAfterBorn = (VisitAfterBorn) objs[2];
			SamTaxempcode samTaxempcode = (SamTaxempcode) objs[3];
			SamTaxorgcode samTaxorgcode = (SamTaxorgcode) objs[4];
			List contentList = new ArrayList();
			contentList.add(samTaxorgcode.getName());
			contentList.add(EncryptionUtils.decipher(file.getFileNo()));
			contentList.add(EncryptionUtils.decipher(file.getName()));
			contentList.add(person.getSex());
			contentList.add(DateToStr(person.getBirthday()));
			contentList.add(visitAfterBorn.getHighRisk());
			contentList.add(DateToStr(visitAfterBorn.getVisitDate()));
			contentList.add(visitAfterBorn.getNextVisitDate());
			contentList.add(visitAfterBorn.getVisitDoctor());
			contentList.add(samTaxempcode.getUsername());
			dataList.add(contentList);
		}
		String fileName = writeExecl(disNo,dataList,status,title);
		return getDownloadURL() + fileName;
	}
	
	/**
	 * 产后访视记录
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportVisitAfterBorn(String disNo,String filterKey,String filterVal){
		return dataExportVisitAfter(disNo,filterKey,filterVal,VISIT_AFTER_DEFAULT,VISITAFTERBORN,VISITAFTERBORN_TITLE);
	}
	
	/**
	 * 产后42天
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @return
	 */
	public String dataExportVisitAfterBorn42(String disNo,String filterKey,String filterVal){
		return dataExportVisitAfter(disNo,filterKey,filterVal,VISIT_AFTER_42,VISITAFTERBORN42,VISITAFTERBORN42_TITLE);
	}
	
	/**
	 * 删除文件
	 * @param fileName
	 */
	public void removeDataExportFile(String fileName){
		File file = new File(getWebRootAbsolutePath() + "data/" + fileName);
		file.delete();
	}
	
	/**
	 * 获得Webroot的路径
	 * @return
	 */
	private  String getWebRootAbsolutePath() {  
        String path = null;  
        String folderPath = ModuleMgr.class.getProtectionDomain().getCodeSource()  
                .getLocation().getPath();  
        if (folderPath.indexOf("WEB-INF") > 0) {  
            path = folderPath.substring(0, folderPath  
                    .indexOf("WEB-INF/classes"));  
        }  
        return path;  
    }  
	
	/**
	 * 日期转换成字符串
	 * @param date
	 * @return
	 */
	private String DateToStr(Date date){
		if(date != null){
			SimpleDateFormat fomart = new SimpleDateFormat("yyyy-MM-dd");
			return fomart.format(date);
		}
		return "";
	}
	
	/**
	 * 构建查询条件
	 * @param disNo
	 * @param filterKey
	 * @param filterVal
	 * @param params
	 * @param where
	 */
	private void buildExportDataGeneralWhere(String disNo,String filterKey,String filterVal, List params,
			StringBuilder where,String appendVal) {
		if(appendVal == null){
			params.add(disNo + '%');
			appendVal = " and (a.districtNumber like ? or c.execDistrictNum like ?) ";
		}
		if (StringUtils.hasText(disNo)) {
			params.add(disNo + '%');
			where.append(appendVal);
		}
		if (StringUtils.hasText(filterKey)) {
			
			if(filterKey.equals("a.name") || filterKey.equals("a.fileNo")){
				filterVal = EncryptionUtils.encry(filterVal);
			}else if(filterKey.equals("a.inputDate") || filterKey.equals("b.birthday") || filterKey.equals("a.lastModifyDate") ){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
				try {
					Date startDate = null;
					Date endDate = null;
					if(filterVal.indexOf("-") > 0){
						String[] valArray = filterVal.split("-");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else if(filterVal.indexOf("－") > 0){
						String[] valArray = filterVal.split("－");
						if(valArray.length > 2){
							throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
						}
						startDate = format.parse(valArray[0] + " 00:00:00");
						endDate = format.parse(valArray[1] + " 23:59:59");
					}else{
						startDate = format.parse(filterVal + " 00:00:00");
						endDate = format.parse(filterVal + " 23:59:59");
					}
					params.add(startDate);
					params.add(endDate);
					where.append(" and " + filterKey + " between ? and  ? ");
				} catch (ParseException e) {
					throw new RuntimeException("请输入正确的日期范围，如：20120101-20120102或者20120101。");
				}
			}else if(filterKey.equals("c.highRisk")){
				if (StringUtils.hasText(filterVal)) {
					params.add(filterVal);
					where.append(" and " + filterKey + " = ?");
				}
			}else{
				if (StringUtils.hasText(filterVal)) {
					params.add('%' + filterVal + '%');
					where.append(" and " + filterVal + " like ?");
				}
			}
		}

		where.append(" and a.fileNo = b.fileNo and a.status = 0 ");
	}
	
	/**
	 * 执行HQL
	 * @param hql
	 * @param params
	 * @return
	 */
	private List query(StringBuilder hql, List params) {
		Query query = getSession().createQuery(hql.toString());
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}
	
	/**
	 * 乡镇汇总统计数据导出
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public String dataExportByTownship(String startDay, String endDay){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerStatisticTownship.length;i++){
			headerList.add(headerStatisticTownship[i]);
		}
		dataList.add(headerList);
		
		List list = reportService.getDataInfoByTownship(startDay, endDay);
		for(Object obj : list){
			List l = (List)obj;
			dataList.add(l);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,STATISTICTOWNSHIP,STATISTICHOSPITAL_TITLE);
	}
	
	/**
	 * 卫生院汇总统计数据导出
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public String dataExportByHospital(String startDay, String endDay){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerStatisticTownship.length;i++){
			headerList.add(headerStatisticTownship[i]);
		}
		dataList.add(headerList);
		
		List list = reportService.getDataInfoByHospital(startDay, endDay);
		for(Object obj : list){
			List l = (List)obj;
			dataList.add(l);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,STATISTICTOWNSHIP,STATISTICTOWNSHIP_TITLE);
	}
	
	/**
	 * 高危汇总统计
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public String dataExportByHighRisk(String startDay, String endDay){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerStatisticHighRisk.length;i++){
			headerList.add(headerStatisticHighRisk[i]);
		}
		dataList.add(headerList);
		
		List list = reportService.getHighRiskData(startDay, endDay);
		for(Object obj : list){
			List l = (List)obj;
			List tmp = new ArrayList();
			for(int i = 1;i<l.size();i++){
				tmp.add(l.get(i));
			}
			dataList.add(tmp);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,STATISTICHIGHRISK,STATISTICHIGHRISK_TITLE);
	}
	
	
	/**
	 * @param qryCond
	 * @return
	 */
	public String dataExportByHighRisk(QryCondition qryCond){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerHighRiskInfo.length;i++){
			headerList.add(headerHighRiskInfo[i]);
		}
		dataList.add(headerList);
		
		List list = userMenuTreeService.getPrintHighRiskRecords(qryCond);
		
		for(Object obj : list){
			List tmp = new ArrayList();
			Object[] objs = (Object[]) obj;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			WomanLastMedicalExamRecord record = (WomanLastMedicalExamRecord) objs[2];
			tmp.add(EncryptionUtils.decipher(file.getFileNo()));
			tmp.add(EncryptionUtils.decipher(file.getName()));
			tmp.add(person.getSex());
			tmp.add(CommonConvertUtils.dateToStringWithDelimiter(person.getBirthday()));
			tmp.add(EncryptionUtils.decipher(person.getIdnumber()));
			tmp.add(CommonConvertUtils.dateToStringWithDelimiter(record.getLastExamDate()));
			tmp.add(record.getHighRiskRemarks());
			tmp.add(file.getAddress());
			tmp.add(person.getLinkman());
			tmp.add(file.getTel());
			dataList.add(tmp);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String url = getDownloadURL() + writeExecl(user.getDistrictId(),dataList,HIGHRISKINFO,HIGHRISKINFO_TITLE);
		return url;
	}
	
	public String dataExportByChildHighRisk(QryCondition qryCond){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerChildHighRiskInfo.length;i++){
			headerList.add(headerChildHighRiskInfo[i]);
		}
		dataList.add(headerList);
		
		List list = userMenuTreeService.getChildPrintHighRiskRecords(qryCond);
		
		for(Object obj : list){
			List tmp = new ArrayList();
			Object[] objs = (Object[]) obj;
			HealthFile file = (HealthFile) objs[0];
			PersonalInfo person = (PersonalInfo) objs[1];
			ChildLastMedicalExamRecord record = (ChildLastMedicalExamRecord) objs[2];
			tmp.add(EncryptionUtils.decipher(file.getFileNo()));
			tmp.add(EncryptionUtils.decipher(file.getName()));
			tmp.add(person.getSex());
			tmp.add(CommonConvertUtils.dateToStringWithDelimiter(person.getBirthday()));
			tmp.add(EncryptionUtils.decipher(person.getIdnumber()));
			tmp.add(CommonConvertUtils.dateToStringWithDelimiter(record.getLastExamDate()));
			tmp.add(record.getHighRiskRemarks());
			tmp.add(file.getAddress());
			tmp.add(person.getLinkman());
			tmp.add(file.getTel());
			dataList.add(tmp);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String url = getDownloadURL() + writeExecl(user.getDistrictId(),dataList,CHILDHIGHRISKINFO,CHILDHIGHRISKINFO_TITLE);
		return url;
	}
	
	/**
	 * 月报表统计一
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public String dataExportByMonth01(String startDay, String endDay){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		for(int i = 0;i<headerStatisticMonth01.length;i++){
			headerList.add(headerStatisticMonth01[i]);
		}
		dataList.add(headerList);
		
		List list = reportService.getDataInfoByMonth01(startDay, endDay);
		for(Object obj : list){
			List l = (List)obj;
			dataList.add(l);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,STATISTICMONTH01,STATISTICMONTH01_TITLE);
	}
	
	public String dataExportByMonth02(String startDay, String endDay){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		ExcelUtils col01 = new ExcelUtils(2,1,"卫生院名称",new String[]{});
		ExcelUtils col02 = new ExcelUtils(1,3,"城镇居民规范化电子建档",new String[]{"人数","%"});
		ExcelUtils col03 = new ExcelUtils(1,5,"农村居民规范化电子建档",new String[]{"人数","%"});
		ExcelUtils col04 = new ExcelUtils(1,7,"0-6岁儿童管理",new String[]{"人数","%"});
		ExcelUtils col05 = new ExcelUtils(1,9,"孕产妇系统管理",new String[]{"人数","%"});
		ExcelUtils col06 = new ExcelUtils(1,11,"老年人管理",new String[]{"人数","%"});
		ExcelUtils col07 = new ExcelUtils(1,13,"高血压管理",new String[]{"人数","%"});
		ExcelUtils col08 = new ExcelUtils(1,15,"糖尿病管理",new String[]{"人数","%"});
		ExcelUtils col09 = new ExcelUtils(1,17,"精神病管理",new String[]{"人数","%"});
		headerList.add(col01);
		headerList.add(col02);
		headerList.add(col03);
		headerList.add(col04);
		headerList.add(col05);
		headerList.add(col06);
		headerList.add(col07);
		headerList.add(col08);
		headerList.add(col09);
		
		List list = reportService.getDataInfoByMonth02(startDay, endDay);
		for(Object obj : list){
			List l = (List)obj;
			dataList.add(l);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,headerList,STATISTICMONTH02,STATISTICMONTH02_TITLE);
	}
	
	/**
	 * 日统计报表数据导出
	 * @param day
	 * @return
	 */
	public String dataExportByDay(String day){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		ExcelUtils col01 = new ExcelUtils(2,1,"卫生院名称",new String[]{});
		ExcelUtils col02 = new ExcelUtils(1,5,"居民健康档案合计",new String[]{
				"常驻人口(人)","累计建档(人)","建档率%","其中电子建档率%"
		});
		ExcelUtils col03 = new ExcelUtils(1,11,"居民健康档案合计",new String[]{
				"城镇居民(人)","累计建档（人）","建档率%","其中电子建档率%","当日建档（人）","当日电子建档（人）"
		});
		ExcelUtils col04 = new ExcelUtils(1,17,"乡村居民建档情况",new String[]{
				"农村居民(人)","累计建档（人）","建档率%","其中电子建档率%","当日建档（人）","当日电子建档（人）"
		});
		headerList.add(col01);
		headerList.add(col02);
		headerList.add(col03);
		headerList.add(col04);
		List list = reportService.getDataInfoByDay(day);
		for(Object obj : list){
			List l = (List)obj;
			dataList.add(l);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,headerList,STATISTICDAY,STATISTICDAY_TITLE);
	}
	
	/**
	 * 写Excel重构
	 * @param disNo
	 * @param list
	 * @param headerList
	 * @param type
	 * @param title
	 * @return
	 */
	private String writeExecl(String disNo,List list,List<ExcelUtils> headerList,String type,String title){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String fileName = DateToStr(new Date()) + "_" + disNo + "_" +user.getUsername() + "_" + type + ".xls";
		File file = new File(getWebRootAbsolutePath() + "data/" + fileName);
		
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(file);
			WritableSheet sheet = wwb.createSheet("sheet1",1000000);
			Label labTitle = new Label(0, 0, title);
			sheet.addCell(labTitle);
			sheet.mergeCells(0, 0, ((List)list.get(0)).size() - 1, 0);
			
			int c = 0;
			int cSub = 0;
			for(ExcelUtils excel : headerList){
				Label labHeader = new Label(cSub,1 , excel.getTitle());
				sheet.addCell(labHeader);
				int col = excel.getCol() - 1;
				int row = excel.getRow();
				sheet.mergeCells(cSub, 1, col , row);
				String[] titleSub = excel.getTitleSub();
				int len = titleSub.length;
				if(len > 0){
					for(int i = 0;i<len;i++){
						Label labHeaderSub = new Label(cSub, 2, titleSub[i]);
						sheet.addCell(labHeaderSub);
						cSub++;
					}
				}else{
					cSub++;
				}
				c++;
			}
			
			int i = 3;
			for (Object object : list) {
				List l = (List)object;
				for(int j=0;j<l.size();j++){
					Label lab = new Label(j, i, isNull(String.valueOf(l.get(j))));
					sheet.addCell(lab);
				}				
				i++;
			}
			wwb.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally{
			 try {
				 wwb.close(); 
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}    
			 
		}
		return fileName;
	}
	
	/**
	 * 判断是否为NULL
	 * @param val
	 * @return
	 */
	private String isNull(String val){
		if(val == null || val.equals("null") || val.equals("0"))
			return "";
		return val;
	}
	
	
	/**
	 * 出生登记月报表（新）
	 * @param qry
	 * @return
	 */
	public String dataExportAllRegisterBaby(BirthCertifiQry qry){
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		List list = summaryService.printAllBirth(qry);
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String orgName = user.getOrg().getName();
		String username = user.getTaxempname();
		ExcelUtils col01 = new ExcelUtils(1,1,"卫生院名称",new String[]{"出生医学证明编号"});
		ExcelUtils col02 = new ExcelUtils(1,4,orgName + "（公章）",new String[]{
				"新生儿姓名","性别","出生日期"
		});
		ExcelUtils col03 = new ExcelUtils(1,5,"填表人",new String[]{"孕周"});
		ExcelUtils col04 = new ExcelUtils(1,8,username,new String[]{
				"新生儿出生状况","母亲姓名","母亲身份证号码"
		});
		ExcelUtils col05 = new ExcelUtils(1,9,"填表日期",new String[]{"父亲姓名"});
		ExcelUtils col06 = new ExcelUtils(1,11,getCurrentDay(),new String[]{
				"父亲身份证号码","家庭住址"
		});
		headerList.add(col01);
		headerList.add(col02);
		headerList.add(col03);
		headerList.add(col04);
		headerList.add(col05);
		headerList.add(col06);
		for(Object obj : list){
			BirthCertificate birthCertifi = (BirthCertificate)obj;
			List tmp = new ArrayList();
			tmp.add(birthCertifi.getCertifiId());
			tmp.add(birthCertifi.getName());
			tmp.add(birthCertifi.getSex());
			tmp.add(DateToStr(birthCertifi.getBirthday()));
			tmp.add(birthCertifi.getBorthWeekly());
			tmp.add(birthCertifi.getHealthStatus());
			tmp.add(birthCertifi.getMotherName());
			tmp.add(birthCertifi.getMotherIdCard());
			tmp.add(birthCertifi.getFatherName());
			tmp.add(birthCertifi.getFatherIdCard());
			tmp.add(birthCertifi.getFamilyAddress());
			dataList.add(tmp);
		}
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,headerList,STATISTICREGISTERBABY,STATISTICREGISTERBABY_TITLE);
	}
	
	
	/**
	 * 出生登记月报表
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public String dataExportRegisterBaby(String startDay,String endDay,String orgname,String orgid){
		
		List dataList = new ArrayList();
		List headerList = new ArrayList();
		List list = reportService.getDataInfoByRegister(startDay, endDay,orgname,orgid);
		String orgName = (String)list.get(0);
		String username = (String)list.get(1);
		ExcelUtils col01 = new ExcelUtils(1,1,"卫生院名称",new String[]{"出生医学证明编号"});
		ExcelUtils col02 = new ExcelUtils(1,4,orgName + "（公章）",new String[]{
				"新生儿姓名","性别","出生日期"
		});
		ExcelUtils col03 = new ExcelUtils(1,5,"填表人",new String[]{"孕周"});
		ExcelUtils col04 = new ExcelUtils(1,8,username,new String[]{
				"新生儿出生状况","母亲姓名","母亲身份证号码"
		});
		ExcelUtils col05 = new ExcelUtils(1,9,"填表日期",new String[]{"父亲姓名"});
		ExcelUtils col06 = new ExcelUtils(1,11,getCurrentDay(),new String[]{
				"父亲身份证号码","家庭住址"
		});
		headerList.add(col01);
		headerList.add(col02);
		headerList.add(col03);
		headerList.add(col04);
		headerList.add(col05);
		headerList.add(col06);
		List ldata = (List)list.get(2);
		for(Object obj : ldata){
			BirthCertificate birthCertifi = (BirthCertificate)obj;
			List tmp = new ArrayList();
			tmp.add(birthCertifi.getCertifiId());
			tmp.add(birthCertifi.getName());
			tmp.add(birthCertifi.getSex());
			tmp.add(DateToStr(birthCertifi.getBirthday()));
			tmp.add(birthCertifi.getBorthWeekly());
			tmp.add(birthCertifi.getHealthStatus());
			tmp.add(birthCertifi.getMotherName());
			tmp.add(birthCertifi.getMotherIdCard());
			tmp.add(birthCertifi.getFatherName());
			tmp.add(birthCertifi.getFatherIdCard());
			tmp.add(birthCertifi.getFamilyAddress());
			dataList.add(tmp);
		}
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		return getDownloadURL() + writeExecl(user.getDistrictId(),dataList,headerList,STATISTICREGISTERBABY,STATISTICREGISTERBABY_TITLE);
	}
	
	/**
	 * 获得文件下载地址
	 * @return
	 */
	private String getDownloadURL(){
		String ret = sysInfos.getVal(2);
		if(!ret.substring(ret.length() - 1, ret.length()).equals("/")){
			ret += "/";
		}
		return ret;
	}
	
	/**
	 * 获得当前日期并格式化
	 * @return
	 */
	private String getCurrentDay(){
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		return format.format(now);
	}
	
	
	
}
