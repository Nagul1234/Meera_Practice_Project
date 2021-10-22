package meera.meera;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RetailRefundReceipt extends RetailBaseOneway{

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
		//Excel data reading
		File file = new File("D:\\DataFile.xlsx");
		 FileInputStream fio=new FileInputStream(file);
		 XSSFWorkbook wb= new XSSFWorkbook(fio);
		 XSSFSheet sheet=wb.getSheet("Sheet2");
		 int rows=sheet.getLastRowNum()+1;
		 System.out.println(rows);
		 for(int r=1;r<rows;r++) {
			 
			 if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("VOIDED"))
			 {
				 RetailBaseOneway.browserHistory();
				//PNR SEARCH
				String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
				//CHANGING STATUS
				XSSFCell cell=sheet.getRow(r).getCell(7);
				cell.setCellValue("REFUNDRECEIPT DONE");
				
				//RetailBaseOneway.bookingReports(pnr);
				RetailBaseOneway.reissueResMulti();
                }
			 else if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("REFUNDED"))
			 {
				 RetailBaseOneway.browserHistory();
				//PNR SEARCH
				String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
				//CHANGING STATUS
				XSSFCell cell=sheet.getRow(r).getCell(7);
				cell.setCellValue("REFUNDRECEIPT DONE");
				
				
				//RetailBaseOneway.bookingReports(pnr);
				RetailBaseOneway.reissueResMulti();
                }
			 else if ((sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("REFUNDRECEIPT DONE")&&r==rows-1))
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
