package com.spendit.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class HSTSFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletResponse resp = (HttpServletResponse) arg1;
	        resp.setHeader("Strict-Transport-Security", "max-age=31622400; includeSubDomains");
	       

	        arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
