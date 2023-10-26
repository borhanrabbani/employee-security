package com.spring.security.demosecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.security.demosecurity.entity.User;
import com.spring.security.demosecurity.user.WebUser;

public interface UserService extends UserDetailsService{
	
	public User findByUserName(String userName);

	void save(WebUser webUser);

}
