package com.rest_assured.json_path_with_java;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


public class ReadingAJsonDocument {

	
	@Test
	public void readAJson() throws IOException
	{
		
		//This the simplest way / basic way
		File jsonFile = new File("src/test/resources/bookStore.json");
		
		List<Object> priceList =  JsonPath.read(jsonFile, "$..price");
		
		for(Object price : priceList)
		System.out.println(price);
	}
	
	
	@Test
	public void parseJsonOneTime() throws IOException
	{
//		This is the Better way
//		File jsonFile = new File("src/test/resources/bookStore.json");
//		
//		List<Object> priceList =  JsonPath.read(jsonFile, "$..price");
//		List<Object> titleList =  JsonPath.read(jsonFile, "$..title");
//		List<Object> categoryList =  JsonPath.read(jsonFile, "$..category");
		
		//if you want to check multiple expressions so if you do it above method it is not and it will parse json every time when read method is called
		// we need to use configuration class so that no need to parse multiple times can parse only one time and can check multiple expression
		
		FileInputStream jsonFile = new FileInputStream("src/test/resources/bookStore.json");
		
	
		Object parsedJsonDocument = Configuration
									.defaultConfiguration()
										.jsonProvider();
//										.parse(json);
//										.parse(jsonFile.readAllBytes());
		
		List<Object> categoryList = JsonPath.read(parsedJsonDocument, "$..category");
		
		System.out.println(categoryList);
	}
	
	@Test
	public void fluentAPI() throws IOException
	{
//		This is the BEST way
		File jsonFile = new File("src/test/resources/bookStore.json");
		
		//First method 
		DocumentContext context = JsonPath.parse(jsonFile);
		List<Object> titleList = context.read("$..title");
		System.out.println(titleList);
		
		//secondMethod
		Configuration configuration = Configuration.defaultConfiguration();
		
		List<Map<String,Object>> titeList2 =  JsonPath						
								  .using(configuration)
								  .parse(jsonFile)
								  .read("$..title");
		
		System.out.println(titeList2);
		
		//if you want to do any further operations in result dont store in Object ...store in List<Map<String,Object>> 
		
	}
	

}
