package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	
	public static CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
		
	}
	
	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
		
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
		
	}
	
	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);	
	}
	
	public static AdminDashBoardPageObject getAdminDashBoardPageObject(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);	
	}
}
