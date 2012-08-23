package cn.net.tongfang.framework.security.demo.service.vo;

import java.util.Map;

public class XnhAccountVO {
	private String name ;
	private String sex ;
	private String idcard ;
	private String type ;
	private String birthday ;
	private String connect ;
	private String personno ;
	private String personmdno ;
	private String familycardno ;
	private String firstdate ;
	private String mdcardno ;
	private String relation ;
	private String mdlevel ;
	private String marrystate ;
	private String money1 ;
	private String count ;
	private String money2 ;
	private String money3 ;
	private String money4 ;
	private String money5 ;
	private String money6 ;
	private String money7 ;
	private String money8 ;
	private String money9 ;
	
	public XnhAccountVO (Map param){
		this.name = (String)param.get("name");
		this.sex = (String)param.get("sex");
		this.idcard = (String)param.get("idcard");
		this.type = (String)param.get("type");
		this.birthday = (String)param.get("birthday");
		this.connect = (String)param.get("connect");
		this.personno  = (String)param.get("personno");
		this.personmdno  = (String)param.get("personmdno");
		this.familycardno  = (String)param.get("familycardno");
		this.firstdate  = (String)param.get("firstdate");
		this.mdcardno  = (String)param.get("mdcardno");
		this.relation  = (String)param.get("relation");
		this.mdlevel  = (String)param.get("mdlevel");
		this.marrystate  = (String)param.get("marrystate");
		this.money1  = (String)param.get("money1");
		this.count  = (String)param.get("count");
		this.money2  = (String)param.get("money2");
		this.money3  = (String)param.get("money3");
		this.money4  = (String)param.get("money4");
		this.money5  = (String)param.get("money5");
		this.money6  = (String)param.get("money6");
		this.money7  = (String)param.get("money7");
		this.money8  = (String)param.get("money8");
		this.money9  = (String)param.get("money9");
	}
	public String getFamilycardno() {
		return familycardno;
	}
	public String getPersonmdno() {
		return personmdno;
	}
	public void setPersonmdno(String personmdno) {
		this.personmdno = personmdno;
	}
	public String getFirstdate() {
		return firstdate;
	}
	public void setFirstdate(String firstdate) {
		this.firstdate = firstdate;
	}
	public String getMdcardno() {
		return mdcardno;
	}
	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getMdlevel() {
		return mdlevel;
	}
	public void setMdlevel(String mdlevel) {
		this.mdlevel = mdlevel;
	}
	public String getMoney1() {
		return money1;
	}
	public void setMoney1(String money1) {
		this.money1 = money1;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMoney2() {
		return money2;
	}
	public void setMoney2(String money2) {
		this.money2 = money2;
	}
	public String getMoney3() {
		return money3;
	}
	public void setMoney3(String money3) {
		this.money3 = money3;
	}
	public String getMoney4() {
		return money4;
	}
	public void setMoney4(String money4) {
		this.money4 = money4;
	}
	public String getMoney5() {
		return money5;
	}
	public void setMoney5(String money5) {
		this.money5 = money5;
	}
	public String getMoney6() {
		return money6;
	}
	public void setMoney6(String money6) {
		this.money6 = money6;
	}
	public String getMoney7() {
		return money7;
	}
	public void setMoney7(String money7) {
		this.money7 = money7;
	}
	public String getMoney8() {
		return money8;
	}
	public void setMoney8(String money8) {
		this.money8 = money8;
	}
	public String getMoney9() {
		return money9;
	}
	public void setMoney9(String money9) {
		this.money9 = money9;
	}
	public void setFamilycardno(String familycardno) {
		this.familycardno = familycardno;
	}
	public String getPersonno() {
		return personno;
	}
	public void setPersonno(String personno) {
		this.personno = personno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMarrystate() {
		return marrystate;
	}
	public void setMarrystate(String marrystate) {
		this.marrystate = marrystate;
	}
	public String getConnect() {
		return connect;
	}
	public void setConnect(String connect) {
		this.connect = connect;
	}
	
}
