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
public class HomePage {

	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	
	@FindBy(xpath="//*[@id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath="//li[contains(text(),'Authentication failed')]")
	WebElement authenticationFailed;
	
	
	public void loginToApplication(String emailAdd, String passwd){
		
		signIn.click();
		log.info("clicked on SignIn Link and the object is :"+signIn.toString());
		emailAddress.sendKeys(emailAdd);
		log.info("Entered email address "+emailAdd+" and the object is :"+emailAddress.toString());
		password.sendKeys(passwd);
		log.info("Entered email address "+passwd+" and the object is :"+password.toString());
		
		submitButton.click();
		log.info("clicked submit button and the object is :"+submitButton.toString());
	}
	
	
	
	public String getInvalidLoginText(){
		
		log.info("Error mesaage is :"+authenticationFailed.getText());
		return authenticationFailed.getText();
		
		
	}
}
