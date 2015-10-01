package com.ichunming.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ichunming.bean.User;

@Repository
public class UserDao implements IUser {
	@Autowired  
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<User> getAllUser() {
		return sqlSessionTemplate.selectList("getAllUser");
	}

	@Override
	public void deleteUser(int id) {
		sqlSessionTemplate.delete("deleteUser", id);
	}

	@Override
	public void updateUser(User user) {
		sqlSessionTemplate.update("updateUser", user);
	}
}
