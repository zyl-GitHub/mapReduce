package com.zhao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AFilter
 */
@WebFilter("/*")
public class AFilter implements Filter {

    public AFilter() {
        
    }
	public void destroy() 
	{
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		System.out.println("拦截你");
		chain.doFilter(request, response);
		System.out.println("又见面了");
	}
	public void init(FilterConfig fConfig) throws ServletException 
	{

	}

}
