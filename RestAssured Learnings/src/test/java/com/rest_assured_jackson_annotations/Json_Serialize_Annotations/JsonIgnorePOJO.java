package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({"age","name"})  	// this is variable level assigning
public class JsonIgnorePOJO {

	private int id;
	private String name;
	private String DOB;
	
	//Like here DOB is already mentioned age is not needed so you can ignore age variable while serializing
	
	//@JsonIgnore      //this is variable level assigning
	private int age;
	
	
	
}
