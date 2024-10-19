package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccpage extends Basepage{

	public Myaccpage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement myaccpage;
	
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement logout;
	
	public boolean myaccpageexsit() {
		try {
		return myaccpage.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
		
		}
	public void clickonlogout() {
		logout.click();
	}
	

}
