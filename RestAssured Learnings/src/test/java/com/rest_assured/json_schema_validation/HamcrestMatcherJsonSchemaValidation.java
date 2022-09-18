package com.rest_assured.json_schema_validation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class HamcrestMatcherJsonSchemaValidation {
	
	@Test
	public void validate() throws IOException
	{
		File inputJson = new File("src/test/resources/input.json");
		
		String jsonContent = FileUtils.readFileToString(inputJson,"UTF-8");
		File jsonSchema = new File("src/test/resources/RequestSchema.json");
		/*
		MatcherAssert.assertThat(inputJson, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
		This will throw error as it cannot validate File and JsonSchemaValidator and it can validate only like string,anydatatype
		So just convert the File(inputJson) to string using Apache Commons IO dependency 
		*/
		MatcherAssert.assertThat(jsonContent, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
		
//		MatcherAssert.assertThat("input.json", JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//		You can think to do it this way by giving input.json directly i too tried but getting error so better try converting file to string
		
		
	}

}
