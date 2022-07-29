package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https:/fb.com");
      driver.manage().window().maximize();
      String photo ="pic";
//      File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//      System.out.println("Source"+"---->"+scr);
     Date d=new Date();
//      System.out.println(d);
     SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
    String date= s.format(d);
    Class c = ScreenShots.class;
//     
//      File distination=new File("./target/"+c.getName()+" "+date+".png");
//      System.out.println("dis----"+distination);
//      FileUtils.copyFile(scr, distination);
//      driver.quit();
     WebElement el= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div"))	;
    File s1= el.getScreenshotAs(OutputType.FILE);
    File distination=new File("./target/"+c.getName()+" "+date+".png");
    FileUtils.copyFile(s1, distination);
    driver.quit();
	}

}
