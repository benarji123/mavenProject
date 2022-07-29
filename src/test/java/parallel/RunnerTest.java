package parallel;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.GetKey;




@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/test/resources/parallel/Login.feature"},
  glue={"parallel"},monochrome = true,
  dryRun =false,plugin= {"pretty","html:target/reports.html","json:target/report.json","junit:target/reports.xml"
		  ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

  
///  plugin = {})
public class RunnerTest extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel=true)
  public Object[][] scenarios() {
	 return super.scenarios();
  }

	
}
