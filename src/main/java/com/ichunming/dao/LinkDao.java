/**
 * link dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Link;
import com.ichunming.idao.ILinkDao;

@Repository
public class LinkDao implements ILinkDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 获得所有标签
	 * return:List<Link> 所有标签
	 */
	@Override
	public List<Link> getAllTags() {
		// 获得所有标签
		return sqlSessionTemplate.selectList("getAllTags");
	}
}
