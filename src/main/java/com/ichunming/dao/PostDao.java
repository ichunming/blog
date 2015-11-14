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
import com.ichunming.entity.Page;
import com.ichunming.idao.IPostDao;

@Repository
public class PostDao implements IPostDao {

	@Autowired  
    private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 取得文章
	 * parameter: page 分页对象
	 * return:List<Post>
	 */
	@Override
	public List<Post> getPosts(Page page) {
		// 取得文章
		return sqlSessionTemplate.selectList("getPosts", page);
	}

	/**
	 * 取得文章总件数
	 * return: int
	 */
	@Override
	public int getTotalNumber() {
		return sqlSessionTemplate.selectOne("getTotalNumber");
	}

	/**
	 * 根据ID取得当前文章及其前后
	 * parameter: id 文章ID
	 * return: post
	 */
	@Override
	public List<Post> getPostsById(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("featured", null);
		return sqlSessionTemplate.selectList("getPostsById", map);
	}

	/**
	 * 根据ID取得当前推荐文章及其前后
	 * parameter: id 文章ID
	 * return: post
	 */
	@Override
	public List<Post> getRecommendPostsById(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("featured", "1");
		return sqlSessionTemplate.selectList("getPostsById", map);
	}
}
