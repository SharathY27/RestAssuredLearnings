package com.rest_assured.json_schema_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkNtJsonSchemaValidation {
	
	@Test
	public void validateJsonSchema() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V6);
		//V6 is what kind of version used to convert json to json schema
		//This validation using Jackson databind library and using NetworkNt method

		
		File inputJson = new File("src/test/resources/input.json");
		FileInputStream schemaJson = new FileInputStream("src/test/resources/RequestSchema.json");
		
		//readTree accepts File object
		JsonNode jsonNode = mapper.readTree(inputJson);
		
		//getSchema doesn't accept File object so creating other ways like InputStream ,String etc.,
		//Here i created another schema file which validate request specified in input json
		JsonSchema jsonSchema = factory.getSchema(schemaJson);
		
		//IMPORTANT : To know what kind of files format the method accepts you can just control space for suggestions so that you can know
//		jsonSchema.validate(jsonNode);
		
		Set<ValidationMessage> result = jsonSchema.validate(jsonNode);
		if(result.isEmpty()) {
			System.out.println("No Validation Errors");
		}
		else {
			for(ValidationMessage message : result)
			{
				System.out.println(message);
			}
		}
		
		
	}

}
