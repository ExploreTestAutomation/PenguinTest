package StepDefinition;
import java.awt.AWTException;	
import java.io.*;    
import java.net.*;
import java.util.List;
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
	}
	
	@And("User click on account-icon")
	public void user_hover_account_icon_button() throws InterruptedException {
		loginPg.clickAccountIcon();
	  
	}
	

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) throws InterruptedException {
		
		loginPg.enterEmail();
		loginPg.enterPassword();
	 
	}

	@And("User click on SignIN")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLoginButton();
	}


	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	//WebElement actualTitle1 = 	driver.findElement(By.xpath(""));
	
	String actualTitle = driver.getTitle();
	
//	String abc = actualTitle1.getTitle();
	
	String expectedTitle1 ="Penguin Random House";
		//String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle1))
		{
			

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail


		}
	}

	
	@When("User click on LogOut link")
	public void user_click_on_log_out() throws InterruptedException {
		loginPg.clickOnLogOutButton();
	}

	

//@Then("verify broken url")
public void verify_broken_url() {
	
	// driver.get("http://www.applicoinc.com");

     // Get all the links URL
     List<WebElement> ele = driver.findElements(By.tagName("a"));
     System.out.println("size:" + ele.size());
     boolean isValid = false;
     for (int i = 0; i < ele.size(); i++) {

         isValid = getResponseCode(ele.get(i).getAttribute("href"));
         if (isValid) {
             System.out.println("ValidLinks:" + ele.get(i).getAttribute("href"));
             driver.get(ele.get(i).getAttribute("href"));
             List<WebElement> ele1 = driver.findElements(By.tagName("a"));
             System.out.println("InsideSize:" + ele1.size());
             for (int j=0; j<ele1.size(); j++){
                 isValid = getResponseCode(ele.get(j).getAttribute("href"));
                 if (isValid) {
                     System.out.println("ValidLinks:" + ele.get(j).getAttribute("href"));
                 }
                 else{
                     System.out.println("InvalidLinks:"+ ele.get(j).getAttribute("href"));
                 }
             }

             } else {
                 System.out.println("InvalidLinks:"
                         + ele.get(i).getAttribute("href"));
             }

         }
     
    
     } 


	
	
	/*@Then("close browser")
	public void close_browser() {
		driver.close();
		

		//driver.quit();
	}

*/
	// login 
	

	

	

	


	



	
	
	

	
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
