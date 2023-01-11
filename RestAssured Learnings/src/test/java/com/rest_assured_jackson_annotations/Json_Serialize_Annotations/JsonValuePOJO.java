package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonValuePOJO {
	
	private int id;
	private String name;
	private String email;
	
	// @JsonValue annotation is used for custom serialization like when we will think that this POJO will return JSON 
	// but actually it will return 0 because we customized to use this particular method to serialize
	
//	If you use @JsonValue Annotations on multiple methods it will throw  InvalidDefinitionException
	
	/*
	 * @JsonValue public int useThis() { return 0; }
	 */
	
	@JsonValue
	public String useThis2()
	{
		return this.name;
	}

}
