package com.practice_test3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson1 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		EmployeeList employee = objectMapper.readValue(
				new File(System.getProperty("user.dir") + "\\com\\data\\UserCredentials2.json"), EmployeeList.class);
		
		List<EmployeeObjectRepo> employeeObj = employee.getEmployeelist();
		
		for(EmployeeObjectRepo employeeObjrepo: employeeObj){
			
			System.out.println(String.format("%s %s %s %s %d", employeeObjrepo.getUsername(), employeeObjrepo.getPassword(),
					employeeObjrepo.getContractType(), employeeObjrepo.getStatus(),employeeObjrepo.getContractYear()));
			
			
		}

	}

}
