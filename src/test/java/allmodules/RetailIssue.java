package allmodules;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RetailIssue {

	static int	ADULT=3;
	static int CHILD=3;
	static int INFANT=3;
	 static int n=(ADULT+CHILD+INFANT);
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


	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagul Meera\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			//Excel read
			File file = new File("D:\\CCC.xls");
			 FileInputStream fio=new FileInputStream(file);
			 Workbook wb=Workbook.getWorkbook(fio);
			 Sheet sheet=wb.getSheet("Sheet1");
			 int rows=sheet.getRows();
			 for(int r=0;r<rows;r++) {
				 String Adult=sheet.getCell(0,r).getContents();
				 System.out.println(Adult);
				 String Child=sheet.getCell(1,r).getContents();
				 System.out.println(Child);
				 String Infant=sheet.getCell(2,r).getContents();
				 System.out.println(Infant);
			//driver.get("http://100.100.60.116:8090/srx/");
			//driver.get("http://100.100.60.116/dashboard");
	driver.get("http://172.168.10.239/qa/srx/");
//driver.get("http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
	      // Thread.sleep(10000);
			driver.findElement(By.name("sign_in_username_email")).sendKeys("warren");
			driver.findElement(By.name("sign_in_password")).sendKeys("warren");
			driver.findElement(By.xpath("//*[text()='Sign In']")).click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@title='Retail Request']")).click();
			Thread.sleep(5000);
			JavascriptExecutor jse41retail = (JavascriptExecutor) driver;
			jse41retail.executeScript("document.getElementById('atu_mobile').value='7893937149';");
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
			

			
			/*int ADULT = Integer.parseInt(Adult2);
			int CHILD = Integer.parseInt(Child);
			int INFANT = Integer.parseInt(Infant);*/
			
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
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(20000);
		//for scroll UP
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
				catch(Exception Alert) {
					System.out.println("Alert.getMessage()");
					Thread.sleep(2000);
				}
			driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
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
		for(int c=0;c<(ADULT-1);c++) {
			List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
		copyticket.get(0).click();
		Thread.sleep(3000);
		}
		for(int i=0;i<(ADULT-1);i++) {
		int	a=i+1;
		String[] STRING_ARRAY = {"Jhon","nagul", "pawan","Britlee","Jacob","Oliver","Fanny","Noah","Harry"};
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
		catch(Exception Alert) {
			System.out.println("Alert.getMessage()");
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='"+a+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
		System.out.println("done1");
		String[] STRING_ARRAY1 = {"Jhon","nagul", "pawan","Britlee","Jacob","Oliver","Fanny","Noah","Harry"};
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
		String[] STRING_ARRAY = {"arun", "sameer","mahesh","Adia","Bency","Cady","Eliza","Emmy","Erica"};
		Thread.sleep(3000);
		List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
		passenger.get(i+ADULT).click();
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
			catch(Exception Alert) {
				System.out.println("Alert.getMessage()");
				Thread.sleep(2000);
			}
		driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
		Thread.sleep(2000);
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
			catch(Exception Alert) {
				System.out.println("Alert.getMessage()");
				Thread.sleep(2000);
			}
		driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
		Thread.sleep(2000);
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
		if(ADULT>=1) {
			for(int d=0;d<(INFANT);d++) {
				List<WebElement> copyticket = driver.findElements(By.cssSelector(".btn.btn-xs.btn-lightblue.copytst"));	
			copyticket.get(0).click();
			Thread.sleep(3000);
			}
			for(int i=0;i<(INFANT);i++) {
				int J=(ADULT+CHILD+i);
				String[] STRING_ARRAY = {"akbar", "Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
				Thread.sleep(3000);
				List<WebElement> passenger = driver.findElements(By.xpath("//*[@title='Add Passengers'][1]"));	
				passenger.get(i+ADULT+CHILD).click();
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
					catch(Exception Alert) {
						System.out.println("Alert.getMessage()");
						Thread.sleep(2000);
					}
				driver.findElement(By.xpath("//*[@id='addPassengersModal']/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='"+J+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b")).click();
				/*WebElement infant1=driver.findElement(By.xpath(".//*[@id='"+I+"']/div[1]/div[3]/div[1]/div/div[1]/div/span/span[1]/span/span[2]/b"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();",infant1);*/
				Thread.sleep(2000);
				String[] STRING_ARRAY1 =  {"akbar", "Neils","Marie","Hadly","Hazel","Jainy","Jalin","Juliya"};
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
		}
		}
		// TODO Auto-generated method stub

	}


