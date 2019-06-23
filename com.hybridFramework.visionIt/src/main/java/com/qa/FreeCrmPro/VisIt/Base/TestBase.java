package com.qa.FreeCrmPro.VisIt.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.qa.FreeCrmPro.VisIt.Util.ExcelDataProvider;
import com.qa.FreeCrmPro.VisIt.Util.Helper;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public ExcelDataProvider excelData;
	
	@BeforeSuite
	public void beforeSuite(){
		
		excelData=new ExcelDataProvider();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult results){
		
		
		if(results.getStatus()==ITestResult.FAILURE){
			
			Helper.cparturesScreenShots(driver);
		}
		
		else if(results.getStatus()==ITestResult.SUCCESS){
			Helper.cparturesScreenShots(driver);
		}
		else if(results.getStatus()==ITestResult.SKIP){
			Helper.cparturesScreenShots(driver);
		}
		else{
			System.out.println("we can't captured screenshots here......");
		}
		driver.quit();
	}
	
	public TestBase(){
		
		try {
			
			File fs = new File(System.getProperty("user.dir")+"//Config//config.properties");
			
			FileInputStream fins=new FileInputStream(fs);
	
			prop=new Properties();
			
			prop.load(fins);
		
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
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
