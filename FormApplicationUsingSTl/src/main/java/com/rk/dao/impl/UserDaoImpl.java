package com.rk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rk.dao.IUserDao;
import com.rk.modle.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUser(User user) {
		Integer id = (Integer) ht.save(user);
		return id;
	}

	@Override
	@SuppressWarnings("deprecation")
	public User getUserByEmail(String userEmail) {
		User user = null;
		String hql = "from " + User.class.getName() + " where userMail=?";
		List<User> userList = (List<User>) ht.find(hql, userEmail);
		if (userList != null && userList.size() > 0) {
			user = userList.get(0);
		}
		return user;
	}

}
