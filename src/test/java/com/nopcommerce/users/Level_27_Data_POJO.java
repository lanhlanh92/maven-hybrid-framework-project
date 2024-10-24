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
import testdata.pojoData.nopcommerce.UserInfo;

public class Level_27_Data_POJO extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private UserInfo userInfo;

	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String browserName;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName ) {
		this.browserName = browserName;
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		userInfo = UserInfo.getUser();
		
		userInfo.setEmailAddress(getEmailAddress("john"));
		userInfo.setFirstName("John");
		userInfo.setLastName("Kennedy");
		userInfo.setPassword("123456");
	}

	@Test
	public void User_01_Register_Validate(Method method) {
		ExtentTestManager.startTest(method.getName() + "Run on" + browserName.toUpperCase(), "User_01_Register_Validate");

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

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter To Register From");
		registerPage.setToRegisterForm(userInfo);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify success message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_03_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_03_Login");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to logo homepage");
		homePage = registerPage.clickToHomePageLogo();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Login to application");
		homePage = loginPage.loginToApp(userInfo);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Account Link");
		customerPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify User Info");
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), userInfo.getFirstName());
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), userInfo.getLastName());
		Assert.assertEquals(customerPage.getEmailAttributeValue(), userInfo.getEmailAddress());

	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
