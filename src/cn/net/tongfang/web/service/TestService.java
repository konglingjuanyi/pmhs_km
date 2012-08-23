package cn.net.tongfang.web.service;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TestService extends HibernateDaoSupport {
	public String get(){
		return "jack";
	}
}
