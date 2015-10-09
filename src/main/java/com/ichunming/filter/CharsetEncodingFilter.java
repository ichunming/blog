/**
 * charset encoding filter
 * 2015/10/06
 * chunming
 */
package com.ichunming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharsetEncodingFilter
 */
public class CharsetEncodingFilter implements Filter {
	
	private String encodeString;
	
    /**
     * Default constructor. 
     */
    public CharsetEncodingFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encodeString);
		response.setCharacterEncoding(encodeString);
		response.setContentType("text/hmtl;charset=" + encodeString);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encodeString=fConfig.getInitParameter("encoding");
		if(null == encodeString || "".equals(encodeString)) {
			encodeString = "utf-8";
		}
	}

}
