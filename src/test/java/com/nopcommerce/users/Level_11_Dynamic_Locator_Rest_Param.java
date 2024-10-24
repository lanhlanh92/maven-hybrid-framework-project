package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.users.AddressPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

@Test
public class Level_11_Dynamic_Locator_Rest_Param extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressPageObject addressPage;
	private RewardPointPageObject rewardPointPage;
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void User_01_Register() {
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();
		 
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
		
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Emily");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Ly");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}
	
	public void User_02_Switch_Page() {
		
		downloadableProductPage = (DownloadableProductPageObject) customerPage.openDynamicSideBarPage("Downloadable products");
		
		addressPage = (AddressPageObject) downloadableProductPage.openDynamicSideBarPage("Addresses");
		
		rewardPointPage = (RewardPointPageObject) addressPage.openDynamicSideBarPage("Reward points");
		
		customerPage = (CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer info");
		
		addressPage = (AddressPageObject) customerPage.openDynamicSideBarPage("Addresses");
		
		downloadableProductPage = (DownloadableProductPageObject) addressPage.openDynamicSideBarPage("Downloadable products");
		
	}
	
	public void User_03_Switch_Page() {
		
		customerPage.openDynamicSideBarPageByName("Downloadable products");
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
		
		downloadableProductPage.openDynamicSideBarPageByName("Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		addressPage.openDynamicSideBarPageByName("Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);
		
		rewardPointPage.openDynamicSideBarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		customerPage.openDynamicSideBarPageByName("Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		addressPage.openDynamicSideBarPageByName("Downloadable products");
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
