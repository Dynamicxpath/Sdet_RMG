package complexResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse {
	@Test
	
	public void staticResponse()
	{
		baseURI ="http://localhost";
		port= 5541;
		
		String expDAtA="TY_PROJ_1002";
		//strore all the responses
		   Response res = when()
				  .get("/projects");
		  
		  String actDATA= res.jsonPath().get("[0].projectId");
		  System.out.println(actDATA);
		  
		  //VALIDATE
		  Assert.assertEquals(actDATA,expDAtA);
		  System.out.println(actDATA + "data verified");
		  res.then().log().all();
	}

}
