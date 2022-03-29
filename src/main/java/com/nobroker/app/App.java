package com.nobroker.app;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class App 
{
	//Checking the behaviour of login
	public static void login() {
		System.setProperty("webdriver.chrome.driver", ".//chrome//chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	     driver.get("https://www.nobroker.in/");
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     List<WebElement> login= driver.findElements(By.xpath("//div[@class='nb__19hcF']"));
	     for (WebElement log : login) 
	     { 
	         if("Log In".equals(log.getText())) {
	        	 log.click();
	        	 break;
	         }
	     }
	     driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9606236150");
	     driver.findElement(By.xpath("//input[@value='password']")).click();
	     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Abi9946101965");
	     driver.findElement(By.id("signUpSubmit")).click();
	     String message = driver.findElement(By.xpath("//div[@id='alertMessageBox']")).getText();
	     System.out.println(message);
	     Assert.assertEquals("Signed in Successfully", message);
	     driver.quit();
	}
	
	//Checking the behaviour of Search 
	
	public static void search() throws InterruptedException {
System.setProperty("webdriver.chrome.driver", ".\\chrome\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
	    driver.get("https://www.nobroker.in/");
	   
	    WebElement dropdown=driver.findElement(By.xpath("//div[contains(@class,'_value-container--has-value')]"));
	    dropdown.click();
	   
	   
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	    List<WebElement> list= driver.findElements(By.xpath("//div[contains(@id,'react-select-2-option-')]"));
	    for(WebElement li : list) {
	    	
	    	if("Pune".equals(li.getText())) {
	    		li.click();
	    		break;
	    	}
	    }
	   
	    driver.findElement(By.id("listPageSearchLocality")).click();
	    driver.findElement(By.id("listPageSearchLocality")).sendKeys("Pune Ci");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    List<WebElement> suggestion= driver.findElements(By.xpath("//div[@class='suggestion-item']"));
	    for(WebElement suggest : suggestion) {
	    	if(suggest.getText().contains("Pune City"));
	    	{
	    		suggest.click();
	    		break;
	    	}
	    }
	    Thread.sleep(5000L);
	    driver.findElement(By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']")).click();
	    String place = driver.findElement(By.xpath("//h1[@class='heading-5 whitespace-nowrap overflow-ellipsis overflow-hidden nb__1K1jy']")).getText();
	    
	    if(place.contains("Pune City")) {
	    	assertTrue( true );
	    	System.out.println("Test Passed");
	    }
	    else {
	    	assertTrue( false );
	    	System.out.println("Test Failed");
	    }
	    
	    
		driver.quit();
		
	}
	
	//Checking the behaviour filter
	
	public static void filter() {
		System.setProperty("webdriver.chrome.driver", ".//chrome//chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.nobroker.in/property/rent/bangalore/Mathikere?searchParam=W3sibGF0IjoxMy4wMzM0MTk0LCJsb24iOjc3LjU2Mzk3NjA5OTk5OTk5LCJwbGFjZUlkIjoiQ2hJSmR3STV1TjhYcmpzUmNheUFzUVYyWGk4IiwicGxhY2VOYW1lIjoiTWF0aGlrZXJlIn1d&radius=2.0&sharedAccomodation=0&city=bangalore&locality=Mathikere");
	    String before=driver.findElement(By.xpath("//*[@id='listPageContainer']/div[1]/div[2]/div[2]/div/div[1]/div[2]")).getText();
	    WebElement sourceEle = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
	    Actions actionProvider = new Actions(driver);
	    actionProvider.clickAndHold(sourceEle).build().perform();
	    actionProvider.moveByOffset(-150, 0).build().perform();
	    actionProvider.release().build().perform();
	    String after=driver.findElement(By.xpath("//*[@id='listPageContainer']/div[1]/div[2]/div[2]/div/div[1]/div[2]")).getText();
		System.out.println(before);
		System.out.println(after);
		if(before!=after) {
			assertTrue( true );
			System.out.println("test passed");
		}
		driver.quit();
		
	}
    
	
	public static void main( String[] args ) throws InterruptedException
    {
    
		System.out.println("Running test for login");
		login();
		System.out.println("Running test for Search functionality");
		search();
		System.out.println("Running test for Filter");
		
		filter();
    }
}
