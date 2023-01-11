package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JsonCreatorPOJO {

	@JsonCreator
	public JsonCreatorPOJO
			(
			
			@JsonSetter("employeeId") 
			int id, 
			@JsonProperty("name")
			String name,
			@JsonProperty("email")
			String email
			
			)
	{
		this.id=id;
		this.name=name;
		this.email=email;
	}
	
	
	private int id;
	private String name;
	private String email;
	
	
}
