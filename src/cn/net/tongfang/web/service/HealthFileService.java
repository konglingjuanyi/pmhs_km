package cn.net.tongfang.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.Opshistory;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.security.vo.TraumaHistory;
import cn.net.tongfang.web.service.bo.HealthFileBO;

public class HealthFileService extends HibernateDaoSupport {
	private static final Logger log = Logger.getLogger(HealthFileService.class);

	public PersonalInfo save(HealthFileBO data) {

		PersonalInfo info = new PersonalInfo();

		BeanUtils.copyProperties(data, info); // spring beanutils

		String testFileNo = java.util.UUID.randomUUID().toString();
		if (testFileNo.length() > 20) {
			testFileNo = testFileNo.substring(0, 19);
		}
		
		info.setFileNo(testFileNo);
		info.setFileNoSub(testFileNo.substring(testFileNo.length() - 7));
		info.setInputDate(new java.sql.Timestamp(System.currentTimeMillis()));
		//info.setInputPersonId(1);
		getHibernateTemplate().saveOrUpdate(info);

		for (Opshistory ops : data.opshistory) {
			ops.setPersonalInfoId(info.getId());
		}

		for (TraumaHistory ops : data.traumaHistory) {
			ops.setPersonalInfoId(info.getId());
		}

		getHibernateTemplate().saveOrUpdateAll(data.opshistory);
		getHibernateTemplate().saveOrUpdateAll(data.traumaHistory);
		return info;
	}
	public HealthFileBO get(String id) {
		return null;
	}

}
