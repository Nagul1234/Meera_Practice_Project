

package Offlineflight;
	//import java.io.File;
import java.util.List;
	import java.util.Random;
	import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;



public class Modify {
	
		
			public static WebDriver driver;
			static String random ;
			private static final String CHAR_LIST ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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


				public static void main(String[] args) throws InterruptedException {
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagul Meera\\Downloads\\chromedriver_win32\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					String UAT="http://100.100.60.116/dashboard";
				    String 	QA="http://172.168.10.239/qa/srx/";
			     	String DEV="http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!";
			     	driver.get(DEV);
					driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
					driver.findElement(By.name("sign_in_password")).sendKeys("warren");
					driver.findElement(By.xpath("//*[text()='Sign In']")).click();
			      //Thread.sleep(20000);
			      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@title='New Request']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					//Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='select2-customerid-container']")).click();
					Thread.sleep(2000);		
					driver.findElement(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']/span/input")).sendKeys("MEERA");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']/span/input")).sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='btn btn-lightblue pull-right requestsubmit']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					//code for search operation
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
				s.selectByIndex(1);
				int	adult=1;
					WebElement N=driver.findElement(By.xpath("//*[@name='flight_child[1]']"));
					Select s1=new Select(N);
					s1.selectByIndex(0);
					int child=0;
					WebElement M=driver.findElement(By.xpath("//*[@name='flight_infant[1]']"));
					Select s2=new Select(M);
					s2.selectByIndex(0);
					int infant=0;
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
				Thread.sleep(15000);
				//for scroll UP
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,-400)", "");
				Thread.sleep(10000);
			WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(1);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", offilineflight);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			System.out.println("Offiline flight link tested successfully");
				Set<String> s11=driver.getWindowHandles();
				Object popup[]=s11.toArray();
				driver.switchTo().window(popup[1].toString());
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
				//driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
				driver.findElement(By.cssSelector("#\\30  > div.offline-flt-tkt-zerocontent > div.zerocontent-two > div > span > span.selection > span > ul > li > input")).sendKeys("S1");
				driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				if(adult>=1) {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("jennifer");
				driver.findElement(By.xpath("//*[@name='SearchLName']")).sendKeys("wilson");
				Thread.sleep(8000);
				try {
					WebElement e1l = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input[1]"));		
				JavascriptExecutor check = (JavascriptExecutor) driver;
				check.executeScript("arguments[0].click()", e1l);
				Thread.sleep(2000);
				}
				catch(Exception e) {
					WebElement e1l = driver.findElement(By.xpath("//*[@class='travel-user-chk other-customer-checkbox ']"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(2000);
				}
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@title='ADULT']")).click();
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("jennifer");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				}
				else {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("anthony");
					Thread.sleep(8000);
					WebElement e1l = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[3]/td[1]/input[1]"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@title='ADULT']")).click();
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("anthony");
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
				}
				driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[4]/div/span/span[1]/span")).click();
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Fly");
				Thread.sleep(3000);
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
				for(int c=0;c<(adult-1);c++) {
					List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
				copyticket.get(0).click();
				Thread.sleep(3000);
				}
				for(int i=0;i<(adult-1);i++) {
				String[] STRING_ARRAY = {"James", "Jhon","nagul", "pawan"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys(STRING_ARRAY[i]);
				Thread.sleep(8000);
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mrs. Jennifer Wilson(Adult)'])"));
				System.out.println("done");
				passenger2.get(1).click();
				String[] STRING_ARRAY1 = {"James", "Jhon","nagul", "pawan"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
			Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
				tickets.get(i+1).clear();
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				tickets.get(i+1).sendKeys(random);
				Thread.sleep(3000);
				}
				//child
				 int x;
				if(adult>=1) {
					x=child;
				}
				else {
					 x=(child-1);
				}
				for(int c=0;c<(x);c++) {
					List<WebElement> copyticketchild = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));
				copyticketchild.get(0).click();
				Thread.sleep(3000);
				}
				int c=child;
				if(adult>=1) {
				for(int i=0;i<(c);i++) {
				Thread.sleep(3000);
				String[] STRING_ARRAY = {"arun", "sameer","mahesh"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+adult).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys(STRING_ARRAY[i]);
				Thread.sleep(8000);
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mrs. Jennifer Wilson(Adult)'])"));	
				passenger2.get(i+1).click();
				String[] STRING_ARRAY1 = {"arun", "sameer","mahesh"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]);
				Thread.sleep(8000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
				tickets.get(i+adult).clear();
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				tickets.get(i+adult).sendKeys(random);
				Thread.sleep(3000);
				}
				}
				else { 
					for(int i=0;i<(child-1);i++) {
				String[] STRING_ARRAY = {"arun", "sameer","mahesh"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys(STRING_ARRAY[i]);
				Thread.sleep(8000);
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mr. Anthony Wilson(Child)'])"));
				passenger2.get(i+1).click();
				String[] STRING_ARRAY1 = {"arun", "sameer","mahesh"};
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
				tickets.get(i+1).clear();
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				tickets.get(i+1).sendKeys(random);
				Thread.sleep(3000);
				}
				}
				if(adult>=1) {
					for(int d=0;d<(infant);d++) {
						List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
					copyticket.get(0).click();
					Thread.sleep(3000);
					}
					for(int i=0;i<(infant);i++) {
						String[] STRING_ARRAY = {"akbar", "Neils","Marie"};
						Thread.sleep(3000);
						List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
						passenger.get(i+adult+child).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys(STRING_ARRAY[i]);
						Thread.sleep(8000);
						WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
						JavascriptExecutor check1 = (JavascriptExecutor) driver;
						check1.executeScript("arguments[0].click()", e1l1);
						Thread.sleep(5000);
						Alert alert =driver.switchTo().alert();
						alert.accept();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
						Thread.sleep(2000);
						List<WebElement> passenger3 = driver.findElements(By.xpath("(//*[@title='Mrs. Jennifer Wilson(Adult)'])"));	
						passenger3.get(i+1).click();
						String[] STRING_ARRAY1 = {"akbar", "Neils","Marie"};
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
						List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
						tickets.get(i+adult+child).clear();
						Thread.sleep(2000);
						random =generateRandomString();
						Thread.sleep(2000);
						tickets.get(i+adult+child).sendKeys(random);
						Thread.sleep(3000);
						}
					
				}
				driver.findElement(By.xpath("//*[@class='btn btn-lightblue addPrice']")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				//Thread.sleep(3000);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//RECEIPT
				driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.linkText("Click here to generate receipt..")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
				Select MOPCASH=new Select(MOP);
				MOPCASH.selectByIndex(1);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='receiveamt[12][]']")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='receiveamt[12][]']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='savePay']")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
				driver.findElement(By.xpath("(//*[@name='submitPay'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				Alert alert2 =driver.switchTo().alert();
				alert2.accept();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				}
				
}
				
				
				
				
				

               
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				


				








