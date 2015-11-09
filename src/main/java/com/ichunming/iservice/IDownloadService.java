/**
 * Download Service接口
 * 2015/11/08 chunming
 */
package com.ichunming.iservice;

import java.util.List;
import com.ichunming.bean.Download;

public interface IDownloadService {
	// 获取下载列表
	public List<Download> findDownloadList();
	
	// 获取最新指定条数下载列表
	public List<Download> findNewestDownloadList(int count);
}
