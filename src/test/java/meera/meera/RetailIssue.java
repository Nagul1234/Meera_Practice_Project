package meera.meera;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
/*import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;*/
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class RetailIssue {
			public static WebDriver driver;
			static String random ;
			private static final String CHAR_LIST ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			private static final int RANDOM_STRING_LENGTH = 6;
			  public static 	HSSFWorkbook workbook;
	          public	FileOutputStream out;
	          public  	HSSFSheet sheet;
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
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagul Meera\\Downloads\\chromedriver_win32\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					//driver.get("http://100.100.60.116/dashboard");
			driver.get("http://172.168.10.239/qa/srx/");
		//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
			      // Thread.sleep(10000);
			workbook = new HSSFWorkbook();


					driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
					driver.findElement(By.name("sign_in_password")).sendKeys("warren");
					driver.findElement(By.xpath("//*[text()='Sign In']")).click();
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@title='Retail Request']")).click();
					Thread.sleep(5000);
					JavascriptExecutor jse41retail = (JavascriptExecutor) driver;
					jse41retail.executeScript("document.getElementById('atu_mobile').value='7893937147';");
					driver.findElement(By.xpath("//*[@id='rusearch']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@class='radio rc']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='rusubmit']")).click();
					Thread.sleep(15000);
					//code for search operation
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//li[@class='active']/a")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flightsource[1]']")).sendKeys("Abu Dhabi-AE(AUH) - Abu Dhabi Intl");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@name='flightdestination[1]']")).sendKeys(" London-GB(LHR) - London Heathrow");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@name='DepartureDate[1]']")).click();
					Thread.sleep(2000);
					//driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
					WebElement date=driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);
					//TO SELECT CURRENT DATE
					//driver.findElement(By.className("ui-datepicker-today")).click();
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
				int n=(adult+child+infant);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
				Thread.sleep(20000);
				//for scroll UP
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,-400)", "");
				Thread.sleep(5000);
			WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(0);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", offilineflight);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			System.out.println("Offiline flight link tested successfully");
				Set<String> s11=driver.getWindowHandles();
				Object popup[]=s11.toArray();
				driver.switchTo().window(popup[1].toString());
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.findElement(By.linkText("Expand All")).click();
				//ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
				//a.driver.swichTo().window(a.get(1));
				System.out.println("WELCOME TO NEW WINDOW");
				random =generateRandomString();
				System.out.println(random);
				driver.findElement(By.xpath("//*[@name='pnrnumber']")).sendKeys(random);
				driver.findElement(By.xpath("//*[@name='iatanumber']")).sendKeys("5656566");
				//driver.findElement(By.xpath("//*[@name='offlineattachment[]']")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\ Penguins.jpg");
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
				if(adult>=1) {
				try {
				driver.findElement(By.xpath("//*[@title='ADULT']")).click();
				Thread.sleep(2000);
				}
				catch(Exception e2)
				{
					driver.findElement(By.xpath("//*[@id=\"select2-passengerNm-98-container\"]")).click();	
					Thread.sleep(2000);
				}
				try {
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Nagul");
				Thread.sleep(2000);
				}
				catch(Exception e3)
				{
					driver.findElement(By.xpath("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys("Nagul");
					Thread.sleep(2000);
				}
				}
				else {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("anthony");
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					Thread.sleep(8000);
					WebElement e1l = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[3]/td[1]/input[1]"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(2000);
					try {
						Alert alert =driver.switchTo().alert();
						alert.accept();
						Thread.sleep(5000);
						}
						catch(Exception A) {
							System.out.println("A.getMessage()");
							Thread.sleep(2000);
						}
					driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					try {
						driver.findElement(By.xpath("//*[@title='ADULT']")).click();
						Thread.sleep(2000);	
					}
					catch(Exception C) {
						driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[3]/div/div[1]/div/span/span[1]/span/span[2]")).click();
						Thread.sleep(2000);
					}
					
					//driver.findElement(By.xpath("//*[@title='ADULT']")).click();
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("anthony");
				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[4]/div/span/span[1]/span")).click();
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Fly");
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//*[@class='form-control basePclass']")).sendKeys("2000");
				driver.findElement(By.xpath("//*[@class='form-control totalTaxClass']")).sendKeys("100");
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
				int	a=i+1;
				String[] STRING_ARRAY = {"James", "Jhon","nagul", "pawan","Britlee","Jacob","Oliver","Fanny","Noah","Harry"};
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
				try {
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				}
				catch(Exception A) {
					System.out.println("A.getMessage()");
					Thread.sleep(2000);
				}
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.findElement(By.xpath(".//*[@id='"+a+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				System.out.println("done1");
				/*WebElement adult1=driver.findElement(By.xpath(".//*[@id='"+a+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();",adult1);
				Thread.sleep(2000);*/
				//List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mr Nagul  meera(Adult)'])"));
				//List<WebElement> passenger2 = driver.findElements(By.cssSelector("select2 select2-container select2-container--default select2-container"));
				//System.out.println("done2");
				//passenger2.get(1).click();
				//WebElement element = passenger2.get(1);
				//JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			//	executor1.executeScript("arguments[0].click();", element);
				
				String[] STRING_ARRAY1 = {"James", "Jhon","nagul", "pawan","Britlee","Jacob","Oliver","Fanny","Noah","Harry"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
				//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
					int C1=(adult+i);
				Thread.sleep(3000);
				String[] STRING_ARRAY = {"arun", "sameer","mahesh","Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+adult).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys(STRING_ARRAY[i]);
				Thread.sleep(8000);
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()",e1l1);
				Thread.sleep(5000);
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception A) {
						System.out.println("A.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				//List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mr Nagul  meera(Adult)'])"));	
				//passenger2.get(i+1).click();
				driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child1=driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor11 = (JavascriptExecutor)driver;
				executor11.executeScript("arguments[0].click();",child1);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"arun", "sameer","mahesh","Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
				Thread.sleep(3000);
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
						int C2=(1+i);
						
				String[] STRING_ARRAY = {"arun", "sameer","mahesh","Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception A) {
						System.out.println("A.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				//List<WebElement> passenger2 = driver.findElements(By.xpath("(//*[@title='Mr. Anthony Wilson(Child)'])"));
				//passenger2.get(i+1).click();
				driver.findElement(By.xpath(".//*[@id='"+C2+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child2=driver.findElement(By.xpath(".//*[@id='"+C2+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor12 = (JavascriptExecutor)driver;
				executor12.executeScript("arguments[0].click();",child2);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"arun", "sameer","mahesh","Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
						int I=(adult+child+i);
						String[] STRING_ARRAY = {"akbar", "Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
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
						try {
							Alert alert =driver.switchTo().alert();
							alert.accept();
							Thread.sleep(5000);
							}
							catch(Exception A) {
								System.out.println("A.getMessage()");
								Thread.sleep(2000);
							}
						driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
						/*WebElement infant1=driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();",infant1);*/
						Thread.sleep(2000);
						
						//List<WebElement> passenger3 = driver.findElements(By.xpath("(//*[@title='Mr Nagul  meera(Adult)'])"));	
						//passenger3.get(i+1).click();
						String[] STRING_ARRAY1 =  {"akbar", "Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
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
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(10000);
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				JavascriptExecutor jse7 = (JavascriptExecutor) driver;
				jse7.executeScript("window.scrollBy(0,-600)", "");
				//excel
				
				/* File file = new File("D:\\Meera.xls");
				  
				Workbook wb = Workbook.createWorkbook(file);
				  WritableSheet sht = wb.createSheet("data", 0); 
				  Label ll = new Label(0, 0, "Result");
				  sht.addCell(ll);
				  sht.addCell(new Label(0, 1, "Pass"));
				  sht.addCell(new Label(0, 2, "Fail"));
				  
				  wb.write();
				  wb.close();*/
				File src= new File("D:\\Meera.xls");
				FileInputStream file = new FileInputStream(src); 
				HSSFWorkbook wb = new HSSFWorkbook(file);
				HSSFSheet sheet1 = wb.getSheetAt(0);
				WebElement P=driver.findElement(By.xpath("//*[@name='pnrnumber']"));
				String PNR=P.getAttribute("value");
				sheet1.getRow(1).createCell(7).setCellValue(PNR);
				FileOutputStream fos= new FileOutputStream(src);
				//wb.write(fos);
				//REISSUE ADD
				/*int P=(n+1);
				List<WebElement> reissue= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissue.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_pen']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[2]/div/input ")).sendKeys("4000");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[3]/div/input ")).sendKeys("100");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input ")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[2]/div/input ")).sendKeys("400");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[3]/div/input ")).sendKeys("100");
				Thread.sleep(2000);
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(10000);*/
				//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
				//REISSUE RESIDUAL&PENALTY
				/*int R=(n+2);
				int P=(n+1);
				List<WebElement> reissueR= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissueR.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_pen']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@name='reissue_res']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				JavascriptExecutor jse5 = (JavascriptExecutor) driver;
				jse5.executeScript("window.scrollBy(0,400)", "");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='"+R+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+R+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+R+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='"+R+"']/div[2]/div[2]/div/input ")).sendKeys("1500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+R+"']/div[2]/div[3]/div/input ")).sendKeys("100");
				Thread.sleep(2000);		
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[2]/div/input ")).sendKeys("100");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/div[2]/div[3]/div/input ")).sendKeys("10");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input ")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[2]/div/input ")).sendKeys("500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[3]/div/input ")).sendKeys("10");
				Thread.sleep(10000);*/
				//ONLY RESIDUAL
			/*	int r=(n+1);
				List<WebElement> reissueR2= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissueR2.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_res']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				JavascriptExecutor jse6 = (JavascriptExecutor) driver;
				jse6.executeScript("window.scrollBy(0,400)", "");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+r+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='"+r+"']/div[2]/div[2]/div/input ")).sendKeys("1500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/div[2]/div[3]/div/input ")).sendKeys("10");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input ")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[2]/div/input ")).sendKeys("500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[3]/div/input ")).sendKeys("10");
				Thread.sleep(10000);*/
				
			//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//REFUND
			/*	JavascriptExecutor jse6 = (JavascriptExecutor) driver;
				jse6.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(5000);
				List<WebElement> Refund =driver.findElements(By.xpath("(//*[@title='Add Refund'])"));
				 Refund.get(0).click();
				Alert alertR =driver.switchTo().alert();
				alertR.accept();
				Thread.sleep(1000);
				Alert alertR1 =driver.switchTo().alert();
				alertR1.accept();
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement>  Refundref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				 Refundref.get(1).sendKeys(random);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='form-control cancellationpenalty'] ")).sendKeys("100");
				List<WebElement>  RefundM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				RefundM2.get(1).sendKeys("20");
				List<WebElement>  RefundD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				RefundD.get(1).sendKeys("10");
				Thread.sleep(10000);*/
				
				//FULL RECEIPT
		/*WebElement NEWPAY=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
			JavascriptExecutor newpay=(JavascriptExecutor)driver;
			newpay.executeScript("arguments[0].click();",NEWPAY);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.linkText("Click here to generate receipt..")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
				Select MOPCASH=new Select(MOP);
				MOPCASH.selectByIndex(1);
				Thread.sleep(2000);
				WebElement ap=driver.findElement(By.xpath("(//*[@name='appliedamount[0][]'])"));
				Actions ap2=new Actions(driver);
				ap2.doubleClick(ap).build().perform();
			    Thread.sleep(2000);
				driver.findElement(By.xpath("(//*[@name='appliedamount[0][]'])")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				Thread.sleep(2000);
				JavascriptExecutor jse2 = (JavascriptExecutor) driver;
				jse2.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(2000);
				/*WebElement receiveamt=driver.findElement(By.xpath("//*[@class='form-control receiveamt']"));
				JavascriptExecutor receiptsave4=(JavascriptExecutor)driver;
				 receiptsave4.executeScript("arguments[0].click();",receiveamt);*/
				/*driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();*/
				/*try {
				driver.findElement(By.xpath("//*[@name='receiveamt[12][]']")).click();
				Thread.sleep(2000);
				}
				catch(Exception a) {
					driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();	
					Thread.sleep(2000);
				}*/
				//WebElement Receive=driver.findElement(By.xpath("//*[@name='receiveamt[12][]']"));
			//	JavascriptExecutor Receive1=(JavascriptExecutor)driver;
				// Receive1.executeScript("arguments[0].click();",Receive);
			//	Thread.sleep(2000);
			/*	WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
				JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
				 receiptsave.executeScript("arguments[0].click();",Receptsave);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
				driver.findElement(By.xpath("(//*[@name='submitPay'])[2]")).click();
				Thread.sleep(6000);
				Alert alert2 =driver.switchTo().alert();
				alert2.accept();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				Thread.sleep(5000);
				WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
				executor.executeScript("arguments[0].click();", backbutton);
				//scrollup
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				JavascriptExecutor jse3 = (JavascriptExecutor) driver;
				jse3.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(5000);
				//VOID
				List<WebElement> Void =driver.findElements(By.xpath("(//*[@title='Add Void'])"));
				Void.get(0).click();
				Alert alertv =driver.switchTo().alert();
				alertv.accept();
				Thread.sleep(1000);
				//Alert alertv2 =driver.switchTo().alert();
			//	alertv2.accept();
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement> Voidref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				Voidref.get(1).sendKeys(random);
				Thread.sleep(2000);
				List<WebElement> VoidM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				VoidM2.get(1).sendKeys("20");
				List<WebElement> VoidD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				VoidD.get(1).sendKeys("10");
				//save&continue
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv3 =driver.switchTo().alert();
				alertv3.accept();
				Thread.sleep(10000);*/
				//PARTIAL RECEIPT
				/*driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys("500");
				driver.findElement(By.xpath("//*[@name='receiveamt[12][]']")).clear();
				driver.findElement(By.xpath("//*[@name='receiveamt[12][]']")).sendKeys("500");*/
				//RefundReceipt
				/*WebElement ap5=driver.findElement(By.xpath("//*[@name='pnrnumber']"));
				Actions ap6=new Actions(driver);
				ap6.doubleClick(ap5).build().perform();
				//driver.findElement(By.xpath("//*[@name='airlinepnroneway[]']")).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			//	Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='pnrnumber']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(4000);
				WebElement NEWPAY2=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
				JavascriptExecutor newpay2=(JavascriptExecutor)driver;
				newpay2.executeScript("arguments[0].click();",NEWPAY2);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.linkText("Click here to generate refund")).click();
				//Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@class='form-control input-sm']")).sendKeys(Keys.chord(Keys.CONTROL,"V"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='flight_passenger_ids[]']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//*[@class='btn btn-success pull-right'])")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				WebElement Rcustomer=driver.findElement(By.xpath("//*[@name='refund_customer']"));
				Select customer=new Select(Rcustomer);
				customer.selectByIndex(1);
				Thread.sleep(2000);
				WebElement Rcustomername=driver.findElement(By.xpath("//*[@name='refund_payer']"));
				Select customername=new Select(Rcustomername);
				customername.selectByIndex(1);
				Thread.sleep(2000);
				WebElement Rcustomertitle=driver.findElement(By.xpath("//*[@id='payertitle']"));
				Select customertitle=new Select(Rcustomertitle);
				customertitle.selectByIndex(2);
				Thread.sleep(2000);
				WebElement ap4=driver.findElement(By.xpath("//*[@name='appliedamount[0][]']"));
				Actions ap3=new Actions(driver);
				ap3.doubleClick(ap4).build().perform();
			    Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='appliedamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='receiveamt[0][]']")).click();
				Thread.sleep(2000);
				Thread.sleep(2000);
				WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
				JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
				 receiptsave2.executeScript("arguments[0].click();",Receptsave2);
				//driver.findElement(By.xpath("//*[@name='savePay']")).click();
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
					driver.findElement(By.xpath("//*[@class='btn btn-lightblue1 pull-right approvePay']")).click();
					Thread.sleep(6000);
					Alert alert3 =driver.switchTo().alert();
					alert3.accept();
					driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
					/*Thread.sleep(5000);
					WebElement backbutton2=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
					executor.executeScript("arguments[0].click();", backbutton2);
					//scrollup
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					JavascriptExecutor jse9 = (JavascriptExecutor) driver;
					jse9.executeScript("window.scrollBy(0,-600)", "");
					Thread.sleep(5000);*/
				}
}
				
				


				











