/**
 * 
 */
package com.framework.automation.PageFactoryFw.homePage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.automation.PageFactoryFw.applicationPages.HomePage;
import com.framework.automation.PageFactoryFw.testBase.TestBase;

import junit.framework.Assert;

/**
 * @author ANKIT
 *
 */
public class TC002_VerifyLoginWithDifferentRecords extends TestBase{
	
	
	public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithDifferentRecords.class.getName());

	HomePage homepage;
	
	
	@DataProvider(name="LoginDetails")
	public String[][] getLoginData(){
		String[][] loginRecords = getData("TestData.xlsx", "LoginData");
		return loginRecords;
		
	}
	
	
	
	@BeforeTest
	public void setUp() {

		init();
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider="LoginDetails")
	public void verifyLoginWithDifferentRecords(String emailAddress, String password, String runmode) {

		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("This is Marked as no Run");
		}
			log.info("=================starting verifyLoginWithDifferentRecords test====================");
			
			homepage = new HomePage(driver);
			homepage.loginToApplication(emailAddress,password);


		    log.info("=================Finished verifyLoginWithDifferentRecords test=====================");
	}

	@AfterTest
	public void endTest() {

		driver.close();
		log.info("closing browser");
	}

}
