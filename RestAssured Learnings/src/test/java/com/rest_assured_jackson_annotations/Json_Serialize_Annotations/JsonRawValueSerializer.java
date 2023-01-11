package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRawValueSerializer {

	public static void main(String[] args) throws JsonProcessingException {
	
		JsonRawValuePOJO jsonRawValuePOJO = new JsonRawValuePOJO();
		
		jsonRawValuePOJO.setName("Sharath");
		jsonRawValuePOJO.setEmail("Sharath@gmail.com");
		jsonRawValuePOJO.setId(1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonRawValuePOJO);
		
		System.out.println(json);
		

	}

}
