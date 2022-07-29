package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.mongodb.annotations.ThreadSafe;

public class GetKey {
	
  
   public static	ThreadLocal<Properties>property=new ThreadLocal<Properties>();
   public static 	String s=System.getProperty("user.dir")+"/src/test/resources/file.properties";
   
	public static Properties cofing()  {
		Properties 	p=new Properties();
	  
     try {
		p.load(new FileInputStream(new File(s)));
		property.set(p);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return p;
	}
	

	
	
}
