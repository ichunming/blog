/**
 * 菜单活动项过滤器
 * 2015/10/29 chunming
 */
package com.ichunming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ichunming.consts.AppConst;
import com.ichunming.entity.MenuManager;

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
		
		HttpServletRequest hRequest = (HttpServletRequest)request;
		// URL
		String URL = hRequest.getRequestURI();
		// 取得menu
		ServletContext servletContext = request.getServletContext();
		MenuManager menuManager = (MenuManager)servletContext.getAttribute("menuManager");
		if(URL.contains("index")) {
			// index
			menuManager.setCurrentNav(AppConst.MENU_INDEX);
		} else if (URL.contains("learn")) {
			// learn
			menuManager.setCurrentNav(AppConst.MENU_LEARN);
		} else if(URL.contains("life")) {
			// life
			menuManager.setCurrentNav(AppConst.MENU_LIFE);
		} else if(URL.contains("about")) {
			// about
			menuManager.setCurrentNav(AppConst.MENU_ABOUT);
		}
		
		// 保存menu
		servletContext.setAttribute("menuManager", menuManager);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
