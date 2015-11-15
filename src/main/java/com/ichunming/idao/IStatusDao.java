/**
 * status 操作接口
 */
package com.ichunming.idao;

import java.util.List;

import com.ichunming.bean.Status;
import com.ichunming.entity.Page;

public interface IStatusDao {
	// 取得最新动态
	public Status getNewestStatus();
	
	// 取得动态信息
	public List<Status> getStatuses(Page page);
	
	// 取得总件数
	public int getTotalNumber();
}
