package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//*[@id='account-button']")
	WebElement accountIcon;
	
	@FindBy(xpath="//*[@id='signup_hover']/div[1]/div[1]/a[3]")
	WebElement SignIN;
	
	@FindBy(xpath ="//*[@id='login']/div[1]/label")
	WebElement email;
	
	@FindBy(xpath="//*[@id='login']/div[2]/label")
	WebElement password;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement LoginBtn;
	
	
	@FindBy(xpath = "//*[@id='create-account-submit']")
	WebElement signIN;
	
	
	@FindBy(xpath = "//*[@id='mininav']/button")
	WebElement logout;
	
	public void clickAccountIcon() throws InterruptedException {
		Thread.sleep(2000);
		//Instantiating Actions class
		Actions actions = new Actions(ldriver);
		actions.moveToElement(accountIcon).perform();
		Thread.sleep(2000);
		actions.click(SignIN).perform();
		Thread.sleep(20000);
		
	}
	
	
	public void enterEmail() throws InterruptedException
	{
		ldriver.switchTo().frame("sign-in-iframe");
		Thread.sleep(2000);
		
		WebElement wb = ldriver.findElement(By.xpath("//*[@id='login']/div[1]/label"));
		
		Actions action = new Actions(ldriver);
		action.sendKeys(wb, "mangroliahetal@gmail.com").build().perform();

	
		
	}
	
	public void enterPassword()
	{
		//password.clear();
		//password.sendKeys(pwd);
		
		WebElement wb1 = ldriver.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		Actions action1 = new Actions(ldriver);
		action1.sendKeys(wb1, "Kirtan27").build().perform();

	}
	

	public void clickOnLoginButton()
	{
		signIN.click();
	}
	
	
	
	
	public void clickOnLogOutButton() throws InterruptedException
	{
		ldriver.switchTo().defaultContent();
		Thread.sleep(20000);
		Actions action1 = new Actions(ldriver);
		action1.moveToElement(accountIcon).build().perform();
		Thread.sleep(2000);
		action1.click(logout).perform();
		
		//logout.click();
	}
}
