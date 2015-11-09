/**
 * 下载类
 * 2015/11/08 chunming
 */
package com.ichunming.bean;

public class Download {
	// ID
	private Integer id;
	// 内容
	private String content;
	// 链接
	private String href;
	// 下载次数
	private int downloadCount;
	// 日期时间
	private String dateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
