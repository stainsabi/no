package com.nobroker.app;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    login Login=new login();
    filter Filter=new filter();
     Searching search=new Searching();
   		Login.logInTest();
   		Filter.filterTest();
   		search.search();
     
    }
}
