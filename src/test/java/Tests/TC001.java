package Tests;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class TC001 {
  @Test(priority=3)
  public void TC001_1() {
	  System.out.println("TC001_1");
	  Reporter.log("TC001_1");
  }
  @Test(priority=2)
  public void TC001_2() {
	  System.out.println("TC001_2");
	  Reporter.log("TC001_2");
  }
  @Test(priority=1)
public void TC001_3() {
	  System.out.println("TC001_3");
	Reporter.log("TC001_3");
}
}
