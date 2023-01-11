package com.rest_assured_construct_POJO_for_complex_json_using_lombok;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Movies {
	
	private String title;
	
	private int year;
	
	private List<String> cast;

	
}
