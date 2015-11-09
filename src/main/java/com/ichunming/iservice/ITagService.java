/**
 * Tag Service 接口
 * 2015/10/29 chunming
 */
package com.ichunming.iservice;

import java.util.List;

import com.ichunming.bean.Tag;

public interface ITagService {
	// 获取所有Tag
	public List<Tag> findAllTags();
}
