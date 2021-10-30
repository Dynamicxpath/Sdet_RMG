package requestchainining;

import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;
import static io.restassured.RestAssured.*;
import genericutility.Javautillity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class RequestChainningForGet {
	
	@Test
	public void requestChainingForGet()
	{
		Javautillity  jlip = new Javautillity ();
		baseURI ="http://localhost";
		port= 5541;
		
		ProjectLibrary plib = new ProjectLibrary
				("Girija1", "Nerolac"+jlip.getRandomNumber(), "Completed", 25);

		Response res = given()
				.contentType(ContentType.JSON)
				.body(plib)
				.when()
				.post("/addProject");

		//capture the project id using json path
		String myprojID = res.jsonPath().get("projectId");
		System.out.println(myprojID);

		res.then().log().all();

		//this is second request to delete the same project created in 1st request
		given()
		.pathParam("projID", myprojID)

		.when()
		.delete("/projects/{projID}")

		.then().assertThat().statusCode(204).log().all();

	}
}
