package com.nicolis.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPlayground {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/nicol/Documents/GitHub/NicolisMillerRevatureProjects/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("http://www.google.com/");

		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("OSRS wiki");

		WebElement searchBtn = driver.findElement(By.name("btnK"));
		searchBtn.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
