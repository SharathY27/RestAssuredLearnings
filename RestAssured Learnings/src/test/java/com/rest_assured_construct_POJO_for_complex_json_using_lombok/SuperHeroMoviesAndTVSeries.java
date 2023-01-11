package com.rest_assured_construct_POJO_for_complex_json_using_lombok;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperHeroMoviesAndTVSeries {

	private String category;
	
	private List<String> acceptedFranchises;
	
	private List<String> genres;
	
	private List<Movies> movies;
	
	private List<TVSeries> tvSeries;
	
	private OtherDetails otherDetails;



}
