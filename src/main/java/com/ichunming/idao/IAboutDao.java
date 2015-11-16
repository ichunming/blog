/**
 * about 操作接口
 * 2015/11/16 chunming
 */
package com.ichunming.idao;

import java.util.List;

import com.ichunming.bean.About;

public interface IAboutDao {
	// 取得about
	public List<About> getAllAbouts();
}
