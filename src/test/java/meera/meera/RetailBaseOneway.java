
package meera.meera;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RetailBaseOneway {
	

	
		static int	adult=1;
		static int child=0;
		static int infant=0;
		static int n=(adult+child+infant);
			public static WebDriver driver;
			public static  WebDriverWait wait;
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

	//RETAIL ISSUE
				/*public static  void excelRead(ADULT,CHILD,INFANT,r,Adult,Child,Infant,From,To,Agent) throws Exception {
					
					File file = new File("D:\\DataFile.xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet2");
					 int rows=sheet.getLastRowNum()+1;
				String Agent=sheet.getRow(r).getCell(0).getStringCellValue();	
				
				//PAX	 
				int ADULT=(int) sheet.getRow(r).getCell(1).getNumericCellValue();
				 int CHILD=(int) sheet.getRow(r).getCell(2).getNumericCellValue();
				 int INFANT=(int) sheet.getRow(r).getCell(3).getNumericCellValue();
			    //FROM&TO
				 String From=sheet.getRow(r).getCell(4).getStringCellValue();
				 String To=sheet.getRow(r).getCell(5).getStringCellValue();
				 String Adult = String.valueOf(ADULT);
				 String Child = String.valueOf(CHILD);
				 String Infant = String.valueOf(INFANT);
				
				}*/
				public static  void retailIssue() throws InterruptedException, Exception {
					System.setProperty("webdriver.chrome.driver","D:\\Meera\\Browserdrivers\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					 //driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
			        driver.get("http://172.168.10.239/qa/srx/");
			        //driver.get("http://100.100.60.116/srx/");
					driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
					driver.findElement(By.name("sign_in_password")).sendKeys("warren");
					driver.findElement(By.xpath("//*[text()=' Sign In ']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
					driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//li[@class='active']/a")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flightsource[1]']")).sendKeys("Abu Dhabi-AE(AUH) - Abu Dhabi Intl");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@name='flightdestination[1]']")).sendKeys(" London-GB(LHR) - London Heathrow");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@name='DepartureDate[1]']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
					/*WebElement date=driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);*/
					//TO SELECT CURRENT DATE
					//driver.findElement(By.className("ui-datepicker-today")).click();
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					Thread.sleep(2000);
					WebElement w=driver.findElement(By.xpath("//*[@name='flight_adult[1]']"));
				    Select s=new Select(w);
				    s.selectByIndex(0);
				    Thread.sleep(2000);
				    s.selectByIndex(1);
				    //int	adult=1;
					WebElement N=driver.findElement(By.xpath("//*[@name='flight_child[1]']"));
					Select s1=new Select(N);
					s1.selectByIndex(0);
					//int child=0;
					WebElement M=driver.findElement(By.xpath("//*[@name='flight_infant[1]']"));
					Select s2=new Select(M);
					s2.selectByIndex(0);
					//int infant=0;
				//int n=(adult+child+infant);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
				Thread.sleep(30000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").toString().equals("complete");
				Thread.sleep(10000);
		// for scroll UP
		        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		        jse1.executeScript("window.scrollBy(0,-400)", "");
		        Thread.sleep(5000);
		        try {
			    WebElement offilineflight = driver.findElements(By.cssSelector("#offline_search_button_1")).get(1);
			    JavascriptExecutor executor = (JavascriptExecutor) driver;
			    executor.executeScript("arguments[0].click();", offilineflight);
			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        } catch (Exception o) {

			    WebElement offilineflight = driver.findElements(By.cssSelector("#offline_search_button_1")).get(0);
			    JavascriptExecutor executor = (JavascriptExecutor) driver;
			    executor.executeScript("arguments[0].click();", offilineflight);
			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        }
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
				
				//adding atachments
				driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div/div[5]/div/div[1]/input")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
				/*StringSelection ss=new StringSelection("Desert.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				*/
				
				
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
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span")).click();
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
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
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("James");
				Thread.sleep(2000);
				}
				catch(Exception e3)
				{
					driver.findElement(By.xpath("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys("James");
					Thread.sleep(2000);
				}
				}
				else {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys("anthony");
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
					Thread.sleep(6000);
					WebElement e1l = driver.findElement(By.cssSelector(".travel-user-chk"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
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
					driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
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
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[4]/div/span/span[1]/span")).click();
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
				String[] STRING_ARRAY = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(6000);
				//WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
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
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@id='"+a+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]")).click();
				//driver.findElement(By.xpath(".//*[@id='"+a+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				System.out.println("done1");
				String[] STRING_ARRAY1 = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
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
				//CHILD ticket issue
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
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+adult).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				/*WebElement search=driver.findElement(By.xpath("//*[@name='SearchEmail']"));
		        Actions a = new Actions(driver);
		        a.doubleClick(search).build().perform();*/
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(000);
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				//*[@class='travel-user-chk other-customer-checkbox same-customer-checkbox']
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
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C1+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				//driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child1=driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor11 = (JavascriptExecutor)driver;
				executor11.executeScript("arguments[0].click();",child1);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
						
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(10000);
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
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C2+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child2=driver.findElement(By.xpath(".//*[@id='"+C2+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor12 = (JavascriptExecutor)driver;
				executor12.executeScript("arguments[0].click();",child2);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
				//INFANT ticket issue
				if(adult>=1) {
					for(int d=0;d<(infant);d++) {
						List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
					copyticket.get(0).click();
					Thread.sleep(3000);
					}
					for(int i=0;i<(infant);i++) {
						int I=(adult+child+i);
						String[] STRING_ARRAY = {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
						Thread.sleep(3000);
						List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
						passenger.get(i+adult+child).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
						driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
						Thread.sleep(6000);
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
						driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='"+I+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
						/*WebElement infant1=driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();",infant1);*/
						Thread.sleep(2000);
						String[] STRING_ARRAY1 =  {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
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
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(15000);
				//Recording PNR
				JavascriptExecutor up=(JavascriptExecutor)driver;
				up.executeScript("window.scrollBy(0,-600);","");
				Thread.sleep(2000);
				String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
				 File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet1");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 Row row=sheet.getRow(1);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(8);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 
				 cell.setCellValue(PNR);
				 //PNRSTATUS
				 org.apache.poi.ss.usermodel.Cell cell2=row.createCell(9);
				 cell2.setCellType(Cell.CELL_TYPE_STRING);
				 cell2.setCellValue("ISSUED");
				 FileOutputStream fo=new FileOutputStream("D:\\AutomationFiles\\DataFile.xlsx");
				 wb.write(fo);
				 
				 
				}
				public static void status(int r) throws Exception{
					File file = new File("D:\\DataFile.xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet2");
					 int rows=sheet.getLastRowNum()+1;
					 float actual=  (float) sheet.getRow(r).getCell(8).getNumericCellValue();
					 System.out.println(actual);
					 float expected=   (float) sheet.getRow(r).getCell(9).getNumericCellValue();
					 System.out.println(expected);
					 System.out.println(rows);
					 if(actual==expected){
					 Row row=sheet.getRow(r);
					 org.apache.poi.ss.usermodel.Cell cell=row.createCell(10);
					 cell.setCellType(Cell.CELL_TYPE_STRING);
					 cell.setCellValue("PASS");
					 //TEXT STYLE
					    Font headerFont = wb.createFont();
					    headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
					    CellStyle headerStyle = wb.createCellStyle();
					    headerStyle.setFont(headerFont);
					    headerStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					    headerFont.setColor(IndexedColors.WHITE.getIndex());
					    headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					    cell.setCellStyle(headerStyle);
					 // -----------------------------------------
					 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
					 wb.write(fo);	
					 }
					 else {
						 
						 Row row=sheet.getRow(r);
						 org.apache.poi.ss.usermodel.Cell cell=row.createCell(10);
						 cell.setCellType(Cell.CELL_TYPE_STRING);
						 cell.setCellValue("FAIL");
						//TEXT STYLE
						    Font headerFont = wb.createFont();
						    headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
						    CellStyle headerStyle = wb.createCellStyle();
						    headerStyle.setFont(headerFont);
						    headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
						    headerFont.setColor(IndexedColors.WHITE.getIndex());
						    headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
						    cell.setCellStyle(headerStyle);
						 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
						 wb.write(fo);		 
						 
						 
						 
					 }
				}
				
				public static float expectedZvalue1(int r) throws Exception{
					switch(r) {
					case 1:
						String Total=driver.findElement(By.xpath("//*[@class='form-control lineTotalclass']")).getAttribute("value");
						System.out.println(Total);
						String voidrefund=driver.findElement(By.xpath("(//*[@class='form-control lineTotalclass'])[2]")).getAttribute("value");
						System.out.println(voidrefund);
						float zvalue1 = Float.parseFloat(Total) - Float.parseFloat(voidrefund);
						System.out.println(zvalue1);
						return zvalue1;
						
					case 2:
						String Total1=driver.findElement(By.xpath("//*[@class='form-control lineTotalclass']")).getAttribute("value");
						String voidrefund1=driver.findElement(By.xpath("(//*[@class='form-control lineTotalclass'])[2]")).getAttribute("value");
						float zvalue2 = Float.parseFloat(Total1) - Float.parseFloat(voidrefund1);
						return zvalue2;
					case 3:
						String refundedOTA=driver.findElement(By.xpath("//*[@class='form-control otacharges']")).getAttribute("value");
						String Ticketamount=driver.findElement(By.xpath("//*[@class='form-control ticketAmountClass']")).getAttribute("value");
						String Markup=driver.findElement(By.xpath("(//*[@class='form-control markupclass'])[2]")).getAttribute("value");
						String ExtraMarkup=driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).getAttribute("value");
						String Discount=driver.findElement(By.xpath("(//*[@class='form-control discountclass'])[2]")).getAttribute("value");
						float zvalue3 = Float.parseFloat(refundedOTA) + Float.parseFloat(Ticketamount)- Float.parseFloat(Markup)- Float.parseFloat(ExtraMarkup)+ Float.parseFloat(Discount);
						System.out.println(zvalue3);
						return zvalue3;
					case 4:
						String refundedOTA4=driver.findElement(By.xpath("//*[@class='form-control otacharges']")).getAttribute("value");
						String Basefare=driver.findElement(By.xpath("(//*[@class='form-control basePclass'])[2]")).getAttribute("value");
						String Markup4=driver.findElement(By.xpath("(//*[@class='form-control markupclass'])[2]")).getAttribute("value");
						String ExtraMarkup4=driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).getAttribute("value");
						String Discount4=driver.findElement(By.xpath("(//*[@class='form-control discountclass'])[2]")).getAttribute("value");
						String cp=driver.findElement(By.xpath("//*[@class='form-control cancellationpenalty']")).getAttribute("value");
						float zvalue4 = Float.parseFloat(refundedOTA4) + Float.parseFloat(Basefare)- Float.parseFloat(Markup4)- Float.parseFloat(ExtraMarkup4)+ Float.parseFloat(Discount4)-Float.parseFloat(cp);
						return zvalue4;
					case 5:
						
					case 6:
						
					case 7:
						
					case 8:
						
					case 9:
						
					}
					return r;    
				    }
				public static void expectedZvalue(int r) throws Exception{
					File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet2");
					 int rows=sheet.getLastRowNum()+1;
					 System.out.println(rows);
					 Row row=sheet.getRow(r);
					 org.apache.poi.ss.usermodel.Cell cell=row.createCell(9);
					 cell.setCellType(Cell.CELL_TYPE_STRING);
					 float zvalue=expectedZvalue1(r);
					 cell.setCellValue(zvalue);
					 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
					 wb.write(fo);	 
				}
				public static void actualZvalue(int r) throws Exception{
				driver.findElement(By.xpath("//*[@id=\"0\"]/div[5]/div[5]/div/div/a/i")).click();
				Thread.sleep(2000);
				String zvalue=driver.findElement(By.xpath("//*[@class='form-control zValue']")).getAttribute("value");
				float actual=Float.parseFloat(zvalue);
				File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet2");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 Row row=sheet.getRow(r);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(8);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 cell.setCellValue(actual);
				 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
				 wb.write(fo);
				
				/*JavascriptExecutor up=(JavascriptExecutor)driver;
				up.executeScript("window.scrollBy(0,-600);","");
				Thread.sleep(2000);
				String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
				File file = new File("D:\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet2");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(PNR);
				 Row row=sheet.getRow(1);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(7);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 cell.setCellValue(PNR);
				 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
				 wb.write(fo);*/
				}
				
				//RETAIL ISSUE WITH EXCEL
			/*public	static int ADULT;
			public	static int CHILD;
			public static	int INFANT;
			public static	String Adult;
			public static	String Child;
			public	static String Infant;*/
				public static void recordPnrReceiptMultiple(int r) throws Exception {
				    //Recording PNR
					JavascriptExecutor up=(JavascriptExecutor)driver;
					up.executeScript("window.scrollBy(0,-600);","");
					Thread.sleep(2000);
					String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
					File file = new File("D:\\AutomationFiles\\Receipt Scenarios For automation .xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet1");
					 int rows=sheet.getLastRowNum()+1;
					 System.out.println(rows);
					 Row row=sheet.getRow(r);
					 org.apache.poi.ss.usermodel.Cell cell=row.createCell(5);
					 cell.setCellType(Cell.CELL_TYPE_STRING);
					 cell.setCellValue(PNR);
					 FileOutputStream fo=new FileOutputStream("D:\\AutomationFiles\\Receipt Scenarios For automation .xlsx");
					 wb.write(fo);
					}
				 public static void recordPnrReceiptSingle(int r) throws Exception {
				    //Recording PNR
					JavascriptExecutor up=(JavascriptExecutor)driver;
					up.executeScript("window.scrollBy(0,-600);","");
					Thread.sleep(2000);
					String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
					File file = new File("D:\\AutomationFilesD:\\Receipt Scenarios For automation .xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet1");
					 int rows=sheet.getLastRowNum()+1;
					 System.out.println(rows);
					 Row row=sheet.getRow(r);
					 org.apache.poi.ss.usermodel.Cell cell=row.createCell(4);
					 cell.setCellType(Cell.CELL_TYPE_STRING);
					 cell.setCellValue(PNR);
					 FileOutputStream fo=new FileOutputStream("D:\\AutomationFiles\\Receipt Scenarios For automation .xlsx");
					 wb.write(fo);
					}
				public static void recordPnr(int r) throws Exception {
			    //Recording PNR
				JavascriptExecutor up=(JavascriptExecutor)driver;
				up.executeScript("window.scrollBy(0,-600);","");
				Thread.sleep(2000);
				String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
				File file = new File("D:\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet2");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 Row row=sheet.getRow(r);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(7);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 cell.setCellValue(PNR);
				 FileOutputStream fo=new FileOutputStream("D:\\DataFile.xlsx");
				 wb.write(fo);
				}
				public static void bookingReports(int u) throws InterruptedException, IOException {
					System.setProperty("webdriver.chrome.driver","D:\\Meera\\chromedriver_win32 (5)\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/booking/getflightreport#!");
					driver.get("http://172.168.10.239/qa/srx/booking/getflightreport#!");
					//driver.get("http://100.100.60.116:8090/srx/booking/getflightreport#!");
					String[] STRING_ARRAY = {"Albert","Abdhul","Edison","Lincon"};
					driver.findElement(By.name("sign_in_username_email")).sendKeys(STRING_ARRAY[u]);
					driver.findElement(By.name("sign_in_password")).sendKeys(STRING_ARRAY[u]);
					driver.findElement(By.xpath("//*[text()='Sign In']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					String pnr=readPNR( );
					driver.findElement(By.xpath("//*[@name='gdspnr']")).sendKeys(pnr);
					driver.findElement(By.xpath("//*[@class='btn btn-lightblue btn-search']")).click();
					Thread.sleep(5000);
					driver.findElement(By.linkText(pnr)).click();
					Thread.sleep(5000);
					/*WebElement horizantal=driver.findElement(By.xpath("//*[@id=\\\"example\\\"]/tbody/tr/td[29]/a"));
					JavascriptExecutor off=(JavascriptExecutor)driver;
					off.executeScript("arhuments[0].scrollIntoView();", horizantal);
					Actions action=new Actions(driver);
					action.dragAndDropBy(horizantal,1000,0).build().perform();*/
					/*JavascriptExecutor off=(JavascriptExecutor)driver;
					off.executpeScript("window.scrollBy(10000,0);", "");*/
					//driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr/td[29]/a")).click();
					}
				public static String readPNR( ) throws IOException {
					//Excel data reading
					File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
					 FileInputStream fio=new FileInputStream(file);
					 XSSFWorkbook wb= new XSSFWorkbook(fio);
					 XSSFSheet sheet=wb.getSheet("Sheet1");
					String pnr1=sheet.getRow(1).getCell(8).getStringCellValue();
					return pnr1;
				}
		
				public static  void retailIssueExcel(int ADULT,int CHILD,int INFANT,int r,String Adult,String Child,String Infant,String From,String To,String Agent) throws InterruptedException, BiffException, IOException {
					
					System.setProperty("webdriver.chrome.driver","D:\\Meera\\chromedriver_win32 (5)\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					int n=(ADULT+CHILD+INFANT);
					/*//Excel data reading
					File file = new File("D:\\CCC.xls");s
					 FileInputStream fio=new FileInputStream(file);
					 Workbook wb=Workbook.getWorkbook(fio);
					 Sheet sheet=wb.getSheet("Sheet1");
					 int rows=sheet.getRows();
					 for(int r=1;r<rows;r++) {
						 String Adult=sheet.getCell(0,r).getContents();
						 System.out.println(Adult);
						 String Child=sheet.getCell(1,r).getContents();
						 System.out.println(Child);
						 String Infant=sheet.getCell(2,r).getContents();
						 System.out.println(Infant);
						int ADULT = Integer.parseInt(Adult);
						int CHILD = Integer.parseInt(Child);
						int INFANT = Integer.parseInt(Infant);*/
					//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
			        //driver.get("http://172.168.10.239/qa/srx/");
					driver.get("http://100.100.60.116/srx/");
					driver.findElement(By.name("sign_in_username_email")).sendKeys(Agent);
					driver.findElement(By.name("sign_in_password")).sendKeys(Agent);
					driver.findElement(By.xpath("//*[text()='Sign In']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
					driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//li[@class='active']/a")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flightsource[1]']")).sendKeys(From);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@name='flightdestination[1]']")).sendKeys(To);
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@name='DepartureDate[1]']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
					/*WebElement date=driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);*/
					//TO SELECT CURRENT DATE
					//driver.findElement(By.className("ui-datepicker-today")).click();
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					WebElement date=driver.findElement(By.xpath("//*[@name='flight_adult[1]']"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);
					//driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).sendKeys("0");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).sendKeys(Adult);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_child[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_child[1]']")).sendKeys(Child);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_infant[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_infant[1]']")).sendKeys(Infant);
					Thread.sleep(2000);

					/*WebElement w=driver.findElement(By.xpath("//*[@name='flight_adult[1]']"));
				    Select s=new Select(w);
				s.selectByIndex(1);
				//int	adult=1;
			
					WebElement N=driver.findElement(By.xpath("//*[@name='flight_child[1]']"));
					Select s1=new Select(N);
					s1.selectByIndex(1);
					//int child=0;
					WebElement M=driver.findElement(By.xpath("//*[@name='flight_infant[1]']"));
					Select s2=new Select(M);
					s2.selectByIndex(1);
					//int infant=0;
				//int n=(adult+child+infant);
				Thread.sleep(2000);*/
				driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
				
				Thread.sleep(30000);
				
				//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				//Reload
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").toString().equals("complete");
				Thread.sleep(10000);

				//
				
				/*new WebDriverWait(driver, 50).until(
			    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));*/
				//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				/*WebDriverWait save=new WebDriverWait(driver,40);
				save.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='offline_search_button_1'])[2]")));*/
				//save.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((//*[@name='offline_search_button_1'])[2]);
				
				//for scroll Up
				
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,-400)", "");
				Thread.sleep(5000);
				try {
			WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(1);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", offilineflight);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				}
				catch(Exception o) {
					
						WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(0);
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", offilineflight);
						driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
					
				}
				
				
			System.out.println("Offiline flight link tested successfully");
			ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(wind.get(1));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
				/*Set<String> s11=driver.getWindowHandles();
				Object popup[]=s11.toArray();
				driver.switchTo().window(popup[1].toString());
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
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
				
				
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span")).click();
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				if(ADULT>=1) {
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
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("James");
				Thread.sleep(2000);
				}
				catch(Exception e3)
				{
					driver.findElement(By.xpath("body > span > span > span.select2-search.select2-search--dropdown > input")).sendKeys("James");
					Thread.sleep(2000);
				}
				}
				else {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys("anthony");
					driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
					Thread.sleep(6000);
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					/*wait=new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));
					*/
					//WebElement e1l = driver.findElement(By.xpath("//*[@id=\"addPassengersModal\"]/div/div/div[2]/div[2]/div[2]/div[3]/div/div/table/tbody/tr[3]/td[1]/input[1]"));
					WebElement e1l = driver.findElement(By.cssSelector(".travel-user-chk"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(5000);
					try {
						Alert alert =driver.switchTo().alert();
						alert.accept();
						Thread.sleep(5000);
						}
						catch(Exception Alert) {
							System.out.println("Alert.getMessage()");
							Thread.sleep(2000);
						}
					driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					try {
						driver.findElement(By.xpath("//*[@title='ADULT']")).click();
						Thread.sleep(2000);	
					}
					catch(Exception Catch) {
						driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[3]/div/div[1]/div/span/span[1]/span/span[2]")).click();
						Thread.sleep(2000);
					}
					
					//driver.findElement(By.xpath("//*[@title='ADULT']")).click();
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("anthony");
				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[4]/div/span/span[1]/span")).click();
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Fly");
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//*[@class='form-control basePclass']")).sendKeys("2000.678");
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
				for(int c=0;c<(ADULT-1);c++) {
					List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
				copyticket.get(0).click();
				Thread.sleep(3000);
				}
				for(int i=0;i<(ADULT-1);i++) {
				int	a=i+1;
				String[] STRING_ARRAY = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(6000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				try {
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				}
				catch(Exception Alert) {
					System.out.println("Alert.getMessage()");
					Thread.sleep(2000);
				}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@id='"+a+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]")).click();
				System.out.println("done1");
				String[] STRING_ARRAY1 = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
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
				//CHILD ticket issue
				 int x;
				if(ADULT>=1) {
					x=CHILD;
				}
				else {
					 x=(CHILD-1);
				}
				for(int c=0;c<(x);c++) {
					List<WebElement> copyticketchild = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));
				copyticketchild.get(0).click();
				Thread.sleep(3000);
				}
				int c=CHILD;
				if(ADULT>=1) {
				for(int i=0;i<(c);i++) {
					int C1=(ADULT+i);
				Thread.sleep(3000);
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+ADULT).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(10000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()",e1l1);
				Thread.sleep(5000);
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception Alert) {
						System.out.println("Alert.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C1+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child1=driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor11 = (JavascriptExecutor)driver;
				executor11.executeScript("arguments[0].click();",child1);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
				tickets.get(i+ADULT).clear();
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				tickets.get(i+ADULT).sendKeys(random);
				Thread.sleep(3000);
				}
				}
				else { 
					for(int i=0;i<(CHILD-1);i++) {
						int C2=(1+i);
						
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(10000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception Alert) {
						System.out.println("Alert.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C2+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child2=driver.findElement(By.xpath(".//*[@id='"+C2+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor12 = (JavascriptExecutor)driver;
				executor12.executeScript("arguments[0].click();",child2);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
				//INFANT ticket issue
				if(ADULT>=1) {
					for(int d=0;d<(INFANT);d++) {
						List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
					copyticket.get(0).click();
					Thread.sleep(3000);
					}
					for(int i=0;i<(INFANT);i++) {
						int J=(ADULT+CHILD+i);
						String[] STRING_ARRAY = {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
						Thread.sleep(3000);
						List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
						passenger.get(i+ADULT+CHILD).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
						//Thread.sleep(8000);
						driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
						Thread.sleep(10000);
						/*wait=new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
						WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
						JavascriptExecutor check1 = (JavascriptExecutor) driver;
						check1.executeScript("arguments[0].click()", e1l1);
						Thread.sleep(5000);
						try {
							Alert alert =driver.switchTo().alert();
							alert.accept();
							Thread.sleep(5000);
							}
							catch(Exception Alert) {
								System.out.println("Alert.getMessage()");
								Thread.sleep(2000);
							}
						driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='"+J+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
						/*WebElement infant1=driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();",infant1);*/
						Thread.sleep(2000);
						String[] STRING_ARRAY1 =  {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]);
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
						List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
						tickets.get(i+ADULT+CHILD).clear();
						Thread.sleep(2000);
						random =generateRandomString();
						Thread.sleep(2000);
						tickets.get(i+ADULT+CHILD).sendKeys(random);
						Thread.sleep(3000);
						}
					
				}
				driver.findElement(By.xpath("//*[@class='btn btn-lightblue addPrice']")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(15000);
				//Recording PNR
				JavascriptExecutor up=(JavascriptExecutor)driver;
				up.executeScript("window.scrollBy(0,-600);","");
				Thread.sleep(2000);
				String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
				 File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet2");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 Row row=sheet.getRow(r);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(6);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 
				 cell.setCellValue(PNR);
				 /*//PNRSTATUS
				 org.apache.poi.ss.usermodel.Cell cell2=row.createCell(7);
				 cell2.setCellType(Cell.CELL_TYPE_STRING);
				 cell2.setCellValue("ISSUED");*/
				/* //To create new cell
				 Row row2=sheet.createRow(rows+1);
				 org.apache.poi.ss.usermodel.Cell cell21=row2.createCell(3);
				 cell21.setCellType(cell.CELL_TYPE_STRING);
				 
				 cell21.setCellValue(PNR);*/
				 FileOutputStream fo=new FileOutputStream("D:\\AutomationFiles\\DataFile.xlsx");
				 wb.write(fo);
				}
                public static  void corporatelIssueExcel(int ADULT,int CHILD,int INFANT,int r,String Adult,String Child,String Infant,String From,String To,String Agent) throws InterruptedException, BiffException, IOException {
					System.setProperty("webdriver.chrome.driver","D:\\Meera\\Browserdrivers\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					Thread.sleep(3000);
					int n=(ADULT+CHILD+INFANT);
					/*//Excel data reading
					File file = new File("D:\\CCC.xls");
					 FileInputStream fio=new FileInputStream(file);
					 Workbook wb=Workbook.getWorkbook(fio);
					 Sheet sheet=wb.getSheet("Sheet1");
					 int rows=sheet.getRows();
					 for(int r=1;r<rows;r++) {
						 String Adult=sheet.getCell(0,r).getContents();
						 System.out.println(Adult);
						 String Child=sheet.getCell(1,r).getContents();
						 System.out.println(Child);
						 String Infant=sheet.getCell(2,r).getContents();
						 System.out.println(Infant);
						int ADULT = Integer.parseInt(Adult);
						int CHILD = Integer.parseInt(Child);
						int INFANT = Integer.parseInt(Infant);*/
					//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
			        driver.get("http://172.168.10.239/qa/srx/");
					//driver.get("http://100.100.60.116/srx/");
					driver.findElement(By.name("sign_in_username_email")).sendKeys(Agent);
					driver.findElement(By.name("sign_in_password")).sendKeys(Agent);
					driver.findElement(By.xpath("//*[text()='Sign In']")).click();
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					//Cotportae Request
					driver.findElement(By.xpath("//*[@title='Corporate Request']")).click();
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
					driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//li[@class='active']/a")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flightsource[1]']")).sendKeys(From);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@name='flightdestination[1]']")).sendKeys(To);
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@name='DepartureDate[1]']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]")).click();
					/*WebElement date=driver.findElement(By.xpath("(//a[contains(text(),'15')])[3]"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);*/
					//TO SELECT CURRENT DATE
					//driver.findElement(By.className("ui-datepicker-today")).click();
					//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					WebElement date=driver.findElement(By.xpath("//*[@name='flight_adult[1]']"));
					JavascriptExecutor executordate = (JavascriptExecutor)driver;
					executordate.executeScript("arguments[0].click();", date);
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).sendKeys("0");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_adult[1]']")).sendKeys(Adult);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_child[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_child[1]']")).sendKeys(Child);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@name='flight_infant[1]']")).click();
					driver.findElement(By.xpath("//*[@name='flight_infant[1]']")).sendKeys(Infant);
					Thread.sleep(2000);
				    driver.findElement(By.xpath("//*[@name='save_button_1']")).click();
                    Thread.sleep(30000);
				    JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("return document.readyState").toString().equals("complete");
				    Thread.sleep(10000);
				   //for scroll Up
				    JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				    jse1.executeScript("window.scrollBy(0,-400)", "");
				    Thread.sleep(5000);
				    try {
			        WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(1);
			        JavascriptExecutor executor = (JavascriptExecutor)driver;
			        executor.executeScript("arguments[0].click();", offilineflight);
			        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				    }
				    catch(Exception o) {
					
					WebElement offilineflight=driver.findElements(By.cssSelector("#offline_search_button_1")).get(0);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", offilineflight);
					driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
				    }
			    System.out.println("Offiline flight link tested successfully");
			    ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(wind.get(1));
			    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
				/*Set<String> s11=driver.getWindowHandles();
				Object popup[]=s11.toArray();
				driver.switchTo().window(popup[1].toString());
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
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
				
				
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span")).click();
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys("S1");
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				if(ADULT>=1) {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys("Albert");
					driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
					Thread.sleep(6000);
					WebElement e1l = driver.findElement(By.cssSelector(".travel-user-chk"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(5000);
					try {
						Alert alert =driver.switchTo().alert();
						alert.accept();
						Thread.sleep(5000);
						}
						catch(Exception Alert) {
							System.out.println("Alert.getMessage()");
							Thread.sleep(2000);
						}
					driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					try {
						driver.findElement(By.xpath("//*[@title='ADULT']")).click();
						Thread.sleep(2000);	
					}
					catch(Exception Catch) {
						driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[3]/div/div[1]/div/span/span[1]/span/span[2]")).click();
						Thread.sleep(2000);
					}
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Albert");
				}
				else {
					driver.findElement(By.xpath("//*[@title='Add Passengers']")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys("anthony");
					driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
					Thread.sleep(6000);
					WebElement e1l = driver.findElement(By.cssSelector(".travel-user-chk"));
					JavascriptExecutor check = (JavascriptExecutor) driver;
					check.executeScript("arguments[0].click()", e1l);
					Thread.sleep(5000);
					try {
						Alert alert =driver.switchTo().alert();
						alert.accept();
						Thread.sleep(5000);
						}
						catch(Exception Alert) {
							System.out.println("Alert.getMessage()");
							Thread.sleep(2000);
						}
					driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					try {
						driver.findElement(By.xpath("//*[@title='ADULT']")).click();
						Thread.sleep(2000);	
					}
					catch(Exception Catch) {
						driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[3]/div/div[1]/div/span/span[1]/span/span[2]")).click();
						Thread.sleep(2000);
					}
					
					//driver.findElement(By.xpath("//*[@title='ADULT']")).click();
					driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("anthony");
				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"0\"]/table/tbody/tr/td[4]/div/span/span[1]/span")).click();
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Fly");
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//*[@class='form-control basePclass']")).sendKeys("2000.678");
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
				for(int c=0;c<(ADULT-1);c++) {
					List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
				copyticket.get(0).click();
				Thread.sleep(3000);
				}
				for(int i=0;i<(ADULT-1);i++) {
				int	a=i+1;
				String[] STRING_ARRAY = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(6000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				try {
				Alert alert =driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
				}
				catch(Exception Alert) {
					System.out.println("Alert.getMessage()");
					Thread.sleep(2000);
				}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@id='"+a+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]")).click();
				System.out.println("done1");
				String[] STRING_ARRAY1 = {"Jhonny","Britlee","Jacob","Oliverr","Ranny","Noah","Narry"};
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
				//CHILD ticket issue
				 int x;
				if(ADULT>=1) {
					x=CHILD;
				}
				else {
					 x=(CHILD-1);
				}
				for(int c=0;c<(x);c++) {
					List<WebElement> copyticketchild = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));
				copyticketchild.get(0).click();
				Thread.sleep(3000);
				}
				int c=CHILD;
				if(ADULT>=1) {
				for(int i=0;i<(c);i++) {
					int C1=(ADULT+i);
				Thread.sleep(3000);
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+ADULT).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(10000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()",e1l1);
				Thread.sleep(5000);
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception Alert) {
						System.out.println("Alert.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C1+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child1=driver.findElement(By.xpath(".//*[@id='"+C1+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor11 = (JavascriptExecutor)driver;
				executor11.executeScript("arguments[0].click();",child1);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
				List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
				tickets.get(i+ADULT).clear();
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				tickets.get(i+ADULT).sendKeys(random);
				Thread.sleep(3000);
				}
				}
				else { 
					for(int i=0;i<(CHILD-1);i++) {
						int C2=(1+i);
						
				String[] STRING_ARRAY = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+1).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
				//Thread.sleep(8000);
				driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
				Thread.sleep(10000);
				/*wait=new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
				WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
				JavascriptExecutor check1 = (JavascriptExecutor) driver;
				check1.executeScript("arguments[0].click()", e1l1);
				Thread.sleep(5000);
				try {
					Alert alert =driver.switchTo().alert();
					alert.accept();
					Thread.sleep(5000);
					}
					catch(Exception Alert) {
						System.out.println("Alert.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+C2+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement child2=driver.findElement(By.xpath(".//*[@id='"+C2+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor12 = (JavascriptExecutor)driver;
				executor12.executeScript("arguments[0].click();",child2);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 = {"Adia","Bency","Cady","Eliza","Emmy","Erica"};
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
				//INFANT ticket issue
				if(ADULT>=1) {
					for(int d=0;d<(INFANT);d++) {
						List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
					copyticket.get(0).click();
					Thread.sleep(3000);
					}
					for(int i=0;i<(INFANT);i++) {
						int J=(ADULT+CHILD+i);
						String[] STRING_ARRAY = {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
						Thread.sleep(3000);
						List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
						passenger.get(i+ADULT+CHILD).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@name='SearchFName']")).sendKeys(STRING_ARRAY[i]);
						//Thread.sleep(8000);
						driver.findElement(By.xpath("//*[@name='SearchEmail']")).click();
						Thread.sleep(10000);
						/*wait=new WebDriverWait(driver,30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='travel-user-chk other-customer-checkbox '])[1]")));*/
						WebElement e1l1 = driver.findElement(By.cssSelector(".travel-user-chk"));
						JavascriptExecutor check1 = (JavascriptExecutor) driver;
						check1.executeScript("arguments[0].click()", e1l1);
						Thread.sleep(5000);
						try {
							Alert alert =driver.switchTo().alert();
							alert.accept();
							Thread.sleep(5000);
							}
							catch(Exception Alert) {
								System.out.println("Alert.getMessage()");
								Thread.sleep(2000);
							}
						driver.findElement(By.xpath("(//*[@title='close'])[4]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='"+J+"']/table/tbody/tr/td[3]/table/tbody/tr/td[1]/div/div/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
						/*WebElement infant1=driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();",infant1);*/
						Thread.sleep(2000);
						String[] STRING_ARRAY1 =  {"Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(STRING_ARRAY1[i]);
						Thread.sleep(5000);
						driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
						List<WebElement> tickets = driver.findElements(By.cssSelector(".form-control.ticketClass"));	
						tickets.get(i+ADULT+CHILD).clear();
						Thread.sleep(2000);
						random =generateRandomString();
						Thread.sleep(2000);
						tickets.get(i+ADULT+CHILD).sendKeys(random);
						Thread.sleep(3000);
						}
					
				}
				driver.findElement(By.xpath("//*[@class='btn btn-lightblue addPrice']")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Alert alert =driver.switchTo().alert();
				alert.accept();
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(15000);
				//Recording PNR
				JavascriptExecutor up=(JavascriptExecutor)driver;
				up.executeScript("window.scrollBy(0,-600);","");
				Thread.sleep(2000);
				String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
				File file = new File("D:\\AutomationFiles\\DataFile.xlsx");
				 FileInputStream fio=new FileInputStream(file);
				 XSSFWorkbook wb= new XSSFWorkbook(fio);
				 XSSFSheet sheet=wb.getSheet("Sheet2");
				 int rows=sheet.getLastRowNum()+1;
				 System.out.println(rows);
				 Row row=sheet.getRow(r);
				 org.apache.poi.ss.usermodel.Cell cell=row.createCell(7);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 
				 cell.setCellValue(PNR);
				 //PNRSTATUS
				 /*org.apache.poi.ss.usermodel.Cell cell2=row.createCell(7);
				 cell2.setCellType(Cell.CELL_TYPE_STRING);
				 cell2.setCellValue("ISSUED");*/
				/* //To create new cell
				 Row row2=sheet.createRow(rows+1);
				 org.apache.poi.ss.usermodel.Cell cell21=row2.createCell(3);
				 cell21.setCellType(cell.CELL_TYPE_STRING);
				 
				 cell21.setCellValue(PNR);*/
				 FileOutputStream fo=new FileOutputStream("D:\\AutomationFiles\\DataFile.xlsx");
				 wb.write(fo);
				}
				
				//REISSUE ADD
				public  static void reissueAdd() throws InterruptedException {
					
					//int n=(ADULT+CHILD+INFANT);
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
				int P=(n+1);
				List<WebElement> reissue= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissue.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_pen']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//*[@id='"+P+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+P+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul")).click();
				driver.findElement(By.xpath("//*[@id='"+P+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/table/tbody/tr/td[4]/table/tbody/tr/td[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='"+P+"']/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/input")).sendKeys("4000");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+P+"']/table/tbody/tr/td[4]/table/tbody/tr/td[3]/div/input ")).sendKeys("100");
				Thread.sleep(1000);
			   driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).clear();
			   Thread.sleep(1000);
               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).sendKeys("100");
               Thread.sleep(1000);
               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).clear();
               Thread.sleep(1000);
               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).sendKeys("50");
			   Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/input")).sendKeys("400");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[3]/div/input")).sendKeys("100");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).sendKeys("50");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).sendKeys("20");
				   Thread.sleep(2000);
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(15000);
				}		
				//REISSUE RESIDUAL&PENALTY
				public static void reissueResandPenalty(/*int ADULT,int CHILD,int INFANT*/) throws InterruptedException {
					/*int n=(ADULT+CHILD+INFANT);*/
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
				int R=(n+2);
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
				Thread.sleep(1000);	
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).sendKeys("100");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).sendKeys("50");
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
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).sendKeys("50");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).sendKeys("30");
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
				driver.findElement(By.xpath("//*[@id='"+n+"']/div[2]/div[3]/div/input ")).sendKeys("50");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[4]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[4]")).sendKeys("50");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[4]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[4]")).sendKeys("30");
				   Thread.sleep(2000);
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(15000);
			//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				}
				//ONLY RESIDUAL
				public static void reissueRes(/*int ADULT,int CHILD,int INFANT*/) throws InterruptedException {
					//int n=(ADULT+CHILD+INFANT);
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
				int r=(n+1);
				List<WebElement> reissueR2= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissueR2.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_res']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				JavascriptExecutor jse6 = (JavascriptExecutor) driver;
				jse6.executeScript("window.scrollBy(0,400)", "");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).click();
				driver.findElement(By.xpath("//*[@id='"+r+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/table/tbody/tr/td[4]/table/tbody/tr/td[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='"+r+"']/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/input")).sendKeys("1500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+r+"']/table/tbody/tr/td[4]/table/tbody/tr/td[3]/div/input")).sendKeys("50");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[2]")).sendKeys("100");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[2]")).sendKeys("50");
				   Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[2]/div/span/span[1]/span/ul/li/input")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[2]/div/input")).sendKeys("500");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+n+"']/table/tbody/tr/td[4]/table/tbody/tr/td[3]/div/input")).sendKeys("10");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).clear();
				   Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@class='form-control m2class'])[3]")).sendKeys("50");
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).clear();
	               Thread.sleep(1000);
	               driver.findElement(By.xpath("(//*[@name='discountPrice[]'])[3]")).sendKeys("30");
				   Thread.sleep(2000);
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(15000);
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				}
				//REFUND
				public static void refund() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(3000);
			JavascriptExecutor jse6 = (JavascriptExecutor) driver;
				jse6.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(5000);
				List<WebElement> Refund =driver.findElements(By.xpath("(//*[@title='Add Refund'])"));
				 Refund.get(0).click();
				Alert alertR =driver.switchTo().alert();
				alertR.accept();
				Thread.sleep(1000);
				try {
					Alert alertv2 =driver.switchTo().alert();
					alertv2.accept();
					}
					catch(Exception A) {
						System.out.println("error"+A.getMessage());
					}
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
				Thread.sleep(10000);
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(15000);
				
				}
				
				public static void reissuerefund() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(3000);
			JavascriptExecutor jse6 = (JavascriptExecutor) driver;
				jse6.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(5000);
				List<WebElement> Refund =driver.findElements(By.xpath("(//*[@title='Add Refund'])"));
				 Refund.get(1).click();
				Alert alertR =driver.switchTo().alert();
				alertR.accept();
				Thread.sleep(1000);
				try {
					Alert alertv2 =driver.switchTo().alert();
					alertv2.accept();
					}
					catch(Exception A) {
						System.out.println("error"+A.getMessage());
					}
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement>  Refundref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				 Refundref.get(2).sendKeys(random);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='form-control cancellationpenalty'] ")).sendKeys("50");
				List<WebElement>  RefundM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				RefundM2.get(2).sendKeys("10");
				List<WebElement>  RefundD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				RefundD.get(2).sendKeys("5");
				Thread.sleep(10000);
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(15000);
				
				}
				//FULL RECEIPT
				public static void fullReceiptIssue() throws InterruptedException {
					//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					/*WebDriverWait wait=new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]")));
						
					Set<String> s11=driver.getWindowHandles();
					Object popup[]=s11.toArray();
					driver.switchTo().window(popup[1].toString());
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
					try {
					ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(wind.get(1));
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					}
					catch(Exception wind) {
						
						System.out.println(wind.getMessage());
					}
			List<WebElement> NEWPAY=driver.findElements(By.cssSelector(".btn.btn-xs.btn-darkblue"));
			JavascriptExecutor newpay=(JavascriptExecutor)driver;
			newpay.executeScript("arguments[0].click();",NEWPAY.get(1));
			Thread.sleep(10000);
			WebElement NEWPAY2=driver.findElement(By.linkText("Click here to generate receipt.."));
			JavascriptExecutor newpay2=(JavascriptExecutor)driver;
			newpay2.executeScript("arguments[0].click();",NEWPAY2);
			//driver.findElement(By.linkText("Click here to generate receipt..")).click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
				Select MOPCASH=new Select(MOP);
				MOPCASH.selectByIndex(1);
				Thread.sleep(5000);
				/*WebElement ap=driver.findElement(By.xpath("(//*[@name='appliedamount[0][]'])"));
				Actions ap2=new Actions(driver);
				ap2.doubleClick(ap).build().perform();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("(//*[@name='appliedamount[0][]'])")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				Thread.sleep(2000);*/
				//WebElement FullAmount=	driver.findElement(By.xpath("//*[@id='actualprice']"));
				WebElement FullAmount=	driver.findElement(By.xpath("//*[@class='form-control totalRefClass']"));
			    String full= FullAmount.getAttribute("value");
				Thread.sleep(2000);
				System.out.println("Pass");
				driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(full);
				System.out.println("Pass2");
				JavascriptExecutor jse2 = (JavascriptExecutor) driver;
				jse2.executeScript("window.scrollBy(0,600)", "");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
				WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
				JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
				 receiptsave.executeScript("arguments[0].click();",Receptsave);
				/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				Thread.sleep(5000);*/
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").toString().equals("complete");
				Thread.sleep(10000);
				driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
				Thread.sleep(1000);
				try {
				driver.switchTo().alert().accept();
				}
				catch(Exception alert) {
					System.out.println("No alert"); 
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys(full);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
				driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
				Thread.sleep(1000);
				Alert alert2 =driver.switchTo().alert();
				alert2.accept();
				Thread.sleep(5000);
				//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Alert alert21 =driver.switchTo().alert();
				alert21.accept();
				
				WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
				JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
				backbutton3.executeScript("arguments[0].click();", backbutton);
				//scrollup
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				JavascriptExecutor jse3 = (JavascriptExecutor) driver;
				jse3.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(5000);
				}
				public static void fullReceiptReIssue() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAY=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpay=(JavascriptExecutor)driver;
					newpay.executeScript("arguments[0].click();",NEWPAY);
					//Thread.sleep(10000);
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					driver.findElement(By.linkText("Click here to generate receipt")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						/*WebElement ap=driver.findElement(By.xpath("(//*[@name='appliedamount[0][]'])"));
						Actions ap2=new Actions(driver);
						ap2.doubleClick(ap).build().perform();
					    Thread.sleep(2000);
						driver.findElement(By.xpath("(//*[@name='appliedamount[0][]F'])")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
						Thread.sleep(2000);*/
						/*WebElement FullAmount=	driver.findElement(By.xpath("//*[@id='actualprice']"));
						String full= FullAmount.getText();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(full);
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						 receiptsave.executeScript("arguments[0].click();",Receptsave);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(6000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						Thread.sleep(5000);*/
						
						WebElement FullAmount=	driver.findElement(By.xpath("//*[@class='form-control totalRefClass']"));
					    String full= FullAmount.getAttribute("value");
						Thread.sleep(2000);
						System.out.println("Pass");
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(full);
						System.out.println("Pass2");
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						 receiptsave.executeScript("arguments[0].click();",Receptsave);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys(full);
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(1000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						Thread.sleep(5000);
						//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
						Alert alert21 =driver.switchTo().alert();
						alert21.accept();
						
						
						
						
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
						}
				//VOID
				public static void cancel() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(5000);
				List<WebElement> Void =driver.findElements(By.xpath("(//*[@title='Add Void'])"));
				Void.get(0).click();
				Alert alertv =driver.switchTo().alert();
				alertv.accept();
				Thread.sleep(1000);
				try {
				Alert alertv2 =driver.switchTo().alert();
				alertv2.accept();
				}
				catch(Exception A) {
					System.out.println("error"+A.getMessage());
				}
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
				//driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
				Thread.sleep(15000);
				
				}
				//VOID MULTI
				public static void cancelMulti() throws InterruptedException {
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(5000);
					for(int i=0;i<n;i++) {
						int [] e= {0,2,4,6,8,10,12,14,16,18};
						int [] o= {1,3,5,7,9,11,13,15,17,19};
				List<WebElement> Void =driver.findElements(By.xpath("(//*[@title='Add Void'])"));
				Void.get(e[i]).click();
				Alert alertv =driver.switchTo().alert();
				alertv.accept();
				Thread.sleep(1000);
				try {
				Alert alertv2 =driver.switchTo().alert();
				alertv2.accept();
				}
				catch(Exception A) {
					System.out.println("error"+A.getMessage());
				}
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement> Voidref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				Voidref.get(o[i]).sendKeys(random);
				Thread.sleep(2000);
				List<WebElement> VoidM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				VoidM2.get(o[i]).sendKeys("20");
				List<WebElement> VoidD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				VoidD.get(o[i]).sendKeys("10");
				}
				//save&continue
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv3 =driver.switchTo().alert();
				alertv3.accept();
				Thread.sleep(10000);
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(10000);
				}
				//REFUND MULTI
				public static void refundMulti() throws InterruptedException {
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,600)", "");
					Thread.sleep(3000);
					for(int i=0;i<n;i++) {
						int [] e= {0,2,4,6,8,10,12,14,16,18};
						int [] o= {1,3,5,7,9,11,13,15,17,19};
				List<WebElement> Refund =driver.findElements(By.xpath("(//*[@title='Add Refund'])"));
				 Refund.get(e[i]).click();
				Alert alertR =driver.switchTo().alert();
				alertR.accept();
				Thread.sleep(1000);
				try {
					Alert alertv2 =driver.switchTo().alert();
					alertv2.accept();
					}
					catch(Exception A) {
						System.out.println("error"+A.getMessage());
					}
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement>  Refundref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				 Refundref.get(o[i]).sendKeys(random);
				Thread.sleep(2000);
				List<WebElement>	CP=driver.findElements(By.xpath("//*[@class='form-control cancellationpenalty'] "));
				CP.get(o[i]).sendKeys("100");
				List<WebElement>  RefundM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				RefundM2.get(o[i]).sendKeys("20");
				List<WebElement>  RefundD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				RefundD.get(o[i]).sendKeys("10");
				Thread.sleep(2000);
					}
					
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(10000);
				
				}
	public static void reissuecancel() throws InterruptedException {
		//Window handle
		try {
			ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(wind.get(1));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
			catch(Exception wind) {
				
				System.out.println(wind.getMessage());
			}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					Thread.sleep(5000);
				List<WebElement> Void =driver.findElements(By.xpath("(//*[@title='Add Void'])"));
				Void.get(1).click();
				Alert alertv =driver.switchTo().alert();
				alertv.accept();
				Thread.sleep(1000);
				try {
				Alert alertv2 =driver.switchTo().alert();
				alertv2.accept();
				}
				catch(Exception A) {
					System.out.println("error"+A.getMessage());
				}
				random =generateRandomString();
				Thread.sleep(2000);
				List<WebElement> Voidref =driver.findElements(By.xpath("(//*[@name='refundconfno[]'])"));
				Voidref.get(2).sendKeys(random);
				Thread.sleep(2000);
				List<WebElement> VoidM2 =driver.findElements(By.xpath("(//*[@name='m2Price[]'])"));
				VoidM2.get(2).sendKeys("20");
				List<WebElement> VoidD =driver.findElements(By.xpath("(//*[@name='discountPrice[]'])"));
				VoidD.get(2).sendKeys("10");
				//save&continue
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv3 =driver.switchTo().alert();
				alertv3.accept();
				Thread.sleep(15000);
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//Thread.sleep(10000);
				}
				//PARTIAL RECEIPT
				public static void partialReceipt1Issue() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.linkText("Click here to generate receipt..")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys("1400");
						Thread.sleep(4000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).clear();
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).sendKeys("1400");
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
			            driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(4000);
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						receiptsave.executeScript("arguments[0].click();",Receptsave);
						Thread.sleep(2000);
						Alert alertv3 =driver.switchTo().alert();
						alertv3.accept();
						WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
						receiptsave2.executeScript("arguments[0].click();",Receptsave2);
						driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("return document.readyState").toString().equals("complete");
						Thread.sleep(10000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
						Thread.sleep(1000);
						try {
						driver.switchTo().alert().accept();
						}
						catch(Exception alert) {
							System.out.println("No alert"); 
						}
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys("1400");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(1000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						Thread.sleep(5000);
						Alert alert21 =driver.switchTo().alert();
						alert21.accept();
						Thread.sleep(5000);
						//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						//Thread.sleep(5000);
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
				}
				public static void partialReceipt1IssueMulti(/*int ADULT,int CHILD,int INFANT*/) throws InterruptedException {
					//int n=(ADULT+CHILD+INFANT);
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.linkText("Click here to generate receipt..")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						for(int p=0;p<n;p++) {
						List<WebElement> FullAmount=	driver.findElements(By.xpath("(//*[@class='form-control receiveamt'])"));
						String amount= FullAmount.get(p).getAttribute("value");
						Float result = Float.parseFloat(amount);
						float partial=((result)/n);
						String s = Float.toString(partial);
						FullAmount.get(p).clear();
						Thread.sleep(1000);
						FullAmount.get(p).sendKeys(s);
						}
						driver.findElement(By.xpath("//*[@id='appliedbal']")).click();
						Thread.sleep(2000);
						String appliedamount =driver.findElement(By.xpath("//*[@id='appliedbal']")).getText();
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys(appliedamount);
						Thread.sleep(4000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(1000);
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(4000);
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						receiptsave.executeScript("arguments[0].click();",Receptsave);
						Thread.sleep(2000);
						try {
						Alert alertv3 =driver.switchTo().alert();
						alertv3.accept();
						}
						catch(Exception partial) {
							System.out.println("partial.getMessage()");
						}
						WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
						receiptsave2.executeScript("arguments[0].click();",Receptsave2);
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						Alert alert3 =driver.switchTo().alert();
						alert3.accept();
						JavascriptExecutor receiptsave3=(JavascriptExecutor)driver;
						receiptsave3.executeScript("window.scrollBy(0,800)", "");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(10000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						Thread.sleep(5000);
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
				}
				public static void partialReceipt1Issue2() throws InterruptedException, AWTException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.linkText("Click here to generate receipt..")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys("3000");
						Thread.sleep(4000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).clear();
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).sendKeys("3000");
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
			            driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						Thread.sleep(4000);
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						receiptsave.executeScript("arguments[0].click();",Receptsave);
						Thread.sleep(2000);
						Alert alertv3 =driver.switchTo().alert();
						alertv3.accept();
						WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
						receiptsave2.executeScript("arguments[0].click();",Receptsave2);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys("3000");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(3000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						Thread.sleep(5000);
						try {
						Alert alert23 =driver.switchTo().alert();
						alert23.accept();
						}
						catch(Exception alert) {
							Robot r =new Robot();
							r.keyPress(KeyEvent.VK_ENTER);
							r.keyRelease(KeyEvent.VK_ENTER);
							
						}
						driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
				}
				public static void partialReceipt1ReIssue() throws InterruptedException, AWTException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.linkText("Click here to generate receipt")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys("1400");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).clear();
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).sendKeys("1400");
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						 receiptsave.executeScript("arguments[0].click();",Receptsave);
						 try {
						 Thread.sleep(2000);
							Alert alertv3 =driver.switchTo().alert();
							alertv3.accept();
							WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
							JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
							receiptsave2.executeScript("arguments[0].click();",Receptsave2);
						 }
						 catch(Exception alert) {
							 System.out.println(alert.getMessage());
						 }
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys("1400");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(1000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
						Thread.sleep(5000);
						try {
						driver.switchTo().alert().accept();
						}
						catch(Exception alert){
						Robot r=new Robot();
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						}
						Thread.sleep(7000);
						
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
				}
				
				//partial receipt
				public static void partialReceipt2() throws InterruptedException {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					/*WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);*/
						//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						List<WebElement> NEWPAY=driver.findElements(By.cssSelector(".btn.btn-xs.btn-darkblue"));
						JavascriptExecutor newpay=(JavascriptExecutor)driver;
						newpay.executeScript("arguments[0].click();",NEWPAY.get(1));
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						//Thread.sleep(10000);
						driver.findElement(By.linkText("Click here to generate receipt..")).click();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						WebElement MOP=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
						Select MOPCASH=new Select(MOP);
						MOPCASH.selectByIndex(1);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@class='form-control paymentamtClass']")).sendKeys("100");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).clear();
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).sendKeys("100");
						JavascriptExecutor jse2 = (JavascriptExecutor) driver;
						jse2.executeScript("window.scrollBy(0,600)", "");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='form-control receiveamt']")).click();
						WebElement Receptsave=driver.findElement(By.xpath("//*[@name='savePay']"));
						JavascriptExecutor receiptsave=(JavascriptExecutor)driver;
						 receiptsave.executeScript("arguments[0].click();",Receptsave);
						 Thread.sleep(2000);
							Alert alertv3 =driver.switchTo().alert();
							alertv3.accept();
							WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
							JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
							receiptsave2.executeScript("arguments[0].click();",Receptsave2);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).clear();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@class='my_apply_amount row_0']")).sendKeys("100");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
						driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue savePay pull-right']")).click();
						Thread.sleep(3000);
						Alert alert2 =driver.switchTo().alert();
						alert2.accept();
						/*driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
						//Thread.sleep(5000);
						Alert alert21 =driver.switchTo().alert();
						alert21.accept();*/
						WebElement backbutton=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/span[2]/a"));
						JavascriptExecutor backbutton3=(JavascriptExecutor)driver;
						backbutton3.executeScript("arguments[0].click();", backbutton);
						//scrollup
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						JavascriptExecutor jse3 = (JavascriptExecutor) driver;
						jse3.executeScript("window.scrollBy(0,-600)", "");
						Thread.sleep(5000);
				}
				//RECEIPT ALLMODES
				public static void allReceipt() throws Exception {
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					WebElement NEWPAYP=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
					JavascriptExecutor newpayP=(JavascriptExecutor)driver;
					newpayP.executeScript("arguments[0].click();",NEWPAYP);
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					WebElement generatereceipt=driver.findElement(By.linkText("Click here to generate receipt.."));
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].click();", generatereceipt);
					Thread.sleep(4000);
					driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.addPayButton")).click();
					driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.addPayButton")).click();
					driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.addPayButton")).click();
					driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.addPayButton")).click();
					//driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.addPayButton")).click();
					Thread.sleep(5000);
					new Select(driver.findElement(By.id("modeofpay"))).selectByVisibleText("Cash");
					List<WebElement> modes=driver.findElements(By.cssSelector(".form-control.paymentamtClass"));
					modes.get(0).sendKeys("100");
					Thread.sleep(5000);
					for(int j=0;j<3;j++){
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)");	
					Thread.sleep(5000);
					if(j==0){
					new Select(driver.findElement(By.xpath("(//select[@id='modeofpay'])[2]"))).selectByVisibleText("Cheque");
					}
					if(j==1){
					new Select(driver.findElement(By.xpath("(//select[@id='modeofpay'])[3]"))).selectByVisibleText("Bank Transfer");
					}
					if(j==2){
					new Select(driver.findElement(By.xpath("(//select[@id='modeofpay'])[4]"))).selectByVisibleText("Credit Card");	
					}	
					List<WebElement> checknumber=driver.findElements(By.cssSelector("#chequenoinput"));
					List<WebElement> checkdate=driver.findElements(By.cssSelector(".form-control.ppaymentchequedate"));
					List<WebElement> banktype=driver.findElements(By.cssSelector(".form-control.ppaymentchequebank"));
					List<WebElement> bankbranch=driver.findElements(By.cssSelector(".form-control.ppaymentchequebranch"));
					Thread.sleep(2000);
					WebElement cn=checknumber.get(j+1);
					WebElement cdate=checkdate.get(j+1);
					WebElement banktype1=banktype.get(j+1);
					WebElement bankbranch1=bankbranch.get(j+1);
					Thread.sleep(2000);

					jse.executeScript("arguments[0].value='123456';",cn);
					jse.executeScript("arguments[0].value='30-Nov-2019';",cdate);
					banktype1.click();
					Thread.sleep(3000);
					banktype1.sendKeys(Keys.ARROW_DOWN);
					banktype1.sendKeys(Keys.ENTER);
					jse.executeScript("arguments[0].value='Hyderababd';",bankbranch1);
					Thread.sleep(4000);
					try{
					Thread.sleep(2000);
					List<WebElement> cc4digits=driver.findElements(By.cssSelector(".form-control.ppaymentchequeposId"));
					List<WebElement> ccmid=driver.findElements(By.cssSelector(".form-control.ppaymentchequemid"));
					List<WebElement> ccapprovalcode=driver.findElements(By.cssSelector(".form-control.ppaymentchequeapprovalCode"));
					List<WebElement> cccardtype=driver.findElements(By.cssSelector("#ppaymentchequecardtype"));
					WebElement cc4=cc4digits.get(j+1);
					WebElement ccdate=ccmid.get(j+1);
					WebElement ccbanktype1=ccapprovalcode.get(j+1);
					WebElement ccbankbranch1=cccardtype.get(j+1);
					Thread.sleep(2000);
					jse.executeScript("arguments[0].value='4444';",cc4);
					jse.executeScript("arguments[0].value='345';",ccdate);
					ccbanktype1.click();
					Thread.sleep(3000);
					ccbanktype1.sendKeys(Keys.ARROW_DOWN);
					ccbanktype1.sendKeys(Keys.ENTER);
					jse.executeScript("arguments[0].value='48765';",ccbanktype1);
					ccbankbranch1.sendKeys("VisaCard");
					}
					catch(Exception e){
					System.out.println("details are not working");
					}
					//jse.executeScript("arguments[0].value='VisaCard';",ccbankbranch1);
					Thread.sleep(2000);



					}
				}
				//RefundReceipt
				public static void refundReceipt() throws InterruptedException {
				/*WebElement ap5=driver.findElement(By.xpath("//*[@name='pnrnumber']"));
				Actions ap6=new Actions(driver);
				ap6.doubleClick(ap5).build().perform();
				driver.findElement(By.xpath("//*[@name='pnrnumber']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));*/
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
			String PNR=	driver.findElement(By.xpath("//*[@name='pnrnumber']")).getAttribute("value");
			//PNR.getAttribute("value");
				Thread.sleep(4000);
				WebElement NEWPAY2=driver.findElement(By.xpath("(//*[@class='btn btn-xs btn-darkblue'])[2]"));
				JavascriptExecutor newpay2=(JavascriptExecutor)driver;
				newpay2.executeScript("arguments[0].click();",NEWPAY2);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.linkText("Click here to generate refund")).click();
				//Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			//	driver.findElement(By.xpath("//*[@class='form-control input-sm']")).sendKeys(Keys.chord(Keys.CONTROL,"V"));
			driver.findElement(By.xpath("//*[@class='form-control input-sm']")).sendKeys(PNR);
				Thread.sleep(10000);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
				WebElement modeofpay=driver.findElement(By.xpath("//*[@name='modeofpay[0][]']"));
				Select Modeofpay=new Select(modeofpay);
				Modeofpay.selectByIndex(1);
				Thread.sleep(2000);
				/*WebElement ap4=driver.findElement(By.xpath("//*[@name='appliedamount[0][]']"));
				Actions ap3=new Actions(driver);
				ap3.doubleClick(ap4).build().perform();
			    Thread.sleep(2000);*/
				String appamount=driver.findElement(By.xpath("//*[@id='appliedbal']")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys(appamount);
				/*driver.findElement(By.xpath("//*[@name='appliedamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='paymentamount[0][]']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				Thread.sleep(2000);*/
				driver.findElement(By.xpath("//*[@name='receiveamt[0][]']")).click();
				Thread.sleep(2000);
				Thread.sleep(2000);
				WebElement Receptsave2=driver.findElement(By.xpath("//*[@name='savePay']"));
				JavascriptExecutor receiptsave2=(JavascriptExecutor)driver;
				 receiptsave2.executeScript("arguments[0].click();",Receptsave2);
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					driver.findElement(By.xpath("//*[@name='paymentRemarks']")).sendKeys("Testing");
					driver.findElement(By.xpath("//*[@class='approvePay btn btn-lightblue  pull-right']")).click();
					Thread.sleep(10000);
					Alert alert3 =driver.switchTo().alert();
					alert3.accept();
					Thread.sleep(5000);
					//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					Alert alert31 =driver.switchTo().alert();
					alert31.accept();
				}
				//REISSUE RES MULTI
				public  static void reissueResMulti(/*int ADULT,int CHILD,int INFANT*/) throws InterruptedException {
					//int n=(ADULT+CHILD+INFANT);
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,400)", "");
					for(int a=0;a<n;a++) {
						int[] o= {1,3,5,7,9,11,13,15,17,19};
						int[] e= {0,2,4,6,8,10,12,14,16,18,20};
					int q=(n+e[a]);
				int P=(n+o[a]);
				List<WebElement> reissue= driver.findElements(By.xpath("(//*[@class='btn btn-xs btn-success _reissue_tst show'])[1]"));
				reissue.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@name='reissue_res']")).click();
				driver.findElement(By.xpath("//*[@class='btn btn-default submitReissueDetails']")).click();
				Thread.sleep(3000);
				
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,400)", "");
				
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
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input ")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[2]/div/input ")).sendKeys("400");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[3]/div/input ")).sendKeys("100");
				Thread.sleep(2000);
					}
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(10000);
				}
				public  static void reissueAddMulti(int ADULT,int CHILD,int INFANT) throws InterruptedException {
					int n=(ADULT+CHILD+INFANT);
					//int n=2;
					//Window handle
					try {
						ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(wind.get(1));
						driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						}
						catch(Exception wind) {
							
							System.out.println(wind.getMessage());
						}
					JavascriptExecutor jse7 = (JavascriptExecutor) driver;
					jse7.executeScript("window.scrollBy(0,600)", "");
					for(int a=0;a<n;a++) {
						int[] o= {1,3,5,7,9,11,13,15,17,19};
						int[] e= {0,2,4,6,8,10,12,14,16,18,20};
					int q=(n+e[a]);
				int P=(n+o[a]);
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
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[1]/div[2]/div/span/span[1]/span/ul")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[1]/div[2]/div/span/span[1]/span/ul/li/input ")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				random =generateRandomString();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[1]/div/input[1]")).sendKeys(random);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[2]/div/input ")).sendKeys("400");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='"+q+"']/div[2]/div[3]/div/input ")).sendKeys("100");
				Thread.sleep(2000);
					}
				JavascriptExecutor jse8 = (JavascriptExecutor) driver;
				jse8.executeScript("window.scrollBy(0,-600)", "");
				driver.findElement(By.xpath("(//*[@class='btn btn-lightblue updatePrice btn-minwidth'])[2]")).click();
				Thread.sleep(1000);
				Alert alertv4 =driver.switchTo().alert();
				alertv4.accept();
				Thread.sleep(10000);
				}
				public void reloadpage() throws Exception
				{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").toString().equals("complete");
				Thread.sleep(2000);
				}
				
				public static void browserHistory() throws AWTException, InterruptedException {
					System.setProperty("webdriver.chrome.driver","D:\\Meera\\Browserdrivers\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().window().maximize();
				
					/*Actions action = new Actions(driver); 
					action.sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,Keys.DELETE)).build().perform();*/
					Robot k=new Robot();
					k.keyPress(KeyEvent.VK_CONTROL);
					k.keyPress(KeyEvent.VK_SHIFT);
                    k.keyPress(KeyEvent.VK_DELETE);
                    k.keyRelease(KeyEvent.VK_CONTROL);
                    k.keyRelease(KeyEvent.VK_SHIFT);
                    k.keyRelease(KeyEvent.VK_DELETE);
                    Thread.sleep(4000);
                    k.keyPress(KeyEvent.VK_ENTER);
                    k.keyRelease(KeyEvent.VK_ENTER);
                    //RELOAD
                    JavascriptExecutor js = (JavascriptExecutor)driver;
    				js.executeScript("return document.readyState").toString().equals("complete");
    				Thread.sleep(2000);
                    //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                    driver.quit();
				    }			
	                public static void quit() {
	                driver=new ChromeDriver();
	                driver.quit();
	                 }
	}	
				


	














