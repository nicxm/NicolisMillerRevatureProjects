
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nicolis.pages.WikiMain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class);
@CucumberOptions(features = "src/test/resources")
public class WikiRunner {

	public static WebDriver driver;
	public static WikiMain wikiMain;
	
	@BeforeClass
	public static void setUp() {
		String path = "\"C:/Users/nicol/Documents/GitHub/NicolisMillerRevatureProjects/chromedriver_win32/chromedriver.exe\"";
		System.setProperty("webdriver.chrom.driver", path);
		
		driver = new ChromeDriver();
		wikiMain = new WikiMain(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}
