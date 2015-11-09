/**
 * post 操作接口
 * 2015/10/29 chunming
 */
package com.ichunming.idao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ichunming.bean.Post;
import com.ichunming.entity.Page;

@Service
public interface IPostDao {
	// 取得文章总条数
	public int getTotalNumber();
	
	// 取得文章
	public List<Post> getPosts(Page page);
	
}
