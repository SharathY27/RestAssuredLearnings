package com.rest_assured_extra_concepts;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class GetRequestSpecificationProperties {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification requestSpecification = RestAssured.given()
															.header("Content-Type","application/json")
															.body("{\r\n"+ " \"first_name\": \"Gokl\",\r\n"
		                                                                 + "  \"last_name\": \"Y\",\r\n"
		                                                                 + "  \"email\": \"mani@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}");
		
		Response response =  requestSpecification.request(Method.POST,"/employees");
		
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		
		
		
		System.out.println(queryableRequestSpecification.getHeaders());
		
		System.out.println("====================================================");
		
		System.out.println(queryableRequestSpecification.getBaseUri());
		
		System.out.println("====================================================");
		
		System.out.println(queryableRequestSpecification.getContentType());
		
		System.out.println("====================================================");



	}

}
