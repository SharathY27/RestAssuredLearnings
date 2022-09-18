package com.restassured.json_filereading;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWritingExample {

	public static void main(String[] args) throws IOException 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name", "Sharath");
		jsonObject.put("Age",23);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("Magical smile");
		jsonArray.add("Magetci Eyes");
		
		jsonObject.put("Qualities", jsonArray);
		
		FileWriter fileWriter = new FileWriter("Sharath.json");
		fileWriter.write(jsonObject.toJSONString()); //jsonObject.toString() will also work
		fileWriter.close();
	}

}
