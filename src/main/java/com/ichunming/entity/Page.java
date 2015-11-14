/**
 * 分页实体类
 * 2015/11/07 chunming
 */
package com.ichunming.entity;

import com.ichunming.consts.BizConst;

public class Page {
	// 总条数
	private int totalNumber;
	// 总页数
	private int totalPage;
	// 当前页
	private int currentPage;
	// 每页显示条数
	private int pageNumber = BizConst.LEARN_PAGE_POST_COUNT;
	// 数据库中limit参数，从第几条开始取
	private int dbIndex;
	// 数据库中limit参数，一共多少条
	private int dbNumber;
	// 推荐flg
	private String featured;
	
	/**
	 * 根据参数计算相关属性
	 */
	public void count() {
		// 总页数
		if(this.pageNumber <= 0) {
			this.pageNumber = BizConst.LEARN_PAGE_POST_COUNT;
		}
		// 页面增量
		int plus = (this.totalNumber % this.pageNumber) == 0?0:1;
		this.totalPage = this.totalNumber / this.pageNumber + plus;
		if(this.totalPage <= 0) {
			this.totalPage = 1;
		}
		
		// 当前页数
		if(this.currentPage < 1) {
			this.currentPage = 1;
		} else if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}

		// 设置limit参数
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}
}
