/**
 * Tag Service
 * 2015/11/08 chunming
 */
package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Tag;
import com.ichunming.idao.ITagDao;
import com.ichunming.iservice.ITagService;

@Service
public class TagService implements ITagService {

	@Autowired
	private ITagDao tagDao;
	
	/**
	 * 获取所有的Tag
	 * return:List<Tag>
	 */
	@Override
	public List<Tag> findAllTags() {
		// 获取所有的Tag
		return tagDao.getAllTags();
	}

}
