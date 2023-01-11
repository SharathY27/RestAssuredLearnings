package com.rest_assured.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;

import static com.jayway.jsonpath.Filter.*;
import com.jayway.jsonpath.JsonPath;
import static com.jayway.jsonpath.JsonPath.parse;
public class FilterPredicateExample {
	
	
//	Writing predicates using Filter API class
	@Test
	public void filterPredicate1() throws IOException
	{
		File jsonFile = new File("src/test/resources/bookStore.json");
		Filter priceLessThanTen = Filter
								  .filter(
										  Criteria
										  .where("price")
										  .lt(10)
										  
										  );
		
		List<Object> result = JsonPath
							  .parse(jsonFile)
							  .read("$..store.book[?]",priceLessThanTen);
		//Here [?] is like a placeHolder for variable priceLessThanTen 
		//You may get confused so its just a placeholder for Filter Class variable
		
		System.out.println(result);
		
	}
	
	@Test
	public void filterPredicate2() throws IOException
	{
		File jsonFile = new File("src/test/resources/bookStore.json");
		Filter secondPredicate = Filter
								  .filter(
										  Criteria
										  .where("price")
										  .lt(10)
										  .and("category")
										  .is("fiction")
										  
										  );
		
		List<Map<String,Object>> result1 = JsonPath
							  .parse(jsonFile)
							  .read("$..store.book[?]",secondPredicate);
		//Here [?] is like a placeHolder for variable priceLessThanTen 
		//You may get confused so its just a placeholder for Filter Class variable
		
		System.out.println(result1);
		//if you want to do any further operations in result dont store in Object ...store in List<Map<String,Object>>
	}
	
	@Test
	public void filterPredicate3() throws IOException
	{
		//Static import method
		File jsonFile = new File("src/test/resources/bookStore.json");
		Filter thirdFilter	=			  filter(
										  Criteria
										  .where("price")
										  .lt(10)
										  .and("category")
										  .is("fiction")
										  
										  );
		
		List<Map<String,Object>> result2 = parse(jsonFile)
				  						   .read("$..store.book[?].author",thirdFilter);
		
		//Here [?] is like a placeHolder for variable thirdFilter 
		//You may get confused so its just a placeholder for Filter Class variable
							  
		System.out.println(result2);
	 
    }
}
