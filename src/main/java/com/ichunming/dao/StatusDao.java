/**
 * satatus dao
 * 2015/10/29 chunming
 */
package com.ichunming.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Status;
import com.ichunming.entity.Page;
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

	/**
	 * 取得动态信息
	 * parameter: page 分页对象
	 * return: List<Status>
	 */
	@Override
	public List<Status> getStatuses(Page page) {
		return sqlSessionTemplate.selectList("getStatuses", page);
	}

	/**
	 * 取得总件数
	 * return: int
	 */
	@Override
	public int getTotalNumber() {
		return sqlSessionTemplate.selectOne("com.ichunming.dao.IStatus.getTotalNumber");
	}
	
}
