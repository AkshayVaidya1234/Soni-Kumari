package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id = "input-email")
	WebElement username;
	
	@FindBy (id = "input-password")
	WebElement password;
	
	@FindBy (xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	
	public void enterusername(String email) {
		username.sendKeys(email);
	}
	
	public void enterpassword(String userpwd) {
		password.sendKeys(userpwd);
	}
	
	
	public void clikonloginbtn() {
		loginbtn.click();
	}
	
	
	
	
	
}
