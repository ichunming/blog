/**
 * satatus dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Status;
import com.ichunming.idao.IStatusDao;

@Repository
public class StatusDao implements IStatusDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 取得最新动态
	 * return:Status
	 */
	@Override
	public Status getNewestStatus() {
		return sqlSessionTemplate.selectOne("getNewestStatus");
	}
	
}
