package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public Workbook wb;
   public ExcelUtils(String filePath) throws EncryptedDocumentException, IOException {
	   FileInputStream fi=new FileInputStream(filePath);
	   wb=WorkbookFactory.create(fi);
    }
   //get row count
   public  int getRowCount(String Sheetname) {
   return wb.getSheet(Sheetname).getLastRowNum();
   }
   //get column number
   public int getColumnCount(String Sheetname) {
	  return wb.getSheet(Sheetname).getRow(1).getLastCellNum();
   }
   //get cell data
   public String getCellData(String Sheetname,int rownumber,int cellnumber) {
	   String celldata = null;
	  // wb.getSheet(Sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
	   if(wb.getSheet(Sheetname).getRow(rownumber).getCell(cellnumber).getCellType()==CellType.NUMERIC) {
		 int info= (int) wb.getSheet(Sheetname).getRow(rownumber).getCell(cellnumber).getNumericCellValue();
		  celldata= String.valueOf(info);
	   }
	   else if(wb.getSheet(Sheetname).getRow(rownumber).getCell(cellnumber).getCellType()==CellType.STRING) {
		   celldata=wb.getSheet(Sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
	   }
	   return celldata;
   }
   // set celldata
   public void setCellData(String Sheetname,int row,int cellnumber,String status,String outfilepath) throws IOException {
	  Row r= wb.getSheet(Sheetname).getRow(row);
	  Cell cell=r.createCell(cellnumber);
	  
	  cell.setCellValue(status);
	  if(status.equalsIgnoreCase("Pass")) {
		 CellStyle style= wb.createCellStyle();
		Font font= wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		r.getCell(cellnumber).setCellStyle(style);
	  }else if(status.equalsIgnoreCase("Fail")) {
		CellStyle style=  wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		
		style.setFont(font);
		r.getCell(cellnumber).setCellStyle(style);
	  }else if(status.equalsIgnoreCase("Skip")) {
		  CellStyle style=  wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.YELLOW.getIndex());
			font.setBold(true);
			
			style.setFont(font);
			r.getCell(cellnumber).setCellStyle(style);
	  }
	  FileOutputStream o=new FileOutputStream(new File(outfilepath));
	  wb.write(o);
   }
}
