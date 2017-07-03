/**
 * 
 */
package com.framework.automation.PageFactoryFw.applicationPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.automation.PageFactoryFw.testBase.TestBase;

/**
 * @author ANKIT
 *
 */
public class HomePage extends TestBase {

	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;

	@FindBy(xpath = "//*[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitButton;

	@FindBy(xpath = "//li[contains(text(),'Authentication failed')]")
	WebElement authenticationFailed;

	@FindBy(xpath = "//a[@class='logout'][contains(text(),'Sign out')]")
	WebElement signOut;

	public void loginToApplication(String emailAdd, String passwd) {

		// waitForElement(60, signIn);
		signIn.click();
		// waitForElement(60, signIn);
		log.info("clicked on SignIn Link and the object is :" + signIn.toString());
		emailAddress.clear();
		emailAddress.sendKeys(emailAdd);
		log.info("Entered email address " + emailAdd + " and the object is :" + emailAddress.toString());
		password.clear();
		password.sendKeys(passwd);
		log.info("Entered password  " + passwd + " and the object is :" + password.toString());

		submitButton.click();
		log.info("clicked submit button and the object is :" + submitButton.toString());
	}

	public String getInvalidLoginText() {

		log.info("Error mesaage is :" + authenticationFailed.getText());
		return authenticationFailed.getText();

	}

	public String getSignOutText() {

		try{
		if(signOut.isDisplayed()){
		log.info("Text on webelement is :" + signOut.getText());
		return signOut.getText();
		}
		}catch(Exception e){
			log.info("Exception Occured Webelement not displayed :" +e);
		}

		return null;
	}
	
	public void clickOnNevigation(String navText){
		
		
		//
	}
}
