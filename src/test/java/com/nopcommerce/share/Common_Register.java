package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Common_Register extends BaseTest {
	public static WebDriver driver;
	public static HomePageObject homePage;
	public static RegisterPageObject registerPage;
	public static String emailAddress, password, firstName, lastName;


	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		emailAddress = getEmailAdress();
		password = "123456";
		firstName = "John";
		lastName = "Kennedy";
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox(firstName);
		registerPage.enterToLastNameTextBox(lastName);
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox(password);
		registerPage.enterToConfirmPasswordTextBox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		quitBrowserDriver();
	}
}
