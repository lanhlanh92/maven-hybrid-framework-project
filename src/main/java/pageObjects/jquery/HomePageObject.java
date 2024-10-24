package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageObjects.users.RegisterPageObject;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	public HomePageObject( WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementClickable(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		senkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
	public void clickToPageByNumber(String pageNumber ) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}
	
	public boolean isPageActiveByNumber(String pageNumber ) {
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}
	
	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplay(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}

	public void clickToRowActionByCountryName(String country, String rowAction) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	}
	
	public void getAllPageValuesByColumnName(String columnName) {
		
		List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);
		List<String> allValues = new ArrayList<String>();
		
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1 ;
		
		for (WebElement pageLink : allPageLinks) {
			
			pageLink.click();
			
			List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_NAME, String.valueOf(columnIndex));
			
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		
		for (String value : allValues) {
			System.out.println(value);
		}
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName) + 1 ;
		
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
	
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName) + 1 ;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

}










