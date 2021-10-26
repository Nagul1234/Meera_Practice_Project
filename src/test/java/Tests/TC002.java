package Tests;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class TC002 {
  @Test(priority=2)
  public void TC002_1() {
	  System.out.println("TC002_1");
	  Reporter.log("TC002_1");
  }
  @Test(dependsOnMethods= {"TC002_3"})
  public void TC002_2() {
	  Reporter.log("TC002_2");
  }
  @Test(priority=1)
  public void TC002_3() {
	  Reporter.log("TC002_3");
  }
}
