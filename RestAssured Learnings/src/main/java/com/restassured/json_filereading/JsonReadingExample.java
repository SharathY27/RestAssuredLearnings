package com.restassured.json_filereading;


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadingExample {

	public static void main(String[] args) throws IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		
		FileReader fileReader = new FileReader("Sharath.json");
		
		
		Object parsedObject = jsonParser.parse(fileReader);
		
		JSONObject jsonObject = (JSONObject) parsedObject;
		
		String name = (String) jsonObject.get("Name");
		
		long age = (Long) jsonObject.get("Age"); //values are stored in long in json
		
		JSONArray jsonArray = (JSONArray) jsonObject.get("Qualities");
		
		Iterator iterator = jsonArray.iterator();
		
		System.out.println("Name is" + name);
		System.out.println("Age is "+ age);
		
		while(iterator.hasNext())
		{
			System.out.println("Qualities :" + iterator.next());
		}
		

	}

}
