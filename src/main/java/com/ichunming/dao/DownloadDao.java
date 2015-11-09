/**
 * Download Dao
 * 2015/11/09 chunming
 */
package com.ichunming.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.Download;
import com.ichunming.idao.IDownloadDao;

@Repository
public class DownloadDao implements IDownloadDao {
	@Autowired  
    private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 获取下载列表
	 * return: List<Download>
	 */
	@Override
	public List<Download> getDownloadList() {
		// 获取下载列表
		return sqlSessionTemplate.selectList("getDownloadList");
	}

	/**
	 * 获取下载列表
	 * parameter: count 指定条数
	 * return: List<Download>
	 */
	@Override
	public List<Download> getNewestDownloadList(int count) {
		// 获取下载列表
		//return sqlSessionTemplate.selectList("getNewestDownloadList", count);
		return null;
	}

}
