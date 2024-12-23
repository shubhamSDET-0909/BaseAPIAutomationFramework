package com.api.base;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {
	
	/*Class Is responsible for Base URI
	 * Creating the Request
	 * Handling the Response
	 */
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpec;
	
	//Putting in static block so it will be executed only one and made availble
	{
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestSpec = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpec.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(Object payload, String endPoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).put(endPoint);
	}
	
	
	protected Response getRequest(String endPoint) {
		return requestSpec.get(endPoint);
	}

}
