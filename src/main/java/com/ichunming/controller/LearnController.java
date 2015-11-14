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
import com.ichunming.common.MessageManager;
import com.ichunming.consts.AppConst;
import com.ichunming.entity.Article;
import com.ichunming.entity.CustomError;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IPostService;

@Controller
@RequestMapping("/")
public class LearnController {
	@Autowired
	private IPostService postService;
	
	@RequestMapping("learn")
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
		return "learn/index";
	}

	@RequestMapping("learn/article")
	public String article(HttpServletRequest request, Model model) {
		// 返回值
		Article article = null;
		List<Post> postList = null;
		
		// 获取参数
		String postIdStr = request.getParameter("postId");
		Integer postId = null;
		if(null != postIdStr) {
			try {
				postId = Integer.parseInt(postIdStr);
			} catch(Exception e) {
				postId = null;
			}
		}

		// 参数check
		if(null == postId) {
			CustomError error = errorProc();
			model.addAttribute("error", error);
			return "learn/article";
		}
		
		// 取得文章
		postList = postService.findPostsById(postId);
		// 取得值check
		if(null == postList || 0 == postList.size() || (1 == postList.size() && postId != postList.get(0).getId())) {
			CustomError error = errorProc();
			model.addAttribute("error", error);
			return "learn/article";
		}
		// 设定返回值
		article = new Article();
		for(Post post : postList) {
			if(post.getId() == postId) {
				article.setPost(post);
			}else if(post.getId() < postId) {
				article.setPreId(post.getId());
				article.setPreTitle(post.getTitle());
			}else {
				article.setNextId(post.getId());
				article.setNextTitle(post.getTitle());
			}
		}
		// 保存取得结果
		model.addAttribute("article", article);
		// 返回页面
		return "learn/article";
	}
	
	private CustomError errorProc() {
		CustomError error = new CustomError();
		error.setCode(AppConst.CODE_WARING);
		error.setMessage(MessageManager.findMessage("W001"));
		
		return error;
	}
}
