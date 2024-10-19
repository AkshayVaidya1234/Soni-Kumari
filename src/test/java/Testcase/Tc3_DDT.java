package Testcase;

import org.testng.annotations.Test;

import TestBase.BseTest;
import Utility.Dataproviders;
import junit.framework.Assert;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.Myaccpage;

public class Tc3_DDT extends BseTest{
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = Dataproviders.class,groups = "datadriven")// get data from utlity class
	public void loginddt(String user,String pwd,String exp) {
	
		try {
		// Home page method	
		Homepage hp= new Homepage(driver);
		hp.clickonregister();
		hp.clickonLoginbtn();
		
		// Login page
		
		LoginPage lp= new LoginPage(driver);
		lp.enterusername(user);
		lp.enterpassword(pwd);
		lp.clikonloginbtn();
		// Myacc page
		
		Myaccpage scc= new Myaccpage(driver);
		
		 boolean mypage=scc.myaccpageexsit();
		 
		 if(exp.equalsIgnoreCase("valid")) {
			 if(mypage=true) {
				 scc.clickonlogout();
				 Assert.assertTrue(true);
				 
			 }
			 else {
				 Assert.assertTrue(false);
			 }
		 }
		 if(exp.equalsIgnoreCase("invalid")) {
			 
				 if(mypage=true) {
					 scc.clickonlogout();
					 Assert.assertTrue(false);
				 }
				 else {
					 Assert.assertTrue(true);
				 }
	}
		}
		catch (Exception e){
			Assert.fail();
		}
	}
}


