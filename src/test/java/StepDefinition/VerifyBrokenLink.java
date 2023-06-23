package StepDefinition;

import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utitlities.ReadConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyBrokenLink extends BaseClass {
	

	@And("verify broken url")
	public void user_click_on_log_out() throws InterruptedException {
        String homePage = "https://www.toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get(homePage);
        
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        
        //Traversing through the list and printing its text along with link address
        for(WebElement link:allLinks){
        System.out.println(link.getText() + " - " + link.getAttribute("href"));
        System.out.println(link.getAttribute("href"));
        
        }
        
        
        
        
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
               System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                    
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		
		
		System.out.println("test");
		
		

	}
	
}


