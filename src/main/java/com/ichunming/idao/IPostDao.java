/**
 * post 操作接口
 * 2015/10/29 chunming
 */
package com.ichunming.idao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ichunming.bean.Post;

@Service
public interface IPostDao {
	// 取得从start开始的count篇文章
	public List<Post> getNewestPosts(int start, int count, String type);
	
}
