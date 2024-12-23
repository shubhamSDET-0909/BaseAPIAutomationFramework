package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test(description ="Checking User Profile")
	public void getProfileInfo() {
		
		AuthService authService = new AuthService();
		Response resp = authService.login(new LoginRequest("Shubham", "Apitest@7105"));
		LoginResponse loginResp = resp.as(LoginResponse.class);
		
		System.out.println(loginResp.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		resp = userProfileManagementService.getProfile(loginResp.getToken());
		System.out.println(resp.prettyPrint());
		
		
		
	}

}
