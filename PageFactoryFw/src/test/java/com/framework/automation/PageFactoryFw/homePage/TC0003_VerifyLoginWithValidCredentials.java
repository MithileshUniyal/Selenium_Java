/**
 * 
 */
package com.framework.automation.PageFactoryFw.homePage;

import org.apache.log4j.Logger;
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
public class TC0003_VerifyLoginWithValidCredentials extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(TC0003_VerifyLoginWithValidCredentials.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {

		init();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifyLoginWithValidCrendetials() {

		try {
			log.info("=================starting verifyLoginWithValidCrendetials test==================== ");
			homepage = new HomePage(driver);
			
			System.out.println("obect initilized");
			
			homepage.loginToApplication("admin123@yahoo.com", "demo123");

			Assert.assertEquals(homepage.getSignOutText(), "Sign out");
			//now will be handled by the listener class
			//getScreenshot("Pass_verifyLoginWithValidCrendetials");

		} catch (Exception e) {
			log.info("Exception occured");
			//now will be handled by the listener class
			getScreenshot("Fail_verifyLoginWithValidCrendetials");
		}

		log.info("=================Finished verifyLoginWithValidCrendetials test==================== ");
	}

	@AfterTest
	public void endTest() {

		driver.close();
		log.info("closing browser");
	}

}
