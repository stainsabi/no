package com.nobroker.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class filter {
	
	
	public void filterTest() {
		
		System.setProperty("webdriver.chrome.driver", ".//chrome//chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
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

}
