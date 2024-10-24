package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Test
public class Level_09_Switch_Site_Url extends BaseTest {
	private WebDriver driver;
	private String emailAddress = getEmailAdress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	private CustomerPageObject customerPage;
	
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashboardPage;
	
	private String userUrl, adminUrl;
	
	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl ) {
		
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
	}

	public void User_01_Register() {
		
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
	
	public void User_02_Switch_Url() {
		// Logout
		homePage = customerPage.clickToUserLogoutLink(driver);
		
		homePage.openUrl(driver, adminUrl);
		
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");
		
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		
		adminLoginPage = adminDashboardPage.clickToAdminLogoutLink(driver);
		
		adminLoginPage.openUrl(driver, userUrl);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
