package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreatorDeserializer {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
		//JsonCreator annotation is same as jsonsetter only thing is we will desirialize with POJO constructor
		//  with JsonCreator we will use JsonProperty (or) JsonSetter annotations above each instance variable to work 
		
		// JsonCreater annotation should be used above constructor only

		String json = "{\r\n"
				+ "  \"name\" : \"Sharath\",\r\n"
				+ "  \"email\" : \"Sharath@gmail.com\",\r\n"
				+ "  \"employeeId\" : 1\r\n"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonCreatorPOJO pojo = mapper.readValue(json, JsonCreatorPOJO.class);
		
		
		System.out.println(pojo.getId());
		
		
	}

}
