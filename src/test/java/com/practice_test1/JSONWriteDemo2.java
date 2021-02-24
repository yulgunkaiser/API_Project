package com.practice_test1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWriteDemo2 {

	// SDET video to 1. use json data in test; 2. use WebDriverManager: https://www.youtube.com/watch?v=tVNcIMsExDg

	public static void main(String[] args) {
		UserObject user1 = new UserObject("testAutomation1", "automation123!", "testing", "automationtesting");
		UserObject user2 = new UserObject("testAutomation2", "automation123!", "testing", "automationtesting");
		UserObject user3 = new UserObject("abcd", "automation123!", "testing", "automationtesting");

		List<UserObject> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);

		LoginUser loginUser = new LoginUser(users);

		ObjectMapper objectMapper = new ObjectMapper();
		String userInfo = null;
		try {
			userInfo = objectMapper.writeValueAsString(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(userInfo);

		try {
			FileUtils.writeStringToFile(new File("com\\data\\users2.json"), userInfo);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
