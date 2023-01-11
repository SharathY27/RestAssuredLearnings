package com.rest_assured_extra_concepts;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import   io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {

	
	// When you have n number of test methods which has baseURI,context path(basePath) 
	// When there is a change in endpoint its difficult to change in all methods
	// So best practice is to create separate RequestSpecification method as below
	
	
	
	//Difference b/w given() and with() , both will function same only the name is different
	RequestSpecification rs;
	
	@BeforeTest
	public void requestSpecification()
	{
		rs = with()
		.baseUri("http://localhost:3000/")
		.basePath("employees");
	}
	
	
	@Test
	public void getAllEmployee() {
		
		
		// 1. This method is using BDD and not using static import
		
		
		//Previously it will be like this below:
				/*
				 * given()
					.baseUri("http://localhost:3000/")
				.when()
					.get("employees")
				.prettyPrint();
				 */
		//Now no need of baseURI and basePath as it defined in requestSpecification variable above
		//TO USE THAT METHOD WE HAVE FUNCTION CALLED **spec**
		
				RestAssured
				.given()
				.spec(rs)
				.when()
				.get()
				.prettyPrint();
				
				
			System.out.println("==================================================================================");	
				
				
	}
	
	@Test
	public void getSpecificEmployee() {
		
		
		// 2. This method is using BDD and using static import		
			
				given()
				.spec(rs)
				.when()
				.get("/1")
				.prettyPrint();
				
	}
		
	
	//Question : Can we define multiple request specification ?
	//Ans : yes we can, like below
	
	//We have created request specification for get method above 
	//Similarly we can create post method also
	//For each request body may change so keep in request specification only optional if u want u can 
	
	RequestSpecification postRequestSpecification = given()
													.baseUri("http://localhost:3000/")
													.basePath("employees")
													.contentType(ContentType.JSON);
	
	
	@Test()
	public void createAnEmployee()
	{
		RestAssured
		.given()
		.spec(postRequestSpecification)
		.body("{\r\n"+ " \"first_name\": \"Rolex Surya\",\r\n"
		                                                                 + "  \"last_name\": \"Y\",\r\n"
		                                                                 + "  \"email\": \"rolex@gmail.com\"\r\n"
		                                                                 + "\r\n"
		                                                                 + "}")
		.when()
		.post()
		.prettyPrint();
	}
	
}
