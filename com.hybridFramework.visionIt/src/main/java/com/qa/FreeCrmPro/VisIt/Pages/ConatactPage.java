package com.qa.FreeCrmPro.VisIt.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.qa.FreeCrmPro.VisIt.Base.TestBase;

public class ConatactPage extends TestBase {

	@FindBy(xpath = "//a[text()='Contacts']")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	@CacheLookup
	WebElement newContactsLink;
	
	
	public NewContactsPage navigateToNewContactsPage(){
		
		Actions action=new Actions(driver);		
		action.moveToElement(contactsLink).build().perform();		
		newContactsLink.click();		
		return new NewContactsPage();
	}
	
}
