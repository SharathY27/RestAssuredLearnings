package com.rest_assured.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.Predicate.PredicateContext;

public class CustomPredicateExamples {

	File jsonFile = new File("src/test/resources/bookStore.json");

	@Test
	public void myCustomPredicate() throws IOException {
		File jsonFile = new File("src/test/resources/bookStore.json");

		// Here predicate is a interface and we cannot create object with it so don't
		// confuse
		// This method is called anonymous function
		// First Method
		
		  Predicate booksWithISBN = new Predicate() {
		  
		  public boolean apply(PredicateContext ctx) { boolean predicate =
		  ctx.item(Map.class).containsKey("isbn"); return predicate; }
		  
		  };
		  
		  
		  
		  List<Map<String,Object>> result = JsonPath .parse(jsonFile)
		  .read("$.store.book[?].title",booksWithISBN);
		  
		  System.out.println(result);
		  
		 
	}

	@Test
	public void myCustomPredicateUsingLambdaFunction() throws IOException {
		File jsonFile = new File("src/test/resources/bookStore.json");

		// Second method using Lambda function
		Predicate booksWithISBN2 = ctx -> ctx.item(Map.class).containsKey("isbn");

		List<Map<String, Object>> result1 = JsonPath.parse(jsonFile).read("$.store.book[?].title", booksWithISBN2);

		System.out.println(result1);

	}

}
