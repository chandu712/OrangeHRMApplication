package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.testBase.BaseClass;

public class LoginPage extends BaseClass{
	
	// 1. Define Driver on class level
	public WebDriver driver;
	
	//2. Create Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;  // Assigning the driver passed from test case to local driver.
		PageFactory.initElements(driver, this);
	}
	
	//3.Locator for username field.
	@FindBy(id="txtUsername")
	WebElement uname;
	
	//4.Locator for password field.
	@FindBy(name="txtPassword")
	WebElement pwd;
	
	//5. Locator for login button
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	// Forgot your password link locator
	@FindBy(id="forgotPasswordLink")
	WebElement forgotYourPwdLnk;
	
	//6.Method to enter username
	public void setUsername(String username) {
		uname.clear();
		uname.sendKeys(username);
		
		logger.info("Username entered is -" + username);
	}
	
	// 7. Method to enter password
	public void setPassword(String password) {
		pwd.clear();
		pwd.sendKeys(password);
		
		logger.info("Password entered is -"+password);
	}
	
	
	// 8.Method to click on login button
	public void clickButton() {
	 if(loginBtn.isEnabled()) {
		 loginBtn.click();
	 }else {
		 
		 logger.info("Login button is not enabled");
	 }
		
	}
	
	// Method to capture forgotPasswordLink? link
	public String forgotPasswordLink() {
		String lnkTxt = forgotYourPwdLnk.getText();
		return lnkTxt;
		
	}
	
	// Method to capture application title
	public String getApplicationTitle() {
		String appTitle = driver.getTitle();
		return appTitle;
	}
	
	

}
