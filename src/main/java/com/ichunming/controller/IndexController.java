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
import com.ichunming.entity.Page;
import com.ichunming.iservice.IPostService;

@Controller
@RequestMapping("blog")
public class IndexController {
	@Autowired
	private IPostService indexService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		// 分页对象
		Page page = new Page();
		// 文章总条数
		page.setTotalNumber(indexService.findTotalNumber());
		// 当前页数
		page.setCurrentPage(1);
		// 分页计算
		page.count();
		
		// 取得文章
		List<Post> postList = indexService.findPosts(page);
		// 保存取得结果
		model.addAttribute(postList);
		// 返回页面
		return "index/index";
	}
}
