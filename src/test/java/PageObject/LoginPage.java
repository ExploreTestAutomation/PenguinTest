package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//*[@id='account-button']/img")
	WebElement accountIcon;
	
	@FindBy(xpath ="//*[@id='login']/div[1]/label")
	WebElement email;
	
	@FindBy(xpath="//*[@id='login']/div[2]/label")
	WebElement password;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement LoginBtn;
	
	
	@FindBy(xpath = "//*[@id='create-account-submit']")
	WebElement signIN;
	
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void clickAccountIcon() {
		
		accountIcon.click();
	}
	
	
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnLogOutButton()
	{
		logout.click();
	}
}
