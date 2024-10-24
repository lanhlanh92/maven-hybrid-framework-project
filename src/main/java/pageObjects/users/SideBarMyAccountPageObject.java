package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.users.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BaseElement {
	WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public AddressPageObject openAddressPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESSES_LINK );
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINT_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);		
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}

	public CustomerPageObject openCustomerInfoPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public SideBarMyAccountPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK ,pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
		
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Orders":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Reward points":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getCustomerPage(driver);
		default:
			new RuntimeException("Sidebar page name incorrect");
			return null;
		}
	}
	
	public void openDynamicSideBarPageByName(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK ,pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
	}
}
