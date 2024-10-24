package com.orangehrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest {
	private WebDriver driver;
	private String browserName, employeeID, firstName, lastName;
	private String nickName, driverLicenseNumber, licenseExpiryDate, ssnNumber, sinNumber;
	private String dateOfBirth, genderStatus, smockerStatus, nationality, maritalStatus;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailsPageObject personalDetailsPage;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		firstName = "Michael";
		lastName = "Owen";
		nickName = "Golden Boy";
		driverLicenseNumber = "D08954796";
		licenseExpiryDate = "2023-01-03";
		ssnNumber = "428-79-4371";
		sinNumber = "968-563-231";
		dateOfBirth = "1986-10-10";
		genderStatus = "Male";
		smockerStatus = "Yes";
		nationality = "Vietnamese";
		maritalStatus = "Married";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGE_HRM_USERNAME);
		loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGE_HRM_PASSWORD);

		dashboardPage = loginPage.clickToLoginButton();
		employeeListPage = dashboardPage.openPIMModule();
	}

	@Test
	public void Employee_01_Add_New(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_01_Add_New");

		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		addEmployeePage.enterToFirstNameTextbox(firstName);
		addEmployeePage.enterToLastNameTextbox(lastName);
		employeeID = addEmployeePage.getEmployeeID();

		addEmployeePage.clickSaveButton();

		Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
		addEmployeePage.waitForSpinnerIconInvisible();

		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderPlayed());
		personalDetailsPage.waitForSpinnerIconInvisible();

		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
		Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

		employeeListPage = personalDetailsPage.clickEmployeeListButton();

		employeeListPage.enterToEmployeeIDTextbox(employeeID);
		employeeListPage.clickToSearchButton();

		employeeListPage.isValueDisplayedAtColumnName("Id", "1", employeeID);
		employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1", firstName);
		employeeListPage.isValueDisplayedAtColumnName("Last Name", "1", lastName);
	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_02_Personal_Details");

		personalDetailsPage = employeeListPage.clickToEditIconByEmployeeID(employeeID);
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderPlayed());

		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
		Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);

		//personalDetailsPage.enterToNicknameTextbox(nickName);
		personalDetailsPage.enterToDriverLicenseNumberTextbox(driverLicenseNumber);
		personalDetailsPage.enterToLicenseExpiryDatePicker(licenseExpiryDate);
//		personalDetailsPage.enterToSocialSecurityNumberTextbox(ssnNumber);
//		personalDetailsPage.enterToSocialInsuranceNumberTextbox(sinNumber);
//		personalDetailsPage.enterToNationalityDropdown(nationality);
		personalDetailsPage.enterToMaritalStatusDropdown(maritalStatus);
		personalDetailsPage.enterToDayOfBirthDatePicker(dateOfBirth);
		personalDetailsPage.clickToRadioButtonByLabelName(genderStatus);
//		personalDetailsPage.clickToCheckboxByLabelName(smockerStatus);
		personalDetailsPage.clickToSaveButtonAtPersonalDetailsPart();
		
		Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
		personalDetailsPage.waitForSpinnerIconInvisible();
		
//		Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), nationality);
		Assert.assertEquals(personalDetailsPage.getMaritalDropdownSelectedText(), maritalStatus);
		
		Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(genderStatus));
//		Assert.assertTrue(personalDetailsPage.isCheckboxSelectedByLabelName(smockerStatus));
	}

	@Test
	public void Employee_03_Contact_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_03_Contact_Details");
	}

	@Test
	public void Employee_04_Emergency_Contact(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_04_Emergency_Contact");
	}

	@Test
	public void Employee_05_Dependents(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_05_Dependents");
	}

	@Test
	public void Employee_06_Immigration(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_06_Immigration");
	}

	@Test
	public void Employee_07_Job(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_07_Job");
	}

	@Test
	public void Employee_08_Salary(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_08_Salary");
	}

	@Test
	public void Employee_09_Report(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(), "Employee_09_Report");
	}

	@Test
	public void Employee_09_Quanlification(Method method) {
		ExtentTestManager.startTest(method.getName() + "- Run on" + browserName.toUpperCase(),
				"Employee_09_Quanlification");
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
}
