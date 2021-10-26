package Tests;

import java.awt.AWTException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.Basepage;

public class TC005 {
  @Test
  public void TC005_1() throws AWTException {
	  Basepage bp=new Basepage();
	  bp.Browserlaunch("Chrome", "http://172.168.10.101/ota/otadev/srm/trunk/dashboard#!");
	  Reporter.log("TC005_1");
  }
  @Test
  public void TC005_2() {
	  Reporter.log("TC005_2");
  }
  @Test
  public void TC005_3() {
	  Reporter.log("TC005_3");
  }
}
