/**
 * Post Dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Post;
import com.ichunming.idao.IPostDao;

@Repository
public class PostDao implements IPostDao {

	@Autowired  
    private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 取得从start开始的count篇文章
	 * parameter:start 开始index
	 * parameter:count 文章篇数
	 * parameter:type link类型
	 * return:List<Post>
	 */
	@Override
	public List<Post> getNewestPosts(int start, int count, String type) {
		// 封装参数
		Map<String, Object> parsMap = new HashMap<String, Object>();
		parsMap.put("start", start);
		parsMap.put("count", count);
		parsMap.put("type", type);
		// 取得最新count篇文章
		return sqlSessionTemplate.selectList("getNewestPosts", parsMap);
	}
}
