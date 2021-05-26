Feature: Postive flow scenarios 

@Reg
Scenario: Verify validation if place is being successfully added by using AddPlaceAPI
	Given Add place payload with "BBhouse" "Spanish" "Sea cross center"
	When user call "AddPlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created in maps to "BBhouse" using "getPlaceAPI"



@Reg
Scenario: Verify validation if Delete Place functionality is working  

Given DeletePlace Payload
	When user call "deletePlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK"