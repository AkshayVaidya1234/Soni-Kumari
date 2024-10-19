package Utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BseTest;
//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class ExtentReportManger  implements ITestListener{

	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repname;
	
	

	public void onStart(ITestContext context) {
		
		
		
		String timestamp=  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname= "Test-Report-" + timestamp + ".html";
		
		sparkreporter= new ExtentSparkReporter(".\\reports\\"+repname);
		sparkreporter.config().setDocumentTitle("OpenCart Automation Report");//set report name
		sparkreporter.config().setReportName(" OpenCart Functional Testing");//set report name
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports ();
		extent.attachReporter(sparkreporter);
		
		
		extent.setSystemInfo("Apllication ", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Coustemer");
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("Environmet", "QA");
		
		
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedgroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty()){
			extent.setSystemInfo("Groups", includedgroups.toString());
		}
		
		
}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got Sucessfully excucated");
		}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+ "got failed");
		try {
		String imgpath=new BseTest().captureshot(result.getName());
		test.addScreenCaptureFromPath(imgpath);
	}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	
	
}
	public void onFinsh(ITestResult result) throws IOException {
	       extent.flush();
	       String pathofextentreport=System.getProperty("user.dir")+"\\reports\\"+"repname";
	       File extenreport=new File(pathofextentreport);
	       try {
	       Desktop.getDesktop().browse(extenreport.toURI());
}
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }
}
}