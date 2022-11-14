Feature: Validating the Place APIs

@AddPlace @Regression
  Scenario Outline: Verify if place is added succesfully using AddPlace API 
  Given Add the Payload for the AddPlace request "<Name>""<Address>""<Language>"
  When User calls the "addPlaceAPI" API with "POST" request
  Then API call is success with a status code 200
  And "status" in response body is "OK" 
  And "scope" in response body is "APP"
  And Verify the "<Name>" in the created place_id using the "getPlaeAPI"
  
  
  Examples:
	
	| Name     | Address       | Language |
	| Sanjeev	 | School Street | English  |
#	| Naveen	 | Hyper Street  | French   |
  
 @DeletePlace @Regression
  Scenario: Verify if place is Deleted succesfully using DeletePlace API 
  Given Add the Payload for the DeletePlace request
  When User calls the "deletePlaceAPI" API with "POST" request
  Then API call is success with a status code 200
  And "status" in response body is "OK" 