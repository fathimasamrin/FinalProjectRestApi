package com.faith.model;

public class User {
	private Long id;
	
	private String username;
	private String password;
	private String roleId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String username, String password, String roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId + "]";
	}
	
	

	
	
	

}
