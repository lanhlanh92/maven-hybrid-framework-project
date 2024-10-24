package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_31_Environment_01_Parameter_Name extends BaseTest {
	private WebDriver driver;
	@Parameters({ "browser", "server" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		driver = getBrowserEnvironment(browserName, serverName);
	}
	@Test
	public void User_01_Register_Validate(Method method) {
		
	}

	@Test
	public void User_02_Register_Success(Method method) {
	
	}

	@Test
	public void User_03_Login(Method method) {
		
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
