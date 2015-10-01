package com.ichunming.controller;

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
	public String viewCourse() {
		System.out.println("Hello chunming");
		return "index";
	}
}
