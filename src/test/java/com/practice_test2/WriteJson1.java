package com.practice_test2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJson1 {

	
	
	
	
	
	public static void main(String[] args) {
		
		
		ObjectRepo object_Obj = new ObjectRepo("Sabir555", "Sabirpassword", "Active", "Fulltime", 3);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String userInfo = null;
		
		try {
			
			userInfo = objMapper.writeValueAsString(object_Obj);
			
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		
		System.out.println(userInfo);
		
		try {
			
			FileUtils.writeStringToFile(new File(System.getProperty("user.dir") + "\\output_data\\UserCredentials.json"), userInfo);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
