package cn.net.tongfang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.net.tongfang.framework.security.demo.service.SimpleService;

public class HelloTest extends javax.servlet.http.HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req,resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		SimpleService u = (SimpleService)ctx.getBean("HelloService");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		System.out.println(u.sayHello());
		out.println(u.sayHello());
		
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
		super.init();
	}

}
