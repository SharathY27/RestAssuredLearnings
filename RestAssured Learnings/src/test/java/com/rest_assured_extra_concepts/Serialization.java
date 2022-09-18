package com.rest_assured_extra_concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Serialization 
{
	//Assume data obtained from UI
	
	//Note: Object can hold any type of datatype
	@Test
	public void serialization() {
	Map<String,Object> jsonBody = new HashMap<String,Object>();
	
	List<String> skills = new ArrayList<String>();
	
	jsonBody.put("first_name", "Roman");
	jsonBody.put("last_name", "Reigns");
	jsonBody.put("email", "Roamnreignsgmail.com");
	
	skills.add("java");
	skills.add("Selenium");
	
	jsonBody.put("Skills", skills);
	
	System.out.println(jsonBody);//In this output we get = in console...in which json file does not have = in it...so we need to convert to json
	//to convert to json we need libraries like Jackson , GSON etc.,
	//we just need to add any library then it will automatically convert map to into desired json ...mostly developers use this for api development
	RestAssured
	.given()
	.header("Content-Type","application/json")
	.body(jsonBody)
	.baseUri("http://localhost:3000/")
	.log().all()
	.when()
	.post("employees")
	.then()
	.log()
	.all();
	
	}
	
}
