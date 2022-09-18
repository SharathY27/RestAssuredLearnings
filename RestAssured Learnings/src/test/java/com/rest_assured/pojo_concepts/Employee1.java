package com.rest_assured.pojo_concepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1 {

	public static void main(String[] args) throws JsonProcessingException {
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Agni");
		employee1.setLastName("A");
		employee1.setEmail("Agni@agni.com");
		employee1.setSkills(Arrays.asList("Java","Selenium"));
		
		//business logic
		
		//POJO = plain old java object
		//here employee1 is POJO and we are going to serialize as json ....this operation is called serialization
		
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.getLastName());
		System.out.println(employee1.getEmail());
		System.out.println(employee1.getSkills());
		
		//to serialize pojo we need to use ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		String employeeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
		
		System.out.println(employeeJson);
		
		

	}

}
