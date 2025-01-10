package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestUtils;

public class AddVehiclePage {

	WebDriver driver;
	private TestUtils utils;

	private By regoNumberInputField = By.cssSelector("[name='regoNumber']");
	private By regoNumberFieldValidationMessage = By.cssSelector("[id=':r0:-form-item-message']");
	private By selectStateButton = By.xpath("//button[contains(.,'NSW')]");
	private By selectStateDropdown = By.cssSelector(
			".flex.h-full.w-full.flex-col.overflow-hidden.rounded-md.border.border-silver.bg-popover.text-popover-foreground");
	private By optionsList = By.cssSelector("[role='option']");
	private By regoLookUpButton = By.xpath("//button[.='Rego Lookup']");
	private By regoSearchAttempts = By.xpath("//div[normalize-space()='5/5 Search Attempts']");
	
	private By makeButton = By.xpath("//label[.='Make*']/following-sibling::button");
	private By modelButton = By.xpath("//label[.='Model*']/following-sibling::button");
	private By yearButton = By.xpath("//label[.='Year*']/following-sibling::button");
	
	

	public AddVehiclePage(WebDriver driver) {
		this.driver = driver;
		utils = new TestUtils(driver);
	}

	public AddVehiclePage fillRegoNuber(String value) {
		utils.fillInput(regoNumberInputField, value);
		return this;
	}

	public String getRegoNumberValidationMessage() {
		return utils.waitForElement(regoNumberFieldValidationMessage).getText();
	}

	public boolean isRegoNumberValidationMessageDisplay() {
		return utils.waitForElement(regoNumberFieldValidationMessage).isDisplayed();
	}

	public AddVehiclePage selectState(String value) {
		utils.clickOn(selectStateButton);
		if (utils.waitForElement(selectStateDropdown).isDisplayed()) {
			List<WebElement> options = driver.findElements(optionsList);
			for (WebElement webElement : options) {
				if (webElement.getText().equalsIgnoreCase(value)) {
					webElement.click();
					break;
				}
			}
		}
		return this;
	}

	public AddVehiclePage clickRegoLookUpButton() {
		utils.clickOn(regoLookUpButton);
		return this;
	}

}
