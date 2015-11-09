/**
 * Tag Dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Tag;
import com.ichunming.idao.ITagDao;

@Repository
public class TagDao implements ITagDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 获得所有标签
	 * return:List<Tag> 所有标签
	 */
	@Override
	public List<Tag> getAllTags() {
		// 获得所有标签
		return sqlSessionTemplate.selectList("getAllTags");
	}
}
