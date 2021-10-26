package Tests;

import java.awt.AWTException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.Basepage;

public class TC004 {
  @Test
  public void TC004_1() throws AWTException {
	  Basepage bp=new Basepage();
	  bp.Browserlaunch("Chrome", "http://172.168.10.239/qa/srx/");
	  Reporter.log("TC004_1");
  }
  @Test
  public void TC004_2() {
	  Reporter.log("TC004_2");
  }
  @Test
  public void TC004_3() {
	  Reporter.log("TC004_3");
  }
}
