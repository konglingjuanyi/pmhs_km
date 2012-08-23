package cn.net.tongfang.web.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.net.tongfang.framework.util.CommonConvertUtils;
import cn.net.tongfang.framework.util.EncryptionUtils;
import cn.net.tongfang.framework.util.service.GenDefaultVal;
import cn.net.tongfang.web.service.bo.PagedList;

public class FileNumSearch extends HibernateDaoSupport{
	static int pageSize = 10;
	public  PagedList listCodePage(int pageNo, String mcode, boolean startWith,String condVal,String isWomanRecord){
    	String likePrefix = startWith ? "" : "%";
    	System.out.println("prefix is " + likePrefix);
    	System.out.println("mcode is " + mcode);
    	PagedList res = new PagedList();
    	String hqlWoman = "";
    	if(isWomanRecord != null && !isWomanRecord.equals("")){
    		hqlWoman = " And p.sex = '女'";
    	}
    	if(condVal.equals("1")){
    		likePrefix = likePrefix.replace("%", "");
    		mcode = mcode.replace("%", "");
    		String fileNo = EncryptionUtils.encry(likePrefix + mcode);
    		long count = (Long)getHibernateTemplate().find("select count(*) from HealthFile hf,PersonalInfo p " +
        			"where hf.fileNo = p.fileNo And substring(hf.fileNo,1," + fileNo.length() + ") = ?" + hqlWoman,fileNo).get(0);
        	System.out.println("total line is : " + count);
        	res.totalLines = count;
        	res.pageSize = pageSize;
        	res.totalPages = (int) (count / pageSize) + ((count % pageSize > 0) ? 1 : 0);
        	int from = pageNo * pageSize;
        	Query qry = getSession().createQuery("select hf.fileNo, hf.name, p.sex, p.birthday,(year(getDate()) - year(p.birthday)) as age," +
        			" p.idnumber,hf.barCode,hf.address from HealthFile as hf, PersonalInfo as p " +
        			"where p.fileNo = hf.fileNo " +
        			"and substring(p.fileNo,1," + fileNo.length() + ") = ?" + hqlWoman);
        	qry.setParameter(0, fileNo);
        	qry.setMaxResults(pageSize);
        	qry.setFirstResult(from);
        	List list = qry.list();
        	System.out.println("res line is : " + list.size());
        	res.res = parseResult(list);
        	res.currentPage = pageNo + 1;
    	}else if(condVal.equals("2")){
    		String[] mcodes = mcode.split("%");
    		String districtNumber = "";
    		String otherCond = "";
    		if(mcodes.length > 1){
    			districtNumber = mcodes[0];
    			otherCond = mcodes[1];
    		}else{
    			otherCond = mcodes[0];
    		}
    		
    		Query qry = getSession().createQuery("select count(*) from HealthFile hf,PersonalInfo p " +
        			"where hf.fileNo = p.fileNo And substring(hf.districtNumber,1," + districtNumber.length() + ") = ? " +
        			"And substring(hf.name,1," + otherCond.length() + ") = ?" +  hqlWoman);
    		qry.setParameter(0, districtNumber);
        	qry.setParameter(1, EncryptionUtils.encry(otherCond));
    		long count = (Long)qry.list().get(0);
        	System.out.println("total line is : " + count);
        	res.totalLines = count;
        	res.pageSize = pageSize;
        	res.totalPages = (int) (count / pageSize) + ((count % pageSize > 0) ? 1 : 0);
        	int from = pageNo * pageSize;
        	qry = getSession().createQuery("select hf.fileNo, hf.name, p.sex, p.birthday,(year(getDate()) - year(p.birthday)) as age," +
        			" p.idnumber,hf.barCode,hf.address  from HealthFile as hf, PersonalInfo as p " +
        			"where p.fileNo = hf.fileNo and substring(hf.districtNumber,1," + 
        			districtNumber.length() + ") = ? " +
        			"And substring(hf.name,1," + otherCond.length() + ") = ? " + hqlWoman);
        	qry.setParameter(0, districtNumber);
        	qry.setParameter(1, EncryptionUtils.encry(otherCond));
        	qry.setMaxResults(pageSize);
        	qry.setFirstResult(from);
        	List list = qry.list();
        	System.out.println("res line is : " + list.size());
        	res.res = parseResult(list);
        	res.currentPage = pageNo + 1;
    	}else if(condVal.equals("3")){
    		String[] mcodes = mcode.split("%");
    		String districtNumber = "";
    		String otherCond = "";
    		if(mcodes.length > 1){
    			districtNumber = mcodes[0];
    			otherCond = mcodes[1];
    		}else{
    			otherCond = mcodes[0];
    		}
    		Query qry = getSession().createQuery("select count(*) from HealthFile hf , PersonalInfo as p " +
        			"where p.fileNo = hf.fileNo And substring(hf.districtNumber,1," + districtNumber.length() +
        			") = ? And substring(p.idnumber,1," + otherCond.length() + ") = ? " + hqlWoman);
    		qry.setParameter(0, districtNumber);
        	qry.setParameter(1, EncryptionUtils.encry(otherCond));
    		long count = (Long)qry.list().get(0);
        	System.out.println("total line is : " + count);
        	res.totalLines = count;
        	res.pageSize = pageSize;
        	res.totalPages = (int) (count / pageSize) + ((count % pageSize > 0) ? 1 : 0);
        	int from = pageNo * pageSize;
        	qry = getSession().createQuery("select hf.fileNo, hf.name, p.sex, p.birthday,(year(getDate()) - year(p.birthday)) as age," +
        			" p.idnumber,hf.barCode,hf.address  from HealthFile as hf, PersonalInfo as p " +
        			"where substring(hf.districtNumber,1," + districtNumber.length() + ") = ? " +
        			"And substring(p.idnumber,1," + otherCond.length() + ") = ?  And hf.fileNo = p.fileNo " + hqlWoman);
        	qry.setParameter(0, districtNumber);
        	qry.setParameter(1, EncryptionUtils.encry(otherCond));
        	qry.setMaxResults(pageSize);
        	qry.setFirstResult(from);
        	List list = qry.list();
        	System.out.println("res line is : " + list.size());
        	res.res = parseResult(list);
        	res.currentPage = pageNo + 1;
    	}else if(condVal.equals("0")){
    		String[] mcodes = mcode.split("%");
//    		String districtNumber = mcodes[0];
    		String otherCond = mcodes[0];
    		if(mcodes.length > 1){
    			otherCond = mcodes[1];
    		}
    		Query qry = getSession().createQuery("select count(*) from HealthFile hf , PersonalInfo as p " +
        			"where p.fileNo = hf.fileNo And substring(hf.barCode,1," + otherCond.length() + ") = ? " + hqlWoman);
//    		qry.setParameter(0, districtNumber + "%");
        	qry.setParameter(0, otherCond);
    		long count = (Long)qry.list().get(0);
        	System.out.println("total line is : " + count);
        	res.totalLines = count;
        	res.pageSize = pageSize;
        	res.totalPages = (int) (count / pageSize) + ((count % pageSize > 0) ? 1 : 0);
        	int from = pageNo * pageSize;
        	qry = getSession().createQuery("select hf.fileNo, hf.name, p.sex, p.birthday,(year(getDate()) - year(p.birthday)) as age," +
        			" p.idnumber,hf.barCode,hf.address from HealthFile as hf, PersonalInfo as p " +
        			"where p.fileNo = hf.fileNo " +
        			"And substring(hf.barCode,1," + otherCond.length() + ") = ? " + hqlWoman);
//        	qry.setParameter(0, districtNumber + "%");
        	qry.setParameter(0, otherCond);
        	qry.setMaxResults(pageSize);
        	qry.setFirstResult(from);
        	List list = qry.list();
        	System.out.println("res line is : " + list.size());
        	res.res = parseResult(list);
        	res.currentPage = pageNo + 1;
    	}
    	return res;
    	
    }
    public  List getItem(String code){
		List list = getHibernateTemplate().find("select hf.fileNo, hf.name, p.sex, p.birthday,(year(getDate()) - year(p.birthday)) as age," +
    			" p.idnumber,hf.barCode" +
    			" from HealthFile as hf, PersonalInfo as p " +
    			"where p.fileNo = hf.fileNo " +
    			"and p.fileNo = ?", EncryptionUtils.encry(code));
    	
    	return parseResult(list);

    }
    /**
     * 解释List
     * @param list
     * @return
     */
    private List parseResult(List list){
    	List arrayList = new ArrayList();
    	String sql = "";
    	Query query = null;
    	List l;
    	if(list.size() > 0){
    		for(int i = 0;i < list.size();i++){
    			Object[] obj = (Object[])list.get(i);
    			Object[] objArray = new Object[10];
    			String name = (String)obj[1];
        		obj[1] = EncryptionUtils.decipher(name);
        		String idNum = (String)obj[5];
        		obj[5] = EncryptionUtils.decipher(idNum);
        		String str = (String)obj[0];
        		sql = "Select general11 From MedicalExam Where fileNo = '" + str + "' Order By inputDate";
        		query = getSession().createQuery(sql);
        		l = query.list();
        		if(l.size() > 0){
        			Object o = l.get(0);
        			if(o != null){
	        			BigDecimal general11 = (BigDecimal)o;
	        			general11 = general11.setScale(2, BigDecimal.ROUND_HALF_UP);
	        			objArray[6] = general11;
        			}else{
        				objArray[6] = 0;
        			}
        		}else{
        			objArray[6] = 0;
        		}
        		obj[0] = EncryptionUtils.decipher(str);
        		for(int j = 0;j<obj.length;j++){
        			objArray[j] = obj[j]; 
        		}
        		arrayList.add(objArray);
    		}
    	}
    	return arrayList;
    }
    
    public boolean districtIdIsExists(String disId){
    	String hql = "From District Where id = ?";
    	Query query = getSession().createQuery(hql);
    	query.setParameter(0, disId);
    	List list = query.list();
    	if(list.size() > 0)
    		return true;
    	return false;
    }
}
