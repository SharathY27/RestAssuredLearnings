package com.rest_assured_authorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenAuth {

	
	@Test
	public void bearerTokenAuth()
	{
		//For bearer token we can use header as "Authorization" as we use in postman
		
		String token = "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";
		given()
		.header("Authorization","Bearer "+token)
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log().body();
	}
}
