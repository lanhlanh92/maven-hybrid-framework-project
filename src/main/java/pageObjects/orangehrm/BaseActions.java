package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseActionsPageUI;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class BaseActions extends BasePage {
	private WebDriver driver;
	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForSpinnerIconInvisible() {
		waitForListElementInvisiable(driver, BaseActionsPageUI.SPINNER_ICON);
	}
	
	public boolean isSuccessMessageDisplayed(String messageContent) {
		waitForElementVisible(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE , messageContent);
		return isElementDisplay(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE , messageContent);
	}
	
	public void isValueDisplayedAtColumnName(String columnName, String indexRow, String rowValue) {
		int columnIndex = getListElementSize(driver, BaseActionsPageUI.DYNAMIC_INDEX_BY_COLUMNNAME, columnName) + 1;
		isElementDisplay(driver, BaseActionsPageUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX, indexRow, String.valueOf(columnIndex), rowValue );
			
	}
	
	public void clickToRadioButtonByLabelName(String radioLabelName) {
		clickToElementByJS(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, radioLabelName);
	}

	public void clickToCheckboxByLabelName(String checkboxLabelName) {
		if ( !isElementSelected(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName)) {
			clickToElementByJS(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName);
		}
	}
	
	public boolean isRadioButtonSelectedByLabelName(String genderStatus) {
		return isElementSelected(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, genderStatus);
	}

	public boolean isCheckboxSelectedByLabelName(String smockerStatus) {
		return isElementSelected(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, smockerStatus);
	}
}
