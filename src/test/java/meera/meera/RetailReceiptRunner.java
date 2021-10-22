package meera.meera;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RetailReceiptRunner extends RetailBaseOneway {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub
		//Excel data reading
		File file = new File("D:\\DataFile.xlsx");
		 FileInputStream fio=new FileInputStream(file);
		 XSSFWorkbook wb= new XSSFWorkbook(fio);
		 XSSFSheet sheet=wb.getSheet("Sheet1");
		 int rows=sheet.getLastRowNum()+1;
		 System.out.println(rows);
		 for(int r=1;r<rows;r++) {
			 
			 if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("ISSUED"))
			 {
				 RetailBaseOneway.browserHistory();
				//PNR SEARCH
				String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
				//CHANGING STATUS
				XSSFCell cell=sheet.getRow(r).getCell(7);
				cell.setCellValue("RECEIPT DONE");
				FileOutputStream fo=new FileOutputStream(new File("D:\\DataFile.xlsx"));
				wb.write(fo);
				//RetailBaseOneway.bookingReports(pnr);
				RetailBaseOneway.fullReceiptIssue();
                }
			 else if(sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("REISSUED"))
			 {
			    RetailBaseOneway.browserHistory();
				//PNR SEARCH
				String pnr=sheet.getRow(r).getCell(6).getStringCellValue();
				//PAX	 
				 int ADULT=(int) sheet.getRow(r).getCell(1).getNumericCellValue();
				 int CHILD=(int) sheet.getRow(r).getCell(2).getNumericCellValue();
				 int INFANT=(int) sheet.getRow(r).getCell(3).getNumericCellValue();
				//RetailBaseOneway.bookingReports(pnr);
				RetailBaseOneway.fullReceiptIssue();
				//CHANGING STATUS
				XSSFCell cell=sheet.getRow(r).getCell(7);
				cell.setCellValue("RECEIPT DONE");
				FileOutputStream fo=new FileOutputStream(new File("D:\\DataFile.xlsx"));
				wb.write(fo);
                }
			 else if ((sheet.getRow(r).getCell(7).getStringCellValue().equalsIgnoreCase("RECEIPT DONE")&&r==rows-1))
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
