/**
 * temp controller
 * 2015/12/02 chunming
 */
package com.ichunming.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.common.BlockManager;

@Controller
@RequestMapping("/")
public class TempController {
	
	@RequestMapping("temp")
	public String temp(HttpServletRequest request) {
		// block更新
		BlockManager blockManager = (BlockManager)request.getServletContext().getAttribute("blockManager");
		blockManager.update();
		request.getServletContext().setAttribute("blockManager", blockManager);
		// 跳转HomeController
		return "redirect:/";
	}
}
