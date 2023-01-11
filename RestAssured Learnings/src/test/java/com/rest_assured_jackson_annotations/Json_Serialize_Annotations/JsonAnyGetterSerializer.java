package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAnyGetterSerializer {

	
	public static void main(String[] args) throws JsonProcessingException {
		
		JsonAnyGetterPOJO jsonAnyGetterPOJO = new JsonAnyGetterPOJO();
		
		Map<String,Object> empValues = new HashMap<String, Object>();
		
		empValues.put("firstName", "Sharath");
		empValues.put("lastName", "Yuvaraj");
		empValues.put("email", "sharath@gmail.com");
		empValues.put("Skills", Arrays.asList("Java","Selenium","Rest Assured"));
		
		
		
		jsonAnyGetterPOJO.setEmployee(empValues);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empValues);
		
		System.out.println("Map into Json " +json);  ///In this we are converting map into json using obj mapper
		
		System.out.println("=======================================================================================");
		
		String pojoJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonAnyGetterPOJO);
		
		System.out.println("POJO to json "+ pojoJson);  // In this we are converting POJO which contains map into JSON
//		IMPORTANT:
//			@JsonAnyGetter Annotation should be used only above get methods and should not be used above set methods
//			Even if you use above set methods it won't throw any error/exceptions rather it will return json as dictionary
		
		
//		Note:  
//			Previously when we try to convert employee POJO(which has separate values not map) to json we will get exact json  without top node/key
//			But when we convert POJO which itself contains map means its returning json with key in root node like dictionary in python
//			Remember As we already know whenever we are passing only POJO object as argument for mapper method 
//			by implicitly getter method was called 
		
		System.out.println("=======================================================================================");
		
		//I am using two get methods in JsonAnyGetterPOJO class so by default all get methods will be called implicitly
		//so  i am just calling the method with annotation to show the difference
		
		String pojoJsonwithJsonAnyGetterAnnotation = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonAnyGetterPOJO.getEmployeeWithAnnotation());
		
		System.out.println("POJO to json "+ pojoJsonwithJsonAnyGetterAnnotation);  // In this we are converting POJO which contains map into JSON
		
	}
}
