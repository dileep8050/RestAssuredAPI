Feature: validating place API's 

@Special
Scenario Outline: Verify if place is being successfully added by using AddPlaceAPI
	Given Add place payload with "<name>" "<language>" "<address>"
	When user call "AddPlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created in maps to "<name>" using "getPlaceAPI"

Examples:
|name 	 | language |address		   |
|Dileephouse |  English |World cross center|
|BBhouse | Spanish  |Sea cross center  |
|BBhouse1 | Spanish1  |Sea cross center1  |
|BBhouse2 | Spanish2  |Sea cross center2  |

@Reg
Scenario: Verify if Delete Place functionality is working

Given DeletePlace Payload
	When user call "deletePlaceAPI" with "Post" Http request
	Then the api got sucess with statu code 200
	And "status" in response body is "OK1"