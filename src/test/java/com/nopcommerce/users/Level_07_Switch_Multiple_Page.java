package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.AddressPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

@Test
public class Level_07_Switch_Multiple_Page extends BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressPageObject addressPage;
	private RewardPointPageObject rewardPointPage;
	
	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl ) {
		
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
		downloadableProductPage = customerPage.openDownloadableProductPage();
		
		addressPage = downloadableProductPage.openAddressPage();
		
		rewardPointPage = addressPage.openRewardPointPage();
		
		customerPage = rewardPointPage.openCustomerInfoPage();
		
		addressPage = customerPage.openAddressPage();
		
		downloadableProductPage = addressPage.openDownloadableProductPage();
		
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
