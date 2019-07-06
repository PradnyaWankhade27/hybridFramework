package com.qa.FreeCrmPro.VisIt.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.VisIt.Base.TestBase;
import com.qa.FreeCrmPro.VisIt.Pages.HomePage;
import com.qa.FreeCrmPro.VisIt.Pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage login;

	HomePage homePage;

	@BeforeMethod
	public void setup() {

		startBrowser(prop.getProperty("browser"), prop.getProperty("qaUrl"));
		login = new LoginPage();
		homePage = login.verifyLogintoFreeCrmPro(prop.getProperty("userName"), prop.getProperty("userPwd"));
	}

	@Test(priority=1)
	public void navigateToContactsPageTest() {

		homePage.navigateToContactsPage();
		logger=reports.createTest("verfiy report home page");
	}


	@Test(priority=2)
	public void navigateToDealsPageTest() {

		homePage.navigateToDealsPage();
	}


	@Test(priority=3)
	public void navigateToTasksPageTest() {

		homePage.navigateToTasksPage();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
