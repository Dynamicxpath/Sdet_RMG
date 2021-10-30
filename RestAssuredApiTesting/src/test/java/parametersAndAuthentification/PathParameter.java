package parametersAndAuthentification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathParameter()
	{
		baseURI ="http://localhost";
		port= 5541;
		given()
		.pathParam("projId", " ")
		
		.when()
		.get("/projects/{projId}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
