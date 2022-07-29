package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWaits;

public class Navigate_To_Home {
	public WebDriver driver;
	WebDriverWaits w;
	public Navigate_To_Home(WebDriver dr) {
		// TODO Auto-generated constructor stub
	this.driver=dr;
		PageFactory.initElements(dr, this);
	w=new WebDriverWaits(driver);
		
	}
   @FindBy(xpath="(//a[text()='Home'])[1]")
   public WebElement home;
   public void clickOnLink() {
	   w.waitForElement(home, 10);
	  home.click();
   }
}
