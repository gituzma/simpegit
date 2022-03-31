package com.git.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GTest {
  
  
	private WebDriver driver;

	@BeforeMethod(groups = "sanity,regression")
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\siddi\\Browser\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

	}

	@AfterMethod(groups = "sanity,regression")
	public void cleanup() {
		driver.manage().deleteAllCookies();
		driver.close();

	}
	

	@Test
	public void testSignInLink() throws InterruptedException {

		String title = driver.getTitle();// get the title
		System.out.println("page title is: " + title);
		System.out.println("The current Url of the Webpage is:" + driver.getCurrentUrl());

		WebElement linkSignin = driver.findElement(By.linkText("Sign in"));
		linkSignin.click();
		Thread.sleep(2000);
		System.out.println("The sign in page is   " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.com%2F&ec=GAZAmgQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		Actions action = new Actions(driver);
		
		
		action.moveToElement(driver.findElement(By.linkText("Create account"))).build().perform();
		/*
		 * WebElement create= driver.findElement(By.linkText("Create account"));
		 * create.click();
		 */
		Thread.sleep(3000);
		

		
	}
	
}
