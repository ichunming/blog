package com.ichunming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.bean.User;
import com.ichunming.dao.IUser;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUser user;
	
	@Override
	public List<User> getAllUser() {
		return user.getAllUser();
	}

	@Override
	public void deleteUpdateUser(int id, User user) {
		this.user.deleteUser(id);
		this.user.updateUser(user);
	}
}
