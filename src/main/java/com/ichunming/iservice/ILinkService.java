/**
 * link service
 * 2015/10/29 chunming
 */
package com.ichunming.iservice;

import java.util.List;

import com.ichunming.bean.Link;

public interface ILinkService {
	// 获取所有Tag
	public List<Link> findAllTags();
}
