/**
 * Download Service
 * 2015/11/08 chunming
 */
package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Download;
import com.ichunming.idao.IDownloadDao;
import com.ichunming.iservice.IDownloadService;

@Service
public class DownloadService implements IDownloadService {

	@Autowired
	private IDownloadDao downloadDao;
	
	/**
	 * 获取下载列表
	 * return: List<Download>
	 */
	@Override
	public List<Download> findDownloadList() {
		// 取得下载列表
		return downloadDao.getDownloadList();
	}

	/**
	 * 获取下载列表
	 * parameter: count 列表条数
	 * return: List<Download>
	 */
	@Override
	public List<Download> findNewestDownloadList(int count) {
		// 获取下载列表
		return downloadDao.getNewestDownloadList(count);
	}

}
