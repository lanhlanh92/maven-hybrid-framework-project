package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_16_ReportNG extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void User_01_Register() {
		
		log.info("Register - Step 01: Verify register link is Displayed ");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 02: Click to Register Link ");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 03: Click to Register button ");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 04: Verify error message at First name textbox ");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("Register - Step 05: Verify error message at Last name textbox ");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
	}
	public void User_02_Register_Success() {
		
		log.info("Register - Step 01: Enter First Name Textbox");
		registerPage.enterToFirstNameTextBox("Emily");
		
		log.info("Register - Step 02: Enter Last Name Textbox");
		registerPage.enterToLastNameTextBox("Ly");
		
		log.info("Register - Step 03: Enter Email Textbox");
		registerPage.enterToEmailTextBox(emailAddress);
		
		log.info("Register - Step 04: Enter Password Textbox");
		registerPage.enterToPasswordTextBox("123456");
		
		log.info("Register - Step 05: Enter Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		log.info("Register - Step 06: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 07: Verify success message ");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
		
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
