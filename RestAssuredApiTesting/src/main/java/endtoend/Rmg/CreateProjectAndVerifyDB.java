package endtoend.Rmg;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CrudOperationWithoutBDD.RestAssuredApiTesting.ProjectLibrary;

import genericutility.BaseClass;
import genericutility.EndPointUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


	public class CreateProjectAndVerifyDB extends BaseClass {

		@Test
		public void createProjectAndVerifyInDB() throws Throwable
		{
			// create a project through API
			ProjectLibrary pLib = new ProjectLibrary
					("Girija", "Firefox"+jlib.getRandomNumber(), "Completed", 20);

			Response res = given()
					.contentType(ContentType.JSON)
					.body(pLib)
					.when()
					.post(EndPointUtility.addProject)

			res.then()
			.log().all();

			// cspture the expected data
			String expData = rlib.getJsonData(res, "projectName");
			System.out.println(expData);

			// verify it in batabase
			String query ="slect * from project";
			String actData = dlib.executeQueryAndGetData(query, 2, expData);

			//validate
			Assert.assertEquals(actData, expData);
			System.out.println("Sucessful");
}
	}
