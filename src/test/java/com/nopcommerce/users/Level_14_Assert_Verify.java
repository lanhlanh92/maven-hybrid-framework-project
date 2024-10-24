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
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_14_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	private CustomerPageObject customerPage;
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void User_01_Register() {
		// Verify register link => FALSE
		verifyFalse(homePage.isRegisterLinkDisplayed());
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		// Verify error message => PASS
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		// Verify error message => FALSE
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		// Verify error message => FALSE
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();
		 
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
		
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Emily");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Ly");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
