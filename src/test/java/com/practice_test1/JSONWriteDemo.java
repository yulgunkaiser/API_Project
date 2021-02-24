package com.practice_test1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWriteDemo {

	public static void main(String[] args) {

		UserObject user1 = new UserObject();
		user1.setUsername("testAutomation1");
		user1.setPassword("automation123!");
		user1.setRole("testing");
		user1.setUsertype("automationtesting");

		ObjectMapper objectMapper = new ObjectMapper();
		String userInfo = null;

		try {

			userInfo = objectMapper.writeValueAsString(user1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(userInfo);

		try {
			FileUtils.writeStringToFile(new File("com\\data\\users.json"), userInfo);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
