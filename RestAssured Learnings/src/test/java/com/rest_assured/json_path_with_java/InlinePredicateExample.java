package com.rest_assured.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredicateExample {
	
	
	public static void inlinePredicate()
	{
		File jsonFile = new File("src/test/resources/bookStore.json");
		//[?()] = this is predicate
		// $.store.book[?(@.price<10)]
		try {
			List<Object> result = JsonPath.parse(jsonFile).read("$.store.book[? (@.price<10 && @.category =='fiction')].author");
			
			System.out.println(result);
			
			//if you want to negation operation just use ! before predicate expression
			
			List<Object> result1 = JsonPath.parse(jsonFile).read("$.store.book[?(!(@.price<10 && @.category =='fiction'))].author");
			
			System.out.println(result1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		
		 inlinePredicate();
		

	}

}
