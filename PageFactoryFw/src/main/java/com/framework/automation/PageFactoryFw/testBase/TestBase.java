/**
 * 
 */
package com.framework.automation.PageFactoryFw.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.automation.PageFactoryFw.applicationPages.HomePage;

/**
 * @author ANKIT
 *
 */
public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	String BaseUrl = "http://automationpractice.com/index.php";
	String browser = "chrome";

	public void init() {
		
		selectBrowser(browser);
		getUrl(BaseUrl);
		
		String log4jconfigpath= "log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);

	}
	
	
	public void selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ANKIT\\EclipseWorkspace\\PageFactoryFw\\drivers\\chromedriver.exe");

			log.info("creating object of "+browser);
			driver = new ChromeDriver();
			
			log.info("opening "+browser+" Browser");
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ANKIT\\EclipseWorkspace\\PageFactoryFw\\drivers\\geckodriver.exe");
			
			log.info("creating object of "+browser);
			
			driver = new FirefoxDriver();
			log.info("opening "+browser+" Browser");

		}

	}
	
	
	public void getUrl(String url){
		driver.get(url);
		log.info("Nevigating to "+url);
		driver.manage().window().maximize();
		log.info("Maximizing browser window");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("Implimented implicit wait");
		log.info("");
	}

}
