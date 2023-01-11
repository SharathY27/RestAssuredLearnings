package com.rest_assured_extra_concepts;

import io.restassured.RestAssured;

public class DefaultHostAndPort {

	//Interview Question
	
	// Here We are not passing any baseURI and basePath which is endPoint 
	// So by default rest assured will check localhost 8080 port if anything is running on that endpoint it will fetch that 
	// Else return java.net.connectException
	
	public static void main(String[] args) {
		
		RestAssured
		.given()
		.log()
		.all()
		.when()
		.get();

	}

}
