package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;

public class Level_14_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String image1 = "image_01.png";
	String image2 = "image_02.jpeg";
	String image3 = "image_03.jpeg";
	
	String[] fileNames = {image1, image2, image3};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	
	public void beforeClass(String browserName , String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManager.getUploadPage(driver);
	}

	public void TC_01_Upload_Single_File(){
		uploadPage.uploadMultipleFiles(driver, image1);
		uploadPage.sleepInSecond(2);
		uploadPage.uploadMultipleFiles(driver, image2);
		uploadPage.sleepInSecond(2);
		uploadPage.uploadMultipleFiles(driver, image3);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image1));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image2));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image3));
		
		uploadPage.clickStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image1));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image2));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image3));
	}

	public void TC_02_Upload_Multiple_File(){
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image1));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image2));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(image3));
		
		uploadPage.clickStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image1));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image2));
		Assert.assertTrue(uploadPage.isFileUpLoadedSuccess(image3));
	}
	@Test
	public void TC_03_Upload_Go_File(){
		uploadPage.openUrl(driver, "https://gofile.io/uploadFiles");
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
		
		Assert.assertTrue(uploadPage.isMultipleProgressBarDisappear());
		
		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
		
		uploadPage.clickToSuccessLink();
		
		Assert.assertTrue(uploadPage.isContentTableDisplayed());
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(image1));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(image2));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(image3));
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(image1));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(image2));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(image3));
		
	}
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
