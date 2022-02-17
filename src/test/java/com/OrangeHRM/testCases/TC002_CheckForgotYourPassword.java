package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC002_CheckForgotYourPassword extends BaseClass{
	
	@Test
	public void checkForgotYourPasswordLinkText() throws IOException {
		
		//captureScreen(driver, "1. Application launched");
		String expVal="Forgot your password?";
		LoginPage lp = new LoginPage(driver);
		
		String actValue = lp.forgotPasswordLink();
		//captureScreen(driver, "2. Forgot your password? link");
		Assert.assertEquals(actValue, expVal,"Forgot your password? link Text is not matching");
		
		logger.info("Forgot your password? link Text is matching.");
		
	}

}
