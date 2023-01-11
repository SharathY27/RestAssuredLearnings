package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonAnySetterDeserializer {
	
	// In JsonAnySetter Annotation we did serialized map into json 
	// Here we are deserialized Json in to map using JsonAnySetter
	// Remind to change the setter method in POJO class

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "  {\r\n"
				+ "    \"firstName\": \"Muthu\",\r\n"
				+ "    \"lastName\": \"Paavai\",\r\n"
				+ "    \"email\": \"muthu@pavai.com\",\r\n"
				+ "    \"skills\": [\r\n"
				+ "      \"Front-End\"\r\n"
				+ "    ],\r\n"
				+ "    \"id\": 13\r\n"
				+ "  }";
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		JsonAnySetterPOJO  pojo = mapper.readValue(json, JsonAnySetterPOJO.class);
		
		System.out.println(pojo.getEmployee());
		
		

	}

}
