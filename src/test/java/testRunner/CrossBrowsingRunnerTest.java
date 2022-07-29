package testRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.GetKey;



@RunWith(Cucumber.class)
@CucumberOptions(features ={"src\\test\\resources\\parallel\\Login.feature"},
  glue={"stepdefinitions"},monochrome = true,
  dryRun =false,plugin= {"pretty","html:target/reports.html","json:target/report.json","junit:target/reports.xml"
		  ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},tags="@login")

  
///  plugin = {})
public class CrossBrowsingRunnerTest extends AbstractTestNGCucumberTests{
	@Parameters("browser")
    @BeforeClass
	public void beforeClass(String browser) throws FileNotFoundException, IOException {
//		System.out.print("this is method");
		//install the localthread
		GetKey.cofing();
//		k.setValue("browser", browse);
		System.out.println("this is before method");
		if(!browser.equalsIgnoreCase("no value")) {
			GetKey.property.get().setProperty("BrowserType", browser);
			
			System.out.println(	GetKey.property.get());
		}
	}
}
