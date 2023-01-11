package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class JsonRawValuePOJO {

	private int id;
	private String name;
	private String email;
	
	@JsonRawValue     
//	private String skills="Java";                           //Here to get Java without double quotes in json we use @JsonRawValue annotation
	private String skills="{[\"Selenium\"],[\"Java\"]}";     //Here to get skills without slashes in json we use @JsonRawValue annotation  
	
	public int getId() {
		return id;
	}
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
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills  = skills;
	}
	
	
	
}
