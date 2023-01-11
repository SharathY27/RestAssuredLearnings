package com.rest_assured_authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuth {

	@Test
	public void basicAuth()
	{
		
		//For API which require authorization if try without giving authorization it will give Unauthorized error
		
		
		
		Response response = RestAssured
		.given()
		.auth()
		.basic("postman", "password")           //Here "postman" is username and "password" is password
		.baseUri("https://postman-echo.com/")
		.when()
		.get("basic-auth");

		
		System.out.println("Status code :  " +response.getStatusCode());
		
		response.prettyPrint();
		
		
	}
	
}
