package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDef {
	
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage SearchCustPg;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
	 
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail


		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	// login 
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
	   
		
		  String actualTitle = addNewCustPg.getPageTitle(); 
		  String expectedTitle = "Dashboard / nopCommerce administration";
		  
		  if(actualTitle.equals(expectedTitle)) {
		  
		  Assert.assertTrue(true);
		  
		  } else { Assert.assertTrue(false);
		  
		  
		  }
		
		
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			

			Assert.assertTrue(true);//pass
		}
		else
		{
		

			Assert.assertTrue(false);//fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterEmail("cs129@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			

		}
		else
		{
		

			Assert.assertTrue(false);//fail

		}

	}
	
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( SearchCustPg.searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			

		}
		else {
			
			Assert.assertTrue(false);

		}
	}
}
