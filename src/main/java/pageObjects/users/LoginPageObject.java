package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.users.LoginPageUI;
import testdata.jsonData.nopcommerce.UserInfoData;
import testdata.pojoData.nopcommerce.UserInfo;

public class LoginPageObject extends BaseElement {

	private WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterToEmailTextBox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}
	public HomePageObject loginAsUser(String emailAdress, String password) {
		enterToTextboxByID("Email", emailAdress);
		enterToTextboxByID("Password", password);
		clickToButtonByText("Log in");
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject loginToApp(UserInfo userInfo) {
		enterToEmailTextBox(userInfo.getEmailAddress());
		enterToPasswordTextBox(userInfo.getPassword());
		return clickToLoginButtonn();
	}
	
	public HomePageObject loginToSystem(UserInfoData userInfo) {
		enterToEmailTextBox(userInfo.getEmailAddress());
		enterToPasswordTextBox(userInfo.getPassword());
		return clickToLoginButtonn();
	}

	public HomePageObject clickToLoginButtonn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
