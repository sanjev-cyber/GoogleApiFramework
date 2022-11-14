package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {

	public AddPlace AddPlaceTestData(String Name, String Address, String Language) {
		AddPlace AddPlaceOj = new AddPlace();

		// Setting The values 
		AddPlaceOj.setAccuracy(50);
		AddPlaceOj.setPhone_number("(+91) 983 893 1123");
		AddPlaceOj.setWebsite("http://google.com");
		
		// Data given dynamically 
		AddPlaceOj.setName(Name);
		AddPlaceOj.setLanguage(Language);
		AddPlaceOj.setAddress(Address);
		
		// Set TypeList 
		List<String> typesList = new ArrayList<String>();
		typesList.add("shoe park");
		typesList.add("shop");
		
		AddPlaceOj.setTypes(typesList);
		
		// Set Location
		Location locationObj = new Location();
		locationObj.setLat(-38.383494);
		locationObj.setLng(33.427362);
		
		AddPlaceOj.setLocation(locationObj);
		
		return AddPlaceOj;

	}
	
	public String DeletePlaceTestdata(String placeId) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
}
