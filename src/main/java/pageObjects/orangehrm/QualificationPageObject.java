package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class QualificationPageObject  extends BaseActions{
	private WebDriver driver;
	
	public QualificationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
