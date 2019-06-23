package com.qa.FreeCrmPro.VisIt.Util;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
/*	public static void cparturesScreenShots(WebDriver driver, String screenShotsName){
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"//ScreenShots//freeCrm_"+screenShotsName+".png"));
		
			System.out.println("Screenshots captured.....");
		
		} catch (IOException e) {

			System.out.println("Screenshots not able to captured.....");
			e.printStackTrace();
		}
	}*/

	
	public static void cparturesScreenShots(WebDriver driver){
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"//ScreenShots//freeCrm_"+getCurrentDateAndTime()+".png"));
		
			System.out.println("Screenshots captured.....");
		
		} catch (IOException e) {

			System.out.println("Screenshots not able to captured.....");
			e.printStackTrace();
		}
	}
	
	
	public static String getCurrentDateAndTime(){
		
		Format sampleFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date date =new Date();
		
		return  sampleFormat.format(date);
	}
}
