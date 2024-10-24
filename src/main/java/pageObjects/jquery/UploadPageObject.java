package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;
	public UploadPageObject( WebDriver driver) {
		this.driver = driver;
	}
	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplay(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		
	}
	public void clickStartButtonEachFile() {
		List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			clickToElement(driver, startButton);
		}
		
		
	}
	public boolean isFileUpLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplay(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}
	public boolean isLoadingIconAtMainContentDisappear() {
		return waitForElementInvisiable(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
	}
	public boolean isLoadingIconAtMainUploadDisappear() {
		return waitForElementInvisiable(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
	}
	public boolean isMultipleProgressBarDisappear() {
		return waitForListElementInvisiable(driver,  UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
	}
	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
		return isElementDisplay(driver,  UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
	}
	public void clickToSuccessLink() {
		waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
		clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
	}
	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
		return isElementDisplay(driver,  UploadPageUI.CONTENT_TABLE);
	}
	public boolean isDownloadButtonDisplayed(String fileName) {
		waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_NAME, fileName);
		return isElementDisplay(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_NAME, fileName);
	}
	public boolean isPlayButtonDisplayed(String fileName) {
		waitForElementClickable(driver, UploadPageUI.PLAY_BUTTON_BY_NAME, fileName);
		return isElementDisplay(driver, UploadPageUI.PLAY_BUTTON_BY_NAME, fileName);
	}
}
