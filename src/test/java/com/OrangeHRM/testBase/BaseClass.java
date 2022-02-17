package com.OrangeHRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	// Define WebDriver
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	// Create a method to launch application
		@BeforeClass
		@Parameters("browser")
		public void setup(String br) throws IOException {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
			prop.load(fis);
			
			// To run on the browser passed in testng.xml
			if(br.equalsIgnoreCase("CHROME")) {
				
				// steps to launch application
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();    //to launch chrome browser
				logger.info("Chrome Browser is launched successfully");
				
			}else if(br.equalsIgnoreCase("EDGE")) {
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Edge browser is launched successfully");
				
			}else if(br.equalsIgnoreCase("FIREFOX")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Firefox browser is launched successfully");
				
			}else {
				logger.info("please pass values as chrome/edge/firefox");
			}
			
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			
			logger.info("URL in the properties file is - " +prop.getProperty("url"));
			driver.get(prop.getProperty("url"));  //opening application
			logger.info("URL entered is - "+prop.getProperty("url"));
		}
		
		@AfterClass
		//Steps to close application
		public void tearDown() {
			driver.quit();
			logger.info("Application closed successfully");
		}
		
		public void captureScreen(WebDriver driver, String testName) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
			FileUtils.copyFile(source, target);
			logger.info("Screenshot captured successfully");
			
			
			
		}


}
