package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Link;
import com.ichunming.consts.BizConst;
import com.ichunming.idao.ILinkDao;
import com.ichunming.iservice.ILinkService;

@Service
public class LinkService implements ILinkService {

	@Autowired
	private ILinkDao linkDao;
	
	/**
	 * 获取所有的Tag
	 * return:List<Link>
	 */
	@Override
	public List<Link> findAllTags() {
		// 获取所有的Tag
		return linkDao.getAllTags();
	}

}
