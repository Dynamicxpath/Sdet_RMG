
package crudoperationwithBdd;

import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class RMG_API_Project_02 {
    @Test
	public void createProjectUsingPojo() {
	
		baseURI="http://localhost";
		port=5541;
		ProjectLibrary pLip= new ProjectLibrary("Girija","jack1	","completed", 10);
		
		//request specification
	      ValidatableResponse all = given()
		.contentType(ContentType.JSON)
		.body(pLip)
		 
		//request
		.when()
		.post("/addProject")
		
		//validation
		
		.then()
		.assertThat()
		.statusCode(500)
		.log().all();
		
		//String string = all.toString();
		//System.out.println(string);
		
		
	}
}
