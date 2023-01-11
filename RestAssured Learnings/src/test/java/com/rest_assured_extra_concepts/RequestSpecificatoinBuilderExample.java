package com.rest_assured_extra_concepts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificatoinBuilderExample {

	
	//This is another method of creating RequestSpecification
	
	public static void main(String[] args) {
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		builder.setBaseUri("http://localhost:3000/");
		builder.setBasePath("employees/21");
		
		RequestSpecification requestSpecification = builder.build();
		
		
		//one method
		RestAssured
		.given()
//		.spec(requestSpecification)
		.spec(builder.build())  //another way of assigning
		.when()
		.get()
		.prettyPrint();
		
		
		
		System.out.println("================================================================");
		
		//We can also pass specification in given method
		
		RestAssured
		.given(builder.build())
	   //another way of assigning
		.when()
		.get()
		.prettyPrint();
		
		
		
	}
}
