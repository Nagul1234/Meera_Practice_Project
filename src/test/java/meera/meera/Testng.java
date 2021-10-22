package meera.meera;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testng {
    public static WebDriver driver;
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver","D:\\Meera\\chromedriver_win32 (5)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://172.168.10.101/ota/otadev/srm/trunk/booking/getflightreport#!");
		driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
		driver.findElement(By.name("sign_in_password")).sendKeys("warren");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Next")).click();
	}
}
