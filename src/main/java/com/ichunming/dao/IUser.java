/**
 * interface user
 * 2015/08/19
 * chunming
 */
package com.ichunming.dao;

import java.util.List;
import com.ichunming.bean.User;

public interface IUser {
	public List<User> getAllUser();
	public void deleteUser(int id);
	public void updateUser(User user);
}
