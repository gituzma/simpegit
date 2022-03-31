package com.git.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub






			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\siddi\\Browser\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://www.google.com");
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Java book");
		Thread.sleep(2000);

		
		  WebElement searchBtn=driver.findElement(By.name("btnK"));
		  searchBtn.click(); Thread.sleep(2000);
		  
		driver.close();
		 

	}
	
	
}
