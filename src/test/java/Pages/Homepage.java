package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
@FindBy(xpath="//*[@id='time']") public WebElement  timer;
public Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}
