package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.web.service.bo.MedicalExamBO;


public class MedicalExamService extends HealthMainService<MedicalExamBO> {

	@Override
	public String save(MedicalExamBO data) throws Exception {
		String fileNo = EncryptionUtils.encry(data.getFileNo());
		Timestamp examDate = data.getExamDate();
		
		if ( fileNo != null && examDate != null ) {
			List<PersonalInfo> list = getHibernateTemplate().find("from PersonalInfo where fileNo = ?", fileNo);
			PersonalInfo p =  null;
			if ( list.size() > 0 ) p = list.get(0);
			if ( p != null) {
				Timestamp birthday = p.getBirthday();
				if ( birthday != null ) {
					year(birthday);
					int birthYear = year(birthday);
					int examYear = year(examDate);
					int age = examYear - birthYear;
					if ( age > 0 ) data.setAge(age);
				}
			}
		}
		data.setFileNo(fileNo);
		TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
		data.setExecDistrictNum(user.getDistrictId());
		return save_(data);
	}

	@Override
	public Object get(MedicalExamBO data) throws Exception {
		data = (MedicalExamBO)get_(data);
		data.setFileNo(EncryptionUtils.decipher(data.getFileNo()));
		return data;
	}

	private int year(Timestamp ts) {
		Calendar birth = Calendar.getInstance();
		birth.setTimeInMillis(ts.getTime());
		return birth.get(Calendar.YEAR);
	}


}
