/**
 * Tag Dao接口
 */
package com.ichunming.idao;

import java.util.List;

import com.ichunming.bean.Tag;

public interface ITagDao {
	// 获取所有的标签
	public List<Tag> getAllTags();
}
