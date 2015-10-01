package com.ichunming.service;

import java.util.List;
import com.ichunming.bean.User;

public interface IUserService {
	public List<User> getAllUser();
	public void deleteUpdateUser(int id, User user);
}
