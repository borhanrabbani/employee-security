package com.spring.security.demosecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_roles")
public class UsersRoles {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public UsersRoles() {
    	
    }
    
	public UsersRoles(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    

    // Constructors, getters, and setters
}