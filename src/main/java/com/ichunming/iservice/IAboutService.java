/**
 * About Service接口
 * 2015/11/16 chunming
 */

package com.ichunming.iservice;

import java.util.List;
import com.ichunming.bean.About;

public interface IAboutService {
	// 取得about
	public List<About> findAllAbouts();
}
