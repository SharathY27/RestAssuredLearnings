
package com.rest_assured.json_schema_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class RestAssuredJsonSchemaValidation {
	
	@Test
	public void validationUsingJsonSchemaInClassPath()
	{
		File inputJson = new File("src/test/resources/input.json");
		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body(inputJson)
		.when()
		.post("employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema.json"));
		//if you keep json schema file in your test/resources folder then you can use above method and can use just file name like schema.json is enough
		//IMPORTANT
		/*
		 * {
		 * File schemaJson = new File("src/test/resources/schema.json");
		 * if u try to use below line in 24th line
		 * .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaJson));
		 * it will throw u error as matchesJsonSchemaInClasspath method accepts only string and will not accept as File
		 * so we just created file under resources and then just use file name matchesJsonSchemaInClasspath method as string
		 * this is important interview question please remember
		 * 
		 *  
		 *  
		 *  u can also validate by removing one required field and practice
		 */
	}
	
	@Test
	public void validationUsingMatchesJsonSchema() throws FileNotFoundException
	{
	//Assume schema file is not in resource folder
		File inputJson = new File("src/test/resources/input.json");
		File inputSchema = new File("src/test/resources/ResponseSchema.json"); //schema is in resources folder only but assume like it is not under resource for another method validation
		//there are different ways sending schema to MatchesJsonSchema method we can try if needed
//		InputStream inputSchema1 = new FileInputStream("src/test/resources/schema.json"); 
//		Reader inputSchema2 = new FileReader("src/test/resources/schema.json");
		//if schema is not in reource folder u cannot use matchesJsonSchemaInClasspath method 
		//u need to use MatchesJsonSchema method 
		
		//So overall we are validating json reponse against schema
		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body(inputJson)
		.when()
		.post("employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchema(inputSchema));
		//in above line in place of inputSchema if you try to give path it will throw you error because it will accept only json filename not path
	
	}

}
