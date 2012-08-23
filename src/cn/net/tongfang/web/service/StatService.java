package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import cn.net.tongfang.framework.util.BusiUtils;
import cn.net.tongfang.framework.util.service.ModuleMgr;
import cn.net.tongfang.web.service.bo.StatBO;


public class StatService extends HealthMainService<StatBO> {

	@Override
	public String save(StatBO data) throws Exception {
		return save_(data);
	}

	@Override
	public Object get(StatBO data) throws Exception {
		return get_(data);
	}
	
	public StatBO stat(String districtNumber, String reportMonth) {
		
		StatBO bo = new StatBO();
		
		if ( ! reportMonth.matches( "\\d{6}") )  {
			return null;
		}
		
		Integer year=0, month=0;
		try {
			year = Integer.valueOf( reportMonth.substring(0, 4) );
			month = Integer.valueOf( reportMonth.substring(4, 6) );
			System.out.println("year: " + year);
			System.out.println("month: " + month);
			if ( year < 1900 || month > 12 || month < 1) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		if ( districtNumber == null ) {
			districtNumber = "";
		}
		
		
		@SuppressWarnings({ "rawtypes" })
		List list = getHibernateTemplate().find("from Stat where reportMonth = ?", reportMonth);
		if ( list.size() > 0 ) {
			throw new RuntimeException("exist [" + reportMonth + "] report.");
		}
		
		Timestamp beginDate, endDate;
		String dist = districtNumber + "%";
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		beginDate = new Timestamp( cal.getTimeInMillis() );
		
		cal.add(Calendar.MONTH, 1);
		endDate = new Timestamp( cal.getTimeInMillis() );
		
		System.out.println(beginDate);
		System.out.println(endDate);
		
		fileNum(bo, year, beginDate, endDate, dist);
		childFileNum(bo, year, beginDate, endDate, dist);
		childBabyVisitNum(bo, year, beginDate, endDate, dist);
		childBabyMoonNum(bo, year, beginDate, endDate, dist);
		childVisitNum(bo, year, beginDate, endDate, dist);
		
		pregnantEarlyNum(bo, year, beginDate, endDate, dist);
		pregnantEarlyVisitNum(bo, year, beginDate, endDate, dist);
		pregnantMidOneVisitNum(bo, year, beginDate, endDate, dist);
		pregnantMidTwoVisitNum(bo, year, beginDate, endDate, dist);
		pregnantLateOneVisitNum(bo, year, beginDate, endDate, dist);
		pregnantLateTwoVisitNum(bo, year, beginDate, endDate, dist);
		pregnantNatalVisitNum(bo, year, beginDate, endDate, dist);
		pregnantNatalExamNum(bo, year, beginDate, endDate, dist);
		
		
		infectANum(bo, year, beginDate, endDate, dist);
		infectBNum(bo, year, beginDate, endDate, dist);
		infectCNum(bo, year, beginDate, endDate, dist);
		
		hypFileNum(bo, year, beginDate, endDate, dist);
		hypVisitNum(bo, year, beginDate, endDate, dist);
		
		diabFileNum(bo, year, beginDate, endDate, dist);
		diabVisitNum(bo, year, beginDate, endDate, dist);
		
		
		furiousFileNum(bo, year, beginDate, endDate, dist);
		furiousVisitNum(bo, year, beginDate, endDate, dist);
		
		
		
		return bo;
	}
	
	private void infectANum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//传染病报告数 甲类(infect_a_num)
		//TODO: 传染卡没有distritNumber，统计是否要考虑？
		hql = "select count( b.id ) from InfectionReport b " +
				"where b.date >= ? and b.date < ? and b.firstInfection is null";
		int infectANum = ( (Long) getHibernateTemplate().find( hql , new Object[]{beginDate, endDate}).get(0) ).intValue();
		bo.setInfectANum(infectANum);

		hql = "select count( b.id ) from InfectionReport b " +
				"where year(b.date) = ? and b.firstInfection is null";
		int yearInfectANum = ( (Long) getHibernateTemplate().find( hql , new Object[]{year}).get(0) ).intValue();
		bo.setYearInfectANum(yearInfectANum);
	}
	private void infectBNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//传染病报告数 乙类(infect_b_num)
		//TODO: 传染卡没有distritNumber，统计是否要考虑？
		hql = "select count( b.id ) from InfectionReport b " +
		"where b.date >= ? and b.date < ? and b.secondInfection is null";
		int infectBNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{beginDate, endDate}).get(0) ).intValue();
		bo.setInfectBNum(infectBNum);
		
		hql = "select count( b.id ) from InfectionReport b " +
		"where year(b.date) = ? and b.secondInfection is null";
		int yearInfectBNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{year}).get(0) ).intValue();
		bo.setYearInfectBNum(yearInfectBNum);
	}
	private void infectCNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//传染病报告数 丙类(infect_c_num)
		//TODO: 传染卡没有distritNumber，统计是否要考虑？
		hql = "select count( b.id ) from InfectionReport b " +
		"where b.date >= ? and b.date < ? and b.thirdInfection is null";
		int infectCNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{beginDate, endDate}).get(0) ).intValue();
		bo.setInfectCNum(infectCNum);
		
		hql = "select count( b.id ) from InfectionReport b " +
		"where year(b.date) = ? and b.thirdInfection is null";
		int yearInfectCNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{year}).get(0) ).intValue();
		bo.setYearInfectCNum(yearInfectCNum);
	}
	
	private void hypVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//高血压患者随访人次数(hyp_visit_num)
		hql = "select count( b.id ) from HealthFile a, HypertensionVisit b " +
		"where a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int hypVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setHypVisitNum(hypVisitNum);
		
		hql = "select count( b.id ) from HealthFile a, HypertensionVisit b " +
		"where a.districtNumber like ? and year( b.visitDate ) = ?";
		int yearHypVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearHypVisitNum(yearHypVisitNum);
	}
	
	private void diabVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//糖尿病患者随访人次数(diab_visit_num)
		hql = "select count( b.id ) from HealthFile a, DiabetesVisit b " +
		"where a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int diabVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setDiabVisitNum(diabVisitNum);
		
		hql = "select count( b.id ) from HealthFile a, DiabetesVisit b " +
		"where a.districtNumber like ? and year( b.visitDate ) = ?";
		int yearDiabVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearDiabVisitNum(yearDiabVisitNum);
	}
	
	private void hypFileNum(StatBO bo, Integer year, Timestamp beginDate,
			Timestamp endDate, String dist) {
		// 高血压患者建档数(hyp_file_num)
		bo.setHypFileNum(diseaseFileNum(bo, year, beginDate, endDate, dist,
				ModuleMgr.DISEASE_HYP));
		bo.setYearHypFileNum(diseaseFileNumYear(bo, year, beginDate, endDate,
				dist, ModuleMgr.DISEASE_HYP));
	}
	
	private void diabFileNum(StatBO bo, Integer year, Timestamp beginDate,
			Timestamp endDate, String dist) {
		// 糖尿病患者建档数(diab_file_num)
		bo.setDiabFileNum(diseaseFileNum(bo, year, beginDate, endDate, dist,
				ModuleMgr.DISEASE_DIAB));
		bo.setYearDiabFileNum(diseaseFileNumYear(bo, year, beginDate, endDate,
				dist, ModuleMgr.DISEASE_DIAB));
	}
	
	private void furiousVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//重性精神疾病患者管理 随访人次数(furious_visit_num)
		hql = "select count( b.id ) from HealthFile a, FuriousVisit b " +
		"where a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int furiousVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setFuriousVisitNum(furiousVisitNum);
		
		hql = "select count( b.id ) from HealthFile a, FuriousVisit b " +
		"where a.districtNumber like ? and year( b.visitDate ) = ?";
		int yearFuriousVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearFuriousVisitNum(yearFuriousVisitNum);
	}
	
	private void furiousFileNum(StatBO bo, Integer year, Timestamp beginDate,
			Timestamp endDate, String dist) {
		// 重性精神疾病患者管理 健康档案建立数(furious_file_num)
		bo.setFuriousFileNum(diseaseFileNum(bo, year, beginDate, endDate, dist,
				ModuleMgr.DISEASE_FURI));
		bo.setYearFuriousFileNum(diseaseFileNumYear(bo, year, beginDate,
				endDate, dist, ModuleMgr.DISEASE_FURI));
	}
	
	private int diseaseFileNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist, Integer diseaseId) {
		String hql;
		hql = "select count( a.fileNo ) from HealthFile a, PersonalInfo b, DiseaseHistory c " +
				"where a.fileNo = b.fileNo and b.id = c.personalInfoId and a.districtNumber like ? and a.buildDate >= ? and a.buildDate < ? and c.diseaseId = ?";
		int num = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate, diseaseId}).get(0) ).intValue();
		return num;
	}
	private int diseaseFileNumYear(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist, Integer diseaseId) {
		String hql;
		hql = "select count( a.fileNo ) from HealthFile a, PersonalInfo b, DiseaseHistory c " +
		"where a.fileNo = b.fileNo and b.id = c.personalInfoId and a.districtNumber like ? and year(a.buildDate) = ? and c.diseaseId = ?";
		int num = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year, diseaseId}).get(0) ).intValue();
		return num;
	}
	
	private void pregnantNatalExamNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		String recordType = "1";
		//产后42天体检人数(pregnant_natal_exam_num)
		hql = "select count( b.id ) from HealthFile a, VisitAfterBorn b " +
				"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ? and b.recordType = ?";
		int pregnantNatalExamNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate, recordType}).get(0) ).intValue();
		bo.setPregnantNatalExamNum(pregnantNatalExamNum);
		
		hql = "select count( b.id ) from HealthFile a, VisitAfterBorn b " +
				"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ? and b.recordType = ?";
		int yearPregnantNatalExamNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year, recordType}).get(0) ).intValue();
		bo.setYearPregnantNatalExamNum(yearPregnantNatalExamNum);
	}
	private void pregnantNatalVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		String recordType = "0";
		//访视人次数(pregnant_natal_visit_num)
		hql = "select count( b.id ) from HealthFile a, VisitAfterBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ? and b.recordType = ?";
		int pregnantNatalVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate, recordType}).get(0) ).intValue();
		bo.setPregnantNatalVisitNum(pregnantNatalVisitNum);
		
		hql = "select count( b.id ) from HealthFile a, VisitAfterBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ? and b.recordType = ?";
		int yearPregnantNatalVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year, recordType}).get(0) ).intValue();
		bo.setYearPregnantNatalVisitNum(yearPregnantNatalVisitNum);
	}
	private void pregnantMidOneVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		int b1 = 16, b2 = 20;
		//孕16周-20周随访人次数(pregnant_mid_one_visit_num)
		bo.setPregnantMidOneVisitNum(pregnantVisitNum(bo,year,beginDate, endDate, dist, b1, b2));
		bo.setYearPregnantMidOneVisitNum(pregnantVisitNumYear(bo,year,beginDate, endDate, dist, b1, b2));
	}
	private void pregnantMidTwoVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		int b1 = 21, b2 = 24;
		//孕21周-24周随访人次数(pregnant_mid_two_visit_num)
		bo.setPregnantMidTwoVisitNum(pregnantVisitNum(bo,year,beginDate, endDate, dist, b1, b2));
		bo.setYearPregnantMidTwoVisitNum(pregnantVisitNumYear(bo,year,beginDate, endDate, dist, b1, b2));
	}
	private void pregnantLateOneVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		int b1 = 25, b2 = 36;
		//孕25周-36周随访人次数(pregnant_late_one_visit_num)
		bo.setPregnantLateOneVisitNum(pregnantVisitNum(bo,year,beginDate, endDate, dist, b1, b2));
		bo.setYearPregnantLateOneVisitNum(pregnantVisitNumYear(bo,year,beginDate, endDate, dist, b1, b2));
	}
	private void pregnantLateTwoVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		int b1 = 37, b2 = 40;
		//孕37周-40周随访人次数(pregnant_late_two_visit_num)
		bo.setPregnantLateTwoVisitNum(pregnantVisitNum(bo,year,beginDate, endDate, dist, b1, b2));
		bo.setYearPregnantLateTwoVisitNum(pregnantVisitNumYear(bo,year,beginDate, endDate, dist, b1, b2));
	}
	
	private int pregnantVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist, int b1, int b2) {
		String hql = "select count( b.id ) from HealthFile a, VisitBeforeBorn b " +
				"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ? " +
				"and b.weeks >= ? and b.weeks <= ?";
		int num = ( (Long) getHibernateTemplate().find(
				hql , new Object[]{dist, beginDate, endDate, b1, b2}).get(0) ).intValue();
		return num;
	}
	private int pregnantVisitNumYear(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist, int b1, int b2) {
		String hql = "select count( b.id ) from HealthFile a, VisitBeforeBorn b " +
				"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ? " +
				"and b.weeks >= ? and b.weeks <= ?";
		int num = ( (Long) getHibernateTemplate().find(
				hql , new Object[]{dist, year, b1, b2}).get(0) ).intValue();
		return num;
	}
	
	private void pregnantEarlyVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//孕早期随访人次数(pregnant_early_visit_num)
		hql = "select count( b.id ) from HealthFile a, FirstVistBeforeBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int pregnantEarlyVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setPregnantEarlyVisitNum(pregnantEarlyVisitNum);
		
		hql = "select count( b.id ) from HealthFile a, FirstVistBeforeBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ?";
		int yearPregnantEarlyVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearPregnantEarlyVisitNum(yearPregnantEarlyVisitNum);
	}
	
	private void pregnantEarlyNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//早孕建卡人数(pregnant_early_num)
		//TODO: 似乎应该是 count( distinct(a.fileNo) )， 但hibernate 解析错误，改成 nativesql？
		hql = "select count( a.fileNo ) from HealthFile a, FirstVistBeforeBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and a.buildDate >= ? and a.buildDate < ?";
		int pregnantEarlyNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setPregnantEarlyNum(pregnantEarlyNum);
		
		hql = "select count( a.fileNo ) from HealthFile a, FirstVistBeforeBorn b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(a.buildDate) = ?";
		int yearPregnantEarlyNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearPregnantEarlyNum(yearPregnantEarlyNum);
	}
	
	private void childVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//0--3岁儿童健康管理	随访人次数(child_visit_num)
		hql = "select count(*) from HealthFile a, ChildrenMediExam b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int childVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setChildVisitNum(childVisitNum);
		
		hql = "select count(*) from HealthFile a, ChildrenMediExam b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ?";
		int yearChildVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearChildVisitNum(yearChildVisitNum);
	}
	
	private void childBabyMoonNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		String moon = "1";
		//新生儿满月管理	管理人次数(child_baby_moon_num)
		hql = "select count(*) from HealthFile a, ChildrenMediExam b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ? and b.checkItem = ?";
		int childBabyMoonNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate, moon}).get(0) ).intValue();
		bo.setChildBabyMoonNum(childBabyMoonNum);
		
		hql = "select count(*) from HealthFile a, ChildrenMediExam b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ? and b.checkItem = ?";		
		int yearChildBabyMoonNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year, moon}).get(0) ).intValue();
		bo.setYearChildBabyMoonNum(yearChildBabyMoonNum);
	}

	private void childBabyVisitNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//新生儿访视	访视人次数(child_baby_visit_num)
		hql = "select count(*) from HealthFile a, BabyVisit b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and b.visitDate >= ? and b.visitDate < ?";
		int childBabyVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setChildBabyVisitNum(childBabyVisitNum);
		
		hql = "select count(*) from HealthFile a, BabyVisit b " +
		"where a.fileNo = b.fileNo and a.districtNumber like ? and year(b.visitDate) = ?";
		int yearChildBabyVisitNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearChildBabyVisitNum(yearChildBabyVisitNum);
	}
	
	private void childFileNum(StatBO bo, Integer year,
			Timestamp beginDate, Timestamp endDate, String dist) {
		String hql;
		//儿童建档数(child_file_num)
		hql = "select count(*) from HealthFile a, PersonalInfo b " +
				"where a.districtNumber like ?  and  a.buildDate >= ? and a.buildDate < ? and b.birthday >= ? and a.fileNo = b.fileNo ";
		int childFileNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, beginDate, endDate, BusiUtils.getChildAge()}).get(0) ).intValue();
		bo.setChildFileNum(childFileNum);
		
		hql = "select count(*) from HealthFile a, PersonalInfo b " +
				"where a.districtNumber like ?  and year(a.buildDate) = ? and b.birthday >= ? and a.fileNo = b.fileNo ";
		int yearChildFileNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year, BusiUtils.getChildAge()}).get(0) ).intValue();
		bo.setYearChildFileNum(yearChildFileNum);
	}

	private void fileNum(StatBO bo, Integer year, Timestamp beginDate,
			Timestamp endDate, String dist) {
		String hql;
		//居民健康档案建立数(file_num)
		hql = "select count(*) from HealthFile a where "
				+ " a.districtNumber like ?  and "
				+ " a.buildDate >= ? and a.buildDate < ? ";
		int fileNum = ( (Long) getHibernateTemplate().find( hql, new Object[]{dist, beginDate, endDate}).get(0) ).intValue();
		bo.setFileNum(fileNum);
		
		hql = "select count(*) from HealthFile a " +
				"where a.districtNumber like ? and year(a.buildDate) = ? ";
		int yearFileNum = ( (Long) getHibernateTemplate().find( hql , new Object[]{dist, year}).get(0) ).intValue();
		bo.setYearFileNum(yearFileNum);
	}

}
