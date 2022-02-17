package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.testBase.BaseClass;

public class DashBoardPage extends BaseClass{
	
	//1. Define Driver on class level
    public WebDriver driver;
	
	//2. Create Constructor
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;  // Assigning the driver passed from test case to local driver.
		PageFactory.initElements(driver, this);
	}
	
	//3.Locator for DashBoard link
	@FindBy(linkText="Dashboard")
	WebElement dashboardLnk;
	
	
	//4. create method for Dashboard Link is displayed
	public boolean dashboardLinkDisplayed() {
		boolean status = dashboardLnk.isDisplayed();
		return status;
	}

}
