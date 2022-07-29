package testRunner;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features ={"src\\test\\resources\\parallel\\CreateNewCustomer.feature"},
  glue={"StepDefinitions"},monochrome = true,
  dryRun =false,plugin= {"pretty","html:target/reports.html","json:target/report.json","junit:target/reports.xml"
		  ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

  
///  plugin = {})

public class RunnerTest1 extends AbstractTestNGCucumberTests {

}
