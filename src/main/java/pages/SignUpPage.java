package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class SignUpPage {

	private WebDriver driver;
	private TestUtils testUtils;
	private By firstNameInputField = By.cssSelector("input[name='first_name']");
	private By lastNameInputField = By.cssSelector("input[name='last_name']");
	private By emailInputField = By.cssSelector("input[name='email']");
	private By phoneNumberInputField = By.cssSelector("input[name='phone_number']");
	private By passwordInputField = By.cssSelector("input[name='password']");
	private By signUpButton = By.xpath("//button[.='Get Started Free']");
	private By loginLink = By.xpath("//span[.=' Login']");
	private By firstNameValidationMessage = By.cssSelector("p[id=':r0:-form-item-message']");
	private By lastNameValidationMessage = By.cssSelector("p[id=':r1:-form-item-message']");
	private By emailValidationMessage = By.cssSelector("p[id=':r2:-form-item-message']");
	private By phoneNumberFieldValidationMessage = By.cssSelector("p[id=':r3:-form-item-message']");
	private By passwordValidationMessage = By.cssSelector("p[id=':r4:-form-item-message']");
	private By workshopNameInputField = By.cssSelector("input[name='workshop_name']");
	private By workshopNameValidationMessage = By.cssSelector("p[id=':r3:-form-item-message']");
	private By invoiceOPtionsButton = By.cssSelector("button[role='combobox']");
	private By invoiceOptions = By.cssSelector("option");
	private By invoiceOptionValidationMessage = By.xpath("//p[@id=':r5:-form-item-message'][contains(.,'program')]");

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		testUtils = new TestUtils(driver);
	}

	public SignUpPage fillFirstName(String value) {
		testUtils.fillInput(firstNameInputField, value);
		return this;
	}

	public String extractFirstNameValidationMessageText() {
		return testUtils.waitForElement(firstNameValidationMessage).getText();
	}

	public SignUpPage fillLastName(String value) {
		testUtils.fillInput(lastNameInputField, value);
		return this;
	}

	public String extractLastNameValidationMessage() {
		return testUtils.waitForElement(lastNameValidationMessage).getText();
	}

	public SignUpPage fillEmail(String value) {
		testUtils.fillInput(emailInputField, value);
		return this;
	}

	public String extractEmailValidationMessageText() {
		return testUtils.waitForElement(emailValidationMessage).getText();
	}

	public SignUpPage fillPhoneNumber(String value) {
		testUtils.fillInput(phoneNumberInputField, value);
		return this;
	}

	public String extractPhoneNumberValidationMessageText() {
		return testUtils.waitForElement(phoneNumberFieldValidationMessage).getText();
	}

	public SignUpPage fillPassword(String value) {
		testUtils.fillInput(passwordInputField, value);
		return this;
	}

	public String extractPasswordValidationMessage() {
		return testUtils.waitForElement(passwordValidationMessage).getText();
	}

	public SignUpPage fillWorkshopName(String value) {
		testUtils.fillInput(workshopNameInputField, value);
		return new SignUpPage(driver);
	}

	public String getWorkshopNameValidationMessage() {
		return testUtils.waitForElement(workshopNameValidationMessage).getText();
	}

	public String getInvoiceOptionValidationMessage() {
		return testUtils.waitForElement(invoiceOptionValidationMessage).getText();
	}

	public SignUpPage selectInvoiceOption(String value) throws InterruptedException {
		clickInvoiceOption();
		testUtils.selectValueFromDropdown(invoiceOptions, value);
		return this;
	}

	public SignUpPage clickInvoiceOption() {
		testUtils.clickOn(invoiceOPtionsButton);
		return this;
	}

	public SignUpPage clickSignUpButton() {
		testUtils.clickOn(signUpButton);
		return this;
	}

	public LoginPage clickLoginLink() {
		testUtils.clickOn(loginLink);
		return new LoginPage(driver);
	}

}
