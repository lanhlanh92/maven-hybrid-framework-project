package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseActions{
	private WebDriver driver;
	
	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementClickable(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementClickable(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAtribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
	}
}
