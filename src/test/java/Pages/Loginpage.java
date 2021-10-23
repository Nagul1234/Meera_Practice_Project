package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Loginpage {
@FindBy(name="sign_in_username_email") public WebElement  UN;
@FindBy(name="sign_in_password") public WebElement PW;
@FindBy(xpath="//*[text()=' Sign In ']") WebElement Signin;
@FindBy(xpath="//*[text()='Username/Password should not be empty.']")
public WebElement Blankusertext;
@FindBy(xpath="//*[text()='Sorry, your Username/Email and Password combination is incorrect.']") public WebElement Invalidusertext;
public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void signin(String usename,String password) throws InterruptedException {
	UN.sendKeys(usename);
	PW.sendKeys(password);
	Signin.click();
	Thread.sleep(5000);
}
}
