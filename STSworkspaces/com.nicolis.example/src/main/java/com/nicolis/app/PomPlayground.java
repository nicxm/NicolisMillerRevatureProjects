package com.nicolis.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PomPlayground {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/nicol/Documents/GitHub/NicolisMillerRevatureProjects/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WikiMain wikiMain = new WikiMain(driver);

		String url = "http://www.wikipedia.org/";
		driver.get(url);

		wikiMain.english.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}
