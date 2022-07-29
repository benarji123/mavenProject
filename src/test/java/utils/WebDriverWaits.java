package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class WebDriverWaits {
	public WebDriver driver;
	public WebDriverWaits(WebDriver dr) {
		this. driver=dr;
	}
	
	public void  waitForElement(WebElement el, long time) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(time));
		w.until(ExpectedConditions.visibilityOf(el));
	
	
}
}