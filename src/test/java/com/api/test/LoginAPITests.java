package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListerner.class)
public class LoginAPITests {

	
	@Test(description = "Verify if Login API Is working..")
	public void loginTest() {
		LoginRequest loginReq = new LoginRequest("Shubham", "Apitest@7105");
		AuthService authService = new AuthService();
		Response resp =authService.login(loginReq);
		LoginResponse loginResp = resp.as(LoginResponse.class);
		
		//System.out.println(resp.prettyPrint());
		System.out.println(loginResp.getToken());
		System.out.println(loginResp.getemail());
		System.out.println(loginResp.getId());

		Assert.assertTrue (loginResp.getToken() !=null);
		Assert.assertEquals(loginResp.getemail(), "sorina8758@ronete.com");
		Assert.assertEquals(loginResp.getId(), 411);
		
		
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
}
