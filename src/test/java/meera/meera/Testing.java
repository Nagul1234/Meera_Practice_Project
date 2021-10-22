package meera.meera;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

public class Testing {

	public static void main(String[] args) throws Exception {
		/*int a=1;
		System.out.println(a+" "+"hello"+" "+"world"+" "+"@");*/
	/*System.setProperty("webdriver.chrome.driver","D:\\Meera\\chromedriver_win32 (5)\\chromedriver.exe");
    ChromeDriver driver=new ChromeDriver();*/
	/*driver.get("https://www.google.com");
	driver.findElement(By.xpath("//*[@name='q']")).sendKeys("facebook");
		*/
		//
		Runtime.getRuntime().exec("C:\\Windows\\system32\\calc.exe");
		//send data to clipboard
		StringSelection o=new StringSelection("100");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(o, null); 
		//copy data to app
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		//close
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
		/*r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		//send data to clipboard
		StringSelection P=new StringSelection("100");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(P, null); 
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		//GET OUT
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(4000);*/
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println(z);
		/*int v=(int) 100.69;
		
		String Adult = String.valueOf(v);
		 System.out.println(Adult);
		float v2=Float.parseFloat(Adult);
		 System.out.println(v2);*/
		/*File file = new File("D:\\DataFile.xlsx");
		 FileInputStream fio=new FileInputStream(file);
		 XSSFWorkbook wb= new XSSFWorkbook(fio);
		 XSSFSheet sheet=wb.getSheet("Sheet2");
		 int rows=sheet.getLastRowNum()+1;
		 for(int i=0;i<rows;i++) {
			 int v=(int) sheet.getRow(i).getCell(11).getNumericCellValue();
			 String Adult = String.valueOf(v);
			 float v2=Float.parseFloat(Adult);
			 System.out.println(v2);
		 }*/
		
	}

}
