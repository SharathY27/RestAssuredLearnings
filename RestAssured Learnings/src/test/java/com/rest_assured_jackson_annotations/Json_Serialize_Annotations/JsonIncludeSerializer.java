package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeSerializer {

	public static void main(String[] args) throws JsonProcessingException {
		
		//JsonInclude annotation is used to consider variables based on methods used like NON_NULL,NON_DEFAULT, etc....,
		//For name i have set as null to serialize POJO to Json without Null values we can use @JsonInclude(Include.NON_NULL)
		//For id and age i haven't set any values so default values will be taken while serializing POJO to Json , if default values should not consider for serialization means we can use @JsonInclude(Include.NON_DEFAULT)
		
		JsonIncludePOJO jsonIncludePOJO = new JsonIncludePOJO();
		
		jsonIncludePOJO.setName(null);
		jsonIncludePOJO.setDOB("01/02/03");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonIncludePOJO);
		
		System.out.println(json);

	}

}
