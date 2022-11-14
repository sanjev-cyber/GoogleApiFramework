package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class StepDefinitions extends Utils{
	
	// Global variable 
	ResponseSpecification ResponseSpec;
	RequestSpecification Request;
	Response Response;

	TestData testDataObj = new TestData();
	static String place_id;
	
	@Given("Add the Payload for the AddPlace request {string}{string}{string}")
	public void add_the_payload_for_the_AddPlace_request(String Name, String Address, String Language) throws IOException {

		Request = given().spec(RequestSpecification()).
				body(testDataObj.AddPlaceTestData(Name,Address,Language)); // Request 
	    
	}
	
	@When("User calls the {string} API with {string} request")
	public void user_calls_the_api_with_post_request(String resource,String HttpMethod) {
		 
		APIResources getResource = APIResources.valueOf(resource); // Enum Obj
		
		ResponseSpec = new ResponseSpecBuilder().expectStatusCode(200)
					.expectContentType(ContentType.JSON).build(); // Generic Response
		
		if (HttpMethod.equalsIgnoreCase("POST")) {
			Response = Request.when().post(getResource.getResource()); // Response 
		} else if(HttpMethod.equalsIgnoreCase("GET")) {
			Response = Request.when().get(getResource.getResource()); // Response 
		}else if(HttpMethod.equalsIgnoreCase("PUT")) {
			Response = Request.when().put(getResource.getResource()); // Response 
		}
		
		System.out.println(getResource.getResource()); 
		
	    
	}
	
	@Then("API call is success with a status code {int}")	
	public void api_call_is_success_with_a_status_code(Integer int1) {
		
		assertEquals(Response.getStatusCode(), int1);
 
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String param, String paramval) {   
	
		assertEquals(GetjsonPath(Response, param),paramval);

	}
	
	@Then("Verify the {string} in the created place_id using the {string}")
	public void verify_the_in_the_created_place_id_using_the(String Expname, String resource) throws IOException {
		
		
		place_id = GetjsonPath(Response, "place_id");
		
		Request = given().spec(RequestSpecification())
				.queryParam("place_id", place_id);
		
		user_calls_the_api_with_post_request(resource,"Get");
		
		assertEquals(GetjsonPath(Response, "name"),Expname);
		
	}
	
	@Given("Add the address details need to be updates {string} for the UpdatePlace request")
	public void add_the_address_details_need_to_be_updates_for_the_update_place_request(String Address) throws IOException {
		
		Request = given().spec(RequestSpecification()).
				body(testDataObj.UpdatePlaceTestdata(place_id,Address));
	   
	}
	
	
	@Given("Add the Payload for the DeletePlace request")
	public void add_the_payload_for_the_DeletePlace_request() throws IOException {
		
		Request = given().spec(RequestSpecification()).
				body(testDataObj.DeletePlaceTestdata(place_id)); 
	}



	
}
