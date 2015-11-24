/**
 * 菜单活动项过滤器
 * 2015/10/29 chunming
 */
package com.ichunming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ichunming.consts.AppConst;

/**
 * Servlet Filter implementation class MenuFilter
 */
@WebFilter("/MenuFilter")
public class MenuFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MenuFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		int currentNav = 0;
		HttpServletRequest hRequest = (HttpServletRequest)request;
		// URL
		String URL = hRequest.getRequestURI();
		
		if(URL.contains("home")) {
			// index
			currentNav = AppConst.MENU_INDEX;
		} else if (URL.contains("learn")) {
			// learn
			currentNav = AppConst.MENU_LEARN;
		} else if(URL.contains("life")) {
			// life
			currentNav = AppConst.MENU_LIFE;
		} else if(URL.contains("about")) {
			// about
			currentNav = AppConst.MENU_ABOUT;
		}
		
		// 保存currentNav
		hRequest.getSession().setAttribute("currentNav", currentNav);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
