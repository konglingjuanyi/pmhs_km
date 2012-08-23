package cn.net.tongfang.web.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.District;
import cn.net.tongfang.framework.security.vo.ResidentPopulation;
import cn.net.tongfang.framework.util.EncryptionUtils;

public class ReportService extends HibernateDaoSupport {
	public static final Integer DISEASE_HYP = 2;
	public static final Integer DISEASE_FURI = 8;
	public static final Integer DISEASE_DIAB = 3;

	// 日统计报表
	public List getDataInfoByDay(String day) {
		//Date date = convertToDate(day);
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		double num4 = 0.0;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		double num8 = 0.0;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		double num14 = 0.0;
		long num15 = 0L;
		long num16 = 0L;
		Query query = null;

		for (District district : districts) {
			String id = district.getId();
			sql = "Select A.id,A.name From SamTaxorgcode A Where A.districtNumber = '"
					+ id + "'";
			query = getSession().createQuery(sql);
			List l = query.list();
			for (int i = 0; i < l.size(); i++) {
				List tmpResult = new ArrayList();
				// 各乡镇名称
				Object[] objs = (Object[]) l.get(i);
				Integer tmpOrgId = (Integer) objs[0];
				String tmpOrgName = (String) objs[1];
				tmpResult.add(tmpOrgName);
				// 居民健康档案合计常驻人口

				ResidentPopulation population = buildSQL04(day.substring(0, 4)
						+ "年", tmpOrgId);
				if (population == null) {
					population = new ResidentPopulation();
					population.setFarmNumber(0L);
					population.setPopulationNumber(0L);
					population.setTownNumber(0L);
				}
				long tmpNum1 = population.getPopulationNumber();
				num1 += tmpNum1;
				tmpResult.add(tmpNum1);
				// 居民健康档案合计累计建档
				sql = buildSQL02(id, tmpOrgId);
				long tmpNum2 = execSQL(sql);
				num2 += tmpNum2;
				tmpResult.add(tmpNum2);
				// 居民健康档案合计建档率
				tmpResult.add(0);
				// 居民健康档案合计其中电子建档率
				double tmpNum4 = 0;
				if (tmpNum2 != 0 && tmpNum1 != 0) {
					tmpNum4 = (new BigDecimal(
							((double) tmpNum2 / tmpNum1) * 100)).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				num4 += tmpNum4;
				tmpResult.add(tmpNum4);
				// 城镇居民建档情况城镇居民
				long tmpNum5 = population.getTownNumber();
				num5 += tmpNum5;
				tmpResult.add(tmpNum5);
				// 城镇居民建档情况累计建档
				sql = buildSQL01(id, " And A.farmStatus = '否' And C.orgId = "
						+ tmpOrgId);
				long tmpNum6 = execSQL(sql);
				num6 += tmpNum6;
				tmpResult.add(tmpNum6);
				// 城镇居民建档情况建档率
				tmpResult.add(0);
				// 城镇居民建档情况其中电子建档率
				double tmpNum8 = 0;
				if (tmpNum6 != 0 && tmpNum5 != 0) {
					tmpNum8 = (new BigDecimal(
							((double) tmpNum6 / tmpNum5) * 100)).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				num8 += tmpNum8;
				tmpResult.add(tmpNum8);
				// 城镇居民建档情况当日建档
				tmpResult.add(0);
				// 城镇居民建档情况当日电子建档
				sql = buildSQL01(id, " And A.farmStatus = '否' And C.orgId  = "
						+ tmpOrgId
						+ "  And CONVERT(varchar(10),B.inputDate,120) = '"
						+ day + "'");
				long tmpNum10 = execSQL(sql);
				num10 += tmpNum10;
				tmpResult.add(tmpNum10);
				// 乡村居民建档情况农村居民
				long tmpNum11 = population.getFarmNumber();
				num11 += tmpNum11;
				tmpResult.add(tmpNum11);
				// 乡村居民建档情况累计建档
				sql = buildSQL01(id, " And A.farmStatus = '是' And C.orgId = "
						+ tmpOrgId);
				long tmpNum12 = execSQL(sql);
				num12 += tmpNum12;
				tmpResult.add(tmpNum12);
				// 乡村居民建档情况建档率
				tmpResult.add(0);
				// 乡村居民建档情况其中电子建档率
				double tmpNum14 = 0;
				if (tmpNum12 != 0 && tmpNum11 != 0) {
					tmpNum14 = (new BigDecimal(
							((double) tmpNum12 / tmpNum11) * 100)).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				num14 += tmpNum14;
				tmpResult.add(tmpNum14);
				// 乡村居民建档情况其中当日建档
				tmpResult.add(0);
				// 乡村居民建档情况当日电子建档
				sql = buildSQL01(id, " And A.farmStatus = '是' And C.orgId = "
						+ tmpOrgId
						+ "  And CONVERT(varchar(10),B.inputDate,120) = '"
						+ day + "'");
				long tmpNum16 = execSQL(sql);
				num16 += tmpNum16;
				tmpResult.add(tmpNum16);
				result.add(tmpResult);
			}
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		
		tmpResult.add(getVal(num2,num1));
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(getVal(num6,num5));
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		tmpResult.add(getVal(num12,num11));
		tmpResult.add(num15);
		tmpResult.add(num16);
		result.add(tmpResult);
		return result;
	}

	
	/**
	 * 百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double getVal(long num1,long num2){
		if(num2 != 0L){
			return (new BigDecimal(
					((double) num1 / num2) * 100)).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return 0.0;
	}
	
	/**
	 * 百分比重构
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double getVal(double num1,double num2){
		if(num2 != 0.0){
			return (new BigDecimal(
					((double) num1 / num2) * 100)).setScale(2,
							BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return 0.0;
	}
	
	/**
	 * 月报表一
	 * 
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public List getDataInfoByMonth01(String startDay, String endDay) {
		// Date date = convertToDate(day);
		String startDate = startDay + " 00:00:00";
		String endDate = endDay + " 23:59:59";

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList<List<Comparable>>();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		long num4 = 0L;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		Query query = null;

		for (District district : districts) {
			String id = district.getId();
			sql = "Select A.id,A.name From SamTaxorgcode A Where A.districtNumber = '"
					+ id + "'";
			query = getSession().createQuery(sql);
			List l = query.list();
			for (int i = 0; i < l.size(); i++) {
				List tmpResult = new ArrayList();

				Object[] objs = (Object[]) l.get(i);
				Integer tmpOrgId = (Integer) objs[0];
				String tmpOrgName = (String) objs[1];
				// 各村委会名称名称
				tmpResult.add(tmpOrgName);
				// 常住人口数
				ResidentPopulation population = buildSQL04(
						endDay.substring(0, 4) + "年", tmpOrgId);
				if (population == null) {
					population = new ResidentPopulation();
					population.setFarmNumber(0L);
					population.setPopulationNumber(0L);
					population.setTownNumber(0L);
				}
				long tmpNum1 = population.getPopulationNumber();
				num1 += tmpNum1;
				tmpResult.add(tmpNum1);
				// 户藉人口数
				sql = buildSQL01(id, " And A.resideType = '户籍' And C.orgId = "
						+ tmpOrgId + " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "'");
				long tmpNum2 = execSQL(sql);
				num2 += tmpNum2;
				tmpResult.add(tmpNum2);
				// 城镇居民人口数
				sql = buildSQL01(id, " And A.farmStatus = '否' And C.orgId = "
						+ tmpOrgId + " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "'");
				long tmpNum3 = execSQL(sql);
				num3 += tmpNum3;
				tmpResult.add(tmpNum3);
				// 乡村居民人口数
				sql = buildSQL01(id, " And A.farmStatus = '是' And C.orgId = "
						+ tmpOrgId + " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "'");
				long tmpNum4 = execSQL(sql);
				num4 += tmpNum4;
				tmpResult.add(tmpNum4);
				// 孕产妇数
				tmpResult.add(0);
				// 活产数
				tmpResult.add(0);
				// 0-6岁儿童数
				sql = buildSQL01(id, " And C.orgId = " + tmpOrgId
						+ " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "' "
						+ " And (year(getDate()) - year(birthday)) <= 6 ");
				long tmpNum7 = execSQL(sql);
				num7 += tmpNum7;
				tmpResult.add(tmpNum7);
				// 15岁以上人口数
				sql = buildSQL01(
						id,
						"  And C.orgId = "
								+ tmpOrgId
								+ " And B.inputDate >= '"
								+ startDate
								+ "' and B.inputDate <= '"
								+ endDate
								+ "' "
								+ " And (year(getDate()) - year(birthday)) > 15 And (year(getDate()) - year(birthday)) <= 35 ");
				long tmpNum8 = execSQL(sql);
				num8 += tmpNum8;
				tmpResult.add(tmpNum8);
				// 35岁以上人口数
				sql = buildSQL01(
						id,
						"  And C.orgId = "
								+ tmpOrgId
								+ " And B.inputDate >= '"
								+ startDate
								+ "' and B.inputDate <= '"
								+ endDate
								+ "' "
								+ " And (year(getDate()) - year(birthday)) > 35 And (year(getDate()) - year(birthday)) <= 65 ");
				long tmpNum9 = execSQL(sql);
				num9 += tmpNum9;
				tmpResult.add(tmpNum9);
				// 65岁以上人口数
				sql = buildSQL01(id, "  And C.orgId = " + tmpOrgId
						+ " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "' "
						+ " And (year(getDate()) - year(birthday)) > 65");
				long tmpNum10 = execSQL(sql);
				num10 += tmpNum10;
				tmpResult.add(tmpNum10);
				// 应管理高血压人数
				sql = buildSQL03(id, "  And D.orgId = " + tmpOrgId
						+ " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "' "
						+ " And C.diseaseId = " + DISEASE_HYP);
				long tmpNum11 = execSQL(sql);
				num11 += tmpNum11;
				tmpResult.add(tmpNum11);
				// 应管理糖尿病人数
				sql = buildSQL03(id, "  And D.orgId = " + tmpOrgId
						+ " And B.inputDate >= '"
						+ startDate + "' and B.inputDate >= '"
						+ endDate + "' "
						+ " And C.diseaseId = " + DISEASE_DIAB);
				long tmpNum12 = execSQL(sql);
				num12 += tmpNum12;
				tmpResult.add(tmpNum12);
				// 应管理精神病人数
				sql = buildSQL03(id, "  And D.orgId = " + tmpOrgId
						+ " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "' "
						+ " And C.diseaseId = " + DISEASE_FURI);
				long tmpNum13 = execSQL(sql);
				num13 += tmpNum13;
				tmpResult.add(tmpNum13);
				result.add(tmpResult);
			}
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		tmpResult.add(num4);
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		result.add(tmpResult);
		return result;
	}

	/**
	 * 月报表二
	 * 
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public List getDataInfoByMonth02(String startDay, String endDay) {
		// Date date = convertToDate(day);
		String startDate = startDay + " 00:00:00";
		String endDate = endDay + " 23:59:59";

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		double num2 = 0.0;
		long num3 = 0L;
		double num4 = 0.0;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		long num14 = 0L;
		long num15 = 0L;
		long num16 = 0L;
		Query query = null;

		for (District district : districts) {
			String id = district.getId();
			sql = "Select A.id,A.name From SamTaxorgcode A Where A.districtNumber = '"
					+ id + "'";
			query = getSession().createQuery(sql);
			List l = query.list();
			for (int i = 0; i < l.size(); i++) {
				List tmpResult = new ArrayList();
				Object[] objs = (Object[]) l.get(i);
				Integer tmpOrgId = (Integer) objs[0];
				String tmpOrgName = (String) objs[1];
				// 各村委会名称名称
				tmpResult.add(tmpOrgName);
				// 城镇居民规范化电子建档人数
				sql = buildSQL01(id, " And A.farmStatus = '否' And C.orgId = "
						+ tmpOrgId + " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "'");
				long tmpNum1 = execSQL(sql);
				num1 += tmpNum1;
				tmpResult.add(tmpNum1);
				// 城镇居民规范化电子建档%
				ResidentPopulation population = buildSQL04(
						endDay.substring(0, 4) + "年", tmpOrgId);
				if (population == null) {
					population = new ResidentPopulation();
					population.setFarmNumber(0L);
					population.setPopulationNumber(0L);
					population.setTownNumber(0L);
				}
				double tmpNum2 = 0.0;
				double tmpTownNumber = (double) population.getTownNumber();
				if (tmpNum1 != 0 && tmpTownNumber != 0) {
					tmpNum2 = (new BigDecimal((tmpNum1 / tmpTownNumber) * 100)
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue());
				}
				num2 += tmpTownNumber;
				tmpResult.add(tmpNum2);
				// 农村居民规范化电子建档人数
				sql = buildSQL01(id, " And A.farmStatus = '是' And C.orgId = "
						+ tmpOrgId + " And B.inputDate >= '"
						+ startDate + "' and B.inputDate <= '"
						+ endDate + "'");
				long tmpNum3 = execSQL(sql);
				num3 += tmpNum3;
				tmpResult.add(tmpNum3);
				// 农村居民规范化电子建档%
				double tmpNum4 = 0.0;
				double tmpFarmNumber = (double) population.getFarmNumber();
				if (tmpNum3 != 0 && tmpFarmNumber != 0) {
					tmpNum4 = (new BigDecimal((tmpNum1 / tmpFarmNumber) * 100)
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue());
				}
				num4 += tmpFarmNumber;
				tmpResult.add(tmpNum4);
				// 0-6岁儿童管理人数
				tmpResult.add(0);
				// 0-6岁儿童管理%
				tmpResult.add(0);
				// 孕产妇系统管理人数
				tmpResult.add(0);
				// 孕产妇系统管理%
				tmpResult.add(0);
				// 老年人管理人数
				tmpResult.add(0);
				// 老年人管理%
				tmpResult.add(0);
				// 高血压管理人数
				tmpResult.add(0);
				// 高血压管理%
				tmpResult.add(0);
				// 糖尿病管理人数
				tmpResult.add(0);
				// 糖尿病管理%
				tmpResult.add(0);
				// 精神病管理人数
				tmpResult.add(0);
				// 精神病管理%
				tmpResult.add(0);
				result.add(tmpResult);
			}
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(getVal(num1,num2));
		tmpResult.add(num3);
		tmpResult.add(getVal(num3,num4));
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		tmpResult.add(num14);
		tmpResult.add(num15);
		tmpResult.add(num16);
		result.add(tmpResult);
		return result;
	}

	/**
	 * 月报表三
	 * 
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public List getDataInfoByMonth03(String startDay, String endDay) {
		// Date date = convertToDate(day);
		Date startDate = convertToTime(startDay + " 00:00:00");
		Date endDate = convertToTime(endDay + " 23:59:59");

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		long num4 = 0L;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		long num14 = 0L;
		long num15 = 0L;
		long num16 = 0L;
		long num17 = 0L;
		long num18 = 0L;
		for (District district : districts) {
			String id = district.getId();
			List tmpResult = new ArrayList();
			// 各村委会名称名称
			tmpResult.add(district.getName());
			// 卡介苗人数
			tmpResult.add(0);
			// 卡介苗%
			tmpResult.add(0);
			// 麻疹疫苗人数
			tmpResult.add(0);
			// 麻疹疫苗%
			tmpResult.add(0);
			// 白百破疫苗人数
			tmpResult.add(0);
			// 白百破疫苗%
			tmpResult.add(0);
			// 脊灰疫苗人数
			tmpResult.add(0);
			// 脊灰疫苗%
			tmpResult.add(0);
			// 乙肝疫苗人数
			tmpResult.add(0);
			// 乙肝疫苗%
			tmpResult.add(0);
			// 乙肝疫苗补种人数
			tmpResult.add(0);
			// 乙肝疫苗补种%
			tmpResult.add(0);
			// 报告例数
			tmpResult.add(0);
			// 发病率
			tmpResult.add(0);
			// 设置宣传栏乡级
			tmpResult.add(0);
			// 设置宣传栏村级
			tmpResult.add(0);
			// 健康讲座
			tmpResult.add(0);
			// 健康咨询
			tmpResult.add(0);
			result.add(tmpResult);
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		tmpResult.add(num4);
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		tmpResult.add(num14);
		tmpResult.add(num15);
		tmpResult.add(num16);
		tmpResult.add(num17);
		tmpResult.add(num18);
		result.add(tmpResult);
		return result;
	}

	/**
	 * 执行SQL
	 * 
	 * @param sql
	 * @return
	 */
	private long execSQL(String sql) {
		Query query = getSession().createQuery(sql);
		List list = query.list();
		return (Long) list.get(0);
	}

	/**
	 * 构建SQL
	 * 
	 * @param id
	 * @return
	 */
	private String buildSQL02(String id, Integer orgId) {
		return "Select Count(*) From HealthFile a,SamTaxempcode b Where a.fileNo Like '"
				+ EncryptionUtils.encry(id)
				+ "%' And a.inputPersonId = b.loginname And b.orgId = " + orgId;
	}

	/**
	 * 构建SQL
	 * 
	 * @param id
	 * @return
	 */
	private String buildSQL01(String id, String where) {
		return "Select Count(*) From PersonalInfo A,HealthFile B,SamTaxempcode C Where B.fileNo Like '"
				+ EncryptionUtils.encry(id)
				+ "%' And A.fileNo = B.fileNo And A.inputPersonId = C.loginname "
				+ where;
	}

	/**
	 * 构建SQL
	 * 
	 * @param id
	 * @return
	 */
	private ResidentPopulation buildSQL04(String years, Integer orgId) {
		String sql = "From ResidentPopulation Where years = '" + years
				+ "' And orgId = " + orgId;
		Query query = getSession().createQuery(sql);
		List list = query.list();
		if (list.size() > 0)
			return (ResidentPopulation) list.get(0);
		return null;
	}

	/**
	 * 构建SQL
	 * 
	 * @param id
	 * @param where
	 * @return
	 */
	private String buildSQL03(String id, String where) {
		return "Select Count(*) From PersonalInfo A,HealthFile B,DiseaseHistory C,SamTaxempcode D Where B.fileNo Like '"
				+ EncryptionUtils.encry(id)
				+ "%' And A.fileNo = B.fileNo And A.id = C.personalInfoId And A.inputPersonId = D.loginname "
				+ where;
	}

	// private String

	// 日期转换
	private Date convertToDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return d;
	}

	// 日期转换
	private Date convertToTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return d;
	}

	public List getDataInfoByTownship(String startDay, String endDay) {
		// Date date = convertToDate(day);
		String startDate = startDay + " 00:00:00";
		String endDate = endDay + " 23:59:59";

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		long num4 = 0L;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		long num14 = 0L;
		long num15 = 0L;
		Query query = null;

		for (District district : districts) {
			List tmpResult = new ArrayList();
			String id = district.getId();
			String orgName = district.getName();
			// 乡镇名称
			tmpResult.add(orgName);
			// 农业户口建档数
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '是' "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
			long tmpNum1 = execSQL01(sql);
			num1 = num1 + tmpNum1;
			tmpResult.add(tmpNum1);
			// 城镇户口建档数
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '否'"
					+ " and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <='"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum2 = execSQL01(sql);
			num2 = num2 + tmpNum2;
			tmpResult.add(tmpNum2);
			// 新生儿
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, BabyVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum3 = execSQL01(sql);
			num3 = num3 + tmpNum3;
			tmpResult.add(tmpNum3);
			// 0~6岁儿童档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and (year(getDate()) - year(b.birthday)) <= 6"
					+ " and  b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And a.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' " + " group by substring(a.districtNumber,1,9)";
			long tmpNum4 = execSQL01(sql);
			num4 = num4 + tmpNum4;
			tmpResult.add(tmpNum4);

			// 0~3岁儿童
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmp0_3child = execSQL01(sql);
			// 3~6岁儿童
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam36 b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmp3_6child = execSQL01(sql);
			long tmpNum5 = tmp0_3child + tmp3_6child;
			num5 = num5 + tmpNum5;
			tmpResult.add(tmpNum5);

			// 孕产妇档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b"
					+ " where a.fileNo = b.fileNo and b.bornStatus = '是'"
					+ " and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum6 = execSQL01(sql);
			num6 = num6 + tmpNum6;
			tmpResult.add(tmpNum6);

			//第一次产前随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FirstVistBeforeBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpFirstVisit = execSQL01(sql);
			// 第2~5次产前随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitBeforeBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpVisit = execSQL01(sql);
			long tmpNum7 = tmpFirstVisit + tmpVisit;
			num7 = num7 + tmpNum7;
			tmpResult.add(tmpNum7);

			// 产后随访
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitAfterBorn b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum8 = execSQL01(sql);
			num8 = num8 + tmpNum8;
			tmpResult.add(tmpNum8);

			// 65岁以上老年人
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, MedicalExam b where a.fileNo = b.fileNo "
					+ " and b.age >= 65 " 
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum9 = execSQL01(sql);
			num9 = num9 + tmpNum9;
			tmpResult.add(tmpNum9);

			// 高血压档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_HYP + " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
			long tmpNum10 = execSQL01(sql);
			num10 = num10 + tmpNum10;
			tmpResult.add(tmpNum10);
			// 高血压
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, HypertensionVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "%' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum11 = execSQL01(sql);
			num11 = num11 + tmpNum11;
			tmpResult.add(tmpNum11);

			// 糖尿病档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_DIAB
					+ " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
			long tmpNum12 = execSQL01(sql);
			num12 = num12 + tmpNum12;
			tmpResult.add(tmpNum12);
			// 糖尿病
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, DiabetesVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "%' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <='"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum13 = execSQL01(sql);
			num13 = num13 + tmpNum13;
			tmpResult.add(tmpNum13);

			// 重性精神病档案
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,DiseaseHistory c where a.fileNo = b.fileNo "
					+ "and b.fileNo Like '"
					+ EncryptionUtils.encry(id)
					+ "%' and c.personalInfoId = b.id and c.diseaseId = "
					+ DISEASE_FURI
					+ " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "'  group by substring(a.districtNumber,1,9)";
			long tmpNum14 = execSQL01(sql);
			num14 = num14 + tmpNum14;
			tmpResult.add(tmpNum14);
			// 重性精神病
			sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FuriousVisit b where a.fileNo = b.fileNo "
//					+ "and b.fileNo Like '"
//					+ EncryptionUtils.encry(id)
					+ "and b.execDistrictNum = '" 
					+ id
					+ "%' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
			long tmpNum15 = execSQL01(sql);
			num15 = num15 + tmpNum15;
			tmpResult.add(tmpNum15);
			result.add(tmpResult);
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		tmpResult.add(num4);
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		tmpResult.add(num14);
		tmpResult.add(num15);
		result.add(tmpResult);
		return result;
	}

	
	/**
	 * 卫生院汇总统计
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public List getDataInfoByHospital(String startDay, String endDay) {
		// Date date = convertToDate(day);
		String startDate = startDay + " 00:00:00";
		String endDate = endDay + " 23:59:59";

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();
		Query q = getSession().createQuery("from District where parentId = ? Or id = ? order by id");
		q.setParameter(0, parentDistrict);
		q.setParameter(1, parentDistrict);
		List<District> districts = q.list();
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		long num4 = 0L;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		long num9 = 0L;
		long num10 = 0L;
		long num11 = 0L;
		long num12 = 0L;
		long num13 = 0L;
		long num14 = 0L;
		long num15 = 0L;
		Query query = null;
		String tmpOrgName = "";
		Integer tmpOrgId;
		for (District district : districts) {
			
			String orgName = district.getName();
			String id = district.getId();
			sql = "Select A.id,A.name From SamTaxorgcode A Where A.districtNumber = '" + 
					id + "' And A.isDetail != 0";
			query = getSession().createQuery(sql);
			List l = query.list();
			for (int i = 0; i < l.size(); i++) {
				List tmpResult = new ArrayList();
				Object[] objs = (Object[])l.get(i);
				tmpOrgId = (Integer)objs[0];
				tmpOrgName = (String)objs[1];
				//卫生院名称
				tmpResult.add(tmpOrgName);
				// 农业户口建档数
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '是' "
					+ "and b.inputPersonId = c.loginname And c.orgId ="
					+ tmpOrgId
					+ " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
				long tmpNum1 = execSQL01(sql);
				num1 = num1 + tmpNum1;
				tmpResult.add(tmpNum1);
				// 城镇户口建档数
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
					+ " where a.fileNo = b.fileNo and b.farmStatus = '否'"
					+ " and b.inputPersonId = c.loginname And c.orgId ="
					+ tmpOrgId + " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <='"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum2 = execSQL01(sql);
				num2 = num2 + tmpNum2;
				tmpResult.add(tmpNum2);
				// 新生儿
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, BabyVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum3 = execSQL01(sql);
				num3 = num3 + tmpNum3;
				tmpResult.add(tmpNum3);
				// 0~6岁儿童档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c "
					+ " where a.fileNo = b.fileNo and (year(getDate()) - year(b.birthday)) <= 6"
					+ " and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And a.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
				long tmpNum4 = execSQL01(sql);
				num4 = num4 + tmpNum4;
				tmpResult.add(tmpNum4);

				// 0~3岁儿童
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
				long tmp0_3child = execSQL01(sql);
				// 3~6岁儿童
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, ChildrenMediExam36 b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
				long tmp3_6child = execSQL01(sql);
				long tmpNum5 = tmp0_3child + tmp3_6child;
				num5 = num5 + tmpNum5;
				tmpResult.add(tmpNum5);

				// 孕产妇档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c"
					+ " where a.fileNo = b.fileNo and b.bornStatus = '是'"
					+ " and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' group by substring(a.districtNumber,1,9)";
				long tmpNum6 = execSQL01(sql);
				num6 = num6 + tmpNum6;
				tmpResult.add(tmpNum6);

				//第一次产前随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FirstVistBeforeBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpFirstVisit = execSQL01(sql);
				// 第2~5次产前随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitBeforeBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpVisit = execSQL01(sql);
				long tmpNum7 = tmpFirstVisit + tmpVisit;
				num7 = num7 + tmpNum7;
				tmpResult.add(tmpNum7);

				// 产后随访
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, VisitAfterBorn b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum8 = execSQL01(sql);
				num8 = num8 + tmpNum8;
				tmpResult.add(tmpNum8);

				// 65岁以上老年人
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, MedicalExam b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ " and b.age >= 65 and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "'"
					+ " And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum9 = execSQL01(sql);
				num9 = num9 + tmpNum9;
				tmpResult.add(tmpNum9);

				// 高血压档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId
					+ " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' and d.personalInfoId = b.id and d.diseaseId = "
					+ DISEASE_HYP + " group by substring(a.districtNumber,1,9)";
				long tmpNum10 = execSQL01(sql);
				num10 = num10 + tmpNum10;
				tmpResult.add(tmpNum10);
				// 高血压
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, HypertensionVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum11 = execSQL01(sql);
				num11 = num11 + tmpNum11;
				tmpResult.add(tmpNum11);

				// 糖尿病档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' and d.personalInfoId = b.id and d.diseaseId = "
					+ DISEASE_DIAB + " group by substring(a.districtNumber,1,9)";
				long tmpNum12 = execSQL01(sql);
				num12 = num12 + tmpNum12;
				tmpResult.add(tmpNum12);
				// 糖尿病
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, DiabetesVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <='"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum13 = execSQL01(sql);
				num13 = num13 + tmpNum13;
				tmpResult.add(tmpNum13);

				// 重性精神病档案
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, PersonalInfo b,SamTaxempcode c,DiseaseHistory d where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId
					+ " And a.inputDate >= '"
					+ startDate
					+ "' and a.inputDate <= '"
					+ endDate
					+ "' and d.personalInfoId = b.id and d.diseaseId = "
					+ DISEASE_FURI + " group by substring(a.districtNumber,1,9)";
				long tmpNum14 = execSQL01(sql);
				num14 = num14 + tmpNum14;
				tmpResult.add(tmpNum14);
				// 重性精神病
				sql = "select new cn.net.tongfang.web.service.StatNode(substring(a.districtNumber,1,9),count(*)) "
					+ " from HealthFile a, FuriousVisit b,SamTaxempcode c where a.fileNo = b.fileNo "
					+ "and b.inputPersonId = c.loginname  And c.orgId ="
					+ tmpOrgId + " And b.execDistrictNum = '" + id + "' And b.inputDate >= '"
					+ startDate
					+ "' and b.inputDate <= '"
					+ endDate
					+ "' "
					+ " group by substring(a.districtNumber,1,9)";
				long tmpNum15 = execSQL01(sql);
				num15 = num15 + tmpNum15;
				tmpResult.add(tmpNum15);
				result.add(tmpResult);
			}
		}
		List tmpResult = new ArrayList();
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		tmpResult.add(num4);
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		tmpResult.add(num9);
		tmpResult.add(num10);
		tmpResult.add(num11);
		tmpResult.add(num12);
		tmpResult.add(num13);
		tmpResult.add(num14);
		tmpResult.add(num15);
		result.add(tmpResult);
		return result;
	}
	
	private long execSQL01(String sql) {
		List<StatNode> nodes = getHibernateTemplate().find(sql);
		long tmpFarm = 0;
		for (StatNode node : nodes) {
			tmpFarm = node.getNum();
		}
		return tmpFarm;
	}
	
	public List getHighRiskData(String startDay, String endDay) {
		// Date date = convertToDate(day);
		String startDate = startDay + " 00:00:00";
		String endDate = endDay + " 23:59:59";

		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager
				.currentOperator();
		String parentDistrict = user.getDistrictId();
		List result = new ArrayList();

		List<District> districts = getHibernateTemplate().find(
				"from District where parentId = ? order by id", parentDistrict);
		String sql = "";
		long num1 = 0L;
		long num2 = 0L;
		long num3 = 0L;
		long num4 = 0L;
		long num5 = 0L;
		long num6 = 0L;
		long num7 = 0L;
		long num8 = 0L;
		Query query = null;

		for (District district : districts) {
			List tmpResult = new ArrayList();
			String id = district.getId();
			String orgName = district.getName();
			tmpResult.add(id);
			// 乡镇名称
			tmpResult.add(orgName);
			//第1次产前随访
			long tmpNum1 = execSQL2("FirstVistBeforeBorn",id,"");
			num1 = num1 + tmpNum1;
			tmpResult.add(tmpNum1);
			//第2~5次产前随访
			long tmpNum2 = execSQL2("VisitBeforeBorn",id,"");
			num2 = num2 + tmpNum2;
			tmpResult.add(tmpNum2);
			//产后访视
			long tmpNum3 = execSQL2("VisitAfterBorn",id,"And recordType = 0");
			num3 = num3 + tmpNum3;
			tmpResult.add(tmpNum3);
			//产后42天访视
			long tmpNum4 = execSQL2("VisitAfterBorn",id,"And recordType = 1");
			num4 = num4 + tmpNum4;
			tmpResult.add(tmpNum4);
			//新生儿家庭访视记录
			long tmpNum5 = execSQL2("BabyVisit",id,"");
			num5 = num5 + tmpNum5;
			tmpResult.add(tmpNum5);
			//1岁以内儿童健康体检
			long tmpNum6 = execSQL2("ChildrenMediExam",id,"And dataType = 0");
			num6 = num6 + tmpNum6;
			tmpResult.add(tmpNum6);
			//1~2岁儿童健康体检
			long tmpNum7 = execSQL2("ChildrenMediExam",id,"And dataType = 1");
			num7 = num7 + tmpNum7;
			tmpResult.add(tmpNum7);
			//3~6岁儿童健康体检
			long tmpNum8 = execSQL2("ChildrenMediExam36",id,"");
			num8 = num8 + tmpNum8;
			tmpResult.add(tmpNum8);
			
			result.add(tmpResult);
		}
		List tmpResult = new ArrayList();
		tmpResult.add("-1");
		tmpResult.add("总计");
		tmpResult.add(num1);
		tmpResult.add(num2);
		tmpResult.add(num3);
		tmpResult.add(num4);
		tmpResult.add(num5);
		tmpResult.add(num6);
		tmpResult.add(num7);
		tmpResult.add(num8);
		result.add(tmpResult);
		return result;
	}
	
	private long execSQL2(String tableName,String orgId,String where){
		String sql = "Select Count(*) From " + tableName + " Where fileNo Like '" +
			EncryptionUtils.encry(orgId) + "%' And highRisk = '是' " + where;
		return execSQL(sql);
	}
	
	/**
	 * 出生登记月报表
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public List getDataInfoByRegister(String startDay,String endDay,String orgname,String orgid){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String orgName = user.getOrg().getName();
		Integer orgId = user.getOrgId();
		if(!orgname.equals("") && !orgId.equals("")){
			orgName = orgname;
			orgId = Integer.parseInt(orgid);
		}
		
		String username = user.getTaxempname();		
		startDay = startDay + " 00:00:00";
		endDay = endDay + " 23:59:59";
		String hql = "From BirthCertificate Where inputPersonId in " +
				"(Select loginname From SamTaxempcode Where orgId = ?) And inputDate >= '" + 
				startDay + "' And inputDate <= '" + endDay + "' And isEffectived in (2,4)";//查询限定时间内的末归档和已归档的出生证明
		Query query = getSession().createQuery(hql);
		query.setParameter(0, orgId);
		List list = query.list();
		List ret = new ArrayList();
		ret.add(orgName);
		ret.add(username);
		ret.add(list);
		return ret;
	}
	
	/**
	 * 出生医学证明年度统计报表
	 * @param startDay
	 * @param endDay
	 * @param orgname
	 * @param orgid
	 * @return
	 */
	public List getDataInfoByManageBirthCertifi(String startDay,String endDay,String orgname,String orgid){
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		String orgName = user.getOrg().getName();
		Integer orgId = user.getOrgId();
		if(!orgname.equals("") && !orgId.equals("")){
			orgName = orgname;
			orgId = Integer.parseInt(orgid);
		}
		
		String username = user.getTaxempname();		
		startDay = startDay + " 00:00:00";
		endDay = endDay + " 23:59:59";
		String hql = "From BirthCertificate Where inputPersonId in " +
				"(Select loginname From SamTaxempcode Where orgId = ?) And inputDate >= '" + 
				startDay + "' And inputDate <= '" + endDay + "' And (isEffectived = 2 Or isEffectived = 4)";//查询限定时间内的末归档和已归档的出生证明
		Query query = getSession().createQuery(hql);
		query.setParameter(0, orgId);
		List list = query.list();
		List ret = new ArrayList();
		ret.add(orgName);
		ret.add(username);
		ret.add(list);
		return ret;
	}
}
