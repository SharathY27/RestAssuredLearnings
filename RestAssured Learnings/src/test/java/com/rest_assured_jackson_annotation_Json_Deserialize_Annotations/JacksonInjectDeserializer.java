package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import java.io.IOException;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JacksonInjectDeserializer {

	//JacksonInject annotation is used to deserialize value which is not in json in to POJO
	
	//In below Json name is not available but in POJO name variable is avaiable so if you want inject the value into POJO which is not in json
	//Use JacksonInject annotation and this we will read using reader not mapper 
	
	public static void main(String[] args) throws IOException {
		String json = "{\r\n"
				+ "    \"id\": 2,\r\n"
				+ "    \"email\": \"doe@gmail.com\"\r\n"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		InjectableValues values = new InjectableValues.Std().addValue(String.class, "Sharath");
		
		ObjectReader reader = mapper.reader(values);
		
		
		JacksonInjectPOJO  pojo = reader.readValue(json, JacksonInjectPOJO.class);
		
		System.out.println(pojo.getName());
		
		

	}

}
