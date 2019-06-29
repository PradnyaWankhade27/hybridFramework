package com.qa.FreeCrmPro.VisIt.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.VisIt.Base.TestBase;

import com.qa.FreeCrmPro.VisIt.Pages.LoginPage;
import com.qa.FreeCrmPro.VisIt.Util.Helper;

public class LoginPageTest extends TestBase{

	LoginPage login;
	
	@BeforeMethod
	public void setup(){
		
		Reporter.log("Browser started and navigating to testing server", true);
		
		startBrowser(prop.getProperty("browser"), prop.getProperty("qaUrl"));
		
		Reporter.log("Succesfuly navigated  to the login page ", true);
		
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		
		Reporter.log("Test started and verifying Title of the Login Page", true);
		
		logger=reports.createTest("Verify_Login_Page_Title_Test");

		logger.info("Verifying title of the Login Page ");
		
		String actualTitle=login.verifyLoginPageTitle();
		
		String expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title of the Login page doesn't match with Expected title");
		
		logger.pass("Veried Login Page title succesfully........");
		
		Reporter.log("veried Title of the Login Page", true);
		
	}
	
	/*@Test(priority=2)
	public void verifyLogintoFreeCrmProTest(){
		
		login.verifyLogintoFreeCrmPro(prop.getProperty("userName"), prop.getProperty("userPwd"));
		
		Assert.assertTrue(driver.getTitle().contains("CRMPRO"),"Titlte of the Home Page doesn't contain CRMPRO");
	}*/
	
	/*@Test(priority=2)
	public void verifyLogintoFreeCrmProTest(){
		
	//	login.verifyLogintoFreeCrmPro(excelData.getExcelStringData("login", 1, 0),excelData.getExcelStringData("login", 1, 1));
		
		login.verifyLogintoFreeCrmPro(excelData.getExcelStringData(0, 1, 0),excelData.getExcelStringData(0, 1, 1));
		
		Assert.assertTrue(driver.getTitle().contains("CRMPRO"),"Titlte of the Home Page doesn't contain CRMPRO");
	}*/
	
	@Test(priority=2, dataProvider="getExcelData")
	public void verifyLogintoFreeCrmProTest(String uname, String upass){
		
		Reporter.log("Eneter username and password to the Text field  ", true);
		logger=reports.createTest("verify_Login_To_FreeCrmPro_Test");
		
		
		//Helper.cparturesScreenShots(driver);
		login.verifyLogintoFreeCrmPro(uname, upass);
		
		Assert.assertTrue(driver.getTitle().contains("CRMPRO"),"Titlte of the Home Page doesn't contain CRMPRO");
		
		//Helper.cparturesScreenShots(driver);
		
		logger.pass("Logged in successfully and verified the HomePage title");
		
		Reporter.log("Navigating to home page of the application ", true);
	}
	
	
	@DataProvider
	public Object [][] getExcelData(){
		
		return excelData.getExcelTestData("login");
	}
	
	
}
