package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_06_Page_Generator_03 extends BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private AdminLoginPageObject adminLoginPage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;


	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl ) {
		//driver = getBrowserDriver(browserName);
		
		//User
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Admin
//		driver = getBrowserDriver(browserName, adminUrl);
//		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	}

	public void Register_01_Empty_Data() {
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	public void Register_02_Invalid_Email() {
		homePage = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox("Emily@Ly@gmail");
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();
		
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
		homePage = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox("Emily");
		registerPage.enterToLastNameTextBox("Ly");
		registerPage.enterToEmailTextBox(getEmailAdress());
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	public void Register_05_Success() {
		homePage = registerPage.clickToHomePageLogo();
		
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
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
