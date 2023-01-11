package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class JsonAnyGetterPOJO {
	
	private Map<String,Object> employee;
	

//	IMPORTANT:
//	@JsonAnyGetter Annotation should be used only above get methods and should not be used above set methods
//	Even if you use above set methods it won't throw any error/exceptions rather it will return json as dictionary

	
	@JsonAnyGetter
	public Map<String,Object> getEmployeeWithAnnotation()
	{
		System.out.println("Get Called");
		return employee;
	}
	
	public Map<String,Object> getEmployee()
	{
		System.out.println("Get Called");
		return employee;
	}
	
	
	
	public void setEmployee(Map<String,Object> employee)
	{
		this.employee=employee;
	}
	
	

}
