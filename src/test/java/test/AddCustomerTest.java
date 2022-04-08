package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;

	String username;
	String password;
	String fullName;
	String companyName;
	String email;
	String phone;
	String address;
	String city;
	String state;
	String zip;
	String country;

	//@Test
	@Parameters({ "UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State",
			"Zip", "Country" })
	public void validUserShouldBeAbleToCreateCustomer(String username, String password, String fullName,
			String companyName, String email, String phone, String address, String city, String state, String zip,
			String country) {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertStateRegion(state);
		addCustomerPage.insertZipPostalCode(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyContactsPage();
		addCustomerPage.verifyProfilePage();
		dashboardPage.clicklistCustomerMenuButton();

		addCustomerPage.verifyEnteredNameAndDelete();

		// div[3]/descendant::a[1]

//		BrowserFactory.tearDown();

	}

	@Test
	@Parameters({ "UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State",
			"Zip", "Country" })
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String username, String password, String fullName,
			String companyName, String email, String phone, String address, String city, String state, String zip,
			String country) {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clicklistCustomerMenuButton();
		dashboardPage.verifyListCustomerContactsPage();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.addCustomerOnListCustomer();
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertStateRegion(state);
		addCustomerPage.insertZipPostalCode(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyContactsPage();
		addCustomerPage.verifyProfilePage();
		dashboardPage.clicklistCustomerMenuButton();
		
		addCustomerPage.insertSearchBarOnListCustomer();
		
		addCustomerPage.verifyEnteredNameOnSearchAndProfile();

//		BrowserFactory.tearDown();

	}

}
