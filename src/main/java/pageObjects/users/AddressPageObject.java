package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressPageObject extends SideBarMyAccountPageObject {
	private WebDriver driver;
	
	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
