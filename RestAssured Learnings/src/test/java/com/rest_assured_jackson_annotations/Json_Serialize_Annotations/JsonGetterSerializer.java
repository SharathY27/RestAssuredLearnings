package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGetterSerializer {

	public static void main(String[] args) throws JsonProcessingException {
		
		
		JsonGetterPOJO jsonGetterPOJO = new JsonGetterPOJO();
		
		jsonGetterPOJO.setId(1);
		jsonGetterPOJO.setEmail("Sharath@gmail.com");
		jsonGetterPOJO.setName("Sharath");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonGetterPOJO);
		
		System.out.println(json);
		

	}

}
