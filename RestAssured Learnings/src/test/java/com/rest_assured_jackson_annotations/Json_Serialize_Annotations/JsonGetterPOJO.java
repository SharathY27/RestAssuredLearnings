package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.annotation.JsonGetter;

import lombok.Getter;
import lombok.Setter;

public class JsonGetterPOJO {

	private int id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	
	// We can also implement getters and setters for name and email as below but i have used lombok to use less code
	// @JsonGetter Annotation is mainly used where if you want the get method to return different key name 
	// For example , in this when we convert this pojo to json we will get keys "id","name","email"
	// If you want to replace "id" with "employeeId" without changing method definition, this annotation is used
	
	
	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */

	

	
	@JsonGetter(value = "employeeId")
	public int getIdWithAnnotation() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */

	
}
