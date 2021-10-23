package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basepage {
	public static WebDriver driver;
	public void Browserlaunch(String Browser,String URL) throws AWTException {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Meera\\Browserdrivers\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			Robot rt=new Robot();
			rt.keyPress(KeyEvent.VK_CONTROL);
			rt.keyPress(KeyEvent.VK_W);
			rt.keyRelease(KeyEvent.VK_CONTROL);
			rt.keyRelease(KeyEvent.VK_W);
			
		}
		driver.get(URL);
	}

}
