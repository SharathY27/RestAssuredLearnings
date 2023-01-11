package com.rest_assured_jackson_annotaion_custom_serializer;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonSerialize(using = CustomSerializer.class)
public class JsonCustomSerializerPOJO {

	private int id;
	private String name;
	private String email;
	private List<String> skills;
	private List<String> languagesKnown;
		

}
