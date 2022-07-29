package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.internal.Throwables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;

public class UtilsMethods {
//public static	
	public static WebDriver openBrowser() throws FileNotFoundException, IOException {
	   WebDriver driver = null;

		GetKey k=new GetKey();
		String browser=k.property.get().getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		return driver;
	}
	public static void openApplication(WebDriver dr,String url) {
		dr.get(url);
	}
	public static void enterValue(WebDriver dr,String locatorType,String locatorValue,String info) {
		if(locatorType.equalsIgnoreCase("name")) {
			dr.findElement(By.name(locatorValue)).sendKeys(info);;
		}else if(locatorType.equalsIgnoreCase("id")) {
			dr.findElement(By.id(locatorValue)).sendKeys(info);;
		}else if(locatorType.equalsIgnoreCase("xpath")) {
			dr.findElement(By.xpath(locatorValue)).sendKeys(info);
		}else if(locatorType.equalsIgnoreCase("css")) {
			dr.findElement(By.cssSelector(locatorValue)).sendKeys(info);;
		}
	}
	public static void clickButton(WebDriver dr,String locatorType,String locatorValue) {
		
		if(locatorType.equalsIgnoreCase("name")) {
			dr.findElement(By.name(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("id")) {
			dr.findElement(By.id(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("Xpath")) {
			dr.findElement(By.xpath(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("css")) {
			dr.findElement(By.cssSelector(locatorValue)).click();
		}
		
	}
	public static void closeBrowser(WebDriver dr){
		dr.quit();
	}
	
	public static void validateDashBoard(WebDriver dr,String data) {
		String title=dr.findElement(By.xpath("//div/h1")).getText();
		SoftAssert s=new SoftAssert();
		if(title.equals(data)) {
			Assert.assertTrue(true);
		}else {
			Throw.valueOf("title not matched");
			}
       // s.assertEquals(title, data);
       // s.assertAll();

		
	}
	public static void webWaiter(WebDriver dr,String time,String locatortype,String locatorvalue) {
		
		WebDriverWait w=new WebDriverWait(dr, Duration.ofSeconds(Integer.parseInt(time)));
		if(locatortype.equalsIgnoreCase("name")) {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		} else if(locatortype.equalsIgnoreCase("id")) {
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}else if(locatortype.equalsIgnoreCase("xpath")) {
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}else if(locatortype.equalsIgnoreCase("Css")) {
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
		}
	}
	public String getFirstname() {
	return RandomStringUtils.random(6);
	   
	}
}
