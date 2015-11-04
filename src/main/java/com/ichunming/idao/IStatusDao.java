/**
 * status 操作接口
 */
package com.ichunming.idao;

import com.ichunming.bean.Status;

public interface IStatusDao {
	// 取得最新动态
	public Status getNewestStatus();
}
