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
import com.ichunming.bean.Tag;
import com.ichunming.common.MessageManager;
import com.ichunming.entity.Article;
import com.ichunming.entity.CustomInfo;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IPostService;
import com.ichunming.iservice.ITagService;

@Controller
@RequestMapping("/")
public class LearnController {
	@Autowired
	private IPostService postService;
	
	@Autowired
	private ITagService tagService;
	
	@RequestMapping("learn")
	public String learn(HttpServletRequest request, Model model) {
		// 获取参数
		String curPageStr = request.getParameter("currentPage");
		String recommend = request.getParameter("recommend");
		// 分页处理 所有文章
		Page page = pageProc(curPageStr, recommend);
		
		// 取得文章
		List<Post> postList = postService.findPosts(page);
		// 取得结果check
		if(null == postList || postList.size() < 1) {
			// 信息
			CustomInfo info = MessageManager.findWarnMsg("ILE001");
			model.addAttribute("info", info);
		}
		
		// 保存取得结果
		model.addAttribute("postList", postList);
		// 保存分页对象
		model.addAttribute("page", page);
		// 推荐Flg
		model.addAttribute("recommend", recommend);
		// 返回页面
		return "learn/index";
	}

	@RequestMapping("learn/article")
	public String article(HttpServletRequest request, Model model) {
		// 返回值
		Article article = null;
		List<Post> postList = null;
		Boolean result = true;
		
		// 获取参数
		String postIdStr = request.getParameter("postId");
		String recommend = request.getParameter("recommend");
		
		Integer postId = null;
		if(null != postIdStr) {
			try {
				postId = Integer.parseInt(postIdStr);
			} catch(Exception e) {
				result = false;
			}
		}
		
		// postId check
		if(result && (null == postId || postId <= 0)) {
			result = false;
		}
		
		if(result) {
			// 取得文章
			postList = postService.findPostsById(postId, recommend);
			
			// 取得值check
			if(null == postList || 0 == postList.size() || postList.size() > 3) {
				result = false;
			}
		}
		
		if(result) {
			// 返回值CHECK，设定
			article = new Article();
			boolean idCheck = false;
			for(Post post : postList) {
				if(post.getId() == postId) {
					if("".equals(post.getAuthor().trim()) || "".equals(post.getDateTime().trim()) || "".equals(post.getTitle().trim()) || "".equals(post.getContent().trim())) {
						result = false;
						break;
					}
					idCheck = true;
					article.setPost(post);
				}else if(post.getId() < postId) {
					article.setPreId(post.getId());
					article.setPreTitle(post.getTitle());
				}else {
					article.setNextId(post.getId());
					article.setNextTitle(post.getTitle());
				}
			}
			if(!idCheck) {
				result = false;
			}
		}

		if(result) {
			// 保存取得结果
			model.addAttribute("article", article);
			// 保存推荐Flg
			model.addAttribute("recommend", recommend);
		} else {
			// error信息
			CustomInfo info = MessageManager.findWarnMsg("WLE001");
			model.addAttribute("info", info);
		}

		// 返回页面
		return "learn/article";
	}
	
	@RequestMapping("learn/tagList")
	public String tagList(Model model) {
		// 取得所有标签
		List<Tag> tagList = tagService.findAllTags();
		// 取得结果check
		if(null == tagList || tagList.size() < 1) {
			// error信息
			CustomInfo info = MessageManager.findWarnMsg("WLE002");
			model.addAttribute("info", info);
		}else {
			// 保存取得结果
			model.addAttribute("tagList", tagList);
		}
		return "learn/tag";
	}
	
	@RequestMapping("learn/tag")
	public String tag(HttpServletRequest request, Model model) {
		boolean result = true;
		boolean tagCheck = false;
		List<Post> postList = null;
		String tagName = "";
		// 获取参数
		String tagIdStr = request.getParameter("tagId");
		// 参数check
		Integer tagId = null;
		if(null != tagIdStr) {
			try {
				tagId = Integer.parseInt(tagIdStr);
			} catch(Exception e) {
				result = false;
			}
		}
		// 取得所有标签
		List<Tag> tagList = tagService.findAllTags();
		// 取得结果check
		if(null == tagList || tagList.size() < 1) {
			result = false;
		}else {
			// tagId check
			for(Tag tag : tagList) {
				if(tag.getId() == tagId) {
					tagName = tag.getContent();
					tagCheck = true;
					break;
				}
			}
			// 保存取得结果
			model.addAttribute("tagList", tagList);
		}
		result = result && tagCheck;
		if(result) {
			postList = postService.findPostsByTag(tagId);
			// 结果check
			if(null == postList || postList.size() < 1) {
				result = false;
			}
		}
		if(result) {
			// 保存取得结果
			model.addAttribute("postList", postList);
			model.addAttribute("tagId", tagId);
		}else {
			// error信息
			CustomInfo info = null;
			if(!tagCheck) {
				info = MessageManager.findWarnMsg("WLE003");
			}else {
				info = MessageManager.findWarnMsg("WLE004", new String[] {tagName});
			}
			model.addAttribute("info", info);
		}
			
		return "learn/tag";
	}

	private Page pageProc(String curPageStr, String featured) {
		// 请求参数处理
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
		page.setTotalNumber(postService.findTotalNumber(featured));
		// 当前页数
		page.setCurrentPage(currentPage);
		// 推荐Flg
		page.setFeatured(featured);
		// 分页计算
		page.count();
		return page;
	}
}
