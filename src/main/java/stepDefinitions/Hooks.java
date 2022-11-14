package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		/*	Execute this method to create placeID 
		 * 	Only if the placeID value is null
		 */
		
		StepDefinitions StepDefinitionsObj = new StepDefinitions();
		
		if(StepDefinitions.place_id == null) {
				
			StepDefinitionsObj.add_the_payload_for_the_AddPlace_request("Naveen", "Hyper Street", "French");
			StepDefinitionsObj.user_calls_the_api_with_post_request("addPlaceAPI", "POST");
			StepDefinitionsObj.verify_the_in_the_created_place_id_using_the("Naveen", "getPlaeAPI");
		}
		
	}
}
