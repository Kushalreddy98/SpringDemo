package com.insuranceapp.model;

import java.util.List;

public class AppUser {
	
	private String username;
	private String email;
	private int userId;
	private String password;
	private List<String> roles;
	
	
	public AppUser() {
		super();
	}
	public AppUser(String username, String email, int userId, String password, List<String> roles) {
		super();
		this.username = username;
		this.email = email;
		this.userId = userId;
		this.password = password;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "AppUser [username=" + username + ", email=" + email + ", userId=" + userId + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	

}
