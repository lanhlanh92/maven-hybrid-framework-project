package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import utilities.EnvironmentConfig;

public class Level_31_Environment_04_Owner extends BaseTest {
	WebDriver driver;
	private EnvironmentConfig environmentConfig;
	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String serverName = System.getProperty("env");
		ConfigFactory.setProperty("server", serverName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		System.out.println(environmentConfig.appUrl());
		System.out.println(environmentConfig.appUserName());
		System.out.println(environmentConfig.appPassword());
		driver = getBrowserDriver(browserName, environmentConfig.appUrl());
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
