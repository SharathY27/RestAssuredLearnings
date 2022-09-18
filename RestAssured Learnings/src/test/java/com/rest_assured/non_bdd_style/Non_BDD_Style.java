package com.rest_assured.non_bdd_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Non_BDD_Style {

	@Test(priority = 3)
	public void getAllEmployees() {
		// TODO Auto-generated method stub re
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response =  requestSpecification.request(Method.GET,"employees");
		
		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());
	}

	@Test(priority = 1)
	public void createAnEmployee() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification requestSpecification = RestAssured.given()
															.header("Content-Type","application/json")
															.body("{\r\n"+ " \"first_name\": \"Gokl\",\r\n"
		                                                                 + "  \"last_name\": \"Y\",\r\n"
		                                                                 + "  \"email\": \"mani@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}");
		
		Response response =  requestSpecification.request(Method.POST,"/employees");
		
		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());
		
	}
	@Test(priority = 2)
	public void updateAnEmployee() {
		
		RestAssured.baseURI = "http://localhost:3000";
		

		RequestSpecification requestSpecification = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\r\n"+ " \"first_name\": \"Yuvaraj\",\r\n"
                             + "  \"last_name\": \"S\",\r\n"
                             + "  \"email\": \"mani@gmail.com\"\r\n"
                             + "\r\n"
                             + "}");
		Response response = requestSpecification.request(Method.PUT,"employees/5");
		
		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());
	}
	@Test(priority = 4)
	public void deleteAnEmployee() {
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.DELETE,"employees/4");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());

	}
}
