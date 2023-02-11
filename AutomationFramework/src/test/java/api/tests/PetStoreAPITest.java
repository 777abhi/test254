package api.tests;

import org.testng.annotations.Test;

import api.files.Payload;
import api.files.Utility;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PetStoreAPITest {
	
	@Test
	public void AddPet() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		String addPetResponse = given().log().all().header("Content-Type", "application/json")
				                .body(Payload.AddPet())
				                .when().post("pet")
				                .then().log().all()
				                .assertThat().statusCode(200).extract().response().asString();				                	
	}
	
	@Test
	public void UpdatePet() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		String addPetResponse = given().log().all().header("Content-Type", "application/json")
				                .body(Payload.AddPet())
				                .when().post("pet")
				                .then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Utility.rawToJson(addPetResponse);  
	    String id = js.getString("id");
	    
	    String updatePetResponse = given().log().all().header("Content-Type", "application/json")
                .body(Payload.UpdatePet())
                .when().put("pet")
                .then().log().all()
                .assertThat().statusCode(200).extract().response().asString();				                	
	}
	
	@Test
	public void GetPet() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		String getPetResponse = given().log().all().header("Content-Type", "application/json")
				                .body(Payload.AddPet())
				                .when().get("pet/5")
				                .then().log().all()
				                .assertThat().statusCode(200).extract().response().asString();			                	
	}
}
