package com.rest_assured.bdd_style;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;  // this is not best practice 

import java.io.File;

import org.testng.annotations.Test;

public class BDD_Style {
	
	

	@Test(enabled=true)
	public void getAllEmployeeBDD() {
		
		
// 1. This method is using BDD and not using static import		
		RestAssured
		.given()
			.baseUri("http://localhost:3000/")
		.when()
			.get("employees")
		.prettyPrint();
		
		
	System.out.println("=================================================");
		
		
//	2. This method is using BDD and using static import
		given()
		.baseUri("http://localhost:3000/")
	.when()
		.get("employees")
	.prettyPrint();

	}
	
	@Test(enabled=true)
	public void createAnEmployee()
	{
		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body("{\r\n"+ " \"first_name\": \"Rolex\",\r\n"
		                                                                 + "  \"last_name\": \"Y\",\r\n"
		                                                                 + "  \"email\": \"rolex@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}")
		.when()
		.post("employees")
		.prettyPrint();
	}
	@Test
	public void updateAnEmployee() {
		given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body("{\r\n"+ " \"first_name\": \"Ravuthar\",\r\n"
		                                                                 + "  \"last_name\": \"A\",\r\n"
		                                                                 + "  \"email\": \"Ravuthar@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}")
		.when()
		.put("employees/3")
		.prettyPrint();
		
		
	}
	@Test
	public void deleteAnEmployee() {
		given()
		.baseUri("http://localhost:3000/")
		.when()
		.delete("employees/5")
		.prettyPrint();

}
	
	@Test
	public void createAnEmplyeeFromJsonFile()
	{
		
		File jsonFile = new File("PostData.json");
		RestAssured
		.given()
		.header("Content-Type","application/json")
		.body(jsonFile)
		.baseUri("http://localhost:3000/")
		.when()
		.post("employees")
		.prettyPrint();

	}
	
}
