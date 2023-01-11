package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueSerializer {

	public static void main(String[] args) throws JsonProcessingException {
	
		JsonValuePOJO jsonValuePOJO = new JsonValuePOJO();
		
		jsonValuePOJO.setName("Sharath");
		jsonValuePOJO.setEmail("Sharath@gmail.com");
		jsonValuePOJO.setId(1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonValuePOJO);
		
		System.out.println(json);

	}

}
