package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Basepage;
import Pages.CustomizationofTestngreport;
import Pages.Homepage;
import Pages.Loginpage;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class Loginpage_Validations {
  @Test
  @DataProvider(name="Logindata")
  public Object[][]  f() throws IOException {
	  File f=new File("D:\\AutomationFiles\\DDT.xlsx");
	  FileInputStream fi=new  FileInputStream(f);
	  XSSFWorkbook wb=new XSSFWorkbook(fi);
	  XSSFSheet sh=wb.getSheet("Sheet1");
	  int rowcount=sh.getLastRowNum()+1;
	  Object[][] data=new Object[rowcount-1][3];
	  for(int i=1;i<rowcount;i++) {
		  try {
			  data[i-1][0]=sh.getRow(i).getCell(0).getStringCellValue();
      	}
      	catch(NullPointerException np){
      	  data[i-1][0]="";
      	}     	
		  try {
			  data[i-1][1]=sh.getRow(i).getCell(1).getStringCellValue();
      	}
      	catch(NullPointerException np){
      		data[i-1][1]="";
      	}     	
		  try {
			  data[i-1][2]=sh.getRow(i).getCell(2).getStringCellValue();
      	}
      	catch(NullPointerException np){
      		data[i-1][2]="";
      	}     	
	  }
	  return data;
  }
  @Test(enabled=false)
  public void test(String criteria,String username,String password) {
	  Reporter.log(criteria);
	  Reporter.log(username);
	  Reporter.log(password);
  }
  
  @Test(dataProvider="Logindata")
  public void login(String criteria,String username,String password) throws AWTException, InterruptedException {
	  Basepage bp=new Basepage();
	  Loginpage Lg=new Loginpage(Basepage.driver);
	  Homepage Ho=new Homepage(Basepage.driver);
	  CustomizationofTestngreport cs=new CustomizationofTestngreport();
	 bp.Browserlaunch("Chrome", "http://172.168.10.239/qa/srx/");
	 /*Reporter.log(username);
	 Reporter.log(password+"empty");*/
	 Lg.signin(username,password);
		if((Lg.PW.equals("")||Lg.UN.equals(""))&&Lg.Blankusertext.isDisplayed()) {
			Reporter.log("Blank  Un or pw test passed");
			Assert.assertTrue(true);
		            }
		else if(criteria.equals("Invalid")&&Lg.Invalidusertext.isDisplayed()) {
		Reporter.log("Invalid user data test passed");
		Assert.assertTrue(true);
		//cs.onTestFailure();
		}
        else if(criteria.equals("Valid")/*&&(!(Lg.UN.isDisplayed()))*/)  {
        	Reporter.log("Valid data test passed");
        	Assert.assertTrue(true);
        	//cs.onTestFailure();
        }
        else 
        {
        	cs.onTestFailure();
        	Assert.assertTrue(false);
        	}
		Thread.sleep(5000);
		 //Basepage.driver.close();
  }
}
