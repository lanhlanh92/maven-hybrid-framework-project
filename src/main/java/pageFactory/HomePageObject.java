package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory{
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a.ico-register")
	WebElement registerLink;
	
	@FindBy(css="a.ico-login")
	WebElement loginLink;
	
	@FindBy(css="a.ico-account")
	WebElement myAccountLink;
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}
	
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}
}
