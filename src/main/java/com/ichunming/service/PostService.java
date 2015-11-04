/**
 * 首页访问
 * 2015/10/29 chunming
 */
package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Post;
import com.ichunming.consts.BizConst;
import com.ichunming.idao.IPostDao;
import com.ichunming.iservice.IPostService;

@Service
public class PostService implements IPostService {
	@Autowired
	IPostDao postDao;
	
	/**
	 * 获取最新PAGE_POST_COUNT篇文章
	 * return:List<Post>
	 */
	@Override
	public List<Post> findNewestPosts() {
		// 取得最新PAGE_POST_COUNT篇文章
		return postDao.getNewestPosts(0, BizConst.PAGE_POST_COUNT, BizConst.POST_TYPE_FEATURED);
	}
	
}
