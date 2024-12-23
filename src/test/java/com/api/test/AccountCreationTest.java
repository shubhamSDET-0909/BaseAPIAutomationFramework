package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description="Verify If create account is working..")
	public void createAccountTest() {
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("SB")
		.email("sb@yahoo.com")
		.firstName("S")
		.lastName("B")
		.mobileNumber("1234567890")
		.build();
		
		AuthService authService = new AuthService();
		Response resp = authService.signUp(signUpRequest);
		
		System.out.println(resp.prettyPrint());
	}

}
