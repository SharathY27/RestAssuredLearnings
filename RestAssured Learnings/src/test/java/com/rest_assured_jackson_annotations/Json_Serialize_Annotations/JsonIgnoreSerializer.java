package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreSerializer {

	public static void main(String[] args) throws JsonProcessingException {
		
		//Even if we set the value for POJO using setter method 
		// If JsonIgnore is used it will not consider while serialization
		// REMEMBER :  
//				JsonIgnoreProperties should be used over class
//		 		JsonIgnore should be over variables
		
		JsonIgnorePOJO jsonIgnorePOJO = new JsonIgnorePOJO();
		
		jsonIgnorePOJO.setName("Sharath");
		jsonIgnorePOJO.setId(1);
		jsonIgnorePOJO.setDOB("01/02/03");
		jsonIgnorePOJO.setAge(24);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonIgnorePOJO);
		
		System.out.println(json);

	}

}
