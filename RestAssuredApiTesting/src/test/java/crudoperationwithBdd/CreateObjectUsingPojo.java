package crudoperationwithBdd;

import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;

import genericutility.Javautillity;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class CreateObjectUsingPojo {
    @Test
	public void createProjectUsingPojo() {
	
    	Javautillity jlib= new Javautillity();
		baseURI="http://localhost";
		port=5541;
		ProjectLibrary pLip= new ProjectLibrary("Girija","skillary " +jlib.getRandomNumber(),"completed", 10);
		
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
		.statusCode(201)
		.log().all();
		
		//String string = all.toString();
		//System.out.println(string);
		
		
	}
}
