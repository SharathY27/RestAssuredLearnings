package com.rest_assured_construct_POJO_for_complex_json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		
		SuperHeroMoviesAndTVSeries heroMoviesAndTVSeries = new SuperHeroMoviesAndTVSeries();
		
		heroMoviesAndTVSeries.setCategory("Super Hero Movies and Tv superGirl");
		
		List<String> acceptedFranchises = new ArrayList<String>();
		
		acceptedFranchises.add("DC");
		acceptedFranchises.add("Marvel");
		
		heroMoviesAndTVSeries.setAcceptedFranchises(acceptedFranchises);
		
		List<String> genres = new ArrayList<String>();
		
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Heroic");
		genres.add("Dark");
		genres.add("Funny");
		
		
		heroMoviesAndTVSeries.setGenres(genres);
		
		Movies batman = new Movies();
		
		batman.setTitle("Batman: The Dark Knight");
		batman.setYear(2008);
		
		List<String> batmanCast = new ArrayList<String>();
		
		batmanCast.add("Christian Bale");
		batmanCast.add("Heath Ledger");
		
		batman.setCast(batmanCast);
		
		Movies jl = new Movies();
		
		jl.setTitle("Justice League: Snyder cut");
		jl.setYear(2021);
		
		List<String> jlCast = new ArrayList<String>();
		
		jlCast.add("Henry Cavil");
		jlCast.add("Gal Gadot");
		
		jl.setCast(jlCast);
		
		
		Movies avengersAOU = new Movies();
		
		avengersAOU.setTitle("Avengers : Age of Ultron");
		avengersAOU.setYear(2015);
		
		List<String> avengersAOUCast = new ArrayList<String>();
		
		avengersAOUCast.add("Robert Downey, Jr.");
		avengersAOUCast.add("Chris Evans");
		
		avengersAOU.setCast(avengersAOUCast);
		
		
		Movies avengers = new Movies();
		
		avengers.setTitle("The Avengers");
		avengers.setYear(2012);
		
		List<String> avengersCast = new ArrayList<String>();
		
		avengersCast.add("Chris Evans");
		avengersCast.add("Chris Hemsworth");
		
		avengers.setCast(avengersCast);
		
		TVSeries flash = new TVSeries();
		
		flash.setTitle("Flash");
		flash.setYear(2014);
		
		TVSeries gotham = new TVSeries();
		
		gotham.setTitle("Gotham");
		gotham.setYear(2014);
		
		TVSeries superGirl = new TVSeries();
		
		superGirl.setTitle("Super Girl");
		superGirl.setYear(2015);
		
		OtherDetails otherDetails = new OtherDetails();
		
		otherDetails.setCountry("Only USA. Engalukku Verngum kilaigal kedayathu");
		otherDetails.setLanguage("Aliena iruntalum English karanda");
		
		
		List<Movies> allMovies = new ArrayList<Movies>();
		
		allMovies.add(batman);
		allMovies.add(jl);
		allMovies.add(avengersAOU);
		allMovies.add(avengers);
		
		
		List<TVSeries> allTvSeries = new ArrayList<TVSeries>();
		
		allTvSeries.add(flash);
		allTvSeries.add(gotham);
		allTvSeries.add(superGirl);
		
		heroMoviesAndTVSeries.setMovies(allMovies);
		heroMoviesAndTVSeries.setTvSeries(allTvSeries);
		heroMoviesAndTVSeries.setOtherDetails(otherDetails);
		
		ObjectMapper mapper = new ObjectMapper();
		
		File json = new File("complex_json.json");
		
		mapper
		.writerWithDefaultPrettyPrinter()
		.writeValue(json, heroMoviesAndTVSeries);
		
		
		
		
		
		
		
	}
}
