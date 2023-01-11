package com.rest_assured_jackson_annotaion_custom_serializer;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;



public class JsonCustomSerializerSerializer {

	
	public static void main(String[] args) throws JsonProcessingException {
		
		
		//If you dont want some elements/key value pair you can create custom serializer to have certain fields alone
		JsonCustomSerializerPOJO jsonCustomSerializerPOJO = new JsonCustomSerializerPOJO();
		
		jsonCustomSerializerPOJO.setEmail("Sharath");
		jsonCustomSerializerPOJO.setId(1);
		jsonCustomSerializerPOJO.setLanguagesKnown(Arrays.asList("Tamil","English"));
		jsonCustomSerializerPOJO.setName("Sharat");
		jsonCustomSerializerPOJO.setSkills(Arrays.asList("Java","Selenium"));
		
		ObjectMapper mapper = new ObjectMapper();

		// Here we are adding our custom serializer over this serializer with help of mapper
		//We can also comment below three lines and use @JsonSerialize(using = CustomSerialiazer) annotation in POJO class 
		
		/*
		 * SimpleModule simpleModule = new SimpleModule();
		 * 
		 * simpleModule.addSerializer(JsonCustomSerializerPOJO.class, new
		 * CustomSerializer());
		 * 
		 * mapper.registerModule(simpleModule);
		 */
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonCustomSerializerPOJO);
		
		System.out.println(json);
		
		

	}

}
