package meera.meera;


import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class IssueretailAllRunner extends RetailBaseOneway {
	
	public static void main(String[] args) throws Exception {
		//Excel data reading
		 File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
		 FileInputStream fio=new FileInputStream(file);
		 XSSFWorkbook wb= new XSSFWorkbook(fio);
		 XSSFSheet sheet=wb.getSheet("Sheet1");
		 int rows=sheet.getLastRowNum()+1;
		 for(int r=1;r<2;r++){
			 
		//Agent
		String Agent=sheet.getRow(r).getCell(0).getStringCellValue();	
		
		//PAX	 
		 int ADULT=(int) sheet.getRow(r).getCell(1).getNumericCellValue();
		 int CHILD=(int) sheet.getRow(r).getCell(2).getNumericCellValue();
		 int INFANT=(int) sheet.getRow(r).getCell(3).getNumericCellValue();
	    //FROM&TO
		 String From=sheet.getRow(r).getCell(4).getStringCellValue();
		 String To=sheet.getRow(r).getCell(5).getStringCellValue();
		 String Adult = String.valueOf(ADULT);
		 String Child = String.valueOf(CHILD);
		 String Infant = String.valueOf(INFANT);
		 //retailIssue1111(r,r);
		 //RetailBaseOneway.bookingReports();
		 RetailBaseOneway.browserHistory(); 
		 RetailBaseOneway.retailIssueExcel(ADULT,CHILD,INFANT,r,Adult,Child,Infant,From,To,Agent);
		 //RetailBaseOneway.corporatelIssueExcel(ADULT,CHILD,INFANT,r,Adult,Child,Infant,From,To,Agent);
		 //RetailBaseOneway.fullReceiptIssue();
	}

}
}
