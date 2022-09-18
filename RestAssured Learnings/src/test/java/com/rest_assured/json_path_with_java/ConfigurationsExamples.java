package com.rest_assured.json_path_with_java;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class ConfigurationsExamples {

	public static void main(String[] args) {
		 
		String json = "[\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"John\",\r\n"
				+ "        \"gender\":\"male\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"name\":\"Ben\"\r\n"
				+ "    }\r\n"
				+ "]";
		//first method
		//{
		//If u try to get the key which is not present in json..it shows you error and if you want to handle that u need to use addOptions
//		Configuration configuration = Configuration.defaultConfiguration();
		
		//this is for handling errors
//		configuration = configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
//	}
		//Second method
		//{
		Configuration configuration = Configuration
									  .builder()
//									  .options(Option.DEFAULT_PATH_LEAF_TO_NULL) //using this wont throw you error if key is not present
//									  .options(Option.ALWAYS_RETURN_LIST)//this will return list even if u use definite path and must store in list else throw you ClassCastException
									  .options(Option.SUPPRESS_EXCEPTIONS)//this will suppress the errors like same as if there is not key present it will throw null
//									  .options(Option.REQUIRE_PROPERTIES)//this will check key in every data exapmle...* means in expression will check all dictionary for gender key so if gender key is not present in 2nd dictionary it will throw you error..so its like recursive operation
									  .build();
		//}
		//This is definite path
		//Remember store the return value as per Option used..like changing string to list and vice versa
		String gender= JsonPath
				.using(configuration)
				.parse(json)
//				.read("$.[*].gender");    //for requireproperties
//				.read("$.[0].gender");    //for Always return list
//				.read("$.[1].gender");    //for default_path_leaf_to_null
				.read("$.[1].gender");    //for suppress exception
		
		System.out.println(gender);

	}

}
