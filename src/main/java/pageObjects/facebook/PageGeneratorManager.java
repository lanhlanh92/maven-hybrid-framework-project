package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	public void clickToCreateNewAccountButton() {
		// TODO Auto-generated method stub
		
	}
}
