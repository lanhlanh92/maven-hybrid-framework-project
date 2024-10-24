//package com.nopcommerce.users;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.GlobalConstants;
//import commons.PageGeneratorManager;
//import pageObjects.users.HomePageObject;
//import pageObjects.users.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//@Test
//public class Level_17_Extent_V2 extends BaseTest {
//	private WebDriver driver;
//	private String emailAddress = getEmailAdress();
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	private String userUrl = GlobalConstants.DEV_USER_URL;
//	
//	@Parameters({"browser"})
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		
//		driver = getBrowserDriver(browserName, userUrl);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//	}
//
//	public void User_01_Register_Validate(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register_Validate");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify register link is Displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click to Register Link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Verify error message at First name textbox");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Verify error message at Last name textbox");
//		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
//		
//	}
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//		

//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Enter First Name Textbox");
//		registerPage = homePage.clickToRegisterLink();
//		registerPage.enterToFirstNameTextBox("Emily");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter Last Name Textbox");
//		registerPage.enterToLastNameTextBox("Ly");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter Email Textbox");
//		registerPage.enterToEmailTextBox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter Password Textbox");
//		registerPage.enterToPasswordTextBox("123456");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter Confirm Password Textbox");
//		registerPage.enterToConfirmPasswordTextBox("123456");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Click to Register Button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Verify success message ");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//		
//	}
//	
//	@AfterClass
//	public void afterClass() {
//		quitBrowserDriver();
//	}
//}
