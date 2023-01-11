package com.rest_assured_authorization;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class APIKeyAuth {

	@Test
	public void apiKeyAuth()
	{
		
		//For API which require authorization if try without giving authorization it will give Unauthorized error
		
		
		
		Response response = RestAssured
		.given()
		.when()
//		This is the main endpoint
//		https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
//		To get appid check this link "https://home.openweathermap.org/api_keys"
		.get("https://api.openweathermap.org/data/2.5/weather?q=london&appid=ca7901ad26598fb76ff7059ccfe1f2b8");
		
		System.out.println("Status code :  " +response.getStatusCode());
		
		response.prettyPrint();
	}
	
	@Test
	public void apiKeyAuthUsingQueryParam()
	{
		given()
		.queryParam("q","Chennai")
		.queryParam("appid", "ca7901ad26598fb76ff7059ccfe1f2b8")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
		.then()
		.log().body();
	}
	
	//we can also pass query parameters as headers , for some api it will work and for some it wont work
	
	@Test
	public void apiKeyAuthUsingHeader()
	{
		given()
		.queryParam("q","Chennai")
		.header("appid", "ca7901ad26598fb76ff7059ccfe1f2b8")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
		.then()
		.log().body();
	}
	
	
}
