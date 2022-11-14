package resources;

import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {

	static RequestSpecification Request;
	public RequestSpecification RequestSpecification() throws IOException {
		
		if (Request == null ) {
		 PrintStream Log = new PrintStream(new FileOutputStream("LogFile.text")); // Logging the logs in a file
		 Request =	new RequestSpecBuilder().setBaseUri(getGlobalData("baseUrl"))
				 	.addFilter(RequestLoggingFilter.logRequestTo(Log)) // Request Log
				 	.addFilter(ResponseLoggingFilter.logResponseTo(Log)) // Response Log
				 	.addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON).build(); // Generic Request
		 return Request;
		}
		 return Request;
		
	}

	
	public static String getGlobalData(String key) throws IOException { // get properties from Properties file
		
		Properties Getprop = new Properties();
		
		FileInputStream file = new FileInputStream("E:\\REST_API_Automation\\REST_API_Basics\\RestApiFramework\\src\\main\\java\\resources\\global.properties");
		
		Getprop.load(file);
		return Getprop.getProperty(key);
		
	}
	
	public String GetjsonPath (Response Response, String pram ) {
		
		String response = Response.asString();
		JsonPath jsReponse = new JsonPath(response);
		return	jsReponse.get(pram).toString();
		
		
	}
}
