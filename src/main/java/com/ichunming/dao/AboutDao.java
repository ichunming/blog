/**
 * About Dao
 * 2015/11/16 chunming
 */
package com.ichunming.dao;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ichunming.bean.About;
import com.ichunming.idao.IAboutDao;

@Repository
public class AboutDao implements IAboutDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 取得所有about
	 * return: List<About>
	 */
	@Override
	public List<About> getAllAbouts() {
		return sqlSessionTemplate.selectList("getAllAbouts");
	}
}
