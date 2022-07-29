package testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import io.cucumber.java.Scenario;
import utils.ExcelUtils;
import utils.GetKey;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
//     String b= GetKey.getValue("browser");
//     System.out.println(b);
		
		ExcelUtils m=new ExcelUtils("C:\\Users\\Dell\\Desktop\\alekh.xlsx");
		for(int i=1;i<=m.getRowCount("Worksheet");i++) {
			//m.setCellData("Worksheet", i, 3, "Fail");
			for(int j=0;j<m.getColumnCount("Worksheet");j++) {
				String data=m.getCellData("Worksheet", i, j);
				System.out.println(data);
			
			}
		}
		FileOutputStream o=new FileOutputStream("C:\\Users\\Dell\\Desktop\\alek.xlsx");
		m.wb.write(o);
		
}

}
