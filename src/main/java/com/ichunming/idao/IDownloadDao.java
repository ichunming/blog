/**
 * Download Dao接口
 * 2015/11/09 chunming
 */
package com.ichunming.idao;

import java.util.List;

import com.ichunming.bean.Download;

public interface IDownloadDao {
	// 获取下载列表
	public List<Download> getDownloadList();
	
	// 获取最新指定条数下载列表
	public List<Download> getNewestDownloadList(int count);
}
