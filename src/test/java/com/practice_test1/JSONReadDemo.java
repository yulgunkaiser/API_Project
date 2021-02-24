package com.practice_test1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReadDemo {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			LoginUser loginUSER = objectMapper
					.readValue(new File(System.getProperty("user.dir") + "\\com\\data\\users2.json"), LoginUser.class);

			List<UserObject> users = loginUSER.getUsers();
			for (UserObject userObject : users) {
				System.out.println(String.format("%s %s %s %s", userObject.getUsername(), userObject.getPassword(),
						userObject.getRole(), userObject.getUsertype()));
			}

		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
