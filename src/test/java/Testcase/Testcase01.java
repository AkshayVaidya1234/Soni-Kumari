package Testcase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.BseTest;
//import pageobjects.AcoountRegistarion;
//import pageobjects.HomePage;
import pageobjects.Homepage;
import pageobjects.RegistrationPage;

public class Testcase01 extends BseTest{
	
	
	
	@Test(groups = {"Regression","Master"})
	
	public void registeraccount() {
		Homepage hp= new Homepage(driver);
		hp.clickonregister();
		hp.clickombtn();
		RegistrationPage ac= new  RegistrationPage(driver);
		 
		
		 ac.enterfirstname(randomstring().toUpperCase());
		 ac.enterlastname(randomstring().toUpperCase());
		 
		ac.entermail(randomstring()+"@gmail.com");// random generated email
		ac.entermobileno(randomnumber());
		 ac.enterpassword("Bhmpyaa@123");
		 ac.enterconfirmpwd("Bhmpyaa@123");
		 ac.enterconfirmbox();
		 ac.clickonbtn();
		 
		 System.out.println("github sucessfully");
		
		
	}
	
	
	
	

}
