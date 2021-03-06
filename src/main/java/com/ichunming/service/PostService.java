/**
 * Post Service
 * 2015/10/29 chunming
 */
package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Post;
import com.ichunming.entity.Page;
import com.ichunming.idao.IPostDao;
import com.ichunming.iservice.IPostService;

@Service
public class PostService implements IPostService {
	@Autowired
	IPostDao postDao;
	
	/**
	 * 获取文章
	 * parameter: 分页对象page
	 * return: List<Post>
	 */
	@Override
	public List<Post> findPosts(Page page) {
		// 取得文章
		return postDao.getPosts(page);
	}

	/**
	 * 获取文章总条数
	 * return: int
	 */
	@Override
	public int findTotalNumber(String recommend) {
		// 文章总条数
		return postDao.getTotalNumber(recommend);
	}

	/**
	 * 根据ID取得当前文章及其前后
	 * parameter: id 文章ID
	 * return: List<post>
	 */
	@Override
	public List<Post> findPostsById(int id, String recommend) {
		return postDao.getPostsById(id, recommend);
	}

	/**
	 * 根据Tag取得文章
	 * parameter: tag 文章所属Tag
	 * return: List<post>
	 */
	@Override
	public List<Post> findPostsByTag(int tagId) {
		return postDao.getPostsByTag(tagId);
	}
}
