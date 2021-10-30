package com.CrudOperationWithoutBDD.RestAssuredApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Tc_002_CreateAllData {
	
	@Test
	public void creat() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","rmgyantra");
		jobj.put("projectname", "Chua");
		jobj.put("status", "completed");
		jobj.put("teamsize", 10);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		Response res = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = res.then();	
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType("application/json");
		validate.log().all();
	}

}
