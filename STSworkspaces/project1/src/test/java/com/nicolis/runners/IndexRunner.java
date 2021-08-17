package com.nicolis.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nicolis.pages.Index;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.nicolis.steps")
public class IndexRunner {

	public static WebDriver driver;
	public static Index index;

	@BeforeClass
	public static void setUp() {
		String path = "C:\\Users\\nicol\\Documents\\GitHub\\NicolisMillerRevatureProjects\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		index = new Index(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
