package com.practice_test1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser {

	@JsonProperty("Users")
	private List<UserObject> users;

	public LoginUser() {

	}

	public LoginUser(List<UserObject> users) {
		this.users = users;
	}

	public List<UserObject> getUsers() {
		return users;
	}

	public void setUsers(List<UserObject> users) {
		this.users = users;
	}

}
