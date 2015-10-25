package com.ichunming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.bean.User;
import com.ichunming.service.IUserService;

@Controller
@RequestMapping("/blog")
public class TestController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.getAllUser();
		if(null != users) {
			for(User user : users) {
				user.print();
			}
		}
		return "index";
	}
}
