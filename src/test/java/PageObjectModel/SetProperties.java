package PageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SetProperties {
 public static  void main(String []args) throws FileNotFoundException, IOException {
	 Properties p=new Properties();
	 p.load(new FileInputStream(new File("src/test/resources/file.properties")));
	
	 
	 
 }
}
