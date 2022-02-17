package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC003_CheckApplicationTitle extends BaseClass{
	
	@Test
	public void checkApplicationTitleTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String expValue = "OrangeHRM";
		captureScreen(driver, "1.Application title");
		String actValue = lp.getApplicationTitle();
		Assert.assertEquals(actValue, expValue, "Application title is not matching");
		
		logger.info("Application title is - "+ actValue);
		
	}

}
