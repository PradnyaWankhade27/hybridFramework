package com.qa.FreeCrmPro.VisIt.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCrmPro.VisIt.Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[text()='Contacts']")
	@CacheLookup
	WebElement contactsLink;

	@FindBy(xpath = "//a[text()='Deals']")
	@CacheLookup
	WebElement dealsLink;

	@FindBy(xpath = "//a[text()='Tasks']")
	@CacheLookup
	WebElement tasksLink;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}

	public ConatactPage navigateToContactsPage() {

		driver.switchTo().frame("mainpanel");
		contactsLink.click();
		driver.switchTo().defaultContent();

		return new ConatactPage();
	}

	public DealsPage navigateToDealsPage() {

		driver.switchTo().frame("mainpanel");
		dealsLink.click();
		driver.switchTo().defaultContent();

		return new DealsPage();
	}

	public TasksPage navigateToTasksPage() {

		driver.switchTo().frame("mainpanel");
		tasksLink.click();
		driver.switchTo().defaultContent();

		return new TasksPage();
	}

}
