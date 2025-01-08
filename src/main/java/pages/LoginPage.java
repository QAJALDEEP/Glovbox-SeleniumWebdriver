package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class LoginPage {

	private final WebDriver driver;
	private final TestUtils testUtils;
	private final By loginButton = By.xpath("//button[contains(text(),'Login')]");
	private final By emailField = By.cssSelector("input[name='email']");
	private final By passwordField = By.cssSelector("input[name='password']");
	private final By emailValidationMessage = By.cssSelector("p[id=':r3:-form-item-message']");
	private final By passwordValidationMessage = By.cssSelector("p[id=':r4:-form-item-message']");
	private final By userSwitch = By.xpath("//button[.='User']");
	private final By workshopSwitch = By.xpath("//button[.='Workshop']");
	private final By signUpLink = By.xpath("//span[.='Sign up now']");
	private final By termsOfServiceLink = By.cssSelector("a[href='/terms-of-service']");
	private final By globalPrivacyStatementLink = By.cssSelector("a[href='/privacy-statement']");
	private final By forgotPasswordLink = By.xpath("//button[.='Forgot your password?']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		testUtils = new TestUtils(driver);
	}

	public LoginPage fillEmail(String value) {
		testUtils.fillInput(emailField, value);
		return this;
	}

	public LoginPage fillPassword(String value) {
		testUtils.fillInput(passwordField, value);
		return this;
	}

	public LoginPage clickLoginButton() {
		testUtils.clickOn(loginButton);
		return this;
	}

	public MyVehiclePage doLogin(String emailValue, String passwordValue) {
		fillEmail(emailValue).fillPassword(passwordValue).clickLoginButton();
		return new MyVehiclePage(driver);
	}

	public boolean isEmailValidation() {
		boolean result = testUtils.waitForElement(emailValidationMessage).isDisplayed();
		return result;
	}

	public boolean isPasswordValidation() {
		boolean result = testUtils.waitForElement(passwordValidationMessage).isDisplayed();
		return result;
	}

	public String getEmailValidationMessage() {
		return testUtils.waitForElement(emailValidationMessage).getText();
	}

	public ForgotPasswordPage clickForgotPasswordLink() {
		testUtils.clickOn(forgotPasswordLink);
		return new ForgotPasswordPage(driver);
	}

}