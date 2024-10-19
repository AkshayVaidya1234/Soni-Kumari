package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BseTest {
	
public static WebDriver driver;
public Properties pr;

	
	
	@BeforeClass(groups = {"Sainty","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException, IOException {
		
		// load config.properties
		
		FileReader fis= new FileReader("C:\\Automation\\HybridFramework001\\config.properties");
		pr= new Properties();
		pr.load(fis);
		
		
		
		
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver();break;
		case "edge" : driver= new EdgeDriver();break;
		case "firefox" : driver= new FirefoxDriver();break;
		 default: System.out.println("invalid browser"); return;
		}
		
		
		
		driver.manage().window().maximize();
		driver.get(pr.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(2000);
	}
	
	
	public String randomstring() {
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		}
		public String randomnumber() {
			String generatenumber=	RandomStringUtils.randomNumeric(10);
			return generatenumber;
			}
		
		
		
		public String captureshot(String tname) {
			String timestamp=  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			TakesScreenshot ss= (TakesScreenshot)driver;
			File source= ss.getScreenshotAs(OutputType.FILE);
			String targetfilepath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_"+ timestamp +".png";
			File targetfile= new File(targetfilepath);
			source.renameTo(targetfile);
			return targetfilepath;
		}
		
		
		
		
		@AfterClass(groups = {"Sainty","Regression","Master"})
		
		public void teardown() {
			driver.close();
		}

}
