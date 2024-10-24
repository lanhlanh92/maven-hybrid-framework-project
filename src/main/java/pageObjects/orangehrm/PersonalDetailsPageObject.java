package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject  extends BaseActions{
	private WebDriver driver;
	
	public PersonalDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
		return getElementAtribute(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
		return getElementAtribute(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAtribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX, "value");
	}

	public EmployeeListPageObject clickEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

	public boolean isPersonalDetailsHeaderPlayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_PAGE_HEADER);
		return isElementDisplay(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_PAGE_HEADER);
	}

	public void enterToNicknameTextbox(String nickName) {
		waitForElementVisible(driver, PersonalDetailsPageUI.NICKNAME_TEXTBOX);
		senkeyToElement(driver, PersonalDetailsPageUI.NICKNAME_TEXTBOX, nickName);
	}

	public void enterToDriverLicenseNumberTextbox(String driverLicenseNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		senkeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicenseNumber);
	}

	public void enterToLicenseExpiryDatePicker(String licenseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_EXPIRY_DATE_PICKER);
		senkeyToElement(driver, PersonalDetailsPageUI.DRIVER_EXPIRY_DATE_PICKER, licenseExpiryDate);
	}

	public void enterToSocialSecurityNumberTextbox(String ssNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_TEXTBOX);
		senkeyToElement(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_TEXTBOX, ssNumber);
		
	}

	public void enterToSocialInsuranceNumberTextbox(String siNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_NUMBER_TEXTBOX);
		senkeyToElement(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_NUMBER_TEXTBOX, siNumber);
	}

	public void enterToNationalityDropdown(String nationalityName) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHILD, nationalityName);	
	}

	public void enterToMaritalStatusDropdown(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
	}

	public void enterToDayOfBirthDatePicker(String dayOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER);
		senkeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER, dayOfBirth);
	}

	public void clickToSaveButtonAtPersonalDetailsPart() {
		waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILS );
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAILS);
		
	}

	public String getNationalityDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_SELECTED_TEXT);
	}

	public String getMaritalDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_TEXT);
	}

}
