package genericutility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	
	public DataUtility dlib = new DataUtility();
	public RestAssuredUtility rlib = new RestAssuredUtility();
	public Javautillity jlib = new Javautillity();
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		dlib.connectToDB();
		baseURI ="http://localhost";
		port =8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dlib.closeDB();
	}
}


