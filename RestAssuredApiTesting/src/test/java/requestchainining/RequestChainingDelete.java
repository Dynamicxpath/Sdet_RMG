package requestchainining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;

import genericutility.Javautillity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingDelete {
	@Test
	public void pathParametrerfordelete() {
		Javautillity jlib = new Javautillity();

		baseURI = "http://localhost";
		port = 5541;

		// create a project
		ProjectLibrary plib = new ProjectLibrary
				("Girija1", "Nerolac"+jlib.getRandomNumber(), "Completed", 25);

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




