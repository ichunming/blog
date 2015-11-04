/**
 * 动态 Service
 * 2015/10/29 chunming
 */
package com.ichunming.iservice;
import com.ichunming.bean.Status;

public interface IStatusService {
	// 取得最新动态
	public Status findNewestStatus();
	// Status中content截断处理
	public void procContent(Status status);
}
