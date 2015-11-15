/**
 * life controller
 * 2015/10/29 chunming
 */
package com.ichunming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichunming.bean.Status;
import com.ichunming.common.MessageManager;
import com.ichunming.consts.BizConst;
import com.ichunming.entity.CustomInfo;
import com.ichunming.entity.Page;
import com.ichunming.iservice.IStatusService;

@Controller
@RequestMapping("/")
public class LifeController {
	@Autowired
	private IStatusService statusService;
	
	@RequestMapping("life")
	public String life(HttpServletRequest request, Model model) {
		// 获取参数
		String curPageStr = request.getParameter("currentPage");
		int currentPage;
		if(null == curPageStr) {
			currentPage = 1;
		}else {
			try {
				currentPage = Integer.parseInt(curPageStr);
			} catch(Exception e) {
				currentPage = 1;
			}
		}
		// 分页对象
		Page page = new Page();
		// Status总条数
		page.setTotalNumber(statusService.findTotalNumber());
		// 每页条数
		page.setPageNumber(BizConst.STATUS_PAGE_COUNT);
		// 当前页数
		page.setCurrentPage(currentPage);
		// 分页计算
		page.count();
		// Status取得
		List<Status> statusList = statusService.findStatuses(page);
		
		// check
		if(null == statusList || statusList.size() < 1) {
			// error信息
			CustomInfo info = MessageManager.findWarnMsg("WLI001");
			model.addAttribute("info", info);
		}else {
			model.addAttribute("statusList", statusList);
		}
		return "life/index";
	}
}
