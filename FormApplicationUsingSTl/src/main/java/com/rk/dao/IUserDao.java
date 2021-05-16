package com.rk.dao;

import com.rk.modle.User;

public interface IUserDao {
	public Integer saveUser(User user);

	public User getUserByEmail(String userEmail);
}
