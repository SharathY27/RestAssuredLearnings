package com.rest_assured_extra_concepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest_assured.pojo_concepts.Employee;

public class SerializeAndDeserialize {
	
	
	//IMPORTANT : RELATION BETWEEN GETTERS,SETTERS & SERIALIZATION , DESERIALIZATION
	
	//SERIALIZATION:
	//-------------
	//Here we are calling only setter methods explicitly in employee class
	//but while using Object mapper writewithdefaultprettyprinter method the getter methods are called implicitly after setter methods to serialize POJO
	//CHECK THE OUTPUT FOR STATEMENT GOT PRINTED IN CONSOLE WHICH IS IN GETTER METHODS
	
	//DESERIALIZATION:
	//-------------
	//Here we are calling only getter methods explicitly in employee class to see the output
	//but while using Object mapper read value method for deserialization the setters methods are called first implicitly to write value in pojo
	//Then getter methods are called
	//CHECK THE OUTPUT FOR STATEMENT GOT PRINTED IN CONSOLE WHICH IS IN GETTER METHODS
	
	
	
	//So for both operations SETTER METHODS are called first  (^_^)
	
	
	ObjectMapper mapper = new ObjectMapper();
	String employeeJson;
	Employee employee1 = new Employee();
	public void serialize() throws JsonProcessingException
	{
		
		System.out.println("==============================================================================");
		
		employee1.setFirstName("Agni");
		employee1.setLastName("A");
		employee1.setEmail("Agni@agni.com");
		employee1.setSkills(Arrays.asList("Java","Selenium"));
		
		System.out.println("-------------------------------------------------------------------------------");
		
		
		
		//business logic
		
		//POJO = plain old java object
		//here employee1 is POJO and we are going to serialize as json ....this operation is called serialization
	
		
		//to serialize pojo we need to use ObjectMapper
		
		
		employeeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
		
		
		
		
		System.out.println(employeeJson);
		
		System.out.println("==============================================================================");
	}
	
	public void deserialize() throws JsonMappingException, JsonProcessingException
	{

		//deserializing json into POJO
		
		
		System.out.println("==============================================================================");
		
		
		mapper.readValue(employeeJson, Employee.class);
	
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.getLastName());
		System.out.println(employee1.getEmail());
		System.out.println(employee1.getSkills());
		
		System.out.println("==============================================================================");

	}

public static void main(String[] args) throws JsonProcessingException {
		
		SerializeAndDeserialize object = new SerializeAndDeserialize();
		
		object.serialize();
		
		object.deserialize();
	
	}
}
