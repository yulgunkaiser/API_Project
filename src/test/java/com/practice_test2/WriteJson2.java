package com.practice_test2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJson2 {

	
	public static void main(String[] args) {
		
		
		
		
		
		List<ObjectRepo> userlist = new ArrayList<>();
		
		userlist.add(new ObjectRepo("Sabir555", "Sabirpassword", "Active", "Fulltime", 3));
		userlist.add(new ObjectRepo("Sadik222", "Sadikpassword", "Active", "Fulltime", 6));
		userlist.add(new ObjectRepo("Memet", "Memetpichak", "Expired", "Contract", 0));
		
		CredentialsList logincredentials = new CredentialsList(userlist);
		
		ObjectMapper objectmapper = new ObjectMapper();
		String loginusers = null;
		
		try {
			
			loginusers = objectmapper.writeValueAsString(logincredentials);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(loginusers);
		
		try {
			
			FileUtils.writeStringToFile(new File(System.getProperty("user.dir")+ "\\com\\data\\UserCredentials2.json"), loginusers);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	

	
	
	
	
}
