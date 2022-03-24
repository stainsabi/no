package com.nobroker.app;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	@Test
	public void  logInTest() {
		System.setProperty("webdriver.chrome.driver", "");
	
		WebDriver driver= new ChromeDriver();
	     driver.get("https://www.nobroker.in/");
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Stains123456789");
	     driver.findElement(By.id("signUpSubmit")).click();
	     String message = driver.findElement(By.xpath("//div[@id='alertMessageBox']")).getText();
	     System.out.println(message);
	     Assert.assertEquals("Signed in Successfully", message);
		
	}

}
