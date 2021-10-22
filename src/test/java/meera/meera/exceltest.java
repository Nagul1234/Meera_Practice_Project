package meera.meera;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class exceltest {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Meera\\chromedriver_win32 (5)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//driver.get("http://100.100.60.116/dashboard");
driver.get("http://172.168.10.239/qa/srx/");
//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
      // Thread.sleep(10000);
		driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
		driver.findElement(By.name("sign_in_password")).sendKeys("warren");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Unique name each result
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date dt=new Date();
		String fname=sdf.format(dt)+".png";
		//Extentreports generation
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		//For results appending use "true" instead of false
		htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("verifyHomePageTitle", "Checking the Title");
		//Screenshot
		File sc=driver.getScreenshotAs(OutputType.FILE);
		String path="D:\\fname.png";
        File f=new File(path);
        FileHandler.copy(sc,f);
		test.log(Status.INFO, "Chrome Browser Launched Successfully"+test.addScreenCaptureFromPath(path));
		extent.flush();
		System.out.println("done");
		
	}

}
