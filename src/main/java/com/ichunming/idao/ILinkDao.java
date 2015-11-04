/**
 * Link 操作接口
 */
package com.ichunming.idao;

import java.util.List;

import com.ichunming.bean.Link;

public interface ILinkDao {
	// 获取所有的标签
	public List<Link> getAllTags();
}
