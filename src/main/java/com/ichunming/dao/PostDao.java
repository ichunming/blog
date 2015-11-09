/**
 * Post Dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import java.util.List;

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
}
