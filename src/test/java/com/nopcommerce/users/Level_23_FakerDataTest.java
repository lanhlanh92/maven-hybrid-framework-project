package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

public class Level_23_FakerDataTest extends BaseTest {
	private WebDriver driver;
	private FakerConfig fakerConfig;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;

	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		fakerConfig = FakerConfig.getFaker();
		firstName = fakerConfig.getFirstName();
		lastName = fakerConfig.getLastName();
		emailAddress = fakerConfig.getEmailAddress();
		password = fakerConfig.getPassword();
	}

	@Test
	public void User_01_Register_Validate(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register_Validate");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify register link is Displayed");
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify error message at First name textbox");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify error message at Last name textbox");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

	}

	@Test
	public void User_02_Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Register_Success");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Enter First Name Textbox");
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter Last Name Textbox");
		registerPage.enterToLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter Email Textbox");
		registerPage.enterToEmailTextBox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter Password Textbox");
		registerPage.enterToPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextBox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Click to Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify success message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_03_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_03_Login");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to logo homepage");
		homePage = registerPage.clickToHomePageLogo();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter User/Password and click 'Login' button");
		homePage = loginPage.loginAsUser(emailAddress, password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Account Link");
		customerPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify User Info");
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), lastName);
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
