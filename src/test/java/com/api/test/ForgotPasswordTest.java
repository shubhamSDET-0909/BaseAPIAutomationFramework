package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="Verify If Forgot password is working..")
	public void forgotPasswordTest() {
		
		
		AuthService authService = new AuthService();
		Response resp = authService.forgotPassword("sorina8758@ronete.com");
		
		System.out.println(resp.prettyPrint());
	}

}
