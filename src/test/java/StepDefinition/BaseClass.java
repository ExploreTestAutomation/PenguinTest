package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utitlities.ReadConfig;

import java.io.*;    
import java.net.*;
/*Parent Class*/
public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage SearchCustPg;
	public ReadConfig readConfig;
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
	public static boolean getResponseCode(String urlString) {
		
		
		
		
        boolean isValid = false;
        try {
            URL u = new URL(urlString);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.connect();
            System.out.println(h.getResponseCode());
            if (h.getResponseCode() != 404) {
                isValid = true;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

	

}
