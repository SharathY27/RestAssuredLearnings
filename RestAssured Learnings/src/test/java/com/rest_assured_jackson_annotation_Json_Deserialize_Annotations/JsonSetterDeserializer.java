package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSetterDeserializer {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
		// In JsonGetter Annotation we have modified one of json key "id" to "employeeId"
		// So when we try to Deserialize to same POJO which dont have employeeId as variable 
		// At that time @JsonSetter annotation is used
		
		//Frequent Error Faced using Deserialization =  UnrecognizedPropertyException
		
		String json = "{\r\n"
				+ "  \"name\" : \"Sharath\",\r\n"
				+ "  \"email\" : \"Sharath@gmail.com\",\r\n"
				+ "  \"employeeId\" : 1\r\n"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonSetterPOJO pojo = mapper.readValue(json, JsonSetterPOJO.class);
		
		
		System.out.println(pojo.getId());
		

	}

}
