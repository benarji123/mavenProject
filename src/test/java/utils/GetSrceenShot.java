package utils;

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

import testcases.ScreenShots;

public class GetSrceenShot {
public static String takeSrceenShot(WebDriver dr,String methodname) throws IOException {
	 Date d=new Date();
     SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
     String date= s.format(d);
    File s1= ( (TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
    String path=System.getProperty("user.dir")+"/Srcenshots/"+methodname+"_"+date+".png";
    
    File distination=new File(path);
    FileUtils.copyFile(s1, distination);
    return path;
}
}
