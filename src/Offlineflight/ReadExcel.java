package Offlineflight;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel {
	
	 public static void main(String[] args) throws IOException
	    {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagul Meera\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
	        /*File fileName = new File ("D:\\Meera.xls");
	        FileInputStream fis = new FileInputStream(fileName);
	        POIFSFileSystem fs = new POIFSFileSystem(fis);
	        FileOutputStream fout = new FileOutputStream(fileName);
	        HSSFWorkbook wb = new HSSFWorkbook(fs);
	        HSSFSheet sh = wb.getSheetAt(0);  
	        sh.getRow(1).createCell(7).setCellValue("Wally");
	        
	        int i;
	        for (i = 0; i <= 10; i++)
	        {
	            sh.getRow(11).createCell(i).setCellValue(i+3);
	        }
	         
	        wb.write(fout);
	        wb.close();
	         
	        System.out.println("It's working");*/
		 
		 
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\extent.html");
			 
			// create ExtentReports and attach reporter(s)
			ExtentReports extent = new ExtentReports();
			
			extent.attachReporter(htmlReporter);
	 
			// creates a toggle for the given test, adds all log events under it    
			ExtentTest test = extent.createTest("verifyHomePageTitle", "Checking the Title");
			test.log(Status.INFO, "Chrome Browser Launched Successfully");
	         
	    }
	
}