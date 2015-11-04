/**
 * index controller
 * 2015/10/29 chunming
 */
package com.ichunming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.bean.Post;
import com.ichunming.iservice.IPostService;

@Controller
@RequestMapping("blog")
public class IndexController {
	@Autowired
	private IPostService indexService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		// 取得最新文章
		List<Post> postList = indexService.findNewestPosts();
		// 保存取得结果
		model.addAttribute(postList);
		// 返回页面
		return "index/index";
	}
}
