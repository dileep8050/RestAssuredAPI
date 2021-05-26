package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
{
		StepDefinition m=new StepDefinition();
		if(StepDefinition.place_id==null) {
		m.add_place_payload_with("Pooji", "Kannada", "bennavara");
		m.user_call_with_Http_request("AddPlaceAPI", "Post");
		m.verify_place_id_created_in_maps_to_using("Pooji", "getPlaceAPI");
	}
		
	}
	
}
