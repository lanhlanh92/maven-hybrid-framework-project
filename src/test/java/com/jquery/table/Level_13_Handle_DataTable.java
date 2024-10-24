package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_13_Handle_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	
	public void beforeClass(String browserName , String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	public void TC_01_Search() {
		//Search data on header
		homePage.inputToColumnTextboxByName("Females", "164548");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Males", "123456");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Country", "164548");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Total", "164548");
		homePage.sleepInSecond(2);
	}
	public void TC_02_Paging() {	
		homePage.clickToPageByNumber("3");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("3"));
		
		homePage.clickToPageByNumber("2");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("2"));
		
		homePage.clickToPageByNumber("4");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("4"));
		
		homePage.clickToPageByNumber("12");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("12"));
	}
	
	public void TC_03_Displayed() {
		
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187","Afghanistan","407124","791312"));
		
		Assert.assertTrue(homePage.isRowValuesDisplayed("12253515","AFRICA","12599691","24853148"));
		
	}
	
	public void TC_04_Icon_Button_Checkbox() {
		homePage.clickToRowActionByCountryName("Afghanistan","remove");
		homePage.clickToRowActionByCountryName("AFRICA","remove");
		homePage.clickToRowActionByCountryName("Albania","remove");
		
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Afghanistan","edit");
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Algeria","edit");
		homePage.refreshCurrentPage(driver);
		
	}
	public void TC_05_Get_All_Row_Values() {
		homePage.getAllPageValuesByColumnName("Country");
		homePage.getAllPageValuesByColumnName("Total");
	}
	
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","Emilly");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company","3","Emilly");
		
		homePage.selectDropdownByColumnNameAndRowIndex("Country","3","Germany");
		
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?","2");
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
