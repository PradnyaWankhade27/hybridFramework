package com.qa.FreeCrmPro.VisIt.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.FreeCrmPro.VisIt.Util.ExcelDataProvider;
import com.qa.FreeCrmPro.VisIt.Util.Helper;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public ExcelDataProvider excelData;
	
	public ExtentReports reports;
	
	public ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuite(){
		
		Reporter.log("Initializing the Excel Config and extents Reporters  ", true);
		excelData=new ExcelDataProvider();
		
		ExtentHtmlReporter htmlRepoter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//ExtentsReports//FreeCrm_"+Helper.getCurrentDateAndTime()+".html"));
		
		reports= new ExtentReports();
		
		reports.attachReporter(htmlRepoter);
		
		Reporter.log("Succesfully done initialization  ", true);	
	}
	@AfterMethod
	public void tearDown(ITestResult results) throws IOException{
	Reporter.log("generating and attaching screen shots ", true);
		
		if(results.getStatus()==ITestResult.FAILURE){
			
			//Helper.capturesScreenShots(driver);
			
			logger.fail("TestCase Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenShots(driver)).build());
		}
		
		else if(results.getStatus()==ITestResult.SUCCESS){
			//Helper.capturesScreenShots(driver);
			
			logger.pass("TestCase Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenShots(driver)).build());
		}
		/*else if(results.getStatus()==ITestResult.SKIP){
		//	Helper.capturesScreenShots(driver);
		}*/
		else{
			System.out.println("we can't captured screenshots here......");
		}
		
		driver.quit();
		
		reports.flush();
		
		Reporter.log("generated  and attached the  screen shots and test will be completed.. ", true);
	}
	
	public TestBase(){
		
		try {
			
			File fs = new File(System.getProperty("user.dir")+"//Config//config.properties");
			
			FileInputStream fins=new FileInputStream(fs);
	
			prop=new Properties();
			
			prop.load(fins);
		
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void startBrowser(String brrName, String url) {

		if (brrName.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", ".//Drivers//gecko.exe");

			driver = new FirefoxDriver();

		} else if (brrName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

			driver = new ChromeDriver();
		} else if (brrName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else {

			System.out.println("Browser not able to fetch and hence we are not navigating to respected browser");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
				
	}

}
