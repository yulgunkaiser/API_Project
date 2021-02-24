package com.commonfunctions;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLibrary {

	



	public void getRequest(String endPoint, String uri, int expectedStatusCode, String expectedStatusLine,

			String expectedResponseBody) {

		SoftAssert sa = null;

		try {

			// Base URI

			RestAssured.baseURI = endPoint;

			// Request Object

			RequestSpecification httpRequest = RestAssured.given();

			// Response Object

			Response response = httpRequest.request(Method.GET, uri);

			// Print Response in console

			String responseBody = response.getBody().asString();

		//	logger.info("The response body is : " + responseBody);

			sa.assertEquals(responseBody, expectedResponseBody);

			// Status Code validation

			int statusCode = response.statusCode();

		//	logger.info("The status Code is: " + statusCode);

			sa.assertEquals(statusCode, expectedStatusCode);

			// Status Line Validation

			String statusLine = response.getStatusLine();

		//	logger.info("The status line is: " + statusLine);

			sa.assertEquals(statusLine, expectedStatusLine);

		} catch (Exception e) {

			e.printStackTrace();

		//	logger.info("The validation is failed");

		}

	}
	
	
	public int getTotalRowNum(String filePath, String sheetName) {
		
		int totalRowNum = 0;
		
		try {
			
			FileInputStream fls = new FileInputStream(new File(filePath));
			Workbook wb = new XSSFWorkbook(fls);
			Sheet sh = wb.getSheet(sheetName);	
			//Row row = sh.getRow(sh.getFirstRowNum());
			
			totalRowNum = sh.getLastRowNum();
					
			wb.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return totalRowNum;
	}
	
	
	public int getTotalClmnNum(String filePath, String sheetName) {
		
		int totalClmnNum = 0;
		
		try {
			
			FileInputStream fls = new FileInputStream(new File(filePath));
			Workbook wb = new XSSFWorkbook(fls);
			Sheet sh = wb.getSheet(sheetName);	
			Row row = sh.getRow(sh.getFirstRowNum());
			
			totalClmnNum = row.getLastCellNum();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalClmnNum;
	}
	
	
	public String excelGetCellData(String filePath, String sheetName, String columnName, int rowNum) {
		String celVal = null;

		try {

			File file = new File(filePath);
			FileInputStream fls = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fls);
			Sheet sh = wb.getSheet(sheetName);
			// int count = excelLastRowNum(filePath, sheetName);
			Row row = sh.getRow(sh.getFirstRowNum());

			int iColumnNum = 0;
			for (int iColumn = 0; iColumn < row.getLastCellNum(); iColumn++) {
				if (row.getCell(iColumn).getStringCellValue().equals(columnName)) {
					iColumnNum = iColumn;
				}
			}
			celVal = sh.getRow(rowNum+1).getCell(iColumnNum).getStringCellValue();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return celVal;
	}
	

}
