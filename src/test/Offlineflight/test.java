package Offlineflight;
import java.io.File;
import java.io.IOException;
//import java.util.List;
import java.util.Random;
//import java.util.ArrayList;
import java.util.Set;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
//import java.util.concurrent.TimeUnit;
//import javax.print.DocFlavor.STRING;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
public static WebDriver driver;
static String random ;
private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
private static final int RANDOM_STRING_LENGTH = 6;
		
	public static String generateRandomString(){
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	         return randStr.toString();
	   	
	        }
	private static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }


	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagul Meera\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//driver.get("http://100.100.60.116/dashboard");
	driver.get("http://172.168.10.101/ota/otadev/srm/trunk/login/?continue=http%3A%2F%2F172.168.10.101%2Fota%2Fotadev%2Fsrm%2Ftrunk%2Fdashboard");
      // Thread.sleep(10000);
		driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
		driver.findElement(By.name("sign_in_password")).sendKeys("warren");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
      Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@title='New Request']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='select2-customerid-container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']/span/input")).sendKeys("MEERA CREATIONS");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']/span/input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='btn btn-lightblue pull-right requestsubmit']")).click();
		Thread.sleep(15000);
		//code for search operation
		//SCREENSHOT
		File sc=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File na=new File("C:\\Users\\Nagul Meera\\Desktop\\all info\\screenshot.png");
		FileHandler.copy(sc,na);
		/*
		driver.findElement(By.xpath("//li[@class='active']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='flightsource[1]']")).sendKeys("Abu Dhabi-AE(AUH) - Abu Dhabi Intl");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='flightdestination[1]']")).sendKeys(" London-GB(LHR) - London Heathrow");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='DepartureDate[1]']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
		//TO SELECT CURRENT DATE
		//driver.findElement(By.className("ui-datepicker-today")).click();
		
		Thread.sleep(2000);
		WebElement w=driver.findElement(By.xpath("//*[@name='flight_adult[1]']"));
	    Select s=new Select(w);
		s.selectByIndex(3);
		int adult=3;
		WebElement N=driver.findElement(By.xpath("//*[@name='flight_child[1]']"));
		Select s1=new Select(N);
		s1.selectByIndex(1);
		int child=2;
		WebElement M=driver.findElement(By.xpath("//*[@name='flight_infant[1]']"));
		Select s2=new Select(M);
		s2.selectByIndex(1);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
	Thread.sleep(20000);
	//for scroll UP
	JavascriptExecutor jse1 = (JavascriptExecutor) driver;
	jse1.executeScript("window.scrollBy(0,-400)", "");
	Thread.sleep(5000);
WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(1);
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", offilineflight);
Thread.sleep(10000);
System.out.println("Offiline flight link tested successfully");
	Set<String> s11=driver.getWindowHandles();
	Object popup[]=s11.toArray();
	driver.switchTo().window(popup[1].toString());
	Thread.sleep(15000);
	driver.findElement(By.linkText("Expand All")).click();
	//ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
	//a.driver.swichTo().window(a.get(1));
	System.out.println("WELCOME TO NEW WINDOW");
	random =generateRandomString();
	System.out.println(random);
	driver.findElement(By.xpath("//*[@name='pnrnumber']")).sendKeys(random);
	driver.findElement(By.xpath("//*[@name='iatanumber']")).sendKeys("5656566");
	driver.findElement(By.xpath("//*[@class='form-control marketingcarriertypeahead marketingcarrier tt-input']")).sendKeys("BA");
	driver.findElement(By.xpath("//*[@name='flightnooneway[]']")).sendKeys("72");
	driver.findElement(By.xpath("//*[@name='operatingoneway[]']")).sendKeys("BA");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@name='equipmenttype[]']")).sendKeys("British Aerospace BAe 146-100");
	Thread.sleep(2000);
	WebElement element11=driver.findElement(By.xpath("//*[@name='airclassoneway[]']"));
	Select drop21=new Select(element11);
	drop21.selectByVisibleText("Business");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"oneWay\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/span/span[1]/span/span[2]")).click();
	driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/input")).sendKeys("B");
	driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//*[@name='departuretimeoneway[]']")).sendKeys("12:30");
	driver.findElement(By.xpath("//*[@name='arivaltimeoneway[]']")).sendKeys("06:30");
	driver.findElement(By.xpath("//*[@name='durationonewayhh[]']")).sendKeys("06");
	driver.findElement(By.xpath("//*[@name='durationonewaymm[]']")).sendKeys("00");
	//SECOND SEGMENT
	/*driver.findElement(By.xpath("//*[@id=\"oneWay\"]/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='flighttooneway2']")).sendKeys("AUH");
	driver.findElement(By.xpath("//*[@id=\"marketingoneway2\"]")).sendKeys("BA");
	driver.findElement(By.xpath("(//*[@name=\"flightnooneway[]\"])[2]")).sendKeys("72");
	driver.findElement(By.xpath("//*[@id=\"operatingoneway2\"]")).sendKeys("BA");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[@name=\"equipmenttype[]\"])[2]")).sendKeys("British Aerospace BAe 146-100");
	Thread.sleep(2000);
	WebElement element12=driver.findElement(By.xpath("(//*[@name=\"airclassoneway[]\"])[2]"));
	Select drop22=new Select(element12);
	drop22.selectByVisibleText("Economy");
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//*[@class='select2-selection select2-selection--single']")).click();
	//driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("D");
	//driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
	//driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("D");
	//driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//*[@name='departuretimeoneway[]'])[2]")).sendKeys("12:30");
	//Thread.sleep(1000);
	driver.findElement(By.xpath("(//*[@name='arivaloneway[]'])[2]")).click();
	driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
	driver.findElement(By.xpath("(//*[@name='arivaltimeoneway[]'])[2]")).sendKeys("06:30");
	driver.findElement(By.xpath("(//*[@name='durationonewayhh[]'])[2]")).sendKeys("06");
	driver.findElement(By.xpath("(//*[@name='durationonewaymm[]'])[2]")).sendKeys("00"); */
	driver.findElement(By.xpath("//*[@id='validate']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/span/span[1]/span/ul")).click();
	driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
	driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("jennifer");
	Thread.sleep(5000);
	WebElement e1l = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[3]/td[1]/input[1]"));
	JavascriptExecutor check = (JavascriptExecutor) driver;
	check.executeScript("arguments[0].click()", e1l);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@title='ADULT']")).click();
	driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("jennifer");
	driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	/*WebElement e13 = driver.findElement(By.xpath("//*[@id=\\\"0\\\"]/div[1]/div[4]/div/span/span[1]/span"));
	JavascriptExecutor check3 = (JavascriptExecutor) driver;
	check3.executeScript("arguments[0].click()", e13);*/
	try {
	driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[4]/div/span/span[1]/span")).click();
	Thread.sleep(2000);
	}
	catch(Exception e) {
		driver.findElement(By.xpath("//*[@class='select2-selection select2-selection--single']")).click();
		Thread.sleep(2000);
	}
	driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("MEERA");
	driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//*[@class='form-control basePclass']")).sendKeys("20000");
	driver.findElement(By.xpath("//*[@class='form-control totalTaxClass']")).sendKeys("500");
	driver.findElement(By.xpath("//*[@name='m2Price[]']")).click();
	driver.findElement(By.xpath("//*[@name='m2Price[]']")).sendKeys(Keys.BACK_SPACE);
	JavascriptExecutor jse31 = (JavascriptExecutor) driver;
	jse31.executeScript("document.getElementById('m2Price1').value='200';");
	driver.findElement(By.xpath("//*[@name='discountPrice[]']")).click();
	driver.findElement(By.xpath("//*[@name='discountPrice[]']")).sendKeys(Keys.BACK_SPACE);
	JavascriptExecutor jse41 = (JavascriptExecutor) driver;
	jse41.executeScript("document.getElementById('discountPrice1').value='100';");
	Thread.sleep(1000);
	if(adult>1) {
		driver.findElement(By.xpath("//*[@class='btn btn-xs btn-lightblue addtst']")).click();
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul")).click();
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);	
		driver.findElement(By.xpath("(//*[@title='Add Passengers'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("James");
		Thread.sleep(3000);
		WebElement e12 = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[8]/td[1]/input[1]"));
		JavascriptExecutor check2 = (JavascriptExecutor) driver;
		check2.executeScript("arguments[0].click()", e12);
		Thread.sleep(2000);
		Alert alert =driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]")).click();
		/*WebElement offilineflight2=driver.findElement(By.xpath("//*[@id='select2-passengerNm-jf-container']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", offilineflight2);*/
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("James");
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[3]/div[2]/div/span/span[1]/span")).click();
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("MEERA");
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).clear();
		random =generateRandomString();
		System.out.println(random);
		driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).sendKeys(random);
		//driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).sendKeys(Keys.chord(Keys.CONTROL,"A","DELETE"));
		driver.findElement(By.xpath("(//*[@class='form-control basePclass'])[2]")).sendKeys("20000");
		driver.findElement(By.xpath("(//*[@class='form-control totalTaxClass'])[2]")).sendKeys("500");
		driver.findElement(By.xpath("(//*[@name='m2Price[]'])[2]")).click();
		driver.findElement(By.xpath("(//*[@name='m2Price[]'])[2]")).sendKeys(Keys.BACK_SPACE);
		JavascriptExecutor jse32 = (JavascriptExecutor) driver;
		jse32.executeScript("document.getElementById('m2Price2').value='200';");
		driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).click();
		driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).sendKeys(Keys.BACK_SPACE);
		JavascriptExecutor jse42 = (JavascriptExecutor) driver;
		jse42.executeScript("document.getElementById('discountPrice2').value='100';");
		Thread.sleep(1000);
	}
	else {
		System.out.println("adult=1");
	}
	if(child>1) {
		if(adult==1) {
			driver.findElement(By.xpath("//*[@class='btn btn-xs btn-lightblue addtst']")).click();
			driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul")).click();
			driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
			driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);	
			driver.findElement(By.xpath("(//*[@title='Add Passengers'])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("James");
			Thread.sleep(3000);
			WebElement e12 = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[8]/td[1]/input[1]"));
			JavascriptExecutor check2 = (JavascriptExecutor) driver;
			check2.executeScript("arguments[0].click()", e12);
			Thread.sleep(2000);
			Alert alert =driver.switchTo().alert();
			alert.accept();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]")).click();
			/*WebElement offilineflight2=driver.findElement(By.xpath("//*[@id='select2-passengerNm-jf-container']"));
			JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();", offilineflight2);*/
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("James");
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id=\"1\"]/div[1]/div[3]/div[2]/div/span/span[1]/span")).click();
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("MEERA");
			driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).clear();
			random =generateRandomString();
			System.out.println(random);
			driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).sendKeys(random);
			//driver.findElement(By.xpath("(//*[@name='ticketnumber[]'])[2]")).sendKeys(Keys.chord(Keys.CONTROL,"A","DELETE"));
			driver.findElement(By.xpath("(//*[@class='form-control basePclass'])[2]")).sendKeys("20000");
			driver.findElement(By.xpath("(//*[@class='form-control totalTaxClass'])[2]")).sendKeys("500");
			driver.findElement(By.xpath("(//*[@name='m2Price[]'])[2]")).click();
			driver.findElement(By.xpath("(//*[@name='m2Price[]'])[2]")).sendKeys(Keys.BACK_SPACE);
			JavascriptExecutor jse32 = (JavascriptExecutor) driver;
			jse32.executeScript("document.getElementById('m2Price2').value='200';");
			driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).click();
			driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).sendKeys(Keys.BACK_SPACE);
			JavascriptExecutor jse42 = (JavascriptExecutor) driver;
			jse42.executeScript("document.getElementById('discountPrice2').value='100';");
			Thread.sleep(1000);
			
		}
		else {
			
		}
	}
	driver.findElement(By.xpath("//*[@class='btn btn-lightblue addPrice']")).click();
	Thread.sleep(3000);
	Alert alert =driver.switchTo().alert();
	alert.accept();
}
}


	

	
	
	
	
	