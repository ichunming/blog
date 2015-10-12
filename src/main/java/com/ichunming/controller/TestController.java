package com.ichunming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.service.IUserService;

@Controller
@RequestMapping("/blog")
public class TestController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/test")
	public String viewCourse(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getContextPath());
		System.out.println(request.getRealPath("/"));
		System.out.println(request.getPathInfo());
		System.out.println(request.getPathTranslated());
		System.out.println(request.getServletPath());
		System.out.println(request.getSession().getServletContext().getContextPath());
		System.out.println(request.getServletContext().getContext("/").getContextPath());
		System.out.println(request.getServletContext().getContext("/").getRealPath("/"));
		System.out.println(request.getServletContext().getContext("/").getContext("/").getContextPath());
		System.out.println(request.getServletContext().getContextPath());
		System.out.println(request.getServletContext().getRealPath("/"));
		return "index";
	}
}
