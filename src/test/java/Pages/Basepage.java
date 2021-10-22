package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basepage {
	public static WebDriver driver;
	public void Browserlaunch(String Browser,String URL) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Meera\\Browserdrivers\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		driver.get(URL);
	}

}
