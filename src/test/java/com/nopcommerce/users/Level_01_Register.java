package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Register_01_Empty_Data() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Emily");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ly");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("Emily@Ly@gmail");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {

		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Emily");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ly");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAdress());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password must meet the following rules:" + "\n" + "must have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Emily");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ly");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAdress());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123654");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Emily");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ly");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAdress());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailAdress() {
		Random rand = new Random();
		return "emily" + rand.nextInt(9999) + "@gmail.com";
	}
}
