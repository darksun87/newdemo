package com.crm.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 请求过滤器
 * @author 黄思旭 IPET006
 */
public class RequestFilter implements Filter {
	
	private String excludedPages;       
	private String[] excludedPageArray = new String[0]; 

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();
		
		boolean isExcludedPage = false;     
		for (String page : excludedPageArray) {//判断是否在过滤url之外     
			if(((HttpServletRequest) request).getServletPath().equals(page)){     
				isExcludedPage = true;     
				break;     
			}     
		} 
		if (isExcludedPage) {
			chain.doFilter(request, response);			
		}else{
			if (session.getAttribute("user") == null) {
				request.getRequestDispatcher("/login.html").forward(request, response);				
			}else{
				chain.doFilter(request, response);				
			}
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException { 
		excludedPages = fConfig.getInitParameter("excludedPages");     
		if (excludedPages!=null&&!excludedPages.equals("")) {     
			excludedPageArray = excludedPages.split(",");     
		}
	}

}