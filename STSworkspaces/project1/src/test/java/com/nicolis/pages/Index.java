package com.nicolis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {

	public WebDriver driver;

	@FindBy(id = "usern")
	public WebElement username;

	@FindBy(id = "pw")
	public WebElement password;

	@FindBy(id = "date1")
	public WebElement date1;

	@FindBy(id = "date2")
	public WebElement date2;

	@FindBy(id = "location")
	public WebElement location;

	@FindBy(id = "description")
	public WebElement description;

	@FindBy(id = "cost")
	public WebElement cost;

	@FindBy(id = "reason")
	public WebElement reason;

	@FindBy(id = "submitForm")
	public WebElement submitForm;

	public Index(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
