package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_22_Close_Browser extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName ) {
		
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"),"First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");
	}

	public void Register_01_Empty_Data() {
		
		
	}

	public void Register_02_Invalid_Email() {
		
	}

	public void Register_03_Invalid_Password() {
		
	}

	public void Register_04_Incorrect_Confirm_Password() {
	

	}

	public void Register_05_Success() {
		

	}
	public void User_06_Login_Success() {
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		quitBrowserDriver();
	}
}
