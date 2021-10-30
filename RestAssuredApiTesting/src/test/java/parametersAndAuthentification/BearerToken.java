package parametersAndAuthentification;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken()
	{   
		
		HashMap map = new HashMap();
		map.put("name","Sdet_21_BearerToken");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("http://api.github.com/user/repos")
		
		.then().log().all();
	}

}
