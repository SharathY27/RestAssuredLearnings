package com.rest_assured.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class KnowWhatYourJsonPathIsReturning {

	@Test
	public void returnType() throws IOException 
	{
		//Definite Path 
		//Indefinite Path = deep scan(..) , [?(expression)] , [0,1] or [0:2] or [*]
		//Indefinite path always store in List
		//For Definite Path you need to know the json path return type and store it in desired datatype  
		File jsonFile = new File("src/test/resources/bookStore.json");
		
		DocumentContext context = JsonPath.parse(jsonFile);
		
		//Definite Path
		Double price = context.read("$.store.book[1].price");
		System.out.println(price);
		
		System.out.println("===================================================================");
		//Definite Path
		String authorName = context.read("$.store.book[1].author");
		System.out.println(authorName);
		
		System.out.println("===================================================================");
		//Indefinite Path
		List<Object> authorsList = context.read("$..store.book[1].author");
		
		for(Object author : authorsList )
			System.out.println(author);
		
//		Configuration  configuration = Configuration.defaultConfiguration();
//		List<Object> authorList2 = JsonPath
//								   .using(configuration)
//								   .parse(jsonFile)
//								   .read("$..author");
//
//		System.out.println(authorList2);
	}

}
