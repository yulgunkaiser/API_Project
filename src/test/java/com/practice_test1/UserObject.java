package com.practice_test1;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserObject {

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	@JsonProperty("role")
	private String role;

	@JsonProperty("usertype")
	private String usertype;

	public UserObject() {

	}

	public UserObject(String username, String password, String role, String usertype) {

		this.username = username;
		this.password = password;
		this.role = role;
		this.usertype = usertype;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}
