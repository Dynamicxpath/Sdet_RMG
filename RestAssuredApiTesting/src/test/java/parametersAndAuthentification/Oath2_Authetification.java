package parametersAndAuthentification;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oath2_Authetification {
	@Test
	public void oath2Authentification()
	{
		Response res = given()
		.formParam("client_id", "SDET21_RMGY_REST1")
		.formParam("client_secret", "3f30a026894ccbde4091a72cb26a7710")
		.formParam("grant_type", " client_credentials ")
		.formParam("redirect_uri ", " http://example.com")
		.formParam("code","authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		// capture the token
		String token =res.jsonPath().get("access_token");
		System.out.println(token);
		
		// create a new request to access the token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2421")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
	
	}
}

	