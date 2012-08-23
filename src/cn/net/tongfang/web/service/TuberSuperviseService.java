package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.TuberSuperDetail;
import cn.net.tongfang.framework.security.vo.Tuberculosis;
import cn.net.tongfang.web.service.bo.TuberculosisBO;

@SuppressWarnings("unchecked")
public class TuberSuperviseService extends HibernateDaoSupport {
	private static final Logger log = Logger.getLogger(PersonalInfoService.class);
	
	/**
	 * 执行SQL
	 * @param sql
	 * @return
	 */
	private List OptDatabse(String sql){
		Query q = getSession().createQuery(sql);
		List list = q.list();
		return list;
	}
	/**
	 * 获得个人基本信息
	 * @param fileNo
	 * @return
	 */
	public String getPersonalInfo(String fileNo){
		String sql = "select a.name,a.address,b.sex,b.birthday from HealthFile a,PersonalInfo b " + 
			"where a.fileNo = b.fileNo and a.fileNo = '" + fileNo + "'"; 
		List list = OptDatabse(sql);
		StringBuffer result = new StringBuffer();
		if (list.size() > 0) {

			for (Object objs : list) {
				Object[] str = (Object[]) objs;
				result.append(String.valueOf(str[0]) + ","
								+ String.valueOf(str[1]) + ","
								+ String.valueOf(str[2]) + ","
								+ String.valueOf(str[3]));
			}
			log.debug("get personInfo success!");
		}
		return result.toString();
	}
	

	/**
	 * 保存
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public synchronized String save(TuberculosisBO data) throws Exception{
		String fileNo = data.getFileNo();
		String sql = "from Tuberculosis a where a.fileNo = '" + fileNo + "'";
		List list = OptDatabse(sql);
		Timestamp timeForStart = null;
		String id;
		if(list.size() > 0){
			Tuberculosis tempTuber = (Tuberculosis)list.get(0);
			id = tempTuber.getId();
		}else{
			timeForStart = new Timestamp(System.currentTimeMillis());
			String disNo = data.getDistrictNumber();
			id = getTuberId(disNo);
			Tuberculosis tuber = new Tuberculosis();
			BeanUtils.copyProperties(data, tuber);
			tuber.setId(id);
			tuber.setTimeForStart(timeForStart);
			getHibernateTemplate().save(tuber);
			
			log.debug("save Tuberculosis information succeed");
		}
		TuberSuperDetail tuberDetail = new TuberSuperDetail();
		BeanUtils.copyProperties(data, tuberDetail);
		tuberDetail.setBaseId(id);
		
		getHibernateTemplate().save(tuberDetail);
		
		log.debug("save TuberSuperDetail information succeed");
		return String.valueOf(tuberDetail.getId());
	}
	
	/**
	 * 获得结核病管理编号
	 * @param disNo
	 * @return
	 */
	private String getTuberId(String disNo){
		String getIdSql = "from Tuberculosis where id like '" + disNo + "%'";
		List getIdList = OptDatabse(getIdSql);
		String id = "";
		if(getIdList.size() > 0){
			int maxSuffixId = 0;
			for(Object objs : getIdList){
				Tuberculosis tempTuber = (Tuberculosis)objs;
				id = tempTuber.getId();
				String suffixId = id.substring(id.indexOf(disNo) + disNo.length(), id.length());
				int tempId = Integer.parseInt(suffixId);
				if(maxSuffixId < tempId)
					maxSuffixId = tempId;
			}
			int tmpSuffixId = maxSuffixId + 1;
			String maxStr = tmpSuffixId + "";
			if(maxStr.length() == 1){
				maxStr = "000" + maxStr;
			}else if(maxStr.length() == 2){
				maxStr = "00" + maxStr;
			}else if(maxStr.length() == 3){
				maxStr = "00" + maxStr;
			}
			id = disNo + maxStr;
		}else{
			id = disNo + "0001";
		}
		return id;
	}
	
	/**
	 * 获得结核病人的基本信息和督导记录
	 * @param id
	 * @return
	 */
	public Map<String, Object> get(String id){
		String baseSql = "from Tuberculosis a where a.id = '" + id + "'";
		String detailSql = "from TuberSuperDetail b where b.baseId = '" + id + "' order by b.timeForSupervise ASC";
		List baseList = OptDatabse(baseSql);
		Tuberculosis baseTuber = (Tuberculosis)baseList.get(0);
		Map<String, Object> baseMap = new HashMap<String, Object>();
		baseMap.put("baseTuber", baseTuber);
		
		List detailList = OptDatabse(detailSql);
		baseMap.put("detailTuber", detailList);
		
		return baseMap;
	}
	
	/**
	 * 更新结核病人的基本信息
	 * @param id
	 * @param data
	 * @return
	 */
	public String updateTuberInfo(String id,TuberculosisBO data){
		Tuberculosis tuber = (Tuberculosis)getHibernateTemplate().get(Tuberculosis.class, id);
		BeanUtils.copyProperties(data, tuber,new String[]{"districtNumber"});
		getHibernateTemplate().update(tuber);
		return "SUCCESS";
	}
	
	/**
	 * 更新结核病人的督导记录
	 * @param id
	 * @param data
	 * @return
	 */
	public String updateTuberDetailInfo(int id,TuberculosisBO data){
		TuberSuperDetail tuberDetail = (TuberSuperDetail)getHibernateTemplate().get(TuberSuperDetail.class, id);
		BeanUtils.copyProperties(data, tuberDetail);
		getHibernateTemplate().update(tuberDetail);
		return "SUCCESS";
	}
	
	/**
	 * 删除督导记录
	 * @param id
	 * @return
	 */
	public String deleteDetailInfo(int id){
		TuberSuperDetail tuberDetail = (TuberSuperDetail)getHibernateTemplate().get(TuberSuperDetail.class, id);
		getHibernateTemplate().delete(tuberDetail);
		return "SUCCESS";
	}
}
