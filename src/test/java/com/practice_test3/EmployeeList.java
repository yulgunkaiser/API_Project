package com.practice_test3;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeList {

	@JsonProperty("User List")
	private List<EmployeeObjectRepo> employeelist;

	public EmployeeList(List<EmployeeObjectRepo> employeelist) {

		this.employeelist = employeelist;
	}

	public EmployeeList() {

	}

	public List<EmployeeObjectRepo> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<EmployeeObjectRepo> employeelist) {
		this.employeelist = employeelist;
	}

}
