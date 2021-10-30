package crudoperationwithBdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class RMG_API_PROJECT_05 {
	 @Test
		public void createProjectUsingPojo() {
		
			baseURI="http://localhost";
			port=5541;
			ProjectLibrary pLip= new ProjectLibrary("rmg","rmgproject","completed", 10);
			
			//request specification
		      ValidatableResponse all = given()
			.contentType(ContentType.HTML)
			.body(pLip)
			 
			//request
			.when()
			.post("/addProject")
			
			//validation
			
			.then()
			//.assertThat()
			//.statusCode(500)
			.log().all();
			
			String string = all.toString();
			System.out.println(string);
			
			
		}
	}




