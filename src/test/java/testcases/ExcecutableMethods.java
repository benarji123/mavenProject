package testcases;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.netty.handler.logging.LogLevel;
import utils.ExcelUtils;
import utils.GetSrceenShot;
import utils.UtilsMethods;

public class ExcecutableMethods {
	@Test
	public void method() throws EncryptedDocumentException, IOException {
		ExcelUtils u=new ExcelUtils("C:/Users/Dell/Desktop/ActualLogin.xlsx");
		String outputpath="C:/Users/Dell/Desktop/Result.xlsx";
		ExtentSparkReporter s=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/ExtentReport/report.html"));
		s.config().setReportName("HtmlReport");
		s.config().setDocumentTitle("AutoamtionReport");
		s.config().setTheme(Theme.DARK);
	    ExtentReports report=new ExtentReports();
		report.setSystemInfo("PlatForm", "Windows");
		report.setSystemInfo("BrowserType","Chrome");
		report.attachReporter(s);
		ExtentTest test;
		WebDriver driver = null;
		String modelStatus="";
		for(int i=1;i<=u.getRowCount("masterSheet");i++) {
			String status=u.getCellData("masterSheet", i, 2);
			if(status.equalsIgnoreCase("ON")) {
			String modulename=u.getCellData("masterSheet", i, 1);
			int rownum=u.getRowCount(modulename);
			int colunum=u.getColumnCount(modulename);
			test=report.createTest(modulename);
			for(int j=1;j<=rownum;j++) {
				String Description=u.getCellData(modulename, j, 0);
				String methodname=u.getCellData(modulename, j, 1);
				String locatortype=u.getCellData(modulename, j,2);
				String locatorvalue=u.getCellData(modulename, j, 3);
				String data=u.getCellData(modulename, j, 4);
				//System.out.println(Description);
//				System.out.println(methodname);
//				System.out.println(locatortype);
//				System.out.println(locatorvalue);
//				System.out.println(data);
				
				try {
				if(methodname.equalsIgnoreCase("openBrowser")) {
					driver=UtilsMethods.openBrowser();
					test.log(Status.INFO,Description );
				}else if(methodname.equalsIgnoreCase("openApplication")) {
					UtilsMethods.openApplication(driver,data);
					test.log(Status.INFO,Description );
				}else if(methodname.equalsIgnoreCase("enterValue")) {
					UtilsMethods.enterValue(driver, locatortype, locatorvalue, data);
					test.log(Status.INFO,Description );
				}else if(methodname.equalsIgnoreCase("clickButton")) {
					UtilsMethods.clickButton(driver, locatortype, locatorvalue);
				}else if(methodname.equalsIgnoreCase("validateDashBoard")) {
					UtilsMethods.validateDashBoard(driver, data);
					test.log(Status.INFO,Description );
					
				}else if(methodname.equalsIgnoreCase("closeBrowser")) {
					UtilsMethods.closeBrowser(driver);
					test.log(Status.INFO,Description );
				}
				else if(locatortype.equalsIgnoreCase("webWaiter")) {
					UtilsMethods.webWaiter(driver, data, locatortype, locatorvalue);
					test.log(Status.INFO,Description );
				
				}
		        u.setCellData(modulename, j, 5,"Pass",outputpath );
		        modelStatus="True";
				}catch (Exception e) {
					u.setCellData(modulename, j, 5,"Fail",outputpath );
					String path=GetSrceenShot.takeSrceenShot(driver, methodname);
					test.log(Status.FAIL,methodname);
					test.fail(e.getMessage());
					test.addScreenCaptureFromPath(path);
										System.out.println("insde catch block");
					modelStatus="False";
	
					//Assert.fail(e.getMessage());
			
					
				}
				
				
			}
			if(modelStatus.equalsIgnoreCase("True")) {
				u.setCellData("masterSheet", i, 3,"Pass", outputpath);
			}else if(modelStatus.equalsIgnoreCase("False")) {
				u.setCellData("masterSheet", i, 3,"Fail", outputpath);
			}
			}else {
				u.setCellData("masterSheet", i, 3, "Skip", outputpath);
				System.out.println("outside if ");
				
			}
		}  

		report.flush();
		
		
		
	}

	
	
	
}
