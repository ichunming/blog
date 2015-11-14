/**
 * Post Service接口
 * 2015/10/29
 */
package com.ichunming.iservice;

import java.util.List;

import com.ichunming.bean.Post;
import com.ichunming.entity.Page;

public interface IPostService {
	// 取得文章总条数
	public int findTotalNumber();
	
	// 取得分页文章
	public List<Post> findPosts(Page page);
	
	// 根据ID取得当前文章及前后
	public List<Post> findPostsById(int id);
	
	// 根据ID取得当前推荐文章及前后
	public List<Post> findRecommendPostsById(int id);
}
