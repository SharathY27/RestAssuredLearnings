package com.rest_assured_extra_concepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareTwoJson {

	// Here we are comparing two json using JsonNode which is from Jackson Databind
	
//	IMPORTANT:
//				i) Even if you change the order of key it will return TRUE only
//			   ii) If you change the order of elements in list it will return FALSE    ("REMEMBER")
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json1 = "{\r\n"
				+ "    \"Skills\": [\r\n"
				+ "        \"java\",\r\n"
				+ "        \"Selenium\"\r\n"
				+ "    ],\r\n"
				+ "    \"last_name\": \"Reigns\",\r\n"
				+ "    \"first_name\": \"Roman\",\r\n"
				+ "    \"email\": \"Roamnreignsgmail.com\",\r\n"
				+ "    \"id\": 25\r\n"
				+ "}";
		
		String json2 = "{\r\n"
				+ "    \"Skills\": [\r\n"
				+ "        \"java\",\r\n"
				+ "        \"Selenium\"\r\n"
				+ "    ],\r\n"
				+ "    \"first_name\": \"Roman\",\r\n"
				+ "    \"last_name\": \"Reigns\",\r\n"
				+ "    \"email\": \"Roamnreignsgmail.com\",\r\n"
				+ "    \"id\": 25\r\n"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode jsonNode1 = mapper.readTree(json1);
		
		JsonNode jsonNode2 = mapper.readTree(json2);
		
		System.out.println("Is Two Jsons are same : " + jsonNode1.equals(jsonNode2));
		
	}
	
}
