package com.rest_assured_extra_concepts;

import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.rest_assured.pojo_concepts.Employee;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;


public class Deserialization {
	
	//Employee is a POJO class
	
	String json = "{\r\n"
			+ "  \"firstName\" : \"Agni\",\r\n"
			+ "  \"lastName\" : \"A\",\r\n"
			+ "  \"email\" : \"Agni@agni.com\",\r\n"
			+ "  \"skills\" : [ \"Java\", \"Selenium\" ]\r\n"
			+ "}\r\n";
	
	@Test
	public void deserializationUsingObjectMapper() throws JsonMappingException, JsonProcessingException
	{

	
	ObjectMapper mapper =new ObjectMapper();
	
	Employee employee = mapper.readValue(json, Employee.class);
	
	System.out.println(employee.getFirstName());
	System.out.println(employee.getLastName());
	System.out.println(employee.getEmail());
	System.out.println(employee.getSkills());
	
	
	}
	
	@Test
	public void deserializationUsingJsonPath() throws JsonMappingException, JsonProcessingException
	{
		
		//this is using JacksonMappingProvider
		
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
		
		Configuration configuration = Configuration
										.builder()
										.mappingProvider(mappingProvider)
										.build();
		Employee employee = JsonPath.using(configuration)
							.parse(json)
							.read("$",Employee.class);
		
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());
	}
	
	@Test
	public void deserializationUsingRestAssuredJsonPath()
	{
		//we r using like this because already Jayway json path is imported above

		io.restassured.path.json.JsonPath jsonPath = io.restassured.path.json.JsonPath.from(json);
		Employee employee = jsonPath.getObject("", Employee.class); //U can also pass "" in place of "$" it will return same IMPORTANT INTERVIEW QUESTION
		
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSkills());
		
	}
	
	
	@Test
	public void deserializationUsingAsFunction()
	{
		
		//this is for storing response directly into Map
		
		Map<String,Object> response = RestAssured 
		.given()
		.baseUri("http://localhost:3000/")
		.when()
		.get("employees/1")
		.then()
		.extract()
		.body()
		.as(new TypeRef <Map<String,Object>>() {                             //this TypeRef() is from Rest Assured not from Jayway
		});
		
		System.out.println(response);
		System.out.println(response.get("id"));
		
		
	}


}
