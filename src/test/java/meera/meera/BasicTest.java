package meera.meera;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;

public class BasicTest extends RetailBaseOneway {
public static WebDriver driver;
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Meera\\Browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_W);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_W);
		
		 //driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
        //driver.get("http://172.168.10.239/qa/srx/");
        //driver.get("http://100.100.60.116/srx/");
		//Reading data form excel
        File f=new File("D:\\AutomationFiles\\DDT.xlsx");
        FileInputStream fi=new FileInputStream(f);
        XSSFWorkbook wb=new XSSFWorkbook(fi);
        XSSFSheet sh=wb.getSheet("Sheet1");
        //because count start form zero
        int rowcount=sh.getLastRowNum()+1;
        System.out.println(rowcount);
        //Extent reports
    	//Extentreports generation
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("extent2.html");
     // create ExtentReports and attach reporter(s)
        ExtentReports reports=new ExtentReports();
      //For results appending use "true" instead of false
        reporter.setAppendExisting(true);
        reports.attachReporter(reporter);
     // creates a toggle for the given test, adds all log events under it    
        com.aventstack.extentreports.ExtentTest test=reports.createTest("DDT test");
        driver.get("http://172.168.10.239/qa/srx/");
   	 driver.manage().window().maximize();
        for(int i=1;i<rowcount;i++) {
        	WebElement un=driver.findElement(By.name("sign_in_username_email"));
        	un.clear();
        	WebElement pw=driver.findElement(By.name("sign_in_password"));
        	pw.clear();
        	String Criteria=sh.getRow(i).getCell(0).getStringCellValue();
        	String username;
        	try {
        		username=sh.getRow(i).getCell(1).getStringCellValue();
        	}
        	catch(NullPointerException np){
        		username="";
        	}     	
        	String password;
        	try {
        		password=sh.getRow(i).getCell(2).getStringCellValue();	
        	}
        	catch(NullPointerException np) {
        		password="";
        	}	
    	
        	un.sendKeys(username);
		pw.sendKeys(password);
		driver.findElement(By.xpath("//*[text()=' Sign In ']")).click();
		Thread.sleep(5000);
		if((pw.equals("")||un.equals(""))&&driver.findElement(By.xpath("//*[text()='Username/Password should not be empty.']")).isDisplayed()) {
			test.log(Status.PASS, "Blank  Un or pw test passed");
		            }
		else if(Criteria.equals("Invalid")&&(un.equals(username)&&pw.equals(password))&&driver.findElement(By.xpath("//*[text()='Sorry, your Username/Email and Password combination is incorrect.']")).isDisplayed()) {
		
		test.log(Status.PASS, "Invalid data test passed");
		}
        else if(Criteria.equals("Valid")&&driver.findElement(By.xpath("//*[@id='time']")).isDisplayed())  {
        	test.log(Status.PASS, "Valid data test passed");
        }
        else 
        {
        	//Unique name each result
    		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
    		Date dt=new Date();
    		String fname=sdf.format(dt)+".png";
    		//Screenshot
    		File sc=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		String path="D:\\"+fname;
            File f1=new File(path);
            FileHandler.copy(sc,f1);
    		test.log(Status.INFO, "Chrome Browser Launched Successfully"+test.addScreenCaptureFromPath(path));
    		reports.flush();
        }
        }
        System.out.println("Done");
	}

}
