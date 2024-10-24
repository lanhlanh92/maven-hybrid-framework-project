package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_06_Page_Generator_01 extends BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName ) {
		driver = getBrowserDriver(browserName);
	}

	public void Register_01_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	public void Register_02_Invalid_Email() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox("Emily@Ly@gmail");
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	public void Register_03_Invalid_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:" + "\n" + "must have at least 6 characters");
	}

	public void Register_04_Incorrect_Confirm_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(getEmailAdress());
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	public void Register_05_Success() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.loginAsUser(emailAddress, "123456");
		homePage = new HomePageObject(driver);
		
		homePage.clickToMyAccountLink();
		customerPage = new CustomerPageObject(driver);
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Emily");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Ly");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
