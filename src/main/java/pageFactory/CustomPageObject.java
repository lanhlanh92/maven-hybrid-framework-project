package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomPageObject extends BasePageFactory{
	
	WebDriver driver;
	
	public CustomPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//UI
	
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(css = "input#login")
	WebElement loginButton;
	
	// Action
	
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, firstNameTextbox );
		return getElementAtribute(driver, firstNameTextbox, "value");
		
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextbox);
		return getElementAtribute(driver, lastNameTextbox, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAtribute(driver, emailTextbox, "value");
	}
	
}
