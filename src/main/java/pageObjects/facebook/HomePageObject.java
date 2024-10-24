package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		//waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isFirstNameTextBoxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
		return isElementDisplay(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isSurNameTextBoxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.SURNAME_TEXTBOX);
		return isElementDisplay(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextBoxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplay(driver, HomePageUI.EMAIL_TEXTBOX);
	}
	
	public boolean isConfirmEmailTextboxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplay(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextBoxDisplayed() {
		//waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplay(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void clickToCloseSignUpPopup() {
		//waitForElementClickable(driver, HomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_POPUP_BUTTON);
		sleepInSecond(2);
	}
	
	public void enterToEmailTextbox(String emailAddress) {
		//waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public boolean isFirstNameTextBoxUndisplayed() {
		return isElementUnDisplay(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isSurNameTextBoxUndisplayed() {
		return isElementUnDisplay(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextBoxUndisplayed() {
		return isElementUnDisplay(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextBoxUndisplayed() {
		return isElementUnDisplay(driver, HomePageUI.PASSWORD_TEXTBOX);
	}
	public boolean isConfirmEmailTextboUndisplayed() {
		return isElementUnDisplay(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}
