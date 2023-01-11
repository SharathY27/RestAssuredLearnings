package com.rest_assured_jackson_annotation_Json_Deserialize_Annotations;

import com.fasterxml.jackson.annotation.JsonSetter;

public class JsonSetterPOJO {

	private int id;
	private String name;
	private String email;
	
	
	
	public int getId() {
		return id;
	}
	
	
	@JsonSetter(value = "employeeId")
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
