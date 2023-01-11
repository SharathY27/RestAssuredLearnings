package com.rest_assured.pojo_concepts;

import java.util.List;

public class Employee {
	
	//Assume UI developed and u get data from there
	
	private String firstName;
	private String lastName;
	private String email;
	private List skills;
	public String getFirstName() {
		System.out.println("GETTER firstName");
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("SETTER firstName");
		this.firstName = firstName;
	}
	public String getLastName() {
		System.out.println("GETTER lastName");
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("SETTER lastName");
		this.lastName = lastName;
	}
	public String getEmail() {
		System.out.println("GETTER Email");
		return email;
	}
	public void setEmail(String email) {
		System.out.println("SETTER Email");
		this.email = email;
	}
	public List getSkills() {
		System.out.println("GETTER skills");
		return skills;
	}
	public void setSkills(List skills) {
		System.out.println("SETTER skills");
		this.skills = skills;
	}
	
	

}
