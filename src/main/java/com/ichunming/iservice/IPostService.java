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
	public int findTotalNumber(String recommend);
	
	// 取得分页文章
	public List<Post> findPosts(Page page);
	
	// 根据ID取得当前文章及前后
	public List<Post> findPostsById(int id, String recommend);
	
	// 根据tag取得文章
	public List<Post> findPostsByTag(int tagId);
}
