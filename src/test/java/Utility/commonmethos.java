package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;

import TestBase.Testbase;

public class commonmethos extends Testbase {
	
	public  static void takesceernshort(WebDriver driver ) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		TakesScreenshot shot=(TakesScreenshot) driver;

		File source= shot.getScreenshotAs(OutputType.FILE);
		
		File dest= new File("C:\\Automation\\HybridFramework001\\Screenshots\\Akshay_"+timeStamp+ ".png");
		
		
		
		Files.copy(source, dest);
		
		test.pass( MediaEntityBuilder.createScreenCaptureFromPath(dest.toString()).build());
	}
	
	public  static void Verfiytitle(String exceptedtitle) throws IOException {
		String actualtitle=driver.getTitle();
		Assert.assertEquals( actualtitle, exceptedtitle);
		System.out.println("Vefiy pagetitle"+exceptedtitle);
		test.pass("Vefiy pagetitle"+exceptedtitle);
		takesceernshort(driver);
		
	}
	
	public static void enterinput(String id,String data,String Message) {
		driver.findElement(By.id(pr.getProperty(id))).sendKeys(data);
		System.out.println("user enter username"+ Message);
		test.info("user enter username"+ Message);
	}
	
	public static void enterinput(String id,String data) {
		driver.findElement(By.id(pr.getProperty(id))).sendKeys(data);
		System.out.println("user enter password"+ data);
		test.info("user enter username"+ data);
	}
	public  static void clicknobtn(String xpath) {
		driver.findElement(By.xpath(pr.getProperty(xpath))).click();
		System.out.println("user on home page");
		test.info("user on home page");
	}
     public static void verfiytext(String xpath,String exceptedtext) {
    	 String actualtext=driver.findElement(By.xpath(pr.getProperty(xpath))).getText();
    	 Assert.assertEquals(actualtext, exceptedtext);
    	 System.out.println("verfiy text"+ exceptedtext);
    	 test.pass("verfiy text"+ exceptedtext);
     }
}
