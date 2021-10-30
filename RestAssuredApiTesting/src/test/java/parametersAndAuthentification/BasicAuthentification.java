package parametersAndAuthentification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthentification {
    @Test
    public void basicAuthentification()
    {
    	baseURI ="http://localhost";
		port= 5541;
    	              given()
    		    	   .auth()
    		    	   .basic("rmgyantra", "rmgy@9999")
    		    	 .when()
    		    	    .get("/login")
    		    	    
    		    	 .then()
    		    	  .assertThat().statusCode(202)
    		    	   .log().all();
    	 
    		}

    	

    }

