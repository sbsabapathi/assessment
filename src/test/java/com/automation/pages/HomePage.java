
package com.automation.pages;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.utils.CommonMethods;
import com.automation.utils.PropertyReader;

public class HomePage extends BasePage {

	@FindBy(id = "firstname")
	WebElement firstNameInput;

	@FindBy(id = "lastname")
	WebElement lastNameInput;

	@FindBy(id = "totalprice")
	WebElement priceInput;

	@FindBy(id = "depositpaid")
	WebElement depositPaidDropdown;

	@FindBy(id = "checkin")
	WebElement checkInDateInput;

	@FindBy(id = "checkout")
	WebElement checkoutDateInput;

	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@id='bookings']/div/div[1]")
	List<WebElement> firstNameList;

	String firstNameValue;

	final String FIRST_NAME_XPATH = "//div[@id='bookings']/div/div[1]/p[text()='%s']";
	
	final String DELETE_BTN_XPATH = "//div[@id='bookings']/div/div[1]/p[text()='%s']/../..//input[@value='Delete']";

	public void openWebsite() {
		// Loading url in the browser
		driver.get(PropertyReader.getProperty("application.url"));
	}

	public void enterFirstName(String firstName) {
		 if(!firstName.isBlank() || !firstName.isEmpty()){
			 Random random = new Random();
			 firstNameValue = firstName + random.nextInt(10000);
		 }else {
			 firstNameValue = "";
		 }
		firstNameInput.sendKeys(firstNameValue);
	}

	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void enterPrice(String price) {
		priceInput.sendKeys(price);
	}

	public void selectDeposit(String deposit) {
		Select depositDropdownSelect = new Select(depositPaidDropdown);
		depositDropdownSelect.selectByVisibleText(deposit);
	}

	public void enterCheckInDate(String checkInDate) {
		checkInDateInput.sendKeys(checkInDate);
	}

	public void enterCheckoutDate(String checkOutDate) {
		checkoutDateInput.sendKeys(checkOutDate);
	}

	public void clickSaveBtn() {
		CommonMethods.waitForElementToBeClickable(saveBtn, driver);
		saveBtn.click();
	}

	public void verifyRecordSavedSuccessfully() {

		String firstNameLoc = String.format(FIRST_NAME_XPATH, firstNameValue);
		boolean isRecordExist = false, recordStatus = false;

		recordStatus = CommonMethods.waitForElementToBeVisible(firstNameLoc, driver, 60);

		for (WebElement webElement : firstNameList) {
			if (webElement.getText().equals(firstNameValue)) {
				isRecordExist = true;
				break;
			}
		}
		Assert.assertTrue("Record is not saved", isRecordExist && recordStatus);
	}

	public void verifyRecordNotDisplayed() {
		boolean isRecordExist = false;
		String firstNameLoc = String.format(FIRST_NAME_XPATH, firstNameValue);
		CommonMethods.waitForElementToBeVisible(firstNameLoc, driver, 10);

		for (WebElement webElement : firstNameList) {
			if (webElement.getText().equals(firstNameValue)) {
				isRecordExist = true;
				break;
			}
		}

		Assert.assertFalse("Record is still visible on page", isRecordExist);
	}

	public void clickOnDelete() {
		String deleteBtnLoc = String.format(DELETE_BTN_XPATH, firstNameValue);
		driver.findElement(By.xpath(deleteBtnLoc)).click();
		CommonMethods.waitForElementNotVisible(deleteBtnLoc, driver, 60);
	}

}
