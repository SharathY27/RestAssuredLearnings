package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rest_assured_extra_concepts.Serialization;

public class JsonRootNameSerializer {

	public static void main(String[] args) throws JsonProcessingException {
		
		JsonRootNamePOJO jsonRootNamePOJO = new JsonRootNamePOJO();
		
		jsonRootNamePOJO.setId(1);
		jsonRootNamePOJO.setEmail("Sharath@gmail.com");
		jsonRootNamePOJO.setName("Sharath");
		jsonRootNamePOJO.setSkills(Arrays.asList("Java","Selenium"));
		

		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonRootNamePOJO);
		
		System.out.println(json);

	}

}
