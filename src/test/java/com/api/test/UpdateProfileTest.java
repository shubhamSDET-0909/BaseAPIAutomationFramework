package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.request.UserProfileResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Checking Update Profile")
	public void UpdateProfileTest() {
		
		AuthService authService = new AuthService();
		Response resp = authService.login(new LoginRequest("Shubham", "Apitest@7105"));
		LoginResponse loginResp = resp.as(LoginResponse.class);
		System.out.println(resp.asPrettyString());
		
		System.out.println("*********************************************************");
		
		UserProfileManagementService userManagementService = new UserProfileManagementService();
		resp = userManagementService.getProfile(loginResp.getToken());
		System.out.println(resp.asPrettyString());
		UserProfileResponse userProfileResp = resp.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResp.getUsername(), "shubham");
		ProfileRequest  profileRequest = new ProfileRequest.Builder()
				.firstname("Shubham2")
				.lastname("bhutkar")
				.email("sorina8111@ronete.com")
				.mobilenumber("7777799999")
				.build();
			
		System.out.println("*********************************************************");
		resp = userManagementService.updateProfile(loginResp.getToken(), profileRequest);
		System.out.println(resp.asPrettyString());
	}
	
}
