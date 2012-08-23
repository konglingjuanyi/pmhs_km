package cn.net.tongfang.framework.security.demo.service;

import org.springframework.security.annotation.Secured;



public class SimpleServiceImpl implements SimpleService{

	
	public String sayHello() {
		return "Hello";
	}
	
}
