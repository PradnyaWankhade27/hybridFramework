package com.qa.FreeCrmPro.VisIt.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCrmPro.VisIt.Base.TestBase;

import net.bytebuddy.asm.Advice.Argument;

public class LoginPage extends TestBase {
	
	// page factory or object repository for login page
	
	@FindBy(name="username")
	@CacheLookup
	WebElement uname;
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement upass;
	
	@FindBy(xpath="//input[@value='Login' or @type='submit']")
	@CacheLookup
	WebElement loginBtn;
	//input[@value='Login']
	
	@FindBy(xpath="//a[text()='Sign Up']")
	@CacheLookup
	WebElement signUpLink;
	
	
	public LoginPage(){
		//super()
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	
	public HomePage verifyLogintoFreeCrmPro(String un, String up){
		
		uname.clear();
		uname.sendKeys(un);
		
		upass.clear();
		upass.sendKeys(up);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", loginBtn);
		
		
		return new HomePage();
	}
	
	
	
	
	

}
