package com.rest_assured_construct_POJO_for_complex_json;

import java.util.List;

public class Movies {
	
	private String title;
	
	private int year;
	
	private List<String> cast;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

}
