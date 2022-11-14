package resources;

// Enum is a special class contains all the constants 

public enum APIResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaeAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	updatePlaceAPI("/maps/api/place/update/json");
	
	private String resource;

	APIResources(String resource) {
		this.resource = resource; // Constructor 
	} 
	
	public String getResource() {
		return resource;
	}

}