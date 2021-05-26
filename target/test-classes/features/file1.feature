Feature: File 1 scenarios 

@Reg
Scenario: File 1 Verify validation if place is being successfully added by using AddPlaceAPI
	Given Add place payload with "BBhouse" "Spanish" "Sea cross center"
	When user call "AddPlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created in maps to "BBhouse" using "getPlaceAPI"



@Reg
Scenario: File 1 Verify validation if Delete Place functionality is working  

Given DeletePlace Payload
	When user call "deletePlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK"