package com.practice_test3;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeObjectRepo {

	
	@JsonProperty("Username")
	private String username;
	
	@JsonProperty("Password")
	private String password;
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("Contract Type")
	private String contractType;
	
	@JsonProperty("Contract Year")
	private int contractYear;

	public EmployeeObjectRepo() {
		
	}
	
		
	public EmployeeObjectRepo(String username, String password, String status, String contractType, int contractYear) {
		
		this.username = username;
		this.password = password;
		this.status = status;
		this.contractType = contractType;
	}



	public int getContractYear() {
		return contractYear;
	}


	public void setContractYear(int contractYear) {
		this.contractYear = contractYear;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
