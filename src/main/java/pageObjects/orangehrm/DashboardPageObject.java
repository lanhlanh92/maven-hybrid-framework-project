package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.DashbroadPageUI;

public class DashboardPageObject extends BaseActions{
	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public EmployeeListPageObject openPIMModule() {
		waitForElementClickable(driver, DashbroadPageUI.PIM_MODULE);
		clickToElement(driver, DashbroadPageUI.PIM_MODULE);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

}
