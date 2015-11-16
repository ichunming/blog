/**
 * About Service
 * 2015/11/16 chunming
 */
package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.About;
import com.ichunming.idao.IAboutDao;
import com.ichunming.iservice.IAboutService;

@Service
public class AboutService implements IAboutService {

	@Autowired
	private IAboutDao aboutDao;
	
	/**
	 * 取得所有about
	 * return: List<About>
	 */
	@Override
	public List<About> findAllAbouts() {
		return aboutDao.getAllAbouts();
	}

}
