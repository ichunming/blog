/**
 * life controller
 * 2015/10/29 chunming
 */
package com.ichunming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class LifeController {
	
	@RequestMapping("/life")
	public String life(Model model) {
		return "life/life";
	}
}
