package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Home_01_Element_Displayed() {
		homePage.clickToCreateNewAccountButton();
		verifyTrue(homePage.isFirstNameTextBoxDisplayed());
		verifyTrue(homePage.isSurNameTextBoxDisplayed());
		verifyTrue(homePage.isEmailTextBoxDisplayed());
		verifyTrue(homePage.isPasswordTextBoxDisplayed());
		
		homePage.enterToEmailTextbox("test123@gmail.com");
		log.info("Verify Confirm Email textbox is Displayed");
		verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
	}
	
	@Test
	public void User_02_Element_Displayed_In_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(2);
		log.info("Verify Confirm Email textbox is not Displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
		
	}
	
	@Test
	public void User_03_Element_Displayed_Not_In_HTML() {
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verify FirstName textbox is not Displayed");
		verifyFalse(homePage.isFirstNameTextBoxDisplayed());
		
		log.info("Verify Surname textbox is not Displayed");
		verifyFalse(homePage.isSurNameTextBoxDisplayed());
		
		log.info("Verify Email textbox is not Displayed");
		verifyFalse(homePage.isEmailTextBoxDisplayed());
		
		log.info("Verify Password textbox is not Displayed");
		verifyFalse(homePage.isPasswordTextBoxDisplayed());
	}
	
	@Test
	public void User_03_Element_Displayed_Not_In_HTML_02() {
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verify FirstName textbox is not Displayed");
		verifyTrue(homePage.isFirstNameTextBoxUndisplayed());
		
		log.info("Verify Surname textbox is not Displayed");
		verifyTrue(homePage.isSurNameTextBoxUndisplayed());
		
		log.info("Verify Email textbox is not Displayed");
		verifyTrue(homePage.isEmailTextBoxUndisplayed());
		
		log.info("Verify Password textbox is not Displayed");
		verifyTrue(homePage.isPasswordTextBoxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
