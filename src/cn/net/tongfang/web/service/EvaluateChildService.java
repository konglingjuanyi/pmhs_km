package cn.net.tongfang.web.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.security.vo.ChildrenHeightWeight;
import cn.net.tongfang.framework.security.vo.ChildrenStandardHeight;
import cn.net.tongfang.framework.security.vo.ChildrenStandardWeight;
import cn.net.tongfang.framework.security.vo.PersonalInfo;
import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;

public class EvaluateChildService extends HibernateDaoSupport {
	private static final String ITEM_WEIGHT = "weight";
	private static final String ITEM_HEIGHT = "height";
	
	private static final Integer EVALUATE_ERROR = -1;//错误
	private static final Integer EVALUATE_A1S = 1;//上
	private static final Integer EVALUATE_A2S = 2;//中上
	private static final Integer EVALUATE_A3S = 3;//中+
	private static final Integer EVALUATE_B1S = 4;//中-
	private static final Integer EVALUATE_B2S = 5;//中下
	private static final Integer EVALUATE_B3S = 6;//下
	
	private static final String NORMAL = "正常";
	private static final String ERROR01 = "消瘦（急性近期营养不良）";
	private static final String ERROR02 = "发育迟缓（过去慢性营养不良）";
	private static final String ERROR03 = "严重慢性营养不良（过去目前营养均差）";
	
	
	public Integer getEvaluateResult(String fileNo,String evaluateItem,Double val){
		String hql = "";
		String sex = "";
		Integer age = -1;
		fileNo = EncryptionUtils.encry(fileNo);
		List list = getHibernateTemplate().find("From PersonalInfo Where fileNo = ?", fileNo);
		if(list.size() > 0){
			PersonalInfo person = (PersonalInfo)list.get(0);
			Timestamp birthday = person.getBirthday();
			sex = person.getSex();
			age = getAge(birthday);
		}else{
			return EVALUATE_ERROR;
		}
		Double b2s = -1.0;
		Double b1s = -1.0;
		Double av = -1.0;
		Double a1s = -1.0;
		Double a2s = -1.0;
		if(evaluateItem.equals(ITEM_WEIGHT)){
			hql = "From ChildrenStandardWeight Where sex = ? And minMonth <= ? And maxMonth > ?";
			Query query = getSession().createQuery(hql);
			query.setParameter(0, sex);
			query.setParameter(1, age);
			query.setParameter(2, age);
			List l = query.list();
			if (l.size() > 0) {
				ChildrenStandardWeight evaluate = (ChildrenStandardWeight) l.get(0);
				b2s = evaluate.getSub2s();
				b1s = evaluate.getSub1s();
				av = evaluate.getAvg();
				a1s = evaluate.getAdd1s();
				a2s = evaluate.getAdd2s();
			}else{
				return EVALUATE_ERROR;
			}
		} else if (evaluateItem.equals(ITEM_HEIGHT)) {
			hql = "From ChildrenStandardHeight Where sex = ? And minMonth <= ? And maxMonth > ?";
			Query query = getSession().createQuery(hql);
			query.setParameter(0, sex);
			query.setParameter(1, age);
			query.setParameter(2, age);
			List l = query.list();
			if (l.size() > 0) {
				ChildrenStandardHeight evaluate = (ChildrenStandardHeight) l.get(0);
				b2s = evaluate.getSub2s();
				b1s = evaluate.getSub1s();
				av = evaluate.getAvg();
				a1s = evaluate.getAdd1s();
				a2s = evaluate.getAdd2s();
			}else{
				return EVALUATE_ERROR;
			}
		}
		if(val.compareTo(a2s) >= 0){
			return EVALUATE_A1S;
		}else if(val.compareTo(a2s) < 0 && val.compareTo(a1s) >= 0){
			return EVALUATE_A2S;
		}else if(val.compareTo(a1s) < 0 && val.compareTo(av) >= 0){
			return EVALUATE_A3S;
		}else if(val.compareTo(av) < 0 && val.compareTo(b1s) >= 0){
			return EVALUATE_B1S;
		}else if(val.compareTo(b1s) < 0 && val.compareTo(b2s) >= 0){
			return EVALUATE_B2S;
		}else if(val.compareTo(b2s) < 0){
			return EVALUATE_B3S;
		}
		return EVALUATE_ERROR;
	}
	
	public String getEvaluateChild(String fileNo,Double height,Double weight){
		String sex = "";
		String hql = "";
		fileNo = EncryptionUtils.encry(fileNo);
		List list = getHibernateTemplate().find("From PersonalInfo Where fileNo = ?", fileNo);
		if(list.size() > 0){
			PersonalInfo person = (PersonalInfo)list.get(0);
			sex = person.getSex();
		}else{
			return null;
		}
		
		Integer _2sd = getEvaluateResult(EncryptionUtils.decipher(fileNo),"height",height);
		
		if(height >= 131)
			height = 130.0;	
		hql = "From ChildrenHeightWeight Where sex = ? And height = Floor(?)";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, sex);
		query.setParameter(1, height);
		List l = query.list();
		if(l.size() > 0){
			ChildrenHeightWeight childrenHeightWeight = (ChildrenHeightWeight) l.get(0);
			if(_2sd == 2){
				if (childrenHeightWeight.getSub2s() > weight) {
					return ERROR03;
				} else {
					return ERROR02;
				}
			}else{
				if (childrenHeightWeight.getSub2s() > weight) {
					return ERROR01;
				} else {
					return NORMAL;
				}
			}
		}
		return null;
	}
	
	private Integer getAge(Timestamp birthday){
		Calendar cal = Calendar.getInstance();
		Calendar birth = CommonConvertUtils.timestampToCalendar(birthday);
		return ((cal.get(1) - birth.get(1)) * 12 + (cal.get(2) - birth.get(2)));
	}
}
