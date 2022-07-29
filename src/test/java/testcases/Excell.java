package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Excell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    //  FileReader r=new FileReader();
      FileInputStream i =new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\alekh.xlsx"));
       Workbook book = WorkbookFactory.create(i);
      int shets= book.getNumberOfSheets();
  // int num= book.getSheet("benarji").getFirstRowNum();
     System.out.println(shets);
  org.apache.poi.ss.usermodel.Sheet s = book.getSheetAt(0);
  int rowcount=s.getLastRowNum();
  System.out.println( rowcount);
  int colunmcount=s.getRow(1).getLastCellNum();
  System.out.println(colunmcount);
  for(int i1=1;i1<=rowcount;i1++) {
	  for(int j=0;j<colunmcount;j++) {
		  if(s.getRow(i1).getCell(j).getCellType()==org.apache.poi.ss.usermodel.CellType.NUMERIC) {
			  int nu = (int)s.getRow(i1).getCell(j).getNumericCellValue();
			  
			 String d= Double.toString(nu);
			  System.out.println(d);
		  }else if(s.getRow(i1).getCell(j).getCellType()==org.apache.poi.ss.usermodel.CellType.STRING) {
		  String info=s.getRow(i1).getCell(j).getStringCellValue();
		  System.out.println(info);
		  }
	  }
  }
     
	}

}
