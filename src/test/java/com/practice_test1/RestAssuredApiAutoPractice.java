package com.practice_test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commonfunctions.ApiLibrary;
import com.commonvariables.Commonvariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RestAssuredApiAutoPractice extends ApiLibrary {

	SoftAssert sa;

	@Test(enabled = false, priority = 0)
	public void getRequest() {

		Response res = get("https://reqres.in/api/users?page=2");
		// System.out.println(res.asString());

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();

		given().header("Content-Type", "application/json").param("param", "param")
				.get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8));

	}

	@Test(enabled = false)
	public void getRequestPrac() {

		Response res = get("https://reqres.in/api/users?page=2");

		// System.out.println(res.getBody().asString());
		// System.out.println(res.statusCode());
		// System.err.println(res.asString());
		// System.out.println(res.getStatusLine());
		// System.out.println(res.getHeaders());
		// System.out.println(res.getTime());

		// String email =
		// given().get("https://reqres.in/api/users?page=2").then().extract().path("data.email[1]");
		// System.out.println(email);

	}

	@SuppressWarnings("unused")
	@Test(enabled = false, priority = 0)
	public void post_And_put_And_patch_Request() {

		first_Scenario: {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "Kaiser");
			map.put("Job", "Doctor");

			System.out.println(map);

			JSONObject request = new JSONObject(map);

			System.out.println(request); // if this line throw error, use below line
			System.out.println(request.toJSONString());

		}

		System.out.println("**************************This is Separator************************");

		second_Scenario: {

			JSONObject request = new JSONObject();

			request.put("name", "Kaiser");
			request.put("Job", "Doctor");

			System.out.println(request);
			System.out.println(request.toJSONString());

			given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
		}

		Third_Scenario: {

			JSONObject request = new JSONObject();

			request.put("name", "Kaiser");
			request.put("Job", "Doctor");

			System.out.println(request);
			System.out.println(request.toJSONString());

			given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200)
					.log().all();
		}

		Fourth_Scenario: {

			JSONObject request = new JSONObject();

			request.put("name", "Kaiser");
			request.put("Job", "Doctor");

			System.out.println(request);
			System.out.println(request.toJSONString());

			given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200)
					.log().all();
		}

		Fifth_Scenario: {

			given().when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		}

	}

	/***
	 * 
	 * json-server --watch db.json use this command to start the json server before
	 * launching the local host "http://localhost:3000/" db.json file is created in
	 * the directory : "C:\Users\yulgu", open it in notepad++ and delete the
	 * existing data and creat custom data
	 * 
	 */

	@SuppressWarnings("unused")
	@Test(enabled = false, priority = 0)
	void testCustomApiGet() {

//		Scenario_1:{
//		
//		baseURI = "http://localhost:3000/";
//		given().get("users").then().statusCode(200).log().all();	
//	}

//	  Scenario_2:{
//	  
//	  given().get("http://localhost:3000/users").then().log().all(); 
//	  
//	}

		Scenario_3: {

			baseURI = "http://localhost:3000/";
			given().param("subjectId", "1").get("users").then().statusCode(200).log().all();

		}

	}

	@SuppressWarnings("unused")
	@Test(enabled = true, priority = 0)
	void testCustomApiPost() {

//		Scenario_1: {
//
//			JSONObject request = new JSONObject();
//
//			request.put("firstName", "Lion");
//			request.put("lastName", "Shir");
//			request.put("subjectId", "2");
//
//			baseURI = "http://localhost:3000/";
//
//			given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//					.body(request.toJSONString()).when().post("users").then().statusCode(201).log().all();
//
//		}

//		Scenario_2: {
//
//			JSONObject request = new JSONObject();
//
//			request.put("firstName", "Tiger");
//			request.put("lastName", "Yolvas");
//			request.put("subjectId", "3");
//
//			baseURI = "http://localhost:3000/";
//
//			given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//					.body(request.toJSONString()).when().put("users/7").then().statusCode(200).log().all();
//
//		}

//		Scenario_3: {
//
//			baseURI = "http://localhost:3000/";
//
//			given().when().delete("users/7").then().statusCode(200).log().all();
//
//		}

//		Scenario_4:{
//		
//		JSONObject request = new JSONObject();
//		request.put("firstName", "Tiger");
//		request.put("lastName", "Yolvas");
//		request.put("subjectId", "3");
//	
//		baseURI = "http://localhost:3000/";
//		given().header("Content-Type", "application/json")
//		.body(request.toJSONString()).when().post("users").then().statusCode(201).log().all();
//			
//	}

		

	}

	@SuppressWarnings("unused")
	@Test(enabled = false, priority = 0, dataProvider = "apiData")
	void dataDriverTest(String firstName, String lastName, String roleId) {

		JSONObject request = new JSONObject();

		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", roleId);

		baseURI = "http://localhost:3000/";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("users").then().statusCode(201).log().all();

	}

	
	void a () throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("excelPathhere");
		XSSFSheet sh = wb.getSheet("sheetNameHere");
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sh.getRow(1).getCell(1));
	}
	
	
	
	
	@DataProvider(name = "apiData")
	public Object[][] apiData() {

		int totalRow = getTotalRowNum(Commonvariables.sourceFile, "ApiData");
		int totalClmn = getTotalClmnNum(Commonvariables.sourceFile, "ApiData");

		Object[][] data = new Object[totalRow][totalClmn];

		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalClmn; j++) {

				String firstName = excelGetCellData(Commonvariables.sourceFile, "ApiData", "firstName", i);
				String lastName = excelGetCellData(Commonvariables.sourceFile, "ApiData", "lastName", i);
				String roleId = excelGetCellData(Commonvariables.sourceFile, "ApiData", "roleId", i);

				if (j == 0) {
					data[i][j] = firstName;
				} else if (j == 1) {
					data[i][j] = lastName;
				} else {
					data[i][j] = roleId;
				}

			}
		}

		return data;
	}

}
