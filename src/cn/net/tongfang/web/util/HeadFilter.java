package cn.net.tongfang.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class HeadFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		if(request.getContentType() !=null && request.getContentType().equals("text/plain")){
			HttpServletResponse rep = (HttpServletResponse) response;
			rep.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
			rep.setHeader("Pragrma", "no-cache");
			rep.setDateHeader("Expires", 0);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
    
	
}