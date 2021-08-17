import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.nicolis.pages.WikiMain;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikiLangStepImpl {

	public static WikiMain wikiMain = WikiRunner.wikiMain;
	public static WebDriver driver = WikiRunner.driver;

	@Given("^The Guest is on the Wikipedia Home Page$")
	public void the_Guest_is_on_the_Wikipedia_Home_Page() throws Throwable {
		driver.get("http://www.wikipedia.org/");
	}

	@When("^The Guest clicks English$")
	public void the_Guest_clicks_English() throws Throwable {
		wikiMain.english.click();
	}

	@Then("^The Guest should be on the English Home Page$")
	public void the_Guest_should_be_on_the_English_Home_Page() throws Throwable {
		assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());

	}

}
