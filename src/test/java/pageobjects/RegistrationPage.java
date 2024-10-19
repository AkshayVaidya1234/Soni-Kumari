package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Basepage{
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(id = "input-firstname")
	WebElement firstname;
	
	@FindBy(name = "lastname")
	WebElement lastname;
	
	@FindBy(id = "input-email")
	WebElement mail;
	
	@FindBy(id="input-telephone")
	WebElement number;
	
	
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmpwd;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn;
	
	
	
	
	public void enterfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void entermail(String email) {
		mail.sendKeys(email);
	}
	
	public void entermobileno(String phoneno) {
		number.sendKeys(phoneno);
	}
	
	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void enterconfirmpwd(String conpwd) {
		confirmpwd.sendKeys(conpwd);
	}
	
	public void enterconfirmbox() {
		checkbox.click();
	}
	
	public void clickonbtn() {
		btn.click();
	}
	

}
