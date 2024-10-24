package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
public class Level_18_Extent_V3 extends BaseTest {
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
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	public void User_01_Register_Validate(Method method) {
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		
	}
	public void User_02_Register_Success(Method method) {
		

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox("Emily");
		
		registerPage.enterToLastNameTextBox("Ly");
		
		registerPage.enterToEmailTextBox(emailAddress);
		
		registerPage.enterToPasswordTextBox("123456");
		
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
