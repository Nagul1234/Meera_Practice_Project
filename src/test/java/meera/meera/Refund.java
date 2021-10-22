package meera.meera;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

public class Refund extends IssueretailAllRunner{

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		// TODO Auto-generated method stub
		//Excel data reading
		File file = new File("D:\\DataFile.xlsx");
		 FileInputStream fio=new FileInputStream(file);
		 XSSFWorkbook wb= new XSSFWorkbook(fio);
		 XSSFSheet sheet=wb.getSheet("Sheet2");
		 
		 int rows=sheet.getLastRowNum()+1;
		 System.out.println(rows);
		 for(int r=1;r<rows;r++) {
			 
			 if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("ISSUED"))
			 {
				 RetailBaseOneway.browserHistory();
				//PNR SEARCH
				String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
				//RetailBaseOneway.bookingReports(pnr);
				//CHANGING STATUS
				XSSFCell cell=sheet.getRow(r).getCell(7);
				cell.setCellValue("REFUNDED");
				//fi.close();
				FileOutputStream fo=new FileOutputStream(new File("D:\\DataFile.xlsx"));
				wb.write(fo);
				//fo.close();
				//Scrolldown
				JavascriptExecutor jc=(JavascriptExecutor)driver;
				jc.executeScript("window.scrollBy(0,600);", "");
				
				//excelreading

				RetailBaseOneway.refundMulti(/*ADULT,CHILD,INFANT*/);
                }
			 else if ((r==rows-1))
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
