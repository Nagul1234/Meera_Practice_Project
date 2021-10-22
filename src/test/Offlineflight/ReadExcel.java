package Offlineflight;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcel {
	
	 public static void main(String[] args) throws IOException
	    {
	        File fileName = new File ("D:\\Meera.xls");
	        FileInputStream fis = new FileInputStream(fileName);
	        POIFSFileSystem fs = new POIFSFileSystem(fis);
	        FileOutputStream fout = new FileOutputStream(fileName);
	        HSSFWorkbook wb = new HSSFWorkbook(fs);
	        HSSFSheet sh = wb.getSheetAt(0);  
	        sh.getRow(1).createCell(7).setCellValue("Wally");
	        /*int i;
	        for (i = 0; i <= 10; i++)
	        {
	            sh.getRow(11).createCell(i).setCellValue(i+3);
	        }*/
	         
	        wb.write(fout);
	        wb.close();
	         
	        System.out.println("It's working");
	         
	    }
	
}