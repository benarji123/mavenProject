package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWaits;

public class Add_Tariff_Plane_Page {
	WebDriver driver;
	WebDriverWaits w;

  public Add_Tariff_Plane_Page(WebDriver dr) {
	// TODO Auto-generated constructor stub
	  this.driver=dr;
	  PageFactory.initElements(dr, this);
	  w=new WebDriverWaits(driver);
}
 @FindBy(id="rental1") 
 private WebElement montaltRental;
 
 @FindBy(id="local_minutes")
 private WebElement localMinutes;
 @FindBy(id="inter_minutes")
 private WebElement internationalMinutes;
 
 @FindBy(name="sms_pack")
 private WebElement smsPack;
 @FindBy(id="minutes_charges")
 private WebElement localCharge;
 @FindBy(name="inter_charges")
 private WebElement inter_Charge;
 @FindBy(id="sms_charges")
 private WebElement smsCharge;
 
 public void enterMontlyRent(String rent) {
	 w.waitForElement(montaltRental, 10);
	 montaltRental.sendKeys(rent);
 }
 public void enterLocalMinutes(String minutes) {
	 w.waitForElement(localMinutes, 10);
	 localMinutes.sendKeys(minutes);
 }
 public void enterInter_Minutes(String minutes) {
	 w.waitForElement(internationalMinutes, 10);
	 internationalMinutes.sendKeys(minutes);
 }
 public void enterSmsPack(String sms) {
	 w.waitForElement(smsPack, 10);
	 smsPack.sendKeys(sms);
 }public void EnterLocalCharges(String localCharges) {
	 w.waitForElement(localCharge, 10);
	 localCharge.sendKeys(localCharges);
 }public void intr_Charges(String intCharges) {
	 w.waitForElement(inter_Charge, 10);
	 inter_Charge.sendKeys(intCharges);
 }public void EntersmsCharge(String smsCharges) {
	 w.waitForElement(smsCharge, 10);
	 smsCharge.sendKeys(smsCharges);
 }
 
 
 
 
  
  
}
