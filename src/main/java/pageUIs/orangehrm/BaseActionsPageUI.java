package pageUIs.orangehrm;

public class BaseActionsPageUI {
		public static final String SPINNER_ICON = "css=div.oxd-loading-spinner-container";
		public static final String DYNAMIC_SUCCESS_MESSAGE = "xpath=//p[contains(@class,'oxd-text--toast-message') and text()='%s']";
		public static final String DYNAMIC_INDEX_BY_COLUMNNAME = "xpath=//div[text()='%s']/preceding-sibling::div";
		public static final String DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//div[@class='oxd-table-body']//div[@role='row'][%s]/div[%s]/div[contains(text(),'%s')]";
		
		public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME = "xpath=//label[contains(string(),'%s')]/input";
		public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[contains(string(),'%s')]/input";
}
