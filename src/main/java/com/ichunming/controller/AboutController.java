/**
 * about controller
 * 2015/10/29 chunming
 */
package com.ichunming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.bean.About;
import com.ichunming.common.MessageManager;
import com.ichunming.entity.CustomInfo;
import com.ichunming.iservice.IAboutService;

@Controller
@RequestMapping("/")
public class AboutController {
	
	@Autowired
	private IAboutService aboutService;
	
	@RequestMapping("about")
	public String about(Model model) {
		// 数据取得
		List<About> aboutList = aboutService.findAllAbouts();
		// check
		if(null == aboutList || aboutList.size() < 1) {
			// error信息
			CustomInfo info = MessageManager.findWarnMsg("WAB001");
			model.addAttribute("info", info);
		}else {
			// 保存取得结果
			model.addAttribute("aboutList", aboutList);
		}
		return "about/index";
	}
}
