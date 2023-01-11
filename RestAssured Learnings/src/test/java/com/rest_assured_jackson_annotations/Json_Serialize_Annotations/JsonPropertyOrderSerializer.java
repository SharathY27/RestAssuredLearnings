package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertyOrderSerializer {

	public static void main(String[] args) throws JsonProcessingException {
		
	JsonPropertyOrderPOJO jsonPropertyOrderPOJO = new JsonPropertyOrderPOJO();
		
//	When we serialize we will get json as same order in POJO 
//	If we want to change the order of elements in json we need to use @JsonPropertyOrder annotation
	
		jsonPropertyOrderPOJO.setId(1);
		jsonPropertyOrderPOJO.setEmail("Sharath@gmail.com");
		jsonPropertyOrderPOJO.setName("Sharath");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonPropertyOrderPOJO);
		
		System.out.println(json);
		

	}

}
