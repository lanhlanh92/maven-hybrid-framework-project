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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;

@Test
@Epic("Account")
@Feature("Create Account")
public class Level_19_AllureReport extends BaseTest {
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
	
	@Description("User_01_Register_Validate")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	public void User_01_Register_Validate() {
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		
	}
	@Description("User_02_Register_Success")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	public void User_02_Register_Success() {

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
