package genericutility;

import io.restassured.response.Response;

public class RestAssuredUtility {
	
	/* This class contains generic methods pertaining to rest-assured
	 * @Girija
	 * 
	 * 
	 */
public String getJsonData(Response res,String jsonPath) {
		
		String value = res.jsonPath().get(jsonPath);
		return value;
		
}
}
