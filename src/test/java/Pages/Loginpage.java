package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
@FindBy(name="sign_in_username_email") WebElement UN;
@FindBy(name="sign_in_password") WebElement PW;
@FindBy(xpath="//*[text()=' Sign In ']") WebElement Signin;
public void signin(String usename,String password) {
	UN.sendKeys(usename);
	PW.sendKeys(password);
	Signin.click();
}
}
