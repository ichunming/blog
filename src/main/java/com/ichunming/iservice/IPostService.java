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
	
	// 取得文章
	public List<Post> findPosts(Page page);
}
