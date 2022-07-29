package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWaits;

public class HomePage {
	public WebDriver	Driver;
	public  WebDriverWaits w;
public HomePage(WebDriver dr) {
    	
	this.Driver=dr;
	PageFactory.initElements(dr, this);
	w=new WebDriverWaits(Driver);
	
}

@FindBy(linkText="Telecom Project")
 public WebElement telecomproject;
@FindBy(xpath="//*[@id='dismiss-button']")
public WebElement add ;


public WebElement clickOnTelePro() {
	w.waitForElement(telecomproject, 3);
	return telecomproject;
}

public void removeAdd() throws InterruptedException {
	Thread.sleep(5);
	try {
	WebElement frame1 = Driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	    Driver.switchTo().frame(frame1);

   Driver.switchTo().frame(Driver.findElement(By.id("ad_iframe")));
	
	//add.click();
	
	//w.waitForElement(add, 30);
	JavascriptExecutor executor = (JavascriptExecutor)Driver;
    executor.executeScript("arguments[0].click();",add);
    Driver.switchTo().defaultContent();
	}catch (Exception e) {
		// TODO: handle exception
		WebElement frame1 = Driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0__container__"));
	    Driver.switchTo().frame(frame1);
	    JavascriptExecutor executor = (JavascriptExecutor)Driver;
	    executor.executeScript("arguments[0].click();",add);
	    Driver.switchTo().defaultContent();
	}
	
}
@FindBy(linkText="Add Customer")	
public WebElement addCustomer;

public WebElement addCustomer() {
	w.waitForElement(addCustomer, 30);
	return addCustomer;
}
@CacheLookup
@FindBy(xpath="//input[@id='done']")
public WebElement doneButton;
@FindBy(name="fname")
public WebElement firstname;
@FindBy(id="lname")
public WebElement lastname;
@FindBy(id="email")
public WebElement Email;
@FindBy(xpath="//textarea[@id='message']")
public WebElement address;
@FindBy(id="telephoneno")
public WebElement mblNumber;
@FindBy(name="submit")
public WebElement submit;
public void clickONButton() {
	 //w.waitForElement(doneButton, 100);
	 JavascriptExecutor executor = (JavascriptExecutor)Driver;  
	 executor.executeScript("arguments[0].click();",doneButton);

}
public WebElement enterFirstName() {
	 w.waitForElement(firstname, 3);
	 return firstname;
}
public WebElement enterLastName() {
	 w.waitForElement(lastname, 3);
	 return lastname;
}
public WebElement enterEamilId() {
	 w.waitForElement(Email, 3);
	 JavascriptExecutor js = (JavascriptExecutor) Driver;
	    // Scrolling down the page till the element is found
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	 //  w.waitForElement(address, 30);
	 return Email;
}
public void enterAddress(String ad) {

    //Locating element by link text and store in variable "Element"        		
  //  WebElement Element = Driver.findElement(By.linkText("Try Selenium Testing For Free"));
	 w.waitForElement(address, 30);
   
    address.sendKeys(ad);
	 
	
}
public WebElement enterMblNumber() {
	 w.waitForElement(mblNumber, 3);
	 return mblNumber;
}
public WebElement ClickOnSubmit() {
	 w.waitForElement(submit, 3);
	 return submit;
	 
}

}