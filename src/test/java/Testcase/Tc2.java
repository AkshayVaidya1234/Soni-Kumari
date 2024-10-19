package Testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BseTest;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.Myaccpage;

public class Tc2 extends BseTest {
	@Test(groups = {"Sainty","Master"})
	public void loginaccount() {

	try {
		// Home page method	
	Homepage hp= new Homepage(driver);
	hp.clickonregister();
	hp.clickonLoginbtn();
	
	// Login page
	
	LoginPage lp= new LoginPage(driver);
	lp.enterusername(pr.getProperty("email"));
	lp.enterpassword(pr.getProperty("password"));
	lp.clikonloginbtn();
	// Myacc page
	
	Myaccpage scc= new Myaccpage(driver);
	
	 boolean mypage=scc.myaccpageexsit();
	 Assert.assertTrue(mypage);
	 }
	catch(Exception e) {
		Assert.fail();
	}

	
}
}

