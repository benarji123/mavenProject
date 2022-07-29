package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();	
		driver.get("https://demo.guru99.com/telecom/addcustomer.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();",driver.findElement(By.id("done")));
		
	}

}
