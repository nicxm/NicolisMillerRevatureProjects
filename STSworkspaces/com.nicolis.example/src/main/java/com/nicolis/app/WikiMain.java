package com.nicolis.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMain {

	public WebDriver driver;

	@FindBy(id = "js-link-box-en")
	public WebElement english;

	public WikiMain(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

}
