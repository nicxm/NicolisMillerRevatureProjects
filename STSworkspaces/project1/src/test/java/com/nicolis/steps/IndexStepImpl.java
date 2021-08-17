package com.nicolis.steps;

import org.openqa.selenium.WebDriver;

import com.nicolis.pages.Index;
import com.nicolis.runners.IndexRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndexStepImpl {

	public static Index index = IndexRunner.index;
	public static WebDriver driver = IndexRunner.driver;

	@Given("The Employee is on the Index")
	public void the_employee_is_on_the_index() {
	}

	@When("Enters their username")
	public void enters_their_username() {
	}

	@When("Enters their password")
	public void enters_their_password() {
	}

	@When("Clicks login")
	public void clicks_login() {
	}

	@Then("They should be logged in")
	public void they_should_be_logged_in() {
	}

	@Given("The Employee is on the Index and is logged in")
	public void the_employee_is_on_the_index_and_is_logged_in() {
	}

	@When("They enter their date start")
	public void they_enter_their_date_start() {
	}

	@When("They enter their date end")
	public void they_enter_their_date_end() {
	}

	@When("They enter their location")
	public void they_enter_their_location() {
	}

	@When("They enter their description")
	public void they_enter_their_description() {
	}

	@When("They enter their cost")
	public void they_enter_their_cost() {
	}

	@When("They enter their reason")
	public void they_enter_their_reason() {
	}

	@When("Clicks Submit Tution Form")
	public void clicks_submit_tution_form() {
	}

	@Then("The Form should submit")
	public void the_form_should_submit() {
	}

}
