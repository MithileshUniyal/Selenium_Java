/**
 * 
 */
package com.framework.automation.PageFactoryFw.homePage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.automation.PageFactoryFw.applicationPages.HomePage;
import com.framework.automation.PageFactoryFw.testBase.TestBase;

import junit.framework.Assert;

/**
 * @author ANKIT
 *
 */
public class TC001_VerifyLoginWithInvalidCrendetials extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCrendetials.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {

		init();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyLoginWithInvalidCrendetials() {

		try {
			log.info("=================starting verifyLoginWithInvalidCrendetials test==================== ");
			homepage = new HomePage(driver);
			
			System.out.println("obect initilized");
			
			homepage.loginToApplication("test@gmail.com", "pass123");

			Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
			getScreenshot("Pass_verifyLoginWithInvalidCrendetials");

		} catch (Exception e) {
			log.info("Exception occured");
			getScreenshot("Fail_verifyLoginWithInvalidCrendetials");
		}

		log.info("=================Finished verifyLoginWithInvalidCrendetials test==================== ");
	}

	@AfterTest
	public void endTest() {

		driver.close();
		log.info("closing browser");
	}
}
