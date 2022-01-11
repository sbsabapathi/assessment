package com.automation.steps;

import com.automation.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	HomePage homePage = new HomePage();

	@Given("user is on website")
	public void user_is_on_website() {
		homePage.openWebsite();
	}

	@When("user enters first name with prefix {string}")
	public void user_enters_first_name_with_prefix(String firstName) {
		homePage.enterFirstName(firstName);
	}

	@When("user enters last name {string}")
	public void user_enters_last_name(String lastName) {
		homePage.enterLastName(lastName);
	}

	@When("user enters price {string}")
	public void user_enters_price(String price) {
		homePage.enterPrice(price);
	}

	@When("select deposit {string}")
	public void select_deposit(String deposit) {
		homePage.selectDeposit(deposit);
	}

	@When("enter check in date {string}")
	public void enter_check_in_date(String checkInDate) {
		homePage.enterCheckInDate(checkInDate);
	}

	@When("enter checko out date {string}")
	public void enter_checko_out_date(String checkOutDate) {
		homePage.enterCheckoutDate(checkOutDate);
	}

	@When("click on save button")
	public void click_on_save_button() {
		homePage.clickSaveBtn();
	}

	@Then("verify saved record is displayed on page")
	public void verify_saved_record_is_displayed_on_page() {
		homePage.verifyRecordSavedSuccessfully();
	}

	@When("verify record is not displayed on page")
	public void verify_record_is_not_displayed_on_page() {
		homePage.verifyRecordNotDisplayed();
	}

	@When("user click on delete for newly added record")
	public void clickOnDelete() {
		homePage.clickOnDelete();
	}

}
