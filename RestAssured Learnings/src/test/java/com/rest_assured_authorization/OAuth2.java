package com.rest_assured_authorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class OAuth2 {

	
	@Test
	public void oAuth2()
	{
		
		//For OAuth we need to use auth function instead of header
		 
		String token = "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";
		given()
		.auth()
		.oauth2(token)
		.when()
		.get("https://api.github.com/user/repos")
		.prettyPrint();
	}
	
}
