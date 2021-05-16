package com.rk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.IUserDao;
import com.rk.modle.User;
import com.rk.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao dao;
	

	@Override
	@Transactional
	public Integer saveUser(User user) {
		Integer id = dao.saveUser(user);
		return id;
	}


}
