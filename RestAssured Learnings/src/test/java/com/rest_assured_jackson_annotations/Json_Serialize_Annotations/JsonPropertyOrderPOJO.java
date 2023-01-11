package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


//@JsonPropertyOrder({"id,name,email"})  // This will not work, use correct syntax
//@JsonPropertyOrder(alphabetic = true) this is for arranging in alphabetical order

@JsonPropertyOrder({"id","email","name"})
//@JsonPropertyOrder(alphabetic = true)
public class JsonPropertyOrderPOJO {

	
	private String name;
	private int id;
	private String email;
	
	
	//it only changes the key name priority is more for propertyOrder annotation only if you have mentioned explicitly
	//for alphabetic = true argument it will return based on changed parameters 
	
	@JsonGetter(value = "AemployeeName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonGetter(value = "BemployeeId")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@JsonGetter(value = "CemployeeEmail")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
