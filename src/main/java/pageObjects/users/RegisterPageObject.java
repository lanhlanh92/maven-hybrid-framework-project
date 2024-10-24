package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.users.RegisterPageUI;
import testdata.jsonData.nopcommerce.UserInfoData;
import testdata.pojoData.nopcommerce.UserInfo;

public class RegisterPageObject extends BaseElement{

	private WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@Step("Click to register button") 
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Verify the First name error message")
	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Verify the Last name error message")
	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Verify the Email error message")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	@Step("Verify the Password error message")
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	@Step("Verify the Confirm Password error message")
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
	@Step("Enter to First Name textbox with value is {0}")
	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	@Step("Enter to Last Name textbox with value is {0}")
	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	@Step("Enter to Email textbox with value is {0}")
	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to Confirm Password textbox with value is {0}")
	public void enterToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	@Step("Verify the register success message is display")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCES_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCES_MESSAGE);
	}
	
	public void setToRegisterForm(UserInfo userInfo) {
		enterToFirstNameTextBox(userInfo.getFirstName());
		enterToLastNameTextBox(userInfo.getLastName());
		enterToEmailTextBox(userInfo.getEmailAddress());
		enterToPasswordTextBox(userInfo.getPassword());
		enterToConfirmPasswordTextBox(userInfo.getPassword());
	}
	
	public void enterToRegisterForm(UserInfoData userInfo) {
		enterToFirstNameTextBox(userInfo.getFirstName());
		enterToLastNameTextBox(userInfo.getLastName());
		enterToEmailTextBox(userInfo.getEmailAddress());
		enterToPasswordTextBox(userInfo.getPassword());
		enterToConfirmPasswordTextBox(userInfo.getPassword());
	}
}
