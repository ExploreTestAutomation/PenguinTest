package StepDefinition;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utitlities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class StepDef extends BaseClass {
	@Before
	public void setup() {
		
	readConfig = new ReadConfig();
		
		//initialise logger
		

		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
           
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
		
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException, AWTException {
		 Thread.sleep(1000);
		driver.get(url);
	    Thread.sleep(1000);
	 
	    WebElement mainMenu = driver.findElement(By.xpath("//*[@id='account-button']"));
	    WebElement mainMenu2 = driver.findElement(By.xpath("//*[@id='signup_hover']/div[1]/div[1]/a[3]"));

		//Instantiating Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu).perform();
		Thread.sleep(2000);
		actions.click(mainMenu2).perform();
		
		Thread.sleep(20000);
		
		
	   driver.switchTo().frame("sign-in-iframe");
		Thread.sleep(2000);
		System.out.println("Frame Source" +driver.getPageSource());
	   // driver.findElement(By.xpath("//*[@id='signup_hover']/div[1]/div[1]/a[3]")).click();
		//loginPg.clickOnLoginButton();
		Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		

	
	   	
			WebElement wb = driver.findElement(By.xpath("//*[@id='login']/div[1]/label"));		
			Actions action = new Actions(driver);
			action.sendKeys(wb, "mangroliahetal@gmail").build().perform();

			WebElement wb1 = driver.findElement(By.xpath("//*[@id='login']/div[2]/label"));
			Actions action1 = new Actions(driver);
			action1.sendKeys(wb1, "Kirtan27").build().perform();
			
			//*[@id="login"]/div[2]/label
			//JavascriptExecutor jse = ((JavascriptExecutor)driver);          
			//WebElement email = driver.findElement(By.id("useremail"));

			//jse.executeScript("arguments[0].value='mangroliahetal@gmail'", wb);
	      // act.sendKeys(Keys.RETURN).build().perform();
		
		
		
		
		
	
		
		
		
		
		
		
		//driver.findElement(By.xpath("//*[@id='login']/div[1]/label")).sendKeys("mangroliahetal@gmail");
		
	  //  driver.findElement(By.xpath("//*[@id='login']/div[1]/label")).sendKeys("mangroliahetal@gmail");
	   // driver.findElement(By.xpath("//*[@id='login']/div[2]/label")).sendKeys("Kirtan27");
	    
	}
	
	@Then("User hover account-icon button")
	public void user_hover_account_icon_button() {
		
		
	//WebElement element=	driver.findElement(By.xpath("//*[@id='account-button']/img"));
		
		
	//	waitabc(accountIcon);
		//loginPg.clickAccountIcon();
	  
	}
	
	@When("Click on Login")
	public void click_on_login() {
		//loginPg.clickOnLoginButton();
	}
	

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
	 
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

	@When("User click on account-icon")
	public void user_click_on_account_icon() {
	   
	}

	
	
	
	
	
	
	/*@Then("close browser")
	public void close_browser() {
		driver.close();
		

		//driver.quit();
	}

*/
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
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		//addNewCustPg.enterEmail("cs129@gmail.com");
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
	
	
	//@After
	public void teardown2(Scenario sc)
	{
	
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\Aarti\\eclipse-workspace_4_Penguien\\penguinrandomhouse\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//driver.quit();
	}
	
	
	//@AfterStep
	public void addScreeshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			final byte[] sceenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sceenshot, "image/png", scenario.getName());
			
		}
		
	}
	
	
	
	
	
	
	
}
