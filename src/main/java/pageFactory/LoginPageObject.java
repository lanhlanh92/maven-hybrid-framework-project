package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.users.HomePageObject;

public class LoginPageObject extends BasePageFactory {

	WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(css="#Password")
	WebElement passwordTextbox;
	
	@FindBy(css = "button.login-button")
	WebElement loginButton;
	
	public void loginAsUser(String emailAdress, String password) {
		enterToEmailTextBox(emailAdress);
		enterToPasswordTextBox(password);
		clickToLoginButton();
	}
	public void enterToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver,emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAdress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

}
