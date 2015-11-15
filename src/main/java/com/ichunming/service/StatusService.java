package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.Status;
import com.ichunming.consts.BizConst;
import com.ichunming.entity.Page;
import com.ichunming.idao.IStatusDao;
import com.ichunming.iservice.IStatusService;

@Service
public class StatusService implements IStatusService {
	
	@Autowired
	private IStatusDao statusDao;
	
	/**
	 * 获得最新动态
	 * return:Status
	 */
	@Override
	public Status findNewestStatus() {
		// 取得最新动态
		return statusDao.getNewestStatus();
	}

	/**
	 * Status中content截断处理
	 */
	@Override
	public void procContent(Status status) {
		// posfix
		String posfix = "";
		// content
		String content = status.getContent();
		// 开始Index
		int startIndex = 0;
		// 总长度
		int length = content.length();
		// 结束Index
		int endIndex = length;
		if (content.indexOf("<img") >= 0) {
			startIndex = content.indexOf("/>") + 2;
		}
		
		if (length - startIndex > BizConst.BLOCK_EVERYDAY_CONTENT_LENGTH) {
			endIndex = BizConst.BLOCK_EVERYDAY_CONTENT_LENGTH + startIndex - 3;
			posfix = "...";
		}
		status.setContent(content.substring(0, endIndex) + posfix);
	}

	/**
	 * 取得Status
	 * parameter: page 分页对象
	 * return: List<Status>
	 */
	@Override
	public List<Status> findStatuses(Page page) {
		return statusDao.getStatuses(page);
	}

	/**
	 * 取得总件数
	 * return: int
	 */
	@Override
	public int findTotalNumber() {
		return statusDao.getTotalNumber();
	}
}
