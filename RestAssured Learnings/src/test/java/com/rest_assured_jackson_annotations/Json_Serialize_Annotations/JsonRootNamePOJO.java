package com.rest_assured_jackson_annotations.Json_Serialize_Annotations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName(value = "employee")
public class JsonRootNamePOJO {

	// @JsonRootName annotation will used to conver the json into dictionary with root element
	// While using this annotation remember to enable Serialization feature in mapper
	// ===> mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
	
	private int id;
	private String name;
	private String email;
	private List<String> skills;
	
}
