package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.HomePageObject;
import pageUIs.users.BaseElementUI;
import pageUIs.users.BasePageUI;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptToAlert(WebDriver driver) {
		// driver.switchTo().alert().accept();
		waitForAlertPresence(driver).accept();
	}

	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senkeyToAlert(WebDriver driver, String keyToSend) {
		waitForAlertPresence(driver).sendKeys(keyToSend);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
		}
	}

	public void switchToWindownByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
	}

	public Set<Cookie> getBrowserCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	
	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	public void sleepInSecond(long timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public By getByLocator(String locatorValue) {
		By by = null;
		
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("Xpath=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=")) {
			by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=") ) {
			by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=") ) {
			by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=") ) {
			by = By.tagName(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator type is not valid.");
		}
		
		return by;
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public String getDynamicLocator(String locator, String... restParams ) {
		return String.format(locator, (Object[])restParams);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locator , String...restParams) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... restParams) {
		getWebElement(driver, getDynamicLocator(locator,restParams)).click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}

	public void senkeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
		getWebElement(driver, getDynamicLocator(locator, restParams)).clear();
		getWebElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
	}
	
	public void selectDropdown(WebDriver driver, String locator, String itemText) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemText);
	}
	
	public void selectDropdown(WebDriver driver, String locator, String itemText, String... restParams) {
		new Select(getWebElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOptions(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultile(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,
			String expectedText) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(12);

		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));

		for (WebElement tempElement : allItems) {

			if (tempElement.getText().equals(expectedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(1);

				tempElement.click();
				sleepInSecond(1);

				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getText();
	}

	public String getElementAtribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAtribute(WebDriver driver, String locator, String attributeName, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}

	public String getHexaColorByRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	
	public int getListElementSize(WebDriver driver, String locator , String... restParams) {
		return getListWebElement(driver, getDynamicLocator(locator, restParams)).size();
	}
	
	public void checkToCheckboxRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			clickToElement(driver, locator);
		}
	}
	public void checkToCheckbox(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	public void checkToCheckbox(WebDriver driver, String locator, String...restParams) {
		if (!getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
			getWebElement(driver, getDynamicLocator(locator, restParams)).click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if (getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public boolean isElementUnDisplay(WebDriver driver, String locator) {
		setImplicitWait(driver, short_timeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		setImplicitWait(driver, timeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() == 1 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
	}
		
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public void switchtoIFrame(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String xpathSource, String xpathTarget) {
		new Actions(driver).dragAndDrop(getWebElement(driver, xpathSource), getWebElement(driver, xpathTarget)).perform();
	}

	public void senkeyBroadElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
		sleepInSecond(3);
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String... restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, restParams)));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName,
			String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		return status;
	}
	
	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver,BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean waitForElementInvisiable(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	public boolean waitForListElementInvisiable(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout))
				.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	public HomePageObject clickToUserLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.USER_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public AdminLoginPageObject clickToAdminLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	private long timeout = GlobalConstants.LONG_TIMEOUT;
	private long short_timeout = GlobalConstants.SHORT_TIMEOUT;
}
