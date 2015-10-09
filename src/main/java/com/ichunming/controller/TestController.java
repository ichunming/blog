package com.ichunming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.service.IUserService;

@Controller
@RequestMapping("/ichunming")
public class TestController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/test")
	public String viewCourse(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello chunming");
		return "index";
	}
}
