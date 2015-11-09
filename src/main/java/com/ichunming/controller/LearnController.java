/**
 * learn contrller
 * 2015/10/29 chunming
 */
package com.ichunming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.bean.Post;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IPostService;

@Controller
@RequestMapping("blog")
public class LearnController {
	@Autowired
	private IPostService postService;
	
	@RequestMapping("/learn")
	public String learn(HttpServletRequest request, Model model) {
		// 获取参数
		String curPageStr = request.getParameter("currentPage");
		int currentPage;
		if(null == curPageStr) {
			currentPage = 1;
		}else {
			try {
				currentPage = Integer.parseInt(curPageStr);
			} catch(Exception e) {
				currentPage = 1;
			}
		}
		// 分页对象
		Page page = new Page();
		// 文章总条数
		page.setTotalNumber(postService.findTotalNumber());
		// 当前页数
		page.setCurrentPage(currentPage);
		// 分页计算
		page.count();
		
		// 取得文章
		List<Post> postList = postService.findPosts(page);
		// 保存取得结果
		model.addAttribute(postList);
		// 保存分页对象
		model.addAttribute(page);
		// 返回页面
		return "learn/learn";
	}
}
