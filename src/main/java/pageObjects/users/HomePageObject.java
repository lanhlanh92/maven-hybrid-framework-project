package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.users.HomePageUI;

public class HomePageObject extends BaseElement{
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@Step("Click to register link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}
	@Step("Click to login link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}
	@Step("Click to my account link")
	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	@Step("Click to my account link")
	public CustomerPageObject openMyAccountLink() {
		String myAcountLink = getElementAtribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
		openUrl(driver, myAcountLink);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	@Step("Verify the register link is display")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplay(driver, HomePageUI.REGISTER_LINK);
		
	}
	
	
}
