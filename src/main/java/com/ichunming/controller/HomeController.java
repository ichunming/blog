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
import com.ichunming.consts.BizConst;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IPostService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IPostService homeService;
	
	@RequestMapping("home")
	public String index(Model model) {
		// 分页对象
		Page page = new Page();
		// 文章总条数
		page.setTotalNumber(homeService.findTotalNumber());
		// 当前页数
		page.setCurrentPage(1);
		// 每页数量
		page.setPageNumber(BizConst.HOME_PAGE_POST_COUNT);
		// 分页计算
		page.count();
		
		// 取得文章
		List<Post> postList = homeService.findPosts(page);
		// 保存取得结果
		model.addAttribute(postList);
		// 返回页面
		return "home/index";
	}
}
