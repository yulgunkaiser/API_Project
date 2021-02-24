package com.practice_test2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsList {

	
	
	@JsonProperty("User List")
	private List<ObjectRepo> usersList;
	
	

	public CredentialsList(List<ObjectRepo> usersList) {
		
		this.usersList = usersList;
	}

	public CredentialsList() {
		
	}

	public List<ObjectRepo> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<ObjectRepo> usersList) {
		this.usersList = usersList;
	}
	
	
	
	
	
	
	
	
	
	
	
}
