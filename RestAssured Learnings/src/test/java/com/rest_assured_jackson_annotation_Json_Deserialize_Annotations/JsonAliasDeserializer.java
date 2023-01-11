package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAliasDeserializer {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {


				//  JsonAlias annotation is same as Jsonsetter  
				//  With JsonAlias we can give multiple options as if variable with id is present in POJO
				//  If we try to change to deserialize  employeeId into the id varaible present in POJO we can use @JsonAlias annotation
				
				

				String json = "{\r\n"
						+ "  \"name\" : \"Sharath\",\r\n"
						+ "  \"email\" : \"Sharath@gmail.com\",\r\n"
						+ "  \"employeeId\" : 1\r\n"
						+ "}";
				
				
//				First method
//				ObjectMapper mapper = new ObjectMapper();
				
//				JsonAliasPOJO pojo = mapper.readValue(json, JsonAliasPOJO.class);
				
	
				
//				Second method (Factory method)
	
				JsonAliasPOJO pojo = new ObjectMapper().readerFor(JsonAliasPOJO.class).readValue(json);
				
				System.out.println(pojo.getId());
				

	}

}
