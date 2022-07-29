package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWaits;

public class Navigate_To_TariffPage {
	WebDriver driver;
	WebDriverWaits w;
  public Navigate_To_TariffPage(WebDriver dr) {
	// TODO Auto-generated constructor stub
	  this.driver=dr;
	  PageFactory.initElements(dr, this);
	 w =new WebDriverWaits(driver);
}
  @FindBy(linkText="Add Tariff Plan")
  private WebElement addTariff;
  public void clickONAddTeriff() {
	  w.waitForElement(addTariff, 10);
	  addTariff.click();
  }
}
