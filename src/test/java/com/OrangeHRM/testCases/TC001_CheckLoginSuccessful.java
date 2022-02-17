package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.DashBoardPage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC001_CheckLoginSuccessful extends BaseClass{
	
	
	
	
	//Steps to login
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		boolean expStatus = true;
		LoginPage lp = new LoginPage(driver);
		DashBoardPage dp = new DashBoardPage(driver);
		
		//captureScreen(driver, "1. Before Entering login Details");
		
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		
		//captureScreen(driver, "2. After Entering Login Details");
		lp.clickButton();
		
		
		
		boolean lnkStatus = dp.dashboardLinkDisplayed();
		//captureScreen(driver, "3. Login successful");
		Assert.assertEquals(lnkStatus, expStatus, "DashBoard Link is not displayed");
		
		logger.info("User logged in successfully");
	}
	
	
}
