/**
 * 首页访问
 * 2015/10/29
 */
package com.ichunming.iservice;

import java.util.List;

import com.ichunming.bean.Post;

public interface IPostService {
	// 取得最新文章
	public List<Post> findNewestPosts();
}
