package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import java.io.IOException;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification())
		.body(data.addPlacePayLoad(name,language,address));
	}

	@When("user call {string} with {string} Http request")
	public void user_call_with_Http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
		response =res.when().get(resourceAPI.getResource());
		
	}

	@Then("the api got sucess with statu code {int}")
	public void the_api_got_sucess_with_statu_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Keyvalue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(getJsonPath(response, Keyvalue), ExpectedValue);
	}
	
	@Then("verify place_id created in maps to {string} using {string}")
	public void verify_place_id_created_in_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id",place_id);	
		user_call_with_Http_request(resource,"GET");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	

}
