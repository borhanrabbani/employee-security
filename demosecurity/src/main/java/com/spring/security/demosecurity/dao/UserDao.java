package com.spring.security.demosecurity.dao;

import com.spring.security.demosecurity.entity.User;

public interface UserDao {
	User findByUserName(String userName);

	void save(User theUser);
}
