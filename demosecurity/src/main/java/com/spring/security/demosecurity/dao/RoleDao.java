package com.spring.security.demosecurity.dao;

import com.spring.security.demosecurity.entity.Role;

public interface RoleDao {
	public Role findRoleByName(String theRoleName);
}
