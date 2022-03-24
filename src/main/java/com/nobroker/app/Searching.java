package com.nobroker.app;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searching {
	
	public void search() {
		System.setProperty("webdriver.chrome.driver", ".\\chrome\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
	    driver.get("https://www.nobroker.in/");
	    WebElement dropdown=driver.findElement(By.xpath("//div[contains(@class,'_value-container--has-value')]"));
	    dropdown.click();
	   
	   
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    List<WebElement> list= driver.findElements(By.xpath("//div[@class='css-q4imyt nb-select__menu-list']//div[@class='css-mdf5j6-option nb-select__option']"));
	    for(WebElement li : list) {
	    	if("Bangalore".equals(li.getText())) {
	    		li.click();
	    		break;
	    	}
	    }
	   
	    driver.findElement(By.id("listPageSearchLocality")).click();
	    driver.findElement(By.id("listPageSearchLocality")).sendKeys("White");
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    List<WebElement> suggestion= driver.findElements(By.xpath("//div[@class='suggestion-item']"));
	    for(WebElement suggest : suggestion) {
	    	if(suggest.getText().contains("Whitefield"));
	    	{
	    		suggest.click();
	    		break;
	    	}
	    }
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']")).click();
	    
		
	}

}
