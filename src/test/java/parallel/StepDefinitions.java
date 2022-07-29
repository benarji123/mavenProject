package parallel;


import java.io.FileNotFoundException;
import java.io.IOException;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import PageObjectModel.Add_Tariff_Plane_Page;
import PageObjectModel.HomePage;
import PageObjectModel.Navigate_To_Home;
import PageObjectModel.Navigate_To_TariffPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import utils.GetKey;

public class StepDefinitions {
public	WebDriver driver;
public  HomePage home;

	


@Before
public void i_setup_browser() throws FileNotFoundException, IOException {
   

    // Write code here that turns the phrase above into concrete actions

//	ChromeOptions options=new ChromeOptions();
//		options.setHeadless(true);
//		options.addArguments("--disable-popup-blocking");
     //  WebDriverManager.chromedriver().setup();
	  //  driver=new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
	//GetKey k=new GetKey();

     System.out.println(GetKey.cofing().getProperty("BrowserType"));
		if(	GetKey.cofing().getProperty("BrowserType").equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\geckodriver.exe");
		driver=new FirefoxDriver();	

		
		}else if(GetKey.cofing().getProperty("BrowserType").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(	GetKey.cofing().getProperty("BrowserType").equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Dell\\Desktop\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}
		home=new HomePage(driver);
   System.out.println("this is in before annotation");
}


@When("i opened orange hrm application using url as {string}")
public void i_opened_orange_hrm_application_using_url_as(String url) {
	url="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    driver.get(url);
}

@Then("i should able to orange hrm logo")
public void i_should_able_to_orange_hrm_logo() {
	boolean actual=driver.findElement(By.id("btnLogin")).isDisplayed();
	Assert.assertEquals(true,actual);
}

@When("i enter username as {string} and password as {string} in login field")
public void i_enter_username_as_and_password_as_in_login_field(String string, String string2) {
	//string="Admin";
	//string2="admin123";
    driver.findElement(By.id("txtUsername")).sendKeys(string);
    driver.findElement(By.name("txtPassword")).sendKeys(string2);
}

@And("i click on login button")
public void i_click_on_login_button() {
    driver.findElement(By.id("btnLogin")).click();
  
}

@Then("i should see the dashboard")
public void i_should_see_the_dashboard() throws InterruptedException {
	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
 if( !driver.findElement(By.id("menu_dashboard_index")).isDisplayed()) {
	  Assert.assertTrue(false);
	  
  }else {
	  Thread.sleep(4);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='welcome']")));

	  
	  Thread.sleep(4);
	  Actions a=new Actions(driver);
	 Actions click= a.moveToElement(driver.findElement(By.xpath("//a[text()='Logout']")));
	 
	 click.click().build().perform();
	 // driver.switchTo().defaultContent();
	  
	  Assert.assertTrue(true);
  }
  
 

       System.out.println("this is after assertion");
}

@When("open an application with Url AS {string}")
public void open_an_application_with_url_as(String url ) {
    driver.get(url);
}
@And("click on telecom project link")
public void click_on_telecom_project_link() throws InterruptedException {
    home=new HomePage(driver);
    home.clickOnTelePro().click();
    
    home.removeAdd();
    
    
    
  
   
}
@When("i click on add customer")
public void i_click_on_add_customer() {
   home.addCustomer().click();
}
@Then("i entr all details in application")
public void i_entr_all_details_in_application() throws InterruptedException {
	Thread.sleep(30);

home.clickONButton();
home.enterFirstName().sendKeys("alekh");
home.enterLastName().sendKeys("narada");
home.enterEamilId().sendKeys("naradabenarji@gmail.com");
home.enterAddress("hyd");
home.enterMblNumber().sendKeys("2344567821");
    
//   cp.clickONButton();
//    
//    cp.enterFirstName().sendKeys("alekh");
//    cp.enterLastName().sendKeys("narada");
//    cp.enterEamilId().sendKeys("naradabenarji@gmail.com");
//    cp.enterAddress().sendKeys("hyd");
//    cp.enterMblNumber().sendKeys("2345678901");
    
}
@And("click on submit button")
public void click_on_submit_button() {
	home.ClickOnSubmit().click();
}
@Then("i should see one message as {string}")
public void i_should_see_one_message_as(String msg) {
	Assert.assertTrue(driver.getPageSource().contains(msg));
	Navigate_To_Home h=new Navigate_To_Home(driver);
	h.clickOnLink();
    
}
@When("i click on add tariff plan")
public void i_click_on_add_tariff_plan() {
   Navigate_To_TariffPage tp=new Navigate_To_TariffPage(driver);
   tp.clickONAddTeriff();
}
@Then("i entr all details in add tariff plan")
public void i_entr_all_details_in_add_tariff_plan() {
    Add_Tariff_Plane_Page ap =new Add_Tariff_Plane_Page(driver);
    ap.enterMontlyRent("90");
    ap.enterLocalMinutes("60");
    ap.enterInter_Minutes("90");
    ap.enterSmsPack("100");
    ap.EnterLocalCharges("6");
    ap.intr_Charges("3");
    ap.EntersmsCharge("4");
    
}
@Then("click on submit button of tariff plan")
public void click_on_submit_button_of_tariff_plan() {
	driver.findElement(By.name("submit")).click();
}


@After
public void getScreenShot(Scenario sce) throws IOException {
	if(sce.isFailed()) {
	// File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	// sce.attach(scr,"image/png","srceenshot");
//File f=new File(scr);
	////FileUtils.copyFile(scr,new File(System.getProperty("user.dir")+"/Screnshots/pic.png") );
	//String s=System.getProperty("user.dir")+"/Screnshots/pic.png";
	 byte[] p = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	 sce.attach(p, "image/png", sce.getName());
	 
	 
	}
	
		driver.quit();
	
}

}
