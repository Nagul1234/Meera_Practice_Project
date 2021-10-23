package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomizationofTestngreport implements ITestListener {


	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure() {
		//Unique name each result
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date dt=new Date();
		String fname=sdf.format(dt)+".png";
		//Screenshot
		/*File sc=((TakesScreenshot)(Bp2.driver)).getScreenshotAs(OutputType.FILE);*/
		TakesScreenshot scrShot =((TakesScreenshot)Basepage.driver);
		File sc=scrShot.getScreenshotAs(OutputType.FILE);
		String path="D:\\"+fname;
        File f1=new File(path);
        try {
			FileHandler.copy(sc,f1);
			Reporter.log("<br><img src='"+f1+"' height='300' width='300' /><br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
