package com.rest_assured_extra_concepts;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationWithoutSpecMethodForAllTest {
	
	//To use Request specification without using "spec" function for all test
	// Assign the created requestSpecification variable to  RestAssured.requestSpecification static variable so that it assigned specification will be used over all test methods 
	
RequestSpecification rs;
	
	@BeforeTest
	public void requestSpecification()
	{
		rs = with()
		.baseUri("http://localhost:3000/")
		.basePath("employees")
		.contentType(ContentType.JSON);
		
		
		RestAssured.requestSpecification= rs;
	}
	
	
	@Test(priority=1)
	public void getAllEmployee() {
		
		
		// 1. This method is using BDD and not using static import
		
		
				RestAssured
				.given()
//				.spec(rs)
				.when()
				.get()
				.prettyPrint();
				
				
			System.out.println("==================================================================================");	
				
				
	}
	
	@Test(priority=2)
	public void getSpecificEmployee() {
		
		
		// 2. This method is using BDD and using static import		
			
				given()
//				.spec(rs)
				.when()
				.get("/19")
				.prettyPrint();
				
	}
		
	
	
	@Test(priority=3)
	public void createAnEmployee()
	{
		RestAssured
		.given()
//		.header("Content-Type","application/json")
		.body("{\r\n"+ " \"first_name\": \"Rolex Surya Villain\",\r\n"
		                                                                 + "  \"last_name\": \"Y\",\r\n"
		                                                                 + "  \"email\": \"rolex@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}")
		.when()
		.post()
		.prettyPrint();
	}
	
	

}
