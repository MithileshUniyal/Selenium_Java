/**
 * 
 */
package com.framework.automation.PageFactoryFw.Custom_Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.framework.automation.PageFactoryFw.testBase.TestBase;

/**
 * @author ANKIT
 *
 */
public class Listener extends TestBase implements ITestListener {
	/*
	WebDriver driver;
	
	

	public Listener(WebDriver driver) {
		
		this.driver=driver;
		
	}*/

	public void onFinish(ITestContext result) {
		Reporter.log("Test finished..."+((ITestResult) result).getMethod().getMethodName());

	} 

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName=result.getName();
		
		

		if(!result.isSuccess()){
			
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String prjDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\main\\java\\com\\framework\\automation\\PageFactoryFw\\";
			File destFile = new File(
					(String) prjDirectory + "/failure_Screenshot/"+methodName + "_" + dateFormatter.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(sourceFile, destFile);
			
			//Linking screenshot with testngReport:
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" +destFile.getAbsolutePath()+ "' height='80' width='80'/></a>");
		
		
		
		
	}catch(IOException e){
		
		e.printStackTrace();
	}
		}
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test skipped..."+result.getMethod().getMethodName());

	}

	public void onTestStart(ITestResult result) {
		Reporter.log("Test started..."+result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName=result.getName();
		
		Reporter.log("Test successful..."+result.getMethod().getMethodName());

		if(result.isSuccess()){
			
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String prjDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\main\\java\\com\\framework\\automation\\PageFactoryFw\\";
			File destFile = new File(
					(String) prjDirectory + "/Success_Screenshot/"+methodName + "_" + dateFormatter.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(sourceFile, destFile);
			
			//Linking screenshot with testngReport:
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" +destFile.getAbsolutePath()+ "' height='80' width='80'/></a>");
		
		
		
		
	}catch(IOException e){
		
		e.printStackTrace();
	}
		}

	}

}
