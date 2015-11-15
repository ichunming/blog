/**
 * 动态 Service
 * 2015/10/29 chunming
 */
package com.ichunming.iservice;
import java.util.List;

import com.ichunming.bean.Status;
import com.ichunming.entity.Page;

public interface IStatusService {
	// 取得最新动态
	public Status findNewestStatus();
	
	// Status中content截断处理
	public void procContent(Status status);
	
	// 取得动态信息
	public List<Status> findStatuses(Page page);
	
	// 取得总件数
	public int findTotalNumber();
}
