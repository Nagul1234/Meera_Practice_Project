package meera.meera;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import jxl.read.biff.BiffException;


public class ReissueRunner extends IssueretailAllRunner {

	public static void main(String[] args) throws IOException, InterruptedException, BiffException, AWTException {
		       //Excel data reading
				File file = new File("D:\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet1");
				 
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 for(int r=1;r<2;r++) {
					 
					 if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("ISSUED"))
					 {
						 RetailBaseOneway.browserHistory();
						//PNR SEARCH
						String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
						//RetailBaseOneway.bookingReports(pnr);
						//fi.close();
						
						//fo.close();
						//Scrolldown
						JavascriptExecutor jc=(JavascriptExecutor)driver;
						jc.executeScript("window.scrollBy(0,600);", "");
						//excelreading
						//PAX	 
						 int ADULT=(int) sheet.getRow(r).getCell(1).getNumericCellValue();
						 int CHILD=(int) sheet.getRow(r).getCell(2).getNumericCellValue();
						 int INFANT=(int) sheet.getRow(r).getCell(3).getNumericCellValue();
						RetailBaseOneway.reissueAddMulti(ADULT,CHILD,INFANT);
						//CHANGING STATUS
						XSSFCell cell=sheet.getRow(r).getCell(7);
						cell.setCellValue("REISSUED");
						FileOutputStream fo=new FileOutputStream(new File("D:\\DataFile.xlsx"));
						wb.write(fo);
	                    }
					 else if ((sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("REISSUED")&&r==rows-1))
					 { 
						 System.out.println("ALL PNR'S ARE USED2"); 
						  break;
											  
						 }
					 else {
						 System.out.println("ALL PNR'S ARE USED1"); 
					 }
                     }
				 System.out.println("ALL PNR'S ARE USED");
				 }

	}

	
