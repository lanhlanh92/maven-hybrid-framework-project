package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageUIs.users.CustomerPageUI;

public class CustomerPageObject extends SideBarMyAccountPageObject{

	private WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
		return getElementAtribute(driver, CustomerPageUI.FIRST_NAME_TEXTBOX,"value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getElementAtribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX,"value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAtribute(driver, CustomerPageUI.EMAIL_TEXTBOX,"value");
	}
	

}
