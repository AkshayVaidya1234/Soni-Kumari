package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement accbtn;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement regbtn;
	
	
	@FindBy(linkText ="Login")
	WebElement loginbtn;
	
	public void clickonregister() {
		accbtn.click();
	}
	
	public void clickombtn() {
		regbtn.click();
	}
	public void clickonLoginbtn() {
		loginbtn.click();
	}

}
